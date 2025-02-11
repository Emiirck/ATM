package Base;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Crear {

    private static final String Ruta = System.getProperty("user.home") + "\\Documents\\registros.txt";

    public void crearRegistro() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la placa (única, no se puede modificar): ");
        String placa = scanner.nextLine().trim().toUpperCase();

        if (existePlaca(placa)) {
            System.out.println("Error: La placa ya está registrada.");
            return;
        }

        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine().trim();

        System.out.print("Ingrese el apellido: ");
        String apellido = scanner.nextLine().trim();

        System.out.print("Ingrese la cédula: ");
        String cedula = scanner.nextLine().trim();

        System.out.print("Ingrese el modelo: ");
        String modelo = scanner.nextLine().trim();

        System.out.print("Ingrese el valor: ");
        String valor = scanner.nextLine().trim();

        System.out.print("Ingrese el año: ");
        String anio = scanner.nextLine().trim();

        System.out.print("Ingrese el número de puertas: ");
        String puertas = scanner.nextLine().trim();

        try (FileWriter writer = new FileWriter(Ruta, true)) {
            String linea = placa + "," + nombre + "," + apellido + "," + cedula + "," + modelo + "," + valor + "," + anio + "," + puertas;
            writer.write(linea);
            System.out.println("Placa registrada correctamente");
        } catch (IOException e) {
            System.out.println("No se ha podido guardar el archivo en la ruta " + e.getMessage());
        }
    }

    private boolean existePlaca(String placa) {
        File archivo = new File(Ruta);
        if (!archivo.exists()) {
            return false; 
        }

        try (Scanner fileScanner = new Scanner(archivo)) {
            while (fileScanner.hasNextLine()) {
                String linea = fileScanner.nextLine();
                String[] partes = linea.split("\\|");
                if (partes[0].equals(placa)) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return false;
    }
}