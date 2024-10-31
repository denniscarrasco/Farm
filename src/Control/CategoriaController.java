/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import ModeloSG.Conexion;
import ModeloSG.D_Categoria;
import ModeloSG.E_Categoria;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;

// apache poi
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 *
 * @author Dennis
 */
public class CategoriaController {

    private D_Categoria categoriaDAO;

    public CategoriaController() {
        this.categoriaDAO = new D_Categoria(); // Inicializa el DAO de Categoría
    }

    public List<E_Categoria> obtenerListadoCa(String cTexto) {
        return categoriaDAO.listadoCa(cTexto); // Llama al método del DAO para obtener la lista de categorías
    }

    public void agregarCategoria(String nombre, String descripcion) throws SQLException {
        E_Categoria nuevaCategoria = new E_Categoria(nombre, descripcion);
        categoriaDAO.agregarCategoria(nuevaCategoria);
    }

    public void actualizarCategoria(int id, String nombre, String descripcion) throws SQLException {
        D_Categoria dao = new D_Categoria();
        dao.actualizarCategoria(id, nombre, descripcion);
    }

    public void eliminarCategoria(int categoriaId) throws SQLException {
        D_Categoria dao = new D_Categoria();
        dao.eliminarCategoria(categoriaId); // Método que debes implementar en tu DAO
    }

    public List<String> obtenerNombresCategorias() {
        List<String> categorias = new ArrayList<>();
        String sql = "SELECT Nombre FROM Categoria";

        try (Connection conn = Conexion.getInstancia().crearConexion(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                categorias.add(rs.getString("Nombre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al obtener los nombres de categorías: " + e.getMessage());
        }
        return categorias;
    }
    public int obtenerIdCategoriaPorNombre(String nombreCategoria) throws SQLException {
        int categoriaID = -1; // Valor por defecto si no se encuentra
        String sql = "SELECT CategoriaID FROM Categoria WHERE Nombre = ?";
        
        try (Connection conn = Conexion.getInstancia().crearConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, nombreCategoria);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                categoriaID = rs.getInt("CategoriaID");
            }
        }
        
        return categoriaID;
    }
    
    
    
    public void generarReporte() {
        D_Categoria dca=new D_Categoria();
         List<E_Categoria> categorias = dca.listadoCa("");
        try {
            exportarCategorias(categorias);
            System.out.println("Reporte generado exitosamente!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al generar el reporte: " + e.getMessage());
        }
    }

    private void exportarCategorias(List<E_Categoria> categorias) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Categorias");

        // Crear encabezados
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("CategoriaID");
        headerRow.createCell(1).setCellValue("Nombre");
        headerRow.createCell(2).setCellValue("Descripcion");

        // Llenar datos
        int rowNum = 1;
        for (E_Categoria categoria : categorias) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(categoria.getCategoriaID());
            row.createCell(1).setCellValue(categoria.getNombre());
            row.createCell(2).setCellValue(categoria.getDescripcion());
        }

        // Escribir el archivo
        try (FileOutputStream outputStream = new FileOutputStream("Categorias.xlsx")) {
            workbook.write(outputStream);
        }
        workbook.close();
    }
    
    
}
