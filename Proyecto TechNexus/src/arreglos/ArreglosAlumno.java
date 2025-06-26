package arreglos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Alumno;

public class ArreglosAlumno {
	
	private ArrayList <Alumno> alumnosList;
	
	public ArreglosAlumno(){
		alumnosList = new ArrayList <Alumno> ();
	}
	
	


	public ArrayList<Alumno> getAlumnosList() {
		return alumnosList;
	}

	public void setAlumnosList(ArrayList<Alumno> alumnosList) {
		this.alumnosList = alumnosList;
	}

	public void adicionar(Alumno a) {
		alumnosList.add(a);
	}
	
	public int tamaño() {
		return alumnosList.size();
	}
	
	public Alumno obtener(int i) {
		return alumnosList.get(i);
	}
	
	public Alumno buscarDNI(String DNI) {
		for (Alumno a : alumnosList) {
			if(a.getDni() == DNI) return a;
		}
		return null;
	}
	
	public ArrayList <Alumno> buscarApellido(String apellido) {
		ArrayList <Alumno> alumXapellido = new ArrayList <Alumno>();
		String[] apellidosArr = apellido.split(" ");
		for(String apN : apellidosArr) {
			for(Alumno a : alumnosList) {
				if(a.getApellidos().contains(apN)) alumXapellido.add(a);
			}
		}
		return alumXapellido.size() == 0? null: alumXapellido;
	}
	
	public Alumno buscarCodigo(int codigoTF) {
		for (Alumno a : alumnosList) {
			if(a.getCodAlumno() == codigoTF) return a;
		}
		return null;
	}
	
	public void Eliminar (Alumno a) {
		alumnosList.remove(a);
	}
	
	public int getNextCodigo() {
		return tamaño()+202500001;
	}
	
	public int cargarAlumnos() {
		try {
			
			BufferedReader br = new BufferedReader(new FileReader("data/alumnos.txt"));
			String[] cadDatos;
			int i=0, codAlumno, edad, celular, estado;
			String linea, nombres, apellidos, dni;
			while ((linea = br.readLine()) != null) {
				i++;
				cadDatos = linea.split(";");
				codAlumno = Integer.parseInt(cadDatos[0].trim());
				nombres = cadDatos[1].trim();
				apellidos = cadDatos[2].trim();
				edad = Integer.parseInt(cadDatos[3].trim());
				celular = Integer.parseInt(cadDatos[4].trim());
				dni = cadDatos[5].trim();
				estado = Integer.parseInt(cadDatos[6].trim());
				adicionar(new Alumno(codAlumno, nombres, apellidos, edad, celular, dni, estado));
			}
			br.close();
			return i;
		}catch(Exception e){
			return 0;
		}
	}
	
	public int cargarALToTxtfile() {
		try {
			int i = 0;
			PrintWriter pw = new PrintWriter(new FileWriter("data/alumnos.txt"));
			String linea;
			for(Alumno a : alumnosList) {
				linea = a.getCodAlumno()+";"
						+a.getNombres()+";"
						+a.getApellidos()+";"
						+a.getEdad()+";"
						+a.getCelular()+";"
						+a.getDni()+";"
						+a.getEstado();
				pw.println(linea);
				i++;
			}
			pw.close();
			return i;
		}catch(Exception e) {
			return 0;
		}
	}
	
	
	
	
}
