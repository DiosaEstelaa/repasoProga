/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package repasoprogra;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author DAW
 */
/*
ENUNCIADO:
Nos piden guardar una serie de datos sobre los candiedatos a un puesto de trabajo en un fichero binario.
Debemos guardar lo siguiente: DNI, nombre, edad y expectativa salarial en ese orden. 
Usa Data Output Stream
 */
public class ficheros_10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leer = new Scanner(System.in);
        leer.useDelimiter("\n");
        leer.useLocale(Locale.US);

        boolean salir = false;

        do {

            System.out.println("Escribe un DNI: ");
            String dni = leer.next();

            System.out.println("Escribe un nombre: ");
            String nombre = leer.next();

            System.out.println("Escribe una edad: ");
            int edad = leer.nextInt();

            System.out.println("Escribe valor de expectativa salarial: ");
            double expectativaSalarial = leer.nextDouble();

            try ( DataOutputStream dos = new DataOutputStream(new FileOutputStream("candidatos.txt", true))) {

                dos.writeUTF(dni);
                dos.writeUTF(nombre);
                dos.writeInt(edad);
                dos.writeDouble(expectativaSalarial);
                System.out.println("Candidato añadido. ");

            } catch (IOException e) {
                System.out.println(e.getMessage());

            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
            
            System.out.println("Quieres añadir más candidatos? " );
            char respuesta = leer.next().toUpperCase().charAt(0);
            
            if (respuesta == 'N'){
                salir=true;
            }

        } while (!salir);

    }//fin main
}//fin class
