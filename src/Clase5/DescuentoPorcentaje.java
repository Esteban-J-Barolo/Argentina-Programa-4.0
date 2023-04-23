package Clase5;

public class DescuentoPorcentaje extends Descuento {

	public double aplicarDescuento(double precio) {
		return precio - (precio*this.valor);
	}

}
