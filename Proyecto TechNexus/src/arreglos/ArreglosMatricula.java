package arreglos;
import arreglos.ArreglosCursos;
import arreglos.ArreglosAlumno;
import clases.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ArreglosMatricula {
	private ArrayList<Matricula> matricula001;
	

	
	public ArreglosMatricula() {
		matricula001= new ArrayList<Matricula>();
		
	}
	
	public void CargarMatricula() {
		try {
			matricula001.clear(); 
			BufferedReader br = new BufferedReader(new FileReader("data/matricula.txt"));
			String[] SEPARATOR;
			int codigoAlum, codigoCurs,CodigoMatri,estado;
			String linea,nombres,Fecha,Hora;
			while((linea= br.readLine())!=null) {
				SEPARATOR = linea.split(";");
				CodigoMatri = Integer.parseInt(SEPARATOR[0].trim());
				 codigoAlum = Integer.parseInt(SEPARATOR[1].trim());
				 codigoCurs = Integer.parseInt(SEPARATOR[2].trim());
				 Fecha = SEPARATOR[3].trim();
				 Hora = SEPARATOR[4].trim();
				 estado=Integer.parseInt(SEPARATOR[5].trim());
				Matricula m =new Matricula(codigoAlum, codigoCurs ,estado);
				m.setNumMatricula(CodigoMatri);  // Si tienes un setter para el número de matrícula
				m.setFecha(Fecha);
				m.setHora(Hora);
				AdicionarMatricula(m);

				
				
			}
		}catch(Exception e) {
			
		} 
	}
	
	
	public void GrabarTXT() {
		try {
			
			PrintWriter PW = new PrintWriter(new FileWriter("data/matricula.txt"));
			String linea;
			for(Matricula M: matricula001) {
				linea = M.getNumMatricula() + ";" 
					      + M.getCodAlumno() + ";" 
					      + M.getCodCurso() + ";" 
					      + M.getFecha() + ";" 
					      + M.getHora() + ";" 
					      + M.getEstado();
				PW.println(linea);
				
			}
			PW.close();
				
		}catch(Exception e) {
		}
		
	}


	
	public void AdicionarMatricula(Matricula M) {
		matricula001.add(M);
	}
/*	public void RegistrarMatricula(int CodeCurso, int CodeAlumno, ArreglosCursos curso, ArreglosAlumno alumno) {
		Curso a =curso.buscarCodigo(CodeCurso);
		int estado= 0;
		Alumno e =alumno.buscarCodigo(CodeAlumno);
		if(a == null||e ==null) {
			return;
	}
		
		Matricula x= new Matricula(CodeAlumno, CodeCurso,estado);
		AdicionarMatricula(x);
	}*/
	public int tamanio() {
		return matricula001.size();
	}
	public Matricula obtener(int i) {
		return matricula001.get(i);
	}
	
	public Matricula buscarMatricula(int codigo) {
		for(Matricula m : matricula001) {
			if(m.getNumMatricula()== codigo) return m;
		}
		return null;
	}
	
	public int generateCod() {
		return tamanio()+100001;
	}
	
		 
	public void Eliminar(Matricula M) {
		matricula001.remove(M);
	 }
	
		
	
	
	
	public ArrayList<Matricula> getMatricula001() {
		return matricula001;
	}
	
	
	public void setMatricula001(ArrayList<Matricula> matricula001) {
		this.matricula001 = matricula001;
	}
	
	
	
	

}
