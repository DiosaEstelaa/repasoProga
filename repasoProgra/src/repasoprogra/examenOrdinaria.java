/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasoprogra;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import static java.util.stream.Collectors.toMap;
import java.util.stream.Stream;

/**
 *
 * @author estel
 */
public class examenOrdinaria {

    /**
     * @param args the command line arguments
     */
    /*
    El Ayuntamiento de Madrid quiere analizar los datos de intervenciones de los bomberos.
    Para ello te proporcionan el histórico de salidas mensuales por distritos de los últimos años (descomprime el archivo bomberos.zip). Crea un programa Java que cumpla los siguientes requisitos:
    a) Maneja los posibles errores y excepciones. Avisar al usuario correctamente en
    cada caso.
    b) No escribas todo el código directamente en la función ‘main’, implementa funciones adicionales para evitar repetir código y que el programa sea modular.
    c) Para que el programa sea eficiente, asegúrate de leer la información de los archivo una sola vez.
    d) Leerá los datos de los archivos y mostrará por pantalla la siguiente información:
    ◦ Intervención con más salidas y número de dichas salidas.
    ◦ Intervención con menos salidas y número de dichas salidas.
    ◦ Intervenciones media por mes y año.
    e) También almacenará el número de intervenciones por distrito en un HashMap.
    f) Tras mostrar los datos del apartado d) le preguntará al usuario de qué distrito
    quiere información, por ejemplo “SAN BLAS” y le mostrará las intervenciones totales para ese distrito.
    Fíjate que en los archivos, los datos están separados por “;”.
    Si te aparecen comillas al leer los archivos, crea una función que las elimine
     */
    //************************************************************************************************************************
    /////////////////////////////////////
    //FUNCIONES/MÉTODOS/////////////////////////////////////////////////////////
    /////////////////////////////////////
    public static void intervencionConMas_y_MenosSalidas(ArrayList<claseIntervencion> columnasIntervenciones_F) {
        //lo que hacemos aquí es usar un Map para guardar el nombre de la intervención y cantidad iniciada a 0
        Map<String, Integer> mapaIncidentes = Stream.of(
                new SimpleEntry<>("Fuegos", 0),
                new SimpleEntry<>("Daños construcción", 0),
                new SimpleEntry<>("Salvamentos y rescates", 0),
                new SimpleEntry<>("Daños agua", 0),
                new SimpleEntry<>("Incidentes diversos", 0),
                new SimpleEntry<>("Salidas sin intervención", 0),
                new SimpleEntry<>("Servicios varios", 0))
                .collect(toMap(SimpleEntry::getKey, SimpleEntry::getValue));

        /*
        El método replace() devuelve una nueva cadena con algunas o todas las 
        coincidencias de un patrón, siendo cada una de estas coincidencias 
        reemplazadas por remplazo. El patrón puede ser una cadena o una RegExp, 
        y el reemplazo puede ser una cadena o una función que será llamada para
        cada coincidencia. Si el patrón es una cadena, sólo la primera 
        coincidencia será reemplazada.
         */
        //por cada intervención de mi ArrayList de intervenciones:
        for (claseIntervencion intervencion : columnasIntervenciones_F) {
            mapaIncidentes.replace("Fuegos", (mapaIncidentes.get("Fuegos") + intervencion.getFuegos()));
            mapaIncidentes.replace("Daños construcción", (mapaIncidentes.get("Daños construcción") + intervencion.getFuegos()));
            mapaIncidentes.replace("Salvamentos y rescates", (mapaIncidentes.get("Salvamentos y rescates") + intervencion.getFuegos()));
            mapaIncidentes.replace("Daños agua", (mapaIncidentes.get("Daños agua") + intervencion.getFuegos()));
            mapaIncidentes.replace("Incidentes diversos", (mapaIncidentes.get("Incidentes diversos") + intervencion.getFuegos()));
            mapaIncidentes.replace("Salidas sin intervención", (mapaIncidentes.get("Salidas sin intervención") + intervencion.getFuegos()));
            mapaIncidentes.replace("Servicios varios", (mapaIncidentes.get("Servicios varios") + intervencion.getFuegos()));
        }//fin for

        List<Entry<String, Integer>> listaIncidentes = new ArrayList<>(mapaIncidentes.entrySet());
        //me da los valores ordenados de menor a mayor
        listaIncidentes.sort(Entry.comparingByValue());
        //para saber el mayor lo que hacemos es restar al tamaño del arraylist '1' para que nos de el último que nos interesa
        System.out.println("La mayor cantidad de incidentes esta provocada por " + listaIncidentes.get(listaIncidentes.size() - 1));
        //para saber el menor lo que hacemos es pedir la posición primera del arrayList, que en este caso es la posición'0'
        System.out.println("La menor cantidad de incidentes esta provocada por " + listaIncidentes.get(0));

    }//fin intervencionConMas_y_MenosSalidas
///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static claseIntervencion intervencionConMenosSalidas(ArrayList<claseIntervencion> columnasIntervenciones_F) {
        int numMenor = 10;
        int numControl;
        claseIntervencion laIntervencion = new claseIntervencion();
        for (claseIntervencion intervencion : columnasIntervenciones_F) {
            numControl = numMenor;
            if (intervencion.getFuegos() < numMenor) {
                numMenor = intervencion.getFuegos();
            }
            if (intervencion.getDaniosConstruc() < numMenor) {
                numMenor = intervencion.getDaniosConstruc();
            }
            if (intervencion.getSalvamentoRescates() < numMenor) {
                numMenor = intervencion.getSalvamentoRescates();
            }
            if (intervencion.getDaniosAgua() < numMenor) {
                numMenor = intervencion.getDaniosAgua();
            }
            if (intervencion.getIncidentesDiversos() < numMenor) {
                numMenor = intervencion.getIncidentesDiversos();
            }
            if (intervencion.getSalidasSinIntervencion() < numMenor) {
                numMenor = intervencion.getSalidasSinIntervencion();
            }
            if (intervencion.getServiciosVarios() < numMenor) {
                numMenor = intervencion.getServiciosVarios();
            }
            if (numControl > numMenor) {
                laIntervencion = intervencion;
            }
        }//fin for
        return laIntervencion;
    }//fin intervencionConMenosSalidas
