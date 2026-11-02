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
    
    private final String URL = "jdbc:postgresql://localhost:5433/db_aplicacao";
    private final String userDB = "postgres";
    private final String passDB = "admin";
            
    
    public Connection getConnection() throws SQLException{
        Connection conexao = DriverManager.getConnection(URL, userDB, passDB);
        
        criarTabelas(conexao);
        
        return conexao;
    }
    
    public void criarTabelas(Connection conexao) {
        String sqlUsuarios = "CREATE TABLE IF NOT EXISTS usuarios ("
                   + "id_user BIGSERIAL PRIMARY KEY, "
                   + "nome VARCHAR(80) NOT NULL, "
                   + "email VARCHAR(180) NOT NULL UNIQUE, "
                   + "senha_hash CHAR(64) NOT NULL"
                   + ");";
        
        String sqlFuncionarios = "CREATE TABLE IF NOT EXISTS funcionarios ("
               + "id_funcionario BIGSERIAL PRIMARY KEY, "
               + "nome_completo VARCHAR(120) NOT NULL, "
               + "data_admissao DATE NOT NULL, "
               + "salario NUMERIC(10, 2) NOT NULL, "
               + "status BOOLEAN NOT NULL DEFAULT TRUE"
               + ");";  
        
        try (Statement stmt = conexao.createStatement()) {
            stmt.execute(sqlUsuarios);
            stmt.execute(sqlFuncionarios);
        } catch (SQLException e) {
            System.err.println("Erro ao criar a tabela: " + e.getMessage());
        }
    }
    
}
