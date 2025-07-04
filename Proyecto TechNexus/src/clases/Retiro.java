package clases;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Retiro {

	private int codRetiro, codMatricula, codAlum, codCurso, estado;
	private String nombres, apellidos, curso, fecha, hora;
	private static int contador;
	static {
		contador = 200001;
	}

	public Retiro(int codRetiro, int codMatricula, int codAlum, String nombres, String apellidos,int codCurso,
			String curso, String fecha, String hora, int estado) {
		this.codRetiro = contador++;
		this.codMatricula = codMatricula;
		this.codAlum = codAlum;
		this.codCurso = codCurso;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.curso = curso;
		this.fecha = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.hora = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        this.estado=estado;
	}
	
	public Retiro() {
		this.codRetiro = contador++;
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

	public int getCodAlum() {
		return codAlum;
	}

	public void setCodAlum(int codAlum) {
		this.codAlum = codAlum;
	}

	public int getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
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

	public static int getContador() {
		return contador;
	}

	public static void setContador(int contador) {
		Retiro.contador = contador;
	}
	
	public int getEstado() {
	    return estado;
	}

	public void setEstado(int estado) {
	    this.estado = estado;
	}
}
