/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Funcionamiento.AgenciaBancaria;
import Funcionamiento.CajeroAutomatico;
import Funcionamiento.Cheques;
import Funcionamiento.Cliente;
import Funcionamiento.CuentaBancaria;
import Funcionamiento.Empleado;
import Funcionamiento.Prestamo;
import Funcionamiento.SolicitudPrestamo;
import Funcionamiento.SolicitudTarjetaCredito;
import Funcionamiento.TarjetaCredito;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Jose Santos
 */
public class Inicio extends JFrame {

    public JPanel panel = new JPanel(); // creación de panel

    /**
     * instancia para empleados
     */
    static public Empleado[] empleado = new Empleado[300];

    /**
     * contador para llevar el control de empleados
     */
    static public int contadorEmpleado = 0;

    /**
     * instacia para los cajeros automaticos
     */
    static public CajeroAutomatico[] cajero = new CajeroAutomatico[300];

    /**
     * variable para llevar control de los cajeros automáticos
     */
    static public int contadorCajero = 0;

    /**
     * Instacia para los clientes del banco
     */
    static public Cliente[] cliente = new Cliente[300];

    /**
     * contador para llevar control de los clientes
     */
    static public int contadorCliente = 0;

    /**
     * Constructor para las cuentas
     */
    static public CuentaBancaria[] cuenta = new CuentaBancaria[300];
    /**
     * contador para llevar el control de las cuentas
     */
    static public int contadorCuenta = 0;

    //Objetos de Agencia Bancaria o Autobanco
    /**
     * Intancia sirve para los bancos
     */
    static public AgenciaBancaria[] banco = new AgenciaBancaria[300];
    /**
     * contador para llevar el control de los bancos
     */
    static public int contadorBanco = 0;

    static public Cheques[] cheque = new Cheques[2000];
    public static int contadorCheque = 0;

    /**
     * soliciutd de tarjeta de credito
     */
    public static SolicitudTarjetaCredito[] solicitarTarjeta = new SolicitudTarjetaCredito[300];
    public static int contadorSolicitarTarjeta = 0;

    /**
     * instancia para llevar el control de las solicitudes de prestamo
     */
    public static SolicitudPrestamo[] solicitudPrestamo = new SolicitudPrestamo[300];
    public static int contadorSolicitudPrestamo = 0;

    //Instancias de Tarjetas de credito
    public static TarjetaCredito[] tarjeta = new TarjetaCredito[100];
    public static int contadorTarjeta = 0;

    //Instancia de prestamos
    public static Prestamo[] prestamo = new Prestamo[100];
    public static int contadorPrestamo = 0;

    public void CrearPrestamo(double prest, int idClient) {
        Calendar fecha = new GregorianCalendar();
        String fech = fecha.get(Calendar.DAY_OF_MONTH) + "/" + (fecha.get(Calendar.MONTH) + 1) + "/" + fecha.get(Calendar.YEAR);
        prestamo[contadorPrestamo++] = new Prestamo(idClient, contadorPrestamo, fech, prest, 0);
    }

    public void CrearTarjeta(double credito, int cliente) {
        Calendar fecha = new GregorianCalendar();
        String fech = (fecha.get(Calendar.MONTH) + 1) + "/" + (fecha.get(Calendar.YEAR) + 5);
        tarjeta[contadorTarjeta++] = new TarjetaCredito(cliente, contadorTarjeta, fech, credito, 0);
    }

    public void SolicitudPrestamo(int cliente) {
        solicitudPrestamo[contadorSolicitudPrestamo++] = new SolicitudPrestamo(contadorSolicitudPrestamo, cliente);
    }

    public void Solicitud(int cliente) {
        solicitarTarjeta[contadorSolicitarTarjeta++] = new SolicitudTarjetaCredito(contadorSolicitarTarjeta, cliente);
    }

