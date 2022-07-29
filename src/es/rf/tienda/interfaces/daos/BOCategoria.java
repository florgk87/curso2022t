package es.rf.tienda.interfaces.daos;

import java.sql.ResultSet;
import java.sql.SQLException;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.exception.DomainException;
import es.rf.tienda.util.Rutinas;

public class BOCategoria extends CategoriaDAO<Categoria> {
	  
	public BOCategoria() {
		super(new Categoria(null, null));
	}
	
	public String obtenLista(Categoria clase, String separador) {
		
		String salida = "";
		if (clase.getId_categoria() > 0) {
			salida = Rutinas.addCampo(salida, "id_Categoria", clase.getId_categoria(), separador);
			
		}
		if ((clase.getCat_nombre() != null && clase.getCat_nombre().compareTo("") !=0) || separador.equals(",")) {
			salida = Rutinas.addCampo(salida, "cat_nombre", clase.getCat_nombre(), separador);
						
		}		
		if ((clase.getCat_descripcion() != null && clase.getCat_descripcion().compareTo("") !=0) || separador.equals(",")) {
			salida = Rutinas.addCampo(salida, "cat_descripcion", clase.getCat_descripcion(), separador);
			
		}	
		return salida;
	}
	
	
	public String obtenInsert(Categoria clase) {
		String salida = "";
		salida = Rutinas.addCampo(salida, "id_Categoria", clase.getId_categoria(), ",");
		salida = Rutinas.addCampo(salida, "cat_nombre", clase.getCat_nombre(), ",");		
		salida = Rutinas.addCampo(salida, "cat_descripcion", clase.getCat_descripcion(), ",");
		return salida;
	}
	
	public Categoria montarRegistro(ResultSet rs) throws DAOException, DomainException  {
		Categoria salida = new Categoria();
		try {
			salida.setId_categoria(rs.getInt("Id_categoria"));
			salida.setCat_nombre(rs.getString("Cat_nombre"));
			salida.setCat_descripcion(rs.getString("Cat_descripcion"));
			
		}catch (SQLException e) {
			throw new DAOException("Error " + e.getMessage() + "\nen montarRegistro" );
		}
		return salida;
	
	}
	
			
	public list<Categoria> leerSQL(String where) throws DAOException, DomainException {
		String sql = SELECT + "WHERE" + where;
		return montarLista(sql);
	}
	
	@Override
	public boolean borra(Categoria clase) throws DAOException {
		String where  = obtenWhere(clase);
		String sql = DELETE+ where;
		return RFDataConnection.ejecutar(sql) >0;
	}
	
	private String obtenWhere(Categoria clase) {
		String salida = obtenLista(clase, "AND");
		if (salida.length()> 0)
			salida = "WHERE " + salida;
		return salida;
	}
	
	private String obtenUpdate(Categoria clase) {
		return obtenLista(clase,"");
	}
	
}
