package gui;

import java.awt.EventQueue;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Principal extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		Principal frame = new Principal();
		frame.setVisible(true);
	}

	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}

}
