package modelo;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;

	final String SQL_SELECT_ALL = "SELECT * FROM persona;";
	final String SQL_SELECT_BY_ID = "SELECT * FROM persona WHERE id = ?";
	final String SQL_SELECT_OPERATIVOS = "SELECT * FROM persona WHERE esDirector = false;";
	final String SQL_INSERT = "INSERT INTO person(nombre, password, esDirector) values(?,?,?)";
	final String SQL_DELETE_BY_ID = "DELETE FROM persona WHERE id = ?";
	final String SQL_UPDATE = "UPDATE persona SET nombre = ?, password = ?, esadmin = ? WHERE id =?";
	final String SQL_AUTORIZAR = "SELECT * FROM persona WHERE nombre = ? AND password = ?";

	private String nombre;
	private int id;
	private String password;
	private boolean esDirector;

	//private static List<Persona> personas = null;

	public Persona() {
	}

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	// Reglas del negocio
	public Persona autorizar(String usuario, String password) {

		Persona personaAutorizada = null;
		/*
		 * List<Persona> listaPersonas = this.getPersonas(); for (Persona persona :
		 * listaPersonas) { if(persona.getNombre().equals(usuario) &&
		 * persona.getPassword().equals(password)) { personaAutorizada = persona; break;
		 * } }
		 */

		try {
			PreparedStatement pstm = BddConeccion.getConexion().prepareStatement(SQL_AUTORIZAR);
			pstm.setString(1, usuario);
			pstm.setString(2, password);

			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				Persona persona = new Persona();
				persona.setId(rs.getInt("id"));
				persona.setNombre(rs.getString("nombre"));
				persona.setPassword(rs.getString("password"));
				persona.setEsDirector(rs.getBoolean("esDirector"));
				personaAutorizada = persona;

			}
			BddConeccion.cerrar(rs);
			BddConeccion.cerrar(pstm);
			BddConeccion.cerrar();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return personaAutorizada;
	}

	public List<Persona> getPersonas() {
		/*
		 * if(personas == null) { personas = new ArrayList<>(); personas.add(new
		 * Persona(1, "Luis", "luis123", true)); personas.add(new Persona(2, "Pepe",
		 * "pepe123", false)); personas.add(new Persona(3, "María", "maria23", false));
		 * personas.add(new Persona(4, "Mariana", "mariana123", false)); } return
		 * personas;
		 */
		List<Persona> listaPersonas = new ArrayList<>();

		try {
			PreparedStatement pstm = BddConeccion.getConexion().prepareStatement(SQL_SELECT_ALL);
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				Persona persona = new Persona();
				persona.setId(rs.getInt("id"));
				persona.setNombre(rs.getString("nombre"));
				persona.setPassword(rs.getString("password"));
				persona.setEsDirector(rs.getBoolean("esDirector"));

				listaPersonas.add(persona);
			}
			BddConeccion.cerrar(rs);
			BddConeccion.cerrar(pstm);
			BddConeccion.cerrar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaPersonas;
	}

	public List<Persona> getOperativos() {
		/*
		 * List<Persona> personasResponsables = new ArrayList<Persona>(); for (Persona
		 * persona : this.getPersonas()) { if (!persona.isEsDirector()) {
		 * personasResponsables.add(persona); } } return personasResponsables;
		 */
		List<Persona> personasResponsables = new ArrayList<>();

		try {
			PreparedStatement pstm = BddConeccion.getConexion().prepareStatement(SQL_SELECT_OPERATIVOS);
			pstm.setBoolean(1, esDirector);
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				Persona persona = new Persona();
				persona.setId(rs.getInt("id"));
				persona.setNombre(rs.getString("nombre"));
				persona.setPassword(rs.getString("password"));
				persona.setEsDirector(rs.getBoolean("esDirector"));

				personasResponsables.add(persona);
			}
			BddConeccion.cerrar(rs);
			BddConeccion.cerrar(pstm);
			BddConeccion.cerrar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return personasResponsables;
	}

	public Persona getPersonaById(Integer idPersonaResponsable) {
		/*
		 * for (Persona persona : this.getPersonas()) { if (persona.getId() ==
		 * idPersonaResponsable) { return persona; } } return null;
		 */

		Persona p = null;

		try {
			PreparedStatement pstm = BddConeccion.getConexion().prepareStatement(SQL_SELECT_BY_ID);
			pstm.setInt(1, id);// inyectar el parametro que nos pide
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				Persona persona = new Persona();
				persona.setId(rs.getInt("id"));
				persona.setNombre(rs.getString("nombre"));
				persona.setPassword(rs.getString("password"));
				persona.setEsDirector(rs.getBoolean("esDirector"));
				p = persona;

			}
			BddConeccion.cerrar(rs);
			BddConeccion.cerrar(pstm);
			BddConeccion.cerrar();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return p;
	}

}
