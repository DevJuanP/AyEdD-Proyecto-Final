package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DialogNuevaConsulta extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblConsultar;
	private JComboBox<String> cmbBuscar;
	private JButton btnListar;
	private JButton btnLimpiar;
	private JScrollPane scrollPane;
	private JTextArea txtS;

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
		cmbBuscar.setBounds(108, 32, 195, 21);
		contentPanel.add(cmbBuscar);
		
		btnListar = new JButton("LISTAR");
		btnListar.setBounds(313, 32, 85, 21);
		contentPanel.add(btnListar);
		
		btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.setBounds(408, 32, 85, 21);
		contentPanel.add(btnLimpiar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 74, 472, 256);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
	}
}
