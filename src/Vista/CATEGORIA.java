/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Control.CategoriaController;
import ModeloSG.D_Categoria;
import ModeloSG.E_Categoria;
import java.io.File;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Dennis
 */
public class CATEGORIA extends javax.swing.JFrame {

    private int categoriaIdSeleccionada = -1;

    /**
     * Creates new form CLIENTES
     */
    public CATEGORIA() {
        initComponents();
        setLocationRelativeTo(null);
//         

        listarCategorias("");
        btnActualizar.setEnabled(false);

        txtCategoria.setEnabled(false);
        txtDescripcion.setEnabled(false);
        btnGrabar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnGenerarReporte.setEnabled(false);

    }

    void habilitarnuevo(boolean ver) {
        txtCategoria.setEnabled(ver);
        txtDescripcion.setEnabled(ver);
        btnGrabar.setEnabled(ver);
        btnCancelar.setEnabled(ver);
    }

    private void generarExcel(List<E_Categoria> listaCategorias) {

        Workbook workbook = new XSSFWorkbook(); // Crear un libro de trabajo
        Sheet sheet = workbook.createSheet("Categorías"); // Crear una hoja

        // Crear la fila de encabezado
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("CODCATEGORIA");
        headerRow.createCell(1).setCellValue("Nombre");
        headerRow.createCell(2).setCellValue("Descripción");

        // Llenar la hoja con datos de categorías
        int rowNum = 1;
        if (listaCategorias != null && !listaCategorias.isEmpty()) {
            for (E_Categoria categoria : listaCategorias) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(categoria.getCategoriaID());
                row.createCell(1).setCellValue(categoria.getNombre());
                row.createCell(2).setCellValue(categoria.getDescripcion());
            }
        } else {
            System.out.println("La lista de categorías está vacía o es nula.");
        }

        // Usar JFileChooser para seleccionar la ubicación del archivo
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar archivo Excel");
        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            // Comprobar si el archivo tiene extensión .xlsx, si no, agregarla
            String filePath = fileToSave.getAbsolutePath();
            if (!filePath.toLowerCase().endsWith(".xlsx")) {
                filePath += ".xlsx";
            }

