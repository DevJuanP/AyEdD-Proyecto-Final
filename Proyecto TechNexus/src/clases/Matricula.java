package clases;
//LOCAL DATE Y TIME AYUDAN A ALMACENAR FECHAS Y HORAS 
import java.time.LocalDate;
import java.time.LocalTime;
//DATE TIME FORM PARA AGREGAR FORMATO Y PARSEAR EL TEXTO A OBJETOS DE TIPO FECHA U HORA
import java.time.format.DateTimeFormatter;

public class Matricula {
	//contador
	static private int contadorMatricula = 100000;

	private int numMatricula,codAlumno,codCurso;
	private String nombres;
	private String apellidos;
	private String asignatura;
	private String fecha;
	private String hora;
	private int estado;
	
	//constructor
	public Matricula(int numMatricula, int codAlumno, int codCurso, String nombres, String apellidos, String asignatura,String fecha, String hora, int estado) {
		this.numMatricula = numMatricula;
		this.codAlumno = codAlumno;
		this.codCurso = codCurso;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.asignatura = asignatura;
		this.fecha = fecha;
		this.fecha = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.hora = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    	this.estado = estado;
	}
	
	public Matricula(int numMatricula, int codAlumno, int codCurso) {
		this.numMatricula = numMatricula;
		this.codAlumno = codAlumno;
		this.codCurso = codCurso;
		this.fecha = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.hora = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
	}


	//get y set
	public static int getContadorMatricula() {
		return contadorMatricula;
	}

	public static void setContadorMatricula(int contadorMatricula) {
		Matricula.contadorMatricula = contadorMatricula;
	}

	public int getNumMatricula() {
		return numMatricula;
	}

	public void setNumMatricula(int numMatricula) {
		this.numMatricula = numMatricula;
	}

	public int getCodAlumno() {
		return codAlumno;
	}

	public void setCodAlumno(int codAlumno) {
		this.codAlumno = codAlumno;
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

	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
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

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
}


//metodo toostring para mostrar la informacion... metodo modificado
/*public String toString() {
	return    "Numero de matricula: " + numMatricula +"\n"+
			  "Codigo de alumno: " + codAlumno +"\n"+ 
			  "Codigo de curso" + codCurso+"\n"+
			  "Fecha: " + fecha +"\n"+
			  "Hora: " + hora;
}*/
