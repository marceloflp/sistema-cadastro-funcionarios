/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import sistema.view.LoginView;

/**
 *
 * @author marcelo
 */
public class Main {
    public static void main(String[] args) {
        // Para padronizar o visual dos componentes
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }

        // Abre a tela de login
        java.awt.EventQueue.invokeLater(() -> new LoginView().setVisible(true));
    }
}
