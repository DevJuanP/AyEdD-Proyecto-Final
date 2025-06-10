package gui;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Image;
import javax.swing.Icon;

public class Principal extends JFrame {

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
		mntmAlumno.setFont(new Font("Tahoma", Font.BOLD, 12));
		mnMatenimiento.add(mntmAlumno);
		
		mntCurso = new JMenuItem("Curso");
		mntCurso.setFont(new Font("Tahoma", Font.BOLD, 12));
		mnMatenimiento.add(mntCurso);
		
		mnRegistro = new JMenu("Registro");
		mnRegistro.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuBar.add(mnRegistro);
		
		mntmMatricula = new JMenuItem("Matr\u00EDcula");
		mntmMatricula.setFont(new Font("Tahoma", Font.BOLD, 12));
		mnRegistro.add(mntmMatricula);
		
		mntmRetiro = new JMenuItem("Retiro");
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
		mnArchivo.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir\r\n");
		mnArchivo.add(mntmSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblFondo = new JLabel();
		lblFondo.setBounds(0, 0, 598, 370);
		contentPane.add(lblFondo);
	}
}
