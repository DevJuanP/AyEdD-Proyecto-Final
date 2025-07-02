package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Retiro;

public class ArreglosRetiro {
	private ArrayList<Retiro>listaRetiros;
	
	public ArreglosRetiro() {
		listaRetiros = new ArrayList<Retiro>();
		cargarRetiros();
	}
	
	public void adicionar(Retiro x) {
		listaRetiros.add(x);
		grabarArchivo();
	}
	
	public int tamanio() {
		return listaRetiros.size();
	}
	
	public Retiro obtener(int i) {
		return listaRetiros.get(i);
	}
	
	public Retiro buscar(int codBus) {
		for(int i = 0; i< tamanio(); i++) {
			if (obtener(i).getCodMatricula()==codBus) {
				return obtener(i);
			}
		}
		return null;
	}
	
	public void eliminar(Retiro x) {
		listaRetiros.remove(x);
		grabarArchivo();
	}
	
	private int cargarRetiros() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("data/retiros.txt"));
			String[] cadRetiros;
			int i = 0, codRetiro, codCurso, codMatricula;
			String linea, nombresApellidos, curso, fecha, hora;
			
			while((linea = br.readLine()) != null) {
				i++;
				cadRetiros = linea.split("-");
				codRetiro =Integer.parseInt(cadRetiros[0].trim());
				codMatricula = Integer.parseInt(cadRetiros[1].trim());
				nombresApellidos = cadRetiros[2].trim();
				codCurso = Integer.parseInt(cadRetiros[3].trim());
				fecha = cadRetiros[4].trim();
				hora = cadRetiros[5].trim();
			}
			br.close();
			return i;
		} catch (Exception e) {
			return 0;
		}
	}
	
	public int grabarArchivo() {
		try {
			int i=0;
			PrintWriter pw = new PrintWriter("data/retiros.txt");
			String linea;
			for(Retiro r: listaRetiros) {
				linea = r.getCodRetiro()+";"
						+r.getCodMatricula()+";"
						+r.getNombres()+";"
						+r.getApellidos()+";"
						+r.getCodCurso()+";"
						+r.getCurso()+";"
						+r.getFecha()+";"
						+r.getHora();
				pw.println(linea);
				i++;
			}
			pw.close();
			return i;
		} catch (Exception e) {
			return 0;
		}
	}
	public void actualizarArchivo() {
		grabarArchivo();
	}
}
