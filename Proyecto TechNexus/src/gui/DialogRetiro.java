package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

//import javax.swing.ButtonGroup;
//import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
//import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JButton;
//import javax.swing.ScrollPaneConstants;




//import java.awt.Component;

public class DialogRetiro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblTitle;
	private JLabel lblCdigoMaticula;
	private JLabel lblCdigoAlumno;
	private JLabel lblNombreDelAlumno;
	private JTextField textCodMat;
	private JTextField txtNomApelli;
	private JLabel lblCdigoCurso;
	private JTextField txtCodMat;
	private JLabel lblCurso;
	private JTextField txtCurso;
	private JLabel lblFecha;
	private JTextField txtFecha;
	private JLabel lblFecha_1;
	private JTextField txtHora;
	private JTextField txtCodCurso;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DialogRetiro frame = new DialogRetiro();
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
	public DialogRetiro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		setSize(900, 608);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitle = new JLabel("REGISTRO DE RETIRO");
		lblTitle.setOpaque(true);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTitle.setBackground(Color.BLACK);
		lblTitle.setBounds(0, 0, 884, 26);
		contentPane.add(lblTitle);
		
		lblCdigoMaticula = new JLabel("Código Maticula");
		lblCdigoMaticula.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCdigoMaticula.setBounds(22, 71, 123, 25);
		contentPane.add(lblCdigoMaticula);
		
		lblCdigoAlumno = new JLabel("Código Alumno");
		lblCdigoAlumno.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCdigoAlumno.setBounds(22, 106, 123, 25);
		contentPane.add(lblCdigoAlumno);
		
		lblNombreDelAlumno = new JLabel("Nombre y Apellidos");
		lblNombreDelAlumno.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombreDelAlumno.setBounds(22, 141, 123, 25);
		contentPane.add(lblNombreDelAlumno);
		
		textCodMat = new JTextField();
		textCodMat.setBounds(161, 106, 109, 25);
		contentPane.add(textCodMat);
		
		txtNomApelli = new JTextField();
		txtNomApelli.setBounds(161, 141, 396, 25);
		contentPane.add(txtNomApelli);
		
		lblCdigoCurso = new JLabel("Código curso");
		lblCdigoCurso.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCdigoCurso.setBounds(617, 106, 91, 25);
		contentPane.add(lblCdigoCurso);
		
		txtCodMat = new JTextField();
		txtCodMat.setBounds(161, 70, 109, 25);
		contentPane.add(txtCodMat);
		
		lblCurso = new JLabel("Curso");
		lblCurso.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCurso.setBounds(617, 141, 52, 25);
		contentPane.add(lblCurso);
		
		txtCurso = new JTextField();
		txtCurso.setBounds(707, 141, 150, 25);
		contentPane.add(txtCurso);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFecha.setBounds(42, 198, 44, 25);
		contentPane.add(lblFecha);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(87, 202, 114, 25);
		contentPane.add(txtFecha);
		
		lblFecha_1 = new JLabel("Hora");
		lblFecha_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFecha_1.setBounds(274, 198, 44, 25);
		contentPane.add(lblFecha_1);
		
		txtHora = new JTextField();
		txtHora.setBounds(328, 200, 114, 25);
		contentPane.add(txtHora);
		
		txtCodCurso = new JTextField();
		txtCodCurso.setBounds(707, 106, 150, 25);
		contentPane.add(txtCodCurso);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 264, 840, 249);
		contentPane.add(scrollPane);
		
		table = new JTable();
		//table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Código Retiro", "Código Alumno", "Nombre y Apellidos", "Código curso", "Curso", "Fecha", "Hora"
			}
		));
		scrollPane.setViewportView(table);
		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		btnNewButton = new JButton("Buscar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(297, 69, 90, 30);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Registrar");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(97, 524, 90, 30);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Modificar");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(392, 524, 90, 30);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Eliminar");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.setBounds(707, 524, 90, 30);
		contentPane.add(btnNewButton_3);
		
		

}
	}
