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
public class Deudores extends JFrame {
    public JPanel panel = new JPanel(); // creación de panel

    public Deudores() {
        //this.setLocation(500, 200); //Posición inicial de la ventana
        this.setSize(600, 600);//define el tamaño de la ventana
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // para terminar la ejecución de la ventana
        this.setTitle("Reporte de Deudores");//Titulo de la ventana
        //this.setBounds(500, 200, 400, 400); //engloba el setLocation y el setSize
        this.setLocationRelativeTo(null); // Establecemos la ventana en el centro
        this.setResizable(false);//Bloque el Maximinizar la ventana

        IniciarComponentes();

    }

    private void IniciarComponentes() {
        ColocarPanel();
        Botones();
        Etiquetas();
        Tabla();
        //MostrarAgencia();
    }

    private void ColocarPanel() {
        panel.setLayout(null); //Desactivando el diseño
        this.getContentPane().add(panel);//agregamos el panel a la ventana 
    }

    private void Etiquetas() {
        JLabel etiqueta1 = new JLabel("Reporte de Deudores");
        etiqueta1.setBounds(200, 10, 300, 30);

        panel.add(etiqueta1);
    }

    private JTextArea txtCliente = new JTextArea();

    private void Tabla() {
        DefaultTableModel modelo1 = new DefaultTableModel();
        modelo1.addColumn("ID Cliente");
        modelo1.addColumn("Tipo Deuda");
        modelo1.addColumn("No de Tarjeta");
        modelo1.addColumn("Fecha Vencimiento");
        modelo1.addColumn("Límite de Crédito");
        modelo1.addColumn("Monto Adeudado");
        modelo1.addColumn("No. de prestamo");
        modelo1.addColumn("Fecha");
        modelo1.addColumn("Monto Prestado");
        modelo1.addColumn("Monto Abonado");
        
        

        String[] valores = new String[10];

        if(Inicio.contadorTarjeta>0){
            for (int i = 0; i < Inicio.contadorTarjeta; i++) {
            valores[0] = Inicio.tarjeta[i].getIdCliente()+"";
            valores[1] = "Tarjeta de Crédito";
            valores[2] = Inicio.tarjeta[i].getNumeroTarjeta()+"";
            valores[3] = Inicio.tarjeta[i].getFechaVencimiento()+"";
            valores[4] = Inicio.tarjeta[i].getLimiteCredito()+"";
            valores[5] = Inicio.tarjeta[i].getMontoAdeudado()+"";
            valores[6] = "No Cumple";
            valores[7] = "No Cumple";
            valores[8] = "No Cumple";
            valores[9] = "No Cumple";
            
        }
        
        modelo1.addRow(valores);
        }
        String[] valores1 = new String[10];
        if(Inicio.contadorPrestamo>0){
            for (int i = 0; i < Inicio.contadorPrestamo; i++) {
            valores1[0] = Inicio.prestamo[i].getIdCliente()+"";
            valores1[1] = "Prestamo";
            valores1[2] = "No Cumple";
            valores1[3] = "No Cumple";
            valores1[4] = "No Cumple";
            valores1[5] = "No Cumple";
            valores1[6] = Inicio.prestamo[i].getNumeroPrestamo()+"";
            valores1[7] = Inicio.prestamo[i].getFecha()+"";
            valores1[8] = Inicio.prestamo[i].getMontoPrestado()+"";
            valores1[9] = Inicio.prestamo[i].getMontoAdeudado()+"";
        }
        modelo1.addRow(valores1);
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
        btnCargar.setText("Cargar");
        btnCargar.setEnabled(false);
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
                JOptionPane.showMessageDialog(null, "Aquí se cargaran los archivos");
            }
        };
        btnCargar.addActionListener(oyente2);
    }
}
