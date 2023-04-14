package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the tb_det_boleta database table.
 * 
 */
@Entity
@Table(name="tb_det_boleta")
@NamedQuery(name="DetBoleta.findAll", query="SELECT d FROM DetBoleta d")
public class DetBoleta implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DetBoletaPK id;

	private int cantidad;

	private BigDecimal preciovta;

	//bi-directional many-to-one association to CabBoleta
	@ManyToOne
	@JoinColumn(name="num_bol", updatable = false, insertable = false)
	private CabBoleta tbCabBoleta;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="id_prod", updatable = false, insertable = false)
	private Producto tbProducto;

	public DetBoleta() {
	}

	public DetBoletaPK getId() {
		return this.id;
	}

	public void setId(DetBoletaPK id) {
		this.id = id;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPreciovta() {
		return this.preciovta;
	}

	public void setPreciovta(BigDecimal preciovta) {
		this.preciovta = preciovta;
	}

	public CabBoleta getTbCabBoleta() {
		return this.tbCabBoleta;
	}

	public void setTbCabBoleta(CabBoleta tbCabBoleta) {
		this.tbCabBoleta = tbCabBoleta;
	}

	public Producto getTbProducto() {
		return this.tbProducto;
	}

	public void setTbProducto(Producto tbProducto) {
		this.tbProducto = tbProducto;
	}

}