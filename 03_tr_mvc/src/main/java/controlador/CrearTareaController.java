package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Tarea;



@WebServlet("/CrearTareaController")
public class CrearTareaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CrearTareaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//3.- Lamo a la vista
		response.sendRedirect("jsp/creartarea.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.-Obtener datos que me envían en la solicitud
		Integer cod = Integer.parseInt(request.getParameter("txtCod"));
		String nombre = request.getParameter("txtNombre");		
		
		//2.- Llamo al Modelo para obtener datos
		Tarea nuevaTarea = new Tarea();
		nuevaTarea.setCodigo(cod);
		nuevaTarea.setNombre(nombre);
		
		
		
		Tarea modeloTarea = new Tarea();
		
				
		//3.- Llamo a la vista
		if(modeloTarea.crearTarea(nuevaTarea) == null) {			
			request.setAttribute("codigoTarea", cod);
			request.getRequestDispatcher("jsp/errortarea.jsp").forward(request, response);
		}else {			
			response.sendRedirect("TareaController");
		}
		
	}

}
