package Animals;

public class Reptile extends Animal {
    protected boolean drySkin;
    protected boolean backbone;
    protected boolean eggType;

    public Reptile() {
        this.drySkin = false;
        this.backbone = false;
        this.eggType = true;

    }

    public Reptile(int height, int weight, String animalType, String bloodType, boolean drySkin, boolean backbone, boolean eggType) {
        super(height, weight, animalType, bloodType);
        this.drySkin = drySkin;
        this.backbone = backbone;
        this.eggType = eggType;
    }

    public boolean isDrySkin() {
        return drySkin;
    }

    public boolean isBackbone() {
        return backbone;
    }

    public boolean isEggType() {
        return eggType;
    }

    @Override
    public String toString() {
        return "Reptile{" +
                "drySkin=" + drySkin +
                ", backbone=" + backbone +
                ", eggType=" + eggType +
                '}';
    }

    public void showInfo() {
        this.toString();
    }
}
