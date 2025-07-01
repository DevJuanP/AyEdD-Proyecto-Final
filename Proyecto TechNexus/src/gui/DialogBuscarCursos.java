package gui;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import arreglos.ArreglosCursos;
import clases.Curso;

import java.awt.*;
import java.awt.event.*;

public class DialogBuscarCursos extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JLabel lblAsignatura;
	private JTextField txtBuscar;
	private JScrollPane scrollPane;
	private JButton btnEnviarDlg;
	private JTable tableBuscar;
	private DefaultTableModel modeloBuscar;
	public DialogRegistroMatricula dlgRMatricula;
	

	// Constructor que recibe el formulario principal
	public DialogBuscarCursos(DialogRegistroMatricula dlg) {
		this.dlgRMatricula = dlg;
		initComponents(); // Llama a la función que construye la interfaz
	}

	private void initComponents() {
		setTitle("Buscar Curso");
		setModal(true);
		setBounds(100, 100, 607, 291);
		setLayout(null);

		lblAsignatura = new JLabel("Asignatura:");
		lblAsignatura.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAsignatura.setBounds(21, 23, 96, 17);
		add(lblAsignatura);

		txtBuscar = new JTextField();
		txtBuscar.setBounds(119, 24, 223, 19);
		add(txtBuscar);
		txtBuscar.setColumns(10);

		btnEnviarDlg = new JButton("Enviar Dialogo");
		btnEnviarDlg.setBounds(415, 23, 130, 21);
		btnEnviarDlg.addActionListener(this);
		add(btnEnviarDlg);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 61, 551, 171);
		add(scrollPane);

		tableBuscar = new JTable();
		modeloBuscar = new DefaultTableModel();
		modeloBuscar.addColumn("Código");
		modeloBuscar.addColumn("Asignatura");
		modeloBuscar.addColumn("Ciclo");
		modeloBuscar.addColumn("Créditos");
		modeloBuscar.addColumn("Horas");
		tableBuscar.setModel(modeloBuscar);
		scrollPane.setViewportView(tableBuscar);

		listarCursos(""); // Mostrar todos los cursos

		// Filtrado en tiempo real
		txtBuscar.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				listarCursos(txtBuscar.getText());
			}
			public void removeUpdate(DocumentEvent e) {
				listarCursos(txtBuscar.getText());
			}
			public void changedUpdate(DocumentEvent e) {
				listarCursos(txtBuscar.getText());
			}
		});
	}
	//Declaracion Global
	ArreglosCursos ac = new ArreglosCursos();

	private void listarCursos(String filtro) {
		modeloBuscar.setRowCount(0); // Limpiar tabla

		for (int i = 0; i < ac.tamanio(); i++) {
			Curso c = ac.obtener(i);
			if (filtro.isEmpty() || c.getAsignatura().toLowerCase().contains(filtro.toLowerCase())) {
				modeloBuscar.addRow(new Object[] {
					c.getCodCurso(),
					c.getAsignatura(),
					c.getCiclo(),
					c.getCreditos(),
					c.getHoras()
				});
			}
		}
	}   

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEnviarDlg) {
			int fila = tableBuscar.getSelectedRow();
			if (fila == -1) {
				JOptionPane.showMessageDialog(this, "Selecciona una fila", "Advertencia", JOptionPane.WARNING_MESSAGE);
				return;
			} 

			int cod = Integer.parseInt(tableBuscar.getValueAt(fila, 0).toString());
			String asig = tableBuscar.getValueAt(fila, 1).toString();
			int ciclo = Integer.parseInt(tableBuscar.getValueAt(fila, 2).toString());
			int cred = Integer.parseInt(tableBuscar.getValueAt(fila, 3).toString());
			int horas = Integer.parseInt(tableBuscar.getValueAt(fila, 4).toString());

			Curso c = new Curso(cod, asig, ciclo, cred, horas);
			dlgRMatricula.leerBusqueda(c); // Envía al formulario
			dispose(); // Cierra este diálogo
		}
	}
}
