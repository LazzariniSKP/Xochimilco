package edu.itesm.mx.xochimilco.services;

import java.io.IOException;
import javax.servlet.http.*;

import edu.itesm.mx.xochimilco.dao.XochimilcoDAOEconomics;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@SuppressWarnings("serial")
public class EconomicsServicesServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("application/json");
		
		JSONObject json, ob;
		JSONArray array;
		int  opcion = Integer.parseInt( req.getParameter("opcion") );
		switch( opcion  ){
		case 1:
			 json = new JSONObject();
			json.put("lat", 19.274085 );
			json.put("lon",  -99.138347);				
			
			 array = new JSONArray();
			array.add(json);
			
			 ob = new JSONObject();
			ob.put("places", array);
			resp.getWriter().println( ob.toString() );
			break;
		case 2:			
			ob = new JSONObject();
			XochimilcoDAOEconomics dao =XochimilcoDAOEconomics.getInstance();
			dao.openConnection();
			ob.put("places", dao.getSites());			
			resp.getWriter().println( ob.toString() );
			break;
		}

	}
}
