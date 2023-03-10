package io.confluent.developer.adventure;

public class MovementCommand {
  private final Direction direction;

  public MovementCommand(Direction direction) {
    this.direction = direction;
  }

  public Direction getDirection() {
    return this.direction;
  };

  enum Direction {
    LOOK, NORTH, SOUTH, EAST, WEST
  }
}
