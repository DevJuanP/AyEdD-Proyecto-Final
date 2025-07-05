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
	ArreglosRetiro ar = new ArreglosRetiro();
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
	}
	
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		  String categoria = (String) cmbBuscar.getSelectedItem();
		  String codigoTexto = txtCodigo.getText().trim();
		  if(codigoTexto.isEmpty()) {
			  JOptionPane.showMessageDialog(null, "Ingrese un cÃ³digo para buscar.");
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
				                    "â†’Nombre \t: " + a.getNombres() + "\n" +
				                    "â†’Apellidos \t: " + a.getApellidos() + "\n" +
				                    "â†’Edad \t: " + a.getEdad() + "\n" +
				                    "â†’DNI \t: " + a.getDni() + "\n" +
				                    "â†’TelÃ©fono \t: " + a.getCelular() + "\n" +
				                    "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -" + "\n" +
				                    "CUSOS MATRICULADOS:" + "\n\n";
				        
				        for (int i = 0; i < am.tamanio(); i++) {
				        	Matricula  m1 = am.obtener(i);
				            if (m1.getCodAlumno() == codigo) {
				                Curso c1 = ac.buscarCodigo(am.obtener(i).getCodCurso());
				                if (c1 != null) {
				                    resultado += "â†’  CÃ³digo de curso \t: " + c1.getCodCurso() +"\n" +
										  		 "â†’  Asignatura \t\t: " + c1.getAsignatura() + "\n" +
										  		 "â†’  Ciclo \t\t: " + c1.getCiclo() + "\n" +
										  		 "â†’  CrÃ©ditos \t\t: " + c1.getCreditos() + "\n" +
										  		 "â†’  Horas \t\t: " + c1.getHoras()+ "\n" +
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
					  resultado="â†’  CÃ³digo de curso \t: " + c.getCodCurso() +"\n" +
							  	"â†’  Asignatura \t\t: " + c.getAsignatura() + "\n" +
							  	"â†’  Ciclo \t\t: " + c.getCiclo() + "\n" +
							  	"â†’  CrÃ©ditos \t\t: " + c.getCreditos() + "\n" +
							  	"â†’  Horas \t\t: " + c.getHoras()+ "\n";
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
					  resultado = "DATOS DE LA MATRÃ�CULA" + "\n\n" +
							  	  "â†’  CÃ³digo Matricula \t: " + m.getNumMatricula() + "\n" +
							  	  "â†’  Codigo Alumno \t: "+ a2.getCodAlumno() + "\n" +
			                      "â†’  Nombre \t\t: " + a2.getNombres() + "\n" +
			                      "â†’  Apellidos \t\t: " + a2.getApellidos() + "\n" +
			                      "â†’  Edad \t\t: " + a2.getEdad() + "\n" +
			                      "â†’  DNI \t\t: " + a2.getDni() + "\n" +
			                      "â†’  TelÃ©fono \t\t: " + a2.getCelular() + "\n" +
			                      "--------------------------------------------------\n\n" +
			                      "CUSOS MATRICULADOS:" + "\n\n";
					  
					  for (int i = 0; i < am.tamanio(); i++) {
						  Matricula m2 = am.obtener(i);
				            if (m2.getCodAlumno() == a2.getCodAlumno()) {
				                Curso c2 = ac.buscarCodigo(am.obtener(i).getCodCurso());
				                if (c2 != null) {
				                    resultado += "â†’  CÃ³digo de curso \t: " + c2.getCodCurso() +"\n" +
										  		 "â†’  Asignatura \t\t: " + c2.getAsignatura() + "\n" +
										  		 "â†’  Ciclo \t\t: " + c2.getCiclo() + "\n" +
										  		 "â†’  CrÃ©ditos \t\t: " + c2.getCreditos() + "\n" +
										  		 "â†’  Horas \t\t: " + c2.getHoras()+ "\n" +
										  		 "â†’  Fecha matrÃ­cula \t: " + m2.getFecha() + "\n" +
				                                 "â†’  Hora matrÃ­cula \t: " + m2.getHora()+ "\n" +
				                    			 "**************************************************" + "\n";
				                }
				            }
				        }
					  txtS.setText(resultado);
				  }else {
					  mensaje("Matricula no encontrado","Advertencia", JOptionPane.ERROR_MESSAGE);
				  }
				  break;
				  
			  case "RETIRO":
				  Retiro r = ar.buscar(codigo);
				  if(r != null) {
					  
					  int codM = r.getCodMatricula();
					  Matricula matri = am.buscarMatricula(codM);
					  Alumno a3 = aa.buscarCodigo(matri.getCodAlumno());
					  Curso c3 = ac.buscarCodigo(matri.getCodCurso());
					  
					  resultado = "DATOS DE LA MATRÃ�CULA" + "\n\n" +
							  	  "â†’  CÃ³digo Matricula \t: " + matri.getNumMatricula() + "\n" +
							  	  "â†’  Codigo Alumno \t: "+ a3.getCodAlumno() + "\n" +
			                      "â†’  Nombre \t\t: " + a3.getNombres() + "\n" +
			                      "â†’  Apellidos \t\t: " + a3.getApellidos() + "\n" +
			                      "â†’  Edad \t\t: " + a3.getEdad() + "\n" +
			                      "â†’  DNI \t\t: " + a3.getDni() + "\n" +
			                      "â†’  TelÃ©fono \t\t: " + a3.getCelular() + "\n" +
			                      "--------------------------------------------------\n\n" +
			                      "CUSO RETIRADO:" + "\n\n";
					  
					  resultado += "â†’  CÃ³digo de curso \t: " + c3.getCodCurso() +"\n" +
						  		 "â†’  Asignatura \t\t: " + c3.getAsignatura() + "\n" +
						  		 "â†’  Ciclo \t\t: " + c3.getCiclo() + "\n" +
						  		 "â†’  CrÃ©ditos \t\t: " + c3.getCreditos() + "\n" +
						  		 "â†’  Horas \t\t: " + c3.getHoras()+ "\n" +
						  		 "â†’  Fecha de retiro \t: " + r.getFecha() + "\n" +
                              "â†’  Hora de retiro \t: " + r.getHora()+ "\n" +
                 			 "**************************************************" + "\n";
					  txtS.setText(resultado);
					
					  
				  }else {
					  mensaje("Retiro no encontrado","Advertencia", JOptionPane.ERROR_MESSAGE);
				  }
				  break;
			  }
		 }catch(Exception x) {
			 JOptionPane.showMessageDialog(null, "Ingrese un cï¿½digo para buscar.");
					 return;
		}
	}
	
	void mensaje(String s, String titulo, int tipo) {
		JOptionPane.showMessageDialog(null, s, titulo, tipo);
	}
	
	
}

