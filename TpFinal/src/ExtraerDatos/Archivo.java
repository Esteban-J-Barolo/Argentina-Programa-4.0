package ExtraerDatos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public abstract class Archivo {
	
	public static ArrayList<String[]> sacarDatos(String str){
		ArrayList<String[]> lineas = new ArrayList<String[]>();
		
		//String str = "C:\\Users\\Esteban\\Desktop\\Arg Prog\\TpFinal\\partidos.txt";
		Path archivo = Paths.get(str);
		List<String> lineasArchivo;
		try {
			lineasArchivo = Files.readAllLines(archivo);
			lineasArchivo.remove(1);
			for (String linea : lineasArchivo) {
				if (!linea.contains("---")) {
					String fila[] = linea.replace(" ", "").replace("\t", "").replace("|", ",").split(",");
					lineas.add(fila);
				}
			}
		} catch (IOException e1) {
			System.out.println("No existe el archivo");
		}
		
		return lineas;
	}
	
	/*public static ArrayList<String[]> sacarDatosPronosticos(){
		ArrayList<String[]> lineas = new ArrayList<String[]>();
		
		String str = "C:\\Users\\Esteban\\Desktop\\Arg Prog\\TpFinal\\pronosticos.txt";
		Path archivo = Paths.get(str);
		List<String> lineasArchivo;
		try {
			lineasArchivo = Files.readAllLines(archivo);
			lineasArchivo.remove(1);
			for (String linea : lineasArchivo) {
				if (!linea.contains("---")) {
					String fila[] = linea.replace(" ", "").replace("\t", "").replace("|", ",").split(",");
					lineas.add(fila);
				}
			}
			
		} catch (IOException e) {
			System.out.println("No existe el archivo");
		}
		return lineas;
	}*/

}
