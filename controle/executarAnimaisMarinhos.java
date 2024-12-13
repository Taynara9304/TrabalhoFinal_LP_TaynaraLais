package controle;
import java.util.ArrayList;
import java.util.List;

import banco_de_dados.dao.AnimaisMarinhosDao;
import modelo.AnimaisMarinhos;
import view.AnimaisMarinhosView;

public class executarAnimaisMarinhos{

    public static void controle(){
        int escolha = 0;
        
        List<AnimaisMarinhos> listaAnimais = new ArrayList<>();
        AnimaisMarinhosDao animaisDao = new AnimaisMarinhosDao();

        while(true){
            escolha = AnimaisMarinhosView.imprimirMenu();

             switch (escolha){

                case 1:
                    // ler animal marinho
                    AnimaisMarinhos animal = new AnimaisMarinhos();
                    //pegando os dados do JOptionPane
                    animal = AnimaisMarinhosView.lerAnimaisMarinhos(animal);
                    //inserindo no banco de dados
                    animaisDao.inserirAnimal(animal);
                    break;
                case 2:
                    // imprimir animal marinho
                    //pegando os dados do banco de dados
                    listaAnimais = animaisDao.listarAnimais();
                    //imprimindo com o JOptionPane
                    AnimaisMarinhosView.imprimirListaAnimal(listaAnimais);
                    break;
                case 3:
                    // imprimir em ordem alfabética
                    AnimaisMarinhosView.ordenarAnimalPorNome();
                    break;
                case 4:
                    // buscar por nome
                    String nomeBuscar = AnimaisMarinhosView.lerNomeAnimal();
                     animaisDao.buscarAnimalPorNome(nomeBuscar);
                    break;
                case 5:
                    // contar quantidade de animais
                    AnimaisMarinhosView.ContarQtdAnimalMarinho();
                    break;
                case 6:
                    // remover animal marinho
                    String nomeDeletar = AnimaisMarinhosView.lerNomeAnimal();
                     animaisDao.deletarAnimal(nomeDeletar);
                    break;
                case 7:
                    // editar animal marinho
                    AnimaisMarinhosView.editarAnimalMarinho();
                    break;
                
             }
        }
    }
}