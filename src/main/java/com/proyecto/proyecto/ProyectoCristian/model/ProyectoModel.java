package com.proyecto.proyecto.ProyectoCristian.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ProyectoModel {
	private String idProyecto;
	private String nombre;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date fechaInicio;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date fechaFin;

	private List<EtapaModel> etapas = new ArrayList<>();

	public ProyectoModel() {

	}

	public ProyectoModel(String idProyecto, String nombre, Date fechaInicio, Date fechaFin, List<EtapaModel> etapas) {
		super();
		this.idProyecto = idProyecto;
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.etapas = etapas;
	}

	public String getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(String idProyecto) {
		this.idProyecto = idProyecto;
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

	public List<EtapaModel> getEtapas() {
		return etapas;
	}

	public void setEtapas(List<EtapaModel> etapas) {
		this.etapas = etapas;
	}

}
