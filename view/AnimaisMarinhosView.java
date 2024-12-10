package view;

import lib.Entrada;
import modelo.AnimaisMarinhos;

public class AnimaisMarinhosView{

    public static int imprimirMenu(){
        return 0;
    }

    public static void lerAnimalMarinho(AnimaisMarinhos animal) {
        String palavra = null;

        System.out.println("Digite o nome da especie:");
        Entrada.lerString_todaLinha();
        palavra = Entrada.lerString_todaLinha().toUpperCase();
        animal.setNomeEspecie(palavra);

        System.out.println("Digite a idade:");
        animal.setIdade(Entrada.lerInt());

        System.out.println("Digite a quantidade de patas:");
        animal.setQtdPatas(Entrada.lerInt());

        System.out.println("Digite o peso:");
        animal.setPeso(Entrada.lerInt());

        System.out.println("Digite a profundidade máxima:");
        animal.setProfundidadeMax(Entrada.lerInt());

        System.out.println("Digite a velocidade máxima:");
        animal.setVelocidadeMax(Entrada.lerInt());
    }

    public void imprimirAnimalMarinho(){

    }

    public void imprimirListaAnimal(){

    }

    public void buscarAnimalPorNome(){

    }

    public void removerAnimalMarinho(){

    }

    public void ordenarAnimalPorNome(){

    }

    public void editarAnimalMarinho(){


    }

    public void ContarQtdAnimalMarinho(){
        
    }

}