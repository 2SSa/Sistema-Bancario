/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CallCenter;

import Operaciones.*;
import Form.Administrador;
import Form.Inicio;
import FormTransacciones.AreaCaja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
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
public class PagoPrestamo1 extends JFrame {

    public JPanel panel = new JPanel(); // creación de panel

    public PagoPrestamo1() {
        //this.setLocation(500, 200); //Posición inicial de la ventana
        this.setSize(400, 400);//define el tamaño de la ventana
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // para terminar la ejecución de la ventana
        this.setTitle("Pago Prestamo");//Titulo de la ventana
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
        //ListaDesplegable();

    }

    private void ColocarPanel() {
        panel.setLayout(null); //Desactivando el diseño
        this.getContentPane().add(panel);//agregamos el panel a la ventana 
    }

    private JTextField txtCuenta = new JTextField();

    private JTextField txtPrestamo = new JTextField();
    private JTextField txtMonto = new JTextField();

    /**
     * Areas de texto en el formulario
     */
    private void AreaTexto() {

        //Area de texto para mostrar el nombre de agencia
        txtCuenta.setBounds(150, 85, 150, 25);
        txtCuenta.setEnabled(true);
        panel.add(txtCuenta);

        //Area de texto para mostrar la direccion
        txtPrestamo.setBounds(150, 122, 150, 25);
        txtPrestamo.setEnabled(true);
        panel.add(txtPrestamo);

        //Area de texto para mostrar el número de telefono
        txtMonto.setBounds(150, 153, 150, 25);
        txtMonto.setEnabled(true);
        panel.add(txtMonto);

    }

    /**
     * Textos en el formulario
     */
    private void Etiquetas() {
//        JLabel etiqueta1 = new JLabel();//Creamos una etiqueta
//        etiqueta1.setText("Id de Cliente"); //Texto de la etiqueta
//        etiqueta1.setBounds(12, 25, 100, 30);
//        panel.add(etiqueta1);

        JLabel etiqueta2 = new JLabel();//Creamos una etiqueta
        etiqueta2.setText("ID cuenta(cliente)"); //Texto de la etiqueta
        etiqueta2.setBounds(12, 87, 120, 16);
        panel.add(etiqueta2);

        JLabel etiqueta3 = new JLabel();//Creamos una etiqueta
        etiqueta3.setText("No. de Prestamo"); //Texto de la etiqueta
        etiqueta3.setBounds(12, 125, 120, 16);
        panel.add(etiqueta3);

        JLabel etiqueta4 = new JLabel();//Creamos una etiqueta
        etiqueta4.setText("Monto"); //Texto de la etiqueta
        etiqueta4.setBounds(12, 155, 120, 16);
        panel.add(etiqueta4);

    }

    private JButton btnEditar = new JButton();
    private JButton btnRegresar = new JButton();
    private JButton btnDepositar = new JButton();

    private void Botones() {

        btnEditar.setBounds(120, 330, 100, 30);
        btnEditar.setText("Actualizar");
        btnEditar.setEnabled(false);
        btnEditar.setMnemonic(KeyEvent.VK_ENTER);
        panel.add(btnEditar);

        //propiedades btn login
        btnRegresar.setBounds(230, 330, 100, 30);
        btnRegresar.setText("Regresar");
        btnRegresar.setEnabled(true);
        panel.add(btnRegresar);

        //Boton Buscar
        btnDepositar.setBounds(10, 330, 100, 30);
        btnDepositar.setText("Pagar");
        btnDepositar.setEnabled(true);
        panel.add(btnDepositar);

        ActionListener oyente4 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //MostrarDatos();
                boolean encontrar = false;
                boolean encontrar1 = false;
                boolean monetaria = false;
                int posicion = 0;
                int pos2 = 0;

                if (Inicio.contadorCuenta == 0) {
                    JOptionPane.showMessageDialog(null, "Cuentas incorrectas", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    encontrar = false;
                    monetaria = false;
                    encontrar1 = false;
                    for (int i = 0; i < Inicio.contadorCuenta; i++) {
                        if (Integer.parseInt(txtCuenta.getText()) == Inicio.cuenta[i].getNoCuenta()) {
                            encontrar = true;
                            posicion = i;
                        }
//                        if (Inicio.cuenta[i].getTipoCuenta().equals("MONETARIA")) {
//                            monetaria = true;
//                        }
                    }

                    if (encontrar == true) {
                        // int cant = Inicio.cuenta[posicion].getCantidadCheque() - 1;

                        int banc = (int) Math.random() * Inicio.contadorBanco;

                        double efecBank = Double.parseDouble(txtMonto.getText()) + Inicio.banco[banc].getEfectivo();

                        double saldo = 0;

                        for (int i = 0; i < Inicio.contadorPrestamo; i++) {
                            if (Integer.parseInt(txtPrestamo.getText()) == Inicio.prestamo[i].getNumeroPrestamo()) {
                                encontrar1 = true;
                                pos2 = i;
                            }
                        }

                        if (encontrar1 == true) {
                            double saldo1 = Inicio.cuenta[posicion].getMonto() - Double.parseDouble(txtMonto.getText());
                            double pres = Inicio.prestamo[pos2].getMontoPrestado() - Double.parseDouble(txtMonto.getText());
                            if (saldo1 < 0) {
                                JOptionPane.showMessageDialog(null, "Saldo insuficiente en la cuenta\nNo se puede cambiar cheque", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                System.out.println("Rest de: "+pres);
                                if (pres >= 0) {
                                    saldo = Inicio.cuenta[posicion].getMonto() - Double.parseDouble(txtMonto.getText());
                                    System.out.println("Saldo Actual" + Inicio.cuenta[pos2].getMonto());
                                    System.out.println("Prestamo inicial "+Inicio.prestamo[pos2].getMontoAdeudado());
                                    Inicio.cuenta[posicion].setMonto(saldo);
                                    //actualizando el dinero del banco
                                    Inicio.prestamo[pos2].setMontoAdeudado(Double.parseDouble(txtMonto.getText()));
                                    System.out.println("Abono "+Inicio.prestamo[pos2].getMontoPrestado());
                                    System.out.println("Saldo despues de deposito " + Inicio.cuenta[posicion].getMonto());
                                    JOptionPane.showMessageDialog(null, "Se ha depositado con éxito", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                    JOptionPane.showMessageDialog(null, "El pago es menor", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                                }

                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Error, no se ha pagado\n No. de prestamo incorrecto", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Error\n1ra. cuenta incorrecta", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    }
                }

            }
        };
        btnDepositar.addActionListener(oyente4);

        ActionListener oyente = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };
        btnEditar.addActionListener(oyente);

        //Boton Inicio
        ActionListener oyente3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OperacionesCall inicio = new OperacionesCall();
                dispose();
                inicio.setVisible(true);
            }
        };
        btnRegresar.addActionListener(oyente3);
    }
}
