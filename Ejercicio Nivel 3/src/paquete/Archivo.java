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
			archivo.close();
		} catch (IOException e) {
			System.out.println("No se encuentra el archivo");
		}
	}

	public String leeArchivo() {
		String texto = "";
		try {
			BufferedReader bf = new BufferedReader(new FileReader(this.direccion));
			String temp = "";
			String bfRead;
			while ((bfRead = bf.readLine()) != null) {
				temp += bfRead;
				temp += "\n";
			}
			texto = temp;
			bf.close();
		} catch (IOException e) {
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
				int j = 0;
				String valor = "";
				for (int i = 0; i < linea.length(); i++) {
					if (linea.charAt(i) != ' ') {
						valor += linea.charAt(i);
					}
					if (linea.charAt(i) == ' ' || i == linea.length() - 1) {
						notas[j] = Integer.parseInt(valor);
						valor = "";
						j++;
					}
				}
			}
			bf.close();
		} catch (IOException e) {
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
