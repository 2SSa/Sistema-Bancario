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
public class Cheques {
    private int idCliente;
    private double monto;
    private int chequesDisponibles;
    
    public Cheques(){
        
    }

    public Cheques(int idCliente, double monto) {
        this.idCliente = idCliente;
        this.monto = monto;
        
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getChequesDisponibles() {
        return chequesDisponibles;
    }

    public void setChequesDisponibles(int chequesDisponibles) {
        this.chequesDisponibles = chequesDisponibles;
    }
    
    
}
