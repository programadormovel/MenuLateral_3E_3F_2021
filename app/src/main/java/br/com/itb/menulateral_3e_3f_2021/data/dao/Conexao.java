package br.com.itb.menulateral_3e_3f_2021.data.dao;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Classe para conectar no Banco de Dados externo
public class Conexao {

    // Método estático de conexão com o banco de dados externo
    public static Connection conectar() {
        // 192.168.0.167 - ip do servidor
        // PRAP3-2021.mssql.somee.com - ip do servidor somee.com remoto

        // TODO - FINALIZAR CLASSE DE CONEXÃO
        Connection conexao = null;

        try{
            // Libera políticas de segurança
            StrictMode.ThreadPolicy policy;
            policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);

            // Verificar se o driver de conexão esta importado
            Class.forName("net.sourceforge.jtds.jdbc.Driver");

            // Estabelecer conexão com o banco de dados externo 192.168.0.200
            conexao = DriverManager.getConnection("" +
                    "jdbc:jtds:sqlserver://PRAP3AB.mssql.somee.com;" +
                    "databaseName=PRAP3AB;user=teste3ab;password=master33##");

            /*conexao = DriverManager.getConnection("" +
                    "jdbc:jtds:sqlserver://192.168.0.200;" +
                    "databaseName=PRAP3_2021;user=sa;password=123456");*/
        }catch (SQLException | ClassNotFoundException e){
            e.getMessage();
        }

        return conexao;
    }

}
