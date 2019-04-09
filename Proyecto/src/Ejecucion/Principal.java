/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejecucion;

import BancoEmpleado.MenuPrinci;
import Form.*;


/**
 *
 * @author Jose Santos
 */
public class Principal {

    public static void main(String[] args) {

        //AreaCaja ca = new AreaCaja();
        //MenuPrinci ca = new MenuPrinci();
        //OperacionesCall ca = new OperacionesCall();
        Inicio cliente = new Inicio();
        //cliente.Cuentas();
        cliente.setVisible(true);

    }

}
