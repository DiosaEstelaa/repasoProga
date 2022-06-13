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

/*
ENUNCIADO:
Teniendo un fichero donde en cada linea hay un numero,
leer el fichero usando Scanner, muestra el contenido por pantalla
 */
public class ficheros_7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        File fichero_numeros = new File("C:\\Users\\estel\\Desktop\\numeros.txt");

        try {

            Scanner leer = new Scanner(fichero_numeros);
            int num;

            while (leer.hasNext()) {
                num = leer.nextInt();
                System.out.println(num);

            }//fin while

        } catch (FileNotFoundException ex) {

            System.out.println("fichero no encontrado");
        }

    }//fin main

}//fin class
