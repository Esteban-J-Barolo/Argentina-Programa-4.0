package Clase5;

public class DescuentoPorcentajeConTope extends Descuento {

	@Override
	public double aplicarDescuento(double precio) {
		double tope = precio * this.valor;
		 if (tope > 600)
			 return precio - 600;
		 else
			 return precio - tope;
	}

}
