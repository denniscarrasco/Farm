/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloSG;

/**
 *
 * @author Dennis
 */
public class E_Proveedor {

    private int proveedorID;
    private String tipoDeDoc;
    private String razonSocial;
    private String nombresApellidos;
    private String celular;
    private String email;

    // Constructor
    public E_Proveedor(String tipoDeDoc, String razonSocial, String nombresApellidos, String celular, String email) {
        this.tipoDeDoc = tipoDeDoc;
        this.razonSocial = razonSocial;
        this.nombresApellidos = nombresApellidos;
        this.celular = celular;
        this.email = email;
    }

    public E_Proveedor(int proveedorID, String tipoDeDoc, String razonSocial, String nombresApellidos, String celular, String email) {
        this.proveedorID = proveedorID;
        this.tipoDeDoc = tipoDeDoc;
        this.razonSocial = razonSocial;
        this.nombresApellidos = nombresApellidos;
        this.celular = celular;
        this.email = email;
    }

    public E_Proveedor() {

    }

    // Getters y Setters
    public int getProveedorID() {
        return proveedorID;
    }

    public void setProveedorID(int proveedorID) {
        this.proveedorID = proveedorID;
    }

    public String getTipoDeDoc() {
        return tipoDeDoc;
    }

    public void setTipoDeDoc(String tipoDeDoc) {
        this.tipoDeDoc = tipoDeDoc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNombresApellidos() {
        return nombresApellidos;
    }

    public void setNombresApellidos(String nombresApellidos) {
        this.nombresApellidos = nombresApellidos;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
