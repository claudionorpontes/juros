import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MegaSena {

    private static final int NUMEROS_SORTEADOS = 6;
    private static final int NUMEROS_POSSIVEIS = 60;

    public static void main(String[] args) {
    	
        // Gerar uma lista de todos os números possíveis
    	
        List<Integer> numerosPossiveis = new ArrayList<>();
        for (int i = 1; i <= NUMEROS_POSSIVEIS; i++) {
            numerosPossiveis.add(i);
        }

        // Gerar uma lista de números sorteados
        
        List<Integer> numerosSorteados = new ArrayList<>();
        for (int i = 0; i < NUMEROS_SORTEADOS; i++) {
            int numeroSorteado = numerosPossiveis.remove(new Random().nextInt(numerosPossiveis.size()));
            numerosSorteados.add(numeroSorteado);
        }

        // Imprimir os números sorteados
        
        System.out.println("Números sorteados: " + numerosSorteados);

        // Calcular as probabilidades de acertar todos os números
        
        float probabilidadeAcertarTodos = 1 / (numerosPossiveis.size() * NUMEROS_SORTEADOS);
        System.out.println("Probabilidade de acertar todos os números: " + probabilidadeAcertarTodos);

        // Calcular as probabilidades de acertar 5 números
        
        float probabilidadeAcertarCinco = numerosPossiveis.size() / (numerosPossiveis.size() * (NUMEROS_SORTEADOS - 1));
        System.out.println("Probabilidade de acertar 5 números: " + probabilidadeAcertarCinco);

        // Calcular as probabilidades de acertar 4 números
        
        float probabilidadeAcertarQuatro = (numerosPossiveis.size() * (numerosPossiveis.size() - 1)) / (numerosPossiveis.size() * (NUMEROS_SORTEADOS - 2));
        System.out.println("Probabilidade de acertar 4 números: " + probabilidadeAcertarQuatro);

        // Calcular as probabilidades de acertar 3 números
        
        float probabilidadeAcertarTres = (numerosPossiveis.size() * (numerosPossiveis.size() - 1) * (numerosPossiveis.size() - 2)) / (numerosPossiveis.size() * (NUMEROS_SORTEADOS - 3));
        System.out.println("Probabilidade de acertar 3 números: " + probabilidadeAcertarTres);

        // Calcular as probabilidades de acertar 2 números
        
        float probabilidadeAcertarDois = (numerosPossiveis.size() * (numerosPossiveis.size() - 1) * (numerosPossiveis.size() - 2) * (numerosPossiveis.size() - 3)) / (numerosPossiveis.size() * (NUMEROS_SORTEADOS - 4));
        System.out.println("Probabilidade de acertar 2 números: " + probabilidadeAcertarDois);

        // Gerar uma lista de números sugeridos
        
        List<Integer> numerosSugeridos = new ArrayList<>();
        for (int i = 0; i < NUMEROS_SORTEADOS; i++) {
            int numeroSugerido = numerosPossiveis.remove(new Random().nextInt(numerosPossiveis.size()));
            numerosSugeridos.add(numeroSugerido);
        }

        // Imprimir os números sugeridos
        
        System.out.println("Números sugeridos: " + numerosSugeridos);
    }
}
