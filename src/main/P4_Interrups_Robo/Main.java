package P4_Interrups_Robo;

public class Main {
    public static void main(String[] args) {
        moveRobot(() -> null, 0, 0);
    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        for (int i = 0; i < 3; i++) {
            RobotConnection connection = null;
            try {
                connection = robotConnectionManager.getConnection();
                connection.moveRobotTo(toX, toY);
                return;
            }
            catch (RobotConnectionException e) { }
            catch (Exception e) { throw e; }
            finally {
                try { connection.close(); }
                catch (Exception e) { }
            }
        }
        throw new RobotConnectionException("");
    }
}
