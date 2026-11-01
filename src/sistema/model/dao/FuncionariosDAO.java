/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.model.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author marcelo
 */
public class FuncionariosDAO {
    
    public void cadastrarFuncionario(String nome, LocalDate dataAdmissao, BigDecimal salario, Boolean status) throws SQLException{
        
        String sql = "INSERT INTO funcionarios (nome_completo, data_admissao, salario, status) VALUES (?, ?, ?, ?)";

        try (Connection conexao = new Conexao().getConnection();
             PreparedStatement statement = conexao.prepareStatement(sql)) {

            statement.setString(1, nome);
            statement.setObject(2, dataAdmissao);
            statement.setBigDecimal(3, salario);
            statement.setBoolean(4, status);
            statement.executeUpdate();
            System.out.println("Funcionário cadastrado!");
        }
    }
}
