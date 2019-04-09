/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BancoEmpleado;

import Operaciones.*;
import Form.Administrador;
import Form.Inicio;
import FormTransacciones.AreaCaja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Jose Santos
 */
public class PagoPrestamo2 extends JFrame {

    public JPanel panel = new JPanel(); // creación de panel

    public PagoPrestamo2() {
        //this.setLocation(500, 200); //Posición inicial de la ventana
        this.setSize(400, 230);//define el tamaño de la ventana
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // para terminar la ejecución de la ventana
        this.setTitle("Pago de Prestamo");//Titulo de la ventana
        //this.setBounds(500, 200, 400, 400); //engloba el setLocation y el setSize
        this.setLocationRelativeTo(null); // Establecemos la ventana en el centro
        this.setResizable(false);//Bloque el Maximinizar la ventana

        IniciarComponentes();

    }

    private void IniciarComponentes() {
        ColocarPanel();
        Etiquetas();
        AreaTexto();
        Botones();

    }

    private void ColocarPanel() {
        panel.setLayout(null); //Desactivando el diseño
        this.getContentPane().add(panel);//agregamos el panel a la ventana 
    }

    private JTextField txtMonto = new JTextField();
    private JTextField txtPrestamo = new JTextField();

    /**
     * Areas de texto en el formulario
     */
    private void AreaTexto() {
        //Area de texto para ingresar usuario

        txtPrestamo.setBounds(140, 30, 70, 30);
        panel.add(txtPrestamo);

        //Area de texto para contraseña
        txtMonto.setBounds(140, 90, 70, 30);
        panel.add(txtMonto);

    }

    /**
     * Textos en el formulario
     */
    private void Etiquetas() {
        JLabel etiqueta1 = new JLabel();//Creamos una etiqueta
        etiqueta1.setText("Codigo de prestamo"); //Texto de la etiqueta
        etiqueta1.setBounds(12, 40, 140, 15);
        panel.add(etiqueta1);

        JLabel etiqueta2 = new JLabel();//Creamos una etiqueta
        etiqueta2.setText("Abonar"); //Texto de la etiqueta
        etiqueta2.setBounds(12, 100, 80, 15);
        panel.add(etiqueta2);
    }

    private JButton btnPagar = new JButton();
    private JButton btnRegresar = new JButton();

    private void Botones() {

        btnPagar.setBounds(100, 130, 100, 30);
        btnPagar.setText("Pagar");
        btnPagar.setEnabled(true);
        btnPagar.setMnemonic(KeyEvent.VK_ENTER);
        panel.add(btnPagar);

        //propiedades btn login
        btnRegresar.setBounds(230, 130, 100, 30);
        btnRegresar.setText("Regresar");
        btnRegresar.setEnabled(true);
        panel.add(btnRegresar);

        //Boton Ingresar
        ActionListener oyente = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean encontrar;

                if (txtPrestamo.getText().equals("") || txtMonto.getText().equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Todos lo campos son obligatorios\nPor llenelos");
                } else {
                    encontrar = false;
                    for (int i = 0; i < Inicio.contadorPrestamo; i++) {
                        if (Integer.parseInt(txtPrestamo.getText()) == Inicio.prestamo[i].getNumeroPrestamo()) {
                            encontrar = true;
                        }
                    }

                    if (encontrar == true) {
                        int pos = Integer.parseInt(txtPrestamo.getText()) - 1;
                        double abono = Inicio.prestamo[pos].getMontoAdeudado() + Double.parseDouble(txtMonto.getText());
                        Inicio.prestamo[pos].setMontoAdeudado(abono);
                        JOptionPane.showMessageDialog(null, "Se ha realizado el pago");
                    } else {
                        JOptionPane.showMessageDialog(null, "Codigo de prestamo invalido");
                    }
                }

            }
        };
        btnPagar.addActionListener(oyente);

        //Boton Inicio
        ActionListener oyente3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AreaCaja2 inicio = new AreaCaja2();
                dispose();
                inicio.setVisible(true);
            }
        };
        btnRegresar.addActionListener(oyente3);
    }
}
