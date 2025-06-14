package clases;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Retiro {

	private int numRetiro, numMatricula;
	private String fecha, hora;
	private static int contador;
	public static int prueba, conta;
	
	static {
		contador = 200001;
		//conta = 5;
	}
	public Retiro(int numMatricula) {
		this.numRetiro = contador++;
		this.numMatricula = numMatricula;
		this.fecha = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		this.hora = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
	}


	public Retiro() {
		super();
		this.fecha = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		this.hora = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
		//this.conta++;
	}
	

	//get and set

	public int getNumRetiro() {
		return numRetiro;
	}

	public void setNumRetiro(int numRetiro) {
		this.numRetiro = numRetiro;
	}

	public int getNumMatricula() {
		return numMatricula;
	}

	public void setNumMatricula(int numMatricula) {
		this.numMatricula = numMatricula;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
	
}
