package Clase8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ComprasCarrito {

	public static void main(String[] args) {
		List<ItemCarrito> listaItems1 = new ArrayList<ItemCarrito>();
		List<ItemCarrito> listaItems2 = new ArrayList<ItemCarrito>();
		
		Producto item1= new Producto(1,"Leche", 210, 20.5);
		Producto item2= new Producto(2,"Manteca", 450, 50);
		Producto item3= new Producto(3,"Queso", 149.99, 40);
		
		Cliente cli1 = new Cliente(1,"Esteban");
		
		Carrito carro1 = new Carrito(1,cli1);
		
		ItemCarrito fila1 = new ItemCarrito(carro1,item1,1);
		ItemCarrito fila2 = new ItemCarrito(carro1,item2,20);
		ItemCarrito fila3 = new ItemCarrito(carro1,item3,1);
		
		listaItems1.add(fila1);
		listaItems1.add(fila2);
		listaItems1.add(fila3);
		
		Carrito carro2 = new Carrito(1,new Cliente(1,"Esteban"));
		
		String str = "C:\\Users\\Esteban\\Desktop\\Arg Prog\\lista.txt";
		Path archivo = Paths.get(str);
		try {
			for (String linea : Files.readAllLines(archivo)) {
				String fila[] = linea.split("\t");
				listaItems2.add(new ItemCarrito(carro2,new Producto(1,fila[2], Integer.parseInt(fila[1]), 0.0),Integer.parseInt(fila[0])));
			}
		} catch (IOException e) {
			System.out.println("No existe el archivo");
		}
		
		carro1.precio();
		carro2.precio();
		
		aplicarDescuento(carro1.getMonto());
		aplicarDescuento(carro2.getMonto());

	}
	
	public static void aplicarDescuento(double monto) {
		final double montoMinimo = 5000;
		
		LocalDate fecha = LocalDate.now();
		int dia = fecha.getDayOfMonth();
		
		if (dia%2!=0) {
			Descuento descuentoF = new DescuentoFijo();
			descuentoF.setValorDesc(349.99);
			try {
				System.out.println("Monto del Carrito con Descuento Fijo: "+descuentoF.aplicarDescuento(monto));
			} catch (DescuentoException e) {
				e.mensaje();
			}
		}
		else {
			Descuento descuentoP = new DescuentoPorcentaje();
			if(monto < montoMinimo) {
				descuentoP.setValorDesc(0.15);	
			}
			else
				descuentoP.setValorDesc(0.25);
			try {
				System.out.println("Monto del Carrito con Descuento Porcentaje: "+descuentoP.aplicarDescuento(monto));
			} catch (DescuentoException e) {
				e.mensaje();
			}
		}
		
	}

}
