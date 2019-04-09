/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormAprobacion;

import Form.Administrador;
import Form.Inicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
public class AceptaCredito extends JFrame {

    public JPanel panel = new JPanel(); // creación de panel

    public AceptaCredito() {
        //this.setLocation(500, 200); //Posición inicial de la ventana
        this.setSize(400, 400);//define el tamaño de la ventana
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // para terminar la ejecución de la ventana
        this.setTitle("Aprobación de Prestamo");//Titulo de la ventana
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

    private JTextField txtCliente = new JTextField();

    private JTextField txtCredito = new JTextField();
    //private JTextField txtTelefono = new JTextField();

    /**
     * Areas de texto en el formulario
     */
    private void AreaTexto() {

        //Area de texto para mostrar el nombre de agencia
        txtCliente.setBounds(150, 85, 150, 25);
        txtCliente.setEnabled(true);
        txtCliente.setEditable(false);
        panel.add(txtCliente);

        //Area de texto para mostrar la direccion
        txtCredito.setBounds(150, 122, 150, 25);
        txtCredito.setEnabled(true);
        panel.add(txtCredito);
//
//        //Area de texto para mostrar el número de telefono
//        txtTelefono.setBounds(150, 153, 150, 25);
//        txtTelefono.setEnabled(true);
//        panel.add(txtTelefono);

    }

    private static JComboBox listaDesplegable;
    private String[] id;

    private void ListaDesplegable() {

        id = new String[Inicio.contadorSolicitudPrestamo];
        for (int i = 0; i < Inicio.contadorSolicitudPrestamo; i++) {
            id[i] = Inicio.solicitudPrestamo[i].getIdSolicitud() + "";

        }

        listaDesplegable = new JComboBox(id);
        listaDesplegable.setBounds(100, 30, 50, 20);
        panel.add(listaDesplegable);

    }

    private void MostrarDatos() {
        boolean encontrado = false;
        int posicion = 0;
        int cliente = 0;

        int val = 0;
        String valo = (String) listaDesplegable.getSelectedItem();
        System.out.println(valo);
        if (Inicio.contadorSolicitudPrestamo == 0) {
            JOptionPane.showMessageDialog(null, "No hay datos cargados", "Informacion", JOptionPane.WARNING_MESSAGE);
        } else {
            val = Integer.parseInt((String) listaDesplegable.getSelectedItem());

            cliente = Inicio.solicitudPrestamo[val - 1].getCliente();

            for (int i = 0; i < Inicio.contadorCliente; i++) {
                if (Inicio.cliente[i].getId() == cliente) {
                    encontrado = true;
                    posicion = i;

                }
            }

            if (encontrado == true) {
                txtCredito.setText("");
                txtCliente.setText(Inicio.cliente[posicion].getNombre());
                //txtTelefono.setText(Inicio.cliente[posicion].getTelefono());
            }
        }
    }

    /**
     * Textos en el formulario
     */
    private void Etiquetas() {
        JLabel etiqueta1 = new JLabel();//Creamos una etiqueta
        etiqueta1.setText("Id de Solicitud"); //Texto de la etiqueta
        etiqueta1.setBounds(12, 25, 100, 30);
        panel.add(etiqueta1);

        JLabel etiqueta2 = new JLabel();//Creamos una etiqueta
        etiqueta2.setText("Cliente"); //Texto de la etiqueta
        etiqueta2.setBounds(12, 87, 120, 16);
        panel.add(etiqueta2);

        JLabel etiqueta3 = new JLabel();//Creamos una etiqueta
        etiqueta3.setText("Crédito"); //Texto de la etiqueta
        etiqueta3.setBounds(12, 125, 120, 16);
        panel.add(etiqueta3);
//
//        JLabel etiqueta4 = new JLabel();//Creamos una etiqueta
//        etiqueta4.setText("Número"); //Texto de la etiqueta
//        etiqueta4.setBounds(12, 155, 120, 16);
//        panel.add(etiqueta4);

    }

    private JButton btnAceptar = new JButton();
    private JButton btnRechazar = new JButton();
    private JButton btnRegresar = new JButton();
    private JButton btnBuscar = new JButton();

    private void Botones() {

        btnAceptar.setBounds(95, 330, 80, 30);
        btnAceptar.setText("Aceptar");
        btnAceptar.setEnabled(true);
        btnAceptar.setMnemonic(KeyEvent.VK_ENTER);
        panel.add(btnAceptar);

        //propiedades btn login
        btnRegresar.setBounds(275, 330, 90, 30);
        btnRegresar.setText("Regresar");
        btnRegresar.setEnabled(true);
        panel.add(btnRegresar);

        btnRechazar.setBounds(180, 330, 90, 30);
        btnRechazar.setText("Rechazar");
        btnRechazar.setEnabled(true);
        panel.add(btnRechazar);

        //Boton Buscar
        btnBuscar.setBounds(10, 330, 80, 30);
        btnBuscar.setText("Buscar");
        btnBuscar.setEnabled(true);
        panel.add(btnBuscar);

        ActionListener oyente5 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //int posicion = 0;
                int valor = 0;
                if (Inicio.contadorSolicitudPrestamo == 0) {
                    System.out.println("No hay solicitud");
                    JOptionPane.showMessageDialog(null, "No hay solicitudes", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    System.out.println("Entre hay soli");
                    valor = Integer.parseInt((String) listaDesplegable.getSelectedItem());
                    System.out.println("el valor de la lista es: " + valor);

                    for (int i = valor - 1; i < Inicio.contadorSolicitudPrestamo - 1; i++) {
                        Inicio.solicitudPrestamo[i] = Inicio.solicitudPrestamo[i + 1];
                        Inicio.solicitudPrestamo[i].setIdSolicitud(i + 1);
                    }

                    System.out.println("Actual: " + Inicio.contadorSolicitudPrestamo);
                    if (Inicio.contadorSolicitudPrestamo > 0) {
                        Inicio.contadorSolicitudPrestamo--;
                        System.out.println("Despues " + Inicio.contadorSolicitudPrestamo);
                    }

                    JOptionPane.showMessageDialog(null, "Se rechazo con éxito", "Informacion", JOptionPane.INFORMATION_MESSAGE);

                }
            }
        };
        btnRechazar.addActionListener(oyente5);

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
                int valor = 0;

                if (Inicio.contadorSolicitudPrestamo == 0) {
                    JOptionPane.showMessageDialog(null, "No hay solicitudes", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    Inicio ini = new Inicio();
                    String expRegular = "([0-9]+|[0-9]+.[0-9]{2})";
                    valor = Integer.parseInt((String) listaDesplegable.getSelectedItem());
                    System.out.println("el valor de la lista es: " + valor);
                    
                    Pattern p = Pattern.compile(expRegular);
                    Matcher m = p.matcher(txtCredito.getText());
                    if (m.matches() == true) {
                        ini.CrearPrestamo(Double.parseDouble(txtCredito.getText()),Inicio.solicitudPrestamo[valor-1].getCliente());

                        for (int i = 0; i < Inicio.contadorPrestamo; i++) {
                            System.out.println("Fecha  " + Inicio.prestamo[i].getFecha());
                            System.out.println("Numero de prestamo " + Inicio.prestamo[i].getNumeroPrestamo());
                            System.out.println("Monto: " + Inicio.prestamo[i].getMontoPrestado());
                        }
                        JOptionPane.showMessageDialog(null, "Se acepto con éxito el prestamo", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Revise el valor de los campos", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    }
                    
                    //actuliza el las solicitudes
                    for (int i = valor - 1; i < Inicio.contadorSolicitudPrestamo - 1; i++) {
                        Inicio.solicitudPrestamo[i] = Inicio.solicitudPrestamo[i + 1];
                        Inicio.solicitudPrestamo[i].setIdSolicitud(i + 1);
                    }


                    System.out.println("Actual: " + Inicio.contadorSolicitudPrestamo);
                    if (Inicio.contadorSolicitudPrestamo > 0) {
                        Inicio.contadorSolicitudPrestamo--;
                        System.out.println("Despues " + Inicio.contadorSolicitudPrestamo);
                    }

                    
                }
            }
        };
        btnAceptar.addActionListener(oyente);

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
