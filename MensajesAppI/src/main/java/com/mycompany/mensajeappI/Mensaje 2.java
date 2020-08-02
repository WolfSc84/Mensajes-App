package com.mycompany.mensajeappI;

public class Mensaje {
    int IdMessage;
    String message;
    String authorMessage;

    public Mensaje(String message, String authorMessage) {
        this.message = message;
        this.authorMessage = authorMessage;
        System.out.println("Mensaje preparado para ser enviado.");
    }

    public Mensaje(){}

    public int getIdMessage() {
        return IdMessage;
    }

    public void setIdMenssage(int IdMessage) {
        this.IdMessage = IdMessage;
    }

    public String getMessage() {
        return message;
    }

    public String getAuthorMessage() {
        return authorMessage;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setAuthorMessage(String authorMessage) {
        this.authorMessage = authorMessage;
    }

}
