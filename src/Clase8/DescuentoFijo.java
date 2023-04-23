package Clase8;

public class DescuentoFijo extends Descuento {

	public double aplicarDescuento(double precio) throws DescuentoException {
		double ret= precio - this.valor;
		if(ret<=0) throw new DescuentoException();
		return ret;
	}

}
