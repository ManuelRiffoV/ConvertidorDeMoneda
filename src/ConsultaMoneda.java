
    import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

    public class ConsultaMoneda {

        private static final String API_URL = "https://v6.exchangerate-api.com/v6/767809b5d3dae0ef21d2ae71/latest/USD";

        public static double obtenerTasaDeCambio(String codigoMoneda) throws Exception {
            URL url = new URL(API_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");


            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }


            in.close();
            conn.disconnect();


            String jsonResponse = content.toString();
            return procesarTasaDeCambio(jsonResponse, codigoMoneda);
        }

        private static double procesarTasaDeCambio(String jsonResponse, String codigoMoneda) {
            if (jsonResponse.contains(codigoMoneda)) {
                String tasaString = jsonResponse.split(codigoMoneda + "\":")[1].split(",")[0];
                return Double.parseDouble(tasaString);
            } else {
                throw new IllegalArgumentException("Moneda no encontrada en la respuesta de la API");
            }
        }
    }




