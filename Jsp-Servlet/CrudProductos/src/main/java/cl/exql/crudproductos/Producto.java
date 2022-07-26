package cl.exql.crudproductos;

public class Producto {
	
	private int id;
	private String articulo;
	private String marca;
	private String detalle;
	private int precio;
	
	public Producto(int id, String articulo, String marca, String detalle, int precio) {
		this.id = id;
		this.articulo = articulo;
		this.marca = marca;
		this.detalle = detalle;
		this.precio = precio;
	}
	
	public Producto(String articulo, String marca, String detalle, int precio) {
		this.articulo = articulo;
		this.marca = marca;
		this.detalle = detalle;
		this.precio = precio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArticulo() {
		return articulo;
	}

	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", articulo=" + articulo + ", marca=" + marca + ", detalle=" + detalle
				+ ", precio=" + precio + "]";
	}	

}
