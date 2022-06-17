/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasoprogra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author estel
 */
public class programame_ProcesandoEntrada {

    /**
     * @param args the command line arguments
     */
    /*
    Entrada
    La entrada estará compuesta por varios casos de prueba. 
    Cada caso de prueba comienza con una línea que contiene el año y el nombre
    completo de una persona a la que se le concedió el título de Caballero y 
    por tanto desde ese año en adelante comenzó a llamársele Sir. 
    A continuación aparecerá una línea indicando el número de obras 
    publicadas por esa persona (entre 1 y 100), a la que le sigue una 
    línea por cada obra con el año y el título.

    Se garantiza que los años serán números positivos no mayores que 10.000,
    que después de cada año habrá un único espacio, y que la longitud de cada 
    línea no superará nunca los 100 caracteres.

    Ningún autor es lo suficientemente prolífico como para tener más de una obra por año.

    Salida
    Para cada caso de prueba se debe indicar cuál es la primera obra del autor
    en la que debe aparecer el título de Sir. Si no hay ninguna se indicará 
    NINGUNA y si todas las obras fueron creadas cuando el autor ya contaba con 
    el título de caballero, se escribirá TODAS.
    */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        /*InputStreamReader: clase que convierte de byte a carácter.
        Existe la posibilidad de conectar el objeto System.in con un objeto de 
        la clase InputStreamReader para leer los caracteres tecleados por el usuario.*/
        InputStreamReader inPuSt = new InputStreamReader(System.in);

        //resulta que leer con Scanner es menos mejor así que usamos BufferReader
        BufferedReader br = new BufferedReader(inPuSt);

        //declaramos como String la frase que introducimos (entrada) y la que recibimos (salidoa
        String entrada, salida;
        /*
        EJEMPLOS PALINDROMOS
        
        "No subas abusón"

        "Oí lo de mamá: me dolió"

        "Sometamos o matemos"

        "Yo dono rosas oro no doy"

        "Isaac no ronca así"

        "Lavan esa base naval"

        "No traces en ese cartón"

        "¿Será lodo o dólares?"
         */
        System.out.println("Introduce una cadena de carácteres: ");
        //leemos nuestra frase introducida con el BufferedReader
        entrada = br.readLine();
        //mientras que la entrada se diferente de XXX
        //"XXX" es como cuando en los menús poniamos que salir era igual a introducir ' 5 '
        while (!entrada.equals("XXX")) {
            //la hacemos mayúscula
            entrada = entrada.toUpperCase();
            //quitamos los espacios
            entrada = entrada.replace(" ", "");
            /*
            .reverse()=
            inPut (lo que entra) : abc
            outPut (lo que sale) : cba
             */
            salida = new StringBuilder(entrada).reverse().toString();
            //mostrar por pantalla
            System.out.println("Así es la frase introducida al principio: ");
            System.out.println(entrada);
            System.out.println("Así es la frase con el .reverse() aplicado: ");
            System.out.println(salida);

            //si la entrada es igual que la salida si es palíndroma
            if (entrada.equals(salida)) {
                System.out.println("SI (es palíndroma)");
            } else {
                System.out.println("NO (no es palíndroma)");
            }
            entrada = br.readLine();
        }//fin while
    }//fin main
}//fin class
