package Animals;

public class Bird extends Animal{
    private boolean hasFeather;
    private boolean canFly;

    public Bird() {
        super();
    }

    public Bird(int height, int weight, String animalType, String bloodType, boolean hasFeather, boolean canFly) {
        super(height, weight, animalType, bloodType);
        this.hasFeather = hasFeather;
        this.canFly = canFly;
    }

    public boolean isHasFeather() {
        return hasFeather;
    }

    public boolean isCanFly() {
        return canFly;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "hasFeather=" + hasFeather +
                ", canFly=" + canFly +
                '}';
    }
    public void showInfo() {
        this.toString();
    }

}
