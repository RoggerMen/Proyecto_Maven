package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the tb_productos database table.
 * 
 */
@Entity
@Table(name="tb_productos")
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_prod")
	private String idProd;

	@Column(name="des_prod")
	private String desProd;

	@Column(name="est_prod")
	private byte estProd;

	@Column(name="pre_prod")
	private BigDecimal preProd;

	@Column(name="stk_prod")
	private int stkProd;

	//bi-directional many-to-one association to DetBoleta
	@OneToMany(mappedBy="tbProducto")
	private List<DetBoleta> tbDetBoletas;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="idcategoria")
	private Categoria tbCategoria;

	//bi-directional many-to-one association to Proveedor
	@ManyToOne
	@JoinColumn(name="idproveedor")
	private Proveedor tbProveedor;

	public Producto() {
	}

	public String getIdProd() {
		return this.idProd;
	}

	public void setIdProd(String idProd) {
		this.idProd = idProd;
	}

	public String getDesProd() {
		return this.desProd;
	}

	public void setDesProd(String desProd) {
		this.desProd = desProd;
	}

	public byte getEstProd() {
		return this.estProd;
	}

	public void setEstProd(byte estProd) {
		this.estProd = estProd;
	}

	public BigDecimal getPreProd() {
		return this.preProd;
	}

	public void setPreProd(BigDecimal preProd) {
		this.preProd = preProd;
	}

	public int getStkProd() {
		return this.stkProd;
	}

	public void setStkProd(int stkProd) {
		this.stkProd = stkProd;
	}

	public List<DetBoleta> getTbDetBoletas() {
		return this.tbDetBoletas;
	}

	public void setTbDetBoletas(List<DetBoleta> tbDetBoletas) {
		this.tbDetBoletas = tbDetBoletas;
	}

	public DetBoleta addTbDetBoleta(DetBoleta tbDetBoleta) {
		getTbDetBoletas().add(tbDetBoleta);
		tbDetBoleta.setTbProducto(this);

		return tbDetBoleta;
	}

	public DetBoleta removeTbDetBoleta(DetBoleta tbDetBoleta) {
		getTbDetBoletas().remove(tbDetBoleta);
		tbDetBoleta.setTbProducto(null);

		return tbDetBoleta;
	}

	public Categoria getTbCategoria() {
		return this.tbCategoria;
	}

	public void setTbCategoria(Categoria tbCategoria) {
		this.tbCategoria = tbCategoria;
	}

	public Proveedor getTbProveedor() {
		return this.tbProveedor;
	}

	public void setTbProveedor(Proveedor tbProveedor) {
		this.tbProveedor = tbProveedor;
	}

}