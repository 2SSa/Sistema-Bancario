/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CallCenter;

import Form.Inicio;
import Form.Login;
import FormCajero.EliminarCajero;
import FormTransacciones.InicioTransacciones;
import Operaciones.Cheque;
import Operaciones.Deposito;
import Operaciones.PagoPrestamo;
import Operaciones.Retiro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Jose Santos
 */
public class OperacionesCall extends JFrame{
    public JPanel panel = new JPanel(); // creación de panel
    
    public OperacionesCall(){
        this.setSize(400, 400);//define el tamaño de la ventana
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // para terminar la ejecución de la ventana
        this.setTitle("Area de Call");//Titulo de la ventana
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
        etiqueta1.setBounds(185, 50, 120, 20);
        etiqueta1.setFont(new java.awt.Font("Caja", 0, 17));
        panel.add(etiqueta1);
        
        JLabel etiqueta2 = new JLabel("Call Center");
        etiqueta2.setBounds(185, 70, 120, 20);
        etiqueta2.setFont(new java.awt.Font("Tahoma", 0, 17));
        panel.add(etiqueta2);
    }

    private JButton btnDeposito = new JButton();
    private JButton btnRetiro = new JButton();
    private JButton btnCheque = new JButton();
    private JButton btnServicios = new JButton();
    private JButton btnTarjeta = new JButton();
    private JButton btnPrestamos = new JButton();
    private JButton btnInicio = new JButton();
    
    private void Botones() {
        //propiedades btn login
        btnDeposito.setBounds(135, 100, 145, 25);
        btnDeposito.setText("Depositar");
        btnDeposito.setEnabled(true);
        panel.add(btnDeposito);

        //propiedades btn Cajero
        btnRetiro.setBounds(135, 130, 145, 25);
        btnRetiro.setText("Retirar");
        btnRetiro.setEnabled(false);
        panel.add(btnRetiro);
        
        //Propiedades del boton Autobanco
        btnCheque.setBounds(135, 160, 145, 25);
        btnCheque.setText("Cheques");
        btnCheque.setEnabled(true);
        panel.add(btnCheque);
        
        //Propiedades del boton Cajero
        btnServicios.setBounds(135, 250, 145, 25);
        btnServicios.setText("Servicios");
        btnServicios.setEnabled(true);
        panel.add(btnServicios);
        
        btnTarjeta.setBounds(135, 190, 145, 25);
        btnTarjeta.setText("Tarjeta de Crédito");
        btnTarjeta.setEnabled(true);
        panel.add(btnTarjeta);
        
        btnPrestamos.setBounds(135, 220, 145, 25);
        btnPrestamos.setText("Prestamo");
        btnPrestamos.setEnabled(true);
        panel.add(btnPrestamos);
        
        btnInicio.setBounds(135, 280, 145, 25);
        btnInicio.setText("Regresar");
        btnInicio.setEnabled(true);
        panel.add(btnInicio);

        ActionListener oyente6 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Sistema en mantenimiento");
            }
        };
        
        btnTarjeta.addActionListener(oyente6);
        
        ActionListener oyente5 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Inicio inicio = new Inicio();
                if(InicioTransacciones.regreso = true){
                    dispose();
                    inicio.setVisible(true);
                    //InicioTransacciones.regreso = false;
                }else{
                   Login lo = new Login();
                   dispose();
                   lo.setVisible(true);
                }
            }
        };
        btnInicio.addActionListener(oyente5);
        
        
        ActionListener oyente = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Deposito1 agencia = new Deposito1();
                dispose();
                agencia.setVisible(true);
            }
        };

        btnDeposito.addActionListener(oyente);

        //boton Buscar
        ActionListener oyente2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Retiro busqueda = new Retiro();
                dispose();
                busqueda.setVisible(true);
            }
        };
        btnRetiro.addActionListener(oyente2);

        //boton Editar
        ActionListener oyente3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cheque1 edit = new Cheque1();
                dispose();
                edit.setVisible(true);
            }
        };
        btnCheque.addActionListener(oyente3);
        
        //boton Eliminar
        ActionListener oyente4 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Service eliminar = new Service();
                dispose();
                eliminar.setVisible(true);
            }
        };
        btnServicios.addActionListener(oyente4);
        
        
        ActionListener oyente7 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PagoPrestamo1 pa = new PagoPrestamo1();
                dispose();
                pa.setVisible(true);
            }
        };
        
        btnPrestamos.addActionListener(oyente7);
        
    }
}
