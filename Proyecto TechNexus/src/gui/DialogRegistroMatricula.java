package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DialogRegistroMatricula extends JFrame {

	private JPanel contentPane;
	JLabel TXThora;
	JLabel lblNewLabel_1;
	JTextField TXTfecha;
	JLabel lblNewLabel_2;
	JTextField TXThora_1;
	JLabel lblNewLabel_3;
	JTextField TXTcodigoMatricula;
	JSeparator separator;
	JLabel lblNewLabel_4;
	JLabel lblNewLabel_5;
	JTextField TXTcodigoAlum;
	JButton ConsultarAlumn;
	JLabel lblNewLabel_6;
	JTextField TXTedad;
	JLabel lblNewLabel;
	JTextField TXTcelular;
	JLabel lblNewLabel_7;
	JTextField TXTestado;
	JLabel lblNewLabel_8;
	JTextField TXTnombres;
	JLabel lblNewLabel_9;
	JTextField TXTapellidos;
	JLabel lblNewLabel_10;
	JTextField TXTdni;
	JSeparator separator_1;
	JSeparator separator_2;
	JSeparator separator_3;
	JSeparator separator_4;
	JSeparator separator_5;
	JSeparator separator_6;
	JSeparator separator_7;
	JLabel lblNewLabel_11;
	JLabel lblNewLabel_12;
	JTextField TXTcodigoCurso;
	JButton ConsultarCiclo;
	JLabel lblNewLabel_13;
	JTextField CICLO;
	JLabel lblNewLabel_14;
	JTextField TXTcreditos;
	JLabel lblNewLabel_15;
	JTextField TXTcHORA;
	JLabel lblNewLabel_16;
	JTextField TXTcuso;
	JScrollPane scrollPane;
	JTable TXTtabla;
	JButton btnConsultar;
	JButton btnModificar;
	JButton btnEliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DialogRegistroMatricula frame = new DialogRegistroMatricula();
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
	public DialogRegistroMatricula() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 707, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TXThora = new JLabel("REGISTRO MATRICULA");
		TXThora.setForeground(Color.WHITE);
		TXThora.setBackground(new Color(0, 0, 0));
		TXThora.setOpaque(true);
		TXThora.setHorizontalAlignment(SwingConstants.CENTER);
		TXThora.setFont(new Font("Tahoma", Font.BOLD, 14));
		TXThora.setBounds(10, 0, 672, 18);
		contentPane.add(TXThora);
		
		lblNewLabel_1 = new JLabel("FECHA");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 21, 47, 18);
		contentPane.add(lblNewLabel_1);
		
		TXTfecha = new JTextField();
		TXTfecha.setBounds(53, 22, 69, 19);
		contentPane.add(TXTfecha);
		TXTfecha.setColumns(10);
		
		lblNewLabel_2 = new JLabel("HORA");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(132, 21, 47, 18);
		contentPane.add(lblNewLabel_2);
		
		TXThora_1 = new JTextField();
		TXThora_1.setBounds(173, 22, 69, 19);
		contentPane.add(TXThora_1);
		TXThora_1.setColumns(10);
		
		lblNewLabel_3 = new JLabel("CODIGO MATRICULA");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(465, 24, 124, 13);
		contentPane.add(lblNewLabel_3);
		
		TXTcodigoMatricula = new JTextField();
		TXTcodigoMatricula.setBounds(586, 22, 96, 19);
		contentPane.add(TXTcodigoMatricula);
		TXTcodigoMatricula.setColumns(10);
		
		separator = new JSeparator();
		separator.setToolTipText("");
		separator.setBounds(0, 57, 692, 2);
		contentPane.add(separator);
		
		lblNewLabel_4 = new JLabel("DATOS DE ALUMNO");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(10, 57, 134, 19);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("CODIGO");
		lblNewLabel_5.setBounds(10, 87, 50, 18);
		contentPane.add(lblNewLabel_5);
		
		TXTcodigoAlum = new JTextField();
		TXTcodigoAlum.setBounds(65, 87, 96, 19);
		contentPane.add(TXTcodigoAlum);
		TXTcodigoAlum.setColumns(10);
		
		ConsultarAlumn = new JButton("BUSCAR");
		ConsultarAlumn.setBounds(173, 84, 96, 25);
		contentPane.add(ConsultarAlumn);
		
		lblNewLabel_6 = new JLabel("EDAD");
		lblNewLabel_6.setBounds(508, 122, 38, 16);
		contentPane.add(lblNewLabel_6);
		
		TXTedad = new JTextField();
		TXTedad.setBounds(544, 121, 38, 19);
		contentPane.add(TXTedad);
		TXTedad.setColumns(10);
		
		lblNewLabel = new JLabel("CELULAR");
		lblNewLabel.setBounds(279, 89, 62, 13);
		contentPane.add(lblNewLabel);
		
		TXTcelular = new JTextField();
		TXTcelular.setBounds(350, 86, 138, 19);
		contentPane.add(TXTcelular);
		TXTcelular.setColumns(10);
		
		lblNewLabel_7 = new JLabel("ESTADO");
		lblNewLabel_7.setBounds(586, 124, 50, 13);
		contentPane.add(lblNewLabel_7);
		
		TXTestado = new JTextField();
		TXTestado.setBounds(640, 121, 42, 19);
		contentPane.add(TXTestado);
		TXTestado.setColumns(10);
		
		lblNewLabel_8 = new JLabel("NOMBRES");
		lblNewLabel_8.setBounds(10, 124, 69, 13);
		contentPane.add(lblNewLabel_8);
		
		TXTnombres = new JTextField();
		TXTnombres.setBounds(75, 121, 167, 19);
		contentPane.add(TXTnombres);
		TXTnombres.setColumns(10);
		
		lblNewLabel_9 = new JLabel("APELLIDOS");
		lblNewLabel_9.setBounds(242, 124, 69, 13);
		contentPane.add(lblNewLabel_9);
		
		TXTapellidos = new JTextField();
		TXTapellidos.setBounds(311, 121, 177, 19);
		contentPane.add(TXTapellidos);
		TXTapellidos.setColumns(10);
		
		lblNewLabel_10 = new JLabel("DNI");
		lblNewLabel_10.setBounds(556, 89, 28, 13);
		contentPane.add(lblNewLabel_10);
		
		TXTdni = new JTextField();
		TXTdni.setText("");
		TXTdni.setBounds(586, 86, 96, 19);
		contentPane.add(TXTdni);
		TXTdni.setColumns(10);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(0, 157, 692, 2);
		contentPane.add(separator_1);
		
		separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(0, 59, 2, 101);
		contentPane.add(separator_2);
		
		separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(690, 57, 2, 101);
		contentPane.add(separator_3);
		
		separator_4 = new JSeparator();
		separator_4.setToolTipText("");
		separator_4.setBounds(0, 169, 692, 2);
		contentPane.add(separator_4);
		
		separator_5 = new JSeparator();
		separator_5.setBounds(0, 269, 692, 2);
		contentPane.add(separator_5);
		
		separator_6 = new JSeparator();
		separator_6.setOrientation(SwingConstants.VERTICAL);
		separator_6.setBounds(0, 171, 2, 101);
		contentPane.add(separator_6);
		
		separator_7 = new JSeparator();
		separator_7.setOrientation(SwingConstants.VERTICAL);
		separator_7.setBounds(690, 169, 2, 101);
		contentPane.add(separator_7);
		
		lblNewLabel_11 = new JLabel("DATOS DE CURSO");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_11.setBounds(10, 169, 134, 19);
		contentPane.add(lblNewLabel_11);
		
		lblNewLabel_12 = new JLabel("CODIGO");
		lblNewLabel_12.setBounds(10, 193, 50, 18);
		contentPane.add(lblNewLabel_12);
		
		TXTcodigoCurso = new JTextField();
		TXTcodigoCurso.setColumns(10);
		TXTcodigoCurso.setBounds(65, 193, 96, 19);
		contentPane.add(TXTcodigoCurso);
		
		ConsultarCiclo = new JButton("BUSCAR");
		ConsultarCiclo.setBounds(173, 190, 96, 25);
		contentPane.add(ConsultarCiclo);
		
		lblNewLabel_13 = new JLabel("CICLO");
		lblNewLabel_13.setBounds(322, 196, 45, 13);
		contentPane.add(lblNewLabel_13);
		
		CICLO = new JTextField();
		CICLO.setColumns(10);
		CICLO.setBounds(363, 193, 38, 19);
		contentPane.add(CICLO);
		
		lblNewLabel_14 = new JLabel("CREDITOS");
		lblNewLabel_14.setBounds(292, 228, 69, 13);
		contentPane.add(lblNewLabel_14);
		
		TXTcreditos = new JTextField();
		TXTcreditos.setColumns(10);
		TXTcreditos.setBounds(363, 225, 38, 19);
		contentPane.add(TXTcreditos);
		
		lblNewLabel_15 = new JLabel("HORAS");
		lblNewLabel_15.setBounds(433, 196, 45, 13);
		contentPane.add(lblNewLabel_15);
		
		TXTcHORA = new JTextField();
		TXTcHORA.setColumns(10);
		TXTcHORA.setBounds(483, 192, 38, 19);
		contentPane.add(TXTcHORA);
		
		lblNewLabel_16 = new JLabel("CURSO");
		lblNewLabel_16.setBounds(10, 231, 76, 13);
		contentPane.add(lblNewLabel_16);
		
		TXTcuso = new JTextField();
		TXTcuso.setColumns(10);
		TXTcuso.setBounds(65, 228, 204, 19);
		contentPane.add(TXTcuso);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 281, 673, 129);
		contentPane.add(scrollPane);
		
		TXTtabla = new JTable();
		TXTtabla.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Fecha", "Hora", "Nombres", "Cod Alum", "Curso", "Cod curso", "Estado"
			}
		));
		scrollPane.setViewportView(TXTtabla);
		
		btnConsultar = new JButton("CONSULTAR");
		btnConsultar.setBounds(118, 412, 96, 25);
		contentPane.add(btnConsultar);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.setBounds(292, 412, 109, 25);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(471, 412, 96, 25);
		contentPane.add(btnEliminar);
	}
}
