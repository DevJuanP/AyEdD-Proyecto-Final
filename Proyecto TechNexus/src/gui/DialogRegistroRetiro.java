package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

//import javax.swing.ButtonGroup;
//import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import arreglos.ArreglosMatricula;
import arreglos.ArreglosRetiro;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import clases.Retiro;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import javax.swing.JSeparator;





public class DialogRegistroRetiro extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lblTitle;
	private JLabel lblCdigoMaticula;
	private JLabel lblCdigoAlumno;
	private JLabel lblNombreDelAlumno;
	private JTextField txtCodAlum;
	private JTextField txtNombres;
	private JLabel lblCdigoCurso;
	private JTextField txtCodMat;
	private JLabel lblAsignatura;
	private JTextField txtAsignatura;
	private JTextField txtCodCurso;
	private JScrollPane scrollPane;
	private JButton btnBuscar;
	private JLabel lblCdigoRetiro;
	private JTextField txtCodRetiro;
	private Timer tiempo;
	private JTable tblDatos;
	private DefaultTableModel model;
	private JLabel lblFecha_1;
	private JTextField txtFecha;
	private JLabel lblHora_1;
	private JTextField txtHora;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JPanel panelConsulta;
	private JTextField txtApellidos;
	private JLabel lblApellidos;
	

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
		setTitle("Registro de Retiro");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 730, 500);
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
		scrollPane.setBounds(21, 264, 675, 159);
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
		
		panelConsulta = new JPanel();
		panelConsulta.setLayout(null); 
		panelConsulta.setBorder(new TitledBorder(new LineBorder(Color.GRAY), "MATRICULA"));
		panelConsulta.setBounds(22, 71, 675, 183); 
		getContentPane().add(panelConsulta);
		
		lblCdigoMaticula = new JLabel("Código Matricula:");
		lblCdigoMaticula.setBounds(15, 27, 135, 25);
		panelConsulta.add(lblCdigoMaticula);
		lblCdigoMaticula.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		lblCdigoAlumno = new JLabel("Código Alumno:");
		lblCdigoAlumno.setBounds(15, 61, 123, 25);
		panelConsulta.add(lblCdigoAlumno);
		lblCdigoAlumno.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		lblNombreDelAlumno = new JLabel("Nombres:");
		lblNombreDelAlumno.setBounds(15, 97, 147, 25);
		panelConsulta.add(lblNombreDelAlumno);
		lblNombreDelAlumno.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtCodAlum = new JTextField();
		txtCodAlum.setBounds(170, 67, 91, 19);
		panelConsulta.add(txtCodAlum);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(170, 102, 245, 19);
		panelConsulta.add(txtNombres);
		
		lblCdigoCurso = new JLabel("Código curso");
		lblCdigoCurso.setBounds(428, 62, 102, 25);
		panelConsulta.add(lblCdigoCurso);
		lblCdigoCurso.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtCodMat = new JTextField();
		txtCodMat.setBounds(170, 32, 91, 19);
		panelConsulta.add(txtCodMat);
		
		lblAsignatura = new JLabel("Asignatura:");
		lblAsignatura.setBounds(428, 97, 102, 25);
		panelConsulta.add(lblAsignatura);
		lblAsignatura.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtAsignatura = new JTextField();
		txtAsignatura.setBounds(530, 102, 135, 19);
		panelConsulta.add(txtAsignatura);
		
		txtCodCurso = new JTextField();
		txtCodCurso.setBounds(530, 67, 135, 19);
		panelConsulta.add(txtCodCurso);
		
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(281, 29, 90, 23);
		panelConsulta.add(btnBuscar);
		btnBuscar.addActionListener(this);
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(170, 135, 245, 19);
		panelConsulta.add(txtApellidos);
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblApellidos.setBounds(15, 132, 147, 25);
		panelConsulta.add(lblApellidos);
		
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
		
		btnAdicionar = new JButton("ADICIONAR");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAdicionar.setBounds(87, 434, 114, 21);
		contentPane.add(btnAdicionar);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(this);
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnModificar.setBounds(295, 433, 114, 21);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEliminar.setBounds(503, 433, 114, 21);
		contentPane.add(btnEliminar);
		
		
		// incicializacion de reloj
		tiempo = new Timer(1000, e -> horaActualizada());
		tiempo.start();
		

}
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
	//Declaracion global
	ArreglosRetiro ar = new ArreglosRetiro();
	
	protected void do_btnBuscar_actionPerformed(ActionEvent e) {	
		/*DialogBuscarRetiro buscarRetiro = new DialogBuscarRetiro(null, am);
		buscarRetiro.setLocationRelativeTo(null);
		buscarRetiro.setVisible(true);*/
	}

	protected void actionPerformedBtnAdicionar(ActionEvent e) {
		/*Retiro r = new Retiro(1, leerCodigoMatricula(), leerApellidos(), leerCodigoCurso(), leerCurso(), leerFecha(), leerHora());
		ar.adicionar(r);
		listar();*/
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
	}

	protected void actionPerformedBtnEliminar(ActionEvent e) {
	}
	
	public void leerBusquedaRetiro(Retiro r) {
		txtCodMat.setText(String.valueOf(r.getCodMatricula()));
	}
	
	
	//Métodos tipo void (sin parámetros)
	public void listar() {
		model.setRowCount(0);
		for (int i = 0; i < ar.tamanio(); i++) {
			Object[] fila = {
					ar.obtener(i).getCodRetiro(),
					ar.obtener(i).getCodMatricula(),
					ar.obtener(i).getCodCurso(),
					ar.obtener(i).getNombres(),
					ar.obtener(i).getApellidos(),
					ar.obtener(i).getCurso(),
					ar.obtener(i).getFecha(),
					ar.obtener(i).getHora()
			};
			model.addRow(fila);
		}
	}
	
	void limpieza() {
		txtCodMat.setText("");
		txtCodAlum.setText("");
		txtNombres.setText("");
		txtCodCurso.setText("");
		txtAsignatura.setText("");
		txtAsignatura.setText("");
		txtCodMat.requestFocus();
	}
	
	//  Métodos tipo void (con parametros)
	 int leerCodigoMatricula() {
		return Integer.parseInt(txtCodMat.getText());
	}
	
	
	String leerApellidos() {
		return txtNombres.getText();
	}
	
	int leerCodigoCurso() {
		return Integer.parseInt(txtCodCurso.getText());
	}
	
	String leerCurso() {
		return txtAsignatura.getText();
	}
	
	String leerFecha() {
		return txtFecha.getText();
	}
	
	String leerHora() {
		return txtHora.getText();
	}
	
	/*wenas*/
	private void horaActualizada() {
		String Hora = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
	}
}
