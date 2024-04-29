package ar.edu.unju.fi.ejercicio2.model;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;

public class Efemeride {
	private Integer codigo;
	private Mes mesEfem;
	private Byte dia;
	private String detalle;
	
	
	public Efemeride() {
	}


	public Efemeride(Integer codigo, Mes mesEfem, Byte dia, String detalle) {
		this.codigo = codigo;
		this.mesEfem = mesEfem;
		this.dia = dia;
		this.detalle = detalle;
	}


	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public Mes getMesEfem() {
		return mesEfem;
	}


	public void setMesEfem(Mes mesEfem) {
		this.mesEfem = mesEfem;
	}


	public Byte getDia() {
		return dia;
	}


	public void setDia(Byte dia) {
		this.dia = dia;
	}


	public String getDetalle() {
		return detalle;
	}


	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}


	@Override
	public String toString() {
		return "\nCodigo=" + codigo +
				"\nMes=" + mesEfem +
				"\nDia=" + dia +
				"\nDetalle=" + detalle;
	}
	
	
	
}
