package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Tarea implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer codigo;
	private String nombre;
	private String responsable;
	private String estado;
	
	private static List<Tarea> tareas = null;
	
	public Tarea() {}

	public Tarea(Integer codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.responsable = "";
		this.estado = "Por asignar";
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

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	//REGLAS DEL NEGOCIO
	public void asignarResponsable(String nombre) {
		Persona p = new Persona();
		List<Persona> listaPersonas = p.getPersonas();

		for (int i = 0; i <= listaPersonas.size(); i++) {
			if (listaPersonas.get(i).getNombre() == nombre) {
				this.responsable = nombre;
				this.estado = "Por Hacer";
				break;
			}
		}
	}
	
	public void crearTarea(Tarea t) {
		this.getTareas().add(t);
	}
	
	public void completarTarea() {
		this.estado = "Completado";
	}
	
	public List<Tarea> getTareas(){
		if(tareas == null) {
			tareas = new ArrayList<>();
			tareas.add(new Tarea(1, "Hacer rol de pago"));
		}		
		return tareas;
	}
	

}
