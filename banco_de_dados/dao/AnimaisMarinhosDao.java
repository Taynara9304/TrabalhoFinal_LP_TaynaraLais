package banco_de_dados.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import banco_de_dados.conexao.Conexao;
import banco_de_dados.entity.AnimaisMarinhos;

public class AnimaisMarinhosDao {
    public void inserirAnimal(AnimaisMarinhos animal) {
        String sql= "INSERT INTO animal(nomeEspecie, idade, qtdPatas, peso, profundidadeMax, velocidadeMax) VALUES (?, ?, ?, ?, ?, ?)";

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

    public AnimaisMarinhos buscarAnimal(int idUser) {
        AnimaisMarinhos animal = new AnimaisMarinhos();

        String sql = "SELECT * FROM animal WHERE animal.id = ?";

        try (Connection connection = new Conexao().conectar()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setInt(1, idUser);

            ResultSet rs = stmt.executeQuery();

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
            System.out.println("Erro ao buscar animal");
            e.printStackTrace();
        }

        return animal;
    }

    public void editarNomeEspecie(int idUser, String modelo) {
        String sql = "UPDATE animal SET nomeEspecie = ? WHERE id = ?";

        try (Connection connection = new Conexao().conectar()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, modelo);
            stmt.setInt(2, idUser);

            int mudanca = stmt.executeUpdate();

            if (mudanca > 0) {
                System.out.println("Tudo certo ao atualizar dado do aviao");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar aviao");
            e.printStackTrace();
        }
    }

    public void editarIdade(int idUser, String fabricante) {
        String sql = "UPDATE animal SET idade = ? WHERE id = ?";

        try (Connection connection = new Conexao().conectar()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, fabricante);
            stmt.setInt(2, idUser);

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar aviao");
            e.printStackTrace();
        }
    }

    public void editarQtdPatas(int idUser, int qtdAssento) {
        String sql = "UPDATE animal SET qtdPatas = ? WHERE id = ?";

        try (Connection connection = new Conexao().conectar()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setInt(1, qtdAssento);
            stmt.setInt(2, idUser);

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar aviao");
            e.printStackTrace();
        }
    }

    public void editarPeso(int idUser, int anoFabricacao) {
        String sql = "UPDATE animal SET peso = ? WHERE id = ?";

        try (Connection connection = new Conexao().conectar()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setInt(1, anoFabricacao);
            stmt.setInt(2, idUser);

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar animal");
            e.printStackTrace();
        }
    }

    public void editarProfundidadeMax(int idUser, int anoFabricacao) {
        String sql = "UPDATE animal SET profundidadeMax = ? WHERE id = ?";

        try (Connection connection = new Conexao().conectar()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setInt(1, anoFabricacao);
            stmt.setInt(2, idUser);

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar animal");
            e.printStackTrace();
        }
    }

    public void editarVelocidadeMax(int idUser, int anoFabricacao) {
        String sql = "UPDATE animal SET velocidadeMax = ? WHERE id = ?";

        try (Connection connection = new Conexao().conectar()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setInt(1, anoFabricacao);
            stmt.setInt(2, idUser);

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar animal");
            e.printStackTrace();
        }
    }

    public void deletarAnimal(int idUser) {
        String sql = "DELETE FROM animal WHERE id = ?";

        try (Connection connection = new Conexao().conectar()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setInt(1, idUser);

            int mudanca = stmt.executeUpdate();

            if (mudanca > 0) {
                System.out.println("Tudo certo ao deletar animal");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao deletar animal");
            e.printStackTrace();
        }
    }

    public void contarAvioes() {
        String sql = "SELECT count(*) FROM animal";

        try (Connection connection = new Conexao().conectar()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);

            int qtd = rs.getInt("id");

            System.out.println(qtd);
        } catch (SQLException e) {
            System.out.println("Erro ao contar animal");
            e.printStackTrace();
        }
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
