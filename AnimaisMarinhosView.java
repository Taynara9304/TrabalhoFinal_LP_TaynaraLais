package view;

import java.util.List;
import javax.swing.JOptionPane;
import modelo.AnimaisMarinhos;
import banco_de_dados.dao.*;
public class AnimaisMarinhosView{

    public static int imprimirMenu(){
        int escolha = 0;

        escolha = Integer.parseInt(JOptionPane.showInputDialog(null, 
        "Escolha uma opção:"
        + "\n1 - Inserir animal marinho"
        + "\n2 - Imprimir animal marinho"
        + "\n3 - Ordenar e imprimir por nome"
        + "\n4 - Buscar por nome do animal marinho"
        + "\n5 - Contar quantidade de animais cadastrados"
        + "\n6 - Remover animal marinho"
        + "\n7 - Editar animal marinho",
        "Menu",
        JOptionPane.QUESTION_MESSAGE));

        return escolha;
    }

    public static AnimaisMarinhos lerAnimaisMarinhos(AnimaisMarinhos animal) {
        String nome = JOptionPane.showInputDialog(null, "Nome da espécie:", "Inserir dados", JOptionPane.QUESTION_MESSAGE);
        animal.setNomeEspecie(nome);

        int idade = Integer.parseInt(JOptionPane.showInputDialog(null, "Idade do animal:", "Inserir dados", JOptionPane.QUESTION_MESSAGE));
        animal.setIdade(idade);

        int qtdPatas = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantidade de patas:", "Inserir dados", JOptionPane.QUESTION_MESSAGE));
        animal.setQtdPatas(qtdPatas);

        int peso = Integer.parseInt(JOptionPane.showInputDialog(null, "Peso do animal:", "Inserir dados", JOptionPane.QUESTION_MESSAGE));
        animal.setPeso(peso);

        int profundidadeMax = Integer.parseInt(JOptionPane.showInputDialog(null, "Profundidade máxima:", "Inserir dados", JOptionPane.QUESTION_MESSAGE));
        animal.setProfundidadeMax(profundidadeMax);

        int velocidadeMax = Integer.parseInt(JOptionPane.showInputDialog(null, "Velocidade máxima:", "Inserir dados", JOptionPane.QUESTION_MESSAGE));
        animal.setVelocidadeMax(velocidadeMax);

        return animal;
    }

    public static void imprimirAnimalMarinho(AnimaisMarinhos animal){
        JOptionPane.showMessageDialog(null, 
        "Nome do animal: " + animal.getNomeEspecie()
         + "\nIdade: " + animal.getIdade() + " anos"
         + "\nQuantidade de patas: " + animal.getQtdPatas() 
         + "\nPeso: " + animal.getPeso() 
         + "\nProfundidade máxima: " + animal.getProfundidadeMax() 
         + "\nVelocidade máxima: " + animal.getVelocidadeMax(),
          "Janela inicial", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void imprimirListaAnimal(List<AnimaisMarinhos> listaAnimais){
        for (AnimaisMarinhos animaisMarinhos : listaAnimais) {
            imprimirAnimalMarinho(animaisMarinhos);
        }
    }

    public static String lerNomeAnimal() {
        String nome = JOptionPane.showInputDialog(null, "Digite o nome do animal:", "Inserir dados", 0);
        return nome;
    }

    public void ordenarAnimalPorNome(){

    }

    public static void editarAnimalMarinho(){
        int escolha = 0;
        AnimaisMarinhosDao animalDao = new AnimaisMarinhosDao();

        escolha = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha uma opção:"
        + "\n1 - Editar nome"
        + "\n2 - Editar idade"
        + "\n3 - Editar quantidade de patas"
        + "\n4 - Editar peso"
        + "\n5 - Editar profundidade máxima"
        + "\n6 - Editar velocidade máxima"
        + "\n7 - Editar tudo"
        , "Editar animal", JOptionPane.QUESTION_MESSAGE));

        String nome = JOptionPane.showInputDialog(null, "Digite o nome do animal que deseja editar:", "Inserir dados", 0);

        switch (escolha) {
            case 1:
                String nomeEspecie = JOptionPane.showInputDialog(null, "Digite o novo nome da espécie:", "Inserir dados", 0);
                animalDao.editarNomeEspecie(nome, nomeEspecie);
                break;
            case 2:
                int idade = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a idade do animal:", "Inserir dados", 0));
                animalDao.editarIdade(nome, idade);
                break;
            case 3:
                int qtdPatas = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade de patas do animal:", "Inserir dados", 0));
                animalDao.editarQtdPatas(nome, qtdPatas);
                break;
            case 4:
                int peso = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o peso do animal:", "Inserir dados", 0));
                animalDao.editarPeso(nome, peso);
                break;
            case 5:
                int profundidadeMax = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a profundidade máxima do animal:", "Inserir dados", 0));
                animalDao.editarProfundidadeMax(nome, profundidadeMax);
                break;
            case 6:
                int velocidadeMax = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a velocidade máxima do animal:", "Inserir dados", 0));
                animalDao.editarVelocidadeMax(nome, velocidadeMax);
                break;
            case 7:
                String nomeEspecieTudo = JOptionPane.showInputDialog(null, "Digite o novo nome da espécie:", "Inserir dados", 0);
                animalDao.editarNomeEspecie(nome, nomeEspecieTudo);

                int idadeTudo = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a idade do animal:", "Inserir dados", 0));
                animalDao.editarIdade(nome, idadeTudo);

                int qtdPatasTudo = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade de patas do animal:", "Inserir dados", 0));
                animalDao.editarQtdPatas(nome, qtdPatasTudo);

                int pesoTudo = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o peso do animal:", "Inserir dados", 0));
                animalDao.editarPeso(nome, pesoTudo);

                int profundidadeMaxTudo = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a profundidade máxima do animal:", "Inserir dados", 0));
                animalDao.editarProfundidadeMax(nome, profundidadeMaxTudo);

                int velocidadeMaxTudo = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a velocidade máxima do animal:", "Inserir dados", 0));
                animalDao.editarVelocidadeMax(nome, velocidadeMaxTudo);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Erro", "Comando inválido", JOptionPane.DEFAULT_OPTION);
                break;
        }
    }

    public void ContarQtdAnimalMarinho(){
        
    }

}