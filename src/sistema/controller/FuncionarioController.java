/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.controller;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import sistema.model.Funcionarios;
import sistema.model.dao.Conexao;
import sistema.model.dao.FuncionariosDAO;
import sistema.util.LogErro;
import sistema.view.CadastroFuncionariosView;

/**
 *
 * @author marcelo
 */
public class FuncionarioController {
    
    public boolean cadastroFuncionario(CadastroFuncionariosView view) {

        String nome = view.getjTextFieldNomeCompleto().getText().trim();
        String dataTexto = view.getjTextFieldDataAdmissao().getText().trim();
        String salarioTexto = view.getjTextFieldSalario().getText().trim();
        boolean ativo = view.getjCheckBoxFuncionarioAtivo().isSelected();

        if (nome.isEmpty() || dataTexto.isEmpty() || salarioTexto.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Preencha todos os campos.");
            return false;
        }

        try {
            LocalDate dataAdmissao = LocalDate.parse(dataTexto, Funcionarios.FORMATO_DATA);
            BigDecimal salario = new BigDecimal(salarioTexto.replace(".", "").replace(",", "."));

            if (salario.signum() < 0) {
                JOptionPane.showMessageDialog(view, "O salário não pode ser negativo.");
                return false;
            }

            new FuncionariosDAO().cadastrarFuncionario(nome, dataAdmissao, salario, ativo);
            return true;

        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(view, "Informe a data no formato dd/MM/aaaa.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Informe o salário no formato 4200,00.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Erro ao fazer cadastro de funcionário.\n"
                    + "Verifique a conexão com banco de dados", "Problema com a conexão", JOptionPane.ERROR_MESSAGE);
            LogErro.erro(
            "CADASTRO",
            "Não foi possível realizar cadastro de funcionário.",
            ex);
        }
        return false;
    }
    
    public List<Funcionarios> listarFuncionarios() throws SQLException {

        String sql = "SELECT nome_completo, data_admissao, salario, status "
                   + "FROM funcionarios ORDER BY nome_completo";

        List<Funcionarios> lista = new ArrayList<>();

        try (Connection conexao = new Conexao().getConnection();
             PreparedStatement statement = conexao.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                lista.add(new Funcionarios(
                    rs.getString("nome_completo"),
                    rs.getObject("data_admissao", LocalDate.class),
                    rs.getBigDecimal("salario"),
                    rs.getBoolean("status")));
            }
        }

        return lista;
    }
    
}
