package es.rf.tienda.dominio;

import java.util.Date;

public class Producto {

	private String id_producto;			// Código de producto
	private String pro_descripcion; // Descripcion corta
	private String pro_desLarga;    // Explicacion
	private Double pro_precio;      // Precio
	private int pro_stock;          // Stock
	private Date pro_fecRepos;		// Fecha prevista reposicion
	private Date pro_fecActi;		// Fecha activacion
	private Date pro_fecDesacti;	// Fecha desactivacion
	private String pro_uniVenta;	// Unidad de venta
	private Double pro_cantXUniVenta; // Cantidad de unidades ultimas
	private String pro_uniUltNivel;   // Unidad ultima
	private int id_pais;			  // Pais deorigen
	private String pro_usoRecomendado; // Uso recomendado
	private int id_categoria; 		   // Categoria
	private int pro_stkReservado;	   // Stock reservado
	private int pro_nStkAlto;		   // Stock para nivel alto
	private int pro_nStkBajo;		   // Stock para nivel bajo
	private String pro_stat;           // Estado
	
	public String getId_producto() {
		return id_producto;
	}
	public void setId_producto(String id_producto) {
		this.id_producto = id_producto;
	}
	public String getPro_descripcion() {
		return pro_descripcion;
	}
	public void setPro_descripcion(String pro_descripcion) {
		this.pro_descripcion = pro_descripcion;
	}
	public String getPro_desLarga() {
		return pro_desLarga;
	}
	public void setPro_desLarga(String pro_desLarga) {
		this.pro_desLarga = pro_desLarga;
	}
	public Double getPro_precio() {
		return pro_precio;
	}
	public void setPro_precio(Double pro_precio) {
		this.pro_precio = pro_precio;
	}
	public int getPro_stock() {
		return pro_stock;
	}
	public void setPro_stock(int pro_stock) {
		this.pro_stock = pro_stock;
	}
	public Date getPro_fecRepos() {
		return pro_fecRepos;
	}
	public void setPro_fecRepos(Date pro_fecRepos) {
		this.pro_fecRepos = pro_fecRepos;
	}
	public Date getPro_fecActi() {
		return pro_fecActi;
	}
	public void setPro_fecActi(Date pro_fecActi) {
		this.pro_fecActi = pro_fecActi;
	}
	public Date getPro_fecDesacti() {
		return pro_fecDesacti;
	}
	public void setPro_fecDesacti(Date pro_fecDesacti) {
		this.pro_fecDesacti = pro_fecDesacti;
	}
	public String getPro_uniVenta() {
		return pro_uniVenta;
	}
	public void setPro_uniVenta(String pro_uniVenta) {
		this.pro_uniVenta = pro_uniVenta;
	}
	public Double getPro_cantXUniVenta() {
		return pro_cantXUniVenta;
	}
	public void setPro_cantXUniVenta(Double pro_cantXUniVenta) {
		this.pro_cantXUniVenta = pro_cantXUniVenta;
	}
	public String getPro_uniUltNivel() {
		return pro_uniUltNivel;
	}
	public void setPro_uniUltNivel(String pro_uniUltNivel) {
		this.pro_uniUltNivel = pro_uniUltNivel;
	}
	public int getId_pais() {
		return id_pais;
	}
	public void setId_pais(int id_pais) {
		this.id_pais = id_pais;
	}
	public String getPro_usoRecomendado() {
		return pro_usoRecomendado;
	}
	public void setPro_usoRecomendado(String pro_usoRecomendado) {
		this.pro_usoRecomendado = pro_usoRecomendado;
	}
	public int getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}
	public int getPro_stkReservado() {
		return pro_stkReservado;
	}
	public void setPro_stkReservado(int pro_stkReservado) {
		this.pro_stkReservado = pro_stkReservado;
	}
	public int getPro_nStkAlto() {
		return pro_nStkAlto;
	}
	public void setPro_nStkAlto(int pro_nStkAlto) {
		this.pro_nStkAlto = pro_nStkAlto;
	}
	public int getPro_nStkBajo() {
		return pro_nStkBajo;
	}
	public void setPro_nStkBajo(int pro_nStkBajo) {
		this.pro_nStkBajo = pro_nStkBajo;
	}
	public String getPro_stat() {
		return pro_stat;
	}
	public void setPro_stat(String pro_stat) {
		this.pro_stat = pro_stat;
	}


	
	
}
