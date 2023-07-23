package controlador;

import java.io.IOException;
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
		Integer idTarea = Integer.parseInt(request.getParameter("idtarea"));
		Tarea tareaModelo = new Tarea();
		Tarea tarea = tareaModelo.getTareaById(idTarea);
		request.setAttribute("tarea", tarea);
		request.getRequestDispatcher("jsp/cambiarestado.jsp").forward(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String estadoTarea = request.getParameter("estado");
		Tarea tareaModelo = new Tarea();
		//EstadoTareaEnum estadoNuevo= EstadoTareaEnum.completado;
		
		//tareaModelo.setEstadoTarea(tareaModelo.getEstadoTarea());
		System.out.println(estadoTarea);
		response.sendRedirect("OperadorController");
		
	}

}
