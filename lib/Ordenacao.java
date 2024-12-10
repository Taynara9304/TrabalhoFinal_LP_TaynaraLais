package lib;

public class Ordenacao {
    private static int[] trocar(int[] vetor, int i, int j) {
        int aux = 0;
        
        aux = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = aux;

        return vetor;
    }

    public static int[] ordenarBubbleSort(int[] vetor) {
        boolean trocas = true;
        int tamanho = vetor.length;

        while (trocas) {
            trocas = false;
            tamanho --;

            for (int i = 0; i < tamanho; i++) {
                if (vetor[i] > vetor[i+1]) {
                    trocar(vetor, i, i + 1);
                    trocas = true;
                }
            }
        }

        return vetor;
    }

    public static int[] ordenarInsertionSort(int[] vetor) {
        int num = 0;

        for (int i = 1; i < vetor.length; i++) {
            num = vetor[i];
            
            for (int j = i-1; j >= 0 && vetor[j] > num; j--) {
                vetor = trocar(vetor, j, j + 1);
            }
        }
        return vetor;
    }

    public static int[] ordenarSelectionSort(int[] vetor) {
        int p = 0;

        for (int i = 0; i < vetor.length - 1; i++) {
            p = i;

            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < vetor[p]) {
                    p = j;  
                }
            }

            if (p != i) {
                vetor = trocar(vetor, i, p);
            }
        }
        return vetor;
    }

    public static int[] iniciarMarge(int[] vetor) {
        int inicio = 0;
        int fim = vetor.length;
        vetor = ordenarMargeSort(vetor, inicio, fim);

        return vetor;
    }

    private static int[] ordenarMargeSort(int[] vetor, int inicio, int fim) {
        int meio = 0;

        if (inicio < fim -1) {
            meio = (inicio + fim)/2;
            ordenarMargeSort(vetor, inicio, meio);
            ordenarMargeSort(vetor, meio, fim);
            margeSort(vetor, inicio, meio, fim);
        }

        return vetor;
    }

    private static int[] margeSort(int[] vetor, int inicio, int meio, int fim) {
        int i = inicio;
        int j = meio;
        int k = 0;

        int[] vetorAux = new int[fim - inicio];

        while (i < meio && j < fim) {
            if (vetor[i] <= vetor[j]) {
                vetorAux[k++] = vetor[i++];
            } else {
                vetorAux[k++] = vetor[j++];
            }
        }

        while (i < meio) {
            vetorAux[k++] = vetor[i++];
        }

        while (j < fim) {
            vetorAux[k++] = vetor[i++];
        }

        for (i = inicio; i < fim; i++) {
            vetor[i] = vetorAux[i - inicio];
        }

        return vetor;
    }

    public static int[] iniciarQuik(int[] vetor) {
        int inicio = 0;
        int fim = vetor.length;
        vetor = ordenarQuikSort(vetor, inicio, fim-1);

        return vetor;
    }
    
    private static int[] ordenarQuikSort(int[] vetor, int inicio, int fim) {
        int meio = 0;
        int pivo = 0;
        int i = inicio;
        int j = fim - 1;

        if (inicio < fim) {
            meio = (inicio + fim)/2;
            pivo = vetor[meio];

            trocar(vetor, meio, fim);

            i = inicio - 1;
            j = fim;

            do {
                do {
                    i ++;
                } while (i <= j && vetor[i] < pivo);

                do {
                    j--;
                } while (i <= j && vetor[j] > pivo);

                if (i <= j) {
                    trocar(vetor, i, j);
                }

            } while (i < j);

            vetor[fim] = vetor[i];
            vetor[i] = pivo;

            ordenarQuikSort(vetor, inicio, i - 1);
            ordenarQuikSort(vetor, i + 1, fim);
        }

        return vetor;
    }

    public static boolean iniciarPesquisaBinaria(int[] vetor, int numProcurado) {
        boolean existe = false;
        int fim = vetor.length;
        int inicio = 0;
        int meio = 0;
        existe = procurarPorPesquisaBinaria(vetor, numProcurado, existe, fim, inicio, meio);

        return existe;
    }

    private static boolean procurarPorPesquisaBinaria(int[] vetor, int numProcurado, boolean posicao, int fim, int inicio, int meio) {
        
        if (inicio < fim) {
            meio = (inicio + fim)/2;

            if(vetor[meio] == numProcurado) {
                return true;
            } else if(numProcurado < vetor[meio]) {
                posicao = procurarPorPesquisaBinaria(vetor, numProcurado, posicao, meio - 1, inicio, meio);
            } else {
                posicao = procurarPorPesquisaBinaria(vetor, numProcurado, posicao, fim, meio + 1, meio);
            }

            return posicao;
        }

        return posicao;
    }

    public static boolean iniciarPesquisaSequencial(int[] vetor, int numProcurado) {
        boolean existe = false;
        existe = procurarPorPesquisaSequencial(vetor, numProcurado, existe);

        return existe;
    }

    private static boolean procurarPorPesquisaSequencial(int[] vetor, int numProcurado, boolean posicao) {
        for (int i = 0; i < vetor.length; i++) {
            if (numProcurado == vetor[i]) {
                return true;
            }
        }

        return posicao;
    }
}
