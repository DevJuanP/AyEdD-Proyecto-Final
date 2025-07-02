package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Frame;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arreglos.ArreglosMatricula;
import clases.Matricula;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class DialogBuscarRetiro extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblAsignatura;
	private JTextField txtBuscar;
	private JButton btEnviar;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel modeloBuscar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArreglosMatricula am = new ArreglosMatricula(); // crear instancia
					DialogBuscarRetiro frame = new DialogBuscarRetiro(null, am);
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
	 private ArreglosMatricula am;
	public DialogBuscarRetiro(Frame owner, ArreglosMatricula amCompartido) {
		super();
        this.am = amCompartido; 
		setTitle("Buscar Cursos");
		setBounds(100, 100, 607, 276);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblAsignatura = new JLabel("Asignatura: ");
		lblAsignatura.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAsignatura.setBounds(22, 11, 96, 17);
		contentPane.add(lblAsignatura);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(120, 12, 223, 19);
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		btEnviar = new JButton("Enviar");
		btEnviar.addActionListener(this);
		btEnviar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btEnviar.setBounds(375, 10, 85, 21);
		contentPane.add(btEnviar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 49, 551, 171);
		contentPane.add(scrollPane);
		
		table = new JTable();
		modeloBuscar=new DefaultTableModel();
		modeloBuscar.addColumn("Cod Mat");
		modeloBuscar.addColumn("Cod Alum");
		modeloBuscar.addColumn("Nombres y apellidos");
		modeloBuscar.addColumn("Cod curso");	
		modeloBuscar.addColumn("Curso");
		modeloBuscar.addColumn("Fecha");
		modeloBuscar.addColumn("Hora");
		table.setModel(modeloBuscar);
		
		table.setModel(modeloBuscar);
		scrollPane.setViewportView(table);
		
		listaDatos();
	}
	
	private void listaDatos() {
		modeloBuscar.setRowCount(0);
        for (int i = 0; i < am.tamanio(); i++) {
            Matricula m = am.obtener(i);
            Object[] fila = {
                m.getNumMatricula(),
                m.getCodAlumno(),
                m.getCodCurso(),
                m.getFecha(),
                m.getHora(),
                m.getEstado()
            };
            modeloBuscar.addRow(fila);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btEnviar) {
			actionPerformedBtEnviar(e);
		}
	}
	protected void actionPerformedBtEnviar(ActionEvent e) {
		int fila = table.getSelectedRow();
		if (fila == -1) {
			JOptionPane.showMessageDialog(this,"Selecciona una fila" + "Advertencia" + JOptionPane.WARNING_MESSAGE);
			return;
		}
		int numMatricula = Integer.parseInt((String) table.getValueAt(fila,0));
		int numCodAlumno = Integer.parseInt((String) table.getValueAt(fila, 1));
		int codCurso = Integer.parseInt((String) table.getValueAt(fila, 2));
		int fecha = Integer.parseInt((String) table.getValueAt(fila, 3));
		int hora = Integer.parseInt((String) table.getValueAt(fila, 4));
	}
}
