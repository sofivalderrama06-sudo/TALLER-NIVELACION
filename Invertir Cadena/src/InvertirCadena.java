import java.util.Scanner;

public class InvertirCadena {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cadena;
        
        System.out.println(" ");
        System.out.println("Invertir Cadena");
        System.out.println(" ");
        System.out.println("Ingrese una cadena de texto: ");
        cadena = scanner.nextLine();
        
        String cadenaInvertida = "";
        
        for (int i = cadena.length() - 1; i >= 0; i--) {
            cadenaInvertida += cadena.charAt(i);
        }
        
        System.out.println("La cadena invertida es: " + cadenaInvertida);
        
        scanner.close();
    }
}