package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Persona;
import modelo.Tarea;

/**
 * Servlet implementation class AsignarResponsableController
 */
@WebServlet("/AsignarResponsableController")
public class AsignarResponsableController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AsignarResponsableController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer idTarea = Integer.parseInt(request.getParameter("idtarea"));
		Tarea tareaModelo = new Tarea();
		tareaModelo.porHacer();
		Tarea tarea = tareaModelo.getTareaById(idTarea);
		//Obtener la lista de posbiles responsables
		Persona personaModelo = new Persona();
		List<Persona> listaPersona = personaModelo.getOperativos();
		request.setAttribute("tarea", tarea);
		request.setAttribute("responsables", listaPersona);
		request.getRequestDispatcher("jsp/asignarresponsable.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer idTarea = Integer.parseInt(request.getParameter("txtCod"));
		Integer idPersonaResponsable = Integer.parseInt( request.getParameter("responsable"));

		Persona modeloPersona = new Persona();
		Persona responsable = modeloPersona.getPersonaById( idPersonaResponsable);

		Tarea tareaModelo = new Tarea();
		tareaModelo.asignarResponsable(responsable , idTarea);
		
		response.sendRedirect("TareaController");
	}

}
