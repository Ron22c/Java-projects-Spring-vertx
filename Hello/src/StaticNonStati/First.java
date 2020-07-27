package StaticNonStati;

public class First {
    public int hello = 23;
    public static int hel;
    public void orin() {
        System.out.println(hel);
        Second s = new Second();
        System.out.println(s.a);
    }
    public static void h() {
        System.out.println(hel);

    }
}
