/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Ejecucion.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class LoginCajero extends JFrame {

    public JPanel panel = new JPanel(); // creación de panel

    public LoginCajero() {
        //this.setLocation(500, 200); //Posición inicial de la ventana
        this.setSize(400, 150);//define el tamaño de la ventana
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // para terminar la ejecución de la ventana
        this.setTitle("Login");//Titulo de la ventana
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

        //para agregar uso al cajero
        if (Inicio.contadorCajero > 0) {
            int uso = 1 + Inicio.cajero[Cajero.posicion].getCantidadUsado();
            Inicio.cajero[Cajero.posicion].setCantidadUsado(uso);
        }

    }

    private void ColocarPanel() {
        panel.setLayout(null); //Desactivando el diseño
        this.getContentPane().add(panel);//agregamos el panel a la ventana 
    }

    private void Etiquetas() {
        JLabel etiqueta1 = new JLabel("No. Cuenta");
        etiqueta1.setBounds(10, 20, 120, 30);

        panel.add(etiqueta1);
    }

    public JTextField txtCuenta = new JTextField();

    private void AreaTexto() {

        //Area de texto para contraseña
        txtCuenta.setBounds(120, 20, 200, 30);
        panel.add(txtCuenta);
    }

    static int cuenta = 0;

    /**
     * Posición de la cuenta en el login
     */
    static int posicion = 0;
    private JButton btnIngresar = new JButton();
    private JButton btnInicio = new JButton();

    private void Botones() {
        //propiedades btn login
        btnIngresar.setBounds(100, 70, 100, 30);
        btnIngresar.setText("Ingresar");
        btnIngresar.setEnabled(true);
        panel.add(btnIngresar);

        //propiedades btn Inicio
        btnInicio.setBounds(230, 70, 100, 30);
        btnInicio.setText("Inicio");
        btnInicio.setEnabled(true);
        panel.add(btnInicio);

        //Agregando evento de tipo action Listener
        ActionListener oyente = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String expCuenta = "[0-9]+";
                Pattern p = Pattern.compile(expCuenta);
                Matcher m = p.matcher(txtCuenta.getText());

                //if para corroborar entrada correcta
                if (m.matches() == true) {
                    cuenta = Integer.parseInt(txtCuenta.getText());
                    dispose();
                    boolean validacion = false;

                    for (int i = 0; i < Inicio.contadorCuenta; i++) {
                        if (cuenta == Inicio.cuenta[i].getNoCuenta()) {
                            validacion = true;
                            posicion = i;
                        }
                    }
                    Cajero cajero = new Cajero();
                    if (validacion == true) {
                        dispose();

                        cajero.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "La cuenta no existe");
                        LoginCajero login = new LoginCajero();
                        login.setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Entrada Incorrecta");
                }
            }
        };

        btnIngresar.addActionListener(oyente);

        //Boton Inicio
        ActionListener oyente1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Inicio inicio = new Inicio();
                inicio.setVisible(true);
            }
        };
        btnInicio.addActionListener(oyente1);
    }
}
