package Clase1;

public class ejer2 {

	public static void main(String[] args) {
		/*
		a-
		Variables de entrada:
		- ingresosMensuales
		- cantidadVehiculoMenor5Anios
		- cantidadInmuebles
		- poseeCapasidadEconomicaPlena

		b-
		-----------------------------------------------------------------------------------------------------------------------
		| Ingresos Altos | ingresosMensuales | cantidadVehiculoMenor5Anios | cantidadInmuebles | poseeCapasidadEconomicaPlena |
		-----------------------------------------------------------------------------------------------------------------------
		| Si pertenece   | >=$489083         | >=3 			   			   | >=3	       	   | Verdadero		      		  |
		-----------------------------------------------------------------------------------------------------------------------
		Si no cumple con las condiciones no pertenece.

		c-
		Imagen

		d-
		*/
		int cantidadVehiculoMenor5Anios, cantidadInmuebles;
		double ingresosMensuales;
		boolean poseeCapasidadEconomicaPlena;

		//persona
		ingresosMensuales=500000;
		cantidadVehiculoMenor5Anios=5;
		cantidadInmuebles=4;
		poseeCapasidadEconomicaPlena=true;

		if(ingresosMensuales>=489083 && cantidadVehiculoMenor5Anios>=3 && cantidadInmuebles>=3 && poseeCapasidadEconomicaPlena) {
			System.out.println("Es una persona con ingresos altos");
		}else {
			System.out.println("No es una persona con ingresos altos");
		}
	}

}
