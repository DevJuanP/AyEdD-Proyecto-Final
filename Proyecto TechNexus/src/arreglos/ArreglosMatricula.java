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
		CargarMatricula();
	}
	
	public void AdicionarMatricula(Matricula M) {
		matricula001.add(M);
		GrabarTXT();
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
		GrabarTXT();
	 }
	
	public ArrayList<Matricula> getMatricula001() {
		return matricula001;
	}
	
	
	public void setMatricula001(ArrayList<Matricula> matricula001) {
		this.matricula001 = matricula001;
	}
	
	
	public void CargarMatricula() {
		try {
			matricula001.clear(); 
			BufferedReader br = new BufferedReader(new FileReader("data/matricula.txt"));
			String[] SEPARATOR;
			int codigoAlum, codigoCurs,CodigoMatri,estado;
			String linea,nombres,apellidos,Fecha,Hora;
			while((linea= br.readLine())!=null) {
				SEPARATOR = linea.split(";");
				CodigoMatri = Integer.parseInt(SEPARATOR[0].trim());
				 codigoAlum = Integer.parseInt(SEPARATOR[1].trim());
				 codigoCurs = Integer.parseInt(SEPARATOR[2].trim());
				 nombres = SEPARATOR[3].trim();
				 apellidos = SEPARATOR[4].trim();
				 Fecha = SEPARATOR[5].trim();
				 Hora = SEPARATOR[6].trim();
				 estado=Integer.parseInt(SEPARATOR[5].trim());
				Matricula m =new Matricula(estado, codigoAlum, codigoCurs, CodigoMatri, estado, nombres, apellidos, Fecha, Hora);
				m.setNumMatricula(CodigoMatri);  // Si tienes un setter para el n�mero de matr�cula
				m.setFecha(Fecha);
				m.setHora(Hora);
				AdicionarMatricula(m);
			}
			br.close();
		}catch(Exception e) {
			//
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
				//
			}
	}

	public void actualizarArchivo() {
		GrabarTXT();
	}
}
