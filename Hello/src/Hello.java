public class Hello {
    public static void main(String arr[]) {
        System.out.println(2+3+"hello"+2+3);
        int max = -987654321;
        long l = 3245465L;
        double d = 1.01234567891234562;

//        int a=22;
        float b=12.4f%3;

//        double value = a*a + 2*a*b + b*b;

        System.out.println(d);

        int age = 45;
        String gender = "girl";

        if((gender=="boy" && age>=21) || (gender=="girl" && age>=18)) {
            System.out.println("legal age to get married");
        } else {
            System.out.println("not legal age to get married");
        }

        int a=3;
        a=a++;
        System.out.println("Post-Increment a: " +a);

        a=++a;
        System.out.println("Pre-Increment a: "+a );

        a=a--;
        System.out.println("Post-Decrement a: " +a);

        a=--a;
        System.out.println("Pre-Decrement a: "+a );



        System.out.println(sumOfDig(233));
        stars();

        int hexa = 0x123;
        System.out.println(hexa);
        int bin = 0b10;
        System.out.println(bin);
        int octa = 010;
        System.out.println(octa);

        String Key = "hello";
        int valu = Integer.valueOf(Key);
        System.out.println(valu);

    }

    public void switchCase() {
        int x = 32;
        switch(x) {
            case 1:
                System.out.println(1);
                break;
            case 2:
                System.out.println(2);
                break;
            case 3:
                System.out.println(3);
                break;
            case 4:
                System.out.println(4);
                break;
            default:
                System.out.println(5);
                break;
        }
    }

    public static String isPrint(int num) {
        for(int i=2; i<num/2;i++) {
            if(num % i == 0) {
                return "NOT PRIME";
            }
        }
        return "PRIMe";
    }

    public static void stars() {
        for(int i=0; i<5;i++) {
            for(int j=0;j<=i;j++) {
                System.out.print("@");
            }
            System.out.println();
        }
    }

    public static int sumOfDig(int digit) {
        int output = 0;
        int length = (int)Math.log10(digit)+1;
        for(int i=0;i<length;i++) {
            int val = (int) ((digit/Math.pow(10, i))%10);
            output=output+val;
        }
        return output;
    }
}