///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void mediaMesAnioDeCadaIntervencion(ArrayList<claseIntervencion> columnasIntervencions_F) {
        //definimos un HashMap que lo llamamos 'lista' donde vamos a guardar el nombre de la intervención y su cantidad
        HashMap<String, Integer> lista = new HashMap<String, Integer>();
        //definimos variables
        String nombre;
        int intervencionesTotal;
        int contador = 0;
        //for-each para que me lea cada intervención del ArrayList columnasIntervencions_F que me llega del main
        for (claseIntervencion intervencion_F : columnasIntervencions_F) {//inicio for 1
            nombre = intervencion_F.getAnio() + " - " + intervencion_F.getMes();
            intervencionesTotal = intervencion_F.getTotal();
            if (lista.containsKey(nombre)) {
                int intervencionesPrevias = lista.get(nombre);
                lista.replace(nombre, (intervencionesTotal + intervencionesPrevias));
            } else {
                lista.put(nombre, intervencionesTotal);
            }//fin if
        }//fin for 1

        for (String fecha : lista.keySet()) {//inicio for 2
            String[] guiones = fecha.split("-");
            //esto nos va a servir para saber cuantas veces aparece una
            //intervencion con el mismo mes y año en el ArrayList ' ColumnasIntervenciones '
            for (claseIntervencion intervencion : columnasIntervencions_F) {//inicio for 3
                if (intervencion.getAnio().equals(guiones[0]) && intervencion.getMes().equals(guiones[1])) {
                    contador += 1;
                }//fin if
            }//fin for 3
            System.out.println("Media de incidentes de " + guiones[0] + " - " + guiones[1] + " : " + (lista.get(fecha) / contador));
        }//fin for 2
    }//fin intervencionPopular_yCantidad
///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void calcularIntervencionesMediasMesAnio(ArrayList<claseIntervencion> columnasIntervencions_F) {
        claseIntervencion intervencionBase = new claseIntervencion();
        ArrayList<claseIntervencion> intervencionesPorMesyAnio = new ArrayList<claseIntervencion>();
        for (claseIntervencion intervencion : columnasIntervencions_F) {
            if (intervencionBase.getAnio().equals(intervencion.getAnio()) && intervencionBase.getMes().equals(intervencion.getMes())) {
                intervencionBase.setTotal(intervencionBase.getTotal() + intervencion.getTotal());
            } else {
                intervencionesPorMesyAnio.add(intervencionBase);
                intervencionBase = new claseIntervencion();
                intervencionBase.setAnio(intervencion.getAnio());
                intervencionBase.setMes(intervencion.getMes());
                intervencionBase.setTotal(intervencion.getTotal());
            }//fin if
        }//fin for
        
        for (int i = 1; i < intervencionesPorMesyAnio.size(); i++) {
            System.out.println(intervencionesPorMesyAnio.get(i).getAnio() + " " + intervencionesPorMesyAnio.get(i).getMes() + " : " + (intervencionesPorMesyAnio.get(i).getTotal() / 22));
        }
    }//fin calcularIntervencionesMediasMesAnio
