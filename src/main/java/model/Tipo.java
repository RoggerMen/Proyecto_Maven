package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_tipos database table.
 * 
 */
@Entity
@Table(name="tb_tipos")
@NamedQuery(name="Tipo.findAll", query="SELECT t FROM Tipo t")
public class Tipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idtipo;

	private String descripcion;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="tbTipo")
	private List<Usuario> tbUsuarios;

	public Tipo() {
	}

	public int getIdtipo() {
		return this.idtipo;
	}

	public void setIdtipo(int idtipo) {
		this.idtipo = idtipo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Usuario> getTbUsuarios() {
		return this.tbUsuarios;
	}

	public void setTbUsuarios(List<Usuario> tbUsuarios) {
		this.tbUsuarios = tbUsuarios;
	}

	public Usuario addTbUsuario(Usuario tbUsuario) {
		getTbUsuarios().add(tbUsuario);
		tbUsuario.setTbTipo(this);

		return tbUsuario;
	}

	public Usuario removeTbUsuario(Usuario tbUsuario) {
		getTbUsuarios().remove(tbUsuario);
		tbUsuario.setTbTipo(null);

		return tbUsuario;
	}

}