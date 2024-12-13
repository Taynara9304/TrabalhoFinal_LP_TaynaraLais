package banco_de_dados.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import banco_de_dados.conexao.Conexao;
import modelo.AnimaisMarinhos;
import view.AnimaisMarinhosView;

public class AnimaisMarinhosDao {
    public void inserirAnimal(AnimaisMarinhos animal) {
        String sql = "INSERT INTO animal(nomeEspecie, idade, qtdPatas, peso, profundidadeMax, velocidadeMax) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = new Conexao().conectar()) {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, animal.getNomeEspecie());
            stmt.setInt(2, animal.getIdade());
            stmt.setInt(3, animal.getQtdPatas());
            stmt.setInt(4, animal.getPeso());
            stmt.setInt(5, animal.getProfundidadeMax());
            stmt.setInt(6, animal.getVelocidadeMax());

            stmt.executeUpdate();
            System.out.println("Animal inserido com sucesso");
            JOptionPane.showMessageDialog(null, "Sucesso ao inserir animal!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            System.out.println("Erro ao inserir animal");
            e.printStackTrace();
        }
    }

    public List<AnimaisMarinhos> listarAnimais() {
        List<AnimaisMarinhos> animaisMarinhos = new ArrayList<>();
        String sql = "SELECT * FROM animal";

        try (Connection connection = new Conexao().conectar()) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                AnimaisMarinhos animal = new AnimaisMarinhos();

                String nomeEspecie = rs.getString("nomeEspecie");
                int idade = rs.getInt("idade");
                int qtdPatas = rs.getInt("qtdPatas");
                int peso = rs.getInt("peso");
                int profundidadeMax = rs.getInt("profundidadeMax");
                int velocidadeMax = rs.getInt("velocidadeMax");

                animal.setNomeEspecie(nomeEspecie);
                animal.setIdade(idade);
                animal.setQtdPatas(qtdPatas);
                animal.setPeso(peso);
                animal.setProfundidadeMax(profundidadeMax);
                animal.setVelocidadeMax(velocidadeMax);

                animaisMarinhos.add(animal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return animaisMarinhos;
    }

    public AnimaisMarinhos buscarAnimalPorNome(String nome) {
        AnimaisMarinhos animal = new AnimaisMarinhos();

        String sql = "SELECT * FROM animal WHERE animal.nomeEspecie = ?";

        try (Connection connection = new Conexao().conectar()) {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String nomeEspecie = rs.getString("nomeEspecie");
                int idade = rs.getInt("idade");
                int qtdPatas = rs.getInt("qtdPatas");
                int peso = rs.getInt("peso");
                int profundidadeMax = rs.getInt("profundidadeMax");
                int velocidadeMax = rs.getInt("profundidadeMax");

                animal.setNomeEspecie(nomeEspecie);
                animal.setIdade(idade);
                animal.setQtdPatas(qtdPatas);
                animal.setPeso(peso);
                animal.setProfundidadeMax(profundidadeMax);
                animal.setVelocidadeMax(velocidadeMax);
            } else {
                System.out.println("Não há um animal com esse nome");

            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar animal");
            e.printStackTrace();
        }
        AnimaisMarinhosView.imprimirAnimalMarinho(animal);

        return animal;
    }

    public void editarNomeEspecie(String nome, String nomeEspecie) {
        String sql = "UPDATE animal SET nomeEspecie = ? WHERE animal.nomeEspecie = ?";

        try (Connection connection = new Conexao().conectar()) {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, nomeEspecie);
            stmt.setString(2, nome);

            int mudanca = stmt.executeUpdate();

            if (mudanca > 0) {
                System.out.println("Tudo certo ao atualizar dado do animal");
                JOptionPane.showMessageDialog(null, "Confirmação", "Sucesso ao atualizar atributo",
                        JOptionPane.YES_OPTION);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar animal");
            JOptionPane.showMessageDialog(null, "Confirmação", "Erro ao atualizar nome", JOptionPane.YES_OPTION);

            e.printStackTrace();
        }
    }

    public void editarIdade(String nome, int idade) {
        String sql = "UPDATE animal SET idade = ? WHERE animal.nomeEspecie = ?";

        try (Connection connection = new Conexao().conectar()) {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, idade);
            stmt.setString(2, nome);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Confirmação", "Sucesso ao atualizar atributo", JOptionPane.YES_OPTION);

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar animal");
            JOptionPane.showMessageDialog(null, "Confirmação", "Erro ao atualizar atributo", JOptionPane.YES_OPTION);

            e.printStackTrace();
        }
    }

