package pkgBaseDatos;

public class vehiculos {

	public String placa;
	public String color;
	public String modelo;
	public String propietario;
	
	public vehiculos() {
		
		
	}

	public vehiculos(String placa, String color, String modelo, String propietario) {
		super();
		this.placa = placa;
		this.color = color;
		this.modelo = modelo;
		this.propietario = propietario;
	}
	
	
	public void ImprimirVehiculo() {
		System.out.println("EL VEHICULO INGRESADO:");
		System.out.println("PLACA: "+ this.placa);
		System.out.println("COLOR: "+this.color);
		System.out.println("MODELO: "+this.modelo);
		System.out.println("PROPIETARIO: "+this.propietario);
		
		
	}
	
	
	
	
}
