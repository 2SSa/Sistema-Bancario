/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BancoEmpleado;

import FormTransacciones.Banco;
import FormTransacciones.CargaCuenta;
import FormTransacciones.SolicitudPres;
import FormTransacciones.SolicitudTarjet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Jose Santos
 */
public class MenuAtencion extends JFrame{
    public JPanel panel = new JPanel(); // creación de panel

    public MenuAtencion() {
        this.setSize(400, 400);//define el tamaño de la ventana
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // para terminar la ejecución de la ventana
        this.setTitle("Atencion al cliente");//Titulo de la ventana
        //this.setBounds(500, 200, 400, 400); //engloba el setLocation y el setSize
        this.setLocationRelativeTo(null); // Establecemos la ventana en el centro
        this.setResizable(false);//Bloque el Maximinizar la ventana

        IniciarComponentes();

    }

    private void IniciarComponentes() {
        ColocarPanel();
        Botones();
        Etiquetas();
    }

    private void ColocarPanel() {
        panel.setLayout(null); //Desactivando el diseño
        this.getContentPane().add(panel);//agregamos el panel a la ventana 
    }

    private void Etiquetas() {
        JLabel etiqueta1 = new JLabel("Area de");
        etiqueta1.setBounds(185, 30, 120, 20);
        etiqueta1.setFont(new java.awt.Font("Tahoma", 0, 17));
        panel.add(etiqueta1);

        JLabel etiqueta2 = new JLabel("Atención al Cliente");
        etiqueta2.setBounds(140, 55, 200, 20);
        etiqueta2.setFont(new java.awt.Font("Tahoma", 0, 17));
        panel.add(etiqueta2);
    }

    private JButton btnCrearCuenta = new JButton();
    private JButton btnPrestamo = new JButton();
    private JButton btnTarjeta = new JButton();
    //private JButton btnEliminacion = new JButton();
    private JButton btnInicio = new JButton();

    private void Botones() {
        //propiedades btn login
        btnCrearCuenta.setBounds(135, 100, 150, 25);
        btnCrearCuenta.setText("Crear Cuenta");
        btnCrearCuenta.setEnabled(true);
        panel.add(btnCrearCuenta);

        //propiedades btn Cajero
        btnPrestamo.setBounds(135, 130, 150, 25);
        btnPrestamo.setText("Solicitud Prestamo");
        btnPrestamo.setEnabled(true);
        panel.add(btnPrestamo);

        //Propiedades del boton Autobanco
        btnTarjeta.setBounds(135, 160, 150, 25);
        btnTarjeta.setText("Solitud Tarjeta");
        btnTarjeta.setEnabled(true);
        panel.add(btnTarjeta);

        //Propiedades del boton Cajero
//        btnEliminacion.setBounds(135, 190, 145, 25);
//        btnEliminacion.setText("Eliminar");
//        btnEliminacion.setEnabled(true);
//        panel.add(btnEliminacion);
        btnInicio.setBounds(135, 220, 145, 25);
        btnInicio.setText("Regresar");
        btnInicio.setEnabled(true);
        panel.add(btnInicio);

        ActionListener oyente10 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Banco inicio = new Banco();
                dispose();
                inicio.setVisible(true);
            }
        };
        btnInicio.addActionListener(oyente10);

        ActionListener oyente = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CargaCuenta cuenta = new CargaCuenta();
                dispose();
                cuenta.setVisible(true);
            }
        };

        btnCrearCuenta.addActionListener(oyente);

        //boton Buscar
        ActionListener oyente2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SolicitudPres pres = new SolicitudPres();
                dispose();
                pres.setVisible(true);
            }
        };
        btnPrestamo.addActionListener(oyente2);

        //boton Editar
        ActionListener oyente3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SolicitudTarjet edit = new SolicitudTarjet();
                dispose();
                edit.setVisible(true);
            }
        };
        btnTarjeta.addActionListener(oyente3);

//        //boton Eliminar
//        ActionListener oyente4 = new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                EliminarCliente eliminar = new EliminarCliente();
//                dispose();
//                eliminar.setVisible(true);
//            }
//        };
//        btnEliminacion.addActionListener(oyente4);
    }
}
