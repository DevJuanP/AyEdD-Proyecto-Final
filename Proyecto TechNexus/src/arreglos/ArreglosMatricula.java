package arreglos;
import arreglos.ArreglosCursos;
import arreglos.ArreglosAlumno;
import clases.*;
import java.util.ArrayList;

public class ArreglosMatricula {
	private ArrayList<Matricula> matricula001;
	

	
	public ArreglosMatricula() {
		matricula001= new ArrayList<Matricula>();
		
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
