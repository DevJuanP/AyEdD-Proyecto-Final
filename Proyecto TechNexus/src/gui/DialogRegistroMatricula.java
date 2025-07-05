	package gui;
	
	import java.awt.EventQueue;
	
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;
	import javax.swing.border.LineBorder;
	import javax.swing.border.TitledBorder;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	
	import java.awt.Font;
	import javax.swing.SwingConstants;
	import javax.swing.UIManager;
	import javax.swing.JTextField;
	import java.awt.Color;
	import javax.swing.JButton;
	import javax.swing.JDialog;
	import javax.swing.JScrollPane;
	import javax.swing.JTable;
	import javax.swing.table.DefaultTableModel;

import arreglos.ArreglosAlumno;
import arreglos.ArreglosCursos;
import arreglos.ArreglosMatricula;
	import clases.Alumno;
	import clases.Curso;
	import clases.Matricula;
	
	import java.awt.event.ActionListener;
	import java.time.LocalDate;
	import java.time.LocalTime;
	import java.time.format.DateTimeFormatter;
	import java.awt.event.ActionEvent;
	
	public class DialogRegistroMatricula extends JDialog implements ActionListener {
	
		private static final long serialVersionUID = 1L;
		
		private JPanel contentPane;
		private JLabel TXThora;
		private JLabel lblNewLabel_1;
		private JTextField TXTfecha;
		private JLabel lblNewLabel_2;
		private JTextField txtHora;
		private JLabel lblNewLabel_3;
		private JTextField TXTcodigoMatricula;
		private JLabel lblNewLabel_5;
		private JTextField TXTcodigoAlum;
		private JButton btnConsultarAlumn;
		private JLabel lblNewLabel_6;
		private JTextField TXTedad;
		private JLabel lblNewLabel;
		private JTextField TXTcelular;
		private JLabel lblNewLabel_7;
		private JTextField TXTestado;
		private JLabel lblNewLabel_8;
		private JTextField TXTnombres;
		private JLabel lblNewLabel_9;
		private JTextField TXTapellidos;
		private JLabel lblNewLabel_10;
		private JTextField TXTdni;
		private JLabel lblNewLabel_12;
		private JTextField TXTcodigoCurso;
		private JButton btnConsultarCurso;
		private JLabel lblNewLabel_13;
		private JTextField txtCiclo;
		private JLabel lblNewLabel_14;
		private JTextField TXTcreditos;
		private JLabel lblNewLabel_15;
		private JTextField TXTHora;
		private JLabel lblNewLabel_16;
		private JTextField txtAsignatura;
		private JScrollPane scrollPane;
		private JTable TablaMatricula;
		private JButton btnAdicionar;
		private JButton btnModificar;
		private JButton btnEliminar;
		private DefaultTableModel modeloMatricula;
		private JPanel panelConsulta;
		private JPanel panelConsulta_1;
	
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						DialogRegistroMatricula dialog = new DialogRegistroMatricula();
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
	
		public DialogRegistroMatricula() {
			setTitle("Registro de Matricula");
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 746, 517);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			TXThora = new JLabel("REGISTRO MATRICULA");
			TXThora.setForeground(Color.WHITE);
			TXThora.setBackground(new Color(0, 0, 0));
			TXThora.setOpaque(true);
			TXThora.setHorizontalAlignment(SwingConstants.CENTER);
			TXThora.setFont(new Font("Tahoma", Font.BOLD, 17));
			TXThora.setBounds(0, 0, 732, 33);
			contentPane.add(TXThora);
			
			lblNewLabel_1 = new JLabel("Fecha:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_1.setBounds(20, 43, 70, 18);
			contentPane.add(lblNewLabel_1);
			
			TXTfecha = new JTextField();
			TXTfecha.setEditable(false);
			TXTfecha.setBounds(85, 45, 69, 19);
			contentPane.add(TXTfecha);
			TXTfecha.setColumns(10);
			
			lblNewLabel_2 = new JLabel("Hora:");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_2.setBounds(168, 43, 47, 18);
			contentPane.add(lblNewLabel_2);
			
			txtHora = new JTextField();
			txtHora.setEditable(false);
			txtHora.setBounds(225, 45, 69, 19);
			contentPane.add(txtHora);
			txtHora.setColumns(10);
			
			lblNewLabel_3 = new JLabel("Código Matricula:");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_3.setBounds(470, 45, 136, 13);
			contentPane.add(lblNewLabel_3);
			
			TXTcodigoMatricula = new JTextField();
			TXTcodigoMatricula.setEditable(false);
			TXTcodigoMatricula.setBounds(616, 44, 96, 19);
			contentPane.add(TXTcodigoMatricula);
			TXTcodigoMatricula.setColumns(10);
			
			scrollPane = new JScrollPane();
			scrollPane.setBounds(20, 310, 692, 129);
			contentPane.add(scrollPane);
			
			TablaMatricula = new JTable();
			modeloMatricula=new DefaultTableModel();
			modeloMatricula.addColumn("Número de Matricula");
			modeloMatricula.addColumn("Código Alumno");
			modeloMatricula.addColumn("Código Curso");
			modeloMatricula.addColumn("Nombres");
			modeloMatricula.addColumn("Apellidos");
			modeloMatricula.addColumn("Asignatura");
			modeloMatricula.addColumn("Fecha");
			modeloMatricula.addColumn("Hora");
			modeloMatricula.addColumn("Estado");
			
			TablaMatricula.setModel(modeloMatricula);
			scrollPane.setViewportView(TablaMatricula);
			listar();
			
			panelConsulta = new JPanel();
			panelConsulta.setLayout(null); 
			panelConsulta.setBorder(new TitledBorder(new LineBorder(Color.GRAY), "DATOS DEL ALUMNO"));
			panelConsulta.setBounds(20, 74, 689, 123); 
			getContentPane().add(panelConsulta);
			
			
			panelConsulta_1 = new JPanel();
			panelConsulta_1.setLayout(null); 
			panelConsulta_1.setBorder(new TitledBorder(new LineBorder(Color.GRAY), "DATOS DEL CURSO"));
			panelConsulta_1.setBounds(20, 207, 689, 93); 
			getContentPane().add(panelConsulta_1);
			
			lblNewLabel_12 = new JLabel("Código:");
			lblNewLabel_12.setBounds(21, 21, 79, 18);
			panelConsulta_1.add(lblNewLabel_12);
			lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			TXTcodigoCurso = new JTextField();
			TXTcodigoCurso.setBounds(119, 23, 109, 19);
			panelConsulta_1.add(TXTcodigoCurso);
			TXTcodigoCurso.setColumns(10);
			
			btnConsultarCurso = new JButton("BUSCAR");
			btnConsultarCurso.setBounds(316, 20, 96, 25);
			panelConsulta_1.add(btnConsultarCurso);
			btnConsultarCurso.setFont(new Font("Tahoma", Font.BOLD, 13));
			
			lblNewLabel_13 = new JLabel("Ciclo:");
			lblNewLabel_13.setBounds(451, 24, 45, 13);
			panelConsulta_1.add(lblNewLabel_13);
			lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			txtCiclo = new JTextField();
			txtCiclo.setBounds(505, 23, 38, 19);
			panelConsulta_1.add(txtCiclo);
			txtCiclo.setColumns(10);
			
			lblNewLabel_14 = new JLabel("Créditos:");
			lblNewLabel_14.setBounds(452, 59, 69, 13);
			panelConsulta_1.add(lblNewLabel_14);
			lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			TXTcreditos = new JTextField();
			TXTcreditos.setBounds(531, 58, 137, 19);
			panelConsulta_1.add(TXTcreditos);
			TXTcreditos.setColumns(10);
			
			lblNewLabel_15 = new JLabel("Horas:");
			lblNewLabel_15.setBounds(560, 24, 65, 13);
			panelConsulta_1.add(lblNewLabel_15);
			lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			TXTHora = new JTextField();
			TXTHora.setBounds(626, 23, 42, 19);
			panelConsulta_1.add(TXTHora);
			TXTHora.setColumns(10);
			
			lblNewLabel_16 = new JLabel("Asignatura:");
			lblNewLabel_16.setBounds(21, 48, 88, 18);
			panelConsulta_1.add(lblNewLabel_16);
			lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			txtAsignatura = new JTextField();
			txtAsignatura.setBounds(119, 55, 293, 19);
			panelConsulta_1.add(txtAsignatura);
			txtAsignatura.setColumns(10);
			btnConsultarCurso.addActionListener(this);
			
			lblNewLabel_5 = new JLabel("Código:");
			lblNewLabel_5.setBounds(21, 22, 61, 21);
			panelConsulta.add(lblNewLabel_5);
			lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			TXTcodigoAlum = new JTextField();
			TXTcodigoAlum.setBounds(119, 24, 109, 19);
			panelConsulta.add(TXTcodigoAlum);
			TXTcodigoAlum.setColumns(10);
			
			btnConsultarAlumn = new JButton("BUSCAR");
			btnConsultarAlumn.setBounds(316, 22, 96, 22);
			panelConsulta.add(btnConsultarAlumn);
			btnConsultarAlumn.setFont(new Font("Tahoma", Font.BOLD, 13));
			
			lblNewLabel_6 = new JLabel("Edad:");
			lblNewLabel_6.setBounds(452, 22, 61, 16);
			panelConsulta.add(lblNewLabel_6);
			lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			TXTedad = new JTextField();
			TXTedad.setBounds(505, 23, 38, 19);
			panelConsulta.add(TXTedad);
			TXTedad.setColumns(10);
			
			lblNewLabel = new JLabel("Celular:");
			lblNewLabel.setBounds(452, 84, 62, 13);
			panelConsulta.add(lblNewLabel);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			TXTcelular = new JTextField();
			TXTcelular.setBounds(524, 79, 144, 19);
			panelConsulta.add(TXTcelular);
			TXTcelular.setColumns(10);
			
			lblNewLabel_7 = new JLabel("Estado:");
			lblNewLabel_7.setBounds(560, 24, 69, 13);
			panelConsulta.add(lblNewLabel_7);
			lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			TXTestado = new JTextField();
			TXTestado.setBounds(626, 23, 42, 19);
			panelConsulta.add(TXTestado);
			TXTestado.setColumns(10);
			
			lblNewLabel_8 = new JLabel("Nombres:");
			lblNewLabel_8.setBounds(20, 53, 80, 18);
			panelConsulta.add(lblNewLabel_8);
			lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			TXTnombres = new JTextField();
			TXTnombres.setBounds(119, 50, 293, 19);
			panelConsulta.add(TXTnombres);
			TXTnombres.setColumns(10);
			
			lblNewLabel_9 = new JLabel("Apellidos:");
			lblNewLabel_9.setBounds(21, 80, 88, 18);
			panelConsulta.add(lblNewLabel_9);
			lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			TXTapellidos = new JTextField();
			TXTapellidos.setBounds(119, 78, 293, 19);
			panelConsulta.add(TXTapellidos);
			TXTapellidos.setColumns(10);
			
			lblNewLabel_10 = new JLabel("DNI:");
			lblNewLabel_10.setBounds(452, 52, 53, 18);
			panelConsulta.add(lblNewLabel_10);
			lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			TXTdni = new JTextField();
			TXTdni.setBounds(524, 54, 144, 19);
			panelConsulta.add(TXTdni);
			TXTdni.setText("");
			TXTdni.setColumns(10);
			
			btnAdicionar = new JButton("ADICIONAR");
			btnAdicionar.setFont(new Font("Tahoma", Font.BOLD, 10));
			btnAdicionar.addActionListener(this);
			btnAdicionar.setBounds(58, 449, 110, 21);
			contentPane.add(btnAdicionar);
			
			btnModificar = new JButton("MODIFICAR");
			btnModificar.setFont(new Font("Tahoma", Font.BOLD, 10));
			btnModificar.addActionListener(this);
			btnModificar.setBounds(226, 449, 110, 21);
			contentPane.add(btnModificar);
			
			btnEliminar = new JButton("ELIMINAR");
			btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 10));
			btnEliminar.addActionListener(this);
			btnEliminar.setBounds(562, 449, 110, 21);
			contentPane.add(btnEliminar);
			
			btnGuardar = new JButton("GUARDAR");
			btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 10));
			btnGuardar.addActionListener(this);
			btnGuardar.setBounds(394, 449, 110, 21);
			contentPane.add(btnGuardar);
			btnConsultarAlumn.addActionListener(this);
			
			mostrarFechaHoraActual();
			TXTcodigoMatricula.setText("" + am.generateCod()); 

			
		}
		
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnGuardar) {
				actionPerformedBtnGuardar(e);
			}
			if (e.getSource() == btnEliminar) {
				actionPerformedBtnEliminar(e);
			}
			if (e.getSource() == btnModificar) {
				actionPerformedBtnModificar(e);
			}
			if (e.getSource() == btnAdicionar) {
				actionPerformedBtnAdicionar(e);
			}
		
			if (e.getSource() == btnConsultarCurso) {
				actionPerformedBtnConsultarCurso(e);
			}
			if (e.getSource() == btnConsultarAlumn) {
				do_btnConsultarAlumn_actionPerformed(e);
			}
		}
		
		public void leerBusqueda (Curso c) {
			TXTcodigoCurso.setText(String.valueOf(c.getCodCurso()));
	        txtAsignatura.setText(c.getAsignatura());
	        txtCiclo.setText(String.valueOf(c.getCiclo()));
	        TXTcreditos.setText(String.valueOf(c.getCreditos()));
	        TXTHora.setText(String.valueOf(c.getHoras()));
	        }
		
		public void leerBusqueda_2(Alumno a) {
		    TXTcodigoAlum.setText(String.valueOf(a.getCodAlumno()));
		    TXTnombres.setText(a.getNombres());
		    TXTapellidos.setText(a.getApellidos());
		    TXTedad.setText(String.valueOf(a.getEdad()));
		    TXTcelular.setText(String.valueOf(a.getCelular()));
		    TXTdni.setText(a.getDni());
		    TXTestado.setText(String.valueOf(a.getEstado()));
		}
	
		
		protected void do_btnConsultarAlumn_actionPerformed(ActionEvent e) {
			DialogBuscarAlumnos dialogBuscarAlumno = new DialogBuscarAlumnos(this);
			dialogBuscarAlumno.setLocationRelativeTo(dialogBuscarAlumno);
			dialogBuscarAlumno.setModal(true);
			dialogBuscarAlumno.setVisible(true);
		}
		
		protected void actionPerformedBtnConsultarCurso(ActionEvent e) {
			DialogBuscarCursos dialogBuscarCursos = new DialogBuscarCursos(this);
			dialogBuscarCursos.setLocationRelativeTo(dialogBuscarCursos);
			dialogBuscarCursos.setModal(true);
			dialogBuscarCursos.setVisible(true);
		}
		
		//Globalizacion
		ArreglosMatricula am = new ArreglosMatricula();
		ArreglosAlumno aa = new ArreglosAlumno();
		ArreglosCursos ac = new ArreglosCursos();
		private JButton btnGuardar;
		
	
	
		protected void actionPerformedBtnAdicionar(ActionEvent e) {
			try {
				int numMatricula =am.generateCod();
				TXTcodigoMatricula.setText(""+numMatricula);
				int codAlumno = Integer.parseInt(TXTcodigoAlum.getText().trim());
				int codCurso = Integer.parseInt(TXTcodigoCurso.getText().trim());
				
				if(matchAlumnoCurso(codAlumno, codCurso)) {
					JOptionPane.showMessageDialog(this, "Alumno ya matriculado en este curso","Advertencia",JOptionPane.WARNING_MESSAGE);
				}
				
				int estado = 1;
				aa.buscarCodigo(codAlumno).setEstado(estado);
				aa.actualizarArchivo();
				am.adicionarMatricula(new Matricula(numMatricula, codAlumno, codCurso));
				listar();
				limpiar();

				TXTcodigoMatricula.setText("" + am.generateCod());

				mostrarFechaHoraActual();

			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos correctamente.\nDetalles: " + e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				e2.printStackTrace();
			} 
		}
		
		private boolean matchAlumnoCurso(int CodAlu, int CodCurso) {
			for(Matricula m : am.getMatricula001()) {
				if(m.getCodAlumno() == CodAlu && m.getCodCurso() == CodCurso) return true;
			}
			return false;
		}

		
		protected void actionPerformedBtnModificar(ActionEvent e) {
			try {
				int fila, respuesta;
				fila=TablaMatricula.getSelectedRow();//Llama a la fila
				if(fila==-1) { //Cuando no se selecciona ninguna fila
					JOptionPane.showMessageDialog(this, "Debes selecionar primero una fila.","Advertencia",JOptionPane.WARNING_MESSAGE);
				}else {
					respuesta=JOptionPane.showConfirmDialog(this, "¿Desea modificar este registro?","Modificar",JOptionPane.YES_NO_OPTION);
					if(respuesta == JOptionPane.YES_NO_OPTION) {
						//alumno
						int CodMatr = Integer.parseInt(TablaMatricula.getValueAt(fila, 0).toString());
						int CodAlum = Integer.parseInt(TablaMatricula.getValueAt(fila, 1).toString());
						int CodCurs = Integer.parseInt(TablaMatricula.getValueAt(fila, 2).toString());

						Alumno a = aa.buscarCodigo(CodAlum);
						Curso c = ac.buscarCodigo(CodCurs);
						Matricula m = am.buscarMatricula(CodMatr);
						
						
						TXTcodigoMatricula.setText(""+CodMatr);  
						TXTcodigoAlum.setText(""+CodAlum);    
						TXTcodigoCurso.setText(""+CodCurs);    
						TXTnombres.setText(a.getNombres());      
						TXTapellidos.setText(a.getApellidos());    
						txtAsignatura.setText(c.getAsignatura());    
						TXTfecha.setText(m.getFecha());          
						txtHora.setText(m.getHora());           
						TXTestado.setText(""+a.getEstado());
						
						ocultarCajas();
						btnModificar.setEnabled(false);
						btnConsultarAlumn.setEnabled(false);
						
						
						modeloMatricula = (DefaultTableModel) TablaMatricula.getModel();
						modeloMatricula.removeRow(fila);
					}
				}
				am.actualizarArchivo();
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Ocurrió un error al intentar modificar: ", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		protected void actionPerformedBtnEliminar(ActionEvent e) {
		    try {
		        int fila = TablaMatricula.getSelectedRow();
		        if (fila == -1) {
		            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila", "Advertencia", JOptionPane.WARNING_MESSAGE);
		            return;
		        }
		        int numMatricula = Integer.parseInt(TablaMatricula.getValueAt(fila, 0).toString());
		        Matricula m = am.buscarMatricula(numMatricula);
		        if (m == null) {
		            JOptionPane.showMessageDialog(this, "Matrícula no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        int respuesta = JOptionPane.showConfirmDialog(this, "¿Deseas eliminar esta matrícula?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
		        if (respuesta == JOptionPane.YES_OPTION) {
		            am.Eliminar(m);
		            listar();
		            limpiar();
		            JOptionPane.showMessageDialog(this, "Matrícula eliminada correctamente");
		        }
		    } catch (Exception e2) {
		        JOptionPane.showMessageDialog(this, "Error al eliminar la matrícula", "Error", JOptionPane.ERROR_MESSAGE);
		        e2.printStackTrace();
		    }
		}
		
		protected void actionPerformedBtnGuardar(ActionEvent e) {
			try {
		        int numMatricula = Integer.parseInt(TXTcodigoMatricula.getText().trim());
		        Matricula m = am.buscarMatricula(numMatricula);

		        if (m == null) {
		            JOptionPane.showMessageDialog(this, "No hay una matrícula con ese código.", "Advertencia", JOptionPane.WARNING_MESSAGE);
		            return;
		        }

		        // Actualizar campos modificados
		        m.setCodAlumno(Integer.parseInt(TXTcodigoAlum.getText().trim()));
		        m.setCodCurso(Integer.parseInt(TXTcodigoCurso.getText().trim()));
		        m.setNombres(TXTnombres.getText().trim());
		        m.setApellidos(TXTapellidos.getText().trim());
		        m.setAsignatura(txtAsignatura.getText().trim());
		        m.setFecha(TXTfecha.getText().trim());
		        m.setHora(txtHora.getText().trim());

		        String estadoTexto = TXTestado.getText().trim().toLowerCase();
		        int estado = estadoTexto.equals("activo") ? 1 : 0;
		        m.setEstado(estado);

		        am.actualizarArchivo();
		        listar();
		        limpiar();
		        JOptionPane.showMessageDialog(this, "Cambios guardados correctamente.");
		        btnModificar.setEnabled(true);
				btnConsultarAlumn.setEnabled(true);
		    } catch (Exception e1) {
		        JOptionPane.showMessageDialog(this, "Error al guardar los cambios. Verifique los datos.", "Error", JOptionPane.ERROR_MESSAGE);
		        e1.printStackTrace();
		    }
		}
		
		//Metodos sin parametros
		 void listar() {
			 modeloMatricula.setRowCount(0);
			 for (int i = 0; i < am.tamanio(); i++) {
				 int NumMatricula = am.obtener(i).getNumMatricula();
				 int CodAlumno = am.obtener(i).getCodAlumno();
				 int CodCurso = am.obtener(i).getCodCurso();
				 
				 Alumno a = aa.buscarCodigo(CodAlumno);
				 Curso c = ac.buscarCodigo(CodCurso);
				 
				 if(a != null && c != null) {
					 String nombres = a.getNombres();
					 String Apellidos = a.getApellidos();
					 String Asignatura = c.getAsignatura();
					 int Estado = a.getEstado();
					 
					 Object[] fila = {
							 NumMatricula,
							 CodAlumno,
							 CodCurso,
							 nombres,
							 Apellidos,
							 Asignatura,
							 am.obtener(i).getFecha(),
							 am.obtener(i).getHora(),
							 Estado,};
					 modeloMatricula.addRow(fila);
				 } 
			}
		 }
		 void limpiar() {
			 TXTcodigoMatricula.setText("");
			 TXTcodigoAlum.setText("");
			 TXTcodigoCurso.setText("");
			 TXTnombres.setText("");
			 TXTapellidos.setText("");
			 TXTedad.setText("");
			 TXTestado.setText("");
			 TXTdni.setText("");
			 TXTcelular.setText("");
			 txtAsignatura.setText(""); 
		 }
		 
		 private void mostrarFechaHoraActual() {
			    LocalDate fechaActual = LocalDate.now();
			    LocalTime horaActual = LocalTime.now();
	
			    // Puedes ajustar el formato si lo deseas
			    DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			    DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
	
			    TXTfecha.setText(fechaActual.format(formatoFecha));
			    txtHora.setText(horaActual.format(formatoHora));
			}
		 
		 void ocultarCajas() {
			TXTestado.setEditable(false);
			TXTedad.setEditable(false);
			TXTdni.setEditable(false);
			TXTcelular.setEditable(false);
			txtCiclo.setEditable(false);
			TXTcreditos.setEditable(false);
			TXTHora.setEditable(false);
		}
	}
