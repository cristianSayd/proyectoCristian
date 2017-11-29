package com.proyecto.proyecto.ProyectoCristian.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "etapas")
public class Etapa {

	
	@Id
	@Column(name = "id_etapa", unique = true, nullable = false)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	private String idEtapa ;
	
	@NotEmpty(message = "Debe indicar el nombre ")
	@Column(name = "nombre")
	private String nombre ;
	
	@DateTimeFormat
	@Column(name = "fecha_inicio")
	private Date fechaInicio;
	
	@DateTimeFormat
	@Column(name = "fecha_fin")
	private Date fechaFin;
	
	@OneToMany(cascade = CascadeType.ALL, fetch= FetchType.LAZY)
	@JoinColumn(name = "id_etapa")
	private List<Actividad> actividades;
	
	
	public Etapa() {}

	public Etapa(String idEtapa, String nombre, Date fechaInicio, Date fechaFin, List<Actividad> actividades) {
		
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

	public List<Actividad> getActividades() {
		return actividades;
	}

	public void setActividades(List<Actividad> actividades) {
		this.actividades = actividades;
	}
	
	
}
