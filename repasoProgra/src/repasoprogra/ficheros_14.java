/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package repasoprogra;

import java.io.IOException;

/**
 *
 * @author DAW
 */
public class ficheros_14 {

    /**
     * @param args the command line arguments
     */
    /*
    A partir del codigo dado (ejercicio POO #11 del canal), crear dos métodos más en la clase 
    agenda que nos permita añadir contactos a un fichero con extension .age

    Un método será para exportar los contactos que tengamos en la actual agenda y otro que sea para 
    importar los contactos de un fichero que se le pase como parametro.

    Todo ello se hará con serialización, piensa que puedes cambiar.
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        Contacto c1 = new Contacto("Yoli", 111111111);
//        Contacto c2 = new Contacto("Paco", 222222222);
//        Contacto c3 = new Contacto("Paca", 333333333);
//        Contacto c4 = new Contacto("Pepe", 444444444);
//        Contacto c5 = new Contacto("Pepa", 555555555);
//
//        Agenda agenda = new Agenda();
//
//        agenda.aniadirContacto(c1);
//        agenda.aniadirContacto(c2);
//        agenda.aniadirContacto(c3);
//        agenda.aniadirContacto(c4);
//        agenda.aniadirContacto(c5);
//
//        agenda.exportarContactos();

        Agenda agenda = new Agenda();
        try {
            agenda.importarContactos("contactos.age");
            agenda.listarContactos();
        } catch (IOException | ClassNotFoundException ex) {

        }

    }//fin main
}//fin class
