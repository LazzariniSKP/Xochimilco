package edu.itesm.mx.xochimilco.services;

import java.io.IOException;
import javax.servlet.http.*;

import edu.itesm.mx.xochimilco.dao.XochimilcoDAO;
import edu.itesm.mx.xochimilco.dao.XochimilcoSitesDAO;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@SuppressWarnings("serial")
public class InsertServicesServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
	
		String nombre = (String) req.getParameter("nombre");
		String descripcion = (String) req.getParameter("descripcion");
		//Instancia de DAO
		XochimilcoDAO dao = XochimilcoDAO.getInstance();
		//Abrir conexión
		dao.openConnection();
		//Ejecutar método
		dao.agrega(nombre, descripcion);
		//Regresa al mapa
		resp.sendRedirect("index.html");
	}
}
