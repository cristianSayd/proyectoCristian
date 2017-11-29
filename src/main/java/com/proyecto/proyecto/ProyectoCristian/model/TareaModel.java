package com.proyecto.proyecto.ProyectoCristian.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import com.fasterxml.jackson.annotation.JsonFormat;
public class TareaModel {
	private String idTarea;
	private String nombre;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date fechaInicio;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date fechaFin;
	
	
	private String idPadre;
	private Integer nivel;
	
	
	public TareaModel() {
		
	}
	


	public TareaModel(String idTarea, String nombre, Date fechaInicio, Date fechaFin, String idPadre, Integer nivel) {
		super();
		this.idTarea = idTarea;
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.idPadre = idPadre;
		this.nivel = nivel;
	}



	public String getIdTarea() {
		return idTarea;
	}


	public void setIdTarea(String idTarea) {
		this.idTarea = idTarea;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Date getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public Date getFechaFin() {
		return fechaFin;
	}


	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}


	public String getIdPadre() {
		return idPadre;
	}


	public void setIdPadre(String idPadre) {
		this.idPadre = idPadre;
	}


	public Integer getNivel() {
		return nivel;
	}


	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}


	

}
