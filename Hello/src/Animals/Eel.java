package Animals;

public class Eel extends Fish {
    protected boolean electricCharge;

    public Eel(int height, int weight, String animalType, String bloodType, boolean livesInWater, boolean hasGills, boolean electricCharge) {
        super(height, weight, animalType, bloodType, livesInWater, hasGills);
        this.electricCharge = electricCharge;
    }

    public Eel() {
        this.electricCharge = true;
    }

    public boolean isElectricCharge() {
        return electricCharge;
    }

    @Override
    public String toString() {
        return "Eel{" +
                "electricCharge=" + electricCharge +
                '}';
    }

    public void showInfo() {
        this.toString();
    }
}
