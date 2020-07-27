package AbstractAnonyomus;

public class MainClass {
    public static void main(String args[]) {
        Door door = new Door();
        System.out.println(door.isLocked(args[0]));

    }
}
