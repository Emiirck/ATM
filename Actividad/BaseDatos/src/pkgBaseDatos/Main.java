package pkgBaseDatos;

public class Main {

	public static void main(String[] args) {

		vehiculos objvehiculo = new vehiculos("GFD3343", "NEGRO", "CAMARO", "LUIS GONZALES");
		BaseDatos objBaseDatos = new BaseDatos();
		objBaseDatos.InsertarVehiculo(objvehiculo);
		
		objvehiculo.ImprimirVehiculo();
		
		
	}

}
