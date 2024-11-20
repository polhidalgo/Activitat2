import java.io.*;
import java.util.Scanner;

public class exercici5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introdueix el nom o ruta del fitxer: ");
        String fileName = scanner.nextLine();
        File inputFile = new File(fileName);

        String outputFileName = "Histograma-" + inputFile.getName();
        generarHistograma(inputFile, outputFileName);

        scanner.close();
    }

    public static void generarHistograma(File inputFile, String outputFileName) {
        if (!inputFile.exists()) {
            System.out.println("El fitxer " + inputFile.getName() + " no existeix.");
            return;
        }
        System.out.println("L'histograma s'ha generat correctament al fitxer: " + outputFileName);
        int suspes = 0, aprovat = 0, notable = 0, excelent = 0;

        try (Scanner fileScanner = new Scanner(inputFile)) {
            while (fileScanner.hasNext()) {
                String value = fileScanner.next();

                try {
                    value = value.replace(",",".");
                    double nota = Double.parseDouble(value);
                    
                    if (nota == -1) {
                        break;
                    }
                    else if (nota >= 9 && nota <= 10) {
                        excelent++;
                    } else if (nota >= 6.5 && nota < 9) {
                        notable++;
                    } else if (nota >= 5 && nota < 6.5) {
                        aprovat++;
                    } else if (nota >= 0 && nota < 5) {
                        suspes++;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Valor no vàlid: " + value);
                }
                
            }

            try (PrintWriter writer = new PrintWriter(new FileWriter(outputFileName))) {
                writer.println("Histograma del fitxer " + inputFile.getName());
                writer.println("------------");
                writer.println("Suspès:" + "*".repeat(suspes));
                writer.println("Aprovat:" + "*".repeat(aprovat));
                writer.println("Notable:" + "*".repeat(notable));
                writer.println("Excel·lent:" + "*".repeat(excelent));
                writer.close();
            }
            fileScanner.close();
        } catch (IOException e) {
            System.out.println("Error durant la escriptura del fitxer: " + e.getMessage());
        }
    }
}
