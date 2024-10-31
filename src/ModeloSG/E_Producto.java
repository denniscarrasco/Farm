/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloSG;

/**
 *
 * @author Dennis
 */
public class E_Producto {

    private int productoID;
    private String nombre;
    private double precioVenta;
    private int categoriaID;       // ID de la categoría
    private int proveedorID;        // ID del proveedor
    private String nombreCategoria; // Nombre de la categoría (solo para listar)
    private String nombreProveedor; // Nombre del proveedor (solo para listar)

    // Constructor para agregar (sin productoID, nombre de categoría ni nombre de proveedor)
    public E_Producto(String nombre, double precioVenta, int categoriaID, int proveedorID) {
        this.nombre = nombre;
        this.precioVenta = precioVenta;
        this.categoriaID = categoriaID;
        this.proveedorID = proveedorID;
    }

    public E_Producto() {
    }

    public E_Producto(int productoID, String nombre, double precioVenta, int categoriaID, int proveedorID) {
        this.productoID = productoID;
        this.nombre = nombre;
        this.precioVenta = precioVenta;
        this.categoriaID = categoriaID;
        this.proveedorID = proveedorID;
    }

    // Constructor para listar (incluye nombres de categoría y proveedor)
    public E_Producto(int productoID, String nombre, double precioVenta, int categoriaID, int proveedorID,
            String nombreCategoria, String nombreProveedor) {
        this.productoID = productoID;
        this.nombre = nombre;
        this.precioVenta = precioVenta;
        this.categoriaID = categoriaID;
        this.proveedorID = proveedorID;
        this.nombreCategoria = nombreCategoria;
        this.nombreProveedor = nombreProveedor;
    }

    // Getters y Setters
    public int getProductoID() {
        return productoID;
    }

    public void setProductoID(int productoID) {
        this.productoID = productoID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getCategoriaID() {
        return categoriaID;
    }

    public void setCategoriaID(int categoriaID) {
        this.categoriaID = categoriaID;
    }

    public int getProveedorID() {
        return proveedorID;
    }

    public void setProveedorID(int proveedorID) {
        this.proveedorID = proveedorID;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }
}
