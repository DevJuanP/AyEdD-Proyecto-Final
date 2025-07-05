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
	ArreglosCursos ac = new ArreglosCursos();
	
	private JTextArea txtArea;
	private JScrollPane scrollPane;
	private JComboBox <String> cmbCategoria;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogNuevoReporte dialog = new DialogNuevoReporte();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogNuevoReporte() {
		setTitle("Nuevo Reporte");
		setBounds(100, 100, 476, 528);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		cmbCategoria = new JComboBox<String>();
		cmbCategoria.setModel(new DefaultComboBoxModel<String>(new String[] {"Matricula Pendiente", "Matricula vigente", "Alumno por curso"}));
		cmbCategoria.setBounds(128, 34, 180, 21);
		contentPanel.add(cmbCategoria);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 65, 425, 398);
		contentPanel.add(scrollPane);
		
		txtArea = new JTextArea();
		scrollPane.setViewportView(txtArea);
		
		btnNewButton = new JButton("CARGAR");
		btnNewButton.setBounds(330, 34, 115, 21);
		contentPanel.add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("Tipo de reporte:");
		lblNewLabel_1.setBounds(20, 34, 98, 17);
		contentPanel.add(lblNewLabel_1);
		/*
		 Alumnos con matrÃ­cula pendiente: mostar los datos completos de aquellos alumnos
que solamente estÃ¡n registrados.
ïƒ° Alumnos con matrÃ­cula vigente: mostar los datos completos de aquellos alumnos
que solamente estÃ¡n matriculados.
ïƒ° Alumnos matriculados por curso: mostar los nombres de los alumnos matriculados
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
				txtArea.append("→  Nombre: " + a.getNombres() + "\n");
				txtArea.append("→  Apellidos: " + a.getApellidos() + "\n");
				txtArea.append("→  Celular: " + a.getCelular() + "\n");
				txtArea.append("→  DNI: " + a.getDni() + "\n");
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
						 sb.append("CÃ³digo: ").append(a.getCodAlumno()).append("\n");
			                sb.append("Nombre: ").append(a.getNombres()).append("\n");
			                sb.append("Apellidos: ").append(a.getApellidos()).append("\n");
			                sb.append("DNI: ").append(a.getDni()).append("\n");
			                sb.append("Celular: ").append(a.getCelular()).append("\n");
			               
			                sb.append("-----------------------------\n");
						 
						 
					 }
				 }
				 if (sb.length() == 0) {
			            txtArea.setText("Todos los alumnos estÃ¡n matriculados.");
			        } else {
			            txtArea.setText(sb.toString());
			        }
				 
		 */
		void mostrarMatriculaVigente() {
			txtArea.setText("");
			for (int i = 0; i < arregloAlumno.tamanio(); i++) {
				Alumno a = arregloAlumno.obtener(i);
				if (a.getEstado() == 1) {
					txtArea.append("→  Nombre: " + a.getNombres() + "\n");
					txtArea.append("→  Apellidos: " + a.getApellidos() + "\n");
					txtArea.append("→  Celular: " + a.getCelular() + "\n");
					txtArea.append("→  DNI: " + a.getDni() + "\n");
					txtArea.append("----------------------------------------------------------\n");
				} 
				
			}
			
			if(txtArea.getText().isEmpty()){
				txtArea.setText("");
				txtArea.append("TODOS ESTAN MATRICULADOS");
				
			}
		}
		
		void mostrarAlumnoPorCurso() {
			txtArea.setText("");
			for(Curso c : ac.getCursoLista()) {
				imprimir("Alumnos matriculdos en "+c.getAsignatura()+" :");
				int acum = 0;
				for(Matricula m : arregloMatricula.getMatricula001()) {
					if(c.getCodCurso() == m.getCodCurso()) {
						Alumno a = arregloAlumno.buscarCodigo(m.getCodAlumno());
						if(a != null) {
							listarAlumno(a);
							acum ++;	
						}
					}
				}
				if(acum == 0) {
					imprimir("  Aún ningún alumno matriculado en este curso");
					imprimir("-----------------------------------------------------------------");
					
				}
			}
			
		}
		private void listarAlumno(Alumno a) {
			txtArea.append("→  Nombre: " + a.getNombres() + "\n");
			txtArea.append("→  Apellidos: " + a.getApellidos() + "\n");
			txtArea.append("→  Celular: " + a.getCelular() + "\n");
			txtArea.append("→  DNI: " + a.getDni() + "\n");
			txtArea.append("-----------------------------------------------------------\n");
		}
		
		private void imprimir(String s) {
			txtArea.append(s+"\n");
		}
		private void imprimir() {
			imprimir("");
		}
}
