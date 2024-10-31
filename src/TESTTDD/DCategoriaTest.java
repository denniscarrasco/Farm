/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TESTTDD;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import ModeloSG.D_Categoria;
import ModeloSG.DatabaseConnection;
import ModeloSG.E_Categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import static org.hamcrest.CoreMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author Dennis
 */
public class DCategoriaTest {

    private D_Categoria d_categoria;
    private Connection mockConnection;
    private PreparedStatement mockStatement;
    private ResultSet mockResultSet;

    @Before

    public void setUp() throws SQLException {
        // Inicializa D_Categoria y mocks
        d_categoria = new D_Categoria();
        mockConnection = mock(Connection.class);
        mockStatement = mock(PreparedStatement.class);
        mockResultSet = mock(ResultSet.class);

        // Configura el comportamiento de D_Categoria para usar el mockConnection
        d_categoria.setConnection(mockConnection); // Asegúrate de que este método exista
    }

    @Test
    public void testListadoCaSinFiltro() throws SQLException {
        // Configurar el comportamiento del mockResultSet
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement); // Cambiado a anyString()
        when(mockStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true).thenReturn(false); // Simula 1 fila
        when(mockResultSet.getInt("CategoriaID")).thenReturn(1);
        when(mockResultSet.getString("Nombre")).thenReturn("Categoria 1");
        when(mockResultSet.getString("Descripcion")).thenReturn("Descripción 1");

        // Llama al método que se está probando
        List<E_Categoria> categorias = d_categoria.listadoCa("");

        // Verificaciones
        assertNotNull(categorias);
        assertEquals(1, categorias.size());
        assertEquals("Categoria 1", categorias.get(0).getNombre());

        // Verificar que se cerró el PreparedStatement
        verify(mockStatement).close();
    }

    @Test
    public void testAgregarCategoria() throws SQLException {
        // Crear una nueva categoría
        E_Categoria nuevaCategoria = new E_Categoria();
        nuevaCategoria.setNombre("Nueva Categoria");
        nuevaCategoria.setDescripcion("Descripción nueva");

        // Simular el comportamiento del PreparedStatement
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);

        // Llamar al método que se está probando
        d_categoria.agregarCategoria(nuevaCategoria);

        // Verificar que se haya ejecutado el PreparedStatement
        verify(mockStatement).executeUpdate();

        // Comprobar que la categoría fue añadida a la lista temporal
        assertTrue(d_categoria.obtenerCategoriasTemp().contains(nuevaCategoria));

        // Comprobar que la lista temporal contiene exactamente 1 elemento
        assertEquals(1, d_categoria.obtenerCategoriasTemp().size());

        // Comprobar que los detalles de la categoría son correctos
        E_Categoria categoriaAgregada = d_categoria.obtenerCategoriasTemp().get(0);
        assertEquals("Nueva Categoria", categoriaAgregada.getNombre());
        assertEquals("Descripción nueva", categoriaAgregada.getDescripcion());
    }

    @Test
    public void testActualizarCategoria() throws SQLException {
        E_Categoria categoriaExistente = new E_Categoria();
        categoriaExistente.setCategoriaID(1);
        categoriaExistente.setNombre("Categoria Antiguo");
        categoriaExistente.setDescripcion("Descripción Antiguo");

        // Agregar la categoría existente a la lista temporal
        d_categoria.agregarCategoria(categoriaExistente);

        // Actualizar la categoría
        d_categoria.actualizarCategoria(1, "Categoria Nuevo", "Descripción Nuevo");

        // Verificar que los cambios se realizaron en la lista temporal
        E_Categoria actualizada = d_categoria.obtenerCategoriasTemp().get(0);
        assertEquals("Categoria Nuevo", actualizada.getNombre());
        assertEquals("Descripción Nuevo", actualizada.getDescripcion());
    }

    @Test
    public void testEliminarCategoria() throws SQLException {
        E_Categoria categoriaAEliminar = new E_Categoria();
        categoriaAEliminar.setCategoriaID(2);
        categoriaAEliminar.setNombre("Categoria a Eliminar");
        categoriaAEliminar.setDescripcion("Descripción a Eliminar");

        // Agregar la categoría a eliminar a la lista temporal
        d_categoria.agregarCategoria(categoriaAEliminar);

        // Eliminar la categoría
        d_categoria.eliminarCategoria(2);

        // Comprobar que la categoría fue eliminada de la lista temporal
        assertFalse(d_categoria.obtenerCategoriasTemp().contains(categoriaAEliminar));
    }
    // Agrega más métodos de prueba aquí
//    public void testListarCategorias() {
//        List<E_Categoria> categorias = d_categoria.listadoCa(""); // Método a probar
//
//        assertNotNull(categorias); // Verifica que la lista no sea nula
//        assertFalse(categorias.isEmpty()); // Verifica que la lista no esté vacía
//    }
//        public void testEjemplo() {
//        // Aquí iría el código de prueba
//        assertEquals(1, 1); // Esto es un ejemplo simple
//    }
}
