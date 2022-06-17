/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasoprogra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

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
        final Scanner leer = new Scanner(System.in);

        //declaramos variables
        String primeraObra;
        boolean cadaUno;
        int anio, anioMasReciente;

        /*
        Entrada de ejemplo
        1902 Connan Doyle
        3
        1892 Las aventuras de Sherlock Holmes
        1905 El retorno de Sherlock Holmes
        1902 El sabueso de los Baskerville
        2000 Sean Connery
        3
        1989 Indiana Jones y la ultima cruzada
        1963 Desde Rusia con amor
        1987 Los intocables de Eliot Ness
        
        Salida de ejemplo
        El sabueso de los Baskerville
        NINGUNA
         */
        System.out.println("Introduce año y obra. (en ese orden). ");
        while (leer.hasNext()) {
            System.out.println("Introduce un año: ");
            anio = leer.nextInt();
            leer.nextLine();

            anioMasReciente = Integer.MAX_VALUE;
            cadaUno = true;
            primeraObra = null;
            for (int i = leer.nextInt(); i > 0; i--) {
                int anioActual;
                String obraActual;
                System.out.println("Introduce un año: ");
                anioActual = leer.nextInt();
                System.out.println("Introduce una obra: ");
                obraActual = leer.nextLine();
                boolean mayorQuePrimeraObra = anioActual >= anio;
                if (mayorQuePrimeraObra && (anioActual - anio < anioMasReciente)) {
                    primeraObra = obraActual;
                    anioMasReciente = anioActual - anio;
                }//fin if
                cadaUno = cadaUno && mayorQuePrimeraObra;
            }//fin for
            if (cadaUno) {
                System.out.println("TODAS");
            } else {
                if (primeraObra == null) {
                    System.out.println("NINGUNA");
                } else {
                    System.out.println(primeraObra.trim());
                    /*
                    Descripción
                    Método que elimina los caracteres blancos iniciales y finales
                    de la cadena, devolviendo una copia de la misma.
                     */
                }
            }
        }//fin while
    }//fin main
}//fin class
