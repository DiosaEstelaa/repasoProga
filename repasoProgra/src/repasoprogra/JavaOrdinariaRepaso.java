/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaordinariarepaso;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import static java.lang.reflect.Array.get;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author DAW
 */
public class JavaOrdinariaRepaso {

    public static ArrayList<Registro> leer(File f) throws FileNotFoundException, IOException {
        ArrayList<Registro> registros = new ArrayList<Registro>();
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
                                Registro r1 = new Registro(celdas[0], celdas[1], celdas[2], celdas[3], celdas[4], celdas[5], celdas[6], celdas[7], celdas[8], celdas[9], celdas[10]);
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

    public static void registroMasGrande(ArrayList<Registro> registros) {
        try {
            int totalFuegos = 0;
            int totaldConstruccion = 0;
            int totalSalvamentosyRescates = 0;
            int totalDanosporagua = 0;
            int totalIncidentesDiversos = 0;
            int totalSalidasSinIntervencion = 0;
            int totalServiciosVarios = 0;
            for (Registro r : registros) {
                totalFuegos += r.getNumfuego();
                totaldConstruccion += r.getdConstruccion();
                totalSalvamentosyRescates += r.getSalvamentosyrescates();
                totalDanosporagua += r.getDanosporagua();
                totalIncidentesDiversos += r.getIncidentesdiversos();
                totalSalidasSinIntervencion += r.getSalidassinintervencion();
                totalServiciosVarios += r.getServiciosvarios();
            }

            if (totalFuegos > totaldConstruccion && totalFuegos > totalSalvamentosyRescates
                    && totalFuegos > totalDanosporagua && totalFuegos > totalIncidentesDiversos && totalFuegos > totalSalidasSinIntervencion
                    && totalFuegos > totalServiciosVarios) {
                System.out.println("El mayor numero de incidentes por fuegos es " + totalFuegos);
            }

            if (totaldConstruccion > totalFuegos && totaldConstruccion > totalSalvamentosyRescates
                    && totaldConstruccion > totalDanosporagua && totaldConstruccion > totalIncidentesDiversos
                    && totaldConstruccion > totalSalidasSinIntervencion && totaldConstruccion > totalServiciosVarios) {
                System.out.println("El mayor numero de incidentes por Construccion es " + totaldConstruccion);
            }

            if (totalSalvamentosyRescates > totalFuegos && totalSalvamentosyRescates > totaldConstruccion
                    && totalSalvamentosyRescates > totalDanosporagua && totalSalvamentosyRescates > totalIncidentesDiversos
                    && totalSalvamentosyRescates > totalSalidasSinIntervencion && totalSalvamentosyRescates > totalServiciosVarios) {
                System.out.println("El mayor numero de incidentes por Salvamentos y Rescates es " + totalSalvamentosyRescates);
            }

            if (totalDanosporagua > totalFuegos && totalDanosporagua > totaldConstruccion && totalDanosporagua > totalSalvamentosyRescates
                    && totalDanosporagua > totalIncidentesDiversos && totalDanosporagua > totalSalidasSinIntervencion
                    && totalDanosporagua > totalServiciosVarios) {
                System.out.println("El mayor numero de incidentes por Daños de agua es " + totalDanosporagua);
            }

            if (totalIncidentesDiversos > totalFuegos && totalIncidentesDiversos > totaldConstruccion && totalIncidentesDiversos > totalSalvamentosyRescates
                    && totalIncidentesDiversos > totalDanosporagua && totalIncidentesDiversos > totalSalidasSinIntervencion
                    && totalIncidentesDiversos > totalServiciosVarios) {
                System.out.println("El mayor numero de incidentes por Incidentes Diversos es " + totalIncidentesDiversos);
            }

            if (totalSalidasSinIntervencion > totalFuegos && totalSalidasSinIntervencion > totaldConstruccion && totalSalidasSinIntervencion > totalSalvamentosyRescates
                    && totalSalidasSinIntervencion > totalDanosporagua && totalSalidasSinIntervencion > totalIncidentesDiversos
                    && totalSalidasSinIntervencion > totalServiciosVarios) {
                System.out.println("El mayor numero de incidentes por Salidas Sin Intervencion es " + totalSalidasSinIntervencion);
            }

            if (totalServiciosVarios > totalFuegos && totalServiciosVarios > totaldConstruccion && totalServiciosVarios > totalSalvamentosyRescates
                    && totalServiciosVarios > totalDanosporagua && totalServiciosVarios > totalIncidentesDiversos
                    && totalServiciosVarios > totalSalidasSinIntervencion) {
                System.out.println("El mayor numero de incidentes por Servicios Varios es " + totalServiciosVarios);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("**************************************");
    }

    public static void registroMasPequeno(ArrayList<Registro> registros) {
        try {
            int totalFuegos = 0;
            int totaldConstruccion = 0;
            int totalSalvamentosyRescates = 0;
            int totalDanosporagua = 0;
            int totalIncidentesDiversos = 0;
            int totalSalidasSinIntervencion = 0;
            int totalServiciosVarios = 0;
            for (Registro r : registros) {
                totalFuegos += r.getNumfuego();
                totaldConstruccion += r.getdConstruccion();
                totalSalvamentosyRescates += r.getSalvamentosyrescates();
                totalDanosporagua += r.getDanosporagua();
                totalIncidentesDiversos += r.getIncidentesdiversos();
                totalSalidasSinIntervencion += r.getSalidassinintervencion();
                totalServiciosVarios += r.getServiciosvarios();
            }
            if (totalFuegos < totaldConstruccion && totalFuegos < totalSalvamentosyRescates
                    && totalFuegos < totalDanosporagua && totalFuegos < totalIncidentesDiversos && totalFuegos < totalSalidasSinIntervencion
                    && totalFuegos < totalServiciosVarios) {
                System.out.println("El menor numero de incidentes por fuegos es " + totalFuegos);
            }

            if (totaldConstruccion < totalFuegos && totaldConstruccion < totalSalvamentosyRescates
                    && totaldConstruccion < totalDanosporagua && totaldConstruccion < totalIncidentesDiversos
                    && totaldConstruccion < totalSalidasSinIntervencion && totaldConstruccion < totalServiciosVarios) {
                System.out.println("El menor numero de incidentes por Construccion es " + totaldConstruccion);
            }

            if (totalSalvamentosyRescates < totalFuegos && totalSalvamentosyRescates < totaldConstruccion
                    && totalSalvamentosyRescates < totalDanosporagua && totalSalvamentosyRescates < totalIncidentesDiversos
                    && totalSalvamentosyRescates < totalSalidasSinIntervencion && totalSalvamentosyRescates < totalServiciosVarios) {
                System.out.println("El menor numero de incidentes por Salvamentos y Rescates es " + totalSalvamentosyRescates);
            }

            if (totalDanosporagua < totalFuegos && totalDanosporagua < totaldConstruccion && totalDanosporagua < totalSalvamentosyRescates
                    && totalDanosporagua < totalIncidentesDiversos && totalDanosporagua < totalSalidasSinIntervencion
                    && totalDanosporagua < totalServiciosVarios) {
                System.out.println("El menor numero de incidentes por Daños de agua es " + totalDanosporagua);
            }

            if (totalIncidentesDiversos < totalFuegos && totalIncidentesDiversos < totaldConstruccion && totalIncidentesDiversos < totalSalvamentosyRescates
                    && totalIncidentesDiversos < totalDanosporagua && totalIncidentesDiversos < totalSalidasSinIntervencion
                    && totalIncidentesDiversos < totalServiciosVarios) {
                System.out.println("El menor numero de incidentes por Incidentes Diversos es " + totalIncidentesDiversos);
            }

            if (totalSalidasSinIntervencion < totalFuegos && totalSalidasSinIntervencion < totaldConstruccion && totalSalidasSinIntervencion < totalSalvamentosyRescates
                    && totalSalidasSinIntervencion < totalDanosporagua && totalSalidasSinIntervencion < totalIncidentesDiversos
                    && totalSalidasSinIntervencion < totalServiciosVarios) {
                System.out.println("El menor numero de incidentes por Salidas Sin Intervencion es " + totalSalidasSinIntervencion);
            }

            if (totalServiciosVarios < totalFuegos && totalServiciosVarios < totaldConstruccion && totalServiciosVarios < totalSalvamentosyRescates
                    && totalServiciosVarios < totalDanosporagua && totalServiciosVarios < totalIncidentesDiversos
                    && totalServiciosVarios < totalSalidasSinIntervencion) {
                System.out.println("El menor numero de incidentes por Servicios Varios es " + totalServiciosVarios);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("**************************************");
    }

    public static void intervencionesPorMes(ArrayList<Registro> registros) {
        try {
            HashMap<String, Integer> mes = new HashMap<String, Integer>();
            for (Registro m : registros) {
                if (mes.containsKey(m.getMes())) {
                    mes.replace(m.getMes(), m.getTotal() + mes.get(m.getMes()));
                } else {
                    mes.put(m.getMes(), m.getTotal());
                }
            }
            for (String mess : mes.keySet()) {
                int intervenciones = mes.get(mess);
                System.out.println("Mes " + mess + "," + "INTERVENCIONES: " + intervenciones);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("**************************************");
    }

    public static void intervencionesPorAno(ArrayList<Registro> registros) {
        try {
            HashMap<Integer, Integer> ano = new HashMap<Integer, Integer>();
            for (Registro a : registros) {
                if (ano.containsKey(a.getYear())) {
                    ano.replace(a.getYear(), a.getTotal() + ano.get(a.getYear()));
                } else {
                    ano.put(a.getYear(), a.getTotal());
                }
            }
            for (Integer anoo : ano.keySet()) {
                int intervenciones = ano.get(anoo);
                System.out.println("AÑO " + anoo + "," + "INTERVENCIONES: " + intervenciones);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("**************************************");
    }

    public static void intervencionesMediaPorMesYaño(ArrayList<Registro> registros) {
        try {
            HashMap<String, Integer> media = new HashMap<String, Integer>();
            for (Registro d : registros) {

                if (media.containsKey(d.getYear() + "-" + d.getMes())) {
                    media.replace(d.getYear() + "-" + d.getMes(), d.getTotal() + media.get(d.getYear() + "-" + d.getMes()));
                } else {
                    media.put(d.getYear() + "-" + d.getMes(), d.getTotal());
                }
            }
            for (String AM : media.keySet()) {
                int intervenciones = media.get(AM);
                System.out.println(AM + "," + " NUMERO DE INTERVENCIONES: " + intervenciones);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("**************************************");

    }

    public static void intervencionesPorDistrito(ArrayList<Registro> registros) {
        try {
            HashMap<String, Integer> distritos = new HashMap<String, Integer>();
            //String totalDistritos = " ";
            //int totalIntervenciones = 0;
            for (Registro d : registros) {

                if (distritos.containsKey(d.getDistrito())) {
                    distritos.replace(d.getDistrito(), d.getTotal() + distritos.get(d.getDistrito()));
                } else {
                    distritos.put(d.getDistrito(), d.getTotal());
                }
            }
            for (String distrito : distritos.keySet()) {
                int intervenciones = distritos.get(distrito);
                System.out.println("DISTRITO: " + distrito + "," + " NUMERO DE INTERVENCIONES: " + intervenciones);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("**************************************");
    }

    public static void main(String[] args) {
        try {
            File f = new File("F:\\programacion\\Bomberos\\Bomberos");
            ArrayList<Registro> guardarResultado = leer(f);
            registroMasGrande(guardarResultado);
            registroMasPequeno(guardarResultado);
            intervencionesPorMes(guardarResultado);
            intervencionesPorAno(guardarResultado);
            intervencionesMediaPorMesYaño(guardarResultado);
            intervencionesPorDistrito(guardarResultado);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