///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void calcularIntervencionesPorDistrito(ArrayList<claseIntervencion> columnasIntervencions_F) {
        claseIntervencion intervencionBase = new claseIntervencion();
        HashMap<String, Integer> lista = new HashMap<String, Integer>();
        String nombre;
        int totalIntervenciones;
        for (claseIntervencion intervencion : columnasIntervencions_F) {
            nombre = intervencion.getDistrito();
            totalIntervenciones = intervencion.getTotal();
            if (lista.containsKey(nombre)) {
                int intervencionesPrevias = lista.get(nombre);
                lista.replace(nombre, (totalIntervenciones + intervencionesPrevias));
            } else {
                lista.put(nombre, totalIntervenciones);
            }
        }//fin for
        boolean cierto = true;
        while (cierto) {
            Scanner leer = new Scanner(System.in);

            System.out.println("Por favor inserte un distrito");
            String nombreDistrito = leer.nextLine();
            if (lista.containsKey(nombreDistrito.toUpperCase())) {
                System.out.println("El distrito " + nombreDistrito.toUpperCase() + " tuvo: " + lista.get(nombreDistrito.toUpperCase()) + " incidentes.");
                cierto = false;
            } else {
                System.out.println("Ese distrito no existe, vuelva a insertar un distrito.");
            }//fin if
        }//fin while
    }//fin calcularIntervencionesPorDistrito
    //************************************************************************************************************************
    //************************************************************************************************************************
    //************************************************************************************************************************
    //************************************************************************************************************************
    //************************************************************************************************************************
    //************************************************************************************************************************
    //************************************************************************************************************************
    //************************************************************************************************************************
    
    /////////////////////////////////////
    //MAIN//////////////////////////////////////////////////////////////////////
    /////////////////////////////////////

    public static void main(String[] args) {
        // TODO code application logic here

        Scanner leer = new Scanner(System.in);

        /*
        trabajamos con el excel de bomberos donde hay once columnas. Vamos a meter
        cada columna en un ArrayList que llamaremos "intervenciones"
         */
        ArrayList<claseIntervencion> columnasIntervenciones = new ArrayList<claseIntervencion>();

        //para el manejo de errores trabajaremos el código en un try-catch
        try {

            //System.getProperty("user.dir") se usa para que coja la ruta del 
            //proyecto donde estamos trabajando. Esto es bueno para cuando el 
            //código se lee en otro pc y las rutas de guardado cambian
            String ruta = System.getProperty("user.dir");

            File carpetaBomberos = new File(ruta + File.separator + "Bomberos");
            /*
            con el listFiles() lo que hacemos es listar el contenido de la carpeta
            bomberos la cual contiene 6 excels (de 2017 a 2022). Lo metemos en un 
            Array que llamamos listaDeArchivos
             */
            File[] listaDeArchivos = carpetaBomberos.listFiles();
            //una vez tenemos listados nuestros 6 excels los vamos a leer con un for-each
            for (File archivo : listaDeArchivos) {
                //ahora creamos un nuevo File para dividirlos por año
                File ficheroPorAnio = new File(archivo.getPath());
                //sin el fichero existe...
                if (ficheroPorAnio.exists()) {//inicio if 1
                    //lo leemos con el Scanner
                    leer = new Scanner(ficheroPorAnio);
                    System.out.println(ficheroPorAnio.getAbsolutePath());
                    //le decimos al Scanner que cada vez que vea un ';' va a cortar esa línea más adelante con el split
                    leer.useDelimiter(";");
                    //mientras tenga algo que leer...
        
                    while (leer.hasNext()) {
                        //hacemos un Array de tipo String para que me vaya metiendo cada linea que corta cuando ve un ';' 
                        String[] linea = leer.nextLine().split(";");
                        //mayor que 2 para asegurarnos que tien cosas escritas
                        if (linea.length > 2) {//inicio if 2
                            /*
                            con ' !linea[9].equals("SERVICIOS VARIOS") ' mos aseguramos que haya hecho bien la partición
                            porque habiendo 11 columnas, pero empezando el Array en '0', la última posición que nos interesa
                            saber es la de "SERVICIOS VARIOS" que es la posición '9' (10 si no empiezas por 0).
                             */
                            if (!linea[9].equals("SERVICIOS VARIOS")) {//inicio if 3
                                claseIntervencion intervencion = new claseIntervencion(linea[0], linea[1], linea[2],
                                        linea[3], linea[4], linea[5], linea[6], linea[7], linea[8], linea[9], linea[10]);
                                columnasIntervenciones.add(intervencion);
                            }//fin if 3
                        }//fin if 2
                    }//fin while
                    //muy importante cerrar el ficherodespués de usar para que no de errores mas adelante
                    leer.close();
                }//fin if 1
            }//fin for-each

            //intervencionConMas_y_MenosSalidas(columnasIntervenciones);
            //System.out.println("");
            //claseIntervencion intervencion2=intervencionConMenosSalidas(columnasIntervenciones);
            //System.out.println(intervencion2.toString());
            System.out.println("");
            calcularIntervencionesMediasMesAnio(columnasIntervenciones);
            System.out.println("");
            //calcularIntervencionesPorDistrito(columnasIntervenciones);
        } catch (FileNotFoundException ex) {
            ex.getMessage();
        }
    }//fin main
}//fin class
