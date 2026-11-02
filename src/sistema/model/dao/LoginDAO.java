/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import sistema.util.Criptografia;

/**
 *
 * @author marcelo
 */
public class LoginDAO {
    
    public void cadastrarUsuario(String nome, String email, String senha) throws SQLException{
        
        String sql = "INSERT INTO usuarios (nome, email, senha_hash) VALUES (?, ?, ?)";
    
        String senhaCriptografada = Criptografia.criptografar(senha);
    
        try (Connection conexao = new Conexao().getConnection();
             PreparedStatement statement = conexao.prepareStatement(sql)) {

            statement.setString(1, nome);
            statement.setString(2, email);
            statement.setString(3, senhaCriptografada);        
            statement.executeUpdate();
            System.out.println("Usuário cadastrado!");
        }
        
    }
    
    public boolean login(String email, String senha) throws SQLException{
        String sql = "SELECT senha_hash FROM usuarios WHERE email = ?";
    
        String senhaCriptografada = Criptografia.criptografar(senha);
    
        try (Connection conexao = new Conexao().getConnection();
             PreparedStatement statement = conexao.prepareStatement(sql)) {

            statement.setString(1, email);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    String hashBanco = rs.getString("senha_hash");

                    if (hashBanco.equals(senhaCriptografada)) {
                        System.out.println("Login realizado com sucesso!");
                        return true; 
                    }
                }
                return false;
            }
        }
        
    }
    
}
