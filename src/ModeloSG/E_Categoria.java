/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloSG;

/**
 *
 * @author Dennis
 */
public class E_Categoria {
    private int categoriaID; // Este ID se generará automáticamente
    private String nombre;
    private String descripcion;

     public E_Categoria() {
    }

    
    // Constructor para crear una nueva categoría (sin ID)
    public E_Categoria(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // Constructor para cargar una categoría existente (con ID)
    public E_Categoria(int categoriaID, String nombre, String descripcion) {
        this.categoriaID = categoriaID;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public int getCategoriaID() {
        return categoriaID;
    }

    public void setCategoriaID(int categoriaID) {
        this.categoriaID = categoriaID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}