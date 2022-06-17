package javaordinariarepaso;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DAW
 */
public class Registro_Antonio {

    private String distrito;
    private String mes;
    private int year;
    private int numfuego;
    private int dConstruccion;
    private int salvamentosyrescates;
    private int danosporagua;
    private int incidentesdiversos;
    private int salidassinintervencion;
    private int serviciosvarios;
    private int total;

    public Registro_Antonio(String year, String mes, String distrito, String numfuego, String dConstruccion, String salvamentosyrescates,
            String danosporagua, String incidentesdiversos, String salidassinintervencion, String serviciosvarios, String total) {
        this.distrito = distrito;
        this.mes = mes;
        this.year = Integer.valueOf(year);
        this.numfuego = Integer.valueOf(numfuego);
        this.dConstruccion = Integer.valueOf(dConstruccion);
        this.salvamentosyrescates = Integer.valueOf(salvamentosyrescates);
        this.danosporagua = Integer.valueOf(danosporagua);
        this.incidentesdiversos = Integer.valueOf(incidentesdiversos);
        this.salidassinintervencion = Integer.valueOf(salidassinintervencion);
        this.serviciosvarios = Integer.valueOf(serviciosvarios);
        this.total = Integer.valueOf(total);
    }

    public String getDistrito() {
        return distrito;
    }

    public String getMes() {
        return mes;
    }

    public int getYear() {
        return year;
    }

    public int getNumfuego() {
        return numfuego;
    }

    public int getdConstruccion() {
        return dConstruccion;
    }

    public int getSalvamentosyrescates() {
        return salvamentosyrescates;
    }

    public int getDanosporagua() {
        return danosporagua;
    }

    public int getIncidentesdiversos() {
        return incidentesdiversos;
    }

    public int getSalidassinintervencion() {
        return salidassinintervencion;
    }

    public int getServiciosvarios() {
        return serviciosvarios;
    }

    public int getTotal() {
        return total;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setNumfuego(int numfuego) {
        this.numfuego = numfuego;
    }

    public void setdConstruccion(int dConstruccion) {
        this.dConstruccion = dConstruccion;
    }

    public void setSalvamentosyrescates(int salvamentosyrescates) {
        this.salvamentosyrescates = salvamentosyrescates;
    }

    public void setDanosporagua(int danosporagua) {
        this.danosporagua = danosporagua;
    }

    public void setIncidentesdiversos(int incidentesdiversos) {
        this.incidentesdiversos = incidentesdiversos;
    }

    public void setSalidassinintervencion(int salidassinintervencion) {
        this.salidassinintervencion = salidassinintervencion;
    }

    public void setServiciosvarios(int serviciosvarios) {
        this.serviciosvarios = serviciosvarios;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    /**
     *
     */
    @Override
    public String toString() {
        return "\nDistrito: " + distrito
                + "\nMes: " + mes
                + "\nAño: " + year
                + "\nNumeros de fuegos: " + numfuego
                + "\nDaños de construcción: " + dConstruccion
                + "\nSalvamentos y Rescates: " + salvamentosyrescates
                + "\nDaños por agua: " + danosporagua
                + "\nIncidentes diversos: " + incidentesdiversos
                + "\nSalidas sin intervencion: " + salidassinintervencion
                + "\nServicios varios: " + serviciosvarios
                + "\nTotal: " + total;
    }

}
