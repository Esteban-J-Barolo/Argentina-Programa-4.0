package Clase4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ejer2 {

	public static void main(String[] args) {
		sumarNumerosArchivoYMostrar("C:\\Users\\Esteban\\Desktop\\Arg Prog\\numeros.txt");
		sumarOMultiplicarNumerosArchivoYMostrar("C:\\Users\\Esteban\\Desktop\\Arg Prog\\numeros.txt",'m');
	}
	
	private static void sumarNumerosArchivoYMostrar(String str) {
		int suma=0;
		Path archivo = Paths.get(str);
		try {
			for (String linea : Files.readAllLines(archivo)) {
				for (String num : linea.split(" ")) {
					suma += Integer.parseInt(num);
				}
			}
		} catch (IOException e) {
			System.out.println("No existe el archivo");
		}
		System.out.println(suma);
	}
	
	private static void sumarOMultiplicarNumerosArchivoYMostrar(String str, char operacion) {
		int suma=0;
		if (operacion == 'm') suma=1;
		Path archivo = Paths.get(str);
		try {
			for (String linea : Files.readAllLines(archivo)) {
				for (String num : linea.split(" ")) {
					if (operacion == 's') suma += Integer.parseInt(num);
					else if (operacion == 'm') suma *= Integer.parseInt(num);
				}
			}
		} catch (IOException e) {
			System.out.println("No existe el archivo");
		}
		System.out.println(suma);
	}

}
