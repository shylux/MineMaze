package ch.shylux.java;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import net.minecraft.src.Block;
import net.minecraft.src.EnumGameType;

import org.apache.commons.io.FileUtils;

import ch.shylux.java.minecraft.JMWorldEdit;
import ch.shylux.java.minecraft.generators.WorldGeneratorGiza;

public class MCExperiments {

  public static void main(String[] args) throws IOException {
    String world = "/Users/lukas/Library/Application Support/minecraft/saves";
    //world = "C:/Users/Shylux/AppData/Roaming/.minecraft/saves";
    FileUtils.deleteDirectory(new File(world+"/world"));
    try (JMWorldEdit edit = new JMWorldEdit(world, 40, new WorldGeneratorGiza())) {

      edit.world.getWorldInfo().setSpawnPosition(0, 200, 0);
      edit.world.getWorldInfo().setGameType(EnumGameType.CREATIVE);
      edit.world.setAllowedSpawnTypes(true, true);
      
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  public void generateGauss3D(JMWorldEdit edit) {
    Random r = new Random();
    int distribution = 20;
    for (int i = 0; i < 10000; i++) {
      int x = (int) (r.nextGaussian() * distribution);
      int z = (int) (r.nextGaussian() * distribution);
      for (int iy = 51; iy < 200; iy++) {
        if (edit.world.getBlockId(x, iy, z) == 0) {
          edit.world.setBlock(x, iy, z, Block.stainedClay.blockID);
          break;
        }
      }
    }
  }

}
