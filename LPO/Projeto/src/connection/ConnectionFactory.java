/** @author Felipe dos Santos Veras
 * Projeto LPOO e integrador
 * Mestre/Orientador Aldo Henrique
 *
 */
package connection;

// importando bibliotecas para conexão com o banco:
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 */
public class ConnectionFactory {

    //criando uma variável especial para 
    //estabelecer uma conexão com o banco
    private static String DRIVER = "com.mysql.jdbc.Driver";
    //armazenando informações referente ao 
    //banco de dados
    private static String URL = "jdbc:mysql://localhost:3306/dbprojeto";
    private static String USER = "root";
    private static String PASS = "";

    //criando um método responsável por estabelecer
    //uma conexão com o banco
    public static Connection getConnection(){
        //estabelecendo a conexão com o banco
        try {
            Class.forName(DRIVER);

            return DriverManager.getConnection(URL,USER,PASS);

        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão:", ex);

        }
    }

    // as linhas abaixo serve para mostrar o erro
    public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void closeConnection(Connection con, PreparedStatement stmt) {
        closeConnection(con);

        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
        closeConnection(con, stmt);

        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
