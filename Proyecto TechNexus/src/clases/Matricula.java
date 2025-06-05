package clases;
//LOCAL DATE Y TIME AYUDAN A ALMACENAR FECHAS Y HORAS 
import java.time.LocalDate;
import java.time.LocalTime;
//DATE TIME FORM PARA AGREGAR FORMATO Y PARSEAR EL TEXTO A OBJETOS DE TIPO FECHA U HORA
import java.time.format.DateTimeFormatter;


public class Matricula {
	//contador
	static private int contadorMatricula = 100001;

	private int numMatricula,codAlumno,codCurso,estado;
	private String fecha;
	private String hora;
	

	

		
	

public Matricula(int codAlumno, int codCurso) {
		this.numMatricula = contadorMatricula++;
		this.estado = 1;
		this.codAlumno = codAlumno;
		this.codCurso = codCurso;
		this.fecha = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		this.hora  = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
	}





//desde aqui generado con java


//GETTER AND SETTER
	



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


	//metodo toostring para mostrar la informacion... metodo modificado
	@Override
	public String toString() {
		return    "Numero de matricula: " + numMatricula +"\n"+
				  "Codigo de alumno: " + codAlumno +"\n"+ 
				  "Codigo de curso" + codCurso+"\n"+
				  "Fecha: " + fecha +"\n"+
				  "Hora: " + hora;
	}
	
	
	
}
