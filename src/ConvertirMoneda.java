public class ConvertirMoneda {


        public static double convertir(Moneda monedaOrigen, Moneda monedaDestino, double monto) {

            double tasaOrigen = monedaOrigen.tasa();
            double tasaDestino = monedaDestino.tasa();
            return (monto / tasaOrigen) * tasaDestino;
        }

        public static void mostrarResultado(double monto, Moneda monedaOrigen, Moneda monedaDestino, double resultado) {
            System.out.printf("%.2f %s son equivalentes a %.2f %s%n",
                    monto, monedaOrigen.nombre(), resultado, monedaDestino.nombre());
        }


}
