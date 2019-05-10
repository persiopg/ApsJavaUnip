
package Controller;

import java.sql.*;

public class LoginDao {
    
    private String usuario;
    private String senha;
    private ConectionFactory con = new ConectionFactory();
    private PreparedStatement pst;

    public boolean getLogin(String user, String pass) throws Exception {
        
        String use = "SELECT * FROM tb_funcionario WHERE nm_func LIKE ?;";
        pst = con.Conection().prepareStatement(use);
        pst.setString(1, user);
        ResultSet resultUser = pst.executeQuery();
        while (resultUser.next()) {            
            this.usuario = resultUser.getString("nm_func");
            this.senha = resultUser.getString("senha_func");
        }
        con.Close();
        
        if(user.equals(usuario) && pass.equals(senha) ){
            return true;
        }
        else{
            return false;
        }
        
    }
    
}
