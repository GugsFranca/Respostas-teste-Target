package FaturamentoDiario;

import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FaturamentoDiario {
    public static void main(String[] args) {
        String caminho = "src/main/java/FaturamentoDiario/dados.json";

        try {
            String caminhoJson = Files.readString(Paths.get(caminho));
            JSONArray jsonArray = new JSONArray(caminhoJson);

            double menorValor = Double.MAX_VALUE;
            double maiorValor = Double.MIN_VALUE;
            double soma = 0;

            int diasContados = 0;
            int diaMenorValor = 0;
            int diaMaiorValor = 0;

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject item = jsonArray.getJSONObject(i);

                double valor = item.getDouble("valor");
                int dia = item.getInt("dia");


                if (valor > 0) {
                    if (valor < menorValor) {
                        menorValor = valor;
                        diaMenorValor = dia;
                    }
                    if (valor > maiorValor) {
                        maiorValor = valor;
                        diaMaiorValor = dia;
                    }
                    soma += valor;
                    diasContados++;
                }
            }

            double media = soma / diasContados;

            int diasAcimaMedia = 0;
            for (int i = 0; i < jsonArray.length(); i++) {
                double valor = jsonArray.getJSONObject(i).getDouble("valor");
                if (valor > media) {
                    diasAcimaMedia++;
                }
            }

            System.out.printf("Menor valor de faturamento: R$ %.2f no dia %d%n", menorValor, diaMenorValor);
            System.out.printf("Maior valor de faturamento: R$ %.2f no dia %d%n", maiorValor, diaMaiorValor);
            System.out.println("Número de dias com faturamento superior à média: " + diasAcimaMedia);

        } catch (Exception e) {
            System.out.println("Erro ao processar o arquivo Json: " + e.getMessage());
        }


    }

}
