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
public class CajeroAutomatico {
    private int id;
    private String ubicacion;
    private double efectivo;
    private boolean estado;
    private int numeroTransacciones;
    private int cantidadUsado;
    
    
    public CajeroAutomatico(){
        
    }

    public CajeroAutomatico(int id, String ubicacion, double efectivo, boolean estado, int cantidadUsado) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.efectivo = efectivo;
        this.estado = estado;
        this.cantidadUsado = cantidadUsado;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public double getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(double efectivo) {
        this.efectivo = efectivo;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getNumeroTransacciones() {
        return numeroTransacciones;
    }

    public void setNumeroTransacciones(int numeroTransacciones) {
        this.numeroTransacciones = numeroTransacciones;
    }

    public int getCantidadUsado() {
        return cantidadUsado;
    }

    public void setCantidadUsado(int cantidadUsado) {
        this.cantidadUsado = cantidadUsado;
    }
    
    
}
