/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package repasoprogra;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author DAW
 */
public class ficheros_11 {

    /**
     * @param args the command line arguments
     */
    /*
    ENUNCIADO:
    Lee el anterior fichero binario con DataInputStream. Despues pide un valor
    (expectativa salarial) y muestra aquellos registros que sean menores que ese dato.
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here

        try ( DataInputStream dis = new DataInputStream(new FileInputStream("candidatos.txt"))) {

            System.out.println("DNI\t\t\tNombre\t\tEdad\t\tExpec. Salar. ");
            String DNI, nombre;
            int edad;
            double exp_sal;

            while (true) {
                DNI = dis.readUTF();
                System.out.print(DNI+"\t\t");

                nombre = dis.readUTF();
                System.out.print(nombre+"\t\t");

                edad = dis.readInt();
                System.out.print(edad + "\t\t");

                exp_sal = dis.readDouble();
                System.out.print(exp_sal + "\t\t");

                System.out.println("");

            }//fin while

        } catch (EOFException ex) {
            System.out.println("Fin.");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("");
        System.out.println("");

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        System.out.println("Dame la expectativa salarial: ");
        double exp_sal_usur = sc.nextDouble();

        try ( DataInputStream dis = new DataInputStream(new FileInputStream("candidatos.txt"))) {

            System.out.println("DNI\t\t\tNombre\t\tEdad\t\tExpec. Salar. ");
            String DNI, nombre;
            int edad;
            double exp_sal;

            while (true) {
                DNI = dis.readUTF();

                nombre = dis.readUTF();

                edad = dis.readInt();

                exp_sal = dis.readDouble();

                if (exp_sal_usur > exp_sal) {
                    System.out.print(DNI + "\t\t");
                    System.out.print(nombre + "\t\t");
                    System.out.print(edad + "\t\t");
                    System.out.print(exp_sal + "\t\t");

                    System.out.println("");
                }

            }//fin while

        } catch (EOFException ex) {
            System.out.println("");
            System.out.println("Fin.");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }//fin main
}//fin class
