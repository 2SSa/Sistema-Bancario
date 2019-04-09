/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormTransacciones;

import Form.Login;
import Form.LoginCajero;
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
public class Banco extends JFrame {
    public JPanel panel = new JPanel(); // creación de panel
    
    public Banco() {
        //this.setLocation(500, 200); //Posición inicial de la ventana
        this.setSize(400, 400);//define el tamaño de la ventana
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // para terminar la ejecución de la ventana
        this.setTitle("Banco");//Titulo de la ventana
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
        etiqueta1.setBounds(150, 30, 250, 30);
        etiqueta1.setFont(new java.awt.Font("Tahoma", 0, 20));
        panel.add(etiqueta1);
        
        JLabel etiqueta2 = new JLabel("al banco");
        etiqueta2.setBounds(150, 55, 250, 30);
        etiqueta2.setFont(new java.awt.Font("Tahoma", 0, 20));
        panel.add(etiqueta2);
    }

    private JButton btnCaja = new JButton();
    private JButton btnAtencion = new JButton();
    private JButton btnRegresar = new JButton();

    private void Botones() {
        //propiedades btn login
        btnCaja.setBounds(130, 90, 150, 25);
        btnCaja.setText("Area de Cajas");
        btnCaja.setEnabled(true);
        panel.add(btnCaja);

        //propiedades btn Cajero
        btnAtencion.setBounds(130, 122, 150, 25);
        btnAtencion.setText("Atención al cliente");
        btnAtencion.setEnabled(true);
        panel.add(btnAtencion);
        
        btnRegresar.setBounds(130, 155, 150, 25);
        btnRegresar.setText("Regresar");
        btnRegresar.setEnabled(true);
        panel.add(btnRegresar);
        
        ActionListener oyente3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InicioTransacciones transac = new InicioTransacciones();
                dispose();
                transac.setVisible(true);
            }
        };
        btnRegresar.addActionListener(oyente3);

        //Agregando evento de tipo action Listener
        ActionListener oyente = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AreaCaja ob = new AreaCaja();
                dispose();
                ob.setVisible(true); //Se Hace Visible la Ventana

            }
        };

        btnCaja.addActionListener(oyente);

        //boton cajaero
        ActionListener oyente2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AtencionCliente login = new AtencionCliente();
                dispose();
                login.setVisible(true);
            }
        };
        btnAtencion.addActionListener(oyente2);

        //boton inicio
    }
}
