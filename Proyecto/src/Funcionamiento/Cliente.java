/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionamiento;

/**
 *
 * @author Jose Santos
 */
public class Cliente {

    private int Id;
    private String nombre;
    private String direccion;
    private String telefono;
    private int cantidadCuentas;
    
    public Cliente (){
        
    }

    public Cliente(int Id, String nombre, String direccion, String telefono, int cantidadCuentas) {
        this.Id = Id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cantidadCuentas = cantidadCuentas;
    }
    
    

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getCantidadCuentas() {
        return cantidadCuentas;
    }

    public void setCantidadCuentas(int cantidadCuentas) {
        this.cantidadCuentas = cantidadCuentas;
    }
    
    
    
}
