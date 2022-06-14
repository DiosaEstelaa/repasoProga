/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasoprogra;

/**
 *
 * @author estel
 */
public class claseIntervencion {

    /////////////////////////////////////
    //VARIABLES/////////////////////////////////////////////////////////////////
    /////////////////////////////////////
    /*el documento con el que vamos a trabajar es como un excel, va por filas y
    columna, en total son 11 apartados(columnas). Vamos a declarar cada apartado
    como una variable. 11 variables en total
     */
    private String anio="";
    private String mes="";
    private String distrito="";
    private int fuegos=0;
    private int daniosConstruc=0;
    private int salvamentoRescates=0;
    private int daniosAgua=0;
    private int incidentesDiversos=0;
    private int salidasSinIntervencion=0;
    private int serviciosVarios=0;
    private int total=0;

    /////////////////////////////////////
    //CONSTRUCTORES/////////////////////////////////////////////////////////////
    /////////////////////////////////////
    //el vacío siempre lo pongo por si acaso
    public claseIntervencion() {
    }

    // este es para cuando tengamos que hacer la media por mes y año
    public claseIntervencion(String anio, String mes, int total) {
        this.anio = anio;
        this.mes = mes;
        this.total = total;
    }

    // el con toas las cosas
    public claseIntervencion(String anio, String mes, String distrito, String fuegos,
            String daniosConstruc, String salvamentoRescates, String daniosAgua,
            String incidentesDiversos, String salidasSinIntervencion, 
            String serviciosVarios, String total) {
        this.anio = anio;
        this.mes = mes;
        this.distrito = distrito;
        this.fuegos = Integer.parseInt(fuegos) ;
        this.daniosConstruc = Integer.parseInt(daniosConstruc) ;
        this.salvamentoRescates =  Integer.parseInt(salvamentoRescates);
        this.daniosAgua = Integer.parseInt(daniosAgua);
        this.incidentesDiversos = Integer.parseInt(incidentesDiversos);
        this.salidasSinIntervencion = Integer.parseInt(salidasSinIntervencion);
        this.serviciosVarios = Integer.parseInt(serviciosVarios);
        this.total = Integer.parseInt(total);
    }

    /////////////////////////////////////
    //GETTERS Y SETTERS/////////////////////////////////////////////////////////
    /////////////////////////////////////
    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public int getFuegos() {
        return fuegos;
    }

    public void setFuegos(int fuegos) {
        this.fuegos = fuegos;
    }

    public int getDaniosConstruc() {
        return daniosConstruc;
    }

    public void setDaniosConstruc(int daniosConstruc) {
        this.daniosConstruc = daniosConstruc;
    }

    public int getSalvamentoRescates() {
        return salvamentoRescates;
    }

    public void setSalvamentoRescates(int salvamentoRescates) {
        this.salvamentoRescates = salvamentoRescates;
    }

    public int getDaniosAgua() {
        return daniosAgua;
    }

    public void setDaniosAgua(int daniosAgua) {
        this.daniosAgua = daniosAgua;
    }

    public int getIncidentesDiversos() {
        return incidentesDiversos;
    }

    public void setIncidentesDiversos(int incidentesDiversos) {
        this.incidentesDiversos = incidentesDiversos;
    }
    
     public int getSalidasSinIntervencion() {
        return incidentesDiversos;
    }

    public void setSalidasSinIntervencion(int salidasSinIntervencion) {
        this.salidasSinIntervencion = salidasSinIntervencion;
    }
    

    public int getServiciosVarios() {
        return serviciosVarios;
    }

    public void setServiciosVarios(int serviciosVarios) {
        this.serviciosVarios = serviciosVarios;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    /////////////////////////////////////
    //FUNCIONES/MÉTODOS/////////////////////////////////////////////////////////
    /////////////////////////////////////

    @Override
    public String toString() {
        return "claseIntervencion{" 
        + "AÑO= " + anio 
        + ", MES= " + mes 
        + ", DISTRITO= " + distrito 
        + ", FUEGOS= " + fuegos 
        + ", DAÑOS CONSTRUCCIÓN= " + daniosConstruc 
        + ", SALVAMENTOS Y RESCATES= " + salvamentoRescates 
        + ", DAÑOS AGUA= " + daniosAgua 
        + ", INCIDENTES DIVERSIOS= " + incidentesDiversos 
        + ", SALIDAS SIN INTERVENCIÓN= " + salidasSinIntervencion 
        + ", SERVICIOS VARIOS= " + serviciosVarios 
        + ", TOTAL= " + total + '}';
    }
    
}//fin class
