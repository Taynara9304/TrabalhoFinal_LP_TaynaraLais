package banco_de_dados.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public Connection conectar() {
        String url = "jdbc:mysql://localhost:3306/sistema_lp_animaisMarinhos";
        String usuario = "root";
        String senha = "24lM28@#";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão estabelecida com sucesso!");

            return conexao;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    
        return null;
    }
}
