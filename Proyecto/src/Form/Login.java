/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import BancoEmpleado.MenuPrinci;
import CallCenter.OperacionesCall;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Jose Santos
 */
public class Login extends JFrame {

    public JPanel panel = new JPanel(); // creación de panel

    public Login() {
        //this.setLocation(500, 200); //Posición inicial de la ventana
        this.setSize(400, 230);//define el tamaño de la ventana
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // para terminar la ejecución de la ventana
        this.setTitle("Login");//Titulo de la ventana
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

    private JPasswordField txtContraseña = new JPasswordField();
    private JTextField txtUsuario = new JTextField();

    /**
     * Areas de texto en el formulario
     */
    private void AreaTexto() {
        //Area de texto para ingresar usuario

        txtUsuario.setBounds(120, 30, 200, 30);
        panel.add(txtUsuario);

        //Area de texto para contraseña
        txtContraseña.setBounds(120, 90, 200, 30);
        panel.add(txtContraseña);

    }

    /**
     * Textos en el formulario
     */
    private void Etiquetas() {
        JLabel etiqueta1 = new JLabel();//Creamos una etiqueta
        etiqueta1.setText("Usuario"); //Texto de la etiqueta
        etiqueta1.setBounds(12, 40, 60, 10);
        panel.add(etiqueta1);

        JLabel etiqueta2 = new JLabel();//Creamos una etiqueta
        etiqueta2.setText("Constraseña"); //Texto de la etiqueta
        etiqueta2.setBounds(12, 100, 80, 10);
        panel.add(etiqueta2);
    }

    private JButton btnIngresar = new JButton();
    private JButton btnInicio = new JButton();

    private void Botones() {

        btnIngresar.setBounds(100, 130, 100, 30);
        btnIngresar.setText("Ingresar");
        btnIngresar.setEnabled(true);
        btnIngresar.setMnemonic(KeyEvent.VK_ENTER);
        panel.add(btnIngresar);

        //propiedades btn login
        btnInicio.setBounds(230, 130, 100, 30);
        btnInicio.setText("Inicio");
        btnInicio.setEnabled(true);
        panel.add(btnInicio);

        //Boton Ingresar
        ActionListener oyente = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = "Admin";
                String contraseña = "201643762";
                boolean login = false;
                boolean login1= false;
                int pos = 0;

                
                login = false;
                login1 = false;
                for (int i = 0; i < Inicio.contadorEmpleado; i++) {
                    if(Inicio.empleado[i].getUsuario().equals(txtUsuario.getText()) && Inicio.empleado[i].getContraseña().equals(txtContraseña.getText())){
                        login = true;
                        pos = i;
                    }
                }
                
                if (txtUsuario.getText().equals("") || txtContraseña.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Llene los campos solicitados", "Error", JOptionPane.WARNING_MESSAGE);
                } else if (usuario.equalsIgnoreCase(txtUsuario.getText()) && contraseña.equalsIgnoreCase(txtContraseña.getText())) {
                    login1=true;
                }
                
                
                if(login == true){
                    if(Inicio.empleado[pos].getAsignacion().equals("AB")){
                        MenuPrinci ban = new MenuPrinci();
                        dispose();
                        ban.setVisible(true);
                    }else if(Inicio.empleado[pos].getAsignacion().equals("CC")){
                        OperacionesCall cal = new OperacionesCall();
                        dispose();
                        cal.setVisible(true);
                    }
                    else if(Inicio.empleado[pos].getAsignacion().equals("DPG")){
                        JOptionPane.showMessageDialog(null, "Empleado del area de gerencia");
                    }
                    else if(Inicio.empleado[pos].getAsignacion().equals("DPM")){
                        JOptionPane.showMessageDialog(null, "Empleado del departamento de Marketing");
                    }
                    else if(Inicio.empleado[pos].getAsignacion().equals("DPI")){
                        JOptionPane.showMessageDialog(null, "Empleado del departamento de informática");
                    }
                    else if(Inicio.empleado[pos].getAsignacion().equals("DPF")){
                        JOptionPane.showMessageDialog(null, "Empleado del departamento financiero");
                    }
                    else if(Inicio.empleado[pos].getAsignacion().equals("DPR")){
                        JOptionPane.showMessageDialog(null, "Empleado del departamento de reclamos");
                    }
                    else if(Inicio.empleado[pos].getAsignacion().equals("DPC")){
                        JOptionPane.showMessageDialog(null, "Empleado del departamento de cobros");
                    }
                }
                if(login1 == true){
                    Administrador admin = new Administrador();
                    dispose();
                    admin.setVisible(true);
                }
                if(login1==false && login ==false){
                    JOptionPane.showMessageDialog(null, "Contraseña o usuario invalido", "Datos", JOptionPane.ERROR_MESSAGE);
                }
//                else {
//                    JOptionPane.showMessageDialog(null, "Contraseña o usuario invalido", "Datos", JOptionPane.ERROR_MESSAGE);
//                }
            }
        };
        btnIngresar.addActionListener(oyente);

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
