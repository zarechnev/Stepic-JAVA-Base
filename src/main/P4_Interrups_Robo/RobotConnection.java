package P4_Interrups_Robo;

public interface RobotConnection extends AutoCloseable {
    void moveRobotTo(int x, int y);
    @Override
    void close();
}
