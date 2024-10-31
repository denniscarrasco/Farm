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
public class D_Cliente {
     private final Conexion conexion;
    private static final String INSERT_CLIENTE_SQL = "INSERT INTO Cliente (Nombre, Apellidos, DNI, Direccion, Telefono, CorreoElectronico) VALUES (?, ?, ?, ?, ?, ?)";

    public D_Cliente() {
        this.conexion = Conexion.getInstancia();
    }
    
    
    public List<E_Cliente> listadoClientes() throws SQLException {
        List<E_Cliente> clientes = new ArrayList<>();
        String query = "SELECT ClienteID, Nombre, Apellidos, DNI, Direccion, Telefono, CorreoElectronico FROM Cliente";
        
        try (Connection conn = conexion.crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                E_Cliente cliente = new E_Cliente(
                        rs.getInt("ClienteID"),
                        rs.getString("Nombre"),
                        rs.getString("Apellidos"),
                        rs.getString("DNI"),
                        rs.getString("Direccion"),
                        rs.getString("Telefono"),
                        rs.getString("CorreoElectronico")
                );
                clientes.add(cliente);
            }
        }
        return clientes;
    }
    public void agregarCliente(E_Cliente cliente) throws SQLException {
        try (Connection conexion = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = conexion.prepareStatement(INSERT_CLIENTE_SQL)) {
            
            preparedStatement.setString(1, cliente.getNombre());
            preparedStatement.setString(2, cliente.getApellidos());
            preparedStatement.setString(3, cliente.getDni());
            preparedStatement.setString(4, cliente.getDireccion());
            preparedStatement.setString(5, cliente.getTelefono());
            preparedStatement.setString(6, cliente.getCorreoElectronico());
            
            preparedStatement.executeUpdate();
        }
    }
    
 public void actualizar(E_Cliente cliente) throws SQLException {
        String sql = "UPDATE Cliente SET Nombre = ?, Apellidos = ?, DNI = ?, Direccion = ?, Telefono = ?, CorreoElectronico = ? WHERE ClienteID = ?";
        
        try (Connection conn = Conexion.getInstancia().crearConexion(); // Asegúrate de que este método esté bien definido
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellidos());
            stmt.setString(3, cliente.getDni());
            stmt.setString(4, cliente.getDireccion());
            stmt.setString(5, cliente.getTelefono());
            stmt.setString(6, cliente.getCorreoElectronico());
            stmt.setInt(7, cliente.getClienteID()); // Asumiendo que tienes el método getClienteID en tu entidad

            stmt.executeUpdate(); // Ejecuta la actualización
        }
    }
 
 public void eliminarCliente(int clienteID) throws SQLException {
    String query = "DELETE FROM Cliente WHERE ClienteID = ?";
    
    try (Connection conn = Conexion.getInstancia().crearConexion();
         PreparedStatement stmt = conn.prepareStatement(query)) {
        
        stmt.setInt(1, clienteID);
        stmt.executeUpdate(); // Ejecutar la eliminación
    }
}
 
 
}
