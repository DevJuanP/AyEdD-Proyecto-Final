package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import arreglos.ArreglosAlumno;
import arreglos.ArreglosCursos;
import arreglos.ArreglosMatricula;
import arreglos.ArreglosRetiro;
import clases.Alumno;
import clases.Curso;
import clases.Matricula;
import clases.Retiro;

public class DialogRegistroRetiro extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTable tblDatos;
	private DefaultTableModel model;

	private JTextField txtCodRetiro, txtCodMat, txtCodAlum, txtNombres, txtApellidos,
			txtCodCurso, txtAsignatura, txtFecha, txtHora;
	private JButton btnBuscar, btnAdicionar, btnModificar, btnEliminar;

	private Timer tiempo;
	private ArreglosRetiro ar = new ArreglosRetiro();
	private JLabel lblEstado;
	private JTextField txtEstado;
	private JLabel lblTitle;
	private JLabel lblCdigoRetiro;
	private JLabel lblFecha;
	private JLabel lblHora;
	private JPanel panelConsulta;
	private JLabel lblCdigoMaticula;
	private JLabel lblCdigoAlumno;
	private JLabel lblNombreDelAlumno;
	private JLabel lblApellidos;
	private JLabel lblCdigoCurso;
	private JLabel lblAsignatura;
	private JScrollPane scrollPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				DialogRegistroRetiro dialog = new DialogRegistroRetiro();
				dialog.setVisible(true);
				dialog.setLocationRelativeTo(null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public DialogRegistroRetiro() {
		setTitle("Registro de Retiro");
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

		txtCodRetiro = new JTextField(String.valueOf(codR()));
		txtCodRetiro.setBounds(594, 36, 102, 19);
		txtCodRetiro.setEditable(false);
		txtCodRetiro.setFocusable(false);
		contentPane.add(txtCodRetiro);

		lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFecha.setBounds(22, 36, 57, 25);
		contentPane.add(lblFecha);

		txtFecha = new JTextField(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yy")));
		txtFecha.setEditable(false);
		txtFecha.setFocusable(false);
		txtFecha.setBounds(87, 41, 114, 19);
		contentPane.add(txtFecha);

		lblHora = new JLabel("Hora:");
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHora.setBounds(211, 36, 44, 25);
		contentPane.add(lblHora);

		txtHora = new JTextField();
		txtHora.setEditable(false);
		txtHora.setFocusable(false);
		txtHora.setBounds(265, 41, 114, 19);
		contentPane.add(txtHora);

		panelConsulta = new JPanel();
		panelConsulta.setLayout(null);
		panelConsulta.setBorder(new TitledBorder(new LineBorder(Color.GRAY), "MATRICULA"));
		panelConsulta.setBounds(22, 71, 675, 183);
		contentPane.add(panelConsulta);

		lblCdigoMaticula = new JLabel("Código Matricula:");
		lblCdigoMaticula.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCdigoMaticula.setBounds(15, 27, 135, 25);
		panelConsulta.add(lblCdigoMaticula);

		lblCdigoAlumno = new JLabel("Código Alumno:");
		lblCdigoAlumno.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCdigoAlumno.setBounds(15, 61, 123, 25);
		panelConsulta.add(lblCdigoAlumno);

		lblNombreDelAlumno = new JLabel("Nombres:");
		lblNombreDelAlumno.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombreDelAlumno.setBounds(15, 97, 147, 25);
		panelConsulta.add(lblNombreDelAlumno);

		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblApellidos.setBounds(15, 132, 147, 25);
		panelConsulta.add(lblApellidos);

		lblCdigoCurso = new JLabel("Código curso");
		lblCdigoCurso.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCdigoCurso.setBounds(428, 62, 102, 25);
		panelConsulta.add(lblCdigoCurso);

		lblAsignatura = new JLabel("Asignatura:");
		lblAsignatura.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAsignatura.setBounds(428, 97, 102, 25);
		panelConsulta.add(lblAsignatura);

		txtCodMat = new JTextField();
		txtCodMat.setBounds(170, 32, 91, 19);
		panelConsulta.add(txtCodMat);

		txtCodAlum = new JTextField();
		txtCodAlum.setBounds(170, 67, 91, 19);
		panelConsulta.add(txtCodAlum);

		txtNombres = new JTextField();
		txtNombres.setBounds(170, 102, 245, 19);
		panelConsulta.add(txtNombres);

		txtApellidos = new JTextField();
		txtApellidos.setBounds(170, 135, 245, 19);
		panelConsulta.add(txtApellidos);

		txtCodCurso = new JTextField();
		txtCodCurso.setBounds(530, 67, 135, 19);
		panelConsulta.add(txtCodCurso);

		txtAsignatura = new JTextField();
		txtAsignatura.setBounds(530, 102, 135, 19);
		panelConsulta.add(txtAsignatura);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBuscar.setBounds(281, 29, 90, 23);
		btnBuscar.addActionListener(this);
		panelConsulta.add(btnBuscar);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEstado.setBounds(428, 140, 102, 25);
		panelConsulta.add(lblEstado);
		
		txtEstado = new JTextField();
		txtEstado.setBounds(530, 137, 69, 19);
		txtEstado.setText("2");
		panelConsulta.add(txtEstado);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 264, 675, 159);
		contentPane.add(scrollPane);

		tblDatos = new JTable();
		model = new DefaultTableModel();
		model.addColumn("Cod Reti");
		model.addColumn("Cod Mat");
		model.addColumn("Cod Alumn");
		model.addColumn("Nombre");
		model.addColumn("Apellidos");
		model.addColumn("Cod Curso");
		model.addColumn("Curso");
		model.addColumn("Fecha");
		model.addColumn("Hora");
		model.addColumn("Estado");  // NUEVA COLUMNA
		tblDatos.setModel(model);
		scrollPane.setViewportView(tblDatos);
		
		tblDatos.getSelectionModel().addListSelectionListener(e -> {
		    if (!e.getValueIsAdjusting() && tblDatos.getSelectedRow() != -1) {
		        int fila = tblDatos.getSelectedRow();
		        if (fila == -1) {
		            JOptionPane.showMessageDialog(this, "Seleccione una fila para editar.");
		            return;
		        }
		        txtCodRetiro.setText(tblDatos.getValueAt(fila, 0).toString());
		        txtCodMat.setText(tblDatos.getValueAt(fila, 1).toString());
		        txtCodAlum.setText(tblDatos.getValueAt(fila, 2).toString());
		        txtNombres.setText(tblDatos.getValueAt(fila, 3).toString());
		        txtApellidos.setText(tblDatos.getValueAt(fila, 4).toString());
		        txtCodCurso.setText(tblDatos.getValueAt(fila, 5).toString());
		        txtAsignatura.setText(tblDatos.getValueAt(fila, 6).toString());
		        txtFecha.setText(tblDatos.getValueAt(fila, 7).toString());
		        txtHora.setText(tblDatos.getValueAt(fila, 8).toString());
		        txtEstado.setText(tblDatos.getValueAt(fila, 9).toString());
		    }
		});

		btnAdicionar = new JButton("ADICIONAR");
		btnAdicionar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAdicionar.setBounds(93, 433, 114, 21);
		btnAdicionar.addActionListener(this);
		contentPane.add(btnAdicionar);

		btnModificar = new JButton("MODIFICAR");
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnModificar.setBounds(300, 433, 114, 21);
		btnModificar.addActionListener(this);
		contentPane.add(btnModificar);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEliminar.setBounds(507, 433, 114, 21);
		btnEliminar.addActionListener(this);
		contentPane.add(btnEliminar);

		tiempo = new Timer(1000, e -> horaActualizada());
		tiempo.start();

		listar();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscar) do_btnBuscar_actionPerformed();
		if (e.getSource() == btnAdicionar) actionPerformedBtnAdicionar();
		if (e.getSource() == btnModificar) actionPerformedBtnModificar();
		if (e.getSource() == btnEliminar) eliminarDatos();
	}

	private void do_btnBuscar_actionPerformed() {
		DialogBuscarMatricula dBMatricula = new DialogBuscarMatricula(this);
		dBMatricula.setLocationRelativeTo(null);
		dBMatricula.setVisible(true);
	}

	private void actionPerformedBtnAdicionar() {
		try {
			int estado = 2; // NUEVO ESTADO
			Retiro r = new Retiro(
				codR(),
				leerCodigoMatricula(),
				leerCodigoAlum(),
				leerNombres(),
				leerApellidos(),
				leerCodigoCurso(),
				leerCurso(),
				leerFecha(),
				leerHora(),
				leerEstado()
			);
			ar.adicionar(r);
			ar.actualizarArchivo();
			listar();
			limpieza();
			txtCodRetiro.setText(String.valueOf(codR()));
			mensaje("Retiro registrado correctamente.");
		} catch (Exception ex) {
			mensaje("Error: " + ex.getMessage());
		}
	}

	private void actionPerformedBtnModificar() {
		try {
			int codMatricula = leerCodigoMatricula();
			Retiro r = ar.buscar(codMatricula);
			if (r != null) {
				r.setCodAlum(leerCodigoAlum());
				r.setNombres(leerNombres());
				r.setApellidos(leerApellidos());
				r.setCodCurso(leerCodigoCurso());
				r.setCurso(leerCurso());
				ar.actualizarArchivo();
				listar();
				limpieza();
				mensaje("Retiro modificado correctamente.");
			} else {
				error("El código de matrícula ingresado no existe", txtCodMat);
			}
		} catch (Exception ex) {
			error("Error: " + ex.getMessage(), txtCodMat);
		}
	}

	private void eliminarDatos() {
		int fila = tblDatos.getSelectedRow();
		if (fila == -1) {
			mensaje("Debes seleccionar una fila para eliminar.");
			return;
		}

		int respuesta = JOptionPane.showConfirmDialog(this, "¿Deseas eliminar este registro?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
		if (respuesta == JOptionPane.YES_OPTION) {
			int codRetiro = (int) model.getValueAt(fila, 0);
			ar.eliminar(codRetiro);
			ar.actualizarArchivo();
			listar();
			mensaje("Retiro eliminado correctamente.");
		}
	}
	
	ArreglosAlumno aa = new ArreglosAlumno();
	ArreglosCursos ac = new ArreglosCursos();
	ArreglosMatricula am = new ArreglosMatricula();

	private void listar() {
		model.setRowCount(0);
		for (int i = 0; i < ar.tamanio(); i++) {
			Retiro r = ar.obtener(i);
			
			int codMatric = r.getCodMatricula();
			Matricula  m =  am.buscarMatricula(codMatric);
			
			if(m != null ) {
				int codAlum = m.getCodAlumno();
				int codCurso = m.getCodCurso();
				
				Alumno a = aa.buscarCodigo(codAlum);
				Curso c = ac.buscarCodigo(codCurso);
				
				if(a != null && c != null) {
					model.addRow(new Object[]{
							r.getCodRetiro(), r.getCodMatricula(), codAlum,
							a.getNombres(), a.getApellidos(), codCurso,
							c.getAsignatura(), r.getFecha(), r.getHora(), a.getEstado() // NUEVO
					});
					
				}
				
				
			}
			
		}
	}

	public void leerBusquedaRetiro(Matricula m) {
		txtCodMat.setText(String.valueOf(m.getNumMatricula()));
		txtCodAlum.setText(String.valueOf(m.getCodAlumno()));
		txtNombres.setText(m.getNombres());
		txtApellidos.setText(m.getApellidos());
		txtCodCurso.setText(String.valueOf(m.getCodCurso()));
		txtAsignatura.setText(m.getAsignatura());
	}

	private int codR() {
		if (ar.tamanio() == 0)
			return 1001;
		else
			return ar.obtener(ar.tamanio() - 1).getCodRetiro() + 1;
	}

	private void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}

	private void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}

	private void limpieza() {
		txtCodMat.setText("");
		txtCodAlum.setText("");
		txtNombres.setText("");
		txtApellidos.setText("");
		txtCodCurso.setText("");
		txtAsignatura.setText("");
		txtEstado.setText("");
		txtCodMat.requestFocus();
	}

	private int leerCodigoMatricula() {
		return Integer.parseInt(txtCodMat.getText());
	}

	private int leerCodigoAlum() {
		return Integer.parseInt(txtCodAlum.getText());
	}

	private String leerNombres() {
		return txtNombres.getText();
	}

	private String leerApellidos() {
		return txtApellidos.getText();
	}

	private int leerCodigoCurso() {
		return Integer.parseInt(txtCodCurso.getText());
	}

	private String leerCurso() {
		return txtAsignatura.getText();
	}

	private String leerFecha() {
		return txtFecha.getText();
	}

	private String leerHora() {
		return txtHora.getText();
	}
	
	private int leerEstado() {
		return Integer.parseInt(txtEstado.getText());
	}
	private void horaActualizada() {
		String hora = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
		txtHora.setText(hora);
	}
}
