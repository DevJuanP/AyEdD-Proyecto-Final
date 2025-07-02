package clases;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Retiro {

	private int codRetiro, codMatricula, codCurso;
	private String nombresApellidos, curso, fecha, hora;
	private static int contador;
	//public static int prueba, conta;
	
	static {
		contador = 200001;
	}

	public Retiro(int codRetiro, int codMatricula, String nombresApellidos, int codCurso,  String curso, String fecha,
			String hora) {
		this.codRetiro = contador++;
		this.codMatricula = codMatricula;
		this.nombresApellidos = nombresApellidos;
		this.codCurso = codCurso;
		this.curso = curso;
		this.fecha = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		this.hora = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
	}

	public int getCodRetiro() {
		return codRetiro;
	}

	public void setCodRetiro(int codRetiro) {
		this.codRetiro = codRetiro;
	}

	public int getCodMatricula() {
		return codMatricula;
	}

	public void setCodMatricula(int codMatricula) {
		this.codMatricula = codMatricula;
	}

	public int getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}

	public String getNombresApellidos() {
		return nombresApellidos;
	}

	public void setNombresApellidos(String nombresApellidos) {
		this.nombresApellidos = nombresApellidos;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
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
	
	
	
	
	
	
	
	
	/*
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
	*/
}
