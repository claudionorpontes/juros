package loteria;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MegaVirada {

    // Os números mais sorteados da Mega-Sena, segundo o site [1]
	
    public static final int[] MAIS_SORTEADOS = {10, 5, 53, 4, 23, 54, 33, 24, 51, 17};

    // Os números menos sorteados da Mega-Sena, segundo o site [1]
    
    public static final int[] MENOS_SORTEADOS = {26, 55, 22, 21, 9, 15, 25, 60, 14, 19};

    // O número total de combinações possíveis de 6 números de 1 a 60
    
    public static final long TOTAL_COMBINACOES = combinacao(60, 6);

    // O número de combinações possíveis de 6 números mais sorteados
    
    public static final long COMBINACOES_MAIS_SORTEADOS = combinacao(10, 6);

    // O número de combinações possíveis de 6 números menos sorteados
    
    public static final long COMBINACOES_MENOS_SORTEADOS = combinacao(10, 6);

    // O número de combinações possíveis de 6 números que contêm pelo menos um dos mais sorteados
    
    public static final long COMBINACOES_COM_MAIS_SORTEADOS = combinacao(50, 5) * 10 + COMBINACOES_MAIS_SORTEADOS;

    // O número de combinações possíveis de 6 números que contêm pelo menos um dos menos sorteados
    
    public static final long COMBINACOES_COM_MENOS_SORTEADOS = combinacao(50, 5) * 10 + COMBINACOES_MENOS_SORTEADOS;

    // O número de combinações possíveis de 6 números que não contêm nenhum dos mais sorteados
    
    public static final long COMBINACOES_SEM_MAIS_SORTEADOS = combinacao(50, 6);

    // O número de combinações possíveis de 6 números que não contêm nenhum dos menos sorteados
    
    public static final long COMBINACOES_SEM_MENOS_SORTEADOS = combinacao(50, 6);

    // Calcula o fatorial de um número
    
    public static long fatorial(int n) {
        long f = 1;
        for (int i = 2; i <= n; i++) {
            f *= i;
        }
        return f;
    }

    // Calcula o número de combinações de n elementos tomados p a p
    
    public static long combinacao(int n, int p) {
        return fatorial(n) / (fatorial(p) * fatorial(n - p));
    }

    // Calcula a probabilidade de acertar a sena com uma combinação de 6 números
    
    public static double probabilidadeSena(int[] numeros) {
    	
        // Verifica se os números são válidos
    	
        if (numeros == null || numeros.length != 6) {
            throw new IllegalArgumentException("A combinação deve ter 6 números");
        }
        for (int n : numeros) {
            if (n < 1 || n > 60) {
                throw new IllegalArgumentException("Os números devem estar entre 1 e 60");
            }
        }

        // Cria um mapa para contar a frequência de cada número
        
        Map<Integer, Integer> frequencia = new HashMap<>();
        for (int n : numeros) {
            frequencia.put(n, frequencia.getOrDefault(n, 0) + 1);
        }

        // Verifica se há números repetidos
        
        if (frequencia.size() != 6) {
            throw new IllegalArgumentException("Os números não podem se repetir");
        }

        // Calcula a probabilidade de acertar a sena
        // A probabilidade é igual ao inverso do número total de combinações
        
        return 1.0 / TOTAL_COMBINACOES;
    }

    // Calcula a probabilidade de acertar a sena com uma combinação de 6 números mais sorteados
    
    public static double probabilidadeSenaMaisSorteados() {
    	
        // A probabilidade é igual ao número de combinações de 6 números mais sorteados
        // dividido pelo número total de combinações
    	
        return (double) COMBINACOES_MAIS_SORTEADOS / TOTAL_COMBINACOES;
    }

    // Calcula a probabilidade de acertar a sena com uma combinação de 6 números menos sorteados
    
    public static double probabilidadeSenaMenosSorteados() {
    	
        // A probabilidade é igual ao número de combinações de 6 números menos sorteados
        // dividido pelo número total de combinações
    	
        return (double) COMBINACOES_MENOS_SORTEADOS / TOTAL_COMBINACOES;
    }

    // Calcula a probabilidade de acertar a sena com uma combinação de 6 números que contêm pelo menos um dos mais sorteados
    
    public static double probabilidadeSenaComMaisSorteados() {
    	
        // A probabilidade é igual ao número de combinações de 6 números que contêm pelo menos um dos mais sorteados
        // dividido pelo número total de combinações
    	
        return (double) COMBINACOES_COM_MAIS_SORTEADOS / TOTAL_COMBINACOES;
    }

    // Calcula a probabilidade de acertar a sena com uma combinação de 6 números que contêm pelo menos um dos menos sorteados
    
    public static double probabilidadeSenaComMenosSorteados() {
    	
        // A probabilidade é igual ao número de combinações de 6 números que contêm pelo menos um dos menos sorteados
        // dividido pelo número total de combinações
    	
        return (double) COMBINACOES_COM_MENOS_SORTEADOS / TOTAL_COMBINACOES;
    }

    // Calcula a probabilidade de acertar a sena com uma combinação de 6 números que não contêm nenhum dos mais sorteados
    
    public static double probabilidadeSenaSemMaisSorteados() {
    	
        // A probabilidade é igual ao número de combinações de 6 números que não contêm nenhum dos mais sorteados
        // dividido pelo número total de combinações
    	
        return (double) COMBINACOES_SEM_MAIS_SORTEADOS / TOTAL_COMBINACOES;
    }

    // Calcula a probabilidade de acertar a sena com uma combinação de 6 números que não contêm nenhum dos menos sorteados
    
    public static double probabilidadeSenaSemMenosSorteados() {
    	
        // A probabilidade é igual ao número de combinações de 6 números que não contêm nenhum dos menos sorteados
        // dividido pelo número total de combinações
    	
        return (double) COMBINACOES_SEM_MENOS_SORTEADOS / TOTAL_COMBINACOES;
    }

    // Testa o código com alguns exemplos
    
    public static void main(String[] args) {
    	
        // Exemplo 1: uma combinação aleatória
    	
        int[] numeros1 = {12, 34, 45, 51, 56, 60};
        System.out.println("A probabilidade de acertar a sena com " + Arrays.toString(numeros1) + " é de " 
        + probabilidadeSena(numeros1));

        // Exemplo 2: uma combinação de 6 números mais sorteados
        
        int[] numeros2 = {10, 5, 53, 4, 23, 54};
        System.out.println("A probabilidade de acertar a sena com " + Arrays.toString(numeros2) + " é de " 
        + probabilidadeSena(numeros2));

        // Exemplo 3: uma combinação de 6 números menos sorteados
        
        int[] numeros3 = {26, 55, 22, 21, 9, 15};
        System.out.println("A probabilidade de acertar a sena com " + Arrays.toString(numeros3) + " é de " 
        + probabilidadeSena(numeros3));

        // Exemplo 4: uma combinação que contém 3 números mais sorteados e 3 números menos sorteados
        
        int[] numeros4 = {10, 5, 53, 26, 55, 22};
        System.out.println("A probabilidade de acertar a sena com " + Arrays.toString(numeros4) + " é de " 
        + probabilidadeSena(numeros4));

        // Exemplo 5: uma combinação que contém 2 números mais sorteados e 4 números que não são nem mais nem menos sorteados
        
        int[]numeros5 = {10, 5, 28, 29, 30, 31};
        System.out.println("A probabilidade de acertar a sena com " + Arrays.toString(numeros5) + " é de " 
        + probabilidadeSena(numeros5));

        // Exibe as probabilidades gerais de acertar a sena com diferentes tipos de combinações
        
        System.out.println("A probabilidade de acertar a sena com uma combinação de 6 números mais sorteados é de " + probabilidadeSenaMaisSorteados());
        System.out.println("A probabilidade de acertar a sena com uma combinação de 6 números menos sorteados é de " + probabilidadeSenaMenosSorteados());
        System.out.println("A probabilidade de acertar a sena com uma combinação de 6 números que contêm pelo menos um dos mais sorteados é de " + probabilidadeSenaComMaisSorteados());
        System.out.println("A probabilidade de acertar a sena com uma combinação de 6 números que contêm pelo menos um dos menos sorteados é de " + probabilidadeSenaComMenosSorteados());
        System.out.println("A probabilidade de acertar a sena com uma combinação de 6 números que não contêm nenhum dos mais sorteados é de " + probabilidadeSenaSemMaisSorteados());
        System.out.println("A probabilidade de acertar a sena com uma combinação de 6 números que não contêm nenhum dos menos sorteados é de " + probabilidadeSenaSemMenosSorteados());
    }
}
        		
        		
        		
        		
        		
        		