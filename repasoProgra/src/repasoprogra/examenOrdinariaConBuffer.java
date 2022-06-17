/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasoprogra;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
public class examenOrdinariaConBuffer {

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
    public static ArrayList<claseIntervencion> leer(File f) throws FileNotFoundException, IOException {
        ArrayList<claseIntervencion> registros = new ArrayList<claseIntervencion>();
        for (File file : f.listFiles()) {

            if (file.isDirectory()) {
                System.out.println(file.getName());
            } else {

                try {

                    FileReader fr = new FileReader(file);
                    BufferedReader bf = new BufferedReader(fr);
                    String datos;

                    while ((datos = bf.readLine()) != null) {
                        String[] celdas = datos.split(";");
                        if (celdas.length > 1) {
                            if (!celdas[3].equals("FUEGOS")) {
                                claseIntervencion r1 = new claseIntervencion(celdas[0], celdas[1], celdas[2], celdas[3], celdas[4], celdas[5], celdas[6], celdas[7], celdas[8], celdas[9], celdas[10]);
                                registros.add(r1);
                                //System.out.println(registros);
                            }
                        }

                        /*                      
                        for (String celda : celdas) {
                            System.out.print(celda + " ");
                        }
                        System.out.print("\n -----------------------------------  \n");
                         */                        //System.out.println(datos);
                    }
                    fr.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
        return registros;
    }

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
        //variables
        int numMenor = 10;
        int numControl;
        //objeto de tipo intervención
        claseIntervencion laIntervencion = new claseIntervencion();
        //for-each para que me lea cada intervencion del ArrayList ' columnasIntervenciones_F '
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
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        Scanner leer1 = new Scanner(System.in);

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
            //esto es para que mire dento de la carpeta bomberos que está en el proyecto
            //ordenador clase:
            //File carpetaBomberos = new File("C:\\Users\\DAW\\Desktop\\repasoProga\\repasoProgra\\Bomberos");
            
            //ordenador casa
            File carpetaBomberos = new File("C:\\Users\\estel\\Documents\\GitHub\\repasoProga\\repasoProgra\\Bomberos");

                    
            columnasIntervenciones = leer(carpetaBomberos);

            //mostrar resultados con las funciones
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("");
            intervencionConMas_y_MenosSalidas(columnasIntervenciones);
            System.out.println("");
            System.out.println("--------------------------------------------------------------------------------------");
            claseIntervencion intervencion2 = intervencionConMenosSalidas(columnasIntervenciones);
            System.out.println(intervencion2.toString());
            System.out.println("");
            System.out.println("--------------------------------------------------------------------------------------");
            calcularIntervencionesMediasMesAnio(columnasIntervenciones);
            System.out.println("");
            System.out.println("--------------------------------------------------------------------------------------");
            calcularIntervencionesPorDistrito(columnasIntervenciones);
        } catch (FileNotFoundException ex) {
            ex.getMessage();
        }
    }//fin main
}//fin class
