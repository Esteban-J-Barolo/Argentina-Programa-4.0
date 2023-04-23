package Clase5;

public abstract class Descuento {
	double valor;
	
	public double getValorDesc() {
		return valor;
	}
	public void setValorDesc(double valor) {
		this.valor = valor;
	}
	
	public abstract double aplicarDescuento(double precio);
}
