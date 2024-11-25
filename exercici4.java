import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class exercici4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File file;
        PrintWriter escriptor = null;

        while (true) {
            System.out.print("Introdueix el nom del fitxer: ");
            String nomFitxer = scanner.nextLine();
            file = new File(nomFitxer);

           
            if (file.exists()) {
                System.out.println("Aquest fitxer ja existeix. Introdueix un altre nom.");
            } else {
                try {
                    
                    if (file.createNewFile()) {
                        System.out.println("Fitxer creat amb exit: " + file.getName());
                    } else {
                        System.out.println("No sha pogut crear el fitxer. Tornaho a intentar.");
                    }
                } catch (IOException e) {
                    System.out.println("Hi ha hagut un error en crear el fitxer.");
                    System.out.println(e);
                }
                break;
            }
        }

        try {
            escriptor = new PrintWriter(file);
            System.out.println("Escriu línies de text. Escriu un punt en una línia per acabar.");

            while (true) {
                String linia = scanner.nextLine();

                
                if (linia.equals(".")) {
                    System.out.println("S ha guardat el text al fitxer.");
                    break;
                }

                escriptor.println(linia + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Hi ha hagut un error en escriure al fitxer");
            System.out.println(e);
        } finally {
                if (escriptor != null) {
                    escriptor.close();
                }
                
                scanner.close();
            }
    }
}
