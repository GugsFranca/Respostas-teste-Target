package FaturamentoDiario;

import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FaturamentoDiario {
    public static void main(String[] args) {
        String caminho = "src/main/java/FaturamentoDiario/faturamento.json";

        try {
            String caminhoJson = Files.readString(Paths.get(caminho));
            JSONObject jsonObject = new JSONObject(caminhoJson);
            JSONArray faturamentoArray = jsonObject.getJSONArray("faturamento");

            double menorValor = Double.MAX_VALUE;
            double maiorValor = Double.MIN_VALUE;
            double soma = 0;
            int diasContados = 0;

            for (int i = 0; i < faturamentoArray.length(); i++) {
                JSONObject item = faturamentoArray.getJSONObject(i);
                double valor = item.getDouble("valor");

                if (valor > 0) {
                    menorValor = Math.min(menorValor, valor);
                    maiorValor = Math.max(maiorValor, valor);
                    soma += valor;
                    diasContados++;
                }
            }

            double media = soma / diasContados;

            int diasAcimaMedia = 0;
            for (int i = 0; i < faturamentoArray.length(); i++) {
                double valor = faturamentoArray.getJSONObject(i).getDouble("valor");
                if (valor > media) {
                    diasAcimaMedia++;
                }
            }

            System.out.printf("Menor valor de faturamento: R$ %.2f%n", menorValor);
            System.out.printf("Maior valor de faturamento: R$ %.2f%n", maiorValor);
            System.out.println("Número de dias com faturamento superior à média: " + diasAcimaMedia);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

}
