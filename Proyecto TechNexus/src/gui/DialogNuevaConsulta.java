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
		cmbBuscar.setBounds(108, 32, 203, 21);
		contentPanel.add(cmbBuscar);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(this);
		
		btnBuscar.setBounds(363, 32, 129, 21);
		contentPanel.add(btnBuscar);
		
		btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setBounds(363, 60, 129, 21);
		contentPanel.add(btnLimpiar);
		
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
		if (e.getSource() == btnLimpiar) {
			actionPerformedBtnLimpiar(e);
		}
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
				  txtS.setText("");
				  Alumno a = aa.buscarCodigo(codigo);
				  if(a != null) {
					  resultado = ">>>>>DATOS ALUMNOS<<<<<" + "\n" +
							  	"" + "\n" +
							  "Nombre \t: " + a.getNombres() + "\n" +
                              "Apellidos \t: " + a.getApellidos() + "\n" +
                              "Edad \t: " + a.getEdad() +"\n" +
                              "DNI \t: " + a.getDni() +"\n" +
                              "Telefóno \t: " + a.getCelular();
					  txtS.append(resultado);
				  }
			  case "CURSO":
				  //txtS.setText("");
				  Curso c = ac.buscarCodigo(codigo);
				  if(c != null) {
					  resultado=">>>>>DATOS CURSO<<<<<" + "\n" +
							  	"" + "\n" +
							  	"Código \t: " + c.getCodCurso() + "\n" +
							  	"Asignatura \t: " + c.getAsignatura() + "\n" +
							  	"Ciclo \t: " + c.getCiclo() + "\n" +
							  	"Créditos \t: " + c.getCreditos() + "\n" +
							  	"Horas \t: " + c.getHoras();
					  txtS.append(resultado);
				  }
			  case "MATRICULA":
				  Matricula m = am.buscarMatricula(codigo);
				  if(m != null) {
					  Alumno alu = aa.buscarCodigo(m.getCodAlumno());
					  Curso cur = ac.buscarCodigo(m.getCodCurso());
					  
					  resultado = ">>>>>DATOS MATRICULA<<<<<" + "\n" +
							  	"" + "\n" +
							  	"Nombre \t: " + alu.getNombres() + "\n" +
							  	"Apellidos \t: " + alu.getApellidos() + "\n" +
							  	"Asignatura \t: " + cur.getAsignatura();
					  txtS.append(resultado);
				  }
			  }
					  }catch(Exception x) {
						  JOptionPane.showMessageDialog(null, "Ingrese un c�digo para buscar.");
				            return;
					  }
	}
	protected void actionPerformedBtnLimpiar(ActionEvent e) {
		txtS.setText("");
	}
}

