package Clase5;

public class Carrito {

	private int numero;
	private Cliente cliente;
	private double montoTotal;
	
	public Carrito(int numero, Cliente cliente) {
		this.numero=numero;
		this.cliente=cliente;
		this.montoTotal=0.0;
	}
	
	public void sumarMonto(double precio) {
		this.montoTotal+=precio;
	}
	
	public double getMonto() {
		return montoTotal;
	}
	
	public void precio() {
		System.out.println("Monto TOTAL: "+this.montoTotal);
	}
}
