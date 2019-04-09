/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Ejecucion.Principal;
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
public class Cajero extends JFrame {

    public JPanel panel = new JPanel(); // creación de panel
    public static int posicion = (int) Math.random() * Inicio.contadorCajero;
    

    public Cajero() {
        //this.setLocation(500, 200); //Posición inicial de la ventana
        this.setSize(400, 400);//define el tamaño de la ventana
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // para terminar la ejecución de la ventana
        this.setTitle("Cajero Automatico");//Titulo de la ventana
        //this.setBounds(500, 200, 400, 400); //engloba el setLocation y el setSize
        this.setLocationRelativeTo(null); // Establecemos la ventana en el centro
        this.setResizable(false);//Bloque el Maximinizar la ventana

        IniciarComponentes();

    }

    private void IniciarComponentes() {
        ColocarPanel();
        Botones();
        Etiquetas();
        System.out.println("posicion "+posicion);

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

        JLabel etiqueta2 = new JLabel("Usted está en Cajero Automático");
        etiqueta2.setBounds(100, 60, 320, 30);
        etiqueta2.setFont(new java.awt.Font("Tahoma", 0, 15));
        panel.add(etiqueta2);
    }

    private JButton btnRetiro = new JButton();
    private JButton btnConsulta = new JButton();
    private JButton btnInicio = new JButton();

    private void Botones() {
        //propiedades btn Retiro
        btnRetiro.setBounds(120, 130, 150, 30);
        btnRetiro.setText("Retiro de Efectivo");
        panel.add(btnRetiro);

        if (Inicio.contadorCajero == 0 || Inicio.cajero[posicion].getEstado()==false) {
            btnConsulta.setEnabled(false);
            btnRetiro.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Fuera de servicio", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            btnConsulta.setEnabled(true);
            btnRetiro.setEnabled(true);
        }

        //propiedades btn consultar saldo
        btnConsulta.setBounds(120, 180, 150, 30);
        btnConsulta.setText("Consulta de Saldo");

        panel.add(btnConsulta);

        //propiedades btn login
        btnInicio.setBounds(120, 230, 150, 30);
        btnInicio.setText("Inicio");
        btnInicio.setEnabled(true);
        panel.add(btnInicio);

        //Boton Retiro
        ActionListener oyente = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RetiroCajero retirocajero = new RetiroCajero();
                retirocajero.setVisible(true);
            }
        };

        btnRetiro.addActionListener(oyente);

        //boton Consulta
        ActionListener oyente2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginCajero login = new LoginCajero();
                JOptionPane.showMessageDialog(null, "Su saldo es: " + Inicio.cuenta[LoginCajero.posicion].getMonto());
//                System.out.println(Inicio.cuenta[Integer.parseInt(login.txtCuenta.getText())].getMonto());
            }
        };
        btnConsulta.addActionListener(oyente2);

        //Boton Inicio
        ActionListener oyente3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Inicio inicio = new Inicio();
                dispose();
                inicio.setVisible(true);
            }
        };
        btnInicio.addActionListener(oyente3);
    }
}
