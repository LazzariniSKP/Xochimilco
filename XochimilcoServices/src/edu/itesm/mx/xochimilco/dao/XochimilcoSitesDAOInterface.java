package edu.itesm.mx.xochimilco.dao;

import net.sf.json.JSONArray;

public interface XochimilcoSitesDAOInterface {
	
	public JSONArray getSites();
	public void openConnection();
	public void closeConnection();
	
	public void agrega(String n, String d);

}
