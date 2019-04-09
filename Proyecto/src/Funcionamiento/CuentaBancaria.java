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
public class CuentaBancaria {
    private int idCliente;
    private int noCuenta;
    private int dia;
    private int mes;
    private int año;
    private String tipoCuenta;
    private double monto;
    private int cantidadCheque;

    public CuentaBancaria() {
    }

    public CuentaBancaria(int idCliente, int noCuenta, int dia, int mes, int año, String tipoCuenta, double monto, int cantidadCheque) {
        this.idCliente = idCliente;
        this.noCuenta = noCuenta;
        this.dia = dia;
        this.mes = mes;
        this.año = año;
        this.tipoCuenta = tipoCuenta;
        this.monto = monto;
        this.cantidadCheque = cantidadCheque;
    }

    public int getCantidadCheque() {
        return cantidadCheque;
    }

    public void setCantidadCheque(int cantidadCheque) {
        this.cantidadCheque = cantidadCheque;
    }

    

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getNoCuenta() {
        return noCuenta;
    }

    public void setNoCuenta(int noCuenta) {
        this.noCuenta = noCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    
}
