package computer;

public class MainClass {
    public static void main(String args[]) {

        Computer c = new Computer();
        System.out.println(c);
        c.getGraphicCard().setMemory(1234);
        System.out.println(c);

    }
}
