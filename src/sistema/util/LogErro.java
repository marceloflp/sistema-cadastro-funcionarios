/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.SQLException;

/**
 *
 * @author marcelo
 */
public class LogErro {
    
    private static final DateTimeFormatter FORMATO =
        DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public static void erro(String operacao, String mensagem, SQLException ex) {

        System.err.println("\n");
        System.err.println("==================================================");
        System.err.println("[ERRO] " + LocalDateTime.now().format(FORMATO));
        System.err.println("Operação: " + operacao);
        System.err.println("Descrição: " + mensagem);
        System.err.println("Detalhes: " + ex.getMessage());
        System.err.println("SQLState: " + ex.getSQLState());
        System.err.println("==================================================");
    }
    
}
