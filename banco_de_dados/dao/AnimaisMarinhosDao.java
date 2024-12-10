package banco_de_dados.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import banco_de_dados.conexao.Conexao;
import banco_de_dados.entity.AnimaisMarinhos;

public class AnimaisMarinhosDao {
    public void inserirAviao(AnimaisMarinhos aviao) {
        String sql= "INSERT INTO aviao(modelo, fabricante, qtdAssentos, anoFabricacao) VALUES (?, ?, ?, ?)";

        try (Connection connection = new Conexao().conectar()) {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, aviao.getModelo());
            stmt.setString(2, aviao.getFabricante());
            stmt.setInt(3, aviao.getQtdAssentos());
            stmt.setInt(4, aviao.getAnoFabricacao());
            
            stmt.executeUpdate();
            System.out.println("Avião inserido com sucesso");
        } catch (SQLException e) {
            System.out.println("erro ao inserir");
            e.printStackTrace();
        }
    }

    public List<AnimaisMarinhos> listarAvioes() {
        List<Aviao> avioes = new ArrayList<>();
        String sql = "SELECT * FROM aviao";

        try (Connection connection = new Conexao().conectar()) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Aviao aviao = new Aviao();

                String modelo = rs.getString("modelo");
                String fabricante = rs.getString("fabricante");
                int qtdAssento = rs.getInt("qtdAssentos");
                int anoFabricacao = rs.getInt("anoFabricacao");

                aviao.setModelo(modelo);
                aviao.setFabricante(fabricante);
                aviao.setQtdAssentos(qtdAssento);
                aviao.setAnoFabricacao(anoFabricacao);

                avioes.add(aviao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return avioes;
    }

    public AnimaisMarinhos buscarAviao(int idUser) {
        AnimaisMarinhos aviao = new Aviao();

        String sql = "SELECT * FROM aviao WHERE aviao.id = ?";

        try (Connection connection = new Conexao().conectar()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setInt(1, idUser);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String modelo = rs.getString("modelo");
                String fabricante = rs.getString("fabricante");
                int qtdAssento = rs.getInt("qtdAssentos");
                int anoFabricacao = rs.getInt("anoFabricacao");
    
                aviao.setModelo(modelo);
                aviao.setFabricante(fabricante);
                aviao.setQtdAssentos(qtdAssento);
                aviao.setAnoFabricacao(anoFabricacao);
            } else {
                System.out.println("Não há um avião com esse id");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar aviao");
            e.printStackTrace();
        }

        return aviao;
    }

    public void editarModeloAviao(int idUser, String modelo) {
        String sql = "UPDATE aviao SET modelo = ? WHERE id = ?";

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

    public void editarFabricanteAviao(int idUser, String fabricante) {
        String sql = "UPDATE aviao SET fabricante = ? WHERE id = ?";

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

    public void editarQtdAssentoAviao(int idUser, int qtdAssento) {
        String sql = "UPDATE aviao SET qtdAcentos = ? WHERE id = ?";

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

    public void editarAnoFabricacaoAviao(int idUser, int anoFabricacao) {
        String sql = "UPDATE aviao SET anoFabricacao = ? WHERE id = ?";

        try (Connection connection = new Conexao().conectar()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setInt(1, anoFabricacao);
            stmt.setInt(2, idUser);

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar aviao");
            e.printStackTrace();
        }
    }

    public void deletarAviao(int idUser) {
        String sql = "DELETE FROM aviao WHERE id = ?";

        try (Connection connection = new Conexao().conectar()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setInt(1, idUser);

            int mudanca = stmt.executeUpdate();

            if (mudanca > 0) {
                System.out.println("Tudo certo ao deletar aviao");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao deletar aviao");
            e.printStackTrace();
        }
    }

    public void contarAvioes() {
        String sql = "SELECT count(*) FROM aviao";

        try (Connection connection = new Conexao().conectar()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);

            int qtd = rs.getInt("id");

            System.out.println(qtd);
        } catch (SQLException e) {
            System.out.println("Erro ao contar aviao");
            e.printStackTrace();
        }
    }

    public AnimaisMarinhos buscarAviaoMaisNovo() {
        String sql = "SELECT * FROM aviao ORDER BY anoFabricacao desc";
        AnimaisMarinhos aviao = new AnimaisMarinhos();

        try (Connection connection = new Conexao().conectar()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                String modelo = rs.getString("modelo");
                String fabricante = rs.getString("fabricante");
                int qtdAssento = rs.getInt("qtdAssentos");
                int anoFabricacao = rs.getInt("anoFabricacao");
    
                aviao.setModelo(modelo);
                aviao.setFabricante(fabricante);
                aviao.setQtdAssentos(qtdAssento);
                aviao.setAnoFabricacao(anoFabricacao);
            } else {
                System.out.println("Não há um avião com esse id");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao contar aviao");
            e.printStackTrace();
        }

        return aviao;
    }

    public void buscarAviaoPorIntervalo(int anoMin, int anoMax) {
        String sql = "SELECT * FROM aviao WHERE aviao.anoFabricacao < ? AND aviao.anoFabricacao > ?";
        AnimaisMarinhos aviao = new AnimaisMarinhos();

        try (Connection connection = new Conexao().conectar()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setInt(1, anoMax);
            stmt.setInt(2, anoMin);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String modelo = rs.getString("modelo");
                String fabricante = rs.getString("fabricante");
                int qtdAssento = rs.getInt("qtdAssentos");
                int anoFabricacao = rs.getInt("anoFabricacao");
    
                aviao.setModelo(modelo);
                aviao.setFabricante(fabricante);
                aviao.setQtdAssentos(qtdAssento);
                aviao.setAnoFabricacao(anoFabricacao);

                System.out.println(aviao);
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao buscar aviao");
            e.printStackTrace();
        }
    }
}
