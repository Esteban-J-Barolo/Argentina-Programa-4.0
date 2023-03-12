package Clase3;

public class ejer2 {

	public static void main(String[] args) {
		String nombres = "Jorge Pedro Marcos Noel Esteban Facu Gabriel Agustina Analia Erica";
		String[] nombre = nombres.split(" ");
		for(int i=0;i<nombre.length;i++)
			System.out.println(nombre[i]);
	}

}
