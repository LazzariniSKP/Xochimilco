package edu.itesm.mx.xochimilco.dao;

import net.sf.json.JSONArray;

public interface XochimilcoDAOInterfaceEconomics {
	
	public JSONArray getSites();
	public void  openConnection();
	public void closeConnection();
	public void agrega(String titulo, String descripcion, String imagen, String video, String idcapa, String idicono, String latitud, String longitud);
}
