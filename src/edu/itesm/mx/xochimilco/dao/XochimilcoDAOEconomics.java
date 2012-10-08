package edu.itesm.mx.xochimilco.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.google.appengine.api.rdbms.AppEngineDriver;


public class XochimilcoDAOEconomics implements XochimilcoDAOInterfaceEconomics{

	private Connection connection;
	private static XochimilcoDAOEconomics dao;
	
	private XochimilcoDAOEconomics(){
	}
	
	public static XochimilcoDAOEconomics getInstance (){
	  if (dao== null){
		  dao= new XochimilcoDAOEconomics();
	  }
	   return dao;
	}
	
	@Override
	public JSONArray getSites() {
		JSONArray sites = new JSONArray();
        try {
                if(connection.isClosed()) openConnection();
        } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
        }
         Statement statement;
        try {
                statement = connection.createStatement();
              ResultSet rs = statement.executeQuery("select nombre, descripcion, imagen, latitud, altitud from puntos where capa_idcapa=5");
              while(rs.next()){
                        JSONObject s = new JSONObject();
                        s.put("nombre", rs.getString(1));
                        s.put("descripcion",rs.getString(2));
                        s.put("latitud", rs.getDouble(4));
                        s.put("altitud", rs.getDouble(5));
                        s.put("imagen", rs.getString(3));
                        sites.add(s);
                  }
               
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
      // Result set get the result of the SQL query
       
       
        return sites;
	}

	@Override
	public void openConnection() {
	       // TODO Auto-generated method stub
        try {
               DriverManager.registerDriver(new AppEngineDriver());
       } catch (SQLException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
       }
    try {
               connection = DriverManager.getConnection(
                                "jdbc:google:rdbms://xochimilcoccm:xochimilco/xochimilco");
       } catch (SQLException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
       }
	}

	@Override
	public void closeConnection() {
		// TODO Auto-generated method stub
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void agrega(String titulo, String descripcion, String imagen, String video, String idcapa, String idicono, String latitud, String altitud) {
		try{
			if(connection.isClosed()) openConnection();
			Statement statement = connection.createStatement(); 
			statement.executeUpdate(
					"insert into puntos (nombre,descripcion,imagen,video,capa_idcapa, icono_idicono,latitud,altitud)"+
					"values('"+titulo+"','"+descripcion+"','"+imagen+"','"+video+"','"+idcapa+"','"+idicono+"','"+latitud+"','"+altitud+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
   
}
