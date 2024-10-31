/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloSG;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import ModeloSG.E_Producto;
/**
 *
 * @author Dennis
 */
public class D_Producto {
    public static List<E_Producto> listarProductos() throws SQLException {
        List<E_Producto> productos = new ArrayList<>();
        String query = "SELECT p.ProductoID, p.Nombre, p.PrecioVenta, "
                     + "c.Nombre AS NombreCategoria, pr.RazonSocial AS NombreProveedor "
                     + "FROM Producto p "
                     + "JOIN Categoria c ON p.CategoriaID = c.CategoriaID "
                     + "JOIN Proveedores pr ON p.ProveedorID = pr.ProveedorID";
        
        try (Connection conn = Conexion.getInstancia().crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                E_Producto producto = new E_Producto();
                producto.setProductoID(rs.getInt("ProductoID"));
                producto.setNombre(rs.getString("Nombre"));
                producto.setPrecioVenta(rs.getDouble("PrecioVenta"));
                producto.setNombreCategoria(rs.getString("NombreCategoria")); // Para mostrar en la lista
                producto.setNombreProveedor(rs.getString("NombreProveedor")); // Para mostrar en la lista
                productos.add(producto);
            }
        }
        
        return productos;
    }
      public void agregarProducto(E_Producto producto) throws SQLException {
        String query = "INSERT INTO Producto (Nombre, PrecioVenta, CategoriaID, ProveedorID) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = Conexion.getInstancia().crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, producto.getNombre());
            stmt.setDouble(2, producto.getPrecioVenta());
            stmt.setInt(3, producto.getCategoriaID());
            stmt.setInt(4, producto.getProveedorID());
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    // Método en el DAO para actualizar un producto
public void actualizarProducto(E_Producto producto) throws SQLException {
    String sql = "UPDATE Producto SET Nombre = ?, PrecioVenta = ?, CategoriaID = ?, ProveedorID = ? WHERE ProductoID = ?";
    try (Connection conexion = DatabaseConnection.getConnection();
         PreparedStatement ps = conexion.prepareStatement(sql)) {
        ps.setString(1, producto.getNombre());
        ps.setDouble(2, producto.getPrecioVenta());
        ps.setInt(3, producto.getCategoriaID());
        ps.setInt(4, producto.getProveedorID());
        ps.setInt(5, producto.getProductoID());
        ps.executeUpdate();
    }
}

// Método en el DAO para eliminar un producto
public void eliminarProducto(int productoID) throws SQLException {
    String sql = "DELETE FROM Producto WHERE ProductoID = ?";
    try (Connection conexion = DatabaseConnection.getConnection();
         PreparedStatement ps = conexion.prepareStatement(sql)) {
        ps.setInt(1, productoID);
        ps.executeUpdate();
    }
}
    
}
