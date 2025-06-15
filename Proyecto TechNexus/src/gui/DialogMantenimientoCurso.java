	package gui;
	
	import java.awt.EventQueue;
	
	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;
	import javax.swing.JLabel;
	import java.awt.Font;
	import java.awt.Color;
	
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
	import java.util.ArrayList;
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
		private JTextField txtBusquedaFiltrada;
		private JButton btnBuscar;
		private JSeparator separator;
		private JSeparator separator_1;
		private JSeparator separator_2;
		private JSeparator separator_3;
		private JRadioButton rbtnCodigo;
		private JRadioButton rbtnAsignatura;
		private JButton btnGuardar;
		
		private static ArrayList<Curso> cursoLista = new ArrayList<>();
		
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						DialogMantenimientoCurso frame = new DialogMantenimientoCurso();
						frame.setVisible(true);
						frame.setLocationRelativeTo(null);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
	        // Establece los textos de los botones en español
	        UIManager.put("OptionPane.yesButtonText", "Sí");
	        UIManager.put("OptionPane.noButtonText", "No");
		}
		
	
	
		public DialogMantenimientoCurso() {
			
			setTitle("Mantenimiento de curso");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 637, 450);
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
			//Agregar tabla
			table = new JTable();
			scrollPane.setViewportView(table);
			//Agregar datos a la tabla
			DefaultTableModel model = new DefaultTableModel();
			// Se agrega Columnas
			model.addColumn("Código");
			model.addColumn("Asignatura");
			model.addColumn("Ciclo");
			model.addColumn("Créditos");
			model.addColumn("Horas");
			table.setModel(model); //Muestra las columnas en la tabla
			ingresarCursos();//Metodo que carga la lista ingresada
			cargarDatosCursos();//Llena la tabla con los datos obtenidos de la	 lista
	
			btnRegistrar = new JButton("REGISTRAR");
			btnRegistrar.addActionListener(this);
			btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnRegistrar.setBounds(39, 368, 107, 21);
			contentPane.add(btnRegistrar);
			
			btnModificar = new JButton("MODIFICAR");
			btnModificar.addActionListener(this);
			btnModificar.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnModificar.setBounds(185, 368, 107, 21);
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
			
			txtBusquedaFiltrada = new JTextField();
			txtBusquedaFiltrada.setColumns(10);
			txtBusquedaFiltrada.setBounds(278, 142, 216, 19);
			contentPane.add(txtBusquedaFiltrada);
			
			btnBuscar = new JButton("BUSCAR");
			btnBuscar.addActionListener(this);
			btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnBuscar.setBounds(505, 141, 85, 21);
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
			separator_2.setBounds(23, 171, 583, 33);
			contentPane.add(separator_2);
			
			separator_3 = new JSeparator(SwingConstants.VERTICAL);
			separator_3.setForeground(Color.GRAY);
			separator_3.setBounds(605, 111, 20, 64);
			contentPane.add(separator_3);
			
			rbtnCodigo  = new JRadioButton("Código");
			rbtnCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
			rbtnCodigo.setBounds(52, 140, 85, 21);
			rbtnCodigo.setSelected(true);
			contentPane.add(rbtnCodigo);
			
			
			rbtnAsignatura = new JRadioButton("Asignatura");
			rbtnAsignatura.setFont(new Font("Tahoma", Font.PLAIN, 12));
			rbtnAsignatura.setBounds(144, 141, 103, 21);
			contentPane.add(rbtnAsignatura);
			
			//Agrupo botones
			ButtonGroup grupoBusqueda = new ButtonGroup();
			grupoBusqueda.add(rbtnCodigo);
			grupoBusqueda.add(rbtnAsignatura);
			
			btnGuardar = new JButton("GUARDAR");
			btnGuardar.addActionListener(this);
			btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnGuardar.setBounds(331, 368, 107, 21);
			contentPane.add(btnGuardar);
		}
		
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnGuardar) {
				doBtnGuardarActionPerformed(e);
			}
			if (e.getSource() == btnBuscar) {
				doBtnBuscarActionPerformed(e);
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
			leerDatosRegistrar();
		}
		
		protected void doBtnModificarActionPerformed(ActionEvent e) {
			leerDatosModificar();
		}
		
		protected void doBtnEliminarActionPerformed(ActionEvent e) {
			leerDatosEliminar();
		}
		
		protected void doBtnBuscarActionPerformed(ActionEvent e) {
			leerDatosBuscar();
		}
		
		protected void doBtnGuardarActionPerformed(ActionEvent e) {
			leerDatosGuardar();
		}
		
		public static void ingresarCursos() {
			Curso c1 = new Curso(3001, "Java", 3, 13, 5);
			cursoLista.add(c1);
			
			Curso c2 = new Curso(3002, "MySQL", 1, 21, 8);
			cursoLista.add(c2);
			
			Curso c3 = new Curso(3003, "Python", 0, 16, 4);
			cursoLista.add(c3);
			
			Curso c4 = new Curso(3004, "PHP", 5, 25, 9);
			cursoLista.add(c4);
			
			Curso c5 = new Curso(3005, "JavaScript", 2, 40, 12);
			cursoLista.add(c5);
			
			Curso c6 = new Curso(3006, "C++", 4, 36, 7);
			cursoLista.add(c6);
			
			Curso c7 = new Curso(3007, "React.js", 1, 42, 16);
			cursoLista.add(c7);
			
			Curso c8 = new Curso(3008, "HTML", 5, 28, 14);
			cursoLista.add(c8);
		}
		
		private void cargarDatosCursos() {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			 	for(Curso c : cursoLista) {
			 		model.addRow(new Object[] {
			 				c.getCodCurso(),
			 				c.getAsignatura(),
			 				c.getCiclo(),
			 				c.getCreditos(),
			 				c.getHoras()
			 		});
			 	}
		}
		
		private void leerDatosRegistrar() {
			try {
				// Leer datos de los campos
				int codCurso = Integer.parseInt(txtCodigo.getText());
				//Validación de codigo para que sean 4 digitos
				if(String.valueOf(codCurso).length() !=4) {
	                JOptionPane.showMessageDialog(this, "El código del curso debe tener exactamente 4 dígitos.");
	                return;
	            }
				String asignatura = txtAsignatura.getText();
				int ciclo = Integer.parseInt((String) cmbCiclo.getSelectedItem());
				int creditos = Integer.parseInt(txtCreditos.getText());
				int horas = Integer.parseInt(txtHoras.getText());
				//Crear objeto
				Curso c = new Curso(codCurso, asignatura,ciclo, creditos, horas);
				// Agregar la tabla los datos
		        DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {
						c.getCodCurso(),
						c.getAsignatura(),
						c.getCiclo(),
						c.getCreditos(),
						c.getHoras(),
				});
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Por favor, ingrese valores correctos en los campos indicados.");
			}
			//Limpiar campos
			txtCodigo.setText("");
			txtCodigo.setEditable(true);
			txtAsignatura.setText("");
			cmbCiclo.setSelectedIndex(0);
			txtCreditos.setText("");
			txtHoras.setText("");
		}
		 private void leerDatosModificar()	{
			//Parametros
				int fila, respuesta;
				//Llama a la fila
				fila=table.getSelectedRow();
				if(fila==-1) { //Cuando no se selecciona ninguna fila
					JOptionPane.showMessageDialog(null, "Debes selecionar primero una fila.","Advertencia",JOptionPane.WARNING_MESSAGE);
				}else {//Selecciona la fila al dar boton modificar
					respuesta=JOptionPane.showConfirmDialog(null, "Desea modificar este registro?","Modificar",JOptionPane.YES_NO_OPTION);
					//Cuando acepta modificar 
					if(respuesta==JOptionPane.YES_NO_OPTION) {
						txtCodigo.setText(String.valueOf(table.getValueAt(fila, 0)));
						txtCodigo.setEditable(false);
						txtAsignatura.setText(String.valueOf(table.getValueAt(fila, 1)));
						cmbCiclo.setSelectedItem(String.valueOf(table.getValueAt(fila, 2)));
						txtCreditos.setText(String.valueOf(table.getValueAt(fila, 3)));
						txtHoras.setText(String.valueOf(table.getValueAt(fila, 4)));
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.removeRow(fila);
					}
				}
		 }
		 
		 private void leerDatosGuardar() {
			leerDatosRegistrar();
			JOptionPane.showMessageDialog(null, "Se modifico correctamente el registro");
		 }
		 
		 private void leerDatosEliminar() {
				//Parametros
				int fila, respuesta;
				//Se llama a la fila
				fila=table.getSelectedRow();
				//Cuando no se selecciona ninguna fila
				if(fila==-1) {
					JOptionPane.showMessageDialog(null, "Selecciona primero un registro","Advertencia",JOptionPane.WARNING_MESSAGE);
					
				}else {//Dar clic en boton eliminar
					respuesta=JOptionPane.showConfirmDialog(null, "Desea eliminar este registro?","Eliminar",JOptionPane.YES_NO_OPTION);
					if(respuesta==JOptionPane.YES_NO_OPTION) {
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.removeRow(fila);
					}
				}
		 }
		 
		 private void leerDatosBuscar() {
			 String criterio = txtBusquedaFiltrada.getText().trim();
			 DefaultTableModel model = (DefaultTableModel) table.getModel();
			 
				// Si el campo de búsqueda está vacío, restaurar la tabla desde cursoLista
				if (criterio.isEmpty()) {
					model.setRowCount(0); // Limpiar filas existentes
					cargarDatosCursos();// Rellenar la tabla con todos los cursos
					return;
					}
		
				//Se crea un nuevo modelo temporal para resultados
				DefaultTableModel modeloFiltrado = new DefaultTableModel();
				//Recorre las columnas
				for(int i=0; i<model.getColumnCount(); i++) {
					modeloFiltrado.addColumn(model.getColumnName(i));
				}
				
				// Busca por código o asignatura recorriendo las filas
				for(int i=0; i<model.getRowCount(); i++) {
					String buscarValor= "";
					// Si se seleccionó búsqueda por código
					if(rbtnCodigo.isSelected()) {
						buscarValor=model.getValueAt(i, 0).toString();//columna 0: codigo
					}
					// Si se seleccionó búsqueda por asignatura
					else if (rbtnAsignatura.isSelected()){
						buscarValor=model.getValueAt(i, 1).toString();//columna 1: asignatura
					}
					
					if (buscarValor.contains(criterio.toLowerCase())) {
						//copiar toda la fila
						Object[]fila = new Object[model.getColumnCount()]; 
						for(int j=0; j<model.getColumnCount(); j++) {
							fila[j] = model.getValueAt(i, j);
						}
						modeloFiltrado.addRow(fila);
					}
				}
				 table.setModel(modeloFiltrado);
		 }
	}
