/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormCajero;

import Form.Inicio;
import FormCliente.MenuCliente;
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
public class EditarCajero extends JFrame {

    public JPanel panel = new JPanel(); // creación de panel

    public EditarCajero() {
        //this.setLocation(500, 200); //Posición inicial de la ventana
        this.setSize(400, 400);//define el tamaño de la ventana
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // para terminar la ejecución de la ventana
        this.setTitle("Editar Cajero");//Titulo de la ventana
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

    private void ListaDesplegable() {

        id = new String[Inicio.contadorCajero];
        for (int i = 0; i < Inicio.contadorCajero; i++) {
            id[i] = Inicio.cajero[i].getId() + "";

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
        if (Inicio.contadorCajero == 0) {
            JOptionPane.showMessageDialog(null, "No hay datos cargados", "Informacion", JOptionPane.WARNING_MESSAGE);
        } else {

            for (int i = 0; i < Inicio.contadorCajero; i++) {
                if (Inicio.cajero[i].getId() == val) {
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

        JLabel etiqueta2 = new JLabel();//Creamos una etiqueta
        etiqueta2.setText("Direccion"); //Texto de la etiqueta
        etiqueta2.setBounds(12, 87, 120, 16);
        panel.add(etiqueta2);

        JLabel etiqueta3 = new JLabel();//Creamos una etiqueta
        etiqueta3.setText("Efectivo"); //Texto de la etiqueta
        etiqueta3.setBounds(12, 125, 120, 16);
        panel.add(etiqueta3);

        JLabel etiqueta4 = new JLabel();//Creamos una etiqueta
        etiqueta4.setText("Estado"); //Texto de la etiqueta
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
                if (Inicio.contadorCajero == 0) {
                    JOptionPane.showMessageDialog(null, "No hay cajeros cargados\nen el sistema", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (txtEfectivo.getText().equals("") || txtDireccion.getText().equals("") || txtEstado.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Por favor, llene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    boolean encontrado = false;
                    int pos = 0;
                    if (Inicio.contadorCajero == 0) {
                        JOptionPane.showMessageDialog(null, "No hay datos cargados", "Informacion", JOptionPane.WARNING_MESSAGE);
                    } else {
                        int val = Integer.parseInt((String) listaDesplegable.getSelectedItem());
                        for (int i = 0; i < Inicio.contadorCajero; i++) {
                            if (Inicio.cajero[i].getId() == val) {
                                encontrado = true;
                                pos = i;
                            }
                        }

                        if (encontrado == true) {
                            Inicio.cajero[pos].setEfectivo(Double.parseDouble(txtEfectivo.getText()));
                            Inicio.cajero[pos].setUbicacion(txtDireccion.getText());
                            if(txtEstado.getText().equalsIgnoreCase("activo")){
                                Inicio.cajero[pos].setEstado(true);
                            }else{
                                Inicio.cajero[pos].setEstado(false);
                            }
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
                MenuCajero inicio = new MenuCajero();
                dispose();
                inicio.setVisible(true);
            }
        };
        btnRegresar.addActionListener(oyente3);
    }
}
