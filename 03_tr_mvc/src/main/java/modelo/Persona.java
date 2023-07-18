package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Persona implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String password;
	
	private static List<Persona> personas = null;
	
	public Persona() {}

	public Persona(String nombre, String password) {
		super();
		this.nombre = nombre;
		this.password = password;
	}

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
			personas.add(new Persona("Luis", "luis123"));
			personas.add(new Persona("Pepe", "pepe123"));
			personas.add(new Persona("María", "maria23"));
			personas.add(new Persona("Mariana", "mariana123"));
		}
		return personas;
	}
	
}
