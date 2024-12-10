package lib;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class HandlerFile {
    public static void criarArquivo(String nomeArquivo) {
        try {
            File fileObj = new File(nomeArquivo + ".txt");

            if (fileObj.createNewFile()) {
                System.out.println("Arquivo criado: " + fileObj.getName());
            } else {
                System.out.println("Arquivo já existente.");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao criar o arquivo.");
            e.printStackTrace();
        }
    }

    public static void escreverArquivo(String nomeArquivo, ArrayList<String> listaFrutas) {
        try {
            FileWriter myWriter = new FileWriter(nomeArquivo);

            myWriter.write("" + listaFrutas);

            myWriter.close();

            System.out.println("Tudo certo para escrever o arquivo");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao escrever no arquivo");
            e.printStackTrace();
        }
    }

    public static void obterInfoArquivo(String nomeArquivo) {
        File myObj = new File(nomeArquivo);
        
        if (myObj.exists()) {
            System.out.println("File name: " + myObj.getName());
            System.out.println("Absolute path: " + myObj.getAbsolutePath());
            System.out.println("Writeable: " + myObj.canWrite());
            System.out.println("Readable: " + myObj.canRead());
            System.out.println("File size: " + myObj.length());
        } else {
            System.out.println("O arquivo não existe.");
        }
    }

    public static void lerArquivo(String nomeArquivo) {
        try {
            File myObj = new File(nomeArquivo);
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }

            myReader.close();

            System.out.println("Tudo certo ao ler o arquivo");
        } catch (FileNotFoundException e) {
            System.out.println("Ocorreu um erro ao ler o arquivo.");
            e.printStackTrace();
        }
    }

    public static void deletarArquivo(String path) {
        File myObj = new File(path);

        if (myObj.delete()) {
            System.out.println("Arquivo deletado : " + myObj.getName());
        } else {
            System.out.println("Não foi possivel deletar o arquivo.");
        }
    }
}
