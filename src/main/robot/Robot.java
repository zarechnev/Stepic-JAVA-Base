package robot;

import java.util.Random;

public class Robot {

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    private Direction direction;
    private int x;
    private int y;

    public Robot(Direction direction, int a, int b) {
        this.direction = direction;

        this.x = a;
        this.y = b;
    }

    public Robot(int a, int b) {
        this(Direction.UP, a, b);
    }

    public Robot() {
        this(Direction.UP, new Random().nextInt(100) - 50, new Random().nextInt(100) - 50);
    }

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void turnLeft() {
        switch (getDirection()) {
            default:
            case DOWN:
                direction = Direction.LEFT;
                break;
            case UP:
                direction = Direction.LEFT;
                break;
            case RIGHT:
                direction = Direction.UP;
                break;
            case LEFT:
                direction = Direction.DOWN;
        }
    }

    public void turnRight() {
        switch (getDirection()) {
            default:
            case DOWN:
                direction = Direction.RIGHT;
                break;
            case UP:
                direction = Direction.LEFT;
                break;
            case RIGHT:
                direction = Direction.DOWN;
                break;
            case LEFT:
                direction = Direction.UP;
        }
    }

    public void stepForward() {
        switch (getDirection()) {
            default:
            case RIGHT:
                x++;
                break;
            case LEFT:
                x--;
                break;
            case UP:
                y++;
                break;
            case DOWN:
                y--;
                break;
        }
    }
}