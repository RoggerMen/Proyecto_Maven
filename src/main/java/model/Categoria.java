package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_categorias database table.
 * 
 */
@Entity
@Table(name="tb_categorias")
@NamedQuery(name="Categoria.findAll", query="SELECT c FROM Categoria c")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idcategoria;

	private String descripcion;

	//bi-directional many-to-one association to Producto
	@OneToMany(mappedBy="tbCategoria")
	private List<Producto> tbProductos;

	public Categoria() {
	}

	public int getIdcategoria() {
		return this.idcategoria;
	}

	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Producto> getTbProductos() {
		return this.tbProductos;
	}

	public void setTbProductos(List<Producto> tbProductos) {
		this.tbProductos = tbProductos;
	}

	public Producto addTbProducto(Producto tbProducto) {
		getTbProductos().add(tbProducto);
		tbProducto.setTbCategoria(this);

		return tbProducto;
	}

	public Producto removeTbProducto(Producto tbProducto) {
		getTbProductos().remove(tbProducto);
		tbProducto.setTbCategoria(null);

		return tbProducto;
	}

}