package principal;

import service.ConsumoAPI;

public class Main {

    public static void main(String[] args) {

        ConsumoAPI api = new ConsumoAPI();

        String json = api.obtenerDatos("USD");
        System.out.println(json);
    }
}
