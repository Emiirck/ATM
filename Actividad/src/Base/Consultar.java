package Base;

import java.io.File;
import java.util.Scanner;

public class Consultar {

    private static final String Ruta = System.getProperty("user.home") + "\\Documents\\registros.txt";

    public void consultarRegistro() {
        File archivo = new File(Ruta);
        if (!archivo.exists()) {
            System.out.println("Error: No hay registros guardados.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la placa a consultar: ");
        String placa = scanner.nextLine().trim().toUpperCase();

        try (Scanner fileScanner = new Scanner(archivo)) {
            boolean encontrado = false;

            while (fileScanner.hasNextLine()) {
                String linea = fileScanner.nextLine();
                String[] partes = linea.split("\\|");

                if (partes[0].equals(placa)) {
                    System.out.println("\n--- Datos del Vehículo ---");
                    System.out.println("Placa: " + partes[0]);
                    System.out.println("Nombre: " + partes[1]);
                    System.out.println("Apellido: " + partes[2]);
                    System.out.println("Cédula: " + partes[3]);
                    System.out.println("Modelo: " + partes[4]);
                    System.out.println("Valor: " + partes[5]);
                    System.out.println("Año: " + partes[6]);
                    System.out.println("Puertas: " + partes[7]);
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("Error: La placa no está registrada.");
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}