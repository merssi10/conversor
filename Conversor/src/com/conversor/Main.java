package com.conversor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        com.conversor.Conversor conversor = new com.conversor.Conversor();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            conversor.mostrarMenu();
            System.out.print("Por favor, elija una opción: ");
            opcion = scanner.nextInt();
            if (opcion != 6) {
                System.out.print("Ingrese el valor a convertir: ");
                double valor = scanner.nextDouble();
                conversor.convertir(opcion, valor);
            }
        } while (opcion != 6);
    }
}
