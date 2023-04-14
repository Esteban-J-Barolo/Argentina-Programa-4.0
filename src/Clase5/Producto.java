package Clase5;

public class Producto {
	
	private int id;
	private String nom;
	private double precio;
	private double desc;
	
	public Producto(int id, String nombre, double precio, double descuento) {
		this.id=id;
		this.nom=nombre;
		this.precio=precio;
		this.desc=descuento;
	}
	
	public double precio() {
		return precio;
	}

}
