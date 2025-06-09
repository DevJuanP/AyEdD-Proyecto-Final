package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Mantenimiento_Curso extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textAsignatura;
	private JTextField textCreditos;
	private JTextField textHoras;
	private JTextField textCodigo;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mantenimiento_Curso frame = new Mantenimiento_Curso();
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
	public Mantenimiento_Curso() {
		setTitle("Mantenimiento de curso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MANTENIMIENTO CURSO");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(0, 0, 627, 26);
		lblNewLabel.setOpaque(true); 
		lblNewLabel.setBackground(new Color(0, 0, 0));
		
		
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Asignatura:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(23, 43, 132, 20);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Ciclo:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(23, 73, 46, 20);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Créditos:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1.setBounds(257, 73, 58, 20);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Horas:");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1_2.setBounds(437, 73, 58, 20);
		contentPane.add(lblNewLabel_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_3 = new JLabel("Código:");
		lblNewLabel_1_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1_3.setBounds(437, 43, 69, 20);
		contentPane.add(lblNewLabel_1_1_1_3);
		
		textAsignatura = new JTextField();
		textAsignatura.setColumns(10);
		textAsignatura.setBounds(108, 45, 308, 19);
		contentPane.add(textAsignatura);
		
		textCreditos = new JTextField();
		textCreditos.setBounds(320, 75, 96, 19);
		contentPane.add(textCreditos);
		textCreditos.setColumns(10);
		
		textHoras = new JTextField();
		textHoras.setColumns(10);
		textHoras.setBounds(505, 75, 96, 19);
		contentPane.add(textHoras);
		
		textCodigo = new JTextField();
		textCodigo.setColumns(10);
		textCodigo.setBounds(506, 45, 96, 19);
		contentPane.add(textCodigo);
		
		JComboBox cmbxCiclo = new JComboBox();
		cmbxCiclo.setBounds(108, 73, 139, 20);
		contentPane.add(cmbxCiclo);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("CONSULTAR:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_2.setBounds(53, 116, 102, 20);
		contentPane.add(lblNewLabel_1_1_2);
		
		JRadioButton rdbtnNombresYApellido = new JRadioButton("Nombres y Apellido");
		rdbtnNombresYApellido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnNombresYApellido.setBounds(29, 142, 132, 21);
		contentPane.add(rdbtnNombresYApellido);
		
		JRadioButton rdbtnDni = new JRadioButton("DNI");
		rdbtnDni.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnDni.setBounds(190, 142, 46, 21);
		contentPane.add(rdbtnDni);
		
		textField = new JTextField();
		textField.setBounds(265, 144, 216, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("BUSCAR");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(510, 143, 85, 21);
		contentPane.add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(128, 128, 128));
		separator.setBounds(23, 113, 583, 33);
		contentPane.add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 203, 578, 194);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"C\u00D3DIGO", "ASIGNATURA", "CICLO", "CR\u00C9DITOS", "HORAS"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnAdicionar = new JButton("ADICIONAR");
		btnAdicionar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAdicionar.setBounds(130, 417, 107, 21);
		contentPane.add(btnAdicionar);
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModificar.setBounds(254, 417, 107, 21);
		contentPane.add(btnModificar);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminar.setBounds(378, 417, 107, 21);
		contentPane.add(btnEliminar);
		
		JSeparator separator_1 = new JSeparator(SwingConstants.VERTICAL);
		separator_1.setForeground(new Color(128, 128, 128));
		separator_1.setBounds(23, 113, 20, 64);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(160, 160, 160));
		separator_2.setBounds(23, 176, 583, 33);
		contentPane.add(separator_2);
		
		JSeparator separator_1_1 = new JSeparator(SwingConstants.VERTICAL);
		separator_1_1.setForeground(new Color(128, 128, 128));
		separator_1_1.setBounds(605, 113, 20, 64);
		contentPane.add(separator_1_1);
		
		JButton btnNuevo = new JButton("NUEVO");
		btnNuevo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNuevo.setBounds(17, 417, 96, 21);
		contentPane.add(btnNuevo);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalir.setBounds(502, 417, 107, 21);
		contentPane.add(btnSalir);
		
	}
}
