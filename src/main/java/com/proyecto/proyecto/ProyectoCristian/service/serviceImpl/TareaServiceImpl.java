package com.proyecto.proyecto.ProyectoCristian.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.proyecto.proyecto.ProyectoCristian.converter.TareaConverter;
import com.proyecto.proyecto.ProyectoCristian.entity.Tarea;
import com.proyecto.proyecto.ProyectoCristian.model.TareaModel;
import com.proyecto.proyecto.ProyectoCristian.repository.ProyectoRepository;
import com.proyecto.proyecto.ProyectoCristian.repository.TareaQRepository;
import com.proyecto.proyecto.ProyectoCristian.repository.TareaRepository;
import com.proyecto.proyecto.ProyectoCristian.service.TareaSevice;

@Service("tareaServiceImpl")
public class TareaServiceImpl implements TareaSevice {

	@Autowired
	@Qualifier("proyectoRepository")
	private ProyectoRepository proyectoRepository;

	@Autowired
	@Qualifier("tareaRepository")
	private TareaRepository tareaRepository;

	@Autowired
	@Qualifier("tareaQRepository")
	private TareaQRepository tareaQRepository;

	@Autowired
	@Qualifier("tareaConverter")
	private TareaConverter tareaConverter;

	public static final List<TareaModel> tareas1 = new ArrayList<>();

	@Override
	public List<TareaModel> listAllTarea() {
		List<Tarea> tareas = tareaRepository.findAll();
		List<TareaModel> tareasM = new ArrayList<>();

		for (Tarea tarea : tareas) {
			tareasM.add(tareaConverter.convertTareaModeToTarea(tarea));

		}

		return tareasM;
	}

	@Override
	public TareaModel addTarea(TareaModel tareaModel) {
		Tarea tarea = tareaConverter.convertTaeaModelToTarea(tareaModel);
		TareaModel tareaM = tareaConverter.convertTareaModeToTarea(tarea);
		tareaRepository.save(tarea);

		return tareaM;
	}

	@Override
	public boolean deleteTarea(String idTarea) {
		try {
			Tarea tarea = tareaRepository.findOne(idTarea);
			tareaRepository.save(tarea);

		} catch (Exception e) {
			e.getMessage();
			return false;
		}
		return true;
	}

	@Override
	public TareaModel findTareaById(String idTarea) {

		Tarea tarea = tareaRepository.findOne(idTarea);

		return tareaConverter.convertTareaModeToTarea(tarea);
	}

	@Override
	public List<TareaModel> listarHijosDirectos(String idPadre) {

		List<Tarea> tareas = tareaRepository.findTareaByIdPadreOrderByNivel(idPadre);
		List<TareaModel> listaFianl = new ArrayList<>();

		for (Tarea tarea : tareas) {
			if (tarea.getNivel() == tareas.get(0).getNivel()) {
				listaFianl.add(tareaConverter.convertTareaModeToTarea(tarea));
			}
		}
		// listaFianl = tareaConverter.convertListTareaModeToListTarea(tareas);

		return listaFianl;
	}

	@Override
	public List<TareaModel> listarByNivel(Integer nivel) {
		List<TareaModel> tareasM = new ArrayList<>();

		tareasM = tareaConverter.convertListTareaModeToListTarea(tareaRepository.findTareaBynivel(nivel));

		return tareasM;
	}

	@Override
	public List<TareaModel> listarArbol() {
		List<TareaModel> tareas = new ArrayList<>();
		List<Tarea> tareasE = tareaQRepository.listTareasArbol();

		tareas = tareaConverter.convertListTareaModeToListTarea(tareasE);
		return tareas;
	}

	@Override
	public List<TareaModel> listArbolByPadre(String idPadre) {

		List<TareaModel> tareasM2 = new ArrayList<>();

		List<TareaModel> tareas = this.listarHijosDirectos(idPadre);

		for (TareaModel tareaModel : tareas) {
			tareas1.addAll(this.listarTareas(tareaModel));

			if (tareas.equals(tareasM2)) {

			} else {

				this.listArbolByPadre(tareaModel.getIdTarea());

			}
		}

		return tareas1;
	}

	@Override
	public TareaModel addTareaHijo(TareaModel tareaM, String idPadre) {
		Tarea tareaP = tareaRepository.findOne(idPadre);

		tareaM.setNivel(tareaP.getNivel() + 1);
		tareaM.setIdPadre(idPadre);

		return null;
	}

	@Override
	public List<TareaModel> listarTareas(TareaModel tareaM) {
		List<TareaModel> tareasMODEL = new ArrayList<>();
		tareasMODEL.add(tareaM);

		return tareasMODEL;
	}

}
