	package gui;
	
	import java.awt.EventQueue;
	
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

	import arreglos.ArreglosCursos;
	import clases.Curso;
	
	import javax.swing.DefaultComboBoxModel;
	import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent;
	import javax.swing.JRadioButton;
	import javax.swing.JSeparator;
	import javax.swing.*;
	
	
	public class DialogMantenimientoCursos extends JDialog implements ActionListener {
	
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
		private DefaultTableModel modelo;
		
		
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						DialogMantenimientoCursos dialog = new DialogMantenimientoCursos();
						dialog.setVisible(true);
						dialog.setLocationRelativeTo(null);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
	        // Establece los textos de los botones en español
	        UIManager.put("OptionPane.yesButtonText", "Sí");
	        UIManager.put("OptionPane.noButtonText", "No");
		}	
		
	
	
		public DialogMantenimientoCursos() {
			setTitle("Mantenimiento de curso");
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 637, 450);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			lblMantenimientoCurso = new JLabel("MANTENIMIENTO CURSO");
			lblMantenimientoCurso.setHorizontalAlignment(SwingConstants.CENTER);
			lblMantenimientoCurso.setForeground(new Color(255, 255, 255));
			lblMantenimientoCurso.setFont(new Font("Tahoma", Font.BOLD, 17));
			lblMantenimientoCurso.setOpaque(true); 
			lblMantenimientoCurso.setBackground(new Color(0, 0, 0));
			lblMantenimientoCurso.setOpaque(true);
			lblMantenimientoCurso.setBounds(0, 0, 627, 26);
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
			modelo = new DefaultTableModel();
			// Se agrega Columnas
			modelo.addColumn("Código");
			modelo.addColumn("Asignatura");
			modelo.addColumn("Ciclo");
			modelo.addColumn("Créditos");	
			modelo.addColumn("Horas");
			table.setModel(modelo); 
	
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
			
			listar();
		}
		
		//Declaración global
		ArreglosCursos ac = new ArreglosCursos(); 
		
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
		
		void leerDatosRegistrar() {
			try {
				int codCurso = Integer.parseInt(txtCodigo.getText().trim());
				if(String.valueOf(codCurso).length() !=4) {  //Validación de codigo para que sean 4 digitos
	                mensaje("El código del curso debe tener exactamente 4 dígitos.","Error",JOptionPane.ERROR_MESSAGE);
	                return;
	            }
		        // Validar si ya existe el curso
		        if (ac.buscarCodigo(codCurso) != null) {
		            mensaje("Ya existe un curso con ese código.", "Advertencia", JOptionPane.WARNING_MESSAGE);
		            return;
		        }
		        
				String asignatura = leerAsignatura();
				int ciclo = leerCiclo();
				int creditos = leerCreditos();
				int horas = leerHoras();
				//Crear objeto
				ac.adicionar(new Curso(codCurso, asignatura, ciclo, creditos, horas));
				listar();
				limpiar();
			} catch (Exception e2) {
				mensaje("Por favor, ingrese valores correctos en los campos indicados.","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		
		void leerDatosModificar()	{
			try {
				//Parametros
				int fila, respuesta;
				fila=table.getSelectedRow();//Llama a la fila
				if(fila==-1) { //Cuando no se selecciona ninguna fila
					mensaje("Debes selecionar primero una fila.","Advertencia",JOptionPane.WARNING_MESSAGE);
				}else {//Selecciona la fila al dar boton modificar
					respuesta=JOptionPane.showConfirmDialog(null, "¿Desea modificar este registro?","Modificar",JOptionPane.YES_NO_OPTION);
					if(respuesta==JOptionPane.YES_NO_OPTION) {//Cuando acepta modificar 
						txtCodigo.setText(String.valueOf(table.getValueAt(fila, 0)));
						txtCodigo.setEditable(false);
						txtAsignatura.setText(String.valueOf(table.getValueAt(fila, 1)));
						cmbCiclo.setSelectedItem(String.valueOf(table.getValueAt(fila, 2)));
						txtCreditos.setText(String.valueOf(table.getValueAt(fila, 3)));
						txtHoras.setText(String.valueOf(table.getValueAt(fila, 4)));
						modelo = (DefaultTableModel) table.getModel();
						modelo.removeRow(fila);
					}
				}
			ac.actualizarArchivo();
			} catch (Exception e) {
				mensaje("Ocurrió un error al intentar modificar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		 }
		 
		 
		 void leerDatosGuardar() {
			 try {
				 int codigo  = Integer.parseInt(txtCodigo.getText().trim());
				 String asignatura  = txtAsignatura.getText();
				 int ciclo  = Integer.parseInt(cmbCiclo.getSelectedItem().toString());
				 int creditos  = Integer.parseInt(txtCreditos.getText().trim());
				 int horas  = Integer.parseInt(txtHoras.getText().trim());
				 
				 Curso c = ac.buscarCodigo(codigo );
				 if( c != null) {
					 c.setAsignatura(asignatura);
					 c.setCiclo(ciclo);
					 c.setCreditos(creditos );
					 c.setHoras(horas);
					 
					 ac.actualizarArchivo();
					 listar();
					 limpiar();
					 mensaje("Se modificó correctamente el registro", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
				 }else {
					 mensaje("No se encontró el curso con ese código", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} catch (Exception e) {
				mensaje("Error al modificar los datos. Verifica los campos.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		 }
		 
		 void leerDatosEliminar() {
			 try {
				 int fila,respuesta;

				 fila = table.getSelectedRow();
				 if(fila==-1) {
					 mensaje("Selecciona primero un registro","Advertencia",JOptionPane.WARNING_MESSAGE);
					 return;
				 }
				
				int codigo=Integer.parseInt(table.getValueAt(fila, 0).toString());
				Curso x = ac.buscarCodigo(codigo);
				if(x==null) {
					 mensaje("Curso no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
				}else {
					respuesta = JOptionPane.showConfirmDialog(null, "¿Deseas eliminar este curso?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
					if(respuesta == JOptionPane.YES_NO_OPTION) {
						ac.elimnar(x);
		                listar();
		                mensaje("Curso eliminado correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				limpiar();
			} catch (Exception e) {
				mensaje("Error al intentar eliminar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		 }
		 
		 void leerDatosBuscar() {
			 String criterio = txtBusquedaFiltrada.getText().trim();
			 modelo = (DefaultTableModel) table.getModel();
			 
				// Si el campo de búsqueda está vacío, restaurar la tabla desde cursoLista
				if (criterio.isEmpty()) {
					modelo.setRowCount(0); // Limpiar filas existentes
					listar();;// Rellenar la tabla con todos los cursos
					return;
					}
		
				DefaultTableModel modeloFiltrado = new DefaultTableModel(); //Se crea un nuevo modelo temporal para resultados
				//Recorre las columnas
				for(int i=0; i<modelo.getColumnCount(); i++) {
					modeloFiltrado.addColumn(modelo.getColumnName(i));
				}
				for(int i=0; i<modelo.getRowCount(); i++) { // Busca por código o asignatura recorriendo las filas
					String buscarValor= "";
					if(rbtnCodigo.isSelected()) { // Si se seleccionó búsqueda por código
						buscarValor=modelo.getValueAt(i, 0).toString();//columna 0: codigo
					}
					else if (rbtnAsignatura.isSelected()){ // Si se seleccionó búsqueda por asignatura
						buscarValor=modelo.getValueAt(i, 1).toString();//columna 1: asignatura
					}
					
					if (buscarValor.toLowerCase().contains(criterio.toLowerCase())) { //Si la busqueda se hace palabras en minusculas
						Object[]fila = new Object[modelo.getColumnCount()]; //copiar toda la fila
						for(int j=0; j<modelo.getColumnCount(); j++) {
							fila[j] = modelo.getValueAt(i, j);
						}
						modeloFiltrado.addRow(fila);
					}
				}
				 table.setModel(modeloFiltrado);
		 }
		 
		
		//Métodos tipo void (sin parámetros)
		void listar() {
			modelo.setRowCount(0);;
			for (int i = 0; i < ac.tamanio(); i++) {
				Object	[] fila = {
						ac.obtener(i).getCodCurso(),
						ac.obtener(i).getAsignatura(),
						ac.obtener(i).getCiclo(),
						ac.obtener(i).getCreditos(),
						ac.obtener(i).getHoras()};
				modelo.addRow(fila);
			}
		}
		
		void limpiar() {
			txtCodigo.setText("");
			txtCodigo.setEditable(true);
			txtAsignatura.setText("");
			cmbCiclo.setSelectedIndex(0);
			txtCreditos.setText("");
			txtHoras.setText("");
			txtCodigo.requestFocus();
		 }
		
		//  Métodos tipo void (con parametros)
		void mensaje(String s, String titulo, int tipo) {
			JOptionPane.showMessageDialog(null, s, titulo, tipo);
		}
		
		//  Metodos que retornan valor (sin parametros)
		int leerCodigo() {
			return Integer.parseInt(txtCodigo.getText().trim());
		}
		
		String leerAsignatura() {
			return txtAsignatura.getText().trim();
		}
		
		int leerCiclo() {
			return cmbCiclo.getSelectedIndex();
		}
		
		int leerCreditos() {
			return Integer.parseInt(txtCreditos.getText().trim());
		}
		
		int leerHoras() {
			return	Integer.parseInt(txtHoras.getText().trim());
		}
	}
