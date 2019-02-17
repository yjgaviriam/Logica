/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import windows.Principal;

/**
 * Clase que arranca la aplicacion con la interfaz principal
 *
 * @author xJoni
 * @version 1.0
 */
public class ApplicationFL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                Principal principal = new Principal();
                principal.setVisible(true);
                principal.setLocationRelativeTo(null);
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                Logger.getLogger(ApplicationFL.class.getName()).log(Level.SEVERE, "Problemas para arrancar la aplicación.", ex);
                JOptionPane.showMessageDialog(null, "Problemas para arrancar la aplicación.");
            }
        });
    }
}
