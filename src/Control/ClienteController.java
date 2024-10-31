/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import ModeloSG.Conexion;
import ModeloSG.D_Cliente;
import ModeloSG.E_Cliente;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author Dennis
 */
public class ClienteController {

    private final D_Cliente clienteDAO;

    public ClienteController() {
        this.clienteDAO = new D_Cliente();
    }

//    public List<E_Cliente> obtenerListadoClientes() throws SQLException {
//        return clienteDAO.listadoClientes();
//    }
    public List<E_Cliente> obtenerListadoClientes() throws SQLException {
        List<E_Cliente> listaClientes = new ArrayList<>();
        String query = "SELECT ClienteID, Nombre, Apellidos, DNI, Direccion, Telefono, CorreoElectronico FROM Cliente";

        try (Connection con = Conexion.getInstancia().crearConexion(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {

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
                listaClientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return listaClientes;
    }

    public void agregarCliente(E_Cliente cliente) throws SQLException {
        clienteDAO.agregarCliente(cliente);
    }

    public void actualizarCliente(int clienteId, String nombre, String apellidos, String dni, String direccion, String telefono, String correo) throws SQLException {
        D_Cliente dao = new D_Cliente();
        E_Cliente cliente = new E_Cliente(clienteId, nombre, apellidos, dni, direccion, telefono, correo); // Asegúrate de que el constructor en E_Cliente acepte el ID
        dao.actualizar(cliente); // Llama al método de actualización en el DAO
    }
public void eliminarCliente(int clienteID) throws SQLException {
    D_Cliente dao = new D_Cliente();
    dao.eliminarCliente(clienteID);
}
}
