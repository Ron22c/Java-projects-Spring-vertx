package Animals;

public class Crocodile extends Reptile{

    public Crocodile(int height, int weight, String animalType, String bloodType, boolean drySkin, boolean backbone, boolean eggType) {
        super(height, weight, animalType, bloodType, drySkin, backbone, eggType);
    }

    public Crocodile(){
        eggType=false;
    }


}
