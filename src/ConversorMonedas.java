import java.util.Scanner;

public class ConversorMonedas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("**********************************");
            System.out.println("*  Conversor de Monedas          *");
            System.out.println("**********************************");
            System.out.println("1. Dólar a Peso Argentino");
            System.out.println("2. Peso Argentino a Dólar");
            System.out.println("3. Real Brasileño a Dólar");
            System.out.println("4. Dólar a Real Brasileño");
            System.out.println("5. Euro a Dólar");
            System.out.println("6. Dólar a Euro");
            System.out.println("7. Salir");
            System.out.print("Ingrese el número de la opción que desea: ");

            int opcion = scanner.nextInt();

            if (opcion == 7) {
                continuar = false;
                System.out.println("Gracias por usar el conversor de monedas. ¡Adiós!");
            } else {
                try {
                    realizarConversion(opcion, scanner);
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }

        scanner.close();
    }

    public static void realizarConversion(int opcion, Scanner scanner) throws Exception {
        double monto;
        Moneda monedaOrigen = null;
        Moneda monedaDestino = null;

        // Pedimos al usuario que ingrese el monto a convertir
        System.out.print("Ingrese el valor que desea convertir: ");
        monto = scanner.nextDouble();

        // Definimos las monedas según la opción seleccionada
        switch (opcion) {
            case 1:
                monedaOrigen = new Moneda("USD", ConsultaMoneda.obtenerTasaDeCambio("USD"));
                monedaDestino = new Moneda("ARS", ConsultaMoneda.obtenerTasaDeCambio("ARS"));
                break;
            case 2:
                monedaOrigen = new Moneda("ARS", ConsultaMoneda.obtenerTasaDeCambio("ARS"));
                monedaDestino = new Moneda("USD", ConsultaMoneda.obtenerTasaDeCambio("USD"));
                break;
            case 3:
                monedaOrigen = new Moneda("BRL", ConsultaMoneda.obtenerTasaDeCambio("BRL"));
                monedaDestino = new Moneda("USD", ConsultaMoneda.obtenerTasaDeCambio("USD"));
                break;
            case 4:
                monedaOrigen = new Moneda("USD", ConsultaMoneda.obtenerTasaDeCambio("USD"));
                monedaDestino = new Moneda("BRL", ConsultaMoneda.obtenerTasaDeCambio("BRL"));
                break;
            case 5:
                monedaOrigen = new Moneda("EUR", ConsultaMoneda.obtenerTasaDeCambio("EUR"));
                monedaDestino = new Moneda("USD", ConsultaMoneda.obtenerTasaDeCambio("USD"));
                break;
            case 6:
                monedaOrigen = new Moneda("USD", ConsultaMoneda.obtenerTasaDeCambio("USD"));
                monedaDestino = new Moneda("EUR", ConsultaMoneda.obtenerTasaDeCambio("EUR"));
                break;
            default:
                System.out.println("Opción no válida. Por favor, elija una opción correcta.");
                return;
        }

        // Realizamos la conversión
        double resultado = ConvertirMoneda.convertir(monedaOrigen, monedaDestino, monto);
        // Mostramos el resultado
        ConvertirMoneda.mostrarResultado(monto, monedaOrigen, monedaDestino, resultado);
    }
}
