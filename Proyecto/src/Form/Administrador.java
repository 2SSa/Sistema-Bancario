/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import FormAprobacion.AceptaCredito;
import FormAprobacion.AceptaTarjeta;
import FormAutobanco.MenuAutobanco;
import FormCajero.MenuCajero;
import FormCliente.MenuCliente;
import FormEmpleado.MenuEmpleado;
import FormTransacciones.InicioTransacciones;
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
public class Administrador extends JFrame{
    public JPanel panel = new JPanel(); // creación de panel
    
    public Administrador(){
        this.setSize(400, 400);//define el tamaño de la ventana
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // para terminar la ejecución de la ventana
        this.setTitle("Administrador");//Titulo de la ventana
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
        JLabel etiqueta1 = new JLabel("Administrador");
        etiqueta1.setBounds(150, 10, 120, 30);
        etiqueta1.setFont(new java.awt.Font("Tahoma", 0, 14));

        panel.add(etiqueta1);
    }

    private JButton btnCliente = new JButton();
    private JButton btnAgencia = new JButton();
    private JButton btnAutobanco = new JButton();
    private JButton btnCajero = new JButton();
    private JButton btnTarjeta = new JButton();
    private JButton btnPrestamo = new JButton();
    private JButton btnEmpleado = new JButton();
    private JButton btnTransacciones = new JButton();
    private JButton btnReporte = new JButton();
    private JButton btnInicio = new JButton();

    private void Botones() {
        //propiedades btn login
        btnCliente.setBounds(135, 40, 145, 25);
        btnCliente.setText("Clientes");
        btnCliente.setEnabled(true);
        panel.add(btnCliente);

        //propiedades btn Cajero
        btnAgencia.setBounds(135, 70, 145, 25);
        btnAgencia.setText("Agencias");
        btnAgencia.setEnabled(true);
        panel.add(btnAgencia);
        
        //Propiedades del boton Autobanco
        btnAutobanco.setBounds(135, 100, 145, 25);
        btnAutobanco.setText("Autobanco");
        btnAutobanco.setEnabled(true);
        panel.add(btnAutobanco);
        
        //Propiedades del boton Cajero
        btnCajero.setBounds(135, 130, 145, 25);
        btnCajero.setText("Cajero");
        btnCajero.setEnabled(true);
        panel.add(btnCajero);
        
        //Propiedades del boton Tarjeta
        btnTarjeta.setBounds(135, 160, 145, 25);
        btnTarjeta.setText("Tarjetas de Crédito");
        btnTarjeta.setEnabled(true);
        panel.add(btnTarjeta);
        
        //Propiedades del boton Prestamo
        btnPrestamo.setBounds(135, 190, 145, 25);
        btnPrestamo.setText("Prestamo");
        btnPrestamo.setEnabled(true);
        panel.add(btnPrestamo);
        
        //Propiedades del boton empleados
        btnEmpleado.setBounds(135, 220, 145, 25);
        btnEmpleado.setText("Empleados");
        btnEmpleado.setEnabled(true);
        panel.add(btnEmpleado);
        
        //Propiedades del boton transacciones
        btnTransacciones.setBounds(135, 250, 145, 25);
        btnTransacciones.setText("Transacciones");
        btnTransacciones.setEnabled(true);
        panel.add(btnTransacciones);
        
        //Propiedades del boton Reportes
        btnReporte.setBounds(135, 280, 145, 25);
        btnReporte.setText("Reportes");
        btnReporte.setEnabled(true);
        panel.add(btnReporte);
        
        btnInicio.setBounds(135, 310, 145, 25);
        btnInicio.setText("Inicio");
        btnInicio.setEnabled(true);
        panel.add(btnInicio);

        ActionListener oyente10 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Inicio inicio = new Inicio();
                dispose();
                inicio.setVisible(true);
            }
        };
        btnInicio.addActionListener(oyente10);
        

        //Boton cliente
        ActionListener oyente = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuCliente men  = new MenuCliente();
                dispose();
                men.setVisible(true);
            }
        };

        btnCliente.addActionListener(oyente);

        //boton cajaero
        ActionListener oyente2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuAgencia agencia = new MenuAgencia();
                dispose();
                agencia.setVisible(true);
            }
        };
        btnAgencia.addActionListener(oyente2);

        //boton Autobanco
        ActionListener oyente3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuAutobanco autobanco = new MenuAutobanco();
                dispose();
                autobanco.setVisible(true);
            }
        };
        btnAutobanco.addActionListener(oyente3);
        
        //boton cajero
        ActionListener oyente4 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuCajero caj = new MenuCajero();
                dispose();
                caj.setVisible(true);
            }
        };
        btnCajero.addActionListener(oyente4);
        
        //boton Tarjeta
        ActionListener oyente5 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AceptaTarjeta tarjeta = new AceptaTarjeta();
                dispose();
                tarjeta.setVisible(true);
            }
        };
        btnTarjeta.addActionListener(oyente5);
        
        //boton Prestamo
        ActionListener oyente6 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AceptaCredito presta = new AceptaCredito();
                dispose();
                presta.setVisible(true);
            }
        };
        btnPrestamo.addActionListener(oyente6);
        
        //boton Empleado
        ActionListener oyente7 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuEmpleado emple = new MenuEmpleado();
                dispose();
                emple.setVisible(true);
            }
        };
        btnEmpleado.addActionListener(oyente7);
        
        //boton Transacciones
        ActionListener oyente8 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InicioTransacciones transa = new InicioTransacciones();
                dispose();
                transa.setVisible(true);
            }
        };
        btnTransacciones.addActionListener(oyente8);
        
        //boton Reporte
        ActionListener oyente9 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuReporte reporte = new MenuReporte();
                dispose();
                reporte.setVisible(true);
            }
        };
        btnReporte.addActionListener(oyente9);
        
    }
    
}
