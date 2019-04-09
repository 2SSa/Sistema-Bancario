/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormTransacciones;

import CallCenter.OperacionesCall;
import Form.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
public class InicioTransacciones extends JFrame{
    public JPanel panel = new JPanel(); // creación de panel

    public InicioTransacciones() {
        //this.setLocation(500, 200); //Posición inicial de la ventana
        this.setSize(400, 400);//define el tamaño de la ventana
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // para terminar la ejecución de la ventana
        this.setTitle("Transacciones");//Titulo de la ventana
        //this.setBounds(500, 200, 400, 400); //engloba el setLocation y el setSize
        this.setLocationRelativeTo(null); // Establecemos la ventana en el centro
        this.setResizable(false);//Bloque el Maximinizar la ventana

        IniciarComponentes();

    }

    private void IniciarComponentes() {
        ColocarPanel();
        Etiquetas();
        //AreaTexto();
        Botones();
        ListaDesplegable();

    }

    private void ColocarPanel() {
        panel.setLayout(null); //Desactivando el diseño
        this.getContentPane().add(panel);//agregamos el panel a la ventana 
    }

    private JTextField txtDireccion = new JTextField();

    private JTextField txtEfectivo = new JTextField();
    private JTextField txtEstado = new JTextField();

    /**
     * Areas de texto en el formulario
     */
    private void AreaTexto() {

        //Area de texto para mostrar el nombre de agencia
        txtDireccion.setBounds(150, 85, 150, 25);
        txtDireccion.setEnabled(true);
        panel.add(txtDireccion);

        //Area de texto para mostrar la direccion
        txtEfectivo.setBounds(150, 122, 150, 25);
        txtEfectivo.setEnabled(true);
        panel.add(txtEfectivo);

        //Area de texto para mostrar el número de telefono
        txtEstado.setBounds(150, 153, 150, 25);
        txtEstado.setEnabled(true);
        panel.add(txtEstado);

    }

    private static JComboBox listaDesplegable;
    private String[] id;

    public static int valorItem=0;
    private void ListaDesplegable() {

        id = new String[Inicio.contadorCliente];
        for (int i = 0; i < Inicio.contadorCliente; i++) {
            id[i] = Inicio.cliente[i].getId() + "";

        }

        listaDesplegable = new JComboBox(id);
        listaDesplegable.setBounds(100, 30, 50, 20);
        panel.add(listaDesplegable);
        
        

    }

    
    private void MostrarDatos() {
        boolean encontrado = false;
        int posicion = 0;
        boolean tipoAgencia = false;
        valorItem = Integer.parseInt((String) listaDesplegable.getSelectedItem());
        String valo = (String) listaDesplegable.getSelectedItem();
        System.out.println(valo);
        if (Inicio.contadorCliente == 0) {
            JOptionPane.showMessageDialog(null, "No hay datos cargados", "Informacion", JOptionPane.WARNING_MESSAGE);
        } else {

            for (int i = 0; i < Inicio.contadorCajero; i++) {
                if (Inicio.cajero[i].getId() == valorItem) {
                    encontrado = true;
                    posicion = i;

                }
            }

            if (encontrado == true) {
                txtEfectivo.setText(Inicio.cajero[posicion].getEfectivo() + "");
                txtDireccion.setText(Inicio.cajero[posicion].getUbicacion());
                if (Inicio.cajero[posicion].getEstado() == true) {
                    txtEstado.setText("Activo");
                } else {
                    txtEstado.setText("Mantenimiento");
                }
            }
        }
    }

    /**
     * Textos en el formulario
     */
    private void Etiquetas() {
        JLabel etiqueta1 = new JLabel();//Creamos una etiqueta
        etiqueta1.setText("Id de Cliente"); //Texto de la etiqueta
        etiqueta1.setBounds(12, 25, 100, 30);
        panel.add(etiqueta1);

    }

    public static boolean regreso=false ;
    
    private JButton btnBanco = new JButton();
    private JButton btnRegresar = new JButton();
    private JButton btnCall = new JButton();
    private JButton btnCajero = new JButton();

    private void Botones() {

        btnBanco.setBounds(140, 60, 100, 25);
        btnBanco.setText("Banco");
        btnBanco.setEnabled(true);
        btnBanco.setMnemonic(KeyEvent.VK_ENTER);
        panel.add(btnBanco);

        //propiedades btn login
        btnCall.setBounds(140, 90, 100, 25);
        btnCall.setText("Call Center");
        btnCall.setEnabled(true);
        panel.add(btnCall);

        //Boton Buscar
        btnCajero.setBounds(140, 120, 100, 25);
        btnCajero.setText("Cajero");
        btnCajero.setEnabled(true);
        panel.add(btnCajero);
        
        btnRegresar.setBounds(140, 150, 100, 25);
        btnRegresar.setText("Regresar");
        btnRegresar.setEnabled(true);
        panel.add(btnRegresar);

        ActionListener oyente5 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginCajero login = new LoginCajero();
                dispose();
                login.setVisible(true);
            }
        };
        
        btnCajero.addActionListener(oyente5);
        
        
        ActionListener oyente4 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Inicio.contadorCliente == 0){
                    JOptionPane.showMessageDialog(null, "No hay clientes registrados");
                }else{
                    OperacionesCall ca = new OperacionesCall();
                    dispose();
                    ca.setVisible(true);
                    regreso = true;
                }
            }
        };
        btnCall.addActionListener(oyente4);

        ActionListener oyente = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(Inicio.contadorCliente == 0){
                   JOptionPane.showMessageDialog(null, "No hay clientes para continuar", "Error", JOptionPane.ERROR_MESSAGE);
               }else{
                   valorItem = Integer.parseInt((String) listaDesplegable.getSelectedItem());
                   Banco bank = new Banco();
                   dispose();
                   bank.setVisible(true);
               }
            }
        };
        btnBanco.addActionListener(oyente);

        //Boton Inicio
        ActionListener oyente3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Administrador inicio = new Administrador();
                dispose();
                inicio.setVisible(true);
            }
        };
        btnRegresar.addActionListener(oyente3);
    }
}
