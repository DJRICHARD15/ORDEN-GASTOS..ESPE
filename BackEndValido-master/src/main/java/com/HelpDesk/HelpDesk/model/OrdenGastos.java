package com.HelpDesk.HelpDesk.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sig_ordengastos")

public class OrdenGastos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9190572552288605715L;

	@Id
	@Column(name = "ordgas_id_orden")
	private Long id_orden;

	@Column(name = "ordgas_numero_contrato ")
	private Float numero_contrato;

	@Column(name = " ordgas_objeto_contra")
	private String objeto_contrato;

	@Column(name = "ordgas_nombre_contratista ")
	private String nombreContratista;

	@Column(name = "ordgas_ruc_contratista")
	private Long ruc_contratista;

	@Column(name = "ordgas_num_orden")
	private Integer numOrden;

	@Column(name = " ordgas_cantidad")
	private Integer cantidad;

	@Column(name = "ordgas_precio_unita")
	private Float precioUnitario;

	@Column(name = "ordgas_subtotal ")
	private Float subtotal;

	@Column(name = " ordgas_iva")
	private Float iva;

	@Column(name = "ordgas_otros_impuestos ")
	private Float otrosImpuestos;

	@Column(name = " ordgas_total")
	private Float total;

	@Column(name = "ordgas_cod_presupuestario")
	private Integer cod_presupuestario;

	@Column(name = "ordgas_descripcion_presupuestaria")
	private String descripcionpresupuestaria;

	@Column(name = "ordgas_valor_certificado")
	private Float valorCert;

	@Column(name = " ordgas_gasto_afectuar ")
	private Float afectuar;

	@Column(name = " ordgas_saldo ")
	private Float saldo;

	@Column(name = " ordgas_fecha_hora_inicio ")
	private Date fechaHoraIni;

	@Column(name = " ordgas_email ")
	private String email;

	@Column(name = " ordgas_descripcion ")
	private String descripcion;
	
	@Column(name = " ordgas_obtener_iva ")
	private Float obtencion_iva;
	
	@Column(name = " ordgas_obtener_otro_impuesto ")
	private Float obtencion_otro_impuesto;
	
	@Column(name = " ordgas_meses_acumulables ")
	private Integer meses_acumulables;

	@Column(name = " ordgas_tipo_pago ")
	private String tipo_pago;

	/**
	 * @return the id_orden
	 */
	public Long getId_orden() {
		return id_orden;
	}

	/**
	 * @param id_orden the id_orden to set
	 */
	public void setId_orden(Long id_orden) {
		this.id_orden = id_orden;
	}

	/**
	 * @return the numero_contrato
	 */
	public Float getNumero_contrato() {
		return numero_contrato;
	}

	/**
	 * @param numero_contrato the numero_contrato to set
	 */
	public void setNumero_contrato(Float numero_contrato) {
		this.numero_contrato = numero_contrato;
	}

	/**
	 * @return the objeto_contrato
	 */
	public String getObjeto_contrato() {
		return objeto_contrato;
	}

	/**
	 * @param objeto_contrato the objeto_contrato to set
	 */
	public void setObjeto_contrato(String objeto_contrato) {
		this.objeto_contrato = objeto_contrato;
	}

	/**
	 * @return the nombreContratista
	 */
	public String getNombreContratista() {
		return nombreContratista;
	}

	/**
	 * @param nombreContratista the nombreContratista to set
	 */
	public void setNombreContratista(String nombreContratista) {
		this.nombreContratista = nombreContratista;
	}

	/**
	 * @return the ruc_contratista
	 */
	public Long getRuc_contratista() {
		return ruc_contratista;
	}

	/**
	 * @param ruc_contratista the ruc_contratista to set
	 */
	public void setRuc_contratista(Long ruc_contratista) {
		this.ruc_contratista = ruc_contratista;
	}

	/**
	 * @return the numOrden
	 */
	public Integer getNumOrden() {
		return numOrden;
	}

	/**
	 * @param numOrden the numOrden to set
	 */
	public void setNumOrden(Integer numOrden) {
		this.numOrden = numOrden;
	}

	/**
	 * @return the cantidad
	 */
	public Integer getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the precioUnitario
	 */
	public Float getPrecioUnitario() {
		return precioUnitario;
	}

	/**
	 * @param precioUnitario the precioUnitario to set
	 */
	public void setPrecioUnitario(Float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	/**
	 * @return the subtotal
	 */
	public Float getSubtotal() {
		return subtotal;
	}

	/**
	 * @param subtotal the subtotal to set
	 */
	public void setSubtotal(Float subtotal) {
		this.subtotal = subtotal;
	}

	/**
	 * @return the iva
	 */
	public Float getIva() {
		return iva;
	}

	/**
	 * @param iva the iva to set
	 */
	public void setIva(Float iva) {
		this.iva = iva;
	}

	/**
	 * @return the otrosImpuestos
	 */
	public Float getOtrosImpuestos() {
		return otrosImpuestos;
	}

	/**
	 * @param otrosImpuestos the otrosImpuestos to set
	 */
	public void setOtrosImpuestos(Float otrosImpuestos) {
		this.otrosImpuestos = otrosImpuestos;
	}

	/**
	 * @return the total
	 */
	public Float getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(Float total) {
		this.total = total;
	}

	/**
	 * @return the cod_presupuestario
	 */
	public Integer getCod_presupuestario() {
		return cod_presupuestario;
	}

	/**
	 * @param cod_presupuestario the cod_presupuestario to set
	 */
	public void setCod_presupuestario(Integer cod_presupuestario) {
		this.cod_presupuestario = cod_presupuestario;
	}

	/**
	 * @return the descripcionpresupuestaria
	 */
	public String getDescripcionpresupuestaria() {
		return descripcionpresupuestaria;
	}

	/**
	 * @param descripcionpresupuestaria the descripcionpresupuestaria to set
	 */
	public void setDescripcionpresupuestaria(String descripcionpresupuestaria) {
		this.descripcionpresupuestaria = descripcionpresupuestaria;
	}

	/**
	 * @return the valorCert
	 */
	public Float getValorCert() {
		return valorCert;
	}

	/**
	 * @param valorCert the valorCert to set
	 */
	public void setValorCert(Float valorCert) {
		this.valorCert = valorCert;
	}

	/**
	 * @return the afectuar
	 */
	public Float getAfectuar() {
		return afectuar;
	}

	/**
	 * @param afectuar the afectuar to set
	 */
	public void setAfectuar(Float afectuar) {
		this.afectuar = afectuar;
	}

	/**
	 * @return the saldo
	 */
	public Float getSaldo() {
		return saldo;
	}

	/**
	 * @param saldo the saldo to set
	 */
	public void setSaldo(Float saldo) {
		this.saldo = saldo;
	}

	/**
	 * @return the fechaHoraIni
	 */
	public Date getFechaHoraIni() {
		return fechaHoraIni;
	}

	/**
	 * @param fechaHoraIni the fechaHoraIni to set
	 */
	public void setFechaHoraIni(Date fechaHoraIni) {
		this.fechaHoraIni = fechaHoraIni;
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
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the obtencion_iva
	 */
	public Float getObtencion_iva() {
		return obtencion_iva;
	}

	/**
	 * @param obtencion_iva the obtencion_iva to set
	 */
	public void setObtencion_iva(Float obtencion_iva) {
		this.obtencion_iva = obtencion_iva;
	}

	/**
	 * @return the obtencion_otro_impuesto
	 */
	public Float getObtencion_otro_impuesto() {
		return obtencion_otro_impuesto;
	}

	/**
	 * @param obtencion_otro_impuesto the obtencion_otro_impuesto to set
	 */
	public void setObtencion_otro_impuesto(Float obtencion_otro_impuesto) {
		this.obtencion_otro_impuesto = obtencion_otro_impuesto;
	}

	/**
	 * @return the meses_acumulables
	 */
	public Integer getMeses_acumulables() {
		return meses_acumulables;
	}

	/**
	 * @param meses_acumulables the meses_acumulables to set
	 */
	public void setMeses_acumulables(Integer meses_acumulables) {
		this.meses_acumulables = meses_acumulables;
	}

	/**
	 * @return the tipo_pago
	 */
	public String getTipo_pago() {
		return tipo_pago;
	}

	/**
	 * @param tipo_pago the tipo_pago to set
	 */
	public void setTipo_pago(String tipo_pago) {
		this.tipo_pago = tipo_pago;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrdenGastos [id_orden=" + id_orden + ", numero_contrato=" + numero_contrato + ", objeto_contrato="
				+ objeto_contrato + ", nombreContratista=" + nombreContratista + ", ruc_contratista=" + ruc_contratista
				+ ", numOrden=" + numOrden + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario
				+ ", subtotal=" + subtotal + ", iva=" + iva + ", otrosImpuestos=" + otrosImpuestos + ", total=" + total
				+ ", cod_presupuestario=" + cod_presupuestario + ", descripcionpresupuestaria="
				+ descripcionpresupuestaria + ", valorCert=" + valorCert + ", afectuar=" + afectuar + ", saldo=" + saldo
				+ ", fechaHoraIni=" + fechaHoraIni + ", email=" + email + ", descripcion=" + descripcion
				+ ", obtencion_iva=" + obtencion_iva + ", obtencion_otro_impuesto=" + obtencion_otro_impuesto
				+ ", meses_acumulables=" + meses_acumulables + ", tipo_pago=" + tipo_pago + "]";
	}
									
}