/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasoprogra;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author estel
 */
public class ficheros_9 {

    /**
     * @param args the command line arguments
     */
    /*
    ENUNCIADO:
    Lo mismo que el anterior pero guarada el resultado en otro fichero
     */
    public static void main(String[] args) {
        File fichero_numeros = new File("C:\\Users\\estel\\Desktop\\numeros.txt");
        File ficheroSalida = new File("C:\\Users\\estel\\Desktop\\numeros_mayores.txt");

        try {

            Scanner leer = new Scanner(fichero_numeros);
            Scanner leer_usuario = new Scanner(System.in);
            PrintWriter pw = new PrintWriter(ficheroSalida);
            int num;
            int num_usuario;

            System.out.println("Introduce un número: ");
            num_usuario = leer_usuario.nextInt();

            while (leer.hasNext()) {
                num = leer.nextInt();

                if (num > num_usuario) {
                    pw.println(num);

                }//fin if
            }//fin while
            leer.close();
            leer_usuario.close();
            pw.close();

        } catch (FileNotFoundException ex) {

            System.out.println("fichero no encontrado");
        }

    }//fin main

}//fin class
