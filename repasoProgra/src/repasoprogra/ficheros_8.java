/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasoprogra;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author estel
 */
public class ficheros_8 {

    /**
     * @param args the command line arguments
     */
    /*
    ENUNCIADO:
    Pide un número por teclado y leer el fichero usando Scanner, pero muestro solo 
    los que sean mayores que el número introducido
     */
    public static void main(String[] args) {
        File fichero_numeros = new File("C:\\Users\\estel\\Desktop\\numeros.txt");

        try {

            Scanner leer = new Scanner(fichero_numeros);
            Scanner leer_usuario = new Scanner(System.in);
            int num;
            int num_usuario;

            System.out.println("Introduce un número: ");
            num_usuario = leer_usuario.nextInt();

            while (leer.hasNext()) {
                num = leer.nextInt();

                if (num > num_usuario) {
                    System.out.println(num);

                }//fin if

            }//fin while

        } catch (FileNotFoundException ex) {

            System.out.println("fichero no encontrado");
        }

    }//fin main

}//fin class
