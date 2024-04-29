package ar.edu.unju.fi.ejercicio4.model;

import java.time.LocalDate;
import java.time.Period;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;

public class Jugador {
	private String nombreJug;
	private String apellidoJug;
	private LocalDate fechaNacJug;
	private String nacionalidadJug;
	private Integer alturaJug;
	private Integer pesoJug;
	private Posicion posicionJug;
	
	
	public Jugador() {
	}


	public Jugador(String nombreJug, String apellidoJug, LocalDate fechaNacJug, String nacionalidadJug,
			Integer alturaJug, Integer pesoJug, Posicion posicionJug) {
		this.nombreJug = nombreJug;
		this.apellidoJug = apellidoJug;
		this.fechaNacJug = fechaNacJug;
		this.nacionalidadJug = nacionalidadJug;
		this.alturaJug = alturaJug;
		this.pesoJug = pesoJug;
		this.posicionJug = posicionJug;
	}

	
	

	@Override
	public String toString() {
		return "\nNombre=" + nombreJug +
				"\nApellido=" + apellidoJug +
				"\nFecha de Nacimiento=" + fechaNacJug+
				"\nNacionalidad=" + nacionalidadJug + 
				"\nEdad=" + calcularEdad() +
				"\nAltura=" + alturaJug + 
				"\nPeso=" + pesoJug + 
				"\nPosición=" + posicionJug;
		
	}


	public String getNombreJug() {
		return nombreJug;
	}


	public void setNombreJug(String nombreJug) {
		this.nombreJug = nombreJug;
	}


	public String getApellidoJug() {
		return apellidoJug;
	}


	public void setApellidoJug(String apellidoJug) {
		this.apellidoJug = apellidoJug;
	}


	public LocalDate getFechaNacJug() {
		return fechaNacJug;
	}


	public void setFechaNacJug(LocalDate fechaNacJug) {
		this.fechaNacJug = fechaNacJug;
	}


	public String getNacionalidadJug() {
		return nacionalidadJug;
	}


	public void setNacionalidadJug(String nacionalidadJug) {
		this.nacionalidadJug = nacionalidadJug;
	}


	public Integer getAlturaJug() {
		return alturaJug;
	}


	public void setAlturaJug(Integer alturaJug) {
		this.alturaJug = alturaJug;
	}


	public Integer getPesoJug() {
		return pesoJug;
	}


	public void setPesoJug(Integer pesoJug) {
		this.pesoJug = pesoJug;
	}


	public Posicion getPosicionJug() {
		return posicionJug;
	}


	public void setPosicionJug(Posicion posicionJug) {
		this.posicionJug = posicionJug;
	}
	
	public Integer calcularEdad() {
		LocalDate hoy = LocalDate.now();
		Period periodo = Period.between(this.fechaNacJug, hoy);
		return periodo.getYears();
	}
	
}