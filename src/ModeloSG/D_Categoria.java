/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloSG;

import com.google.common.collect.ImmutableList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists; // Google Guava 
// **S** - Single Responsibility Principle (SRP): 
// La clase D_Categoria tiene una única responsabilidad: gestionar 
// la recuperación de categorías desde la base de datos. 

public class D_Categoria implements CategoriaRepository {

    private List<E_Categoria> categoriasTemp = Lists.newArrayList(); // Lista mutable de Guava

    public List<E_Categoria> listadoCa(String cTexto) {
        List<E_Categoria> lista = new ArrayList<>();
        String sql = "SELECT * FROM categoria"; // Consulta SQL para obtener todas las categorías.

        // Verifica si cTexto está vacío para construir la consulta SQL
        if (!cTexto.isEmpty()) {
            sql += " WHERE descripcion LIKE ?"; // Añade una cláusula WHERE si hay texto de búsqueda.
        }

        // **O** - Open/Closed Principle (OCP): 
        // La clase está abierta a la extensión (puedes añadir más métodos para diferentes 
        // tipos de consultas) pero cerrada a la modificación (no necesitas cambiar 
        // el código existente para añadir nuevas funcionalidades).
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            if (!cTexto.isEmpty()) {
                statement.setString(1, "%" + cTexto + "%"); // Evita inyección SQL al parametrizar.
            }
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    // **L** - Liskov Substitution Principle (LSP): 
                    // Aquí se asegura que cualquier subclase de E_Categoria 
                    // se pueda utilizar sin problemas en esta parte del código.
                    E_Categoria entidad = new E_Categoria();
                    entidad.setCategoriaID(resultSet.getInt("CategoriaID"));
                    entidad.setNombre(resultSet.getString("Nombre"));
                    entidad.setDescripcion(resultSet.getString("Descripcion"));
                    lista.add(entidad); // Se añade la entidad a la lista.
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepciones, se podría mejorar utilizando un logger.
        }
        // **I** - Interface Segregation Principle (ISP): 
        // ICategoriaRepository permite que las clases que implementan la 
        // interfaz tengan métodos que son específicos y relevantes para 
        // su contexto. No están obligadas a implementar métodos que no 
        // utilizan.
        return ImmutableList.copyOf(lista); // Google Guava -- Cambiado para devolver una lista inmutable.
        // **D** - Dependency Inversion Principle (DIP): 
        // D_Categoria depende de una abstracción (ICategoriaRepository) 
        // en lugar de depender de una implementación concreta. Esto facilita 
        // el cambio de la implementación de la base de datos o el repositorio 
        // sin afectar a la lógica de negocio.
    }

    public void agregarCategoria(E_Categoria categoria) throws SQLException {
        Connection conexion = DatabaseConnection.getConnection();
        String sql = "INSERT INTO Categoria (Nombre, Descripcion) VALUES (?, ?)";

        // Agregar la categoría a la lista temporal
        categoriasTemp.add(categoria);

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, categoria.getNombre());
            ps.setString(2, categoria.getDescripcion());
            ps.executeUpdate();
        }
    }

    // Método para obtener la lista de categorías temporales (opcional)
    public List<E_Categoria> obtenerCategoriasTemp() {
        return Lists.newArrayList(categoriasTemp); // Retornar una copia mutable de la lista
    }

    public void actualizarCategoria(int id, String nombre, String descripcion) throws SQLException {
//        String query = "UPDATE categoria SET Nombre = ?, Descripcion = ? WHERE CategoriaID = ?";
//        try (Connection conn = Conexion.getInstancia().crearConexion(); PreparedStatement stmt = conn.prepareStatement(query)) {
//            stmt.setString(1, nombre);
//            stmt.setString(2, descripcion);
//            stmt.setInt(3, id);
//            stmt.executeUpdate();
//        }

        String query = "UPDATE categoria SET Nombre = ?, Descripcion = ? WHERE CategoriaID = ?";

        // Buscar y actualizar en la lista temporal si existe
        for (E_Categoria categoria : categoriasTemp) {
            if (categoria.getCategoriaID() == id) {
                categoria.setNombre(nombre);
                categoria.setDescripcion(descripcion);
                break; // Salir del bucle una vez encontrada la categoría
            }
        }

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nombre);
            stmt.setString(2, descripcion);
            stmt.setInt(3, id);
            stmt.executeUpdate();
        }
    }

    public void eliminarCategoria(int categoriaId) throws SQLException {
        String sql = "DELETE FROM Categoria WHERE CategoriaID = ?";

        // **O** - Open/Closed Principle (OCP):
        // La estructura de este método permite agregar más lógica en el futuro,
        // como validaciones, sin modificar la funcionalidad existente.
        // Eliminar de la lista temporal si existe
        // **L** - Liskov Substitution Principle (LSP): 
        // Al utilizar la propiedad de la clase E_Categoria, este método se 
        // asegura de que cualquier subclase pueda ser manejada correctamente.
        categoriasTemp.removeIf(categoria -> categoria.getCategoriaID() == categoriaId);

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, categoriaId); // Se establece el ID de la categoría a eliminar.
            pstmt.executeUpdate(); // Se ejecuta la consulta de eliminación.
        } catch (SQLException e) {
            // **D** - Dependency Inversion Principle (DIP): 
            // Aquí, se podría considerar manejar la excepción de forma 
            // abstracta, permitiendo que otras partes del sistema manejen
            // la lógica de error.
            e.printStackTrace(); // Se recomienda usar un logger en producción.
        }
    }

//    public void eliminarCategoria(int categoriaId) throws SQLException {
// 
//        String sql = "DELETE FROM Categoria WHERE CategoriaID = ?";  
//
//        // Eliminar de la lista temporal si existe
//        categoriasTemp.removeIf(categoria -> categoria.getCategoriaID() == categoriaId);
//
//        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setInt(1, categoriaId);
//            pstmt.executeUpdate();
//        }
//    }
//    
    public void setConnection(Connection mockConnection) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
