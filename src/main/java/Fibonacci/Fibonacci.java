package Fibonacci;

import java.util.Scanner;

import static Fibonacci.CalcFibonacci.verificaFib;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe um número: ");
        int num = scanner.nextInt();
        scanner.close();

        if (verificaFib(num)){
            System.out.println("O número "+ num + " pertence a sequência" );
        }else{
            System.out.println("O número "+ num + " não pertence a sequência" );
        }
    }

}
