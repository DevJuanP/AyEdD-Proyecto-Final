package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Curso;

public class ArreglosCursos {
	
	private ArrayList<Curso> cursoLista;
	
	public ArreglosCursos() {
		cursoLista = new ArrayList<Curso>();
		cargarCursos();
	}
	
	
	
	public ArrayList<Curso> getCursoLista() {
		return cursoLista;
	}



	public void adicionar(Curso x) {
		 cursoLista.add(x);
		 grabarCursos();
	}
	 public int tamanio() {
		 return cursoLista.size();
	 }
	 
	 public Curso obtener(int i) {
		 return cursoLista.get(i);
	 }
	 
	 public Curso buscarCodigo(int codigo) {
		 for (int i = 0; i < tamanio(); i++) {
			if(obtener(i).getCodCurso() == codigo)
				return obtener(i);
		}
		return null;
	 }
	 
	 public void elimnar(Curso x) {
		cursoLista.remove(x);
		grabarCursos();
	 }
	 
	 private void cargarCursos() {
		try {
			BufferedReader br;
			String[] s;
			String linea, asignatura;
			int codigo, ciclo, creditos, horas;
			
			br = new BufferedReader(new FileReader("data/cursos.txt"));
			while((linea=br.readLine())!=null) {
				s=linea.split(";");
				codigo=Integer.parseInt(s[0].trim());
				asignatura=s[1].trim();
				ciclo=Integer.parseInt(s[2].trim());
				creditos=Integer.parseInt(s[3].trim());
				horas=Integer.parseInt(s[4].trim());
				adicionar(new Curso(codigo, asignatura, ciclo, creditos, horas));
			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	 }

	private void grabarCursos() {
		 try {
			PrintWriter pw;
			String linea;
			Curso x;
			pw = new PrintWriter(new FileWriter("data/cursos.txt"));
			for (int i = 0; i < tamanio(); i++) {
				x=obtener(i);
				linea = x.getCodCurso()+";"+
						x.getAsignatura()+";"+
						x.getCiclo()+";"+
						x.getCreditos()+";"+
						x.getHoras();
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	 }
	 
	 public void actualizarArchivo() {
		grabarCursos();
	}
}
