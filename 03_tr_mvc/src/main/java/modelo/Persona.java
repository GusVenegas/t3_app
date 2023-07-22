package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Persona implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private int id;
	private String password;
	private boolean esDirector;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
	public Persona() {}

	public Persona(int id, String nombre, String password, boolean esDirector) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.password = password;
		this.esDirector = esDirector;
	}
	
	public boolean isEsDirector() {
		return esDirector;
	}

	public void setEsDirector(boolean esDirector) {
		this.esDirector = esDirector;
	}

	private static List<Persona> personas = null;
	


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	//Reglas del negocio
	public Persona autorizar(String usuario,String password) {
		Persona personaAutorizada = null;
		
		List<Persona> listaPersonas = this.getPersonas();
		for (Persona persona : listaPersonas) {
			if(persona.getNombre().equals(usuario) && persona.getPassword().equals(password)) {
				personaAutorizada = persona;
				break;
			}
		}
		return personaAutorizada;
	}
		
	public List<Persona> getPersonas(){
		if(personas == null) {
			personas = new ArrayList<>();
			personas.add(new Persona(1, "Luis", "luis123", true));
			personas.add(new Persona(2, "Pepe", "pepe123", false));
			personas.add(new Persona(3, "María", "maria23", false));
			personas.add(new Persona(4, "Mariana", "mariana123", false));
		}
		return personas;
	}

	public List<Persona> getOperativos() {
		List<Persona> personasResponsables = new ArrayList<Persona>();
		for (Persona persona : this.getPersonas()) {
			if(!persona.isEsDirector()){
				personasResponsables.add(persona);
			}
		}
		return personasResponsables;
	}

	public Persona getPersonaById(Integer idPersonaResponsable) {
		for (Persona persona : this.getPersonas()) {
			if(persona.getId() == idPersonaResponsable){
				return persona;
			}
		}
		return null;
	}
	
}
