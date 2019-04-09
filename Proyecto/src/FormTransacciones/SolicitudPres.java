/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormTransacciones;

import Form.Inicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Jose Santos
 */
public class SolicitudPres extends JFrame{
        public JPanel panel = new JPanel(); // creación de panel

    public SolicitudPres() {

        //this.setLocation(500, 200); //Posición inicial de la ventana
        this.setSize(400, 400);//define el tamaño de la ventana
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // para terminar la ejecución de la ventana
        this.setTitle("Solicitud Prestamo");//Titulo de la ventana
        //this.setBounds(500, 200, 400, 400); //engloba el setLocation y el setSize
        this.setLocationRelativeTo(null); // Establecemos la ventana en el centro
        this.setResizable(false);//Bloque el Maximinizar la ventana

        IniciarComponentes();

    }

    private void IniciarComponentes() {
        ColocarPanel();
        Botones();
        Etiquetas();
        ListaDesplegable();
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
        listaDesplegable.setBounds(80, 83, 50, 20);
        panel.add(listaDesplegable);
    }

    private void ColocarPanel() {
        panel.setLayout(null); //Desactivando el diseño
        this.getContentPane().add(panel);//agregamos el panel a la ventana 
    }

    private void Etiquetas() {
        JLabel etiqueta1 = new JLabel("Solicitud de");
        etiqueta1.setBounds(150, 30, 250, 30);
        etiqueta1.setFont(new java.awt.Font("Tahoma", 0, 20));
        panel.add(etiqueta1);

        JLabel etiqueta2 = new JLabel("Prestamo");
        etiqueta2.setBounds(150, 55, 250, 30);
        etiqueta2.setFont(new java.awt.Font("Tahoma", 0, 20));
        panel.add(etiqueta2);
        
        JLabel etiqueta3 = new JLabel("Cliente");
        etiqueta3.setBounds(10, 80, 250, 20);
        etiqueta3.setFont(new java.awt.Font("Tahoma", 0, 17));
        panel.add(etiqueta3);
    }

    private JButton btnAceptar = new JButton();
    private JButton btnRegresar = new JButton();
//    private JButton btnAtencion = new JButton();
//    private JButton btnRegresar = new JButton();

    private void Botones() {
        //propiedades btn login
        btnAceptar.setBounds(130, 120, 150, 25);
        btnAceptar.setText("Aceptar");
        btnAceptar.setEnabled(true);
        panel.add(btnAceptar);
        
        btnRegresar.setBounds(130, 150, 150, 25);
        btnRegresar.setText("Regresar");
        btnRegresar.setEnabled(true);
        panel.add(btnRegresar);
        
        ActionListener oyente3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AtencionCliente inicio = new AtencionCliente();
                dispose();
                inicio.setVisible(true);
            }
        };
        btnRegresar.addActionListener(oyente3);
        
        //Agregando evento de tipo action Listener
        ActionListener oyente = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Inicio.contadorCliente == 0){
                    JOptionPane.showMessageDialog(null, "No hay clientes registrados", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    int idCliente = Integer.parseInt((String) listaDesplegable.getSelectedItem());
                    
                    Inicio ini = new Inicio();
                    ini.SolicitudPrestamo(idCliente);
                    JOptionPane.showMessageDialog(null, "Se hizo la solicitud");
                }
                
                for (int i = 0; i < Inicio.contadorSolicitudPrestamo; i++) {
                    System.out.println("No. Solicitud: "+Inicio.solicitudPrestamo[i].getIdSolicitud());
                    System.out.println("Id Cliente: "+Inicio.solicitudPrestamo[i].getCliente()+"\n");
                }

            }
        };

        btnAceptar.addActionListener(oyente);

    }
}
