package gui;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arreglos.ArreglosMatricula;
import clases.Matricula;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogBuscarMatricula extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblAsignatura;
	private JTextField txtBuscar;
	private JButton btEnviar;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel modeloBuscar;
	public DialogRegistroRetiro dlgRegistroRetiro;
	
	public DialogBuscarMatricula(DialogRegistroRetiro dlg) {
		this.dlgRegistroRetiro = dlg;
		initComponents();
	}

	private void initComponents() {
		setTitle("Buscar Matricula");
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
		modeloBuscar.addColumn("Nombres");
		modeloBuscar.addColumn("Apellidos");
		modeloBuscar.addColumn("Cod curso");	
		modeloBuscar.addColumn("Curso");
		modeloBuscar.addColumn("Fecha");
		modeloBuscar.addColumn("Hora");
		table.setModel(modeloBuscar);
		
		table.setModel(modeloBuscar);
		scrollPane.setViewportView(table);
		
		listaDatos();
	}
	
	
	
	//Declaracion Global
	ArreglosMatricula ar = new ArreglosMatricula();
	
	private void listaDatos() {
		modeloBuscar.setRowCount(0);
        for (int i = 0; i < ar.tamanio(); i++) {
            Matricula m = ar.obtener(i);
            Object[] fila = {
                m.getNumMatricula(),
                m.getCodAlumno(),
                m.getNombres(),
                m.getApellidos(),
                m.getCodCurso(),
                m.getAsignatura(),
                m.getFecha(),
                m.getHora(),
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
		        JOptionPane.showMessageDialog(this, "Selecciona una fila", "Advertencia", JOptionPane.WARNING_MESSAGE);
		        return;
		    }
		    
		    try {
		        int numMatricula = Integer.parseInt(table.getValueAt(fila, 0).toString());
		        int numCodAlumno = Integer.parseInt(table.getValueAt(fila, 1).toString());
		        String nombre = table.getValueAt(fila, 2).toString();
		        String apellido = table.getValueAt(fila, 3).toString();
		        int codCurso = Integer.parseInt(table.getValueAt(fila, 4).toString());
		        String asignatura = table.getValueAt(fila, 5).toString();
		        String fecha = table.getValueAt(fila, 6).toString();
		        String hora = table.getValueAt(fila, 7).toString();
		        Matricula m = new Matricula(numMatricula,numCodAlumno,codCurso,nombre,apellido,asignatura,fecha,hora, codCurso);
		       dlgRegistroRetiro.leerBusquedaRetiro(m);
		        this.dispose();
		        
		    } catch (NumberFormatException ex) {
		        JOptionPane.showMessageDialog(this, 
		            "Error al obtener datos numéricos de la tabla", 
		            "Error de formato", 
		            JOptionPane.ERROR_MESSAGE);
		    } catch (Exception ex) {
		        JOptionPane.showMessageDialog(this, 
		            "Error inesperado: " + ex.getMessage(), 
		            "Error", 
		            JOptionPane.ERROR_MESSAGE);
		    }
		
	}
}
