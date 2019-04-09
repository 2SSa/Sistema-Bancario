/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

/**
 *
 * @author Jose Santos
 */
public class ControlCajero {
    private int idCuenta;
    private int dia;
    private int mes;
    private int año;
    private double montoRetirado;

    public ControlCajero() {
    }

    public ControlCajero(int idCuenta, int dia, int mes, int año, double montoRetirado) {
        this.idCuenta = idCuenta;
        this.dia = dia;
        this.mes = mes;
        this.año = año;
        this.montoRetirado = montoRetirado;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
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

    public double getMontoRetirado() {
        return montoRetirado;
    }

    public void setMontoRetirado(double montoRetirado) {
        this.montoRetirado = montoRetirado;
    }
    
    
}
