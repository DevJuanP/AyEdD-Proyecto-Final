package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import clases.*;
import arreglos.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogNuevaConsulta extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblConsultar;
	private JComboBox<String> cmbBuscar;
	private JButton btnBuscar;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JTextField txtCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogNuevaConsulta dialog = new DialogNuevaConsulta();
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
	public DialogNuevaConsulta() {
		setTitle("Nueva Consulta");
		setBounds(100, 100, 528, 398);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblConsultar = new JLabel("Consultar:");
		lblConsultar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConsultar.setBounds(21, 29, 88, 22);
		contentPanel.add(lblConsultar);
		
		cmbBuscar = new JComboBox<>();
		cmbBuscar.addItem("ALUMNO");
		cmbBuscar.addItem("CURSO");
		cmbBuscar.addItem("MATRICULA");
		cmbBuscar.addItem("RETIRO");
		cmbBuscar.setBounds(108, 32, 203, 21);
		contentPanel.add(cmbBuscar);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(this);
		
		btnBuscar.setBounds(363, 32, 129, 21);
		contentPanel.add(btnBuscar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 109, 472, 221);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(108, 61, 111, 19);
		contentPanel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblCodigo = new JLabel("CODIGO:");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCodigo.setBounds(21, 61, 88, 22);
		contentPanel.add(lblCodigo);
			
	}
	//DECLARACION GLOBAL
	ArreglosAlumno aa = new ArreglosAlumno();
	ArreglosMatricula am = new ArreglosMatricula();
	ArreglosCursos ac = new ArreglosCursos();
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
	}
	
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		  String categoria = (String) cmbBuscar.getSelectedItem();
		  String codigoTexto = txtCodigo.getText().trim();
		  if(codigoTexto.isEmpty()) {
			  JOptionPane.showMessageDialog(null, "Ingrese un código para buscar.");
	            return;
		  }
		  try {
			  int codigo= Integer.parseInt(codigoTexto);
			  String resultado = "";
			  switch (categoria) {
			  case "ALUMNO":
				  	txtCodigo.setText("");
				  	txtS.setText("");
				    Alumno a = aa.buscarCodigo(codigo);
				    if (a != null) {
				        resultado = "DATOS ALUMNOS\n\n" +
				                    "→Nombre \t: " + a.getNombres() + "\n" +
				                    "→Apellidos \t: " + a.getApellidos() + "\n" +
				                    "→Edad \t: " + a.getEdad() + "\n" +
				                    "→DNI \t: " + a.getDni() + "\n" +
				                    "→Teléfono \t: " + a.getCelular() + "\n" +
				                    "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -" + "\n" +
				                    "CUSOS MATRICULADOS:" + "\n\n";
				        
				        for (int i = 0; i < am.tamanio(); i++) {
				        	Matricula  m1 = am.obtener(i);
				            if (m1.getCodAlumno() == codigo) {
				                Curso c1 = ac.buscarCodigo(am.obtener(i).getCodCurso());
				                if (c1 != null) {
				                    resultado += "→  Código de curso \t: " + c1.getCodCurso() +"\n" +
										  		 "→  Asignatura \t\t: " + c1.getAsignatura() + "\n" +
										  		 "→  Ciclo \t\t: " + c1.getCiclo() + "\n" +
										  		 "→  Créditos \t\t: " + c1.getCreditos() + "\n" +
										  		 "→  Horas \t\t: " + c1.getHoras()+ "\n" +
				                    			 "**************************************************" + "\n";
				                }
				            }
				        }

				        txtS.append(resultado);
				    } else {
				        mensaje("Alumno no encontrado","Advertencia", JOptionPane.ERROR_MESSAGE);
				    }
				    break;
			  //////////////////////////////////////////////

			  case "CURSO":
					txtCodigo.setText("");
					txtS.setText("");
				  Curso c = ac.buscarCodigo(codigo);
				  if(c != null) {
					  resultado="→  Código de curso \t: " + c.getCodCurso() +"\n" +
							  	"→  Asignatura \t\t: " + c.getAsignatura() + "\n" +
							  	"→  Ciclo \t\t: " + c.getCiclo() + "\n" +
							  	"→  Créditos \t\t: " + c.getCreditos() + "\n" +
							  	"→  Horas \t\t: " + c.getHoras()+ "\n";
					  txtS.append(resultado);
				  }else {
					  mensaje("Curso no encontrado","Advertencia", JOptionPane.ERROR_MESSAGE);
				  }
				  break;
				  
			  //////////////////////////////////////////////	
			    
			  case "MATRICULA":
				  txtCodigo.setText("");
				  txtS.setText("");
				  Matricula m = am.buscarMatricula(codigo);
				  if(m != null) {
					  Alumno a2 = aa.buscarCodigo(m.getCodAlumno());
					  resultado = "DATOS DE LA MATRÍCULA" + "\n\n" +
							  	  "→  Código Matricula \t: " + m.getNumMatricula() + "\n" +
							  	  "→  Codigo Alumno \t: "+ a2.getCodAlumno() + "\n" +
			                      "→  Nombre \t\t: " + a2.getNombres() + "\n" +
			                      "→  Apellidos \t\t: " + a2.getApellidos() + "\n" +
			                      "→  Edad \t\t: " + a2.getEdad() + "\n" +
			                      "→  DNI \t\t: " + a2.getDni() + "\n" +
			                      "→  Teléfono \t\t: " + a2.getCelular() + "\n" +
			                      "--------------------------------------------------\n\n" +
			                      "CUSOS MATRICULADOS:" + "\n\n";
					  
					  for (int i = 0; i < am.tamanio(); i++) {
						  Matricula m2 = am.obtener(i);
				            if (m2.getCodAlumno() == a2.getCodAlumno()) {
				                Curso c2 = ac.buscarCodigo(am.obtener(i).getCodCurso());
				                if (c2 != null) {
				                    resultado += "→  Código de curso \t: " + c2.getCodCurso() +"\n" +
										  		 "→  Asignatura \t\t: " + c2.getAsignatura() + "\n" +
										  		 "→  Ciclo \t\t: " + c2.getCiclo() + "\n" +
										  		 "→  Créditos \t\t: " + c2.getCreditos() + "\n" +
										  		 "→  Horas \t\t: " + c2.getHoras()+ "\n" +
										  		 "→  Fecha matrícula \t: " + m2.getFecha() + "\n" +
				                                 "→  Hora matrícula \t: " + m2.getHora()+ "\n" +
				                    			 "**************************************************" + "\n";
				                }
				            }
				        }
					  txtS.setText(resultado);
				  }else {
					  mensaje("Matricula no encontrado","Advertencia", JOptionPane.ERROR_MESSAGE);
				  }
				  break;
			  }
		 }catch(Exception x) {
			 JOptionPane.showMessageDialog(null, "Ingrese un c�digo para buscar.");
					 return;
		}
	}
	
	void mensaje(String s, String titulo, int tipo) {
		JOptionPane.showMessageDialog(null, s, titulo, tipo);
	}
	
	
}

