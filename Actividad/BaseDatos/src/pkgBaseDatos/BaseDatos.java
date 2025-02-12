package pkgBaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BaseDatos {

	private static final String URL="jdbc:mysql://localhost:3306/";
	private static final String USUARIO="root";
	private static final String CONTRASENA="root";
	private static final String BASE_DATOS="poo_istlc";
	
	private Connection conexion;
	
	
	public BaseDatos() {
		try {
			conexion=DriverManager.getConnection(URL+BASE_DATOS,USUARIO,CONTRASENA);
			System.out.println("Conexión Exitosa");
		}
		catch(SQLException e) {
		System.out.println("Error al conecta a la base de datos");
	}
	
}
	
	public void InsertarVehiculo(vehiculos objvehiculo){
		String sql="INSERT INTO VEHICULOS(PLACA,COLOR,MODELO,PROPIETARIO) " +
				"VALUES('"+objvehiculo.placa+"','"+objvehiculo.color+"','"+objvehiculo.modelo+"','"+objvehiculo.propietario+"');";
	try 
	{
		PreparedStatement ps= conexion.prepareStatement(sql);
		ps.execute();
		ps.close();
		System.out.println("Ingreso Exitoso");
		
	}
	catch (SQLException e) {
		System.out.println("Error al insertar en la bd");
		e.printStackTrace();	
	}
	
	
}
	
}