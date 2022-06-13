/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package repasoprogra;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author DAW
 */
/*
ENUNCIADO:
Vamos a gestionar clientes desde un fichero binario usando Serialización.
Los datos del cliente son:
- DNI
- Nombre
- Teléfono
 Simplemente, ponle getters, setters y toString.
 Tendremos las siguientes opciones a modo de menú:
- Crear fichero: Crea el fichero sino existe, si existe indicarlo.
- Añadir cliente: Pide todos los datos del cliente, crea el objeto y lo mete en el fichero.
- Listar clientes: Muestra todos los clientes
- Borrar fichero: Borra el fichero, sino existe lo indica
- Salir: Salimos del programa
 Ten en cuenta, que tendremos que usar la clase MiObjectOutputStream a la hora de añadir clientes, si ya hay algún cliente.
 */
public class ficheros_13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        // TODO code application logic here
        Scanner leer = new Scanner(System.in);
        leer.useDelimiter("\n");

        boolean salir = false;
        int opcion;

        File fichero = new File("clientes.txt");

        String DNI, nombre, telefono;
        Cliente cliente1;

        while (!salir) {

            System.out.println("1. Crear fichero. ");
            System.out.println("2. Añadir cliente. ");
            System.out.println("3. Listar clientes. ");
            System.out.println("4. Borrar fichero. ");
            System.out.println("5. Salir del programa. ");

            try {
                System.out.println("Escribe una opción. ");
                opcion = leer.nextInt();

                switch (opcion) {

                    case 1:
                        if (fichero.exists()) {
                            System.out.println("El fichero ya esta creado ");
                        } else {
                            if (fichero.createNewFile()) {
                                System.out.println("Se ha creado el fichero ");
                            } else {
                                System.out.println("Ha habido un error al crear el fichero. ");
                            }
                        }

                        break;

                    case 2:
                        if (fichero.exists()) {
                            System.out.println("Introduce un DNI");
                            DNI = leer.next();
                            System.out.println("Introduce un nombre");
                            nombre = leer.next();
                            System.out.println("Introduce un telefono");
                            telefono = leer.next();
                            System.out.println("");

                            cliente1 = new Cliente(DNI, nombre, telefono);

                            ObjectOutputStream oos;

                            if (fichero.length() == 0) {
                                oos = new ObjectOutputStream(new FileOutputStream(fichero));
                                oos.writeObject(cliente1);
                            } else {
                                oos = new MiObjectOutputStream(new FileOutputStream(fichero, true));
                            }

                            oos.writeObject(cliente1);
                            System.out.println("Se ha añadido correctamente.");
                        } else {
                            System.out.println("Debes crear el fichero. ");
                        }

                        break;

                    case 3:
                        if (fichero.exists()) {
                            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
                            while (true) {
                                cliente1 = (Cliente) ois.readObject();
                                System.out.println(cliente1.toString());

                            }//fin while
                        } else {
                            System.out.println("Debes crear el fichero. ");
                        }

                    case 4:
                        if (fichero.exists()) {
                            fichero.delete();
                            System.out.println("El fichero se ha borrado. ");
                        } else {
                            System.out.println("No se puede borrar ya que no existe el fichero. ");
                        }

                        break;

                    case 5:
                        salir = true;
                        break;
                }//fin switch
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                leer.next();
            } catch (EOFException e) {
                System.out.println("No hay más clientes. ");
                leer.next();
            } catch (IOException | ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            }

        }//fin while

    }//fin main
}//fin class
