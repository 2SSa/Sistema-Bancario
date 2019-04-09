/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Reportes.ControlCajero;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
public class RetiroCajero extends JFrame {

    static ControlCajero[] retiro = new ControlCajero[300];
    static int contadorRetiro = 0;

    
    public JPanel panel = new JPanel(); // creación de panel

    public RetiroCajero() {
        //this.setLocation(500, 200); //Posición inicial de la ventana
        this.setSize(400, 150);//define el tamaño de la ventana
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // para terminar la ejecución de la ventana
        this.setTitle("Retiro");//Titulo de la ventana
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
        JLabel etiqueta1 = new JLabel("Cantidad a retirar");
        etiqueta1.setBounds(10, 20, 120, 30);

        panel.add(etiqueta1);
    }

    private JTextField txtRetiro = new JTextField();

    private void AreaTexto() {

        //Area de texto para contraseña
        txtRetiro.setBounds(120, 20, 200, 30);
        panel.add(txtRetiro);
    }

    private JButton btnRetirar = new JButton();
    private JButton btnCancelar = new JButton();

    private void Botones() {
        //propiedades btn login
        btnRetirar.setBounds(100, 70, 100, 30);
        btnRetirar.setText("Retirar");
        btnRetirar.setEnabled(true);
        panel.add(btnRetirar);

        //propiedades btn Inicio
        btnCancelar.setBounds(230, 70, 100, 30);
        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(true);
        panel.add(btnCancelar);

        //Agregando evento de tipo action Listener
        ActionListener oyente = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                double dinero = 0;
                double dineroCajero = 0;
                String expCuenta = "([0-9]+)|([0-9]+\\.[0-9]+)";
                Pattern p = Pattern.compile(expCuenta);
                Matcher m = p.matcher(txtRetiro.getText());

                //if para corroborar entrada correcta
                if (m.matches() == true) {
                    //para ver si tiene saldo la cuenta y elvajero
                    dinero = Inicio.cuenta[LoginCajero.posicion].getMonto() - Double.parseDouble(txtRetiro.getText());
                    System.out.println("Dinero = "+dinero);
                    dineroCajero = Inicio.cajero[Cajero.posicion].getEfectivo() - Double.parseDouble(txtRetiro.getText());
                    System.out.println("Dinero cajero = "+dineroCajero);
                    
                    if (dinero < 0) {
                        System.out.println("Dinero mio");
                        JOptionPane.showMessageDialog(null, "No tiene suficiente dinero\n para realizar la transacción");
                    }
                    else if(dineroCajero < 0){
                        System.out.println("DInero cajero");
                        JOptionPane.showMessageDialog(null, "No es posible realizar la\n  la transacción");
                    }
                        else {
                        Inicio.cuenta[LoginCajero.posicion].setMonto(dinero);
                        java.util.Date fecha = new Date();

                        retiro[contadorRetiro++] = new ControlCajero(LoginCajero.cuenta, fecha.getDay(), fecha.getMonth(), fecha.getYear(), Double.parseDouble(txtRetiro.getText()));
                        JOptionPane.showMessageDialog(null, "Se ha retirado con éxito!");
                        System.out.println(fecha.getDay() + "/" + fecha.getMonth() + "/" + fecha.getYear());
                        Inicio.cajero[Cajero.posicion].setEfectivo(dineroCajero);
                        System.out.println("Dinero actual cajero"+Inicio.cajero[Cajero.posicion].getEfectivo());

                    }
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Cantidad incorrecta");
                }

//                Cajero cajero = new Cajero();
//                cajero.setVisible(true);
                for (int i = 0; i < contadorRetiro; i++) {
                    System.out.println("Cuenta: " + retiro[i].getIdCuenta());
                    System.out.println("Monto: " + retiro[i].getMontoRetirado());
                }
            }
        };
        btnRetirar.addActionListener(oyente);

        //Boton Cancelar
        ActionListener oyente1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Cajero inicio = new Cajero();
                inicio.setVisible(true);
            }
        };
        btnCancelar.addActionListener(oyente1);
    }
}
