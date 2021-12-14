package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MontoDAO {
    
    private final String query1 = "SELECT *" + "FROM public.multa WHERE placa =?";
    private final String query2 = "DELETE FROM public.multa WHERE id_multa=?";
    private Connection conec;
    private PreparedStatement consulta1 = null;

    public MontoDAO() throws SQLException{
	conec = Conexion.getConnection();
	try {
		if(conec.isValid(1000))System.out.println("base conectada");
	} catch (SQLException e) {
	// TODO Auto-generated catch block
		System.out.println("a:"+e.getMessage());
		}
	}
    
}
