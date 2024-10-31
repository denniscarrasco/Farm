/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Control;
import Vista.CATEGORIA;
import javax.swing.*;
/**
 *
 * @author Dennis
 */
public class SgFar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Gestión de Categorías");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.add(new Vista.CATEGORIA()); // Agrega tu formulario de categorías aquí
            frame.setVisible(true);
              });
        
    }
    
}
