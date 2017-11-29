package com.proyecto.proyecto.ProyectoCristian.entity;

import java.util.ArrayList;
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
@Table(name = "proyectos")
public class Proyecto {

	@Id
	@Column(name = "id_proyecto", unique = true, nullable = false)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	private String idProyecto;
	
	@NotEmpty(message = "Debe indicar el nombre ")
	@Column(name = "nombre")
	private String nombre;
	
	@DateTimeFormat
	@Column(name = "fecha_inicio")
	private Date fechaInicio;
	
	@DateTimeFormat
	@Column(name = "fecha_fin")
	private Date fechaFin;
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name = "id_proyecto")
	private List<Etapa> etapas = new ArrayList<>();
	
	public Proyecto() {
		
	}

	public Proyecto(String idProyecto, String nombre, Date fechaInicio, Date fechaFin, List<Etapa> etapas) {
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

	public List<Etapa> getEtapas() {
		return etapas;
	}

	public void setEtapas(List<Etapa> etapas) {
		this.etapas = etapas;
	}
	
	
	
}
