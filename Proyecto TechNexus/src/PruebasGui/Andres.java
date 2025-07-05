package PruebasGui;

import java.awt.Dialog;
import java.awt.EventQueue;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arreglos.ArreglosAlumno;
import clases.Alumno;
import clases.Retiro;

public class Andres extends JFrame {

	private JPanel contentPane;
	
	public static void main(String[] args) {
		Andres frame = new Andres();
		frame.setVisible(true);
	}
	
	private JTextArea txtOut;
	private JTextField txtNumRetiro;
	private Timer timer;
	private JTextField textHoraPrueba;
	
	public Andres() {
	       setTitle("Ventana con Hora en Vivo");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 450, 300);

	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        contentPane.setLayout(null);
	        setContentPane(contentPane);
	       // Retiro reee = new Retiro();
	        
	        timer = new Timer(1000, e -> actualizarHora());
	        timer.start();

	        // Campo num retiro
	        txtNumRetiro = new JTextField();
	        txtNumRetiro.setBounds(33, 11, 68, 25);
	        contentPane.add(txtNumRetiro);
	        txtNumRetiro.setEditable(false);

	        // Botón procesar
	        JButton btnProcesar = new JButton("Procesar");
	        btnProcesar.setBounds(280, 20, 100, 25);
	        contentPane.add(btnProcesar);

	        // Área de salida
	        txtOut = new JTextArea();
	        JScrollPane scr = new JScrollPane(txtOut);
	        scr.setBounds(20, 55, 400, 200);
	        contentPane.add(scr);

	        // Mostrar fecha y hora inicial
	       // textHoraPrueba.setText(reee.getHora());
	     //   txtOut.setText("Fecha: " + reee.getFecha() + "\n");
	       // txtOut.append("Contador sin matrícula: " + Retiro.getNumMatricula() + "\n");

	        // Iniciar reloj en tiempo real (actualiza hora cada segundo)
	        
	        textHoraPrueba = new JTextField();
	        textHoraPrueba.setBounds(150, 11, 100, 25);
	        textHoraPrueba.setEditable(false);
	        contentPane.add(textHoraPrueba);
	        
	        
	        // Acción botón procesar
	        btnProcesar.addActionListener(e -> {
	          //  Retiro re = new Retiro(123);
	           // txtNumRetiro.setText(String.valueOf(re.getNumRetiro()));
	            
	         
	            //Imprimir("Nuevo retiro generado: " + re.getNumRetiro());
	           // Imprimir("Hora: " + re.getHora());
	           // Imprimir("Fecha: " + re.getFecha());
	            Imprimir(); // línea en blanco
	        });
	    }

	   /* private void actualizarHora() {
	        String horaActual = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
	        // Reemplaza la línea de hora actual (segunda línea del JTextArea)
	        String[] lineas = txtNumRetiro.getText().split("\n");
	        if (lineas.length >= 2) {
	            lineas[1] = "Hora actual: " + horaActual;
	            txtNumRetiro.setText(String.join("\n", lineas));
	        }
	    }*/

	    private void actualizarHora() {
	        String horaActual = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
	        textHoraPrueba.setText(horaActual);
	    }
	    void Listar(Alumno a1) {
	        // lógica para listar Alumno
	    }

	    void Imprimir(String s) {
	        txtOut.append(s + "\n");
	    }

	    void Imprimir() {
	        Imprimir("");
	    }

	    void Limpiar() {
	        txtOut.setText("");
	    }
	    
	    
	   
}
