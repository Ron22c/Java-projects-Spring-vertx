package inheritance;

public class Vehicle {

    private String engine;
    private int fueltank;
    private int seat;
    private int wheels;
    private String lights;

    public Vehicle(String engine, int fueltank, int seat, int wheels, String lights) {
        this.engine = engine;
        this.fueltank = fueltank;
        this.seat = seat;
        this.wheels = wheels;
        this.lights = lights;
    }

    public Vehicle() {
        this.engine="petrol";
        this.fueltank=1;
        this.lights="led";
        this.seat=4;
        this.wheels=4;
    }

    public String getEngine() {
        return engine;
    }

    public int getFueltank() {
        return fueltank;
    }

    public int getSeat() {
        return seat;
    }

    public int getWheels() {
        return wheels;
    }

    public String getLights() {
        return lights;
    }
}
