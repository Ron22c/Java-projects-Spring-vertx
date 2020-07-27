package shop;

public class MainClass {
    public static void main(String args[]) {
        Door d = new Door();
        d.shopStatus();
        d.getLock().setLock(false);
        d.shopStatus();

        DoorOne d1 = new DoorOne();
        System.out.println(d1.isLocked("test"));
    }
}