/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modal;

import Controller.ConectionFactory;
import java.sql.*;

/**
 *
 * @author user
 */
public class FuncionarioDao {
    private String nome;
    private String senha;
    private int matricula;
    private boolean permissao;
    private FuncionarioDao fun;
    private final ConectionFactory con = new ConectionFactory();
    private PreparedStatement pst;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public boolean isPermissao() {
        return permissao;
    }

    public void setPermissao(boolean permissao) {
        this.permissao = permissao;
    }

    
    public FuncionarioDao getFuncionario(String user, String pass) throws Exception {
        
        String use = "SELECT * FROM tb_funcionario WHERE nm_func LIKE ?;";
        pst = con.Conection().prepareStatement(use);
        pst.setString(1, user);
        ResultSet resultUser = pst.executeQuery();
        while (resultUser.next()) {            
            this.nome = resultUser.getString("nm_func");
            this.senha = resultUser.getString("senha_func");
            this.matricula = resultUser.getInt("id_func");
            this.permissao = resultUser.getBoolean("permissao");
        }
        
        pst.close();
        con.Close();
        if(user.equals(nome) && pass.equals(senha) ){ 
            fun = new FuncionarioDao();            
            fun.setNome(nome);
            fun.setSenha(senha);
            fun.setPermissao(permissao);
            fun.setMatricula(matricula);
            return fun;
        }
        else{
            return null;
        }
        
    }
    public String Busca(String nome) throws Exception{
        String use = "SELECT * FROM tb_funcionario WHERE nm_func LIKE ?;";
        pst = con.Conection().prepareStatement(use);
        pst.setString(1, nome);
        ResultSet resultUser = pst.executeQuery();
        while (resultUser.next()) {            
            this.nome = resultUser.getString("nm_func");
            this.matricula = resultUser.getInt("id_func");
        }
         
        pst.close();
        con.Close();
        if(nome.equals(this.nome)){
            return String.valueOf(matricula);
        }
        else{
            return null;
        }
    }

    public void cadastrar(FuncionarioDao fun) throws Exception{
        String use = "INSERT INTO tb_funcionario (id_func, nm_func, senha_func, permissao) VALUES(?,?,?,?);";
        pst = con.Conection().prepareStatement(use);
        pst.setInt(1, fun.getMatricula());
        pst.setString(2, fun.getNome());
        pst.setString(3, fun.getSenha());
        pst.setBoolean(4, fun.isPermissao());
        pst.execute();
        pst.close();
        con.Close();
        
    }
    public void Deletar(FuncionarioDao fun) throws Exception{
        String sql = "DELETE FROM tb_funcionario WHERE id_func = ?;";
        pst = con.Conection().prepareStatement(sql);        
        pst.setLong(1,fun.getMatricula());
        pst.executeUpdate();
        pst.close();
        con.Close(); 
        
    }
    
}
