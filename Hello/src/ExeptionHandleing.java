public class ExeptionHandleing {

    public static void main(String[] args) {
        System.out.println("exp");
        try {
            new ExeptionHandleing().th();
        } catch (Exp exp) {
            exp.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void th() throws Exp {
        throw new Exp();
    }
}


class Exp extends Throwable {
    Exp() {
        System.out.println("this is a exp");
    }
}