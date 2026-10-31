/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author marcelo
 */
public class Conexao {
    
    private final String URL = "jdbc:postgresql://localhost:5432/db_aplicacao";
    private final String userDB = "postgres";
    private final String passDB = "admin";
            
    
    public Connection getConnection() throws SQLException{
        Connection conexao = DriverManager.getConnection(URL, userDB, passDB);
        
        criarTabelas(conexao);
        
        return conexao;
    }
    
    public void criarTabelas(Connection conexao) {
        String sql = "CREATE TABLE IF NOT EXISTS usuarios ("
                   + "id_user BIGSERIAL PRIMARY KEY, "
                   + "nome VARCHAR(80) NOT NULL, "
                   + "email VARCHAR(180) NOT NULL UNIQUE, "
                   + "senha_hash CHAR(64) NOT NULL"
                   + ");";
        

        try (Statement stmt = conexao.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela 'usuarios' verificada/criada com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao criar a tabela: " + e.getMessage());
        }
    }
    
}
