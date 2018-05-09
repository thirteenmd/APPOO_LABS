package dpriciple;

public class RacingCar implements Vehicle {
    private final int maxFuel;
    private int remainingFuel;
    private int power;

    public RacingCar(int maxFuel) {
        this.maxFuel = maxFuel;
        this.remainingFuel = maxFuel;
    }

    public void accelerate() {
        power++;
        remainingFuel--;
    }
}
