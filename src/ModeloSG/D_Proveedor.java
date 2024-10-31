/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloSG;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Dennis
 */
public class D_Proveedor {
    
     public List<E_Proveedor> obtenerListadoProveedores() throws SQLException {
        List<E_Proveedor> proveedores = new ArrayList<>();
        String query = "SELECT ProveedorID, TipoDeDoc, RazonSocial, NombresApellidos, Celular, Email FROM Proveedores";

        try (Connection conn = Conexion.getInstancia().crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                E_Proveedor proveedor = new E_Proveedor(
                    rs.getString("TipoDeDoc"),
                    rs.getString("RazonSocial"),
                    rs.getString("NombresApellidos"),
                    rs.getString("Celular"),
                    rs.getString("Email")
                );
                proveedor.setProveedorID(rs.getInt("ProveedorID"));
                proveedores.add(proveedor);
            }
        }
        return proveedores;
    }

    public void agregarProveedor(E_Proveedor proveedor) throws SQLException {
        String query = "INSERT INTO Proveedores (TipoDeDoc, RazonSocial, NombresApellidos, Celular, Email) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexion.getInstancia().crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, proveedor.getTipoDeDoc());
            stmt.setString(2, proveedor.getRazonSocial());
            stmt.setString(3, proveedor.getNombresApellidos());
            stmt.setString(4, proveedor.getCelular());
            stmt.setString(5, proveedor.getEmail());
            stmt.executeUpdate();
        }
    }

    public void actualizarProveedor(E_Proveedor proveedor) throws SQLException {
        String query = "UPDATE Proveedores SET TipoDeDoc = ?, RazonSocial = ?, NombresApellidos = ?, Celular = ?, Email = ? WHERE ProveedorID = ?";

        try (Connection conn = Conexion.getInstancia().crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, proveedor.getTipoDeDoc());
            stmt.setString(2, proveedor.getRazonSocial());
            stmt.setString(3, proveedor.getNombresApellidos());
            stmt.setString(4, proveedor.getCelular());
            stmt.setString(5, proveedor.getEmail());
            stmt.setInt(6, proveedor.getProveedorID());
            stmt.executeUpdate();
        }
    }

   public void eliminarProveedor(int proveedorID) throws SQLException {
    String sql = "DELETE FROM Proveedores WHERE ProveedorID = ?";
    try (Connection conn = Conexion.getInstancia().crearConexion();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, proveedorID);
        stmt.executeUpdate();
    }
    }
    
}
