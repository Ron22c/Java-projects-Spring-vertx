package AbstractAnonyomus;

public abstract class Lock {
    public abstract boolean isLocked(String key);
    public void test() {
        System.out.println("Test");
    }
}
