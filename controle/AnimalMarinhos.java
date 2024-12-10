package controle;

import java.util.ArrayList;

import modelo.*;
import view.*;

public class AnimalMarinhos{

    public static void controle(){
        int n = 0;
        ArrayList<AnimaisMarinhos> listaAnimais = new ArrayList<>();

        while(true){
            n = AnimaisMarinhosView.imprimirMenu();

             switch (n){

                case 1:
                    // ler animal marinho
                    AnimaisMarinhosView.lerAnimaisMarinhos();
                    break;
                case 2:
                    // imprimir animal marinho
                    // AnimaisMarinhosView.imprimirListaAnimal();
                    break;
                case 3:
                    // ordenar por nome
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
}