package controle;

import java.util.ArrayList;

import modelo.*;
import view.*;

public class executarAnimaisMarinhos{

    public static void controle(){
        int n = 0;
        ArrayList<AnimaisMarinhos> listaAnimais = new ArrayList<>();

        while(true){
            AnimaisMarinhosView.imprimirMenu();

             switch (n){

                case 1:
                    // ler animal marinho
                    //AnimaisMarinhosView.lerAnimaisMarinhos();
                    break;
                case 2:
                    // imprimir animal marinho
                    //AnimaisMarinhosView.imprimirListaAnimal();
                    break;
                case 3:
                    // ordenar e imprimir por nome
                    //AnimaisMarinhosView.ordenarAnimalPorNome();
                    break;
                case 4:
                    // buscar por nome
                    //AnimaisMarinhosView.buscarAnimalPorNome();
                    break;
                case 5:
                    // contar quantidade de animais
                    //AnimaisMarinhosView.ContarQtdAnimalMarinho();
                    break;
                case 6:
                    // remover animal marinho
                    //AnimaisMarinhosView.ordenarAnimalPorNome();
                    break;
                case 7:
                    // editar animal marinho
                    //AnimaisMarinhosView.editarAnimalMarinho();
                    break;
                
             }
        }
    }

    public static void imprimirListaAnimal(AnimaisMarinhos animal) {
        System.out.println("Nome da espécie: " + animal.getNomeEspecie());
        System.out.println("Idade: " + animal.getIdade());
        System.out.println("Quantidade de patas: " + animal.getPeso());
        System.out.println("Profundidade máxima: " + animal.getProfundidadeMax());
        System.out.println("Velocidade máxima: " + animal.getVelocidadeMax());
    }
}