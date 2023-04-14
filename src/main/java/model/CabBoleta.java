package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tb_cab_boleta database table.
 * 
 */
@Entity
@Table(name="tb_cab_boleta")
@NamedQuery(name="CabBoleta.findAll", query="SELECT c FROM CabBoleta c")
public class CabBoleta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="num_bol")
	private int numBol;

	@Temporal(TemporalType.DATE)
	@Column(name="fch_bol")
	private Date fchBol;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="cod_usua")
	private Usuario tbUsuario;

	//bi-directional many-to-one association to DetBoleta
	@OneToMany(mappedBy="tbCabBoleta")
	private List<DetBoleta> tbDetBoletas;

	public CabBoleta() {
	}

	public int getNumBol() {
		return this.numBol;
	}

	public void setNumBol(int numBol) {
		this.numBol = numBol;
	}

	public Date getFchBol() {
		return this.fchBol;
	}

	public void setFchBol(Date fchBol) {
		this.fchBol = fchBol;
	}

	public Usuario getTbUsuario() {
		return this.tbUsuario;
	}

	public void setTbUsuario(Usuario tbUsuario) {
		this.tbUsuario = tbUsuario;
	}

	public List<DetBoleta> getTbDetBoletas() {
		return this.tbDetBoletas;
	}

	public void setTbDetBoletas(List<DetBoleta> tbDetBoletas) {
		this.tbDetBoletas = tbDetBoletas;
	}

	public DetBoleta addTbDetBoleta(DetBoleta tbDetBoleta) {
		getTbDetBoletas().add(tbDetBoleta);
		tbDetBoleta.setTbCabBoleta(this);

		return tbDetBoleta;
	}

	public DetBoleta removeTbDetBoleta(DetBoleta tbDetBoleta) {
		getTbDetBoletas().remove(tbDetBoleta);
		tbDetBoleta.setTbCabBoleta(null);

		return tbDetBoleta;
	}

}