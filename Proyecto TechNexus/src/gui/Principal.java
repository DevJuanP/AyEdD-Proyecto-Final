package gui;

import java.awt.Cursor;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Curso;

import java.awt.Font;
import java.awt.Image;
import javax.swing.Icon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class Principal extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnMatenimiento;
	private JMenu mnRegistro;
	private JMenu mnConsulta;
	private JMenu mnReporte;
	private JMenu mnArchivo;
	private JMenuItem mntmAlumno;
	private JMenuItem mntCurso;
	private JMenuItem mntmMatricula;
	private JMenuItem mntmRetiro;
	private JMenuItem mntmBuscarAlumno;
	private JMenuItem mntmBuscarCurso;
	private JMenuItem mntmBuscarMatricula;
	private JMenuItem mntmBuscarRetiro;
	private JMenuItem mntmMatriculaPendiente;
	private JMenuItem mntmMatriculaVigente;
	private JMenuItem mntmMatriculaPorCurso;
	private JMenuItem mntmSalir;
	private JLabel lblFondo;

	public static void main(String[] args) {
		Principal frame = new Principal();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
        // Establece los textos de los botones en español
        UIManager.put("OptionPane.yesButtonText", "Sí");
        UIManager.put("OptionPane.noButtonText", "No");
	}

	public Principal() {
		setTitle("Sistema Insituci\u00F3n Educativa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 428);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnMatenimiento = new JMenu("Mantenimiento");
		mnMatenimiento.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuBar.add(mnMatenimiento);
		
		mntmAlumno = new JMenuItem("Alumno");
		mntmAlumno.addActionListener(this);
		mntmAlumno.setFont(new Font("Tahoma", Font.BOLD, 12));
		mnMatenimiento.add(mntmAlumno);
		
		mntCurso = new JMenuItem("Curso");
		mntCurso.addActionListener(this);
		mntCurso.setFont(new Font("Tahoma", Font.BOLD, 12));
		mnMatenimiento.add(mntCurso);
		
		mnRegistro = new JMenu("Registro");
		mnRegistro.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuBar.add(mnRegistro);
		
		mntmMatricula = new JMenuItem("Matr\u00EDcula");
		mntmMatricula.addActionListener(this);
		mntmMatricula.setFont(new Font("Tahoma", Font.BOLD, 12));
		mnRegistro.add(mntmMatricula);
		
		mntmRetiro = new JMenuItem("Retiro");
		mntmRetiro.addActionListener(this);
		mntmRetiro.setFont(new Font("Tahoma", Font.BOLD, 12));
		mnRegistro.add(mntmRetiro);
		
		mnConsulta = new JMenu("Consulta");
		mnConsulta.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuBar.add(mnConsulta);
		
		mntmBuscarAlumno = new JMenuItem("Buscar Alumno");
		mntmBuscarAlumno.setFont(new Font("Tahoma", Font.BOLD, 12));
		mnConsulta.add(mntmBuscarAlumno);
		
		mntmBuscarCurso = new JMenuItem("Buscar Curso");
		mntmBuscarCurso.setFont(new Font("Tahoma", Font.BOLD, 12));
		mnConsulta.add(mntmBuscarCurso);
		
		mntmBuscarMatricula = new JMenuItem("Buscar Matricula");
		mntmBuscarMatricula.setFont(new Font("Tahoma", Font.BOLD, 12));
		mnConsulta.add(mntmBuscarMatricula);
		
		mntmBuscarRetiro = new JMenuItem("Buscar Retiro");
		mntmBuscarRetiro.setFont(new Font("Tahoma", Font.BOLD, 12));
		mnConsulta.add(mntmBuscarRetiro);
		
		mnReporte = new JMenu("Reporte");
		mnReporte.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuBar.add(mnReporte);
		
		mntmMatriculaPendiente = new JMenuItem("Matr\u00EDcula pendiente");
		mntmMatriculaPendiente.setFont(new Font("Tahoma", Font.BOLD, 12));
		mnReporte.add(mntmMatriculaPendiente);
		
		mntmMatriculaVigente = new JMenuItem("Matr\u00EDcula vigente");
		mntmMatriculaVigente.setFont(new Font("Tahoma", Font.BOLD, 12));
		mnReporte.add(mntmMatriculaVigente);
		
		mntmMatriculaPorCurso = new JMenuItem("Matriculados por curso");
		mntmMatriculaPorCurso.setFont(new Font("Tahoma", Font.BOLD, 12));
		mnReporte.add(mntmMatriculaPorCurso);
		
		mnArchivo = new JMenu("Archivo");
		mnArchivo.addActionListener(this);
		mnArchivo.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir\r\n");
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Imagen de fondo
		ImageIcon icono = new ImageIcon(Principal.class.getResource("/imagenes/educacion.png"));
		Image iconoModificado = icono.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
		ImageIcon iconoRedimencionado = new ImageIcon(iconoModificado);

		lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 598, 370);
		lblFondo.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondo.setIcon(iconoRedimencionado);
		contentPane.add(lblFondo);
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmRetiro) {
			doMntmRetiroActionPerformed(e);
		}
		if (e.getSource() == mntmMatricula) {
			doMntmMatriculaActionPerformed(e);
		}
		if (e.getSource() == mntmAlumno) {
			doMntmAlumnoActionPerformed(e);
		}
		if (e.getSource() == mntCurso) {
			doMntCursoActionPerformed(e);
		}
		if (e.getSource() == mntmSalir) {
			doMntmSalirActionPerformed(e);
		}
	}
	protected void doMntmSalirActionPerformed(ActionEvent e) {
        // Establece los textos de los botones en español
        UIManager.put("OptionPane.yesButtonText", "Sí");
        UIManager.put("OptionPane.noButtonText", "No");
		int respuesta;
		respuesta=JOptionPane.showConfirmDialog(this, "¿Estas seguro que desea salir?","IMPORTANTE",JOptionPane.YES_NO_OPTION);
		if(respuesta == 0)
		System.exit(0);
	}
	protected void doMntmAlumnoActionPerformed(ActionEvent e) {
		DialogMantenimientoAlumno dMAlumno = new DialogMantenimientoAlumno();
		dMAlumno.setLocationRelativeTo(dMAlumno);
		dMAlumno.setVisible(true);
	}
	
	protected void doMntCursoActionPerformed(ActionEvent e) {
		FrmMantenimientoCursos dMCursos = new FrmMantenimientoCursos();
		dMCursos.setLocationRelativeTo(dMCursos);
		dMCursos.setVisible(true);
	}
	protected void doMntmMatriculaActionPerformed(ActionEvent e) {
		DialogRegistroMatricula dRMatricula = new DialogRegistroMatricula();
		dRMatricula.setLocationRelativeTo(dRMatricula);
		dRMatricula.setVisible(true);
	}
	protected void doMntmRetiroActionPerformed(ActionEvent e) {
		DialogRegistroRetiro dRRetiro = new DialogRegistroRetiro();
		dRRetiro.setLocationRelativeTo(dRRetiro);
		dRRetiro.setVisible(true);
	}
}
