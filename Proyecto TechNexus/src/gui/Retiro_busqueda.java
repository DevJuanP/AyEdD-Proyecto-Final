package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Retiro_busqueda extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Retiro_busqueda frame = new Retiro_busqueda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Retiro_busqueda() {
		setTitle("Bucar alumno");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Apellidos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(28, 23, 67, 14);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(105, 20, 178, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("New button");
		btnNewButton.setBounds(299, 20, 110, 26);
		getContentPane().add(btnNewButton);

	}
}
