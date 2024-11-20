import java.io.File;
import java.util.Scanner;

public class exercici3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escriu una ruta a un fitxer:");
        String rutaFitxer = scanner.nextLine();
        
        comptaParaules(rutaFitxer);

        scanner.close();
    }

    public static void comptaParaules(String filePath) {
        try (Scanner fileScanner = new Scanner(new File(filePath))) {
            int linea = 1;

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();

              
                if (line.equals("fi")) {
                    System.out.println("Has arribat al final");
                    break;
                }

                int contadorParaules = contador(line);
                System.out.println("La línia " + linea + " té " + contadorParaules + " paraules");
                linea++;
            }
        } catch (Exception e) {
            System.out.println("Error en llegir el fitxer: " + e.getMessage());
        }
    }


    private static int contador(String line) {

        if (line.trim().isEmpty()) {
            return 0;
        }

        String[] words = line.trim().split("\\s+");
        return words.length;
    }
}

