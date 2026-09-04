import java.util.Scanner;
public class Calculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        Double num1, num2, resultado;
        String operacion;

        System.out.println(" ");
        System.out.println("Bienvenido a la calculadora básica");
        System.out.println(" ");
        System.out.println("Ingrese el primer número: ");
        num1 = scanner.nextDouble();
        System.out.println("Ingrese el segundo número: ");
        num2 = scanner.nextDouble();
        System.out.println("Ingrese la operación que desea realizar (+, -, *, /): ");
        operacion = scanner.next();
        System.out.println(" ");
        
        switch (operacion) {
            case "+":
                resultado = num1 + num2;
                System.out.println("El resultado de la suma es: " + resultado);
                break;
            case "-":
                resultado = num1 - num2;
                System.out.println("El resultado de la resta es: " + resultado);
                break;
            case "*":
                resultado = num1 * num2;
                System.out.println("El resultado de la multiplicación es: " + resultado);
                break;
            case "/":
                if (num2 != 0) {
                    resultado = num1 / num2;
                    System.out.println("El resultado de la división es: " + resultado);
                } else {
                    System.out.println("Error: No se puede dividir entre cero.");
                }
                break;
            default:
                System.out.println("Operación no válida.");
        }
    scanner.close();
    }

}