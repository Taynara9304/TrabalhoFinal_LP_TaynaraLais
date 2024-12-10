package lib;

public class Matriz {
    public static int[][] multiplicar(int[][] multiplicacao, int[][] matriz1, int[][] matriz2) {
        if (matriz1.length >= matriz2.length) {
            multiplicacao = multiplicarMatrizMaior(multiplicacao, matriz1, matriz2, matriz1.length, matriz2.length);
        } else {
            multiplicacao = multiplicarMatrizMenor(multiplicacao, matriz1, matriz2, matriz1.length, matriz2.length);
        }

        return multiplicacao;
    }

    private static int[][] multiplicarMatrizMenor(int[][] multiplicacao, int[][] matriz1, int[][] matriz2, int n1, int m2) {
        int aux = 0;
        int soma = 0;

        for (int linha = 0; linha < n1; linha++) {
            for (int i = 0; i < n1; i++) {
                soma = 0;
                aux = 0;
    
                for (int j = 0; j < m2; j++) {
                    aux = matriz1[linha][j] * matriz2[j][i];
                    soma += aux;
                }
    
                multiplicacao[linha][i] = soma;
            }
        }
        

        return multiplicacao;
    }

    private static int[][] multiplicarMatrizMaior(int[][] multiplicacao, int[][] matriz1, int[][] matriz2, int n1, int m2) {
        int aux = 0;
        int soma = 0;

        for (int linha = 0; linha < n1; linha++) {
            for (int i = 0; i < m2; i++) {
                soma = 0;
                aux = 0;
    
                for (int j = 0; j < m2; j++) {
                    aux = matriz1[linha][j] * matriz2[j][i];
                    soma += aux;
                }
    
                multiplicacao[linha][i] = soma;
            }
        }
        

        return multiplicacao;
    }

    public static boolean verificarMatrizIdetentidade(int[][] matriz, int n, int m) {
        boolean aux = true;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == j) {
                    if (matriz[i][j] == 1) {
                        aux = true;
                    } else {
                        aux = false;
                        break;
                    }
                } else {
                    if (matriz[i][j] != 0) {
                        aux = false;
                        break;
                    }
                }
            }

            if (aux == false) {
                break;
            }
        }

        return aux;
    }

    public static int[][] calcularOposta(int[][] matriz, int[][] matrizOposta) {
        for (byte i = 0; i < matrizOposta.length; i++) {
            for (byte j = 0; j < matrizOposta[0].length; j++) {
                matrizOposta[i][j] = matriz[i][j] * -1;
            }
        }

        return matrizOposta;
    }

    public static short[][] transporMatriz(short[][] matriz, short[][] matrizTransposta, byte n, byte m) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrizTransposta[i][j] = matriz[j][i];
            }
        }

       return matrizTransposta; 
    }

    public static int[][] somarMatriz(int[][] matriz1, int[][] matriz2, int[][] soma, int n, int m){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                soma[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }
  
        return soma;
    }

    public static int[][] subtrairMatriz(int[][] matriz1, int[][] matriz2, int[][] soma, int n, int m){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                soma[i][j] = matriz1[i][j] - matriz2[i][j];
            }
        }
      
        return soma;
    }
}
