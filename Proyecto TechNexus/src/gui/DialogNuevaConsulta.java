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

public class DialogNuevaConsulta extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblConsultar;
	private JComboBox<String> cmbBuscar;
	private JButton btnBuscar;
	private JButton btnLimpiar;
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
		cmbBuscar.setBounds(108, 32, 195, 21);
		contentPanel.add(cmbBuscar);
		
		btnBuscar = new JButton("BUSCAR");
		
		btnBuscar.setBounds(218, 60, 85, 21);
		contentPanel.add(btnBuscar);
		
		btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.setBounds(313, 45, 85, 21);
		contentPanel.add(btnLimpiar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 109, 472, 221);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(108, 61, 88, 19);
		contentPanel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblCodigo = new JLabel("CODIGO:");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCodigo.setBounds(21, 61, 88, 22);
		contentPanel.add(lblCodigo);
		
		ArreglosAlumno RRalum = new ArreglosAlumno();
		ArreglosMatricula RRmatri = new ArreglosMatricula();
		ArreglosCursos RRcurs = new ArreglosCursos();	
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
						  Alumno a = RRalum.buscarCodigo(codigo);
						  if(a != null) {
							  resultado = "Nombre: " + a.getNombres() +
	                                    "\nApellidos: " + a.getApellidos() +
	                                    "\nEdad: " + a.getEdad() +
	                                    "\nDNI: " + a.getDni();
							  Matricula m = RRmatri.buscarMatricula(codigo);
							  if(m != null) {
								  Curso c = RRcurs.buscarCodigo(codigo);
								  resultado += "\n\nCurso Matriculado: " + c.getAsignatura() + 
                                          "\nCiclo: " + c.getCiclo();
							  }
							  txtS.setText(resultado);

						  }
					  }
							  }catch(Exception x) {
								  JOptionPane.showMessageDialog(null, "Ingrese un código para buscar.");
						            return;
							  }
			}
		});
	}
}
