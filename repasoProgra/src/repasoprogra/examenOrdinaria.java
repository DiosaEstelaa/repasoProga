/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasoprogra;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

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
    public static void mediaMesAnioDeCadaIntervencion(ArrayList<claseIntervencion>columnasIntervencions_F){
        //definimos un HashMap que lo llamamos 'lista' donde vamos a guardar el nombre de la intervención y su cantidad
        HashMap<String,Integer>lista=new HashMap<String,Integer>();
        //definimos variables
        String nombre;
        int intervencionesTotal;
        int contador=0;
        //for-each para que me lea cada intervención del ArrayList columnasIntervencions_F que me llega del main
        for(claseIntervencion intervencion_F:columnasIntervencions_F){//inicio for 1
            nombre=intervencion_F.getAnio()+" - "+intervencion_F.getMes();
            intervencionesTotal=intervencion_F.getTotal();
            if(lista.containsKey(nombre)){
                int intervencionesPrevias=lista.get(nombre);
                lista.replace(nombre, (intervencionesTotal+intervencionesPrevias));
            }else{
                lista.put(nombre, intervencionesTotal);
            }//fin if
        }//fin for 1
        
        for(String fecha:lista.keySet()){//inicio for 2
            String[]guiones=fecha.split("-");
            //esto nos va a servir para saber cuantas veces aparece una
            //intervencion con el mismo mes y año en el ArrayList ' ColumnasIntervenciones '
            for(claseIntervencion intervencion:columnasIntervencions_F){//inicio for 3
                if(intervencion.getAnio().equals(guiones[0])&& intervencion.getMes().equals(guiones[1])){
                   contador+=1; 
                }//fin if
            }//fin for 3
            System.out.println("Media de incidentes de " +guiones[0]+" - "+guiones[1]+ " : "+(lista.get(fecha)/contador));
        }//fin for 2
    }//intervencionPopular_yCantidad
    
    //************************************************************************************************************************
    /////////////////////////////////////
    //MAIN//////////////////////////////////////////////////////////////////////
    /////////////////////////////////////
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner leer = new Scanner(System.in);

        /*
        trabajamos con el excel de bomberos donde hay once columnas. Vamos a meter
        cada columna en un ArrayList que llamaremos "itervenciones"
        */
        ArrayList<claseIntervencion>columnasIntervenciones=new ArrayList<claseIntervencion>();
        
        //para el manejo de errores trabajaremos el código en un try-catch
        try{
            
            //System.getProperty("user.dir") se usa para que coja la ruta del 
            //proyecto donde estamos trabajando. Esto es bueno para cuando el 
            //código se lee en otro pc y las rutas de guardado cambian
            String ruta = System.getProperty("user.dir");
            
            File carpetaBomberos =new File(ruta+File.separator+"sources"+File.separator+"Bomberos");
            /*
            con el listFiles() lo que hacemos es listar el contenido de la carpeta
            bomberos la cual contiene 6 excels (de 2017 a 2022). Lo metemos en un 
            Array que llamamos listaDeArchivos
            */
            File[]listaDeArchivos=carpetaBomberos.listFiles();
            //una vez tenemos listados nuestros 6 excels los vamos a leer con un for-each
            for(File archivo:listaDeArchivos){
                //ahora creamos un nuevo File para dividirlos por año
                File ficheroPorAnio = new File(archivo.getPath());
                //sin el fichero existe...
                if(ficheroPorAnio.exists()){//inicio if 1
                    //lo leemos con el Scanner
                    leer=new Scanner(ficheroPorAnio);
                    //le decimos al Scanner que cada vez que vea un ';' va a cortar esa línea más adelante con el split
                    leer.useDelimiter(";");
                    //mientras tenga algo que leer...
                    while(leer.hasNext()){
                        //hacemos un Array de tipo String para que me vaya metiendo cada linea que corta cuando ve un ';' 
                        String[]linea=leer.nextLine().split(";");
                        //mayor que 2 para asegurarnos que tien cosas escritas
                        if(linea.length>2){//inicio if 2
                            /*
                            con ' !linea[9].equals("SERVICIOS VARIOS") ' mos aseguramos que haya hecho bien la partición
                            porque habiendo 11 columnas, pero empezando el Array en '0', la última posición que nos interesa
                            saber es la de "SERVICIOS VARIOS" que es la posición '9' (10 si no empiezas por 0).
                            
                            */
                            if(!linea[9].equals("SERVICIOS VARIOS")){//inicio if 3
                                claseIntervencion intervencion = new claseIntervencion(linea[0],linea[1],linea[2],
                                linea[3],linea[4],linea[5],linea[6],linea[7],linea[8],linea[9],linea[10]);
                                columnasIntervenciones.add(intervencion);
                            }//fin if 3
                        }//fin if 2
                    }//fin while
                    //muy importante cerrar el ficherodespués de usar para que no de errores mas adelante
                    leer.close();
                }//fin if 1
            }//fin for-each
            
            
        }catch(FileNotFoundException ex){
            ex.getMessage();
        }
    }//fin main
}//fin class
