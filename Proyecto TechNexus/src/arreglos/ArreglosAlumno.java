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
		cargarAlumnos();
	}
	
	public ArrayList<Alumno> getAlumnosList() {
		return alumnosList;
	}

	public void setAlumnosList(ArrayList<Alumno> alumnosList) {
		this.alumnosList = alumnosList;
	}

	public void adicionar(Alumno a) {
		alumnosList.add(a);
		grabarAlumnos();
	}
	
	public int tamanio() {
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
	
	public Alumno buscarCodigo(int codigo) {
	    for (Alumno a : alumnosList) {
	        if (a.getCodAlumno() == codigo)
	            return a;
	    }
	    return null;
	}

	public Alumno buscarDni(String dni) {
	    for (Alumno a : alumnosList) {
	        if (a.getDni().equalsIgnoreCase(dni))
	            return a;
	    }
	    return null;
	}

	public ArrayList<Alumno> buscarPorApellidos(String apellidos) {
	    ArrayList<Alumno> resultados = new ArrayList<>();
	    for (Alumno a : alumnosList) {
	        if (a.getApellidos().toLowerCase().contains(apellidos.toLowerCase())) {
	            resultados.add(a);
	        }
	    }
	    return resultados;
	}
	
	public void Eliminar (Alumno a) {
		alumnosList.remove(a);
		grabarAlumnos();
		
	}
	
	public int getNextCodigo() {
		int nextCodigo = tamanio()+202510001;
		while(buscarCodigo(nextCodigo) != null) {
			nextCodigo++;
		}
		return nextCodigo;
	}
	
	private void cargarAlumnos() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("data/alumnos.txt"));
			String[] cadDatos;
			int codAlumno, edad, celular, estado;
			String linea, nombres, apellidos, dni;
			while ((linea = br.readLine()) != null) {
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
		}catch(Exception e){
		}
	}
	
	private void grabarAlumnos() {
		try {
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
			}
			pw.close();
		}catch(Exception e) {
		}
	}
	
	public void actualizarArchivo() {
		grabarAlumnos();
	}
	
}
