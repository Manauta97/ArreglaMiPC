package clases;
/*
* @author Raul Manauta
* @version 1.0
*/

public class Articulos {
	private String codigoArticulo;
	private double precio;
	
	public Articulos(String codigoArticulo, double precio) {
		
		this.codigoArticulo = codigoArticulo;
		this.precio = precio;
	}

	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Articulos [codigoArticulo=" + codigoArticulo + ", precio=" + precio + "]";
	}
	
	
	
}
