package modelos;

public class ConversionHistorial {
    private String monedaInicial;
    private String monedaConvertida;
    private String cantidad;
    private String resultado;

    // Constructor, getters, setters y toString
    public ConversionHistorial(String monedaInicial, String monedaConvertida, String cantidad, String resultado) {
        this.monedaInicial = monedaInicial;
        this.monedaConvertida = monedaConvertida;
        this.cantidad = cantidad;
        this.resultado = resultado;
    }

    public String getMonedaInicial() {
        return monedaInicial;
    }

    public void setMonedaInicial(String monedaInicial) {
        this.monedaInicial = monedaInicial;
    }

    public String getMonedaConvertida() {
        return monedaConvertida;
    }

    public void setMonedaConvertida(String monedaConvertida) {
        this.monedaConvertida = monedaConvertida;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "ConversionHistorial{" +
                "monedaInicial='" + monedaInicial + '\'' +
                ", monedaConvertida='" + monedaConvertida + '\'' +
                ", cantidad='" + cantidad + '\'' +
                ", resultado='" + resultado + '\'' +
                '}';
    }
}