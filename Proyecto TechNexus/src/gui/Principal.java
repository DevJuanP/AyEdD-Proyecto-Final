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
	private JMenuItem mntmSalir;
	private JLabel lblFondo;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNuevaConsulta;

	public static void main(String[] args) {
		Principal frame = new Principal();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
        // Establece los textos de los botones en espa�ol
        UIManager.put("OptionPane.yesButtonText", "S�");
        UIManager.put("OptionPane.noButtonText", "No");
	}

	public Principal() {
		setTitle("Sistema Insituci\u00F3n Educativa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 372);
		
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
		
		mntmNuevaConsulta = new JMenuItem("Nueva Consulta");
		mntmNuevaConsulta.addActionListener(this);
		mnConsulta.add(mntmNuevaConsulta);
		
		mnReporte = new JMenu("Reporte");
		mnReporte.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuBar.add(mnReporte);
		
		mntmNewMenuItem_1 = new JMenuItem("Nuevo Reporte");
		mnReporte.add(mntmNewMenuItem_1);
		
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
		ImageIcon icono = new ImageIcon("imagenes/educacion.png");
		Image iconoModificado = icono.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
		ImageIcon iconoRedimencionado = new ImageIcon(iconoModificado);

		lblFondo = new JLabel("");
		lblFondo.setBounds(-20, -19, 598, 370);
		lblFondo.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondo.setIcon(iconoRedimencionado);
		contentPane.add(lblFondo);
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmNuevaConsulta) {
			actionPerformedMntmNuevaConsulta(e);
		}
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
        // Establece los textos de los botones en espa�ol
        UIManager.put("OptionPane.yesButtonText", "S�");
        UIManager.put("OptionPane.noButtonText", "No");
		int respuesta;
		respuesta=JOptionPane.showConfirmDialog(this, "�Estas seguro que desea salir?","IMPORTANTE",JOptionPane.YES_NO_OPTION);
		if(respuesta == 0)
		System.exit(0);
	}
	protected void doMntmAlumnoActionPerformed(ActionEvent e) {
		DialogMantenimientoAlumno dMAlumno = new DialogMantenimientoAlumno();
		dMAlumno.setLocationRelativeTo(dMAlumno);
		dMAlumno.setVisible(true);
	}
	
	protected void doMntCursoActionPerformed(ActionEvent e) {
		DialogMantenimientoCursos dMCursos = new DialogMantenimientoCursos();
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
	protected void actionPerformedMntmNuevaConsulta(ActionEvent e) {
		DialogNuevaConsulta dialogNuevaConsulta = new DialogNuevaConsulta();
		dialogNuevaConsulta.setLocationRelativeTo(dialogNuevaConsulta);
		dialogNuevaConsulta.setVisible(true);
	}
}
