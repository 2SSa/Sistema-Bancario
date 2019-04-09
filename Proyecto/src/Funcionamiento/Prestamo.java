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
public class Prestamo {
    private int idCliente;
    private int numeroPrestamo;
    private String fecha;
    private double montoPrestado;
    private double montoAdeudado;

    public Prestamo() {
    }

    public Prestamo(int idCliente, int numeroPrestamo, String fecha, double montoPrestado, double montoAdeudado) {
        this.idCliente = idCliente;
        this.numeroPrestamo = numeroPrestamo;
        this.fecha = fecha;
        this.montoPrestado = montoPrestado;
        this.montoAdeudado = montoAdeudado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    

    public int getNumeroPrestamo() {
        return numeroPrestamo;
    }

    public void setNumeroPrestamo(int numeroPrestamo) {
        this.numeroPrestamo = numeroPrestamo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getMontoPrestado() {
        return montoPrestado;
    }

    public void setMontoPrestado(double montoPrestado) {
        this.montoPrestado = montoPrestado;
    }

    public double getMontoAdeudado() {
        return montoAdeudado;
    }

    public void setMontoAdeudado(double montoAdeudado) {
        this.montoAdeudado = montoAdeudado;
    }
    
    
}
