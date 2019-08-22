package com.HelpDesk.HelpDesk.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "sig_datos_empleado")
public class DatosEmpleado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8905374584710838458L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ruc", nullable = false)
	private Long ruc;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Login login;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "ordgas_id_orden")
	private OrdenGastos ordenGastos;

	@Column(name = "datemp_nombre")
	private String datempNombre;

	@Column(name = "datemp_cargo")
	private String dateCargo;

	@Column(name = " datemp_fecha_ini")
	private Timestamp fechaIni;

	@Column(name = "datemp_fecha_fin")
	private Timestamp fechaFin;

	@Column(name = " datemp_modificacio ")
	private String fechaHoraModificacion;

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
	 * @return the login
	 */
	public Login getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(Login login) {
		this.login = login;
	}

	/**
	 * @return the ordenGastos
	 */
	public OrdenGastos getOrdenGastos() {
		return ordenGastos;
	}

	/**
	 * @param ordenGastos the ordenGastos to set
	 */
	public void setOrdenGastos(OrdenGastos ordenGastos) {
		this.ordenGastos = ordenGastos;
	}

	/**
	 * @return the datempNombre
	 */
	public String getDatempNombre() {
		return datempNombre;
	}

	/**
	 * @param datempNombre the datempNombre to set
	 */
	public void setDatempNombre(String datempNombre) {
		this.datempNombre = datempNombre;
	}

	/**
	 * @return the dateCargo
	 */
	public String getDateCargo() {
		return dateCargo;
	}

	/**
	 * @param dateCargo the dateCargo to set
	 */
	public void setDateCargo(String dateCargo) {
		this.dateCargo = dateCargo;
	}

	/**
	 * @return the fechaIni
	 */
	public Timestamp getFechaIni() {
		return fechaIni;
	}

	/**
	 * @param fechaIni the fechaIni to set
	 */
	public void setFechaIni(Timestamp fechaIni) {
		this.fechaIni = fechaIni;
	}

	/**
	 * @return the fechaFin
	 */
	public Timestamp getFechaFin() {
		return fechaFin;
	}

	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(Timestamp fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * @return the fechaHoraModificacion
	 */
	public String getFechaHoraModificacion() {
		return fechaHoraModificacion;
	}

	/**
	 * @param fechaHoraModificacion the fechaHoraModificacion to set
	 */
	public void setFechaHoraModificacion(String fechaHoraModificacion) {
		this.fechaHoraModificacion = fechaHoraModificacion;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DatosEmpleado [ruc=" + ruc + ", login=" + login + ", ordenGastos=" + ordenGastos + ", datempNombre="
				+ datempNombre + ", dateCargo=" + dateCargo + ", fechaIni=" + fechaIni + ", fechaFin=" + fechaFin
				+ ", fechaHoraModificacion=" + fechaHoraModificacion + "]";
	}

}