    /**
     * Método para cargar las cuentas al constructor
     *
     * @param agencia Nombre de agencia
     * @param id identificador de agencia
     * @param direccion dirección que se encuentra ubicada la agencia
     * @param telefono número de telefono de la agencia
     * @param cajas número de cajas disponible
     * @param noEscritorios número de escritorios
     * @param efectivo cantidad de dinero en la agencia
     * @param tipoAgencia si es banco o autobanco (false=banco true=autobanco)
     * @param cajasAutobanco si es true se llena
     * @param uso parametro para saber cuantas veces se ha usado la agencia
     */
    public void CrearBanco(String agencia, int id, String direccion, String telefono, int cajas, int noEscritorios, double efectivo, boolean tipoAgencia, int cajasAutobanco, int uso) {
        banco[contadorBanco++] = new AgenciaBancaria(agencia, id, direccion, telefono, cajas, noEscritorios, efectivo, tipoAgencia, cajasAutobanco, uso);
    }

    public void CrearCliente(int idCliente, String nombre, String direccion, String telefono, int cantidadCuentas) {
        cliente[contadorCliente++] = new Cliente(idCliente, nombre, direccion, telefono, cantidadCuentas);
    }

    public void CrearCajero(int id, String ubicacion, double efectivo, boolean estado, int cantidadUsado) {
        cajero[contadorCajero++] = new CajeroAutomatico(id, ubicacion, efectivo, estado, cantidadUsado);
    }

    public void CrearEmpleado(String nombre, String direccion, String usuario, String contraseña) {

        empleado[contadorEmpleado++] = new Empleado(contadorEmpleado, nombre, direccion, "", 0, usuario, contraseña);
    }

    public void Cuentas() {
        cuenta[contadorCuenta++] = new CuentaBancaria(1, contadorCuenta, 20, 03, 2019, "AHORRO", 100, 0);
        cuenta[contadorCuenta++] = new CuentaBancaria(2, contadorCuenta, 20, 03, 2019, "AHORRO", 200, 0);
        cuenta[contadorCuenta++] = new CuentaBancaria(3, contadorCuenta, 20, 03, 2019, "AHORRO", 300, 0);
        cuenta[contadorCuenta++] = new CuentaBancaria(4, contadorCuenta, 20, 03, 2019, "MONETARIA", 400, 25);
        cuenta[contadorCuenta++] = new CuentaBancaria(5, contadorCuenta, 20, 03, 2019, "MONETARIA", 500, 25);
    }

    public void CrearCuenta(int id, int dia, int mes, int año, String tipoCuenta, double monto) {
        cuenta[contadorCuenta++] = new CuentaBancaria(id, contadorCuenta, dia, mes, año, tipoCuenta, monto, 0);

    }

    public void Cheque() {
        cheque[contadorCheque++] = new Cheques();
    }

    public Inicio() {
        //this.setLocation(500, 200); //Posición inicial de la ventana
        this.setSize(400, 400);//define el tamaño de la ventana
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // para terminar la ejecución de la ventana
        this.setTitle("Inicio");//Titulo de la ventana
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
        JLabel etiqueta1 = new JLabel("Bienvenido");
        etiqueta1.setBounds(150, 30, 120, 30);
        etiqueta1.setFont(new java.awt.Font("Tahoma", 0, 20));

        panel.add(etiqueta1);
    }

    private JButton btnLogin = new JButton();
    private JButton btnCajero = new JButton();

    private void Botones() {
        //propiedades btn login
        btnLogin.setBounds(150, 130, 100, 30);
        btnLogin.setText("Login");
        btnLogin.setEnabled(true);
        panel.add(btnLogin);

        //propiedades btn Cajero
        btnCajero.setBounds(150, 180, 100, 30);
        btnCajero.setText("Cajero");
        btnCajero.setEnabled(true);
        panel.add(btnCajero);

        //Agregando evento de tipo action Listener
        ActionListener oyente = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login ob = new Login();
                dispose();
                ob.setVisible(true); //Se Hace Visible la Ventana

            }
        };

        btnLogin.addActionListener(oyente);

        //boton cajaero
        ActionListener oyente2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginCajero login = new LoginCajero();
                dispose();
                login.setVisible(true);
            }
        };
        btnCajero.addActionListener(oyente2);

        //boton inicio
    }
}
