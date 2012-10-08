package edu.itesm.mx.xochimilco.services;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.itesm.mx.xochimilco.dao.XochimilcoDAOEconomics;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@SuppressWarnings("serial")
public class InsertEconomicsServlet extends HttpServlet {
	 public void doPost(HttpServletRequest req, HttpServletResponse resp)
             throws IOException {

		 String titulo = (String)req.getParameter("titulo");
		 String descripcion = (String)req.getParameter("descripcion");
		 String altitud = (String)req.getParameter("altitud");
		 String latitud = (String)req.getParameter("latitud");
		 String imagen = (String)req.getParameter("imagen");
		 String idcapa = (String)req.getParameter("idcapa");
		 String idicono = (String)req.getParameter("idicono");
		 String video = (String)req.getParameter("video");
		 
		 XochimilcoDAOEconomics dao =XochimilcoDAOEconomics.getInstance();
		 dao.openConnection();
		 dao.agrega(titulo, descripcion, imagen, video, idcapa,idicono, latitud, altitud);
		 resp.sendRedirect("index.html");
	 }
}