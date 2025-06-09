package PruebasGui;

import java.awt.EventQueue;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Alumno;

public class Juan extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		Juan frame = new Juan();
		frame.setVisible(true);
	}
	
	private JTextArea txtOut;

	public Juan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btnProcesar = new JButton("Procesar");
		btnProcesar.setBounds(280, 20, 100, 25);
		getContentPane().add(btnProcesar);
		
		txtOut = new JTextArea();
		
		JScrollPane scr = new JScrollPane(txtOut);
		scr.setBounds(20, 55, 400, 200);
		getContentPane().add(scr);
		
		btnProcesar.addActionListener(e -> {
			Alumno a1 = new Alumno(22, 926948098, "pepe", "paredes", "72884005");
			Listar(a1);
		});	
	}
	void Listar(Alumno a1) {
		Imprimir("codigo: "+a1.getCodAlumno());
		Imprimir("edad : "+a1.getEdad());
		Imprimir("celular: "+a1.getCelular());
		Imprimir("estado: "+a1.getEstado());
		Imprimir("nombre: "+a1.getNombres());
		Imprimir("apellidos: "+a1.getApellidos());
		Imprimir("dni: "+a1.getDni());
		Imprimir();
	}
	void Imprimir(String s) {
		txtOut.append(s + "\n");
	}
	void Imprimir(){
		Imprimir("");
	}
	void Limpiar() {
		txtOut.setText("");
	}
}
