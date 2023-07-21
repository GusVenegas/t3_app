package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

public class Tarea implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer codigo;
	private String nombre;
	private Persona responsable;
	private String estado;

	private static List<Tarea> tareas = null;

	public Tarea() {
	}

	public Tarea(Integer codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.responsable = null;
		this.estado = "Por asignar";
	}

	public void setResponsable(Persona responsable) {
		this.responsable = responsable;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Persona getResponsable() {
		return responsable;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	// REGLAS DEL NEGOCIO
	public void asignarResponsable(Persona persona, int idTarea) {
		for (Tarea tarea : this.getTareas()) {
			if(tarea.getCodigo() == idTarea){
				tarea.setResponsable(persona);
				tarea.setEstado("POR HACER");
			}
		}
	}

	public void crearTarea(Tarea t) {
		this.getTareas().add(t);
	}

	public void completarTarea() {
		this.estado = "Completado";
	}

	public List<Tarea> getTareas() {
		if (tareas == null) {
			tareas = new ArrayList<>();
			tareas.add(new Tarea(1, "Hacer rol de pago"));
		}
		return tareas;
	}

	public List<Tarea> getTareasByPersona(Persona persona) {
		List<Tarea> personalizada = new ArrayList<>();
		for (Tarea tarea : this.getTareas()) {
			if(tarea.getResponsable() != null) {
				if (tarea.getResponsable().getId() == persona.getId()) {
					personalizada.add(tarea);
				}
			}			
		}
		return personalizada;
	}

	public Tarea getTareaById(Integer idTarea) {
		Tarea tareaEspecifica = null;	
		for (Tarea tarea : this.getTareas()) {
			
				if (tarea.getCodigo() == idTarea) {
					return tarea;
				}
						
		}
		return tareaEspecifica;
		
	}

}
