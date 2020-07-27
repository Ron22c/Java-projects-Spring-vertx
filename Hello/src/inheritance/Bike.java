package inheritance;

public class Bike extends Vehicle{
    private String handel;

    public Bike() {
        this.handel="short";
    }

    public Bike(String handel,String engine, int fueltank, int seat, int wheels, String lights) {
        super(engine, fueltank, seat, wheels, lights);
        this.handel = handel;
    }

    public String getHandel() {
        return handel;
    }
}
