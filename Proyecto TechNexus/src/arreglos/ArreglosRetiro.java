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
	
	private void cargarRetiros() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("data/retiros.txt"));
			String[] cadRetiros;
			int codRetiro, codCurso, codMatricula;
			String linea, nombre,apellido, curso, fecha, hora;
			
			while((linea = br.readLine()) != null) {
				cadRetiros = linea.split(";");
				codRetiro =Integer.parseInt(cadRetiros[0].trim());
				codMatricula = Integer.parseInt(cadRetiros[1].trim());
				nombre = cadRetiros[2].trim();
				apellido = cadRetiros[3].trim();
				codCurso = Integer.parseInt(cadRetiros[4].trim());
				curso = cadRetiros[5].trim();
				fecha = cadRetiros[6].trim();
				hora = cadRetiros[7].trim();
				adicionar(new Retiro(codRetiro, codMatricula, codMatricula, nombre, apellido, codCurso, curso, fecha, hora));
			}
			br.close();
		} catch (Exception e) {
			//return 0;
		}
	}
	
	public void grabarArchivo() {
		try {
			//int i=0;
			PrintWriter pw = new PrintWriter("data/retiros.txt");
			String linea;
			Retiro r;
			for(int i = 0; i<tamanio(); i++) {
				r=obtener(i);
				linea = r.getCodRetiro()+";"
						+r.getCodMatricula()+";"
						+r.getNombres()+";"
						+r.getApellidos()+";"
						+r.getCodCurso()+";"
						+r.getCurso()+";"
						+r.getFecha()+";"
						+r.getHora();
				pw.println(linea);
				//i++;
			}
			pw.close();
			//return i;
		} catch (Exception e) {
			//return 0;
		}
	}
	public void actualizarArchivo() {
		grabarArchivo();
	}
}
