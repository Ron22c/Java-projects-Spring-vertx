package Animals;

public class Animal {
    protected int height;
    protected int weight;
    protected String animalType;
    protected String bloodType;

    public Animal(int height, int weight,String animalType,String bloodType) {
        this.height=height;
        this.weight=weight;
        this.animalType=animalType;
        this.bloodType=bloodType;
    }

    public Animal() {
        this.height=0;
        this.weight=0;
        this.animalType=null;
        this.bloodType=null;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public String getAnimalType() {
        return animalType;
    }

    public String getBloodType() {
        return bloodType;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "height=" + height +
                ", weight=" + weight +
                ", animalType='" + animalType + '\'' +
                ", bloodType='" + bloodType + '\'' +
                '}';
    }

    public void showInfo() {
        this.toString();
    }
}
