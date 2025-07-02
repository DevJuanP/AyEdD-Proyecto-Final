package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import arreglos.ArreglosAlumno;
import clases.Alumno;

import javax.swing.*;

import java.util.ArrayList;

import java.awt.event.ActionListener;


public class DialogMantenimientoAlumno extends JDialog implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JPanel panelConsulta;
	
	private JLabel lblTitle;
	
	private JLabel lblNombre;
	private JTextField txtNombre;
	
	private JLabel lblApellidos;
	private JTextField txtApellidos;
	
	private JLabel lblCodigo;
	private JTextField txtCodigo;
	
	private JLabel lblEdad;
	private JTextField txtEdad;
	
	private JLabel lblTelefono;
	private JTextField txtTelefono;
	
	private JLabel lblDNI;
	private JTextField txtDNI;
	
	private JRadioButton rdbDni;
	private JRadioButton rdbApellidos;
	private ButtonGroup grupo;
	
	private JTextField txtBuscar;
	private JButton btnBuscar;
	
	private JTable tblAlumnos;
	private JScrollPane scrollTabla;
	
	private JButton btnNuevo;
	private JButton btnRegistrar;
	private JButton btnModificar;
	private JButton btnEliminar;
	public static ArreglosAlumno alumnosList = new ArreglosAlumno();
	
	//otros
	private DefaultTableModel modelo;
	
	

	public static void main(String[] args) {
		//cargarAlumnos();
		DialogMantenimientoAlumno dialog = new DialogMantenimientoAlumno();
		dialog.setVisible(true);
		dialog.setLocationRelativeTo(null);
	}

	public DialogMantenimientoAlumno() {
		setTitle("Mantenimiento de Alumno");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(695, 446);
		setSize(900, 600);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		lblTitle = new JLabel("MANTENIMIENTO ALUMNO");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTitle.setBounds(0, 0, 681, 34);
		lblTitle.setOpaque(true); 
		lblTitle.setBackground(new Color(0, 0, 0));
		getContentPane().add(lblTitle);
		
		lblNombre = new JLabel("Nombres :");
		lblNombre.setBounds(25, 75, 120, 25);
		getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(120, 78, 270, 19);
		getContentPane().add(txtNombre);
		
		lblApellidos = new JLabel("Apellidos :");
		lblApellidos.setBounds(25, 110, 120, 25);
		getContentPane().add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(120, 110, 270, 19);
		getContentPane().add(txtApellidos);
		
		lblCodigo = new JLabel("Código :");
		lblCodigo.setBounds(25, 40, 120, 25);
		getContentPane().add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(120, 46, 100, 19);
		txtCodigo.setEditable(false);
		getContentPane().add(txtCodigo);
		
		lblEdad = new JLabel("Edad :");
		lblEdad.setBounds(414, 40, 120, 25);
		getContentPane().add(lblEdad);
		
		txtEdad = new JTextField();
		txtEdad.setBounds(504, 43, 100, 19);
		getContentPane().add(txtEdad);
		
		lblTelefono = new JLabel("Telefono :");
		lblTelefono.setBounds(414, 75, 70, 25);
		getContentPane().add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(504, 78, 150, 19);
		getContentPane().add(txtTelefono);
		
		lblDNI = new JLabel("DNI :");
		lblDNI.setBounds(414, 110, 70, 25);
		getContentPane().add(lblDNI);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(504, 113, 150, 19);
		getContentPane().add(txtDNI);
		
		panelConsulta = new JPanel();
		panelConsulta.setForeground(Color.GRAY);
		panelConsulta.setLayout(null); 
		panelConsulta.setBorder(new TitledBorder(new LineBorder(Color.GRAY),"Consulta"));
		panelConsulta.setBounds(25, 145, 635, 65); 
		getContentPane().add(panelConsulta);
		
		rdbDni = new JRadioButton("DNI");
        rdbDni.setBounds(45,25, 60, 20);
        panelConsulta.add(rdbDni);

        rdbApellidos = new JRadioButton("Apellidos");
        rdbApellidos.setBounds(107, 25, 74, 20);
        panelConsulta.add(rdbApellidos);

        grupo = new ButtonGroup();
        grupo.add(rdbDni);
        grupo.add(rdbApellidos);
        
        txtBuscar = new JTextField();
        txtBuscar.setBounds(197, 23, 267, 20);
        panelConsulta.add(txtBuscar);
        
        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(474, 22, 100, 20);
        panelConsulta.add(btnBuscar);
        
        //tablas:
        String[] columnas = {"Código", "Nombre", "Apellidos", "Edad", "Teléfono", "DNI", "Estado"};
        modelo = new DefaultTableModel(columnas, 0);
        
        tblAlumnos = new JTable(modelo);
        scrollTabla = new JScrollPane(tblAlumnos);
        
        scrollTabla.setBounds(30, 220, 624, 143);
        getContentPane().add(scrollTabla);
        
        //carga la tabla
        
        cargarTabla();
        //cargarAlumnos();
        
        //botones        
        btnNuevo = new JButton("Nuevo");
        btnNuevo.setBounds(56, 373, 100, 25);
        getContentPane().add(btnNuevo);
        btnNuevo.addActionListener(this);
        
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(212, 373, 100, 25);
        getContentPane().add(btnRegistrar);
        btnRegistrar.addActionListener(this);
        
        btnModificar = new JButton("Modificar");
        btnModificar.setBounds(368, 373, 100, 25);
        getContentPane().add(btnModificar);
        
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(524, 373, 100, 25);
        getContentPane().add(btnEliminar);
        
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnRegistrar) {
			doBtnRegistrarActionPerformed(e);
		}
		if(e.getSource() == btnNuevo) {
			doBtnNuevoActionPerformed(e);
		}
	}
	
	protected void doBtnNuevoActionPerformed(ActionEvent e) {
		int newcod = alumnosList.getNextCodigo();
		limpiarImputs();
		txtCodigo.setText(""+newcod);
	}
	
	protected void doBtnRegistrarActionPerformed(ActionEvent e) {
		Alumno datos = leerDatos();
    	
    	Alumno a = new Alumno(datos.getEdad(), datos.getCelular(), datos.getNombres(), datos.getApellidos(), datos.getDni());
    	alumnosList.adicionar(a);
    	alumnosList.cargarALToTxtfile();//para actualizar
    	imprimirDatos(a);
    	limpiarImputs();
	}
	
	//metodos de agregar:
	private Alumno leerDatos() {
		String nombre = txtNombre.getText();
    	String Apellidos = txtApellidos.getText();
    	String DNI = txtDNI.getText();
    	int Edad  = Integer.parseInt(txtEdad.getText());
    	int telefono = Integer.parseInt(txtTelefono.getText());
    	
    	return new Alumno(Edad, telefono, nombre, Apellidos, DNI, "LEER_DATOS");
	}
	private void imprimirDatos(Alumno a) {
		txtCodigo.setText(""+a.getCodAlumno());
    	modelo.addRow(new Object[] {a.getCodAlumno(),a.getNombres(), a.getApellidos(), a.getEdad(), a.getCelular(), a.getDni(), a.getEstado()});
	}
	private void limpiarImputs() {
		txtNombre.setText("");
		txtApellidos.setText("");
		txtCodigo.setText("");
		txtEdad.setText("");
		txtTelefono.setText("");
		txtDNI.setText("");
	}
	
	private void cargarTabla() {
		for (Alumno a : alumnosList.getAlumnosList()) {
		    modelo.addRow(new Object[] {a.getCodAlumno(),a.getNombres(), a.getApellidos(), a.getEdad(), a.getCelular(), a.getDni(), a.getEstado()});
		}
	}

}
