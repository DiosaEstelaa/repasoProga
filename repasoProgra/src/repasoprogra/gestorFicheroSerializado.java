/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasoprogra;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author DAW
 */

/*
Vamos a crear un gestor de fichero serializado. Contendra lo siguiente:
 
 - Atributos: fichero y arraylist de objetos.
 - obtenerDatos(): trae toda la informacion de un fichero.
 - guardarDato(objeto): guarda un objeto en el fichero y en la lista
 */
public class gestorFicheroSerializado<T> {

    private File fichero;
    private ArrayList<T> datos;

    public gestorFicheroSerializado(String fichero) throws IOException, FileNotFoundException, ClassNotFoundException {

        this.fichero = new File(fichero);
        this.datos = new ArrayList();
        obtenerDatos();

    }

    public gestorFicheroSerializado(File fichero) throws IOException, FileNotFoundException, ClassNotFoundException {
        this.fichero = fichero;
        this.datos = new ArrayList();
        obtenerDatos();
    }

    public void obtenerDatos() throws FileNotFoundException, IOException, ClassNotFoundException {

        if (fichero.exists()) {
            T elemento;
            try ( ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
                while (true) {
                    elemento = (T) ois.readObject();
                    datos.add(elemento);
                }

            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            } catch (EOFException ex) {

            } catch (IOException ex) {
                System.out.println(ex.getMessage());

            } catch (ClassNotFoundException ex) {
                System.out.println(ex.getMessage());

            }
        }//fin if

    }//fin obtenerDatos

    public void guardarDato(T elemento) {

        if (fichero.exists() && fichero.length() > 0) {
            try ( MiObjectOutputStream oos = new MiObjectOutputStream(new FileOutputStream(fichero, true))) {
                oos.writeObject(elemento);
                datos.add(elemento);

            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());

            } catch (IOException ex) {
                System.out.println(ex.getMessage());

            }

        } else {
            try ( ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero, true))) {
                oos.writeObject(elemento);
                datos.add(elemento);

            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());

            } catch (IOException ex) {
                System.out.println(ex.getMessage());

            }

        }

        datos.add(elemento);

    }//fin guardarDato

    public ArrayList<T> getDatos() {
        return datos;
    }

    /*Muestra los datos de la lista, la clase debe terner un toString*/
    public void mostrarDatos() {
        for (T e : datos) {
            System.out.println(e);
        }//fin for
    }//fin mostrarDatos

    public boolean existeDato(T elemento) {

        for (T e : datos) {
            if (e.equals(elemento)) {
                return true;

            }//fin if
        }//fin for
        return false;
    }// fin existeDato

    public void borrarDato(T elemento) {

        if (datos.remove(elemento)) {
            ArrayList<T> copia = datos;
            datos = new ArrayList<>();
            fichero.delete();

            for (T e : datos) {
                guardarDato(e);
                
            }//fin for
        }//fin if

    }//fin borrarDato

}//fin class
