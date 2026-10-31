/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.controller;

import java.sql.Connection;
import java.sql.SQLException;
import sistema.model.dao.Conexao;
import sistema.model.dao.LoginDAO;
import sistema.view.CadastroView;
import sistema.view.LoginView;

/**
 *
 * @author marcelo
 */
public class LoginController {
    
    
    public void cadastroUsuario(CadastroView view) throws SQLException{
        
        Connection conexao = new Conexao().getConnection();
        LoginDAO cadastro = new LoginDAO();
        
        cadastro.cadastrarUsuario(view.getjTextFieldNome().getText(), view.getjTextFieldEmail().getText(), view.getjPasswordFieldSenha().getText());
 
    }
    
    public void loginUsuario(LoginView view) throws SQLException{
        
        Connection conexao = new Conexao().getConnection();
        LoginDAO login = new LoginDAO();
        
        login.login(view.getjTextFieldEmail().getText(), view.getjPasswordFieldSenha().getText());
    }
    
}
