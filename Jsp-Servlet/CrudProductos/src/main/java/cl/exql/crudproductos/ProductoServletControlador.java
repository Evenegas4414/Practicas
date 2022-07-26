package cl.exql.crudproductos;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/ProductoServletControlador")
public class ProductoServletControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductoBdUtil pbdu;
	
	// Muy importante: la anotación debe ir arriba del DataSource.
	@Resource(name = "jdbc/web_productos")
	private DataSource ds;

	@Override
	public void init() throws ServletException {
		super.init();

		try {
			pbdu = new ProductoBdUtil(ds);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String comando = request.getParameter("comando");
			if (comando == null) {
				comando = "SELECT";
			}
			switch (comando) {
			case "SELECT":
				listarProductos(request, response);
				break;
			case "INSERT":
				agregarProducto(request, response);
				break;
			case "LOAD":
				cargarProducto(request, response);
				break;
			case "UPDATE":
				actualizarProducto(request, response);
				break;
			case "DELETE":
				borrarProducto(request, response);
				break;
			default:
				listarProductos(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	private void listarProductos(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<Producto> listaProductos = pbdu.obtenerProductos();
		request.setAttribute("listaProductos", listaProductos);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/lista-productos.jsp");
		dispatcher.forward(request, response);

	}
	
	private void agregarProducto(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
		String articulo = request.getParameter("articulo");
		String marca = request.getParameter("marca");
		String detalle = request.getParameter("detalle");
		int precio = Integer.parseInt(request.getParameter("precio"));
		
		Producto nuevoProducto = new Producto(articulo, marca, detalle, precio);
		pbdu.agregarProducto(nuevoProducto);
		
		listarProductos(request, response);
	}
	
	private void cargarProducto(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String idProducto = request.getParameter("idProducto");
		
		Producto p = pbdu.obtenerProducto(idProducto);
		
		request.setAttribute("producto", p);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/actualizar-producto-form.jsp");
		dispatcher.forward(request, response);		
	}	

	private void actualizarProducto(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("idProducto"));
		String articulo = request.getParameter("articulo");
		String marca = request.getParameter("marca");
		String detalle = request.getParameter("detalle");
		int precio = Integer.parseInt(request.getParameter("precio"));
		
		Producto p = new Producto(id, articulo, marca, detalle, precio);
		
		pbdu.actualizarProducto(p);
		
		listarProductos(request, response);
		
	}
	
	private void borrarProducto(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String idProducto = request.getParameter("idProducto");
		pbdu.borrarProducto(idProducto);
		
		listarProductos(request, response);
		
	}

}
