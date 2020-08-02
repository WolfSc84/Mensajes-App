/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mensajeapp;

import java.sql.Connection;

/**
 *
 * @author bw84
 */
public class Inicio {

    public static void main(String[] args){
        Conexion conexions = new Conexion();

        try(Connection cnx = conexions.get_connection()){

        } catch (Exception throwables) {
            throwables.printStackTrace();
            System.out.println(throwables);
        }


    }
}
