package principal;

import modelos.dto.ResponseApi;
import service.ConsumoAPI;

public class Main {

    public static void main(String[] args) {

        ConsumoAPI api = new ConsumoAPI();

        ResponseApi json = api.obtenerConversion("USD", "PEN", "1");
        System.out.println(json.result());
    }
}
