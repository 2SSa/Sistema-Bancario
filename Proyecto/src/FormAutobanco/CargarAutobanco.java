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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Jose Santos
 */
public class CargarAutobanco extends JFrame {
     public JPanel panel = new JPanel(); // creación de panel

    public CargarAutobanco() {
        //this.setLocation(500, 200); //Posición inicial de la ventana
        this.setSize(600, 600);//define el tamaño de la ventana
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // para terminar la ejecución de la ventana
        this.setTitle("Area de carga");//Titulo de la ventana
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

    }

    private void ColocarPanel() {
        panel.setLayout(null); //Desactivando el diseño
        this.getContentPane().add(panel);//agregamos el panel a la ventana 
    }

    private void Etiquetas() {
        JLabel etiqueta1 = new JLabel("Area de Carga de Autobanco");
        etiqueta1.setBounds(200, 10, 300, 30);
        panel.add(etiqueta1);

        JLabel etiqueta2 = new JLabel("Area de errores");
        etiqueta2.setBounds(42, 370, 300, 30);
        panel.add(etiqueta2);
    }

    private JTextArea txtBanco = new JTextArea();
    private JTextArea txtError = new JTextArea();

    private void AreaTexto() {

        //Area de texto para contraseña
        txtBanco.setBounds(40, 40, 500, 330);
        panel.add(txtBanco);
        //Scroll
        JScrollPane scroll = new JScrollPane(txtBanco);
        scroll.setBounds(40, 40, 500, 330);
        panel.add(scroll);

        //Area de texto para contraseña
        txtError.setBounds(40, 300, 500, 50);
        txtError.setEditable(false);
        panel.add(txtError);
        //Scroll
        JScrollPane scroll1 = new JScrollPane(txtError);
        scroll1.setBounds(40, 400, 500, 100);
        panel.add(scroll1);
    }

    private JButton btnCargar = new JButton();
    private JButton btnRegresar = new JButton();

    private void Botones() {
        //propiedades btn regresar
        btnRegresar.setBounds(150, 510, 100, 30);
        btnRegresar.setText("Regresar");
        btnRegresar.setEnabled(true);
        panel.add(btnRegresar);

        //propiedades del boto cargar
        btnCargar.setBounds(300, 510, 100, 30);
        btnCargar.setText("Cargar");
        btnCargar.setEnabled(true);
        panel.add(btnCargar);

        //Boton Regresar
        ActionListener oyente = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuAgencia menu = new MenuAgencia();
                dispose();
                menu.setVisible(true);
            }
        };
        btnRegresar.addActionListener(oyente);

        //Boton Cargar
        ActionListener oyente2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtError.setText("");
                String texto = txtBanco.getText();
                String expRegular = "[a-zA-Z0-9 ]+;[0-9]+;[0-9a-zA-Z ]+;[0-9]{8};[0-9]+;[0-9]+;[0-9]+;(SI|si|Si);[0-9]+[ ]*";
                String errores = "";
                boolean verificaId;
                if (texto.equals("")) {
                    JOptionPane.showMessageDialog(null, "Ingrese datos", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    String[] arrBanco = texto.split("\n");

                    Pattern p = Pattern.compile(expRegular);
                    for (int a = 0; a < arrBanco.length; a++) {
                        Matcher m = p.matcher(arrBanco[a]);
                        if (m.matches() == true) {
                            String[] valores = arrBanco[a].split(";");

                            verificaId = false;
                            //Comprobando si existe el id de la agencia bancaria
                            for (int i = 0; i < Inicio.contadorBanco; i++) {
                                if (Integer.parseInt(valores[1]) == Inicio.banco[i].getId()) {
                                    verificaId = true;
                                    errores += "Identificador único repetido, en la linea" + (a + 1) + "\n";
                                }
                            }

                            //si el identificador es único se sube
                            if (verificaId == false) {
                                Inicio inicio = new Inicio();
                                System.out.println("Escritorios: " + valores[5]);
                                inicio.CrearBanco(valores[0], Integer.parseInt(valores[1]), valores[2], valores[3], Integer.parseInt(valores[4]), Integer.parseInt(valores[5]), Integer.parseInt(valores[6]), true, Integer.parseInt(valores[8]), 0);
                            }

                        } else {
                            errores += "Error de sintaxis, " + "linea" + (a + 1) + "\n";
                        }
                    }
                    txtError.setText(errores);

                }
                if (txtError.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Se cargaron los datos con éxito", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Se cargaron los datos que\nno contienen errores", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                }

//                for (int i = 0; i < Inicio.contadorBanco; i++) {
//                    System.out.println("Nombre: " + Inicio.banco[i].getNombreAgencia());
//                    System.out.println("Identificador: " + Inicio.banco[i].getId());
//                    System.out.println("Dirección: " + Inicio.banco[i].getDireccion());
//                    System.out.println("Telefono: " + Inicio.banco[i].getNumeroTelefono());
//                    System.out.println("Numero de cajas: " + Inicio.banco[i].getNumeroCajas());
//                    System.out.println("Numero de escritorios: " + Inicio.banco[i].getNoServicioCliente());
//                    System.out.println("Efectivo: " + Inicio.banco[i].getEfectivo());
//
//                }
            }
        };
        btnCargar.addActionListener(oyente2);
    }
}
