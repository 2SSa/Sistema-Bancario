/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CallCenter;

import Operaciones.*;
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
public class DepositoCheque1 extends JFrame{
    public JPanel panel = new JPanel(); // creación de panel

    public DepositoCheque1() {
        //this.setLocation(500, 200); //Posición inicial de la ventana
        this.setSize(400, 400);//define el tamaño de la ventana
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // para terminar la ejecución de la ventana
        this.setTitle("Depósito");//Titulo de la ventana
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

    private JTextField txtCuentaDepo = new JTextField();
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
        txtCuentaDepo.setBounds(150, 122, 150, 25);
        txtCuentaDepo.setEnabled(true);
        panel.add(txtCuentaDepo);

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
        etiqueta2.setText("ID cuenta"); //Texto de la etiqueta
        etiqueta2.setBounds(12, 87, 120, 16);
        panel.add(etiqueta2);

        JLabel etiqueta3 = new JLabel();//Creamos una etiqueta
        etiqueta3.setText("Cuenta a depositar"); //Texto de la etiqueta
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
        btnDepositar.setText("Depositar");
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
                    JOptionPane.showMessageDialog(null, "Cuenta incorrecta", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    encontrar = false;
                    monetaria = false;
                    encontrar1 = false;
                    for (int i = 0; i < Inicio.contadorCuenta; i++) {
                        if (Integer.parseInt(txtCuenta.getText()) == Inicio.cuenta[i].getNoCuenta()) {
                            encontrar = true;
                            posicion = i;
                        } else if (Inicio.cuenta[posicion].getTipoCuenta().equals("MONETARIA")) {
                            monetaria = true;
                        }
                    }

                    if (encontrar == true && monetaria == true) {
                        int cant = Inicio.cuenta[posicion].getCantidadCheque() - 1;

                        if (cant < 0) {
                            JOptionPane.showMessageDialog(null, "No hay cheques disponibles", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            int banc = (int) Math.random() * Inicio.contadorBanco;
                            int uso = Inicio.banco[banc].getCantidadUsado() + 1;

                            double efecBank = Double.parseDouble(txtMonto.getText()) + Inicio.banco[banc].getEfectivo();
                            Inicio.banco[banc].setCantidadUsado(uso);

                            double saldo = 0;

                            for (int i = 0; i < Inicio.contadorCuenta; i++) {
                                if (Integer.parseInt(txtCuentaDepo.getText()) == Inicio.cuenta[i].getNoCuenta()) {
                                    encontrar1 = true;
                                    pos2 = i;
                                }
                            }

                            if (encontrar1 == true) {
                                saldo = Inicio.cuenta[pos2].getMonto() + Double.parseDouble(txtMonto.getText());
                                System.out.println("Saldo Actual" + Inicio.cuenta[pos2].getMonto());
                                Inicio.cuenta[pos2].setMonto(saldo);
                                //actualizando el dinero del banco
                                Inicio.banco[banc].setEfectivo(efecBank);

                                System.out.println("Saldo despues de deposito " + Inicio.cuenta[pos2].getMonto());
                                JOptionPane.showMessageDialog(null, "Se ha depositado con éxito", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Error, no se ha depositado\n 2da cuenta incorrecta", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    } else if (monetaria == false) {
                        JOptionPane.showMessageDialog(null, "Cheque invalido", "Informacion", JOptionPane.INFORMATION_MESSAGE);
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
                Cheque1 inicio = new Cheque1();
                dispose();
                inicio.setVisible(true);
            }
        };
        btnRegresar.addActionListener(oyente3);
    }
}
