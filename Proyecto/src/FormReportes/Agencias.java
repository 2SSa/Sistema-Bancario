/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormReportes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import Form.Inicio;
import Form.MenuReporte;
import java.awt.Component;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author Jose Santos
 */
public class Agencias extends JFrame {

    public JPanel panel = new JPanel(); // creación de panel

    public Agencias() {
        //this.setLocation(500, 200); //Posición inicial de la ventana
        this.setSize(600, 600);//define el tamaño de la ventana
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // para terminar la ejecución de la ventana
        this.setTitle("Reporte de Agencia");//Titulo de la ventana
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
        MostrarAgencia();
    }

    private void ColocarPanel() {
        panel.setLayout(null); //Desactivando el diseño
        this.getContentPane().add(panel);//agregamos el panel a la ventana 
    }

    private void Etiquetas() {
        JLabel etiqueta1 = new JLabel("Reporte de Agencia");
        etiqueta1.setBounds(200, 10, 300, 30);

        panel.add(etiqueta1);
    }

    private JTextArea txtCliente = new JTextArea();

    private void Tabla() {
        DefaultTableModel modelo1 = new DefaultTableModel();
        modelo1.addColumn("Identificador");
        modelo1.addColumn("Nombre de Agencia");
        modelo1.addColumn("Numero de Telefono");
        modelo1.addColumn("Número de Cajas");
        modelo1.addColumn("Numero de Escritorios");
        modelo1.addColumn("Efectivo");
        modelo1.addColumn("Dirección");
        modelo1.addColumn("Tipo de Agencia");
        modelo1.addColumn("Cajas Autobanco");
        modelo1.addColumn("Uso");

        String[] valores = new String[10];

        for (int i = 0; i < Inicio.contadorBanco; i++) {
            valores[0] = Inicio.banco[i].getId() + "";
            valores[1] = Inicio.banco[i].getNombreAgencia() + "";
            valores[2] = Inicio.banco[i].getNumeroTelefono() + "";
            valores[3] = Inicio.banco[i].getNumeroCajas() + "";
            valores[4] = Inicio.banco[i].getNoServicioCliente() + "";
            valores[5] = Inicio.banco[i].getEfectivo() + "";
            valores[6] = Inicio.banco[i].getDireccion() + "";
            valores[9] = Inicio.banco[i].getCantidadUsado()+"";
            if (Inicio.banco[i].getTipoAgencia() == true) {
                valores[7] = "Autobanco";
                valores[8] = Inicio.banco[i].getCajasAutobanco() + "";
            } else {
                valores[7] = "Agencia Bancaria";
                valores[8] = "No cumple";
            }

            modelo1.addRow(valores);
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
        if (Inicio.contadorBanco == 0) {
//            JOptionPane.showMessageDialog(null, "No hay agencias registradas", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            for (int i = 0; i < Inicio.contadorBanco; i++) {
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
