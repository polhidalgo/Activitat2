import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;



public class exercici1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escriu una ruta a un fitxer:");
        String pathFitxer = scanner.nextLine();
        File file = new File(pathFitxer);
        System.out.println("Escriu un text que li vulguis pasar:");
        String text = scanner.nextLine();
        escriureUnFitxer(file, text);
        llegirUnFitxer(file);
        scanner.close();
    }

    public static void escriureUnFitxer(File f, String text) {
        String textAlternat = alternarText(text);
        try{
            PrintStream escriptor = new PrintStream(f);
            escriptor.print(textAlternat);
            escriptor.close();
        }
        catch (Exception e) {
   
            System.out.println("Error: " + e);
         }

    }

    private static String alternarText(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isUpperCase(ch)) {
                result += Character.toLowerCase(ch);
            } else {
                result += Character.toUpperCase(ch);
            }
        }
        return result;
    }

    public static void llegirUnFitxer(File f){
        try{
            Scanner lector = new Scanner(f);
            while (lector.hasNextLine()) {
                String line = lector.nextLine();
                System.out.println(line);
            }
            lector.close();
        }
        catch (Exception e) {
           
            System.out.println("Error: " + e);
         }
        

    }
}
