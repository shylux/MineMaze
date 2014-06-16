package ch.shylux.java.maze;

import java.util.List;

import ch.shylux.java.maze.Maze2D.Direction;

public class Node {
  Maze2D ctx;

  int x;
  int y;

  public Node(Maze2D context, int x, int y) {
    this.ctx = context;
    this.x = x;
    this.y = y;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Node) {
      Node other = (Node) obj;
      return (x == other.x && y == other.y);
    }
    return false;
  }

  @Override
  public String toString() {
    return String.format("[%d,%d]", x, y);
  }

  public boolean isExitNode() {
    return ctx.isExitNode(this);
  }

  public List<Node> getNeighbours() {
    return ctx.getNeighbours(this);
  }

  public void setWall(Direction d, boolean on) {
    ctx.setWall(this, d, on);
  }
  public void digWall(Direction d) {
    ctx.digWall(this, d);
  }
  public boolean hasWall(Direction d) {
    return ctx.hasWall(this, d);
  }

  public void setVisited(boolean isVisited) {
    ctx.setVisited(this, isVisited);
  }
  public boolean isVisited() {
    return ctx.isVisited(this);
  }

  public boolean isPassable(Direction d) {
    return ctx.isPassable(this, d);
  }

  public boolean inMaze() {
    return !ctx.out(this);
  }

  public int check(int mask) {
    return ctx.checkNode(this, mask);
  }
}
