package PruebasGui;
import arreglos.ArreglosMatricula;
import java.awt.EventQueue;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Alumno;
import clases.Matricula;

public class Oscar extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		Oscar frame = new Oscar();
		frame.setVisible(true);
	}
	
	private JTextArea txtOut;

	public Oscar() {
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
		ArreglosMatricula mList =new ArreglosMatricula();
		
		btnProcesar.addActionListener(e -> {
			//aquí la lógica
			Imprimir("Codea pues ----→> (╯°□°）╯︵ ┻━┻");
			
			
		});
			
	}
	void Listar(ArreglosMatricula a1) {
		
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
