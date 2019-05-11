package Controller;
import Modal.FuncionarioDao;

public class Funcionario {
    
    public static FuncionarioDao getFuncionario(String user, String pass) throws Exception{
        FuncionarioDao fun = new FuncionarioDao();
        
        return fun.getFuncionario(user, pass);
    }
    
    public static void FuncCadastrar(String nome, String senha, int matricula, boolean permissao) throws Exception{
        FuncionarioDao fun = new FuncionarioDao();        
        fun.setNome(nome);
        fun.setSenha(senha);
        fun.setMatricula(matricula);
        fun.setPermissao(permissao);
        fun.cadastrar(fun);
    }
   public static void FuncDeletar(String nome, String senha, int matricula, boolean permissao) throws Exception{
        FuncionarioDao fun = new FuncionarioDao();        
        fun.setNome(nome);
        fun.setSenha(senha);
        fun.setMatricula(matricula);
        fun.setPermissao(permissao);
        fun.Deletar(fun);
   }
   
}
