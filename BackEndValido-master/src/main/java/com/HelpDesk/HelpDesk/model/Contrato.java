package com.HelpDesk.HelpDesk.model;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
@SuppressWarnings("unused")
@Entity
@Table(name = "sig_contrato")
public class Contrato implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8330918448227468374L;
	
	@Id
	@Column(name = "cont_ruc_contratista", nullable = false)
	private Long ruc;
	@Column(name = "cont_email")
	private String email;
	@Column(name = "cont_numero_contrato")
	private Integer numero;
	@Column(name = "cont_nombre_contratista")
	private String nombre;
	@Column(name = "cont_objeto_contratacion")
	private String objeto;
	/**
	 * @return the ruc
	 */
	public Long getRuc() {
		return ruc;
	}
	/**
	 * @param ruc the ruc to set
	 */
	public void setRuc(Long ruc) {
		this.ruc = ruc;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the numero
	 */
	public Integer getNumero() {
		return numero;
	}
	/**
	 * @param numero the numero to set
	 */
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the objeto
	 */
	public String getObjeto() {
		return objeto;
	}
	/**
	 * @param objeto the objeto to set
	 */
	public void setObjeto(String objeto) {
		this.objeto = objeto;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Contrato [ruc=" + ruc + ", email=" + email + ", numero=" + numero + ", nombre=" + nombre + ", objeto="
				+ objeto + "]";
	}
	
}
