package clases;
//LOCAL DATE Y TIME AYUDAN A ALMACENAR FECHAS Y HORAS 
import java.time.LocalDate;
import java.time.LocalTime;
//DATE TIME FORM PARA AGREGAR FORMATO Y PARSEAR EL TEXTO A OBJETOS DE TIPO FECHA U HORA
import java.time.format.DateTimeFormatter;
//DATE TIME EXCEPTION LANZA UNA EXCEPCION EN CASO DE QUE EL FORMATO SEA INCORRECTO O UNA FECHA INCORRECTA
import java.time.format.DateTimeParseException;
public class Matricula {
	//contador
	static private int contadorMatricula = 100001;

	private int numMatricula,codAlumno,codCurso;
	private LocalDate fecha;
	private LocalTime hora;
	
	//CREACION DE LOS FOMATOS DE DECHA Y HORA 
	static public final DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	static public final DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");	
	
	

		
	

public Matricula(int codAlumno, int codCurso, String fecha, String hora) {
		this.numMatricula = contadorMatricula++;
		this.codAlumno = codAlumno;
		this.codCurso = codCurso;
		this.fecha = ConvertirFecha(fecha);
		this.hora = ConvertirHora(hora);
	}


//metodos para comvertir las fechas y horas String a objetos date/time
 private LocalDate ConvertirFecha(String fecha) {
	 try {
		 return LocalDate.parse(fecha, formatoFecha);
	 }catch (DateTimeParseException e) {
		throw new IllegalArgumentException("Fecha incorrecta, ingrese correctamente los datos.");
	}
 }
 

 private LocalTime ConvertirHora(String hora) {
	 try {
		 return  LocalTime.parse(hora, formatoHora);
	 }catch (DateTimeParseException e) {
		throw new IllegalArgumentException("Hora incorrecta, ingrese correctamente los datos.");
	}
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

//metodo toostring para mostrar la informacion... metodo modificado
	@Override
	public String toString() {
		return    "Numero de matricula: " + numMatricula +"\n"+
				  "Codigo de alumno: " + codAlumno +"\n"+ 
				  "Codigo de curso" + codCurso+"\n"+
				  "Fecha: " + fecha.format(formatoFecha) +"\n"+
				  "Hora: " + hora.format(formatoHora);
	}
	
	
	
	
}
