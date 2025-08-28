import Model.myNumber;

public class TestNumber {
    public static void main(String[] args) {
        myNumber n1 = new myNumber();
        myNumber n2 = new myNumber();

        n1.i = 2;
        n2.i = 5;

        n1 = n2;
        n2.i = 10;
        System.out.println(n2.i); // 10

        n1.i = 20;
        System.out.println(n1.i); // 20
    }
}
