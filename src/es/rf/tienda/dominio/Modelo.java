package es.rf.tienda.dominio;

public abstract class Modelo implements Cloneable {

	private String pk = "id_categoria";
	private String tabla = "categoria";
	
	public Modelo(String tabla, String pk) {
		this.setTabla(tabla);
		this.setPk(pk);
	}

	public String getNombrePk() {
		return pk;
	}

	public void setPk(String pk) {
		this.pk = pk;
	}

	public String getTabla() {
		return tabla;
	}

	public void setTabla(String tabla) {
		this.tabla = tabla;
	}

	public Object clone() {
		try {
			return super.clone();
			
		}catch (Exception e) {
			return null;
		}
	}
	
	public abstract boolean isValid();
	public abstract int getId();
	public abstract void setId(int id);
	public abstract String[] toArray();
	public abstract Categoria clean();
	
	
}
