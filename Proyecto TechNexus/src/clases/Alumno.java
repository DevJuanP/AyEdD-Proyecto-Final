package clases;

public class Alumno {
	private int codAlumno, edad, celular, estado;
	private String nombres, apellidos, dni;
	
	private static int genCode = 202510000;
	
	public Alumno(int edad, int celular, String nombres, String apellidos, String dni) {
		genCode++;
		this.codAlumno = genCode;
		this.edad = edad;
		this.celular = celular;
		this.estado = 0;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
	}
	
	public Alumno(int edad, int celular, String nombres, String apellidos, String dni, String s) {
		switch(s) {
			case "LEER_DATOS":
				this.estado = 3;//3 que se usa para leer datos
				break;
			default:
				this.estado = 0;
		}
		this.codAlumno = genCode;
		this.edad = edad;
		this.celular = celular;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
	}

	public int getCodAlumno() {
		return codAlumno;
	}

	public void setCodAlumno(int codAlumno) {
		this.codAlumno = codAlumno;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
}
