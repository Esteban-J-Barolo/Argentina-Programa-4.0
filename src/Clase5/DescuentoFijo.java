package Clase5;

public class DescuentoFijo extends Descuento {

	public double aplicarDescuento(double precio) {
		return precio - this.valor;
	}

}
