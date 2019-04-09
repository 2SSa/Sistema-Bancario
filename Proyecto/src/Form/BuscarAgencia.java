/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Jose Santos
 */
public class BuscarAgencia extends JFrame {

    public JPanel panel = new JPanel(); // creación de panel

    public BuscarAgencia() {
        //this.setLocation(500, 200); //Posición inicial de la ventana
        this.setSize(400, 400);//define el tamaño de la ventana
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // para terminar la ejecución de la ventana
        this.setTitle("Busqueda");//Titulo de la ventana
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
        ListaDesplegable();

    }

    private void ColocarPanel() {
        panel.setLayout(null); //Desactivando el diseño
        this.getContentPane().add(panel);//agregamos el panel a la ventana 
    }

    private void ListaDesplegable() {

    }

    private JTextField txtNombre = new JTextField();
    private JTextField txtId = new JTextField();
    private JTextField txtDireccion = new JTextField();
    private JTextField txtTelefono = new JTextField();
    private JTextField txtEfectivo = new JTextField();

    /**
     * Areas de texto en el formulario
     */
    private void AreaTexto() {
        //Area de texto para ingresar id de agencia
        txtId.setBounds(100, 30, 50, 25);
        panel.add(txtId);

        //Area de texto para mostrar el nombre de agencia
        txtNombre.setBounds(130, 85, 200, 25);
        txtNombre.setEnabled(false);
        panel.add(txtNombre);

        //Area de texto para mostrar la direccion
        txtDireccion.setBounds(130, 122, 200, 25);
        txtDireccion.setEnabled(false);
        panel.add(txtDireccion);

        //Area de texto para mostrar el número de telefono
        txtTelefono.setBounds(130, 153, 200, 25);
        txtTelefono.setEnabled(false);
        panel.add(txtTelefono);

        //Area de texto para mostrar la cantidad de efectivo
        txtEfectivo.setBounds(130, 183, 200, 25);
        txtEfectivo.setEnabled(false);
        panel.add(txtEfectivo);
    }

    /**
     * Textos en el formulario
     */
    private void Etiquetas() {
        JLabel etiqueta1 = new JLabel();//Creamos una etiqueta
        etiqueta1.setText("Id de Agencia"); //Texto de la etiqueta
        etiqueta1.setBounds(12, 25, 100, 30);
        panel.add(etiqueta1);

        JLabel etiqueta2 = new JLabel();//Creamos una etiqueta
        etiqueta2.setText("Nombre de Agencia "); //Texto de la etiqueta
        etiqueta2.setBounds(12, 87, 120, 16);
        panel.add(etiqueta2);

        JLabel etiqueta3 = new JLabel();//Creamos una etiqueta
        etiqueta3.setText("Direccion"); //Texto de la etiqueta
        etiqueta3.setBounds(12, 125, 120, 16);
        panel.add(etiqueta3);

        JLabel etiqueta4 = new JLabel();//Creamos una etiqueta
        etiqueta4.setText("Número"); //Texto de la etiqueta
        etiqueta4.setBounds(12, 155, 120, 16);
        panel.add(etiqueta4);

        JLabel etiqueta5 = new JLabel();//Creamos una etiqueta
        etiqueta5.setText("Efectivo Q"); //Texto de la etiqueta
        etiqueta5.setBounds(12, 185, 120, 16);
        panel.add(etiqueta5);
    }

    private JButton btnBuscar = new JButton();
    private JButton btnRegresar = new JButton();

    private void Botones() {

        btnBuscar.setBounds(100, 330, 100, 30);
        btnBuscar.setText("Buscar");
        btnBuscar.setEnabled(true);
        btnBuscar.setMnemonic(KeyEvent.VK_ENTER);
        panel.add(btnBuscar);

        //propiedades btn login
        btnRegresar.setBounds(230, 330, 100, 30);
        btnRegresar.setText("Regresar");
        btnRegresar.setEnabled(true);
        panel.add(btnRegresar);

        //Boton Ingresar
        ActionListener oyente = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String exp = "[0-9]+";
                Pattern p = Pattern.compile(exp);
                boolean agencia = false;
                boolean tipoAgencia =true;
                int posicion = 0;
                Matcher m = p.matcher(txtId.getText());

                //Iniciar los JTextFiel con campos vacios
                txtNombre.setText("");
                txtDireccion.setText("");
                txtTelefono.setText("");
                txtEfectivo.setText("");

                if (txtId.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Ingrese el Id de la agencia bancaria", "Campo Vacío", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (m.matches() == true) {
                        if (Inicio.contadorBanco == 0) {
                            JOptionPane.showMessageDialog(null, "No hay bancos agregados\nen el sistema", "Información", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            for (int i = 0; i < Inicio.contadorBanco; i++) {
                                if (Integer.parseInt(txtId.getText()) == Inicio.banco[i].getId()) {
                                    posicion = i;
                                    agencia = true;
                                    tipoAgencia = Inicio.banco[i].getTipoAgencia();
                                }
                            }

                            if (agencia == true && tipoAgencia==false) {
                                txtNombre.setText(Inicio.banco[posicion].getNombreAgencia());
                                txtDireccion.setText(Inicio.banco[posicion].getDireccion());
                                txtTelefono.setText(Inicio.banco[posicion].getNumeroTelefono());
                                txtEfectivo.setText(Inicio.banco[posicion].getEfectivo() + "");
                            } else {
                                JOptionPane.showMessageDialog(null, "La agencia no se encuentra registrada", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Entrada incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

            }
        };
        btnBuscar.addActionListener(oyente);

        //Boton Inicio
        ActionListener oyente3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuAgencia inicio = new MenuAgencia();
                dispose();
                inicio.setVisible(true);
            }
        };
        btnRegresar.addActionListener(oyente3);
    }
}
