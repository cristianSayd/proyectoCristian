package com.proyecto.proyecto.ProyectoCristian.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tareas")
public class Tarea {
	
	@Id
	@Column(name = "id_tarea", unique = true, nullable = false)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	private String idTarea ;
	
	@NotEmpty(message = "Debe indicar el nombre ")
	@Column(name = "nombre")
	private String nombre ;
	
	
	
	
	
	@DateTimeFormat
	@Column(name = "fecha_inicio")
	private Date fechaInicio;
	
	@DateTimeFormat
	@Column(name = "fecha_fin")
	private Date fechaFin;
	
	@Column (name = "id_padre")
	private String  idPadre ;
	
	@Column (name = "nivel")
	private Integer nivel ;
	 

	public Tarea() {
		
	}

	public Tarea(String idTarea, String nombre, Date fechaInicio, Date fechaFin, String idPadre, Integer nivel) {
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
