package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DialogBuscarRetiro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblAsignatura;
	private JTextField txtBuscar;
	private JButton btBuscar_2;
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
					DialogBuscarRetiro frame = new DialogBuscarRetiro();
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
	public DialogBuscarRetiro() {
		setTitle("Buscar Cursos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		btBuscar_2 = new JButton("Buscar");
		btBuscar_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btBuscar_2.setBounds(376, 10, 85, 21);
		contentPane.add(btBuscar_2);
		
		btEnviar = new JButton("Enviar");
		btEnviar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btEnviar.setBounds(488, 10, 85, 21);
		contentPane.add(btEnviar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 49, 551, 171);
		contentPane.add(scrollPane);
		
		table = new JTable();
		modeloBuscar=new DefaultTableModel();
		modeloBuscar.addColumn("Código");
		modeloBuscar.addColumn("Asignatura");
		modeloBuscar.addColumn("Ciclo");
		modeloBuscar.addColumn("Créditos");	
		modeloBuscar.addColumn("Horas");
		table.setModel(modeloBuscar);
		
		table.setModel(modeloBuscar);
		scrollPane.setViewportView(table);

	}
}
