package Controller;
import java.sql.*;

public class ConectionFactory {
    
    private String drive;
    private String url;
    private String usuario;
    private String senha;
    private Connection con;
    
 
    public Connection Conection() throws Exception{
        this.url = "jdbc:postgresql://localhost:5432/sistema_caixa";
        this.usuario = "postgres";
        this.senha = "98745663";
        this.drive = "org.postgresql.Driver";
        
        try {
            Class.forName(drive);
            con = DriverManager.getConnection(url,usuario,senha);
            System.out.println("conexao realizada com sucesso!!!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }       
        return con;
    }
    public void Close() throws Exception{
        con.close();
        
    }
    
}
