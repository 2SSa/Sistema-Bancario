/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import FormReportes.Agencias;
import FormReportes.Cajeros;
import FormReportes.ClienteCuenta;
import FormReportes.Clientes;
import FormReportes.Deudores;
import FormReportes.EfectivoAgencia;
import FormReportes.EmpleadosAgencia;
import FormReportes.EmpleadosGerencia;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Jose Santos
 */
public class MenuReporte extends JFrame{
     public JPanel panel = new JPanel(); // creación de panel
    
    public MenuReporte(){
        this.setSize(400, 400);//define el tamaño de la ventana
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // para terminar la ejecución de la ventana
        this.setTitle("Reportes");//Titulo de la ventana
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
        JLabel etiqueta1 = new JLabel("Area de Reportes");
        etiqueta1.setBounds(150, 10, 120, 30);
        etiqueta1.setFont(new java.awt.Font("Tahoma", 0, 14));

        panel.add(etiqueta1);
    }

    private JButton btnBanco = new JButton();
    private JButton btnDeudores = new JButton();
    private JButton btnTop = new JButton();
    private JButton btnCajero = new JButton();
    private JButton btnClienteCuen = new JButton();
    private JButton btnTotalEfectivo = new JButton();
    private JButton btnMontoAgencia = new JButton();
    private JButton btnEmpleadosAgencia = new JButton();
    private JButton btnEmpeladosCentral = new JButton();
    private JButton btnRegresar = new JButton();
    private JButton btnClientes = new JButton();

    private void Botones() {
        //propiedades btn login
        btnBanco.setBounds(135, 40, 145, 25);
        btnBanco.setText("Agencia");
        btnBanco.setEnabled(true);
        panel.add(btnBanco);

        //propiedades btn Cajero
        btnCajero.setBounds(135, 70, 145, 25);
        btnCajero.setText("Cajeros");
        btnCajero.setEnabled(true);
        panel.add(btnCajero);
        
        //Propiedades del boton Autobanco
        btnTop.setBounds(135, 100, 145, 25);
        btnTop.setText("Top 5");
        btnTop.setEnabled(true);
        panel.add(btnTop);
        
        //Propiedades del boton Cajero
        btnDeudores.setBounds(135, 130, 145, 25);
        btnDeudores.setText("Deudores");
        btnDeudores.setEnabled(true);
        panel.add(btnDeudores);
        
        //Propiedades del boton Tarjeta
        btnClienteCuen.setBounds(135, 160, 145, 25);
        btnClienteCuen.setText("Cuentas de Cliente");
        btnClienteCuen.setEnabled(true);
        panel.add(btnClienteCuen);
        
        //Propiedades del boton Prestamo
        btnTotalEfectivo.setBounds(135, 190, 145, 25);
        btnTotalEfectivo.setText("Efectivo Disponible");
        btnTotalEfectivo.setEnabled(true);
        panel.add(btnTotalEfectivo);
        
        //Propiedades del boton empleados
        btnMontoAgencia.setBounds(135, 220, 145, 25);
        btnMontoAgencia.setText("Monto por Agencia");
        btnMontoAgencia.setEnabled(true);
        panel.add(btnMontoAgencia);
        
        //Propiedades del boton transacciones
        btnEmpleadosAgencia.setBounds(135, 250, 145, 25);
        btnEmpleadosAgencia.setText("Empleados por Agencia");
        btnEmpleadosAgencia.setEnabled(true);
        panel.add(btnEmpleadosAgencia);
        
        //Propiedades del boton Reportes
        btnEmpeladosCentral.setBounds(135, 280, 145, 25);
        btnEmpeladosCentral.setText("Empleados Office");
        btnEmpeladosCentral.setEnabled(true);
        panel.add(btnEmpeladosCentral);
        
        btnRegresar.setBounds(135, 340, 145, 25);
        btnRegresar.setText("Regresar");
        btnRegresar.setEnabled(true);
        panel.add(btnRegresar);
        
        btnClientes.setBounds(135, 310, 145, 25);
        btnClientes.setText("Clientes");
        btnClientes.setEnabled(true);
        panel.add(btnClientes);

        ActionListener oyente10 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Administrador inicio = new Administrador();
                dispose();
                inicio.setVisible(true);
            }
        };
        btnRegresar.addActionListener(oyente10);
        

        //Boton cliente
        ActionListener oyente = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Agencias agenc = new Agencias();
                
                if (Inicio.contadorBanco == 0) {
                    JOptionPane.showMessageDialog(null, "No hay agencias registradas", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    dispose();
                    agenc.setVisible(true);
                }
            }
        };

        btnBanco.addActionListener(oyente);

        //boton cajaero
        ActionListener oyente2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Deudores deuda = new Deudores();
                dispose();
                deuda.setVisible(true);
            }
        };
        btnDeudores.addActionListener(oyente2);

        //boton Autobanco
        ActionListener oyente3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "El sistema se encuentra en mantenimiento");
            }
        };
        btnTop.addActionListener(oyente3);
        
        //boton cajero
        ActionListener oyente4 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cajeros caj = new Cajeros();
                dispose();
                caj.setVisible(true);
            }
        };
        btnCajero.addActionListener(oyente4);
        
        //boton Tarjeta
        ActionListener oyente5 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClienteCuenta clientList = new ClienteCuenta();
                dispose();
                clientList.setVisible(true);
            }
        };
        btnClienteCuen.addActionListener(oyente5);
        
        //boton Prestamo
        ActionListener oyente6 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double dinero=0;
                if(Inicio.contadorBanco==0){
                    JOptionPane.showMessageDialog(null, "NO hay efectivo disponible", "Inoformacion", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    for (int i = 0; i < Inicio.contadorBanco; i++) {
                        dinero += Inicio.banco[i].getEfectivo();
                    }
                    JOptionPane.showMessageDialog(null, "La agencia cuenta con Q"+dinero+" de efectivo", "Información", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        };
        btnTotalEfectivo.addActionListener(oyente6);
        
        //boton Empleado
        ActionListener oyente7 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EfectivoAgencia efect = new EfectivoAgencia();
                dispose();
                efect.setVisible(true);
            }
        };
        btnMontoAgencia.addActionListener(oyente7);
        
        //boton Transacciones
        ActionListener oyente8 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmpleadosAgencia emplea = new EmpleadosAgencia();
                dispose();
                emplea.setVisible(true);
            }
        };
        btnEmpleadosAgencia.addActionListener(oyente8);
        
        //boton Reporte
        ActionListener oyente9 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmpleadosGerencia gere =new EmpleadosGerencia();
                dispose();
                gere.setVisible(true);
            }
        };
        btnEmpeladosCentral.addActionListener(oyente9);
        
        
        ActionListener oyente11 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Clientes clien = new Clientes();
                dispose();
                clien.setVisible(true);
            }
        };
        
        btnClientes.addActionListener(oyente11);
    }
}
