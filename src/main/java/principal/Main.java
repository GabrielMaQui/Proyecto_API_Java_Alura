package principal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import modelos.ConversionHistorial;
import modelos.dto.ResponseApi;
import service.ConsumoAPI;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static String DOLAR = "USD";
    public static final String ARGENTINO = "ARS";
    public static final String BRAZIL = "BRL";
    public static final String COLOMBIANO = "COP";
    public static final String PERUANO = "PEN";
    private static List<ConversionHistorial> historial = new ArrayList<>();

    public static void main(String[] args) {
        cargarHistorial();
        Scanner teclado = new Scanner(System.in);
        int opc = 0;
        String cantidad = "";

        do {
            mostrarMenu();
            opc = teclado.nextInt();
            switch (opc) {
                case 1:
                    cantidad = cantidadRecibidad();
                    convertirMoneda(DOLAR, ARGENTINO, cantidad);
                    break;
                case 2:
                    cantidad = cantidadRecibidad();
                    convertirMoneda(ARGENTINO, DOLAR, cantidad);
                    break;
                case 3:
                    cantidad = cantidadRecibidad();
                    convertirMoneda(DOLAR, BRAZIL, cantidad);
                    break;
                case 4:
                    cantidad = cantidadRecibidad();
                    convertirMoneda(BRAZIL, DOLAR, cantidad);
                    break;
                case 5:
                    cantidad = cantidadRecibidad();
                    convertirMoneda(DOLAR, COLOMBIANO, cantidad);
                    break;
                case 6:
                    cantidad = cantidadRecibidad();
                    convertirMoneda(COLOMBIANO, DOLAR, cantidad);
                    break;
                case 7:
                    cantidad = cantidadRecibidad();
                    convertirMoneda(DOLAR, PERUANO, cantidad);
                    break;
                case 8:
                    cantidad = cantidadRecibidad();
                    convertirMoneda(PERUANO, DOLAR, cantidad);
                    break;
                case 9:
                    guardarHistorial();
                    System.out.println("Saliendo...");
                    break;
                case 10:
                    mostrarHistorial();
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        } while (opc != 9);
    }

    private static String cantidadRecibidad() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el valor que desea convertir");
        return teclado.nextLine();
    }


    public static void mostrarMenu() {
        System.out.println("****************************************");
        System.out.println("Sea bienvenido/a al Conversor de Moneda =]");
        System.out.println();
        System.out.println("1) Dólar => Peso argentino");
        System.out.println("2) Peso argentino => Dólar");
        System.out.println("3) Dólar => Real brasileño");
        System.out.println("4) Real brasileño => Dólar");
        System.out.println("5) Dólar => Peso colombiano");
        System.out.println("6) Peso colombiano => Dólar");
        System.out.println("7) Dolar => Sol Peruano");
        System.out.println("8) Sol Peruano => Dólar");
        System.out.println("9) Salir");
        System.out.println("10) Historial");
        System.out.println();
        System.out.print("Elija una opción válida: ");
        System.out.println("****************************************");
    }

    public static void convertirMoneda(String monedaInicial, String monedaConvertida, String cantidad) {
        ConsumoAPI api = new ConsumoAPI();
        ResponseApi json = api.obtenerConversion(monedaInicial, monedaConvertida, cantidad);
        String resultado = json.conversion_result();
        System.out.printf("El valor %s [%s] corresponde al valor final de =>>> %s [%s]", cantidad, monedaInicial, resultado, monedaConvertida);
        System.out.println();
        ConversionHistorial conversion = new ConversionHistorial(monedaInicial, monedaConvertida, cantidad, resultado);
        historial.add(conversion);

    }

    private static void guardarHistorial() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            mapper.writeValue(new File("historial_conversions.json"), historial);
            System.out.println("Historial guardado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void cargarHistorial() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            File file = new File("historial_conversions.json");
            if (file.exists()) {
                ConversionHistorial[] historialArray = mapper.readValue(file, ConversionHistorial[].class);
                historial.clear();
                historial.addAll(Arrays.asList(historialArray));
                System.out.println("Historial cargado correctamente.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void mostrarHistorial() {
        System.out.println("Historial de conversiones:");
        for (ConversionHistorial conversion : historial) {
            System.out.println(conversion);
        }
    }

}
