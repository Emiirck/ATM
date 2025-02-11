package Base;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Crear crear = new Crear();
        Consultar consultar = new Consultar();
        Actualizar actualizar = new Actualizar();
        int opcion;

        do {
            System.out.println("**********Menú de Matriculación de Vehículos**********");
            System.out.println("1. Crear");
            System.out.println("2. Consultar");
            System.out.println("3. Actualizar");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    crear.crearRegistro();
                    break;
                case 2:
                    consultar.consultarRegistro();
                    break;
                case 3:
                    actualizar.actualizarRegistro();
                    break;
                case 4:
                    System.out.println("Muchas gracias por usar el aplicativo del ATM");
                    break;
                default:
                    System.out.println("Por favor eliga una de las opciones propuestas");
            }
        } while (opcion != 4);

        scanner.close();
    }
}