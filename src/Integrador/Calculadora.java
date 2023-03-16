package Integrador;

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
		System.out.print("Opción: ");
		opc = scn.nextInt();
		switch (opc) {
		case 1:
			suma();
			break;
		case 2:
			resta();
			break;
		case 3:
			mult();
			break;
		case 4:
			div();
			break;
		case 5:
			break;
		case 6:
			scn.close();
			seguir = false;
			break;
		}
		return seguir;
	}
	
	public static void suma() {
		System.out.print("Número 1: ");
		Scanner scn = new Scanner(System.in);
		int num1, num2;
		num1 = scn.nextInt();
		System.out.print("Número 2: ");
		num2 = scn.nextInt();
		System.out.println(num1+" + "+num2+" = "+(num1+num2));
		try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println("nada");
        }
	}
	
	public static void resta() {
		System.out.print("Número 1: ");
		Scanner scn = new Scanner(System.in);
		int num1, num2;
		num1 = scn.nextInt();
		System.out.print("Número 2: ");
		num2 = scn.nextInt();
		System.out.println(num1+" - "+num2+" = "+(num1-num2));
	}
	
	public static void mult() {
		System.out.print("Número 1: ");
		Scanner scn = new Scanner(System.in);
		int num1, num2;
		num1 = scn.nextInt();
		System.out.print("Número 2: ");
		num2 = scn.nextInt();
		System.out.println(num1+" x "+num2+" = "+(num1*num2));
	}
	
	public static void div() {
		System.out.print("Dividendo: ");
		Scanner scn = new Scanner(System.in);
		int num1, num2;
		num1 = scn.nextInt();
		System.out.print("Divisor: ");
		num2 = scn.nextInt();
		System.out.println(num1+" / "+num2+" = "+(num1/num2));
	}

}
