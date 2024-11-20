import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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

        try{
            FileOutputStream fos = new FileOutputStream(archiuDesti);
                copiar(f1, fos);
                copiar(f2, fos);
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e);
        } 
        }
        

    

    private static void copiar(File f, FileOutputStream fos){
        try 
        { FileInputStream fis = new FileInputStream(f);
            byte[] buffer = new byte[1024];
            int bytesLeidos;
            while ((bytesLeidos = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesLeidos);
                 }
        
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e);
        }
    }
}


