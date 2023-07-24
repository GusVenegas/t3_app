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

@WebServlet("/OperadorController")
public class OperadorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OperadorController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.- Obtener datos que me envían de la solicitud
		// 2.- Llamar al modelo para obtener los datos
		Tarea modeloTarea = new Tarea();
		List<Tarea> listaTareas = modeloTarea.getTareasByPersona((Persona)request.getSession().getAttribute("usuarioLogeado"));		
		// 3.- Llamo a la vista
		request.setAttribute("tareas", listaTareas);
		request.getRequestDispatcher("jsp/tareaOperador.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
