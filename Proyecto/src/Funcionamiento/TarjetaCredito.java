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
public class TarjetaCredito {
    private int idCliente;
    private int numeroTarjeta;
    private String fechaVencimiento;
    private double limiteCredito;
    private double montoAdeudado;

    public TarjetaCredito() {
    }

    public TarjetaCredito(int idCliente, int numeroTarjeta, String fechaVencimiento, double limiteCredito, double montoAdeudado) {
        this.idCliente = idCliente;
        this.numeroTarjeta = numeroTarjeta;
        this.fechaVencimiento = fechaVencimiento;
        this.limiteCredito = limiteCredito;
        this.montoAdeudado = montoAdeudado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    

    public int getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(int numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public double getMontoAdeudado() {
        return montoAdeudado;
    }

    public void setMontoAdeudado(double montoAdeudado) {
        this.montoAdeudado = montoAdeudado;
    }
    
    
}
