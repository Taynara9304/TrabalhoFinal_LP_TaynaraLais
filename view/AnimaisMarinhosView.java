package view;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import modelo.AnimaisMarinhos;
import banco_de_dados.dao.*;
public class AnimaisMarinhosView{

    public static void imprimirMenu(){
        JOptionPane.showMessageDialog(null, "Menu", "Escolha uma opção:"
        + "\n1 - Inserir animal marinho"
        + "\n2 - Imprimir animal marinho"
        + "\n3 - Ordenar e imprimir por nome"
        + "\n4 - Buscar por nome do animal marinho"
        + "\n5 - Contar quantidade de animais cadastrados"
        + "\n6 - Remover animal marinho"
        + "\n7 - Editar animal marinho"
        , JOptionPane.QUESTION_MESSAGE);

    }

    public void lerAnimaisMarinhos(AnimaisMarinhos animal) {
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
    }

    public void imprimirAnimalMarinho(AnimaisMarinhos animal){
        JOptionPane.showMessageDialog(null, 
        "Nome do animal: " + animal.getNomeEspecie()
         + "\nIdade: " + animal.getIdade() + " anos"
         + "\nQuantidade de patas: " + animal.getQtdPatas() 
         + "\nPeso: " + animal.getPeso() 
         + "\nProfundidade máxima: " + animal.getProfundidadeMax() 
         + "\nVelocidade máxima: " + animal.getVelocidadeMax(),
          "Janela inicial", JOptionPane.INFORMATION_MESSAGE);
    }

    public void imprimirListaAnimal(ArrayList<AnimaisMarinhos> listaAnimais){
        for (AnimaisMarinhos animaisMarinhos : listaAnimais) {
            imprimirAnimalMarinho(animaisMarinhos);
        }
    }

    public void buscarAnimalPorNome(String nome){
        AnimaisMarinhosDao animal = new AnimaisMarinhosDao();
        animal.buscarAnimal(nome);
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