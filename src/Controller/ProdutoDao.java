
package Controller;

import Modal.Produto;
import java.sql.PreparedStatement;

public class ProdutoDao{
    
    private ConectionFactory con = new ConectionFactory();
    private PreparedStatement pst;
    
    public void Add(Produto p) throws Exception{
        String add = "INSERT INTO tb_produto (nome,email, telefone) VALUES(?,?,?);";

        pst = con.Conection().prepareStatement(add);
    }
    
    public void delet(Produto p) throws Exception{        
        String dlt = "DELETE FROM tb_produto WHERE id_contato = ?;";

        pst = con.Conection().prepareStatement(dlt);
    }
    public void search(String codBar)throws Exception{
        String src = "SELECT * FROM tb_produto WHERE codigo LIKE ?;";
        
        pst = con.Conection().prepareStatement(src);
    }
}
