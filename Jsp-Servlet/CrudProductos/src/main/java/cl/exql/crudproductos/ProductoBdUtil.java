package cl.exql.crudproductos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class ProductoBdUtil {

	private DataSource ds;
	private String SQL_SELECT = "SELECT * FROM PRODUCTOS;";
	private String SQL_INSERT = "INSERT INTO PRODUCTOS (ARTICULO, MARCA, DETALLE, PRECIO)" 
			+ " VALUES (?, ?, ?, ?);";
	private String SQL_LOAD = "SELECT * FROM PRODUCTOS WHERE id=?;";
	private String SQL_UPDATE = "UPDATE PRODUCTOS SET ARTICULO=?, MARCA=?, DETALLE=?, PRECIO=?"
			+ " WHERE id=?;";
	private String SQL_DELETE = "DELETE FROM PRODUCTOS WHERE ID=?;";

	public ProductoBdUtil(DataSource ds) {
		this.ds = ds;
	}

	public List<Producto> obtenerProductos() throws Exception {
		List<Producto> productos = new ArrayList<Producto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL_SELECT);
			while (rs.next()) {
				int id = rs.getInt(1);
				String articulo = rs.getString(2);
				String marca = rs.getString(3);
				String detalle = rs.getString(4);
				int precio = rs.getInt(5);
				Producto p = new Producto(id, articulo, marca, detalle, precio);
				productos.add(p);
			}
			return productos;
		} finally {
			cerrarRecursos(conn, stmt, rs);
		}
	}

	public void agregarProducto(Producto p) throws Exception {

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(SQL_INSERT);
			
			pstmt.setString(1, p.getArticulo());
			pstmt.setString(2, p.getMarca());
			pstmt.setString(3, p.getDetalle());			
			pstmt.setInt(4, p.getPrecio());
			
			pstmt.execute();			
		} finally {
			cerrarRecursos(conn, pstmt, null);
		}

	}

	public Producto obtenerProducto(String idProducto) throws Exception {
		Producto producto = null;		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int id;
		try {
			
			id = Integer.parseInt(idProducto);
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(SQL_LOAD);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String articulo = rs.getString(2);
				String marca = rs.getString(3);
				String detalle = rs.getString(4);
				int precio = rs.getInt(5);
				
				producto = new Producto(articulo, marca, detalle, precio);
			} else {
				throw new Exception("No se ha encontrado el producto con id=" + id + ".");
			}
			return producto;
		} finally {
			cerrarRecursos(conn, pstmt, rs);
		}
	} 
	
	public void actualizarProducto(Producto p) throws Exception {

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(SQL_UPDATE);
			
			pstmt.setString(1, p.getArticulo());
			pstmt.setString(2, p.getMarca());
			pstmt.setString(3, p.getDetalle());			
			pstmt.setInt(4, p.getPrecio());
			pstmt.setInt(5, p.getId());
			
			pstmt.execute();			
		} finally {
			cerrarRecursos(conn, pstmt, null);
		}

	}
	
	public void borrarProducto(String idProducto) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int id = Integer.parseInt(idProducto);
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(SQL_DELETE);
			pstmt.setInt(1, id);
			
			pstmt.execute();			
		} finally {
			cerrarRecursos(conn, pstmt, null);
		}
		
	}

	public void cerrarRecursos(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}

			if (stmt != null) {
				stmt.close();
			}

			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
