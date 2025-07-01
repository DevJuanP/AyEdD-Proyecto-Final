package gui;

import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import arreglos.ArreglosMatricula;
import clases.Curso;
import clases.Matricula;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogRegistroMatricula extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	JLabel TXThora;
	JLabel lblNewLabel_1;
	JTextField TXTfecha;
	JLabel lblNewLabel_2;
	JTextField txtHora;
	JLabel lblNewLabel_3;
	JTextField TXTcodigoMatricula;
	JSeparator separator;
	JLabel lblNewLabel_4;
	JLabel lblNewLabel_5;
	JTextField TXTcodigoAlum;
	JButton btnConsultarAlumn;
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
	JSeparator separator_2;
	JSeparator separator_3;
	JSeparator separator_4;
	JLabel lblNewLabel_11;
	JLabel lblNewLabel_12;
	JTextField TXTcodigoCurso;
	JButton btnConsultarCurso;
	JLabel lblNewLabel_13;
	JTextField txtCiclo;
	JLabel lblNewLabel_14;
	JTextField TXTcreditos;
	JLabel lblNewLabel_15;
	JTextField TXTHora;
	JLabel lblNewLabel_16;
	JTextField TXTcuso;
	JScrollPane scrollPane;
	JTable TablaMatricula;
	JButton btnConsultar;
	JButton btnRegistrar;
	JButton btnCerrar;
	private JSeparator separator_1;
	private JSeparator separator_5;
	private JSeparator separator_6;
	private JSeparator separator_7;
	private JButton btnEliminar;
	private DefaultTableModel modeloMatricula;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DialogRegistroMatricula dialog = new DialogRegistroMatricula();
					dialog.setVisible(true);
					dialog.setLocationRelativeTo(null);
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
		setTitle("Registro de Matricula");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 746, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TXThora = new JLabel("REGISTRO MATRICULA");
		TXThora.setForeground(Color.WHITE);
		TXThora.setBackground(new Color(0, 0, 0));
		TXThora.setOpaque(true);
		TXThora.setHorizontalAlignment(SwingConstants.CENTER);
		TXThora.setFont(new Font("Tahoma", Font.BOLD, 17));
		TXThora.setBounds(0, 0, 732, 33);
		contentPane.add(TXThora);
		
		lblNewLabel_1 = new JLabel("Fecha:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(20, 43, 70, 18);
		contentPane.add(lblNewLabel_1);
		
		TXTfecha = new JTextField();
		TXTfecha.setEditable(false);
		TXTfecha.setBounds(85, 45, 69, 19);
		contentPane.add(TXTfecha);
		TXTfecha.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Hora:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(168, 43, 47, 18);
		contentPane.add(lblNewLabel_2);
		
		txtHora = new JTextField();
		txtHora.setEditable(false);
		txtHora.setBounds(225, 45, 69, 19);
		contentPane.add(txtHora);
		txtHora.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Código Matricula:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(470, 45, 136, 13);
		contentPane.add(lblNewLabel_3);
		
		TXTcodigoMatricula = new JTextField();
		TXTcodigoMatricula.setEditable(false);
		TXTcodigoMatricula.setBounds(616, 44, 96, 19);
		contentPane.add(TXTcodigoMatricula);
		TXTcodigoMatricula.setColumns(10);
		
		separator = new JSeparator();
		separator.setForeground(Color.GRAY);
		separator.setToolTipText("");
		separator.setBounds(20, 71, 692, 8);
		contentPane.add(separator);
		
		lblNewLabel_4 = new JLabel("DATOS DE ALUMNOS");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(30, 80, 199, 19);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Código:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(40, 109, 61, 21);
		contentPane.add(lblNewLabel_5);
		
		TXTcodigoAlum = new JTextField();
		TXTcodigoAlum.setBounds(138, 111, 109, 19);
		contentPane.add(TXTcodigoAlum);
		TXTcodigoAlum.setColumns(10);
		
		btnConsultarAlumn = new JButton("BUSCAR");
		btnConsultarAlumn.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnConsultarAlumn.addActionListener(this);
		btnConsultarAlumn.setBounds(335, 109, 96, 22);
		contentPane.add(btnConsultarAlumn);
		
		lblNewLabel_6 = new JLabel("Edad:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(471, 109, 61, 16);
		contentPane.add(lblNewLabel_6);
		
		TXTedad = new JTextField();
		TXTedad.setBounds(524, 110, 38, 19);
		contentPane.add(TXTedad);
		TXTedad.setColumns(10);
		
		lblNewLabel = new JLabel("Celular:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(471, 171, 62, 13);
		contentPane.add(lblNewLabel);
		
		TXTcelular = new JTextField();
		TXTcelular.setBounds(543, 166, 144, 19);
		contentPane.add(TXTcelular);
		TXTcelular.setColumns(10);
		
		lblNewLabel_7 = new JLabel("Estado:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBounds(579, 111, 69, 13);
		contentPane.add(lblNewLabel_7);
		
		TXTestado = new JTextField();
		TXTestado.setBounds(645, 110, 42, 19);
		contentPane.add(TXTestado);
		TXTestado.setColumns(10);
		
		lblNewLabel_8 = new JLabel("Nombres:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_8.setBounds(39, 140, 80, 18);
		contentPane.add(lblNewLabel_8);
		
		TXTnombres = new JTextField();
		TXTnombres.setBounds(138, 137, 293, 19);
		contentPane.add(TXTnombres);
		TXTnombres.setColumns(10);
		
		lblNewLabel_9 = new JLabel("Apellidos:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9.setBounds(40, 167, 88, 18);
		contentPane.add(lblNewLabel_9);
		
		TXTapellidos = new JTextField();
		TXTapellidos.setBounds(138, 165, 293, 19);
		contentPane.add(TXTapellidos);
		TXTapellidos.setColumns(10);
		
		lblNewLabel_10 = new JLabel("DNI:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_10.setBounds(471, 139, 53, 18);
		contentPane.add(lblNewLabel_10);
		
		TXTdni = new JTextField();
		TXTdni.setText("");
		TXTdni.setBounds(543, 141, 144, 19);
		contentPane.add(TXTdni);
		TXTdni.setColumns(10);
		
		separator_2 = new JSeparator();
		separator_2.setForeground(Color.GRAY);
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(20, 71, 2, 126);
		contentPane.add(separator_2);
		
		separator_3 = new JSeparator();
		separator_3.setForeground(Color.GRAY);
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(710, 71, 2, 126);
		contentPane.add(separator_3);
		
		separator_4 = new JSeparator();
		separator_4.setForeground(Color.GRAY);
		separator_4.setToolTipText("");
		separator_4.setBounds(20, 195, 692, 2);
		contentPane.add(separator_4);
		
		lblNewLabel_11 = new JLabel("DATOS DE CURSO");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_11.setBounds(30, 214, 151, 19);
		contentPane.add(lblNewLabel_11);
		
		lblNewLabel_12 = new JLabel("Código:");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_12.setBounds(40, 244, 79, 18);
		contentPane.add(lblNewLabel_12);
		
		TXTcodigoCurso = new JTextField();
		TXTcodigoCurso.setColumns(10);
		TXTcodigoCurso.setBounds(138, 246, 109, 19);
		contentPane.add(TXTcodigoCurso);
		
		btnConsultarCurso = new JButton("BUSCAR");
		btnConsultarCurso.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnConsultarCurso.addActionListener(this);
		btnConsultarCurso.setBounds(335, 243, 96, 25);
		contentPane.add(btnConsultarCurso);
		
		lblNewLabel_13 = new JLabel("Ciclo:");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_13.setBounds(470, 247, 45, 13);
		contentPane.add(lblNewLabel_13);
		
		txtCiclo = new JTextField();
		txtCiclo.setColumns(10);
		txtCiclo.setBounds(524, 246, 38, 19);
		contentPane.add(txtCiclo);
		
		lblNewLabel_14 = new JLabel("Créditos:");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_14.setBounds(471, 282, 69, 13);
		contentPane.add(lblNewLabel_14);
		
		TXTcreditos = new JTextField();
		TXTcreditos.setColumns(10);
		TXTcreditos.setBounds(550, 281, 137, 19);
		contentPane.add(TXTcreditos);
		
		lblNewLabel_15 = new JLabel("Horas:");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_15.setBounds(579, 247, 65, 13);
		contentPane.add(lblNewLabel_15);
		
		TXTHora = new JTextField();
		TXTHora.setColumns(10);
		TXTHora.setBounds(645, 246, 42, 19);
		contentPane.add(TXTHora);
		
		lblNewLabel_16 = new JLabel("Asignatura:");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_16.setBounds(40, 271, 88, 18);
		contentPane.add(lblNewLabel_16);
		
		TXTcuso = new JTextField();
		TXTcuso.setColumns(10);
		TXTcuso.setBounds(138, 278, 293, 19);
		contentPane.add(TXTcuso);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 324, 692, 129);
		contentPane.add(scrollPane);
		
		TablaMatricula = new JTable();
		modeloMatricula=new DefaultTableModel();
		modeloMatricula.addColumn("Número de Matricula");
		modeloMatricula.addColumn("Código Alumno");
		modeloMatricula.addColumn("Código Curso");
		modeloMatricula.addColumn("Fecha");
		modeloMatricula.addColumn("Hora");
		modeloMatricula.addColumn("Estado");
		
		TablaMatricula.setModel(modeloMatricula);
		scrollPane.setViewportView(TablaMatricula);
		
		btnConsultar = new JButton("CONSULTAR");
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(58, 463, 118, 25);
		contentPane.add(btnConsultar);
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(234, 463, 118, 25);
		contentPane.add(btnRegistrar);
		
		btnCerrar = new JButton("CERRAR");
		btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(577, 463, 96, 25);
		contentPane.add(btnCerrar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEliminar.addActionListener(this); 
		btnEliminar.setBounds(410, 463, 109, 25);
		contentPane.add(btnEliminar);
		
		separator_1 = new JSeparator();
		separator_1.setToolTipText("");
		separator_1.setForeground(Color.GRAY);
		separator_1.setBounds(20, 207, 692, 8);
		contentPane.add(separator_1);
		
		separator_5 = new JSeparator();
		separator_5.setOrientation(SwingConstants.VERTICAL);
		separator_5.setForeground(Color.GRAY);
		separator_5.setBounds(20, 209, 2, 99);
		contentPane.add(separator_5);
		
		separator_6 = new JSeparator();
		separator_6.setToolTipText("");
		separator_6.setForeground(Color.GRAY);
		separator_6.setBounds(20, 309, 692, 13);
		contentPane.add(separator_6);
		
		separator_7 = new JSeparator();
		separator_7.setOrientation(SwingConstants.VERTICAL);
		separator_7.setForeground(Color.GRAY);
		separator_7.setBounds(710, 209, 2, 99);
		contentPane.add(separator_7);
		setear();
		listar();
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == btnConsultarCurso) {
			actionPerformedBtnConsultarCurso(e);
		}
		if (e.getSource() == btnConsultarAlumn) {
			do_btnConsultarAlumn_actionPerformed(e);
		}
		if (e.getSource() == btnEliminar) {
			do_btnEliminar_actionPerformed(e);
		}
	}
	
	public void leerBusqueda (Curso c) {
		TXTcodigoCurso.setText(String.valueOf(c.getCodCurso()));
        TXTcuso.setText(c.getAsignatura());
        txtCiclo.setText(String.valueOf(c.getCiclo()));
        TXTcreditos.setText(String.valueOf(c.getCreditos()));
        TXTHora.setText(String.valueOf(c.getHoras()));
        }
	
	protected void do_btnConsultarAlumn_actionPerformed(ActionEvent e) {
		DialogBuscarAlumnos dialogBuscarAlumno = new DialogBuscarAlumnos(this);
		dialogBuscarAlumno.setLocationRelativeTo(dialogBuscarAlumno);
		dialogBuscarAlumno.setModal(true);
		dialogBuscarAlumno.setVisible(true);
	}
	
	protected void actionPerformedBtnConsultarCurso(ActionEvent e) {
		DialogBuscarCursos dialogBuscarCursos = new DialogBuscarCursos(this);
		dialogBuscarCursos.setLocationRelativeTo(dialogBuscarCursos);
		dialogBuscarCursos.setModal(true);
		dialogBuscarCursos.setVisible(true);
	}
	
	//Globalizacion
	ArreglosMatricula am = new ArreglosMatricula();
	
	//Metodos sin parametros
	 void listar() {
		 modeloMatricula.setRowCount(0);
		 for (int i = 0; i < am.tamanio(); i++) {
			Object[] fila = {
					am.obtener(i).getNumMatricula(),
					am.obtener(i).getCodAlumno(),
					am.obtener(i).getCodCurso(),
					am.obtener(i).getFecha(),
					am.obtener(i).getHora(),
					am.obtener(i).getEstado(),};
			modeloMatricula.addRow(fila);
		}
	 }
	
	protected void do_btnEliminar_actionPerformed(ActionEvent e) {
		 am.Eliminar(null);
	}
	 
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		setear();
		am.CargarMatricula();
		listar();
	}
	
	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		try {
		int codigoAlumno = Integer.parseInt(TXTcodigoAlum.getText().trim());
		int codigoCurso = Integer.parseInt(TXTcodigoCurso.getText().trim());
		String fecha = TXTfecha.getText().trim();
		String hora = TXTHora.getText().trim();
		int estado = Integer.parseInt(TXTestado.getText().trim());
		Matricula m = new Matricula(codigoAlumno,codigoCurso,estado );
		am.AdicionarMatricula(m);
		am.GrabarTXT();
		setear();
		listar();
		javax.swing.JOptionPane.showMessageDialog(null, "Matrícula registrada correctamente.");
		}catch(Exception x) {
			javax.swing.JOptionPane.showMessageDialog(null, "Codigos existentes//Datos mas ingresados");
		}
	}
	
	public void setear() {
		Matricula m = new Matricula(0, 0, 0);
		TXTnombres.setText("");
		TXTapellidos.setText("");
		TXTedad.setText("");
		TXTdni.setText("");
		TXTcelular.setText("");
		TXTestado.setText("");

		TXTcodigoCurso.setText("");
		TXTcuso.setText("");
		txtCiclo.setText("");
		TXTcreditos.setText("");
		TXTHora.setText("");

		TXTcodigoAlum.setText("");
		TXTfecha.setText(m.getFecha());
		txtHora.setText(m.getHora());
		TXTcodigoMatricula.setText(String.valueOf(Matricula.getContadorMatricula()));
	}
	
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		Principal principal = new Principal();
		principal.setLocationRelativeTo(principal);
		principal.setVisible(true);
		dispose();
	}
}
