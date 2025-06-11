package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import clases.Curso;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.*;

public class DialogMantenimientoCurso extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblMantenimientoCurso;
	private JLabel lblAsignatura;
	private JLabel lblCiclo;
	private JLabel lblCreditos;
	private JLabel lblHoras;
	private JLabel lblCodigo;
	private JTextField txtAsignatura;
	private JTextField txtCreditos;
	private JTextField txtHoras;
	private JTextField txtCodigo;
	private JComboBox<String> cmbCiclo;
	private JButton btnRegistrar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblConsultar;
	private JTextField txtCodigoCurso;
	private JButton btnBuscar;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JButton btnNuevo;
	private JRadioButton rbtnCodigo;
	private JRadioButton rbtnAsignatura;
	private int filaSeleccionada = -1;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DialogMantenimientoCurso frame = new DialogMantenimientoCurso();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	


	public DialogMantenimientoCurso() {
		
		setTitle("Mantenimiento de curso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblMantenimientoCurso = new JLabel("MANTENIMIENTO CURSO");
		lblMantenimientoCurso.setHorizontalAlignment(SwingConstants.CENTER);
		lblMantenimientoCurso.setForeground(new Color(255, 255, 255));
		lblMantenimientoCurso.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblMantenimientoCurso.setBounds(0, 0, 627, 26);
		lblMantenimientoCurso.setOpaque(true); 
		lblMantenimientoCurso.setBackground(new Color(0, 0, 0));
		
		
		contentPane.add(lblMantenimientoCurso);
		
		lblAsignatura = new JLabel("Asignatura:");
		lblAsignatura.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAsignatura.setBounds(23, 43, 132, 20);
		contentPane.add(lblAsignatura);
		
		lblCiclo = new JLabel("Ciclo:");
		lblCiclo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCiclo.setBounds(23, 73, 46, 20);
		contentPane.add(lblCiclo);
		
		lblCreditos = new JLabel("Cr\u00E9ditos:");
		lblCreditos.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCreditos.setBounds(257, 73, 58, 20);
		contentPane.add(lblCreditos);
		
		lblHoras = new JLabel("Horas:");
		lblHoras.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHoras.setBounds(437, 73, 58, 20);
		contentPane.add(lblHoras);
		
		lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCodigo.setBounds(437, 43, 69, 20);
		contentPane.add(lblCodigo);
		
		txtAsignatura = new JTextField();
		txtAsignatura.setColumns(10);
		txtAsignatura.setBounds(108, 45, 308, 19);
		contentPane.add(txtAsignatura);
		
		txtCreditos = new JTextField();
		txtCreditos.setBounds(325, 75, 96, 19);
		contentPane.add(txtCreditos);
		txtCreditos.setColumns(10);
		
		txtHoras = new JTextField();
		txtHoras.setColumns(10);
		txtHoras.setBounds(505, 75, 101, 19);
		contentPane.add(txtHoras);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(506, 45, 100, 19);
		contentPane.add(txtCodigo);
		
		cmbCiclo = new JComboBox<String>();
		cmbCiclo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbCiclo.setModel(new DefaultComboBoxModel<String>(new String[] {"0", "1", "2", "3", "4", "5"}));
		cmbCiclo.setBounds(108, 73, 139, 20);
		contentPane.add(cmbCiclo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 202, 583, 141);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("C�digo");
		model.addColumn("Asignatura");
		model.addColumn("Ciclo");
		model.addColumn("Cr�ditos");
		model.addColumn("Horas");
		table.setModel(model);

		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegistrar.setBounds(185, 368, 107, 21);
		contentPane.add(btnRegistrar);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(this);
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModificar.setBounds(331, 368, 107, 21);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminar.setBounds(477, 368, 107, 21);
		contentPane.add(btnEliminar);
		
		lblConsultar = new JLabel("CONSULTAR:");
		lblConsultar.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblConsultar.setBounds(53, 114, 102, 20);
		contentPane.add(lblConsultar);
		
		txtCodigoCurso = new JTextField();
		txtCodigoCurso.setColumns(10);
		txtCodigoCurso.setBounds(278, 142, 216, 19);
		contentPane.add(txtCodigoCurso);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(this);
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBuscar.setBounds(506, 141, 85, 21);
		contentPane.add(btnBuscar);
		
		separator = new JSeparator();
		separator.setForeground(Color.GRAY);
		separator.setBounds(23, 111, 583, 33);
		contentPane.add(separator);
		
		separator_1 = new JSeparator(SwingConstants.VERTICAL);
		separator_1.setForeground(Color.GRAY);
		separator_1.setBounds(23, 111, 20, 64);
		contentPane.add(separator_1);
		
		separator_2 = new JSeparator();
		separator_2.setForeground(Color.GRAY);
		separator_2.setBounds(23, 174, 583, 33);
		contentPane.add(separator_2);
		
		separator_3 = new JSeparator(SwingConstants.VERTICAL);
		separator_3.setForeground(Color.GRAY);
		separator_3.setBounds(605, 111, 20, 64);
		contentPane.add(separator_3);
		
		btnNuevo = new JButton("NUEVO");
		btnNuevo.addActionListener(this);
		btnNuevo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNuevo.setBounds(39, 368, 107, 21);
		contentPane.add(btnNuevo);
		
		rbtnCodigo = new JRadioButton("C\u00F3digo");
		rbtnCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rbtnCodigo.setBounds(52, 140, 85, 21);
		contentPane.add(rbtnCodigo);
		
		rbtnAsignatura = new JRadioButton("Asignatura");
		rbtnAsignatura.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rbtnAsignatura.setBounds(144, 141, 103, 21);
		contentPane.add(rbtnAsignatura);
		
		ButtonGroup grupoBusqueda = new ButtonGroup();
		grupoBusqueda.add(rbtnCodigo);
		grupoBusqueda.add(rbtnAsignatura);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscar) {
			doBtnBuscarActionPerformed(e);
		}
		if (e.getSource() == btnNuevo) {
			doBtnNuevoActionPerformed(e);
		}
		if (e.getSource() == btnEliminar) {
			doBtnEliminarActionPerformed(e);
		}
		if (e.getSource() == btnModificar) {
			doBtnModificarActionPerformed(e);
		}
		if (e.getSource() == btnRegistrar) {
			doBtnRegistrarActionPerformed(e);
		}
	}
	protected void doBtnRegistrarActionPerformed(ActionEvent e) {
		try {
			// Leer datos de los campos
			int codCurso = Integer.parseInt(txtCodigo.getText());
			String asignatura = txtAsignatura.getText();
			int ciclo = Integer.parseInt((String) cmbCiclo.getSelectedItem());
			int creditos = Integer.parseInt(txtCreditos.getText());
			int horas = Integer.parseInt(txtHoras.getText());
			//Crear objeto
			Curso c = new Curso(codCurso, ciclo, creditos, horas, asignatura);
			// Agregar la tabla
	        DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.addRow(new Object[] {
					c.getCodCurso(),
					c.getAsignatura(),
					c.getCiclo(),
					c.getCreditos(),
					c.getHoras(),
			});
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "Por favor, ingrese valores num�ricos v�lidos en los campos num�ricos.");
		}
	}
	protected void doBtnModificarActionPerformed(ActionEvent e) {
		if (filaSeleccionada == -1) {
	        JOptionPane.showMessageDialog(this, "Primero debes buscar un curso para modificar.");
	        return;
	    }

	    try {
	        String asignatura = txtAsignatura.getText();
	        int ciclo = Integer.parseInt(cmbCiclo.getSelectedItem().toString());
	        int creditos = Integer.parseInt(txtCreditos.getText());
	        int horas = Integer.parseInt(txtHoras.getText());

	        DefaultTableModel model = (DefaultTableModel) table.getModel();

	        model.setValueAt(asignatura, filaSeleccionada, 1);
	        model.setValueAt(ciclo, filaSeleccionada, 2);
	        model.setValueAt(creditos, filaSeleccionada, 3);
	        model.setValueAt(horas, filaSeleccionada, 4);

	        JOptionPane.showMessageDialog(this, "Curso modificado exitosamente.");

	        // Reset
	        filaSeleccionada = -1;
	        txtCodigo.setEditable(true);
	        doBtnNuevoActionPerformed(e);

	    } catch (Exception ex) {
	        JOptionPane.showMessageDialog(this, "Error al modificar. Verifica los campos.");
	    }
	}
	protected void doBtnEliminarActionPerformed(ActionEvent e) {
	}
	protected void doBtnNuevoActionPerformed(ActionEvent e) {
		txtCodigo.setText("");
		txtAsignatura.setText("");
		cmbCiclo.setSelectedIndex(0);
		txtCreditos.setText("");
		txtHoras.setText("");
	}
	protected void doBtnBuscarActionPerformed(ActionEvent e) {
	    String criterio = txtCodigoCurso.getText().trim();
	    DefaultTableModel model = (DefaultTableModel) table.getModel();
	    filaSeleccionada = -1;

	    for (int i = 0; i < model.getRowCount(); i++) {
	        String valorCelda = "";

	        if (rbtnCodigo.isSelected()) {
	            valorCelda = model.getValueAt(i, 0).toString(); // c�digo
	        } else if (rbtnAsignatura.isSelected()) {
	            valorCelda = model.getValueAt(i, 1).toString(); // asignatura
	        }

	        if (valorCelda.equalsIgnoreCase(criterio)) {
	            filaSeleccionada = i;

	            // Llenar campos de texto con los datos encontrados
	            txtCodigo.setText(model.getValueAt(i, 0).toString());
	            txtAsignatura.setText(model.getValueAt(i, 1).toString());
	            cmbCiclo.setSelectedItem(model.getValueAt(i, 2).toString());
	            txtCreditos.setText(model.getValueAt(i, 3).toString());
	            txtHoras.setText(model.getValueAt(i, 4).toString());

	            // Deshabilitar campo de c�digo para evitar cambios
	            txtCodigo.setEditable(false);
	            return;
	        }
	    }

	    JOptionPane.showMessageDialog(this, "No se encontr� el curso.");
	}
}
