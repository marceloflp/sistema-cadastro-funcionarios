/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.controller;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import sistema.model.dao.Conexao;
import sistema.model.dao.LoginDAO;
import sistema.util.LogErro;
import sistema.view.CadastroView;
import sistema.view.LoginView;

/**
 *
 * @author marcelo
 */
public class LoginController {
    
    
    public void cadastroUsuario(CadastroView view){
        
        try {
            Connection conexao = new Conexao().getConnection();
            LoginDAO cadastro = new LoginDAO();
        
            cadastro.cadastrarUsuario(view.getjTextFieldNome().getText(), view.getjTextFieldEmail().getText(), view.getjPasswordFieldSenha().getText());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Erro ao fazer cadastrar usuário.\n"
                    + "Verifique a conexão com banco de dados", "Problema com a conexão", JOptionPane.ERROR_MESSAGE);
            LogErro.erro(
            "CADASTRO",
            "Não foi possível realizar cadastro de usuário.",
            ex);
        }
 
    }
    
    public boolean loginUsuario(LoginView view){
        
        try {
            Connection conexao = new Conexao().getConnection();
            LoginDAO login = new LoginDAO();
            return login.login(view.getjTextFieldEmail().getText(), view.getjPasswordFieldSenha().getText());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Erro ao fazer login.\n"
                    + "Verifique a conexão com banco de dados", "Problema com a conexão", JOptionPane.ERROR_MESSAGE);
            LogErro.erro(
            "LOGIN",
            "Não foi possível realizar a autenticação.",
            ex);
        }
        
        return false;
        
    }
    
}
