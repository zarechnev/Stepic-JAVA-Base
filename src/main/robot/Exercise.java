package robot;

import java.util.Random;

public class Exercise {
    public static void main(String[] args) {
        Robot robot = new Robot();
        Random rnd = new Random();

        int x = rnd.nextInt(100) -50;
        int y = rnd.nextInt(100) -50;

        System.out.println(String.format("Robo new in point [%d; %d]", robot.getX(), robot.getY()));
        System.out.println(String.format("Robo have to go to point [%d; %d]", x, y));

        Exercise.moveRobot(robot, x, y);
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        // Доходим до требуемой точки по X
        while (robot.getX() != toX){
            if (robot.getX() > toX){
                // Любым образом (turnLeft() или turnRight()) поворачиваем Робо в лево
                while (robot.getDirection() != Robot.Direction.LEFT){ robot.turnLeft(); }
                robot.stepForward();
            } else {
                // Любым образом (turnLeft() или turnRight()) поворачиваем Робо в право
                while (robot.getDirection() != Robot.Direction.RIGHT){ robot.turnLeft(); }
                robot.stepForward();
            }
        }

        // Доходим до требуемой точки по Y
        while (robot.getY() != toY){
            if (robot.getY() > toY){
                // Любым образом (turnLeft() или turnRight()) поворачиваем Робо в низ
                while (robot.getDirection() != Robot.Direction.DOWN){ robot.turnLeft(); }
                robot.stepForward();
            } else {
                // Любым образом (turnLeft() или turnRight()) поворачиваем Робо в верх
                while (robot.getDirection() != Robot.Direction.UP){ robot.turnLeft(); }
                robot.stepForward();
            }
        }
    }
}
