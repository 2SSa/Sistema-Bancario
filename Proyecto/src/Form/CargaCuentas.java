/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Funcionamiento.CuentaBancaria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Jose Santos
 */
public class CargaCuentas extends JFrame {

    

    public JPanel panel = new JPanel(); // creación de panel

    public CargaCuentas() {
        //CargaCuentas Prueba
        
        //this.setLocation(500, 200); //Posición inicial de la ventana
        this.setSize(600, 600);//define el tamaño de la ventana
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // para terminar la ejecución de la ventana
        this.setTitle("Area de carga");//Titulo de la ventana
        //this.setBounds(500, 200, 400, 400); //engloba el setLocation y el setSize
        this.setLocationRelativeTo(null); // Establecemos la ventana en el centro
        this.setResizable(false);//Bloque el Maximinizar la ventana

        IniciarComponentes();

    }

    private void IniciarComponentes() {
        ColocarPanel();
        Botones();
        Etiquetas();
        AreaTexto();
    }

    private void ColocarPanel() {
        panel.setLayout(null); //Desactivando el diseño
        this.getContentPane().add(panel);//agregamos el panel a la ventana 
    }

    private void Etiquetas() {
        JLabel etiqueta1 = new JLabel("Area de Carga de Cuentas");
        etiqueta1.setBounds(200, 10, 300, 30);

        panel.add(etiqueta1);
    }

    private JTextArea txtCliente = new JTextArea();

    private void AreaTexto() {

        //Area de texto para contraseña
        txtCliente.setBounds(40, 40, 500, 400);
        panel.add(txtCliente);

        //Scroll
        JScrollPane scroll = new JScrollPane(txtCliente);
        scroll.setBounds(40, 40, 500, 400);
        panel.add(scroll);
    }

    private JButton btnCargar = new JButton();
    private JButton btnRegresar = new JButton();

    private void Botones() {
        //propiedades btn regresar
        btnRegresar.setBounds(150, 460, 100, 30);
        btnRegresar.setText("Regresar");
        btnRegresar.setEnabled(true);
        panel.add(btnRegresar);

        //propiedades del boto cargar
        btnCargar.setBounds(300, 460, 100, 30);
        btnCargar.setText("Cargar");
        btnCargar.setEnabled(true);
        panel.add(btnCargar);

        //Boton Regresar
        ActionListener oyente = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Aca se regresara");
            }
        };
        btnRegresar.addActionListener(oyente);

        //Boton Cargar
        ActionListener oyente2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Aquí se cargaran los archivos");
            }
        };
        btnCargar.addActionListener(oyente2);
    }
}
