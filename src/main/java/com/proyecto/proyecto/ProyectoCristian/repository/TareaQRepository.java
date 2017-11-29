package com.proyecto.proyecto.ProyectoCristian.repository;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.proyecto.proyecto.ProyectoCristian.entity.Tarea;

@Repository ("tareaQRepository")
public class TareaQRepository {

	@PersistenceContext
	private EntityManager em;
	
//	@Autowired
//	@Qualifier("estadoActicoProducto")
	public List<Tarea> listTareasArbol(){
		
		
		Query query = em.createNativeQuery("\n" + 
				"SELECT \n" + 
				"    *,\n" + 
				"    (SELECT \n" + 
				"            nombre\n" + 
				"        FROM\n" + 
				"            proyecto_db.tareas\n" + 
				"        WHERE\n" + 
				"            id_tarea = a.id_padre) AS id_padre\n" + 
				"FROM\n" + 
				"    proyecto_db.tareas a", Tarea.class);
		
		return query.getResultList();
		
	}
	
	
}
