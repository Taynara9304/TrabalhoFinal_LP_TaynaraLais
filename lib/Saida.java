package lib;

public class Saida {
    public static void imprimirVetorInteiro(int[] vetor) {
        System.out.println();

        for (int i = 0; i < vetor.length - 1; i++) {
            System.out.print(vetor[i] + " ");
        }

        System.out.print(vetor[vetor.length - 1]);
    }

    public static void imprimirMatrizInteira(int[][] matriz) {
        System.out.println();

        for (int i = 0; i < matriz.length - 1; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
        }

        System.out.print(matriz[matriz.length - 1][matriz.length - 1] + "\n");
    }

    public static void imprimirInteiro_comQuebraDeLinha(int inteiro) {
        System.out.println(inteiro);
    }

    public static void imprimirInteiro_semQuebraDeLinha_comEspaco(int inteiro) {
        System.out.print(inteiro + " ");
    }

    public static void imprimirString_comQuebraDeLinha(String palavra) {
        System.out.println(palavra);
    }

    public static void imprimirString_semQuebraDeLinha_comEspaco(String palavra) {
        System.out.print(palavra + " ");
    }

    public static void imprimirFloat_comQuebraDeLinha(float pontoFlutuante) {
        System.out.println(pontoFlutuante);
    }

    public static void imprimirFloat_semQuebraDeLinha_comEspaco(float pontoFlutuante) {
        System.out.print(pontoFlutuante + " ");
    }

    public static void imprimirDouble_comQuebraDeLinha(Double pontoFlutuante) {
        System.out.println(pontoFlutuante);
    }

    public static void imprimirDouble_semQuebraDeLinha_comEspaco(Double pontoFlutuante) {
        System.out.print(pontoFlutuante + " ");
    }

    public static void imprimirBoolean_comQuebraDeLinha(boolean testeLogico) {
        System.out.println(testeLogico);
    }

    public static void imprimirBoolean_semQuebraDeLinha_comEspaco(boolean testeLogico) {
        System.out.print(testeLogico + " ");
    }
}
