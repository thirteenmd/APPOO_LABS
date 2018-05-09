package olprinciples;

public class Sport implements DrivingMode{
    private static final int POWER = 500;
    private static final int SUSPENSION_HEIGHT = 10;

    public int getPower() {
        return POWER;
    }

    public int getSuspensionHeight() {
        return SUSPENSION_HEIGHT;
    }
}
