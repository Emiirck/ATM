package Base;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Actualizar {

    private static final String Ruta = System.getProperty("user.home") + "\\Documents\\registros.txt";
    public void actualizarRegistro() {
        File archivo = new File(Ruta);
        if (!archivo.exists()) {
            System.out.println("Error: No hay registros guardados.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la placa a actualizar: ");
        String placa = scanner.nextLine().trim().toUpperCase();

        List<String> lineas = new ArrayList<>();
        boolean encontrado = false;

        try (Scanner fileScanner = new Scanner(archivo)) {
            while (fileScanner.hasNextLine()) {
                String linea = fileScanner.nextLine();
                String[] partes = linea.split("\\|");

                if (partes[0].equals(placa)) {
                    encontrado = true;
                    System.out.println("\nDatos actuales del vehículo:");
                    System.out.println("Placa: " + partes[0]);
                    System.out.println("Nombre: " + partes[1]);
                    System.out.println("Apellido: " + partes[2]);
                    System.out.println("Cédula: " + partes[3]);
                    System.out.println("Modelo: " + partes[4]);
                    System.out.println("Valor: " + partes[5]);
                    System.out.println("Año: " + partes[6]);
                    System.out.println("Puertas: " + partes[7]);

                    System.out.println("\nIngrese los nuevos datos (deje en blanco para mantener el valor actual):");
                    System.out.print("Nuevo nombre [" + partes[1] + "]: ");
                    String nombre = scanner.nextLine().trim();
                    if (nombre.isEmpty()) nombre = partes[1];

                    System.out.print("Nuevo apellido [" + partes[2] + "]: ");
                    String apellido = scanner.nextLine().trim();
                    if (apellido.isEmpty()) apellido = partes[2];

                    System.out.print("Nueva cédula [" + partes[3] + "]: ");
                    String cedula = scanner.nextLine().trim();
                    if (cedula.isEmpty()) cedula = partes[3];

                    System.out.print("Nuevo modelo [" + partes[4] + "]: ");
                    String modelo = scanner.nextLine().trim();
                    if (modelo.isEmpty()) modelo = partes[4];

                    System.out.print("Nuevo valor [" + partes[5] + "]: ");
                    String valor = scanner.nextLine().trim();
                    if (valor.isEmpty()) valor = partes[5];

                    System.out.print("Nuevo año [" + partes[6] + "]: ");
                    String anio = scanner.nextLine().trim();
                    if (anio.isEmpty()) anio = partes[6];

                    System.out.print("Nuevo número de puertas [" + partes[7] + "]: ");
                    String puertas = scanner.nextLine().trim();
                    if (puertas.isEmpty()) puertas = partes[7];

                    linea = placa + "|" + nombre + "|" + apellido + "|" + cedula + "|" + modelo + "|" + valor + "|" + anio + "|" + puertas;
                }

                lineas.add(linea);
            }

            if (!encontrado) {
                System.out.println("Error: La placa no está registrada.");
                return;
            }

            try (FileWriter writer = new FileWriter(archivo)) {
                for (String linea : lineas) {
                    writer.write(linea + "\n");
                }
                System.out.println("Registro actualizado exitosamente.");
            } catch (Exception e) {
                System.out.println("Error al actualizar el registro: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}