package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class Tarea implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer codigo;
	private String nombre;
	private Persona responsable;	
	private EstadoTareaEnum estadoTarea;

	private static List<Tarea> tareas = null;

	public Tarea() {
	}

	public Tarea(Integer codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.responsable = null;		
		this.estadoTarea= EstadoTareaEnum.porAsignar;
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
	
	public EstadoTareaEnum getEstadoTarea() {
		return estadoTarea;
	}

	public void setEstadoTarea(EstadoTareaEnum estadoTarea) {
		this.estadoTarea = estadoTarea;
	}

	// REGLAS DEL NEGOCIO
	public void asignarResponsable(Persona persona, int idTarea) {
		for (Tarea tarea : this.getTareas()) {
			if(tarea.getCodigo() == idTarea){
				tarea.setResponsable(persona);
				tarea.porHacer();
			}
		}
	}
	
	public Tarea crearTarea(Tarea t) {
		Tarea tareaNueva = null;
		for (Tarea tarea : this.getTareas()) {
			if(t.getCodigo() != tarea.getCodigo()) {				
				this.getTareas().add(t);
				tareaNueva = t;
				tareaNueva.porAsignar();
				break;
			}
		}
		return tareaNueva;
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

	public void porHacer() {		
		this.estadoTarea= EstadoTareaEnum.porHacer;		
	}
	
	public void completar(int idTarea){
		for (Tarea tarea : this.getTareas()) {
			if(tarea.getCodigo() == idTarea){				
				tarea.setEstadoTarea(EstadoTareaEnum.completado);
			}
		}
		
	}
	
	public void porAsignar() {
		this.estadoTarea = EstadoTareaEnum.porAsignar;
	}
	
	public void cambiaraHacer(int idTarea) {
		for (Tarea tarea : this.getTareas()) {
			if(tarea.getCodigo() == idTarea){				
				tarea.setEstadoTarea(EstadoTareaEnum.porHacer);
			}
		}
	}

	
}
