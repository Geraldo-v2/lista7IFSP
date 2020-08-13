package util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sound.sampled.SourceDataLine;

import com.mysql.cj.jdbc.MysqlDataSource;

public class ConexaoBanco {

    private Connection conexao = null;
    private final String BANCO = "bancojava";   //troque pelo nome do seu database
    private final String LOGIN = "root";   //use o usuário do banco (default: root)
    private final String SENHA = "";      //se estiver sem senha deixe vazio: ""
    private final String HOST = "localhost"; //se o mysql estiver rodando localmente, use "localhost"

    public Connection getConnection() {
    try {

        MysqlDataSource ds = new MysqlDataSource();
        ds.setServerName(HOST);
        ds.setDatabaseName(BANCO);
        ds.setUser(LOGIN);
        ds.setPassword(SENHA);

        ds.setServerTimezone("UTC");
        ds.setConnectTimeout(8000);

        conexao = ds.getConnection();

        return conexao;
        
        }catch (SQLException e){
            System.out.println("falha na conexão com SQL"+e.getMessage());
        }
        return conexao;
    }
    
}