package Fibonacci;

import java.util.Scanner;

import static Fibonacci.CalcFibonacci.verificaFib;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe um número: ");
        int num = scanner.nextInt();
        scanner.close();

        if (verificaFib(num)){
            System.out.println("O numero "+ num + " pertence a sequencia" );
        }else{
            System.out.println("O numero "+ num + " não pertence a sequencia" );
        }
    }

}
