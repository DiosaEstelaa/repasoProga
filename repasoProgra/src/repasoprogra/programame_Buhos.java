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
public class programame_Buhos {

    /**
     * @param args the command line arguments
     */
    /*
    Entrada
    La entrada estará compuesta por múltiples casos de prueba. Cada caso de prueba
    es una única línea con una palabra o frase de no más de 100 caracteres. 
    En ella puede haber tanto letras mayúsculas como minúsculas del alfabeto 
    inglés y uno o varios espacios separando palabras (eso sí, las líneas empezarán 
    y terminarán siempre con letra, nunca con espacios). A riesgo de comprometer la
    ortografía y la semántica, las palabras no contendrán tildes y los signos de puntuación se omiten.

    El último caso de prueba va seguido de una línea con XXX que marca el 
    final y no debe ser procesada.

    Salida
    Por cada caso de prueba se escribirá SI si la palabra o frase es 
    palíndroma y NO en caso contrario.
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
