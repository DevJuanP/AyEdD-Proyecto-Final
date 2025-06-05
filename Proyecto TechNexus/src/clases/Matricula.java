package clases;
//LOCAL DATE Y TIME AYUDAN A ALMACENAR FECHAS Y HORAS 
import java.time.LocalDate;
import java.time.LocalTime;

public class Matricula {
	//contador
	static private int contadorMatricula = 100001;

	private int numMatricula,codAlumno,codCurso;
	private LocalDate fecha;
	private LocalTime hora;
	

	

		
	

public Matricula(int codAlumno, int codCurso) {
		this.numMatricula = contadorMatricula++;
		this.codAlumno = codAlumno;
		this.codCurso = codCurso;
		this.fecha = LocalDate.now();
		this.hora = LocalTime.now();
	}





//desde aqui generado con java


//GETTER AND SETTER
	
//metodo toostring para mostrar la informacion... metodo modificado
	@Override
	public String toString() {
		return    "Numero de matricula: " + numMatricula +"\n"+
				  "Codigo de alumno: " + codAlumno +"\n"+ 
				  "Codigo de curso" + codCurso+"\n"+
				  "Fecha: " + fecha +"\n"+
				  "Hora: " + hora;
	}


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


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public LocalTime getHora() {
		return hora;
	}


	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	
	
	
	
}
