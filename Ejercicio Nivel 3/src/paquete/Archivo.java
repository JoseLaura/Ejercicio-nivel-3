package paquete;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Archivo {
	public Archivo(String direccion) {
		this.direccion = direccion;
	}

	public void escribeArchivo(String linea) {
		try (FileWriter archivo = new FileWriter(this.direccion, true)) {
			String texto = linea;
			texto += "\r\n";
			archivo.write(texto);
			archivo.close();// cierro el archivo
		} catch (IOException e) {// controlo excepciones
			System.out.println("No se encuentra el archivo");
		}
	}

	public String leeArchivo() {
		String texto = "";
		try {
			BufferedReader bf = new BufferedReader(new FileReader(this.direccion));
			String temp = "";
			String bfRead;
			while ((bfRead = bf.readLine()) != null) {// Este while avanza linea por linea
				temp += bfRead;// guardo el contenido de la linea del archivo en la variable temporal
				temp += "\n";/*
								 * guardo en la variable String temporal un salto de linea antes de guardar la
								 * siguente linea en esta variable
								 */
			}
			texto = temp;// aqui asigno el contenido de temp a la variable String que retorno
			bf.close();// cierro el archivo
		} catch (IOException e) {// controlo excepciones
			System.out.println("No se encuentra el archivo");
		}
		return texto;
	}

	public void extraeDatosArchivo(String direccion) {
		try {
			BufferedReader bf = new BufferedReader(new FileReader(this.direccion));
			String linea = "";
			if ((linea = bf.readLine()) != null) {
				this.cantidadDeNotas = Integer.parseInt(linea);
				linea = "";
			}
			if ((linea = bf.readLine()) != null) {
				notas = new int[this.cantidadDeNotas];
				String lineaSinEspacios = "";
				for (int i = 0; i < linea.length(); i++) {
					if (linea.charAt(i) != ' ') {
						lineaSinEspacios += linea.charAt(i);
					}
				}
				for (int j = 0; j < this.cantidadDeNotas; j++) {
					notas[j] = (int) lineaSinEspacios.charAt(j);
				}
			}
			bf.close();// cierro el archivo
		} catch (IOException e) {// controlo excepciones
			System.out.println("No se encuentra el archivo");
		}
		
	}

	public int[] dimeNotas() {
		return this.notas;
	}
	
	public int cantNotas() {
		return cantidadDeNotas;
	}
	

	private String direccion;
	private int cantidadDeNotas = 0;
	private int notas[];
}
