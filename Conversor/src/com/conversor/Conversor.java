package com.conversor;

import org.json.simple.JSONObject;

public class Conversor {
    private com.conversor.ClienteApi clienteApi;
    private JSONObject tasasCambio;

    public Conversor() {
        clienteApi = new com.conversor.ClienteApi();
        try {
            tasasCambio = clienteApi.obtenerTasasCambio();
        } catch (Exception e) {
            System.err.println("Error al obtener las tasas de cambio: " + e.getMessage());
        }
    }

    public void mostrarMenu() {
        System.out.println("Bienvenido(a) a tu conversor de monedas");
        System.out.println("1. Dólares a Pesos Argentinos");
        System.out.println("2. Pesos Argentinos a Dólares");
        System.out.println("3. Euros a Dólares");
        System.out.println("4. Reales a Dólares");
        System.out.println("5. Dólares a Reales");
        System.out.println("6. Salir");
    }

    public void convertir(int opcion, double cantidad) {
        double resultado = 0;
        JSONObject conversionRates = (JSONObject) tasasCambio.get("conversion_rates");
        switch (opcion) {
            case 1:
                resultado = cantidad * ((Number) conversionRates.get("ARS")).doubleValue();
                System.out.printf("%.2f USD son %.2f ARS%n", cantidad, resultado);
                break;
            case 2:
                resultado = cantidad / ((Number) conversionRates.get("ARS")).doubleValue();
                System.out.printf("%.2f ARS son %.2f USD%n", cantidad, resultado);
                break;
            case 3:
                resultado = cantidad * ((Number) conversionRates.get("EUR")).doubleValue();
                System.out.printf("%.2f EUR son %.2f USD%n", cantidad, resultado);
                break;
            case 4:
                resultado = cantidad * ((Number) conversionRates.get("BRL")).doubleValue();
                System.out.printf("%.2f BRL son %.2f USD%n", cantidad, resultado);
                break;
            case 5:
                resultado = cantidad / ((Number) conversionRates.get("BRL")).doubleValue();
                System.out.printf("%.2f USD son %.2f BRL%n", cantidad, resultado);
                break;
            case 6:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción no válida");
        }
    }
}
