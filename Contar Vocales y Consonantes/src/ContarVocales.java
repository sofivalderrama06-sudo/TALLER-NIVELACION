import java.util.Scanner;

public class ContarVocales {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String palabra;
        int contadorVocales = 0;
        
        System.out.println(" ");
        System.out.println("Contador de vocales y consonantes");
        System.out.println(" ");
        System.out.println("Ingrese una palabra");
        palabra = scanner.next();

        for (int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);

            if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
                    contadorVocales++;
                }
            }

        int contadorConsonantes = palabra.length() - contadorVocales;

        System.out.println("Número de vocales: " + contadorVocales);
        System.out.println("Número de consonantes: " + contadorConsonantes);

        scanner.close();
    }
}