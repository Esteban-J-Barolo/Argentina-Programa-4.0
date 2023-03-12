package Clase4;

import java.util.Scanner;

public class ejer1_b {

	public static void main(String[] args) {
		int numeros[] = new int[3];
		int i = 0;
		try (Scanner scn = new Scanner(System.in)) {
			System.out.print("Ingrese 3 numero separados por un espacio: ");
			String numerosLine = scn.nextLine();
			for (String numeroStr : numerosLine.split(" ")) {
				numeros[i] = Integer.parseInt(numeroStr);
				i++;
			}
		} catch (NumberFormatException e) {
			System.out.println("No ingreso los numeros.");
		}
		int a=numeros[0], b=numeros[1], c=numeros[2];
		int vectorOrdenado[] = ordenar(a,b,c,'a');
		System.out.println(vectorOrdenado[0]+" "+vectorOrdenado[1]+" "+vectorOrdenado[2]);
	}
	
	private static int[] ordenar( int a, int b, int c, char ord) {
		int vectorOrdenado[] = new int[3];
		if (ord == 'a') {
			if (a<b && a<c) {
				vectorOrdenado[0]=a;
				if (b<c){
					vectorOrdenado[1]=b;
					vectorOrdenado[2]=c;
				}else {
					vectorOrdenado[2]=b;
					vectorOrdenado[1]=c;
				}
			}else {
				if (b<a && b<c) {
					vectorOrdenado[0]=b;
					if (a<c){
						vectorOrdenado[1]=a;
						vectorOrdenado[2]=c;
					}else {
						vectorOrdenado[2]=a;
						vectorOrdenado[1]=c;
					}
				}else {
					vectorOrdenado[0]=c;
					if (b<a){
						vectorOrdenado[1]=b;
						vectorOrdenado[2]=a;
					}else {
						vectorOrdenado[2]=b;
						vectorOrdenado[1]=a;
					}
				}
			}
		}else if (ord == 'b') {
			if (a>b && a>c) {
				vectorOrdenado[0]=a;
				if (b>c){
					vectorOrdenado[1]=b;
					vectorOrdenado[2]=c;
				}else {
					vectorOrdenado[2]=b;
					vectorOrdenado[1]=c;
				}
			}else {
				if (b>a && b>c) {
					vectorOrdenado[0]=b;
					if (a>c){
						vectorOrdenado[1]=a;
						vectorOrdenado[2]=c;
					}else {
						vectorOrdenado[2]=a;
						vectorOrdenado[1]=c;
					}
				}else {
					vectorOrdenado[0]=c;
					if (b>a){
						vectorOrdenado[1]=b;
						vectorOrdenado[2]=a;
					}else {
						vectorOrdenado[2]=b;
						vectorOrdenado[1]=a;
					}
				}
			}
		}
		return vectorOrdenado;
	}

}
