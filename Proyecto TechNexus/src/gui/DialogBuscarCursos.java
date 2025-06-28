package gui;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;

import arreglos.ArreglosCursos;
import clases.Curso;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogBuscarCursos extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblAsignatura;
	private JTextField txtBuscar;
	private JScrollPane scrollPane;
	private JTable tableBuscar;
	private DefaultTableModel modeloBuscar;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogBuscarCursos dialog = new DialogBuscarCursos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogBuscarCursos() {
		setBounds(100, 100, 607, 291);
		getContentPane().setLayout(null);
		
		lblAsignatura = new JLabel("Asignatura: ");
		lblAsignatura.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAsignatura.setBounds(21, 23, 96, 17);
		getContentPane().add(lblAsignatura);
		
		txtBuscar = new JTextField();
		txtBuscar.addActionListener(this);
		txtBuscar.setColumns(10);
		txtBuscar.setBounds(119, 24, 223, 19);
		getContentPane().add(txtBuscar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 61, 551, 171);
		getContentPane().add(scrollPane);
		
		tableBuscar = new JTable();
		modeloBuscar=new DefaultTableModel();
		modeloBuscar.addColumn("Código");
		modeloBuscar.addColumn("Asignatura");
		modeloBuscar.addColumn("Ciclo");
		modeloBuscar.addColumn("Créditos");	
		modeloBuscar.addColumn("Horas");
		tableBuscar.setModel(modeloBuscar);
		
		scrollPane.setViewportView(tableBuscar);
		
		btnEnviarDlg = new JButton("Enviar Dialogo");
		btnEnviarDlg.addActionListener(this);
		btnEnviarDlg.setBounds(415, 23, 130, 21);
		getContentPane().add(btnEnviarDlg);
		
		// Mostrar todos los cursos al abrir
		listarCursos("");

		// Listener que detecta cuando escribes y filtra en tiempo real
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
	ArreglosCursos ac = new ArreglosCursos();
	private JButton btnEnviarDlg;
	
	// Método para llenar o filtrar la tabla
	private void listarCursos(String filtro) {
		modeloBuscar.setRowCount(0); // Limpiar la tabla

		for (int i = 0; i < ac.tamanio(); i++) {
			Curso c = ac.obtener(i);
			if (filtro.isEmpty() || c.getAsignatura().toLowerCase().contains(filtro.toLowerCase())) {
				Object[] fila = {
					c.getCodCurso(),
					c.getAsignatura(),
					c.getCiclo(),
					c.getCreditos(),
					c.getHoras()
				};
				modeloBuscar.addRow(fila);
			}
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEnviarDlg) {
			actionPerformedBtnEnviarDlg(e);
		}
	}
	protected void actionPerformedBtnEnviarDlg(ActionEvent e) {
		int fila = tableBuscar.getSelectedRow();
		if (fila == -1) {
			JOptionPane.showMessageDialog(null, "Selecciona una fila", "Advertencia", JOptionPane.WARNING_MESSAGE);
			return;
		}
		// Obtener curso desde fila
		int cod = Integer.parseInt(tableBuscar.getValueAt(fila, 0).toString());
		String asig = tableBuscar.getValueAt(fila, 1).toString();
		int ciclo = Integer.parseInt(tableBuscar.getValueAt(fila, 2).toString());
		int cred = Integer.parseInt(tableBuscar.getValueAt(fila, 3).toString());
		int horas = Integer.parseInt(tableBuscar.getValueAt(fila, 4).toString());

		Curso c = new Curso(cod, asig, ciclo, cred, horas);
		//DialogRegistroMatricula.llenarCamposDesdeBusqueda(c); // Llenar campos en el otro frame
		dispose(); // Cierra el diálogo
	}
}
