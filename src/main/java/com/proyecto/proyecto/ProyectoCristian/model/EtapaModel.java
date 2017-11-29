package com.proyecto.proyecto.ProyectoCristian.model;

import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;

public class EtapaModel {
	private String idEtapa;
	private String nombre;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date fechaInicio;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date fechaFin;
	
	private List<ActividadModel> actividades;
	
	public EtapaModel() {
		
	}

	public EtapaModel(String idEtapa, String nombre, Date fechaInicio, Date fechaFin, List<ActividadModel> actividades) {
		super();
		this.idEtapa = idEtapa;
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.actividades = actividades;
	}

	public String getIdEtapa() {
		return idEtapa;
	}

	public void setIdEtapa(String idEtapa) {
		this.idEtapa = idEtapa;
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

	public List<ActividadModel> getActividades() {
		return actividades;
	}

	public void setActividades(List<ActividadModel> actividades) {
		this.actividades = actividades;
	}
	
	
	

}
