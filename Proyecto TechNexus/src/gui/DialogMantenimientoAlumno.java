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
		setBounds(100, 100, 697, 445);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		lblTitle = new JLabel("MANTENIMIENTO ALUMNO");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTitle.setBounds(0, 0, 686, 34);
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
        btnBuscar.addActionListener(this);
        btnBuscar.setBounds(474, 22, 100, 20);
        panelConsulta.add(btnBuscar);
        
        //tablas:
        String[] columnas = {"Código", "Nombre", "Apellidos", "Edad", "Teléfono", "DNI", "Estado"};
        modelo = new DefaultTableModel(columnas, 0);
        
        tblAlumnos = new JTable(modelo);
        scrollTabla = new JScrollPane(tblAlumnos);
        
        scrollTabla.setBounds(30, 220, 624, 143);
        getContentPane().add(scrollTabla);
        
        tblAlumnos.getSelectionModel().addListSelectionListener(e ->{
        	if(!e.getValueIsAdjusting() && tblAlumnos.getSelectedRow() != -1) {
        		int fila = tblAlumnos.getSelectedRow();
        		if(fila == -1) {
        			JOptionPane.showMessageDialog(this, "Seleccione una fila para editar.");
        			return;
        		}
        		txtCodigo.setText(tblAlumnos.getValueAt(fila, 0).toString());
        		txtNombre.setText(tblAlumnos.getValueAt(fila, 1).toString());
        		txtApellidos.setText(tblAlumnos.getValueAt(fila, 2).toString());
        		txtEdad.setText(tblAlumnos.getValueAt(fila, 3).toString());
        		txtTelefono.setText(tblAlumnos.getValueAt(fila, 4).toString());
        		txtDNI.setText(tblAlumnos.getValueAt(fila, 5).toString());
        	}
   
        });
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
        btnModificar.addActionListener(this);
        btnModificar.setBounds(368, 373, 100, 25);
        getContentPane().add(btnModificar);
        
        btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(this);
        btnEliminar.setBounds(524, 373, 100, 25);
        getContentPane().add(btnEliminar);
        
	}
	
	//Delcaracion global
	ArreglosAlumno aa = new ArreglosAlumno();
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
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
    	cargarTabla();
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

	private void limpiarImputs() {
		txtNombre.setText("");
		txtApellidos.setText("");
		txtCodigo.setText("");
		txtEdad.setText("");
		txtTelefono.setText("");
		txtDNI.setText("");
	}
	
	private void cargarTabla() {
		modelo.setRowCount(0);
		for (Alumno a : alumnosList.getAlumnosList()) {
		    modelo.addRow(new Object[] {a.getCodAlumno(),a.getNombres(), a.getApellidos(), a.getEdad(), a.getCelular(), a.getDni(), a.getEstado()});
		}
	}

	protected void actionPerformedBtnEliminar(ActionEvent e) {
		 try {
		        int fila = tblAlumnos.getSelectedRow();
		        if (fila == -1) {
		            JOptionPane.showMessageDialog(this, "Selecciona primero un registro", "Advertencia", JOptionPane.WARNING_MESSAGE);
		            return;
		        }

		        int codigo = Integer.parseInt(tblAlumnos.getValueAt(fila, 0).toString());
		        Alumno x = alumnosList.buscarCodigo(codigo);
		        if (x == null) {
		            JOptionPane.showMessageDialog(this, "Alumno no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
		        } else {
		            int respuesta = JOptionPane.showConfirmDialog(this, "¿Desea eliminar este alumno?", "Confirmar", JOptionPane.YES_NO_OPTION);
		            if (respuesta == JOptionPane.YES_OPTION) {
		                alumnosList.Eliminar(x);
		                alumnosList.actualizarArchivo(); 
		                cargarTabla();
		                limpiarImputs();
		                JOptionPane.showMessageDialog(this, "Alumno eliminado correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
		            }
		        }
		    } catch (Exception e2) {
		        JOptionPane.showMessageDialog(this, "Error al intentar eliminar: " + e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		    }
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		try {
	        int codigo = Integer.parseInt(txtCodigo.getText().trim());
	        Alumno a = alumnosList.buscarCodigo(codigo);
	        if (a == null) {
	            JOptionPane.showMessageDialog(this, "El código no existe");
	            return;
	        }
	        a.setNombres(txtNombre.getText().trim());
	        a.setApellidos(txtApellidos.getText().trim());
	        a.setEdad(Integer.parseInt(txtEdad.getText().trim()));
	        a.setCelular(Integer.parseInt(txtTelefono.getText().trim()));
	        a.setDni(txtDNI.getText().trim());
	        alumnosList.actualizarArchivo();
	        cargarTabla();
	        limpiarImputs();
	        JOptionPane.showMessageDialog(this, "Alumno modificado correctamente");
	    } catch (Exception e2) {
	        JOptionPane.showMessageDialog(this, "Error al modificar alumno. Verifique los datos.");
	    }
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		String criterio = txtBuscar.getText().trim();
		modelo = (DefaultTableModel) tblAlumnos.getModel();

		// Si el campo de búsqueda está vacío, restaurar todos los alumnos
		if (criterio.isEmpty()) {
		    modelo.setRowCount(0);
		    cargarTabla(); // vuelve a mostrar todos los alumnos
		    return;
		}

		// Crear modelo temporal para resultados filtrados
		DefaultTableModel modeloFiltrado = new DefaultTableModel();

		// Copiar las columnas del modelo original
		for (int i = 0; i < modelo.getColumnCount(); i++) {
		    modeloFiltrado.addColumn(modelo.getColumnName(i));
		}

		// Recorrer todas las filas del modelo original
		for (int i = 0; i < modelo.getRowCount(); i++) {
		    String buscarValor = "";

		    if (rdbDni.isSelected()) {
		        buscarValor = modelo.getValueAt(i, 5).toString(); // Columna 5: DNI
		    } else if (rdbApellidos.isSelected()) {
		        buscarValor = modelo.getValueAt(i, 2).toString(); // Columna 2: Apellidos
		    }

		    if (buscarValor.toLowerCase().contains(criterio.toLowerCase())) {
		        Object[] fila = new Object[modelo.getColumnCount()];
		        for (int j = 0; j < modelo.getColumnCount(); j++) {
		            fila[j] = modelo.getValueAt(i, j);
		        }
		        modeloFiltrado.addRow(fila);
		    }
		}

		// Mostrar el modelo filtrado en la tabla
		tblAlumnos.setModel(modeloFiltrado);
	}
}
