/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormAutobanco;

import Form.Administrador;
import Form.BuscarAgencia;
import Form.CargarBanco;
import Form.EditarAgencia;
import Form.EliminarAgencia;
import javax.swing.JFrame;
import Form.Inicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Jose Santos
 */
public class MenuAutobanco extends JFrame{
    public JPanel panel = new JPanel(); // creación de panel
    
    public MenuAutobanco(){
        this.setSize(400, 400);//define el tamaño de la ventana
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // para terminar la ejecución de la ventana
        this.setTitle("Agencia Bancaria");//Titulo de la ventana
        //this.setBounds(500, 200, 400, 400); //engloba el setLocation y el setSize
        this.setLocationRelativeTo(null); // Establecemos la ventana en el centro
        this.setResizable(false);//Bloque el Maximinizar la ventana

        IniciarComponentes();

    }

    private void IniciarComponentes() {
        ColocarPanel();
        Botones();
        Etiquetas();
    }

    private void ColocarPanel() {
        panel.setLayout(null); //Desactivando el diseño
        this.getContentPane().add(panel);//agregamos el panel a la ventana 
    }

    private void Etiquetas() {
        JLabel etiqueta1 = new JLabel("Agencia");
        etiqueta1.setBounds(185, 50, 120, 20);
        etiqueta1.setFont(new java.awt.Font("Tahoma", 0, 17));
        panel.add(etiqueta1);
        
        JLabel etiqueta2 = new JLabel("Con Autobanco");
        etiqueta2.setBounds(185, 70, 120, 20);
        etiqueta2.setFont(new java.awt.Font("Tahoma", 0, 17));
        panel.add(etiqueta2);
    }

    private JButton btnCrear = new JButton();
    private JButton btnBuscar = new JButton();
    private JButton btnEditar = new JButton();
    private JButton btnEliminacion = new JButton();
    private JButton btnInicio = new JButton();
    
    private void Botones() {
        //propiedades btn login
        btnCrear.setBounds(135, 100, 145, 25);
        btnCrear.setText("Crear");
        btnCrear.setEnabled(true);
        panel.add(btnCrear);

        //propiedades btn Cajero
        btnBuscar.setBounds(135, 130, 145, 25);
        btnBuscar.setText("Buscar");
        btnBuscar.setEnabled(true);
        panel.add(btnBuscar);
        
        //Propiedades del boton Autobanco
        btnEditar.setBounds(135, 160, 145, 25);
        btnEditar.setText("Editar");
        btnEditar.setEnabled(true);
        panel.add(btnEditar);
        
        //Propiedades del boton Cajero
        btnEliminacion.setBounds(135, 190, 145, 25);
        btnEliminacion.setText("Eliminar");
        btnEliminacion.setEnabled(true);
        panel.add(btnEliminacion);
        
        btnInicio.setBounds(135, 220, 145, 25);
        btnInicio.setText("Regresar");
        btnInicio.setEnabled(true);
        panel.add(btnInicio);

        ActionListener oyente10 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Administrador inicio = new Administrador();
                dispose();
                inicio.setVisible(true);
            }
        };
        btnInicio.addActionListener(oyente10);
        
        
        ActionListener oyente = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CargarAutobanco agencia = new CargarAutobanco();
                dispose();
                agencia.setVisible(true);
            }
        };

        btnCrear.addActionListener(oyente);

        //boton Buscar
        ActionListener oyente2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BuscarAutobanco busqueda = new BuscarAutobanco();
                dispose();
                busqueda.setVisible(true);
            }
        };
        btnBuscar.addActionListener(oyente2);

        //boton Editar
        ActionListener oyente3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditarAutobanco edit = new EditarAutobanco();
                dispose();
                edit.setVisible(true);
            }
        };
        btnEditar.addActionListener(oyente3);
        
        //boton Eliminar
        ActionListener oyente4 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EliminarAutobanco eliminar = new EliminarAutobanco();
                dispose();
                eliminar.setVisible(true);
            }
        };
        btnEliminacion.addActionListener(oyente4);
    }
}
