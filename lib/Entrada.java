package lib;

import java.util.ArrayList;
import java.util.Scanner;

public class Entrada {
    public static Scanner LER;

    public static void abrir() {
        LER = new Scanner(System.in);
    }

    public static void fechar() {
        LER.close();
    }
    
    public static int lerInt() {
        return LER.nextInt();
    }

    public static int lerInt(String mensagem) {
        System.out.println(mensagem);
        return LER.nextInt();
    }

    public static String lerString() {
        return LER.next();
    }

    public static String lerString_todaLinha() {
        return LER.nextLine();
    }

    public static float lerFloart() {
        return LER.nextFloat();
    }

    public static double lerDouble() {
        return LER.nextDouble();
    }

    public static boolean lerBoolean() {
        return LER.nextBoolean();
    }

    public static int[] lerVetor(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = LER.nextInt();
            System.out.println(vetor[i]);
        }

        return vetor;
    }

    public static ArrayList<Integer> lerArrayLista_Integer(ArrayList<Integer> numeros) {
        System.out.println("Digite -1 para terminar de inserir");
        
        while (!numeros.contains(-1)){
            int aux = LER.nextInt();

            if (aux != -1) {
                numeros.add(aux);
            } else {
                break;
            }
        }

        return numeros;
    }

    public static ArrayList<String> lerArrayLista_String(ArrayList<String> palavras) {
        System.out.println("Digite -1 para terminar de inserir");
        
        while (!palavras.contains("-1")){
            String aux = LER.next();

            if (!aux.equals("-1")) {
                palavras.add(aux);
            } else {
                break;
            }
        }

        return palavras;
    }
}
