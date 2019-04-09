/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CallCenter;

import Operaciones.*;
import FormTransacciones.AreaCaja;
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
public class Cheque1 extends JFrame{
    public JPanel panel = new JPanel(); // creación de panel
    public Cheque1() {
        //this.setLocation(500, 200); //Posición inicial de la ventana
        this.setSize(400, 400);//define el tamaño de la ventana
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // para terminar la ejecución de la ventana
        this.setTitle("Pago con cheque");//Titulo de la ventana
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
        JLabel etiqueta1 = new JLabel("Bienvenido");
        etiqueta1.setBounds(150, 30, 120, 30);
        etiqueta1.setFont(new java.awt.Font("Tahoma", 0, 20));

        panel.add(etiqueta1);
    }

    private JButton btnEfectivo = new JButton();
    private JButton btnDepositar = new JButton();
    private JButton btnRegresar = new JButton();

    private void Botones() {
        //propiedades btn login
        btnEfectivo.setBounds(150, 130, 100, 30);
        btnEfectivo.setText("Efectivo");
        btnEfectivo.setEnabled(false);
        panel.add(btnEfectivo);

        //propiedades btn Cajero
        btnDepositar.setBounds(150, 180, 100, 30);
        btnDepositar.setText("Depositar");
        btnDepositar.setEnabled(true);
        panel.add(btnDepositar);
        
        btnRegresar.setBounds(150, 230, 100, 30);
        btnRegresar.setText("Regresar");
        btnRegresar.setEnabled(true);
        panel.add(btnRegresar);
        
        ActionListener oyente3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OperacionesCall ar = new OperacionesCall();
                dispose();
                ar.setVisible(true);
            }
        };
        
        btnRegresar.addActionListener(oyente3);

        //Agregando evento de tipo action Listener
        ActionListener oyente = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RetiroCheque1 ob = new RetiroCheque1();
                dispose();
                ob.setVisible(true); //Se Hace Visible la Ventana

            }
        };

        btnEfectivo.addActionListener(oyente);

        //boton cajaero
        ActionListener oyente2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DepositoCheque1 login = new DepositoCheque1();
                dispose();
                login.setVisible(true);
            }
        };
        btnDepositar.addActionListener(oyente2);

        //boton inicio
    }
}
