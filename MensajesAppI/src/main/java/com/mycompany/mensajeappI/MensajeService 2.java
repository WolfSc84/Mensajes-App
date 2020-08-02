package com.mycompany.mensajeappI;

import java.util.Scanner;

public class MensajeService {

    public static void crearMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje: ");
        String texto = sc.nextLine();

        System.out.println("Escribe tu nombre: ");
        String nombre = sc.nextLine();

        Mensaje registro = new Mensaje(texto,nombre);
        MensajeDAO.crearMensajeDB(registro);

    }

    public static void listarMensajes(){
        MensajeDAO.leerMensajesDB();
    }

    public static void borrarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Indique el id del mensaje que desea eliminar: ");
        int idBorrar = sc.nextInt();

        MensajeDAO.borrarMensajesDB(idBorrar);


    }

    public static void editarMensaje() {
        Scanner sci = new Scanner(System.in);
        System.out.println("Indique el id del mensaje que desea editar: ");
        int idBorrar = sci.nextInt();

        Scanner sc = new Scanner(System.in);
        System.out.println("Indique el mensaje que deseas editar: ");
        String mensajeE = sc.nextLine();

        Mensaje mensajeActualizar = new Mensaje();
        mensajeActualizar.setIdMenssage(idBorrar);
        mensajeActualizar.setMessage(mensajeE);

        MensajeDAO.actualizarMensajesDB(mensajeActualizar);
    }
}