    public void editarQtdPatas(String nome, int qtdPatas) {
        String sql = "UPDATE animal SET qtdPatas = ? WHERE animal.nomeEspecie = ?";

        try (Connection connection = new Conexao().conectar()) {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, qtdPatas);
            stmt.setString(2, nome);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Confirmação", "Sucesso ao atualizar atributo", JOptionPane.YES_OPTION);
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar animal");
            JOptionPane.showMessageDialog(null, "Confirmação", "Erro ao atualizar atributo", JOptionPane.YES_OPTION);
            e.printStackTrace();
        }
    }

    public void editarPeso(String nome, int peso) {
        String sql = "UPDATE animal SET peso = ? WHERE animal.nomeEspecie = ?";

        try (Connection connection = new Conexao().conectar()) {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, peso);
            stmt.setString(2, nome);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Confirmação", "Sucesso ao atualizar atributo", JOptionPane.YES_OPTION);
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar animal");
            JOptionPane.showMessageDialog(null, "Erro", "Sucesso ao atualizar atributo", JOptionPane.YES_OPTION);
            e.printStackTrace();
        }
    }

    public void editarProfundidadeMax(String nome, int profundidadeMax) {
        String sql = "UPDATE animal SET profundidadeMax = ? WHERE animal.nomeEspecie = ?";

        try (Connection connection = new Conexao().conectar()) {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, profundidadeMax);
            stmt.setString(2, nome);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Confirmação", "Sucesso ao atualizar atributo", JOptionPane.YES_OPTION);
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar animal");
            JOptionPane.showMessageDialog(null, "Confirmação", "Erro ao atualizar atributo", JOptionPane.YES_OPTION);

            e.printStackTrace();
        }
    }

    public void editarVelocidadeMax(String nome, int velocidadeMax) {
        String sql = "UPDATE animal SET velocidadeMax = ? animal.nomeEspecie = ?";

        try (Connection connection = new Conexao().conectar()) {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, velocidadeMax);
            stmt.setString(2, nome);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Confirmação", "Sucesso ao atualizar atributo", JOptionPane.YES_OPTION);
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar animal");
            JOptionPane.showMessageDialog(null, "Confirmação", "Erro ao atualizar atributo", JOptionPane.YES_OPTION);

            e.printStackTrace();
        }
    }

    public void deletarAnimal(String nome) {
        String sql = "DELETE FROM animal WHERE animal.nomeEspecie = ?";

        try (Connection connection = new Conexao().conectar()) {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, nome);

            int mudanca = stmt.executeUpdate();

            if (mudanca > 0) {
                System.out.println("Tudo certo ao deletar animal");
                JOptionPane.showMessageDialog(null, "Confirmação", "Sucesso ao remover animal", JOptionPane.YES_OPTION);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao deletar animal");
            JOptionPane.showMessageDialog(null, "Confirmação", "Erro ao remover animal", JOptionPane.YES_OPTION);
            e.printStackTrace();
        }
    }

    public int contarAnimais() {
        String sql = "SELECT count(*) FROM animal";
        int qtd = 0;

        try (Connection connection = new Conexao().conectar();
                PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                qtd = rs.getInt(1);
            }

            System.out.println(qtd);
        } catch (SQLException e) {
            System.out.println("Erro ao contar animal");
            e.printStackTrace();
        }
        return qtd;
    }

    public AnimaisMarinhos buscarAnimalMaisNovo() {
        String sql = "SELECT * FROM animal ORDER BY anoFabricacao desc";
        AnimaisMarinhos animal = new AnimaisMarinhos();

        try (Connection connection = new Conexao().conectar()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                String nomeEspecie = rs.getString("nomeEspecie");
                int idade = rs.getInt("idade");
                int qtdPatas = rs.getInt("qtdPatas");
                int peso = rs.getInt("peso");
                int profundidadeMax = rs.getInt("profundidadeMax");
                int velocidadeMax = rs.getInt("velocidadeMax");

                animal.setNomeEspecie(nomeEspecie);
                animal.setIdade(idade);
                animal.setQtdPatas(qtdPatas);
                animal.setPeso(peso);
                animal.setProfundidadeMax(profundidadeMax);
                animal.setVelocidadeMax(velocidadeMax);
            } else {
                System.out.println("Não há um animal com esse id");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao contar animais");
            e.printStackTrace();
        }

        return animal;
    }

    public void buscarAnimalPorIntervalo(int idadeMin, int idadeMax) {
        String sql = "SELECT * FROM animal WHERE aviao.anoFabricacao < ? AND aviao.anoFabricacao > ?";
        AnimaisMarinhos animal = new AnimaisMarinhos();

        try (Connection connection = new Conexao().conectar()) {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, idadeMax);
            stmt.setInt(2, idadeMin);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String nomeEspecie = rs.getString("nomeEspecie");
                int idade = rs.getInt("idade");
                int qtdPatas = rs.getInt("qtdPatas");
                int peso = rs.getInt("peso");
                int profundidadeMax = rs.getInt("profundidadeMax");
                int velocidadeMax = rs.getInt("velocidadeMax");

                animal.setNomeEspecie(nomeEspecie);
                animal.setIdade(idade);
                animal.setQtdPatas(qtdPatas);
                animal.setPeso(peso);
                animal.setProfundidadeMax(profundidadeMax);
                animal.setVelocidadeMax(velocidadeMax);

                System.out.println(animal);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar animal");
            e.printStackTrace();
        }
    }
}
