package Integrador;

import java.io.IOException;
import java.util.Scanner;

public class Calculadora {

	public static void main(String[] args) {
		boolean repetir=true;
		while (repetir) {
			repetir = menu(repetir);
		}
	}
	
	public static boolean menu(boolean seguir) {
		System.out.println("  MENU Calculadora\n1- Sumar\n2- Restar\n3- Multiplicar\n4- Dividir\n5- Limpiar\n6- Salir");
		Scanner scn = new Scanner(System.in);
		int opc = 0;
		double resultado;
		System.out.print("Opción: ");
		opc = scn.nextInt();
		int num1=0, num2=0;
		if (opc==1 && opc==2 && opc==3 && opc==4) {
			System.out.print("Número 1: ");
			num1 = scn.nextInt();
			System.out.print("Número 2: ");
			num2 = scn.nextInt();
		}
		switch (opc) {
		case 1:
			resultado=suma(num1, num2);
			System.out.println(num1+" + "+num2+" = "+resultado);
			break;
		case 2:
			resultado=resta(num1, num2);
			System.out.println(num1+" - "+num2+" = "+resultado);
			break;
		case 3:
			resultado=mult(num1, num2);
			System.out.println(num1+" x "+num2+" = "+resultado);
			break;
		case 4:
			resultado=div(num1, num2);
			System.out.println(num1+" / "+num2+" = "+resultado);
			break;
		case 5:
			 
			break;
		case 6:
			scn.close();
			System.out.println("FIN");
			seguir = false;
			break;
		default:
			System.out.println("Opción incorrecta");
		}
		return seguir;
	}
	
	public static double suma(double num1, double num2) {
		return num1+num2;
	}
	
	public static double resta(double num1, double num2) {
		return num1-num2;
	}
	
	public static double mult(double num1, double num2) {
		return num1*num2;
	}
	
	public static double div(double num1, double num2) {
		return num1/num2;
	}

}
