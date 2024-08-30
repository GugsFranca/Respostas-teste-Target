import java.util.Scanner;

public class StringInvertida {
    public static void main(String[] args) {

        System.out.print("Entre com o nome: ");

        Scanner scanner = new Scanner(System.in);
        String entrada = scanner.nextLine();
        scanner.close();

        StringBuilder saida = new StringBuilder();
        for (int i = entrada.length() - 1; i >= 0; i--) {

            saida.append(entrada.charAt(i));
        }
        System.out.println(saida);
    }
}
