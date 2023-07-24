package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.EstadoTareaEnum;
import modelo.Tarea;


@WebServlet("/CambiarEstadoController")
public class CambiarEstadoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CambiarEstadoController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.- Obtener datos que me envían de la solicitud	
		Integer idTarea = Integer.parseInt(request.getParameter("idtarea"));
		//2.- Llamar al modelo para obtener los datos
		Tarea tareaModelo = new Tarea();
		//tareaModelo.completar();
		Tarea tarea = tareaModelo.getTareaById(idTarea);
		//3.- Llamo a la vista
		request.setAttribute("tarea", tarea);
		request.setAttribute("estado", tareaModelo.getEstadoTarea());
		request.getRequestDispatcher("jsp/cambiarestado.jsp").forward(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.- Obtener datos que me envían de la solicitud
		String estadoTarea = request.getParameter("estadoE");
		Integer idTarea = Integer.parseInt(request.getParameter("txtCod"));
		//2.- Llamar al modelo para obtener los datos
		Tarea tareaModelo = new Tarea();
		//tareaModelo.completar();
		
		//EstadoTareaEnum estadoNuevo= EstadoTareaEnum.completado;
		
		//tareaModelo.setEstadoTarea(tareaModelo.getEstadoTarea());
		System.out.println(estadoTarea);
		//System.out.println(tareaModelo.getEstadoTarea());
		
		if(estadoTarea.equals("Completado")) {			
			tareaModelo.completar(idTarea);					
		}else {
			tareaModelo.cambiaraHacer(idTarea);						
		}
		response.sendRedirect("OperadorController");

		//3.- Llamo a la vista
		
		
	}

}
