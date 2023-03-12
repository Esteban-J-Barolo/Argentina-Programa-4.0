package Clase4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ejer3 {

	public static void main(String[] args) {
		String nombres = "Jorge Pedro Marcos Noel Esteban Facu Gabriel Agustina Analia Erica";
		String[] nombre = nombres.split(" ");
		Path archivo = Paths.get("C:\\Users\\Esteban\\Desktop\\Arg Prog\\nombres.txt");
		for( String nomb : nombre)
			try {
				Files.writeString(archivo,nomb.concat("\r\n"),StandardOpenOption.APPEND);
			} catch (IOException e) {
				System.out.println("No existe el archivo");
			}

		
	}

}
