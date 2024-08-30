package Fibonacci;

public class CalcFibonacci {
    public static boolean verificaFib(int num) {
        int a = 0, b = 1;

        if (num == 0 || num == 1) return true;

        while (b <= num) {
            if (b == num) {
                return true;
            }
            int calc = a + b;
            a = b;
            b = calc;
        }
        return false;
    }
}
