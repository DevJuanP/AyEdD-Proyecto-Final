package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import arreglos.ArreglosAlumno;
import clases.Alumno;

public class DialogBuscarAlumnos extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblAsignatura;
	private JTextField txtBuscar;
	private JButton btBuscar_2;
	private JButton btEnviar;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel modeloBuscar;
	private ArreglosAlumno al=new ArreglosAlumno();
	private DialogRegistroMatricula frameDeMatricula;
	/**
	 * Launch the application. */
	public DialogBuscarAlumnos(DialogRegistroMatricula frm) {
	    this.frameDeMatricula = frm;
	    initComponents();
	}
	
	/**
	 * Create the frame.
	 */
	private void initComponents() {
		setTitle("Buscar Alumnos");
		setBounds(100, 100, 607, 276);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblAsignatura = new JLabel("Apellido: ");
		lblAsignatura.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAsignatura.setBounds(22, 11, 96, 17);
		contentPane.add(lblAsignatura);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(120, 12, 223, 19);
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		btBuscar_2 = new JButton("Buscar");
		btBuscar_2.addActionListener(this);
		btBuscar_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btBuscar_2.setBounds(376, 10, 85, 21);
		contentPane.add(btBuscar_2);
		
		btEnviar = new JButton("Enviar");
		btEnviar.addActionListener(this);
		btEnviar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btEnviar.setBounds(488, 10, 85, 21);
		contentPane.add(btEnviar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 49, 551, 171);
		contentPane.add(scrollPane);
		
		table = new JTable();
		String[] columnas = {"C�digo", "Nombre", "Apellidos", "Edad", "Tel�fono", "DNI", "Estado"};
		modeloBuscar = new DefaultTableModel(columnas, 0);
		table.setModel(modeloBuscar);
		
		table.setModel(modeloBuscar);
		scrollPane.setViewportView(table);
		
		cargarTabla(DialogMantenimientoAlumno.alumnosList.getAlumnosList());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btEnviar) {
			actionPerformedBtEnviar(e);
		}
		if (e.getSource() == btBuscar_2) {
			actionPerformedBtBuscar_2(e);
		}
		// TODO Auto-generated method stub
		
	}
	protected void actionPerformedBtBuscar_2(ActionEvent e) {
		ArrayList <Alumno> alumApe = DialogMantenimientoAlumno.alumnosList.buscarApellido(leerApellido());
		cargarTabla(alumApe);
	}
	protected void actionPerformedBtEnviar(ActionEvent e) {
		int fila = table.getSelectedRow();
		if (fila != -1) {
			String cod = table.getValueAt(fila, 0).toString();
			String nom = table.getValueAt(fila, 1).toString();
			String ape = table.getValueAt(fila, 2).toString();
			String edad = table.getValueAt(fila, 3).toString();
			String cel = table.getValueAt(fila, 4).toString();
			String dni = table.getValueAt(fila, 5).toString();
			String estado = table.getValueAt(fila, 6).toString();

			frameDeMatricula.TXTcodigoAlum.setText(cod);
			frameDeMatricula.TXTnombres.setText(nom);
			frameDeMatricula.TXTapellidos.setText(ape);
			frameDeMatricula.TXTedad.setText(edad);
			frameDeMatricula.TXTcelular.setText(cel);
			frameDeMatricula.TXTdni.setText(dni);
			frameDeMatricula.TXTestado.setText(estado);

			dispose();  // Cierra la ventana despu�s de enviar los datos
		}
	}
	
	
	private String leerApellido() {
		return txtBuscar.getText().trim();
	}
	
	/*private ArrayList <Alumno> leetAlumnosTXT() {
		
	}
	*/
	private void cargarTabla(ArrayList <Alumno> arrList) {
		for (Alumno a : arrList) {
			modeloBuscar.addRow(new Object[] {a.getCodAlumno(),a.getNombres(), a.getApellidos(), a.getEdad(), a.getCelular(), a.getDni(), a.getEstado()});
		}
	}

	public void setModal(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
