package loteria;

import java.util.Arrays;
import java.util.List;

public class Probabilidade {

    private static final int NUMEROS_POSSIVEIS = 60;
    private static final int NUMEROS_SORTEADOS = 6;

    public static void main(String[] args) {

        // Calcula o número total de combinações possíveis
        int combinacoesPossiveis = calcularCombinacoes(NUMEROS_POSSIVEIS, NUMEROS_SORTEADOS);

        // Calcula a probabilidade de acertar a sena
        double probabilidadeSena = 1 / combinacoesPossiveis;

        // Calcula a probabilidade de acertar a quina
        double probabilidadeQuina = calcularProbabilidade(NUMEROS_SORTEADOS, 5);

        // Calcula a probabilidade de acertar a quadra
        double probabilidadeQuadra = calcularProbabilidade(NUMEROS_SORTEADOS, 4);

        System.out.println("Probabilidade de acertar a sena: " + probabilidadeSena);
        System.out.println("Probabilidade de acertar a quina: " + probabilidadeQuina);
        System.out.println("Probabilidade de acertar a quadra: " + probabilidadeQuadra);
    }

    private static int calcularCombinacoes(int n, int k) {
        return (int) (factorial(n) / (factorial(k) * factorial(n - k)));
    }

    private static long factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    private static double calcularProbabilidade(int n, int k) {
        return 1.0 * calcularCombinacoes(n, k) / calcularCombinacoes(n, n - k);
    }
}
