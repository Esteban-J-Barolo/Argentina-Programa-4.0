package Clase2;

public class ejer1_c {

	public static void main(String[] args) {
		int numeros[] = {3,5,7,9,2,4}, x = 5, suma=0;
		for(int i=0;i<numeros.length;i++) {
			if( numeros[i] > x ) {
				suma += numeros[i];
			}
		}
		System.out.println(suma);
	}

}
