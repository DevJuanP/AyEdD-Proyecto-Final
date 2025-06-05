package gui;

import java.awt.EventQueue;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Alumno;

public class pruebas extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		pruebas frame = new pruebas();
		frame.setVisible(true);
	}

	public pruebas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btnProcesar = new JButton("Procesar");
		btnProcesar.setBounds(280, 20, 100, 25);
		getContentPane().add(btnProcesar);
		
		JTextArea txtOut = new JTextArea();
		
		JScrollPane scr = new JScrollPane(txtOut);
		scr.setBounds(20, 55, 400, 200);
		getContentPane().add(scr);
		
		Alumno a1 = new Alumno(22, 926948098, "pepe", "paredes", "72884005");
		
		txtOut.append("codigo: "+a1.getCodAlumno()+"\n");
		txtOut.append("edad : "+a1.getEdad()+"\n");
		txtOut.append("celular: "+a1.getCelular()+"\n");
		txtOut.append("estado: "+a1.getEstado()+"\n");
		txtOut.append("nombre: "+a1.getNombres()+"\n");
		txtOut.append("apellidos: "+a1.getApellidos()+"\n");
		txtOut.append("dni: "+a1.getDni());
		
	}

}
