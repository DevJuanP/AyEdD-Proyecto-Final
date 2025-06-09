package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import clases.Alumno;

import javax.swing.*;

import java.util.ArrayList;


public class AlumnoGui extends JFrame {

	private JPanel contentPane;
	private JPanel panelConsulta;

	public static void main(String[] args) {
		AlumnoGui frame = new AlumnoGui();
		frame.setVisible(true);
	}

	public AlumnoGui() {
		setTitle("Mantenimiento de Alumno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 600);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("MANTENIMIENTO ALUMNO");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTitle.setBounds(0, 0, 900, 26);
		lblTitle.setOpaque(true); 
		lblTitle.setBackground(new Color(0, 0, 0));
		getContentPane().add(lblTitle);
		
		JLabel lblNombre = new JLabel("Nombres :");
		lblNombre.setBounds(25, 75, 120, 25);
		getContentPane().add(lblNombre);
		
		JTextField txtNombre = new JTextField();
		txtNombre.setBounds(120, 75, 420, 25);
		getContentPane().add(txtNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos :");
		lblApellidos.setBounds(25, 110, 120, 25);
		getContentPane().add(lblApellidos);
		
		JTextField txtApellidos = new JTextField();
		txtApellidos.setBounds(120, 110, 420, 25);
		getContentPane().add(txtApellidos);
		
		JLabel lblCodigo = new JLabel("Código :");
		lblCodigo.setBounds(25, 40, 120, 25);
		getContentPane().add(lblCodigo);
		
		JTextField txtCodigo = new JTextField();
		txtCodigo.setBounds(120, 40, 100, 25);
		txtCodigo.setEditable(false);
		getContentPane().add(txtCodigo);
		
		JLabel lblTelefono = new JLabel("Telefono :");
		lblTelefono.setBounds(600, 75, 70, 25);
		getContentPane().add(lblTelefono);
		
		JTextField txtTelefono = new JTextField();
		txtTelefono.setBounds(690, 75, 150, 25);
		getContentPane().add(txtTelefono);
		
		JLabel lblDNI = new JLabel("DNI :");
		lblDNI.setBounds(600, 110, 70, 25);
		getContentPane().add(lblDNI);
		
		JTextField txtDNI = new JTextField();
		txtDNI.setBounds(690, 110, 150, 25);
		getContentPane().add(txtDNI);
		
		panelConsulta = new JPanel();
		panelConsulta.setLayout(null); 
		panelConsulta.setBorder(new TitledBorder("Consulta"));
		panelConsulta.setBounds(25, 160, 810, 65); 
		getContentPane().add(panelConsulta);
		
		JRadioButton rdbDni = new JRadioButton("DNI");
        rdbDni.setBounds(45,25, 60, 20);
        panelConsulta.add(rdbDni);

        JRadioButton rdbApellidos = new JRadioButton("Apellidos");
        rdbApellidos.setBounds(130, 25, 100, 20);
        panelConsulta.add(rdbApellidos);

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(rdbDni);
        grupo.add(rdbApellidos);
        
        JTextField txtBuscar = new JTextField();
        txtBuscar.setBounds(240, 25, 370, 25);
        panelConsulta.add(txtBuscar);
        
        JButton btnBuscar = new JButton("Buscar 🔍");
        btnBuscar.setBounds(662, 25, 100, 25);
        panelConsulta.add(btnBuscar);
        
        //tablas:
        String[] columnas = {"Código", "Nombre", "Apellidos", "Teléfono", "DNI", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
        JTable tblAlumnos = new JTable(modelo);
        JScrollPane scrTabla = new JScrollPane(tblAlumnos);
        scrTabla.setBounds(30, 250, 810, 250);
        getContentPane().add(scrTabla);
        
        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(120, 520, 100, 25);
        getContentPane().add(btnAgregar);
        
        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(290, 520, 100, 25);
        getContentPane().add(btnRegistrar);
        
        JButton btnModificar = new JButton("Modificar");
        btnModificar.setBounds(460, 520, 100, 25);
        getContentPane().add(btnModificar);
        
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(630, 520, 100, 25);
        getContentPane().add(btnEliminar);
        
        ArrayList<Alumno> alumnos = new ArrayList<>();
        
        btnAgregar.addActionListener(e -> {
        	String nombre = txtNombre.getText();
        	String Apellidos = txtApellidos.getText();
        	String DNI = txtDNI.getText();
        	int telefono = Integer.parseInt(txtTelefono.getText());
        	
        	Alumno a = new Alumno(22, telefono, nombre, Apellidos, DNI);
        	txtCodigo.setText(""+a.getCodAlumno());
        	alumnos.add(a);
        	
        	modelo.addRow(new Object[] {a.getCodAlumno(),a.getNombres(), a.getApellidos(), a.getCelular(), a.getDni(), a.getEstado()});
        });
        
	}
	

}
