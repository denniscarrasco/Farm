/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author Dennis
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        setExtendedState(Menu.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        MnProductos = new javax.swing.JMenuItem();
        MnCategoria = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        MnCliente = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        MnProveedor = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MENU PRINCIPAL");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(102, 102, 255));
        setSize(new java.awt.Dimension(1000, 1400));

        jMenu1.setText("GESTION DE PRODUCTOS");

        MnProductos.setText("PRODUCTOS");
        MnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnProductosActionPerformed(evt);
            }
        });
        jMenu1.add(MnProductos);

        MnCategoria.setText("CATEGORIA");
        MnCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnCategoriaActionPerformed(evt);
            }
        });
        jMenu1.add(MnCategoria);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("GESTION DE CLIENTES");

        MnCliente.setText("CLIENTE");
        MnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnClienteActionPerformed(evt);
            }
        });
        jMenu2.add(MnCliente);

        jMenuBar1.add(jMenu2);

        jMenu7.setText("REGISTRO");

        MnProveedor.setText("PROVEEDORES");
        MnProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnProveedorActionPerformed(evt);
            }
        });
        jMenu7.add(MnProveedor);

        jMenuItem7.setText("ENTRADA DE PRODUCTOS");
        jMenu7.add(jMenuItem7);

        jMenuItem8.setText("SALIDA DE PRODUCTOS");
        jMenu7.add(jMenuItem8);

        jMenuBar1.add(jMenu7);

        jMenu4.setText("VENTAS");

        jMenuItem9.setText("VENTA DE PRODUCTOS");
        jMenu4.add(jMenuItem9);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("REPORTES");
        jMenuBar1.add(jMenu5);

        jMenu6.setText("CONFIGURACION");

        jMenuItem10.setText("USUARIOS");
        jMenu6.add(jMenuItem10);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 694, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 386, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnProductosActionPerformed
        // TODO add your handling code here:
         PRODUCTO proForm = new PRODUCTO();
        proForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
        proForm.setAlwaysOnTop(true);  
         proForm.setVisible(true);  
    }//GEN-LAST:event_MnProductosActionPerformed

    private void MnCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnCategoriaActionPerformed
        // TODO add your handling code here:
   

        CATEGORIA catesForm = new CATEGORIA();
        catesForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
        catesForm.setAlwaysOnTop(true);  
         catesForm.setVisible(true);  

    }//GEN-LAST:event_MnCategoriaActionPerformed

    private void MnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnClienteActionPerformed
        // TODO add your handling code here:
        CLIENTES cliForm = new CLIENTES();
        cliForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
        cliForm.setAlwaysOnTop(true);  
         cliForm.setVisible(true);  
    }//GEN-LAST:event_MnClienteActionPerformed

    private void MnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnProveedorActionPerformed
        // TODO add your handling code here:
          PROVEEDOR proForm = new PROVEEDOR();
        proForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
        proForm.setAlwaysOnTop(true);  
         proForm.setVisible(true);  
    }//GEN-LAST:event_MnProveedorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MnCategoria;
    private javax.swing.JMenuItem MnCliente;
    private javax.swing.JMenuItem MnProductos;
    private javax.swing.JMenuItem MnProveedor;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    // End of variables declaration//GEN-END:variables
}
