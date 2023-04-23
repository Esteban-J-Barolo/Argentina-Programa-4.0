package Clase8;

public class DescuentoPorcentajeConTope extends Descuento {

	@Override
	public double aplicarDescuento(double precio) throws DescuentoException {
		double tope = precio * this.valor;
		
		if (tope > 600) {
			if(precio - 600<=0)throw new DescuentoException();
			return precio - 600;
		}
		else {
			if(precio - tope<=0)throw new DescuentoException();
			return precio - tope;
		}
	}

}
