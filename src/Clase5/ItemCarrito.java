package Clase5;

public class ItemCarrito {
	
	private Carrito num;
	private Producto prod;
	private int cant;
	private double montoItem;
	
	public ItemCarrito(Carrito numero, Producto producto, int cantidad) {
		this.num=numero;
		this.prod=producto;
		this.cant=cantidad;
		this.montoItem=producto.precio()*cantidad;
		this.num.sumarMonto(this.montoItem);
	}

}
