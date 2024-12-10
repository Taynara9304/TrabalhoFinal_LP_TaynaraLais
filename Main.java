import banco_de_dados.*;
import banco_de_dados.dao.AnimaisMarinhosDao;
import modelo.AnimaisMarinhos;
import view.AnimaisMarinhosView;
public class Main {
    public static void main(String[] args) {
        
        AnimaisMarinhosDao animaisDao = new AnimaisMarinhosDao();
        AnimaisMarinhos animal = new AnimaisMarinhos();
        AnimaisMarinhosView.lerAnimalMarinho(animal);
        animaisDao.inserirAnimal(animal);
        
    }
}