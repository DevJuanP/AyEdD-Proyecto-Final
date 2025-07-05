package gui;
import clases.*;
import arreglos.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.HashSet;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogNuevoReporte extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	
	
	ArreglosAlumno arregloAlumno = new ArreglosAlumno();
	ArreglosMatricula arregloMatricula = new ArreglosMatricula();
	private JTextArea txtArea;
	private JScrollPane scrollPane;
	private JComboBox cmbCategoria;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogNuevoReporte dialog = new DialogNuevoReporte();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogNuevoReporte() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("REPORTE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(175, 10, 75, 30);
		contentPanel.add(lblNewLabel);
		
		cmbCategoria = new JComboBox();
		cmbCategoria.setModel(new DefaultComboBoxModel(new String[] {"Matricula Pendiente", "Matricula vigente", "Alumno por curso"}));
		cmbCategoria.setBounds(20, 64, 167, 21);
		contentPanel.add(cmbCategoria);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 95, 416, 158);
		contentPanel.add(scrollPane);
		
		txtArea = new JTextArea();
		scrollPane.setViewportView(txtArea);
		
		btnNewButton = new JButton("CARGAR");
		btnNewButton.setBounds(200, 64, 85, 21);
		contentPanel.add(btnNewButton);
		/*
		 Alumnos con matrícula pendiente: mostar los datos completos de aquellos alumnos
que solamente están registrados.
 Alumnos con matrícula vigente: mostar los datos completos de aquellos alumnos
que solamente están matriculados.
 Alumnos matriculados por curso: mostar los nombres de los alumnos matriculados
en cada uno de los cursos
		 */
		 

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String opcion = cmbCategoria.getSelectedItem().toString();

				 if (opcion.equals("Matricula Pendiente")) {
						mostrarMatriculaPendiente();
					} else if (opcion.equals("Matricula vigente")) {
						mostrarMatriculaVigente();
					} else if (opcion.equals("Alumno por curso")) {
						mostrarAlumnoPorCurso();
					}
			    
				
				
			}
		});
	}
	
	void mostrarMatriculaPendiente() {
		txtArea.setText("");
		for (int i = 0; i < arregloAlumno.tamanio(); i++) {
			Alumno a = arregloAlumno.obtener(i);
			if (a.getEstado() == 0) {
				txtArea.append("Nombre: " + a.getNombres() + "\n");
				txtArea.append("Apellidos: " + a.getApellidos() + "\n");
				txtArea.append("Celular: " + a.getCelular() + "\n");
				txtArea.append("DNI: " + a.getDni() + "\n");
				txtArea.append("--------------------------\n");
			} 
			
		}
		
		if(txtArea.getText().isEmpty()){
			txtArea.setText("");
			txtArea.append("TODOS ESTAN MATRICULADOS");
			
		}
	} 
			
		
		/*	StringBuilder sb = new StringBuilder();
				 HashSet<Integer>CodigosMatriculados = new HashSet<>();
				 for ( int i=0 ; i< arregloMatricula.tamanio();i++) {
					 Matricula m = arregloMatricula.obtener(i);
					 CodigosMatriculados.add(m.getCodAlumno());
				 }
				 for (int i = 0 ;i < arregloAlumno.tamanio();i++) {
					 Alumno a = arregloAlumno.obtener(i);
					 if(!CodigosMatriculados.contains(a.getCodAlumno())) {
						 sb.append("Código: ").append(a.getCodAlumno()).append("\n");
			                sb.append("Nombre: ").append(a.getNombres()).append("\n");
			                sb.append("Apellidos: ").append(a.getApellidos()).append("\n");
			                sb.append("DNI: ").append(a.getDni()).append("\n");
			                sb.append("Celular: ").append(a.getCelular()).append("\n");
			               
			                sb.append("-----------------------------\n");
						 
						 
					 }
				 }
				 if (sb.length() == 0) {
			            txtArea.setText("Todos los alumnos están matriculados.");
			        } else {
			            txtArea.setText(sb.toString());
			        }
				 
		 */
		void mostrarMatriculaVigente() {
			txtArea.setText("");
			for (int i = 0; i < arregloAlumno.tamanio(); i++) {
				Alumno a = arregloAlumno.obtener(i);
				if (a.getEstado() == 1) {
					txtArea.append("Nombre: " + a.getNombres() + "\n");
					txtArea.append("Apellidos: " + a.getApellidos() + "\n");
					txtArea.append("Celular: " + a.getCelular() + "\n");
					txtArea.append("DNI: " + a.getDni() + "\n");
					txtArea.append("--------------------------\n");
				} 
				
			}
			
			if(txtArea.getText().isEmpty()){
				txtArea.setText("");
				txtArea.append("TODOS ESTAN MATRICULADOS");
				
			}
		}
		
		void mostrarAlumnoPorCurso() {
			
			
		}
}
