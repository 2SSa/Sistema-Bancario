/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormCliente;

import Form.Inicio;
import FormAutobanco.MenuAutobanco;
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
public class EditarCliente extends JFrame {

    public JPanel panel = new JPanel(); // creación de panel

    public EditarCliente() {
        //this.setLocation(500, 200); //Posición inicial de la ventana
        this.setSize(400, 400);//define el tamaño de la ventana
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // para terminar la ejecución de la ventana
        this.setTitle("Editar Cliente");//Titulo de la ventana
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

    private JTextField txtNombre = new JTextField();

    private JTextField txtDireccion = new JTextField();
    private JTextField txtTelefono = new JTextField();

    /**
     * Areas de texto en el formulario
     */
    private void AreaTexto() {

        //Area de texto para mostrar el nombre de agencia
        txtNombre.setBounds(150, 85, 150, 25);
        txtNombre.setEnabled(true);
        panel.add(txtNombre);

        //Area de texto para mostrar la direccion
        txtDireccion.setBounds(150, 122, 150, 25);
        txtDireccion.setEnabled(true);
        panel.add(txtDireccion);

        //Area de texto para mostrar el número de telefono
        txtTelefono.setBounds(150, 153, 150, 25);
        txtTelefono.setEnabled(true);
        panel.add(txtTelefono);

    }

    private static JComboBox listaDesplegable;
    private String[] id;

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
        int val = Integer.parseInt((String) listaDesplegable.getSelectedItem());
        String valo = (String) listaDesplegable.getSelectedItem();
        System.out.println(valo);
        if (Inicio.contadorCliente == 0) {
            JOptionPane.showMessageDialog(null, "No hay datos cargados", "Informacion", JOptionPane.WARNING_MESSAGE);
        } else {

            for (int i = 0; i < Inicio.contadorCliente; i++) {
                if (Inicio.cliente[i].getId() == val) {
                    encontrado = true;
                    posicion = i;
                    
                }
            }

            if (encontrado == true) {
                txtDireccion.setText(Inicio.cliente[posicion].getDireccion());
                txtNombre.setText(Inicio.cliente[posicion].getNombre());
                txtTelefono.setText(Inicio.cliente[posicion].getTelefono());
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

        JLabel etiqueta2 = new JLabel();//Creamos una etiqueta
        etiqueta2.setText("Nombre de Cliente"); //Texto de la etiqueta
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

        
    }

    private JButton btnEditar = new JButton();
    private JButton btnRegresar = new JButton();
    private JButton btnBuscar = new JButton();

    private void Botones() {

        btnEditar.setBounds(120, 330, 100, 30);
        btnEditar.setText("Actualizar");
        btnEditar.setEnabled(true);
        btnEditar.setMnemonic(KeyEvent.VK_ENTER);
        panel.add(btnEditar);

        //propiedades btn login
        btnRegresar.setBounds(230, 330, 100, 30);
        btnRegresar.setText("Regresar");
        btnRegresar.setEnabled(true);
        panel.add(btnRegresar);

        //Boton Buscar
        btnBuscar.setBounds(10, 330, 100, 30);
        btnBuscar.setText("Buscar");
        btnBuscar.setEnabled(true);
        panel.add(btnBuscar);

        ActionListener oyente4 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MostrarDatos();
            }
        };
        btnBuscar.addActionListener(oyente4);

        ActionListener oyente = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Inicio.contadorCliente == 0) {
                    JOptionPane.showMessageDialog(null, "No hay clientes cargados\nen el sistema", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (txtDireccion.getText().equals("") || txtNombre.getText().equals("") || txtTelefono.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Por favor, llene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    boolean encontrado = false;
                    int pos = 0;
                    if (Inicio.contadorCliente == 0) {
                        JOptionPane.showMessageDialog(null, "No hay datos cargados", "Informacion", JOptionPane.WARNING_MESSAGE);
                    } else {
                        int val = Integer.parseInt((String) listaDesplegable.getSelectedItem());
                        for (int i = 0; i < Inicio.contadorCliente; i++) {
                            if (Inicio.cliente[i].getId() == val) {
                                encontrado = true;
                                pos = i;
                            }
                        }

                        if (encontrado == true) {
                            Inicio.cliente[pos].setDireccion(txtDireccion.getText());
                            Inicio.cliente[pos].setNombre(txtNombre.getText());
                            Inicio.cliente[pos].setTelefono(txtTelefono.getText());
                            JOptionPane.showMessageDialog(null, "Se han actualizado los datos", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
            }
        };
        btnEditar.addActionListener(oyente);

        //Boton Inicio
        ActionListener oyente3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuCliente inicio = new MenuCliente();
                dispose();
                inicio.setVisible(true);
            }
        };
        btnRegresar.addActionListener(oyente3);
    }
}
