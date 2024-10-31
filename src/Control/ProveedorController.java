/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import ModeloSG.Conexion;
import ModeloSG.D_Proveedor;
import ModeloSG.E_Proveedor;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author Dennis
 */
public class ProveedorController {

    private D_Proveedor dao;

    public ProveedorController() {
        dao = new D_Proveedor();
    }

    public List<E_Proveedor> obtenerListadoProveedores() throws SQLException {
        return dao.obtenerListadoProveedores();
    }

    public void agregarProveedor(String tipoDeDoc, String razonSocial, String nombresApellidos, String celular, String email) throws SQLException {
        E_Proveedor proveedor = new E_Proveedor(tipoDeDoc, razonSocial, nombresApellidos, celular, email);
        dao.agregarProveedor(proveedor);
    }

    public void actualizarProveedor(int proveedorID, String tipoDeDoc, String razonSocial, String nombresApellidos, String celular, String email) throws SQLException {
        E_Proveedor proveedorActualizado = new E_Proveedor(tipoDeDoc, razonSocial, nombresApellidos, celular, email);
        proveedorActualizado.setProveedorID(proveedorID);
        dao.actualizarProveedor(proveedorActualizado);
    }

    public void eliminarProveedor(int proveedorID) throws SQLException {
        dao.eliminarProveedor(proveedorID);
    }

    public List<String> obtenerNombresProveedores() throws SQLException {
        List<String> proveedores = new ArrayList<>();
        String sql = "SELECT RazonSocial FROM Proveedores"; // Ajusta la consulta según tu tabla

        try (Connection conn = Conexion.getInstancia().crearConexion(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                proveedores.add(rs.getString("RazonSocial"));
            }
        }
        return proveedores;
    }
      public int obtenerIdProveedorPorNombre(String nombreProveedor) throws SQLException {
        int proveedorID = -1; // Valor por defecto si no se encuentra
        String sql = "SELECT ProveedorID FROM Proveedores WHERE RazonSocial= ?";
        
        try (Connection conn = Conexion.getInstancia().crearConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, nombreProveedor);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                proveedorID = rs.getInt("ProveedorID");
            }
        }
        
        return proveedorID;
    }

}
