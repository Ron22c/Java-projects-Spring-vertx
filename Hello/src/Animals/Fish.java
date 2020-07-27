package Animals;

public class Fish extends Animal{
    protected boolean livesInWater;
    protected boolean hasGills;

    public Fish(int height, int weight, String animalType, String bloodType, boolean livesInWater, boolean hasGills) {
        super(height, weight, animalType, bloodType);
        this.livesInWater = livesInWater;
        this.hasGills = hasGills;
    }

    public Fish(){
        this.livesInWater = true;
        this.hasGills = true;
    }

    public boolean isLivesInWater() {
        return livesInWater;
    }

    public boolean isHasGills() {
        return hasGills;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "livesInWater=" + livesInWater +
                ", hasGills=" + hasGills +
                '}';
    }

    public void showInfo() {
        this.toString();
    }
}
