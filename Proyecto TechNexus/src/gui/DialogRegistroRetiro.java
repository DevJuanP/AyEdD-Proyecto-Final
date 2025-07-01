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

import arreglos.ArreglosRetiro;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import clases.Retiro;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import javax.swing.ScrollPaneConstants;
import javax.swing.Timer;
import javax.swing.JSeparator;



//import java.awt.Component;

public class DialogRegistroRetiro extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblTitle;
	private JLabel lblCdigoMaticula;
	private JLabel lblCdigoAlumno;
	private JLabel lblNombreDelAlumno;
	private JTextField txtCodAlum;
	private JTextField txtNomApelli;
	private JLabel lblCdigoCurso;
	private JTextField txtCodMat;
	private JLabel lblAsignatura;
	private JTextField txtCurso;
	private JLabel lblFecha;
	private JLabel lblHora;
	private JTextField txtCodCurso;
	private JScrollPane scrollPane;
	private JButton btnBuscar;
	private JLabel lblCdigoRetiro;
	private JTextField txtCodRetiro;
	private Timer tiempo;
	//Retiro re1 = new Retiro();
	private JTable tblDatos;
	private DefaultTableModel model;
	private JLabel lblNewLabel;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JLabel lblFecha_1;
	private JTextField txtFecha;
	private JLabel lblHora_1;
	private JTextField txtHora;
	private JTextField txtFecha2;
	private JTextField txtHora2;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DialogRegistroRetiro dialog = new DialogRegistroRetiro();
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
	public DialogRegistroRetiro() {
		setTitle("Retiro");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 734, 482);
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
		lblTitle.setBounds(0, 0, 720, 31);
		contentPane.add(lblTitle);
		
		lblCdigoMaticula = new JLabel("Código Matricula:");
		lblCdigoMaticula.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCdigoMaticula.setBounds(34, 94, 135, 25);
		contentPane.add(lblCdigoMaticula);
		
		lblCdigoAlumno = new JLabel("Código Alumno:");
		lblCdigoAlumno.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCdigoAlumno.setBounds(34, 128, 123, 25);
		contentPane.add(lblCdigoAlumno);
		
		lblNombreDelAlumno = new JLabel("Nombre y Apellidos:");
		lblNombreDelAlumno.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombreDelAlumno.setBounds(34, 164, 147, 25);
		contentPane.add(lblNombreDelAlumno);
		
		txtCodAlum = new JTextField();
		txtCodAlum.setBounds(189, 134, 91, 19);
		contentPane.add(txtCodAlum);
		
		txtNomApelli = new JTextField();
		txtNomApelli.setBounds(189, 169, 245, 19);
		contentPane.add(txtNomApelli);
		
		lblCdigoCurso = new JLabel("Código curso");
		lblCdigoCurso.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCdigoCurso.setBounds(447, 129, 102, 25);
		contentPane.add(lblCdigoCurso);
		
		txtCodMat = new JTextField();
		txtCodMat.setBounds(189, 99, 91, 19);
		contentPane.add(txtCodMat);
		
		lblAsignatura = new JLabel("Asignatura:");
		lblAsignatura.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAsignatura.setBounds(447, 164, 102, 25);
		contentPane.add(lblAsignatura);
		
		txtCurso = new JTextField();
		txtCurso.setBounds(549, 169, 135, 19);
		contentPane.add(txtCurso);
		
		lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFecha.setBounds(34, 199, 57, 25);
		contentPane.add(lblFecha);
		
		lblHora = new JLabel("Hora:");
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHora.setBounds(211, 199, 44, 25);
		contentPane.add(lblHora);
		
		txtCodCurso = new JTextField();
		txtCodCurso.setBounds(549, 134, 135, 19);
		contentPane.add(txtCodCurso);
		
		lblCdigoRetiro = new JLabel("Código retiro:");
		lblCdigoRetiro.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCdigoRetiro.setBounds(482, 36, 102, 25);
		contentPane.add(lblCdigoRetiro);
		
		txtCodRetiro = new JTextField();
		txtCodRetiro.setBounds(594, 36, 102, 19);
		txtCodRetiro.setText("200001");
		txtCodRetiro.setEditable(false);
		txtCodRetiro.setFocusable(false);
		txtCodRetiro.setCursor(null);
		contentPane.add(txtCodRetiro);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 244, 675, 159);
		contentPane.add(scrollPane);
		
		tblDatos = new JTable();
		scrollPane.setViewportView(tblDatos);
		model = new DefaultTableModel();
		model.addColumn("Código retiro");
		model.addColumn("Código matricula");
		model.addColumn("Nombre y apellidos");
		model.addColumn("Código curso");
		model.addColumn("Curso");
		model.addColumn("Fecha");
		model.addColumn("Hora");
		tblDatos.setModel(model);
		//header.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBuscar.setBounds(300, 96, 90, 23);
		contentPane.add(btnBuscar);
		
		lblNewLabel = new JLabel("Matricula:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(34, 77, 102, 13);
		contentPane.add(lblNewLabel);
		
		separator = new JSeparator();
		separator.setForeground(Color.GRAY);
		separator.setBounds(22, 233, 675, 19);
		contentPane.add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setForeground(Color.GRAY);
		separator_1.setBounds(22, 71, 675, 19);
		contentPane.add(separator_1);
		
		separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setForeground(Color.GRAY);
		separator_2.setBounds(695, 71, 13, 163);
		contentPane.add(separator_2);
		
		separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setForeground(Color.GRAY);
		separator_3.setBounds(22, 71, 13, 163);
		contentPane.add(separator_3);
		
		lblFecha_1 = new JLabel("Fecha:");
		lblFecha_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFecha_1.setBounds(22, 36, 57, 25);
		contentPane.add(lblFecha_1);
		
		txtFecha = new JTextField();
		txtFecha.setText("01/07/2025");
		txtFecha.setFocusable(false);
		txtFecha.setEditable(false);
		txtFecha.setBounds(87, 41, 114, 19);
		contentPane.add(txtFecha);
		
		lblHora_1 = new JLabel("Hora:");
		lblHora_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHora_1.setBounds(211, 36, 44, 25);
		contentPane.add(lblHora_1);
		
		txtHora = new JTextField();
		txtHora.setText("00:05:41");
		txtHora.setFocusable(false);
		txtHora.setEditable(false);
		txtHora.setBounds(265, 41, 114, 19);
		contentPane.add(txtHora);
		
		txtFecha2 = new JTextField();
		txtFecha2.setBounds(97, 204, 102, 19);
		contentPane.add(txtFecha2);
		txtFecha2.setColumns(10);
		
		txtHora2 = new JTextField();
		txtHora2.setBounds(265, 204, 105, 19);
		contentPane.add(txtHora2);
		txtHora2.setColumns(10);
		
		btnAdicionar = new JButton("ADICIONAR");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAdicionar.setBounds(94, 414, 114, 21);
		contentPane.add(btnAdicionar);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(this);
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnModificar.setBounds(302, 413, 114, 21);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEliminar.setBounds(510, 413, 114, 21);
		contentPane.add(btnEliminar);
		
		
		// incicializacion de reloj
		tiempo = new Timer(1000, e -> horaActualizada());
		tiempo.start();
		

}
	Retiro r = new Retiro(1,123456,"Zeus", 123, "phuthon", "12/10/2025", "13:00");
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(e);
		}
		if (e.getSource() == btnBuscar) {
			do_btnBuscar_actionPerformed(e);
		}
	}
	
	ArreglosRetiro ar = new ArreglosRetiro();
	protected void do_btnBuscar_actionPerformed(ActionEvent e) {	
		DialogBuscarRetiro frame = new DialogBuscarRetiro();
		frame.setVisible(true);
	}

	protected void actionPerformedBtnAdicionar(ActionEvent e) {
		listar();
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
	}
	
	
	
	
	//Listar
	public void listar() {
		model.setRowCount(0);
		for (int i = 0; i < ar.tamanio(); i++) {
			Object[] fila = {
					ar.obtener(i).getCodRetiro(),
					ar.obtener(i).getCodMatricula(),
					ar.obtener(i).getNombresApellidos(),
					ar.obtener(i).getCodCurso(),
					ar.obtener(i).getCurso(),
					ar.obtener(i).getFecha(),
					ar.obtener(i).getHora()
			};
			model.addRow(fila);
		}
	}
	//parametros de leectura
	public int leerCodigoMatricula() {
		return Integer.parseInt(txtCodMat.getText());
	}
	
	public int leerCodigoAlumno() {
		return Integer.parseInt(txtCodAlum.getText());
	}
	
	public String leerApellidos() {
		return txtNomApelli.getText();
	}
	
	public int leerCodigoCurso() {
		return Integer.parseInt(txtCodCurso.getText());
	}
	
	public String leerCurso() {
		return txtCurso.getText();
	}
	//metodo limpiar
	void limpieza() {
		txtCodMat.setText("");
		txtCodAlum.setText("");
		txtNomApelli.setText("");
		txtCodCurso.setText("");
		txtCurso.setText("");
	}
	
	private void horaActualizada() {
		String Hora = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
	}

}
