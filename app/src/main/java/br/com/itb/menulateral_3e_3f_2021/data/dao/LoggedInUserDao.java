package br.com.itb.menulateral_3e_3f_2021.data.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.itb.menulateral_3e_3f_2021.data.Result;
import br.com.itb.menulateral_3e_3f_2021.data.model.LoggedInUser;

public class LoggedInUserDao {

    public static LoggedInUser verificarUsuario(String usuario,
                                                String senha){
        LoggedInUser login = null;

        // Consultar banco de dados (login)
        try{
            // Comando ou declaração SQL
            String declaracao = "select id, conta, senha, nome, email, nivel_acesso " +
                    "from login " +
                    "where email = ? and senha = ?;";
            // Prepara o objeto de execução do comando para conectar no banco
            PreparedStatement pst = Conexao.conectar().prepareStatement(declaracao);
            // Realizar passagem de parâmetros
            pst.setString(1, usuario);
            pst.setString(2, senha);
            // Realizar execução e aguardar retorno
            ResultSet res = pst.executeQuery();
            // Verifico se o resultSet esta vivo
            if(res != null){
                while (res.next()){
                    login = new LoggedInUser(
                            String.valueOf(res.getInt(1)),
                            res.getString(4));
                }
            }

        }catch (SQLException e){
            e.getMessage();
        }

        return login;
    }

    public static LoggedInUser inserirUsuario(LoggedInUser usuario){
        int retorno = 0;

        try {
            String declaracao = "Insert Into login " +
                    "(conta, senha, nome, email, nivel_acesso) " +
                    " values (?, ?, ?, ?, ?);";
            PreparedStatement pst = Conexao.conectar().prepareStatement(declaracao);
            // Passagem de Parâmetros
            pst.setString(1, usuario.getConta());
            pst.setString(2, usuario.getSenha());
            pst.setString(3, usuario.getDisplayName());
            pst.setString(4, usuario.getEmail());
            pst.setInt(5, 1);
            // Execução da declaração
            pst.executeUpdate();
            retorno = 1;
            // Para retornar valor do ID inserido no banco de dados
            pst = Conexao.conectar().prepareStatement("Select id from login " +
                    "where email = ?;");
            pst.setString(1, usuario.getEmail());
            ResultSet res = pst.executeQuery();
            if(res!=null){
                while (res.next()){
                    usuario.setUserId(String.valueOf(res.getInt(1)));
                }
            }

            return usuario;
        }catch (SQLException e){
            e.getMessage();
        }

        return null;
    }
}
