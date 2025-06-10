package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;

public class DialogMantenimientoCurso extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblMantenimientoCurso;
	private JLabel lblAsignatura;
	private JLabel lblCiclo;
	private JLabel lblCreditos;
	private JLabel lblHoras;
	private JLabel lblCodigo;
	private JLabel lblConsultar;
	private JTextField txtAsignatura;
	private JTextField txtCreditos;
	private JTextField txtHoras;
	private JTextField txtCodigo;
	private JTextField txtField;
	private JComboBox<String> cmbCiclo;
	private JRadioButton rbtnNombresYApellido;
	private JRadioButton rbtnDni;
	private JButton btnBuscar;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnNuevo;
	private JScrollPane scrollPane;
	private JTable table;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_1_1;
	private JSeparator separator_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DialogMantenimientoCurso frame = new DialogMantenimientoCurso();
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
	public DialogMantenimientoCurso() {
		setTitle("Mantenimiento de curso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblMantenimientoCurso = new JLabel("MANTENIMIENTO CURSO");
		lblMantenimientoCurso.setHorizontalAlignment(SwingConstants.CENTER);
		lblMantenimientoCurso.setForeground(new Color(255, 255, 255));
		lblMantenimientoCurso.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblMantenimientoCurso.setBounds(0, 0, 627, 26);
		lblMantenimientoCurso.setOpaque(true); 
		lblMantenimientoCurso.setBackground(new Color(0, 0, 0));
		
		
		contentPane.add(lblMantenimientoCurso);
		
		lblAsignatura = new JLabel("Asignatura:");
		lblAsignatura.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAsignatura.setBounds(23, 43, 132, 20);
		contentPane.add(lblAsignatura);
		
		lblCiclo = new JLabel("Ciclo:");
		lblCiclo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCiclo.setBounds(23, 73, 46, 20);
		contentPane.add(lblCiclo);
		
		lblCreditos = new JLabel("Cr\u00E9ditos:");
		lblCreditos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCreditos.setBounds(257, 73, 58, 20);
		contentPane.add(lblCreditos);
		
		lblHoras = new JLabel("Horas:");
		lblHoras.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHoras.setBounds(437, 73, 58, 20);
		contentPane.add(lblHoras);
		
		lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCodigo.setBounds(437, 43, 69, 20);
		contentPane.add(lblCodigo);
		
		txtAsignatura = new JTextField();
		txtAsignatura.setColumns(10);
		txtAsignatura.setBounds(108, 45, 308, 19);
		contentPane.add(txtAsignatura);
		
		txtCreditos = new JTextField();
		txtCreditos.setBounds(320, 75, 96, 19);
		contentPane.add(txtCreditos);
		txtCreditos.setColumns(10);
		
		txtHoras = new JTextField();
		txtHoras.setColumns(10);
		txtHoras.setBounds(505, 75, 96, 19);
		contentPane.add(txtHoras);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(506, 45, 96, 19);
		contentPane.add(txtCodigo);
		
		cmbCiclo = new JComboBox<String>();
		cmbCiclo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbCiclo.setModel(new DefaultComboBoxModel<String>(new String[] {"0-Primero", "1-Segundo", "2-Tercero", "3-Cuarto", "4-Quinto", "5-Sexto"}));
		cmbCiclo.setBounds(108, 73, 139, 20);
		contentPane.add(cmbCiclo);
		
		lblConsultar = new JLabel("CONSULTAR:");
		lblConsultar.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblConsultar.setBounds(53, 116, 102, 20);
		contentPane.add(lblConsultar);
		
		rbtnNombresYApellido = new JRadioButton("Nombres y Apellido");
		rbtnNombresYApellido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rbtnNombresYApellido.setBounds(29, 142, 132, 21);
		contentPane.add(rbtnNombresYApellido);
		
		rbtnDni = new JRadioButton("DNI");
		rbtnDni.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rbtnDni.setBounds(190, 142, 46, 21);
		contentPane.add(rbtnDni);
		
		txtField = new JTextField();
		txtField.setBounds(265, 144, 216, 19);
		contentPane.add(txtField);
		txtField.setColumns(10);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBuscar.setBounds(510, 143, 85, 21);
		contentPane.add(btnBuscar);
		
		scrollPane = new JScrollPane();
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
		
		btnAdicionar = new JButton("REGISTRAR");
		btnAdicionar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAdicionar.setBounds(180, 418, 107, 21);
		contentPane.add(btnAdicionar);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModificar.setBounds(329, 418, 107, 21);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminar.setBounds(478, 418, 107, 21);
		contentPane.add(btnEliminar);
		
		separator = new JSeparator();
		separator.setForeground(new Color(128, 128, 128));
		separator.setBounds(23, 113, 583, 33);
		contentPane.add(separator);
		
		separator_1 = new JSeparator(SwingConstants.VERTICAL);
		separator_1.setForeground(new Color(128, 128, 128));
		separator_1.setBounds(23, 113, 20, 64);
		contentPane.add(separator_1);
		
		separator_2 = new JSeparator();
		separator_2.setForeground(new Color(160, 160, 160));
		separator_2.setBounds(23, 176, 583, 33);
		contentPane.add(separator_2);
		
		separator_1_1 = new JSeparator(SwingConstants.VERTICAL);
		separator_1_1.setForeground(new Color(128, 128, 128));
		separator_1_1.setBounds(605, 113, 20, 64);
		contentPane.add(separator_1_1);
		
		btnNuevo = new JButton("NUEVO");
		btnNuevo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNuevo.setBounds(42, 418, 96, 21);
		contentPane.add(btnNuevo);
		
	}
}
