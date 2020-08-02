package com.mycompany.mensajeappI;

import java.util.Scanner;

public class Menu {

    public static void showMenu() {
        Scanner sc = new Scanner(System.in);
        int answer;

        do {
            System.out.println("*------*|*------*|*------*|*------*|*------*|*------*|*------*|*------*|*------*|*------*");
            System.out.println("Aplicacion de mensajes");
            System.out.println("1.- Crear mensaje.");
            System.out.println("2.- Listar mensajes.");
            System.out.println("3.- Editar mensaje.");
            System.out.println("4.- Eliminar mensaje.");
            System.out.println("5.- Salir");
            System.out.println("Seleccione un valor para acceder a la opcion (1 -5): ");
            answer = sc.nextInt();

            switch(answer){
                case 1:
                    MensajeService.crearMensaje();
                    break;
                case 2:
                    MensajeService.listarMensajes();
                    break;
                case 3:
                    MensajeService.editarMensaje();
                    break;
                case 4:
                    MensajeService.borrarMensaje();
                    break;
                default:
                    break;
            }
        } while (answer != 5);
    }
}
