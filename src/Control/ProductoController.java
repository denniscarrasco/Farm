/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import ModeloSG.D_Producto;
import ModeloSG.E_Producto;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Dennis
 */
public class ProductoController {
    private D_Producto dao;

    public ProductoController() {
        dao = new D_Producto();
    }

    public List<E_Producto> obtenerListadoProductos() throws SQLException {
        return dao.listarProductos();
    }
    
  public void agregarProducto(String nombre, double precioVenta, int categoriaID, int proveedorID) throws SQLException {
        // Crea una instancia de E_Producto con los datos proporcionados
        E_Producto producto = new E_Producto(nombre, precioVenta, categoriaID, proveedorID);
        // Llama al método DAO para agregar el producto a la base de datos
        dao.agregarProducto(producto);
    }
  public void actualizarProducto(int productoID, String nombre, double precioVenta, int categoriaID, int proveedorID) throws SQLException {
    // Crea una instancia de E_Producto con los datos proporcionados
      E_Producto producto = new E_Producto(productoID, nombre, precioVenta, categoriaID, proveedorID);
    // Llama al método DAO para actualizar el producto en la base de datos
    dao.actualizarProducto(producto);
}

// Método para eliminar un producto de la base de datos
public void eliminarProducto(int productoID) throws SQLException {
    // Llama al método DAO para eliminar el producto en la base de datos
    dao.eliminarProducto(productoID);
}
    
}
