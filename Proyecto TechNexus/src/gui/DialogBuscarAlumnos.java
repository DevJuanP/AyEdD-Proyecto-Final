package gui;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import arreglos.ArreglosAlumno;
import arreglos.ArreglosMatricula;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import clases.Alumno;
import clases.Curso;

public class DialogBuscarAlumnos extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lblAsignatura;
	private JTextField txtBuscar;
	private JButton btEnviar;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel modeloBuscar;
	public DialogRegistroMatricula dlgRMatricula;

	// Constructor que recibe el formulario principal
	public DialogBuscarAlumnos(DialogRegistroMatricula dlg) {
	    this.dlgRMatricula = dlg;
	    initComponents();// Llama a la función que construye la interfaz
	}
	
	private void initComponents() {
		setTitle("Buscar Alumnos");
		setBounds(100, 100, 607, 276);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblAsignatura = new JLabel("Apellido: ");
		lblAsignatura.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAsignatura.setBounds(22, 11, 96, 17);
		contentPane.add(lblAsignatura);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(120, 12, 223, 19);
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		btEnviar = new JButton("Enviar");
		btEnviar.addActionListener(this);
		btEnviar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btEnviar.setBounds(488, 10, 85, 21);
		contentPane.add(btEnviar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 49, 551, 171);
		contentPane.add(scrollPane);
		
		table = new JTable();
		String[] columnas = {"Cï¿½digo", "Nombre", "Apellidos", "Edad", "Telï¿½fono", "DNI", "Estado"};
		modeloBuscar = new DefaultTableModel(columnas, 0);
		table.setModel(modeloBuscar);
		
		table.setModel(modeloBuscar);
		scrollPane.setViewportView(table);
		
		cargarTabla("");
		
		// Filtrado en tiempo real
				txtBuscar.getDocument().addDocumentListener(new DocumentListener() {
					public void insertUpdate(DocumentEvent e) {
						cargarTabla(txtBuscar.getText());
					}
					public void removeUpdate(DocumentEvent e) {
						cargarTabla(txtBuscar.getText());
					}
					public void changedUpdate(DocumentEvent e) {
						cargarTabla(txtBuscar.getText());
					}
				});
	}

	// Declaracion global
	ArreglosAlumno aa = new ArreglosAlumno();
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btEnviar) {
			actionPerformedBtEnviar(e);
		}
		
	}
	protected void actionPerformedBtEnviar(ActionEvent e) {
		int fila = table.getSelectedRow();
		if (fila == -1) {
			JOptionPane.showMessageDialog(this, "Selecciona una fila", "Advertencia", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		int cod = Integer.parseInt(table.getValueAt(fila, 0).toString());
		String nom = table.getValueAt(fila, 1).toString();
		String ape = table.getValueAt(fila, 2).toString();
		int edad = Integer.parseInt(table.getValueAt(fila, 3).toString());
		int cel = Integer.parseInt(table.getValueAt(fila, 4).toString());
		String dni = table.getValueAt(fila, 5).toString();
		int estado = Integer.parseInt(table.getValueAt(fila, 6).toString());
	
		Alumno a = new Alumno(cod, nom, ape, edad, cel, dni, estado);
		dlgRMatricula.leerBusqueda_2(a);
		dispose();
	}
	
	
	private void cargarTabla(String filtro) {
		modeloBuscar.setRowCount(0);
		
		for (int i = 0; i < aa.tamanio(); i++) {
			Alumno a = aa.obtener(i);
			if(filtro.isEmpty() || a.getApellidos().toLowerCase().contains(filtro.toLowerCase())) {
				modeloBuscar.addRow(new Object[] {
					a.getCodAlumno(),
					a.getNombres(),
					a.getApellidos(),
					a.getEdad(),
					a.getCelular(),
					a.getDni(),
					a.getEstado()
				});
			}
		}
	}

	public void setModal(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
