/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloSG;

import ModeloSG.Conexion;
import java.sql.Connection;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Dennis
 */
public class Main { 
    public static void main(String[] args) {
//        Conexion conexion = Conexion.getInstancia();
//        Connection conn = conexion.crearConexion();
//        
//        if (conn != null) {
//            System.out.println("Conexión exitosa a la base de datos.");
//            // Aquí puedes ejecutar tus consultas
//        } else {
//            System.out.println("Error en la conexión.");
//        }
        
        try (XSSFWorkbook workbook = new XSSFWorkbook()) {
            System.out.println("Apache POI inicializado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
} 
