public class fib {
    public static int count = 0;

    public static int fib2(int no) {
        count++;
        if (no == 1 || no == 0) {

            return no;
        }
        return fib2(no - 1) + fib2(no - 2);

    }

    public static void iterative_fib(int no) {
        int a = 0;
        int b = 1;
        System.out.print(a + "->");
        System.out.print(b);
        for (int i = 2; i <= no; i++) {
            int temp = a + b;
            a = b;
            b = temp;
            System.out.print("->" + temp);
        }
    }

    public static void main(String[] args) {

        System.out.println("Recursive Fibonacci of 5: " + fib2(5));
        System.out.println("Recursive calls count: " + count);
        System.out.print("Iterative Fibonacci sequence up to 5: ");
        iterative_fib(5);
    }
}