package arreglos;

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
		cargarMatricula();
	}
	
	
	
	public ArrayList<Matricula> getMatricula001() {
		return matricula001;
	}



	public void setMatricula001(ArrayList<Matricula> matricula001) {
		this.matricula001 = matricula001;
	}



	public void adicionarMatricula(Matricula M) {
		matricula001.add(M);
		grabarMatricula();
	}
	
	public int tamanio() {
		return matricula001.size();
	}
	public Matricula obtener(int i) {
		return matricula001.get(i);
	}
	
	public Matricula buscarMatricula(int codigo) {
		/*for(Matricula m : matricula001) {
			if(m.getNumMatricula()== codigo) 
				return m;
		}*/
		for (int i = 0; i < tamanio(); i++) {
			if (obtener(i).getNumMatricula()==codigo) {
				return obtener(i);
			}
		}
		return null;
	}
	
	public int generateCod() {
		int nextCod = tamanio()+100001;
		while(buscarMatricula(nextCod)!=null) {
			nextCod++;
		}
		return nextCod;
	}
	
	public void Eliminar(Matricula M) {
		matricula001.remove(M);
		grabarMatricula();
	 }
	
	/*
	public ArrayList<Matricula> getMatricula001() {
		return matricula001;
	}
	
	
	public void setMatricula001(ArrayList<Matricula> matricula001) {
		this.matricula001 = matricula001;
	} */
	
	
	public void cargarMatricula() {
		
	    try {
	        matricula001.clear(); // Limpiar antes de cargar
	        BufferedReader br = new BufferedReader(new FileReader("data/matricula.txt"));
	        
	        String[] separador;
			int codigoAlum, codigoCurs,CodigoMatri,estado;
			String linea,nombres,apellidos,Fecha,Hora;
			while((linea= br.readLine())!=null) {
				separador = linea.split(";");
				CodigoMatri = Integer.parseInt(separador[0].trim());
				codigoAlum = Integer.parseInt(separador[1].trim());
				codigoCurs = Integer.parseInt(separador[2].trim());
				nombres = separador[3].trim();
				apellidos = separador[4].trim();
				String asignatura = separador[5].trim();
				Fecha = separador[6].trim();
				Hora = separador[7].trim();
				estado = Integer.parseInt(separador[8].trim());
				adicionarMatricula(new Matricula(CodigoMatri, codigoAlum, codigoCurs, nombres, apellidos, asignatura, Fecha, Hora, estado));
				 }
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
		
		
		//codigo incial
		/*try {
			//matricula001.clear(); 
			BufferedReader br = new BufferedReader(new FileReader("data/matricula.txt"));
			String[] separador;
			int codigoAlum, codigoCurs,CodigoMatri,estado;
			String linea,nombres,apellidos,Fecha,Hora;
			while((linea= br.readLine())!=null) {
				separador = linea.split(";");
				CodigoMatri = Integer.parseInt(separador[0].trim());
				 codigoAlum = Integer.parseInt(separador[1].trim());
				 codigoCurs = Integer.parseInt(separador[2].trim());
				 nombres = separador[3].trim();
				 apellidos = separador[4].trim();
				 Fecha = separador[5].trim();
				 Hora = separador[6].trim();
				 estado=Integer.parseInt(separador[7].trim());
				//Matricula m =new Matricula(codigoAlum, codigoCurs, CodigoMatri, nombres, apellidos, apellidos, Fecha, Hora, estado);
				//AdicionarMatricula(m);
				 adicionarMatricula(new Matricula(codigoAlum, codigoCurs, CodigoMatri, nombres, apellidos, apellidos, Fecha, Hora, estado));
			}
			br.close();
		}catch(Exception e) {
			//
		}*/
	}
	
	
	public void grabarMatricula() {
		try {
			PrintWriter pw = new PrintWriter("data/matricula.txt");
			String linea;
			Matricula m;
			for(int i = 0; i < tamanio(); i++) {
				m=obtener(i);
				linea = m.getNumMatricula() + ";" +
				        m.getCodAlumno() + ";" +
				        m.getCodCurso() + ";" +
				        m.getNombres() + ";" +
				        m.getApellidos() + ";" +
				        m.getAsignatura() + ";" +
				        m.getFecha() + ";" +
				        m.getHora() + ";" +
				        m.getEstado();
						
						//cod inicial
						/*m.getNumMatricula() + ";" +
					    m.getCodAlumno() + ";" +
					    m.getNombres() + ";" +
					    m.getApellidos() + ";" +
					    m.getCodCurso() + ";" +
					    m.getAsignatura() + ";" +
					    m.getFecha() + ";" +
					    m.getHora() + ";" +
					    m.getEstado();*/
				pw.println(linea);
			}
			pw.close();
			}catch(Exception e) {
				//
			}
	}

	public void actualizarArchivo() {
		grabarMatricula();
	}
}
