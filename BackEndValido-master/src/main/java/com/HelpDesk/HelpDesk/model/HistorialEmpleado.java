package com.HelpDesk.HelpDesk.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "sig_historial_empleados")
public class HistorialEmpleado implements Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = 8749383183007601847L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "histemp_id_historial", nullable = false)
	private Long histEmp;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "ruc ")
	private DatosEmpleado datosEmpleado;

	@Column(name = " histemp_modificacion")
	private String modificacion;

	@Column(name = " histemp_fecha_hora")
	private Timestamp modificacionFechaHora;

	/**
	 * @return the histEmp
	 */
	public Long getHistEmp() {
		return histEmp;
	}

	/**
	 * @param histEmp the histEmp to set
	 */
	public void setHistEmp(Long histEmp) {
		this.histEmp = histEmp;
	}

	/**
	 * @return the datosEmpleado
	 */
	public DatosEmpleado getDatosEmpleado() {
		return datosEmpleado;
	}

	/**
	 * @param datosEmpleado the datosEmpleado to set
	 */
	public void setDatosEmpleado(DatosEmpleado datosEmpleado) {
		this.datosEmpleado = datosEmpleado;
	}

	/**
	 * @return the modificacion
	 */
	public String getModificacion() {
		return modificacion;
	}

	/**
	 * @param modificacion the modificacion to set
	 */
	public void setModificacion(String modificacion) {
		this.modificacion = modificacion;
	}

	/**
	 * @return the modificacionFechaHora
	 */
	public Timestamp getModificacionFechaHora() {
		return modificacionFechaHora;
	}

	/**
	 * @param modificacionFechaHora the modificacionFechaHora to set
	 */
	public void setModificacionFechaHora(Timestamp modificacionFechaHora) {
		this.modificacionFechaHora = modificacionFechaHora;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HistorialEmpleado [histEmp=" + histEmp + ", datosEmpleado=" + datosEmpleado + ", modificacion="
				+ modificacion + ", modificacionFechaHora=" + modificacionFechaHora + "]";
	}

}