            // Escribir el archivo Excel
            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
                System.out.println("Excel generado exitosamente en " + filePath);
            } catch (IOException e) {
                System.err.println("Error al generar el archivo Excel: " + e.getMessage());
                e.printStackTrace();
            }
        }

        // Cerrar el workbook
        try {
            workbook.close(); // Cerrar el libro de trabajo
        } catch (IOException e) {
            System.err.println("Error al cerrar el libro de trabajo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void listarCategorias(String cTexto) {
        try {
            CategoriaController o = new CategoriaController();
            List<E_Categoria> lista = o.obtenerListadoCa(cTexto); // Método que obtiene todas las categorías
            mostrarResultados(lista);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar las categorías: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrarResultados(List<E_Categoria> lista) {
        DefaultTableModel model = (DefaultTableModel) TCategoria.getModel(); // Obtener el modelo de la tabla
        model.setRowCount(0); // Limpiar resultados anteriores

        for (E_Categoria categoria : lista) {
            model.addRow(new Object[]{categoria.getCategoriaID(), categoria.getNombre(), categoria.getDescripcion()}); // Agregar filas a la tabla
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        PLISTADO = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TCategoria = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnGenerarReporte = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        txtCategoria = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        btnGrabar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CATEGORIA");
        setFont(new java.awt.Font("Agency FB", 1, 10)); // NOI18N

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));

        PLISTADO.setBackground(new java.awt.Color(255, 255, 255));
        PLISTADO.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        TCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, ""},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "CODCATEGORIA", "CATEGORIA", "DESCRIPCION"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TCategoria.setName("TCategoria"); // NOI18N
        TCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TCategoriaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TCategoria);
        if (TCategoria.getColumnModel().getColumnCount() > 0) {
            TCategoria.getColumnModel().getColumn(0).setResizable(false);
            TCategoria.getColumnModel().getColumn(1).setResizable(false);
            TCategoria.getColumnModel().getColumn(2).setResizable(false);
        }

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        jLabel7.setText("BUSCAR");

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnGenerarReporte.setText("REPORTE");
        btnGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteActionPerformed(evt);
            }
        });

        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnNuevo.setText("NUEVO");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        jLabel10.setText("CATEGORIA");

        jLabel9.setText("DESCRIPCION");

        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnGrabar.setText("GRABAR");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PLISTADOLayout = new javax.swing.GroupLayout(PLISTADO);
        PLISTADO.setLayout(PLISTADOLayout);
        PLISTADOLayout.setHorizontalGroup(
            PLISTADOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PLISTADOLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(PLISTADOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PLISTADOLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PLISTADOLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PLISTADOLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnGrabar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(PLISTADOLayout.createSequentialGroup()
                .addGroup(PLISTADOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PLISTADOLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PLISTADOLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnNuevo)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)
                        .addGap(26, 26, 26)
                        .addComponent(btnGenerarReporte)
                        .addGap(33, 33, 33)
                        .addComponent(btnSalir)))
                .addContainerGap(518, Short.MAX_VALUE))
        );
        PLISTADOLayout.setVerticalGroup(
            PLISTADOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PLISTADOLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PLISTADOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(PLISTADOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PLISTADOLayout.createSequentialGroup()
                        .addGroup(PLISTADOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PLISTADOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(PLISTADOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGrabar)
                            .addComponent(btnActualizar)
                            .addComponent(btnCancelar))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PLISTADOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PLISTADOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEliminar)
                        .addComponent(btnGenerarReporte)
                        .addComponent(btnNuevo))
                    .addComponent(btnSalir))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("LISTADO ", PLISTADO);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 923, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(204, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        // String nombre = txtCategoria.getText();
        String nombre = txtCategoria.getText().trim(); // Asegúrate de usar trim para quitar espacios
        String descripcion = txtDescripcion.getText().trim();

        if (nombre.isEmpty() || descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            CategoriaController controller = new CategoriaController();
            controller.agregarCategoria(nombre, descripcion);
            JOptionPane.showMessageDialog(this, "Categoría agregada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            // Actualiza la lista de categorías
            listarCategorias("");

            // Limpia ambos campos de texto
            txtCategoria.setText(""); // Limpia el campo de nombre
            txtDescripcion.setText(""); // Limpia el campo de descripción
        } catch (SQLException e) {
            e.printStackTrace(); // Imprime el error para el diagnóstico
            JOptionPane.showMessageDialog(this, "Error al agregar la categoría: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void TCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TCategoriaMouseClicked

        if (evt.getClickCount() == 2) {
            int row = TCategoria.getSelectedRow();
            if (row != -1) {
                categoriaIdSeleccionada = (int) TCategoria.getValueAt(row, 0); // Suponiendo que el ID es la primera columna
                String nombre = (String) TCategoria.getValueAt(row, 1);
                String descripcion = (String) TCategoria.getValueAt(row, 2);

                // Llena los campos de texto
                txtCategoria.setText(nombre);
                txtDescripcion.setText(descripcion);
                habilitarnuevo(true);
                btnActualizar.setEnabled(true);
                 btnEliminar.setEnabled(true);
                btnGrabar.setEnabled(false);

            }
        }


    }//GEN-LAST:event_TCategoriaMouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        String nombre = txtCategoria.getText();
        String descripcion = txtDescripcion.getText();

        if (nombre == null || nombre.trim().isEmpty() || descripcion == null || descripcion.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Verifica que se haya seleccionado una categoría para actualizar
            if (categoriaIdSeleccionada == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione una categoría para actualizar.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            CategoriaController controller = new CategoriaController();
            controller.actualizarCategoria(categoriaIdSeleccionada, nombre, descripcion);
            JOptionPane.showMessageDialog(this, "Categoría actualizada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            listarCategorias(""); // Actualiza la lista de categorías
            txtCategoria.setText(""); // Limpia el campo de nombre
            txtDescripcion.setText(""); // Limpia el campo de descripción
            categoriaIdSeleccionada = -1; // Reinicia la selección
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al actualizar la categoría: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if (categoriaIdSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una categoría para eliminar(doble click).", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea eliminar esta categoría?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                CategoriaController controller = new CategoriaController();
                controller.eliminarCategoria(categoriaIdSeleccionada);
                JOptionPane.showMessageDialog(this, "Categoría eliminada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                listarCategorias(""); // Actualiza la lista de categorías
                txtCategoria.setText(""); // Limpia el campo de nombre
                txtDescripcion.setText(""); // Limpia el campo de descripción
                categoriaIdSeleccionada = -1; // Reinicia la selección
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al eliminar la categoría: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteActionPerformed
        // TODO add your handling code here:
        D_Categoria dca = new D_Categoria();
        List<E_Categoria> categorias = dca.listadoCa("");// Llama a tu método para obtener la lista de categorías
        generarExcel(categorias); // Genera el Excel con la lista de categorías

    }//GEN-LAST:event_btnGenerarReporteActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:

        habilitarnuevo(true);

        btnNuevo.setEnabled(false);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:

        habilitarnuevo(false);
        btnNuevo.setEnabled(true);
        btnActualizar.setEnabled(false);

        txtCategoria.setText("");
        txtDescripcion.setText("");
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
         String textoBusqueda = txtBuscar.getText().toLowerCase(); // Obtener el texto en minúsculas
        DefaultTableModel modelo = (DefaultTableModel) TCategoria.getModel(); // Suponiendo que tu tabla tiene un DefaultTableModel
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo); // Crear un sorter para el modelo
        TCategoria.setRowSorter(sorter); // Asignar el sorter a la tabla

        // Filtrar basado en la búsqueda
        if (textoBusqueda.trim().length() == 0) {
            sorter.setRowFilter(null); // Si el campo está vacío, mostrar todas las filas
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + textoBusqueda)); // Filtrar insensiblemente a mayúsculas
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(CATEGORIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CATEGORIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CATEGORIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CATEGORIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CATEGORIA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PLISTADO;
    private javax.swing.JTable TCategoria;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGenerarReporte;
    private javax.swing.JButton btnGrabar;
    public javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtDescripcion;
    // End of variables declaration//GEN-END:variables
}
