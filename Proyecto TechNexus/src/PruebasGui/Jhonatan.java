package PruebasGui;

import java.awt.EventQueue;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Alumno;

public class Jhonatan extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		Jhonatan frame = new Jhonatan();
		frame.setVisible(true);
	}
	
	private JTextArea txtOut;

	public Jhonatan() {
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
			//aquí la lógica
			Imprimir("Codea pues ----→> (╯°□°）╯︵ ┻━┻");
			Imprimir();
			Imprimir("          (¬_¬ )");
			Imprimir();
			Imprimir("          (ᵔ◡ᵔ)");
		});
			
	}
	void Listar(Alumno a1) {
		//aquí el listado de tu clase
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
