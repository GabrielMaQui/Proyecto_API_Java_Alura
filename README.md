# Conversor de Moneda

Este proyecto es una aplicación de consola en Java que permite convertir entre diferentes monedas. Utiliza una API externa para obtener las tasas de conversión actualizadas y guarda un historial de conversiones en un archivo JSON.

## Funcionalidades

- Convertir entre diferentes monedas:
  - Dólar (USD) => Peso argentino (ARS)
  - Peso argentino (ARS) => Dólar (USD)
  - Dólar (USD) => Real brasileño (BRL)
  - Real brasileño (BRL) => Dólar (USD)
  - Dólar (USD) => Peso colombiano (COP)
  - Peso colombiano (COP) => Dólar (USD)
  - Dólar (USD) => Sol peruano (PEN)
  - Sol peruano (PEN) => Dólar (USD)
- Guardar un historial de conversiones en un archivo JSON.
- Cargar y mostrar el historial de conversiones al iniciar la aplicación.

## Requisitos

- Java 8 o superior
- Biblioteca Jackson para el manejo de JSON

## Instalación

1. Clona el repositorio o descarga el código fuente.
2. Abre el proyecto en tu IDE favorito (Eclipse, IntelliJ, etc.).
3. Asegúrate de tener las dependencias de Jackson en tu `pom.xml` si estás usando Maven. Agrega lo siguiente a tu archivo `pom.xml`:
   
    ```xml
    <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-databind</artifactId>
        <version>2.13.0</version>
    </dependency>
    ```

4. Si no estás usando Maven, descarga las bibliotecas de Jackson manualmente y agrégalas al classpath de tu proyecto.

## Uso

1. Ejecuta la clase `Main`.
2. El menú principal se mostrará en la consola:

    ```
    ****************************************
    Sea bienvenido/a al Conversor de Moneda =]
    
    1) Dólar => Peso argentino
    2) Peso argentino => Dólar
    3) Dólar => Real brasileño
    4) Real brasileño => Dólar
    5) Dólar => Peso colombiano
    6) Peso colombiano => Dólar
    7) Dólar => Sol Peruano
    8) Sol Peruano => Dólar
    9) Salir
    10) Mostrar Historial de Conversiones
    
    Elija una opción válida: 
    ****************************************
    ```

3. Selecciona una opción ingresando el número correspondiente.
4. Sigue las instrucciones para ingresar la cantidad a convertir.
5. El resultado de la conversión se mostrará en la consola.
6. Si seleccionas la opción 9, el programa se cerrará y el historial de conversiones se guardará en un archivo JSON llamado `historial_conversions.json`.
7. Si seleccionas la opción 10, se mostrará el historial de conversiones.

## Ejemplo de Conversión

```plaintext
Ingrese el valor que desea convertir:
100
El valor 100 [USD] corresponde al valor final de =>>> 9200 [ARS]
