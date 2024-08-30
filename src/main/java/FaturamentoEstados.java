public class FaturamentoEstados {
    public static void main(String[] args) {

        String[] estados = {"SP", "RJ", "MG", "ES", "Outros"};
        double[] faturamento = {67836.43, 36678.66, 29229.88, 27165.48, 19849.53};

        double total = 0;
        for (double faturamentos : faturamento) {
            total += faturamentos;
        }

        for (int i = 0; i < estados.length; i++) {
            double percentual = (faturamento[i] / total) * 100;
            System.out.printf("%s: %.2f%%\n", estados[i], percentual);
        }

    }

}
