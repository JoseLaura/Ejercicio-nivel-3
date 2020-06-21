package paquete;

public class Main {

	public static void main(String[] args) {
		
		Archivo entrada = new Archivo("C:\\Users\\Usuario1\\git\\Ejercicio-nivel-3\\Ejercicio Nivel 3\\entrada.txt");
		entrada.extraeDatosArchivo("C:\\Users\\Usuario1\\git\\Ejercicio-nivel-3\\Ejercicio Nivel 3\\entrada.txt");
		
		Archivo salida = new Archivo("C:\\Users\\Usuario1\\git\\Ejercicio-nivel-3\\Ejercicio Nivel 3\\salida.txt");
		
		int notas[] = new int[entrada.cantNotas()];
		notas=entrada.dimeNotas();
	
		int sumaDeTodasLasNotas=0;
		int promedio;
		boolean aprobado;
		int mejorNota=0;
		
		for(int i=0;i<notas.length;i++) {
			sumaDeTodasLasNotas+=notas[i];
			
			if(notas[i]>=mejorNota) {
				mejorNota=notas[i];
			}
		}
		
		promedio=sumaDeTodasLasNotas/entrada.cantNotas();
		
		if(promedio >=7 && notas[notas.length-1]>=7) {
			aprobado = true;
		}else {
			aprobado = false;
		}
		
		String linea1="", linea2="", linea3="", linea4="";
		linea1+=sumaDeTodasLasNotas;
		linea2+=promedio;
		
		if(aprobado==true) {
			linea3="SI";
		}else {
			linea3="NO";
		}
		linea4+=mejorNota;
		
		
		
		
		salida.escribeArchivo(linea1);
		salida.escribeArchivo(linea2);
		salida.escribeArchivo(linea3);
		salida.escribeArchivo(linea4);
		
		
		
	}

}
	

