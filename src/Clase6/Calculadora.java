package Clase6;

import java.util.Scanner;

public class Calculadora {

public static void main(String[] args) {

		Scanner ingreso = new Scanner(System.in);
		double n1, n2, resultado;
		int opcion;
		boolean operador = true;
		
		while(operador) {
			System.out.println("MENU");
			System.out.println("1. Sumar");
			System.out.println("2. Restar");
			System.out.println("3. Multiplicar");
			System.out.println("4. Dividir");
			System.out.println("5. Salir");
			System.out.print("Seleccionar Opcion: ");
			opcion = ingreso.nextInt();
			
			if(opcion == 5) {
				System.out.println("Finalizado.....");
				break;
			}else {
				switch(opcion) {
				case 1:
					System.out.print("1er valor: ");
					n1 = ingreso.nextInt();
					System.out.print("2do valor: ");
					n2 = ingreso.nextInt();
					resultado = Operador.sumar(n1, n2);
					System.out.println("La suma es: " + resultado);						
					break;
				case 2:
					System.out.print("1er valor: ");
					n1 = ingreso.nextInt();
					System.out.print("2do valor: ");
					n2 = ingreso.nextInt();
					resultado = Operador.restar(n1, n2);
					System.out.println("La resta es: " + resultado);	
					break;
					
				case 3:
					System.out.print("1er valor: ");
					n1 = ingreso.nextInt();
					System.out.print("2do valor: ");
					n2 = ingreso.nextInt();
					resultado = Operador.multiplicar(n1, n2);
					System.out.println("El producto es: " + resultado);						
					break;
					
				case 4:
					System.out.print("1er valor: ");
					n1 = ingreso.nextInt();
					System.out.print("2do valor: ");
					n2 = ingreso.nextInt();
					resultado = Operador.dividir(n1, n2);
					System.out.println("La division es: " + resultado);						
					break;
				default:
					System.out.print("Opcion no valida.....");
				}
			}
		}
		
	}

}
