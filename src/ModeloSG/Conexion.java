/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloSG;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private String base;
    private String servidor;
    private static Conexion con = null;

    private Conexion() {
        this.base = "Dbsgfarma"; // Nombre de la base de datos
        this.servidor = "DESKTOP-GNHI12B\\MSSQLSERVER01"; // Nombre del servidor
    }

    public Connection crearConexion() {
        Connection conexion = null;
        try {
            // Cargar el controlador SQL Server
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Cadena de conexión usando autenticación SQL Server
            String url = "jdbc:sqlserver://" + this.servidor + ";databaseName=" + this.base + ";user=sa;password=root;encrypt=true;trustServerCertificate=true;";

            // Crear conexión
            conexion = DriverManager.getConnection(url);
            System.out.println("Conexión establecida con éxito a la base de datos");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se encontró el controlador SQL Server.");
            e.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("Error en la conexión con la base de datos.");
            ex.printStackTrace(); // Manejo de excepciones
        }
        return conexion;
    }

    public static Conexion getInstancia() {
        if (con == null) {
            con = new Conexion();
        }
        return con;
    }


//    public static void main(String[] args) {
//        Conexion conexion = Conexion.getInstancia();
//        Connection conn = conexion.crearConexion();
//        
//        if (conn != null) {
//            System.out.println("Conexión exitosa a la base de datos.");
//            // Aquí puedes ejecutar tus consultas
//        } else {
//            System.out.println("Error en la conexión.");
//        }
//    }
}