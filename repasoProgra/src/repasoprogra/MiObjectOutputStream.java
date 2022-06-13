/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasoprogra;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author DAW
 */
public class MiObjectOutputStream extends ObjectOutputStream {
    //sobrescribimos el método que crea la cabecera
    protected void writeStreamHeader() throws IOException{
        //No hace nada.
    }
    //Constructores
    public MiObjectOutputStream() throws IOException{
        super();
    }
    
    public MiObjectOutputStream(OutputStream out) throws IOException{
        super(out);
    }
}//fin class
