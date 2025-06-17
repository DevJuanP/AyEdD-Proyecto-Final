package arreglos;

import java.util.ArrayList;

import clases.Curso;

public class ArreglosCursos {
	
	private ArrayList<Curso> cursoLista;
	
	public ArreglosCursos() {
		cursoLista = new ArrayList<Curso>();
		adicionar(new Curso(3001, "Java", 3, 13, 5));
		adicionar(new Curso(3002, "MySQL", 1, 21, 8));
		adicionar(new Curso(3003, "Python", 0, 16, 4));
		adicionar(new Curso(3004, "PHP", 5, 25, 9));
		adicionar(new Curso(3005, "JavaScript", 2, 40, 12));
		adicionar(new Curso(3006, "C++", 4, 36, 7));
		adicionar(new Curso(3007, "React.js", 1, 42, 16));
		adicionar(new Curso(3008, "HTML", 5, 28, 14));
	}
	
	public void adicionar(Curso x) {
		 cursoLista.add(x);
	}
	 public int tamanio() {
		 return cursoLista.size();
	 }
	 
	 public Curso obtener(int i) {
		 return cursoLista.get(i);
	 }
	 
		// Buscar curso por código
	public Curso buscarPorCodigo(int codigo) {
		for (Curso c : cursoLista) {
			if (c.getCodCurso() == codigo) {
				return c;
				}
			}
			return null;
		}
}
