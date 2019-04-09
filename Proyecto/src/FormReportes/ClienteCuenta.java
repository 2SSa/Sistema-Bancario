/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormReportes;

import Form.Inicio;
import Form.MenuReporte;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author Jose Santos
 */
public class ClienteCuenta extends JFrame {

    public JPanel panel = new JPanel(); // creación de panel

    public ClienteCuenta() {
        //this.setLocation(500, 200); //Posición inicial de la ventana
        this.setSize(600, 600);//define el tamaño de la ventana
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // para terminar la ejecución de la ventana
        this.setTitle("Reporte de Cliente");//Titulo de la ventana
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
        //Tabla();
        //MostrarAgencia();
    }

    private void ColocarPanel() {
        panel.setLayout(null); //Desactivando el diseño
        this.getContentPane().add(panel);//agregamos el panel a la ventana 
    }

    private void Etiquetas() {
        JLabel etiqueta1 = new JLabel("Reporte de Lista de Cuentas");
        etiqueta1.setBounds(200, 10, 300, 30);

        panel.add(etiqueta1);
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

    private JTextArea txtCliente = new JTextArea();

    private void Tabla() {
        String[] valores = new String[4];
        DefaultTableModel modelo1 = new DefaultTableModel();
        modelo1.addColumn("Tipo");
        modelo1.addColumn("Efectivo");
        modelo1.addColumn("Monto Adeudado");
        modelo1.addColumn("Abono");

        if (Inicio.contadorCliente == 0) {
            JOptionPane.showMessageDialog(null, "No hay clientes Disponibles");
        } else {
            int val = Integer.parseInt((String) listaDesplegable.getSelectedItem());
            
            //Agregando cuentas normales
            for (int i = 0; i < Inicio.contadorCuenta; i++) {

                if (val == Inicio.cuenta[i].getIdCliente()) {
                    valores[0] = "Cuenta de tipo "+Inicio.cuenta[i].getTipoCuenta() + "";
                    valores[1] = Inicio.cuenta[i].getMonto()+"";
                    valores[2] = "No cumple";
                    valores[3] = "No cumple";
                    modelo1.addRow(valores);
                }
            }
            
            //Agregando prestamos
            for (int i = 0; i < Inicio.contadorPrestamo; i++) {

                if (val == Inicio.prestamo[i].getIdCliente()) {
                    valores[0] = "Prestamo";
                    valores[1] = "No cumple";
                    valores[2] = Inicio.prestamo[i].getMontoPrestado()+"";
                    valores[3] = Inicio.prestamo[i].getMontoAdeudado()+"";
                    modelo1.addRow(valores);
                }
            }
            
            for (int i = 0; i < Inicio.contadorTarjeta; i++) {

                if (val == Inicio.tarjeta[i].getIdCliente()) {
                    valores[0] = "Tarjeta de Crédito";
                    valores[1] = "No cumple";
                    valores[2] = Inicio.tarjeta[i].getMontoAdeudado()+"";
                    valores[3] = "No cumple";
                    modelo1.addRow(valores);
                }
            }
        }

        JTable table = new JTable(modelo1);
        table.setBounds(40, 40, 500, 400);
        table.setEnabled(false);
//        tabla.setAutoscrolls(true);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (int i = 0; i < table.getColumnCount(); i++) {
            DefaultTableColumnModel colModel = (DefaultTableColumnModel) table.getColumnModel();
            TableColumn col = colModel.getColumn(i);
            int width = 0;

            TableCellRenderer renderer = col.getHeaderRenderer();
            for (int r = 0; r < table.getRowCount(); r++) {
                renderer = table.getCellRenderer(r, i);
                Component comp = renderer.getTableCellRendererComponent(table, table.getValueAt(r, i),
                        false, false, r, i);
                width = Math.max(width, comp.getPreferredSize().width);
            }
            col.setPreferredWidth(width + 2);
        }

        //table.doLayout();
        panel.add(table);

        //Scroll
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(40, 40, 500, 400);
        panel.add(scroll);

    }

    private void MostrarAgencia() {
        String agencia = "";
        if (Inicio.contadorCliente == 0) {
//            JOptionPane.showMessageDialog(null, "No hay agencias registradas", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            for (int i = 0; i < Inicio.contadorCliente; i++) {
                if (Inicio.banco[i].getTipoAgencia() == false) {
                    agencia += "Agencia Bancaria\n";

                } else {
                    agencia += "Autobanco\n" + "Numero de Cajas del Autobanco: " + Inicio.banco[i].getCajasAutobanco() + "\n";
                }
                agencia += "Nombre de Agencia: " + Inicio.banco[i].getNombreAgencia() + "\n"
                        + "Identificador de Agencia: " + Inicio.banco[i].getId() + "\n"
                        + "Número de Teléfono: " + Inicio.banco[i].getNumeroTelefono() + "\n"
                        + "Numero Cajas: " + Inicio.banco[i].getNumeroCajas() + "\n"
                        + "Numero de Escritorios en servicio al cliente: " + Inicio.banco[i].getNoServicioCliente() + "\n"
                        + "Efectivo: " + Inicio.banco[i].getEfectivo() + "\n"
                        + "La agencia se ha usado: " + Inicio.banco[i].getCantidadUsado() + " veces" + "\n"
                        + "Dirección: " + Inicio.banco[i].getDireccion() + "\n\n";
            }
            txtCliente.setText(agencia);
        }

    }

    private JButton btnCargar = new JButton();
    private JButton btnRegresar = new JButton();

    private void Botones() {
        //propiedades btn regresar
        btnRegresar.setBounds(150, 460, 100, 30);
        btnRegresar.setText("Regresar");
        btnRegresar.setEnabled(true);
        panel.add(btnRegresar);

        //propiedades del boto cargar
        btnCargar.setBounds(300, 460, 100, 30);
        btnCargar.setText("Buscar");
        btnCargar.setEnabled(true);
        panel.add(btnCargar);

        //Boton Regresar
        ActionListener oyente = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuReporte menu = new MenuReporte();
                dispose();
                menu.setVisible(true);
            }
        };
        btnRegresar.addActionListener(oyente);

        //Boton Cargar
        ActionListener oyente2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tabla();
            }
        };
        btnCargar.addActionListener(oyente2);
    }
}
