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
@Table(name = "uzotcertificado")
public class Certificado implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1776872328946084386L;

	@Id
	@Column(name = "certificado_codigo_presupuestario", nullable = false)
	private Long codigo;
	@Column(name = "certificado_item_presupuestario")
	private String item;
	@Column(name = "certificado_valor_certificado")
	private Float valor;
	@Column(name = "certificado_gasto_afectuar")
	private Float afectuar;
	/**
	 * @return the codigo
	 */
	public Long getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return the item
	 */
	public String getItem() {
		return item;
	}
	/**
	 * @param item the item to set
	 */
	public void setItem(String item) {
		this.item = item;
	}
	/**
	 * @return the valor
	 */
	public Float getValor() {
		return valor;
	}
	/**
	 * @param valor the valor to set
	 */
	public void setValor(Float valor) {
		this.valor = valor;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Certificado [codigo=" + codigo + ", item=" + item + ", valor=" + valor + ", afectuar=" + afectuar + "]";
	}
		
}
