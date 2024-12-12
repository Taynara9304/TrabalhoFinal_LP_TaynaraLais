import banco_de_dados.dao.*;
import modelo.AnimaisMarinhos;
import view.AnimaisMarinhosView;
import controle.*;
public class Main {
    public static void main(String[] args) {
        AnimaisMarinhosDao animaisDao = new AnimaisMarinhosDao();
        AnimaisMarinhosView animaisView = new AnimaisMarinhosView();
        AnimaisMarinhos animal = new AnimaisMarinhos();

        /*animaisView.lerAnimaisMarinhos(animal);
        animaisDao.inserirAnimal(animal);
        animaisDao.editarIdade(1, 50);
        animaisView.imprimirAnimalMarinho(animal);*/

        animaisView.imprimirMenu();
        animal = animaisDao.buscarAnimal("Cavalo");
        animaisView.imprimirAnimalMarinho(animal);
    }
}