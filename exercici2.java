import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class exercici2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Escriu una primera ruta de fitxer: ");
        String rutaArchivo1 = scanner.nextLine();
        System.out.print("Escriu una segona:  ");
        String rutaArchivo2 = scanner.nextLine();

        System.out.print("Introduix la ruta de destí: ");
        String rutaDestino = scanner.nextLine();
        File f1 = new File(rutaArchivo1);
        File f2 = new File(rutaArchivo2);
        File fDesti = new File(rutaDestino);

        try {
            ferUnArchiu(f1, f2, fDesti);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }

    public static void ferUnArchiu(File f1, File f2, File fDesti){

        String nomArchiu1 = f1.getName().replaceAll("\\.txt$", "");
        String nomArchiu2 = f2.getName().replaceAll("\\.txt$", "");

        String nomArchiuDesti = nomArchiu1+"_"+nomArchiu2+".txt";
        File archiuDesti = new File(fDesti, nomArchiuDesti);

        if(archiuDesti.exists()){
            Scanner scanner = new Scanner(System.in);
            System.out.print("El archiu ja existeix, vols sobreescriurel? (s/n): ");
            String resposta = scanner.nextLine();
            if (!resposta.toLowerCase().equals("s")) {
                System.out.println("Cancelat");
                scanner.close();
                return;
            }
            scanner.close();
        }

        try (PrintWriter escriptor = new PrintWriter(new FileWriter(archiuDesti))) {
            copiar(f1, escriptor);
            copiar(f2, escriptor);
            System.out.println("Fitxers fusionats correctament a: " + nomArchiuDesti);
            escriptor.close();
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e);
        } 
        }
        

    

    private static void copiar(File f, PrintWriter escriptor){
        try 
        { Scanner fileScanner = new Scanner(f);
            while(fileScanner.hasNextLine()){
                String linia = fileScanner.nextLine();
                // if(linia.trim().equalsIgnoreCase("fi")){
                //     break;
                // }
                escriptor.println(linia);
            }
            fileScanner.close();
            
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e);
        }
    }
}


