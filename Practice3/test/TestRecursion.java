public class TestRecursion {
    public static void main(String[] args) {
        Recursion r = new Recursion();

        System.out.println("Factorial(5) = " + r.factorial(5));
        System.out.println("Fibonacci(7) = " + r.fibonacci(7));
        System.out.println("Sum(1..10) = " + r.sumToN(10));
    }
}
