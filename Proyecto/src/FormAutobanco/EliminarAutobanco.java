/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormAutobanco;

import Form.Inicio;
import Form.MenuAgencia;
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
public class EliminarAutobanco extends JFrame{
  public JPanel panel = new JPanel(); // creación de panel

    public EliminarAutobanco() {
        //this.setLocation(500, 200); //Posición inicial de la ventana
        this.setSize(400, 400);//define el tamaño de la ventana
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // para terminar la ejecución de la ventana
        this.setTitle("Editar Autobanco");//Titulo de la ventana
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
    private JTextField txtNumeroCajas = new JTextField();
    private JTextField txtDireccion = new JTextField();
    private JTextField txtTelefono = new JTextField();
    private JTextField txtEfectivo = new JTextField();
    private JTextField txtEscritorios = new JTextField();
    private JTextField txtCajas = new JTextField();

    /**
     * Areas de texto en el formulario
     */
    private void AreaTexto() {
        //Area de texto para ingresar id de agencia
        txtNumeroCajas.setBounds(150, 213, 150, 25);
        panel.add(txtNumeroCajas);

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

        //Area de texto para mostrar la cantidad de efectivo
        txtEfectivo.setBounds(150, 183, 150, 25);
        txtEfectivo.setEnabled(true);
        panel.add(txtEfectivo);

        //Area de texto para mostrar el numero de escritorios
        txtEscritorios.setBounds(150, 250, 150, 25);
        panel.add(txtEscritorios);
        
        //Area de texto para mostrar el numero de cajas de autobanco
        txtCajas.setBounds(150, 290, 150, 25);
        txtCajas.setEnabled(true);
        panel.add(txtCajas);

    }

    private static JComboBox listaDesplegable;
    private String[] id;

    private void ListaDesplegable() {

        id = new String[Inicio.contadorBanco];
        for (int i = 0; i < Inicio.contadorBanco; i++) {
            if (Inicio.banco[i].getTipoAgencia() == true) {
                id[i] = Inicio.banco[i].getId() + "";
            }
        }

        listaDesplegable = new JComboBox(id);
        listaDesplegable.setBounds(100, 30, 50, 20);
        panel.add(listaDesplegable);

    }

    private void MostrarDatos() {
        boolean encontrado = false;
        int posicion = 0;
        if (Inicio.contadorBanco == 0) {
            JOptionPane.showMessageDialog(null, "No hay datos cargados", "Informacion", JOptionPane.WARNING_MESSAGE);
        } else {
            int val = Integer.parseInt((String) listaDesplegable.getSelectedItem());
            for (int i = 0; i < Inicio.contadorBanco; i++) {
                if (Inicio.banco[i].getId() == val) {
                    encontrado = true;
                    posicion = i;
                }
            }

            if (encontrado == true) {
                txtDireccion.setText(Inicio.banco[posicion].getDireccion());
                txtNombre.setText(Inicio.banco[posicion].getNombreAgencia());
                txtEfectivo.setText("" + Inicio.banco[posicion].getEfectivo());
                txtEscritorios.setText("" + Inicio.banco[posicion].getNoServicioCliente());
                txtNumeroCajas.setText(Inicio.banco[posicion].getNumeroCajas() + "");
                txtTelefono.setText(Inicio.banco[posicion].getNumeroTelefono() + "");
                txtCajas.setText(Inicio.banco[posicion].getCajasAutobanco()+"");
            }
        }
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

        JLabel etiqueta6 = new JLabel();//Creamos una etiqueta
        etiqueta6.setText("Numero de Cajas"); //Texto de la etiqueta
        etiqueta6.setBounds(12, 215, 120, 16);
        panel.add(etiqueta6);

        JLabel etiqueta7 = new JLabel();//Creamos una etiqueta
        etiqueta7.setText("Numero de escritorios"); //Texto de la etiqueta
        etiqueta7.setBounds(12, 245, 140, 16);
        panel.add(etiqueta7);

        JLabel etiqueta8 = new JLabel("Servicio al cliente");//Creamos una etiqueta
        etiqueta8.setBounds(12, 260, 140, 16);
        panel.add(etiqueta8);
    }

    private JButton btnEliminar = new JButton();
    private JButton btnRegresar = new JButton();
    private JButton btnBuscar = new JButton();

    private void Botones() {

        btnEliminar.setBounds(120, 330, 100, 30);
        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(true);
        btnEliminar.setMnemonic(KeyEvent.VK_ENTER);
        panel.add(btnEliminar);

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
                int po = 0;

                if (Inicio.contadorBanco == 0) {
                    JOptionPane.showMessageDialog(null, "No hay banco cargados\nen el sistema", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (txtDireccion.getText().equals("") || txtEfectivo.getText().equals("") || txtEscritorios.getText().equals("") || txtNombre.getText().equals("") || txtNumeroCajas.getText().equals("") || txtTelefono.getText().equals("") || txtCajas.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Por favor, llene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    boolean encontrado = false;
                    int pos = 0;
                    if (Inicio.contadorBanco == 0) {
                        JOptionPane.showMessageDialog(null, "No hay datos cargados", "Informacion", JOptionPane.WARNING_MESSAGE);
                    } else {
                        int val = Integer.parseInt((String) listaDesplegable.getSelectedItem());
                        for (int i = 0; i < Inicio.contadorBanco; i++) {
                            if (Inicio.banco[i].getId() == val) {
                                encontrado = true;
                                pos = i;
                            }
                        }

                        if (encontrado == true) {
                            for (int i = pos; i < Inicio.contadorBanco - 1; i++) {
                                Inicio.banco[i] = Inicio.banco[i + 1];
                                System.out.println("Actual " + Inicio.contadorBanco);
                                

                            }

                            if(Inicio.contadorBanco>=1){
                                Inicio.contadorBanco--;
                                System.out.println("Despues " + Inicio.contadorBanco);
                            }
//                            EliminarAgencia elimina = new EliminarAgencia();
//                            dispose();
//                            elimina.setVisible(true);
                            JOptionPane.showMessageDialog(null, "Se ha eliminado a la agencia\ncon éxito", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
            }
        };
        btnEliminar.addActionListener(oyente);

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
