
package View;
import Controller.ConectionFactory;
import java.sql.SQLException;


public class testconection {
    public static void main(String[] args) throws Exception{
        try {
            ConectionFactory con = new ConectionFactory();
            con.Conection();
        } catch (SQLException ex) {
            ex.toString();
        }
        
    }
}
