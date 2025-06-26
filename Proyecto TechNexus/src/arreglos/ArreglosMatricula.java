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
			BufferedReader br = new BufferedReader(new FileReader("data/matricula.txt"));
			String[] SEPARATOR;
			int i=0, Fecha,Hora,codigoAlum, codigoCurs,CodigoMatri,estado;
			String linea,nombres;
			while((linea= br.readLine())!=null) {
				SEPARATOR = linea.split(";");
				Fecha= Integer.parseInt(SEPARATOR[0].trim());
				Hora= Integer.parseInt(SEPARATOR[1].trim());
				codigoAlum= Integer.parseInt(SEPARATOR[2].trim());
				codigoCurs= Integer.parseInt(SEPARATOR[3].trim());
				CodigoMatri= Integer.parseInt(SEPARATOR[4].trim());
				estado= Integer.parseInt(SEPARATOR[5].trim());
				AdicionarMatricula(new Matricula(codigoAlum, codigoCurs));

				
				
			}
		}catch(Exception e) {
			
		} 
	}
	
	
	public void cargarTxtFile() {
		try {
			
			PrintWriter PW = new PrintWriter(new FileWriter("data/matricula.txt"));
			String linea;
			for(Matricula M: matricula001) {
				linea = M.getFecha()+";"
						+M.getHora()+";"
						+M.getCodAlumno()+";"
						+M.getCodCurso()+";"
						+M.getNumMatricula()+";"
						+M.getEstado();
				PW.println(linea);
				
			}
			PW.close();
				
		}catch(Exception e) {
		}
		
	}


	public void AdicionarMatricula(Matricula M) {
		matricula001.add(M);
	}
	public void RegistrarMatricula(int CodeCurso, int CodeAlumno, ArreglosCursos curso, ArreglosAlumno alumno) {
		Curso a =curso.buscarCodigo(CodeCurso);
		Alumno e =alumno.buscarCodigo(CodeAlumno);
		if(a == null||e ==null) {
			return;
		}
		
		Matricula x= new Matricula(CodeAlumno, CodeCurso);
		AdicionarMatricula(x);
	}
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
