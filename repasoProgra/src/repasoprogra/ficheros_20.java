/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package repasoprogra;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 *
 * @author DAW
 */
public class ficheros_20 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        ArrayList<Producto> productos = new ArrayList<>();

        productos.add(new Producto(1, "producto 1", 10.5, true, 'T'));
        productos.add(new Producto(2, "producto 2", 9.5, true, 'R'));
        productos.add(new Producto(3, "producto 3", 11.5, false, 'T'));
        productos.add(new Producto(4, "producto 4", 8.5, true, 'T'));
        productos.add(new Producto(5, "producto 5", 7.5, true, 'S'));

        try ( RandomAccessFile raf = new RandomAccessFile("ejemplo_raf.dat", "rw")) {
            for (Producto p : productos) {
                raf.writeInt(p.getId());

                StringBuffer sb = new StringBuffer(p.getNombre());
                sb.setLength(10);
                raf.writeChars(sb.toString());
                raf.writeDouble(p.getPrecio());
                raf.writeBoolean(p.isDescuento());
                raf.writeChar(p.getTipo());

            }//fin for
            
            /*
            
            int = 4 bytes
            String = 2 bytes por cada caracter, como son 10 "sb.setLength(10)", serían 20 en total 
            double = 8 bytes
            boolean = 1 byte
            char = 2 bytes
            
            4 + 20 + 8 + 2 + 1 = 35 bytes cada registro
            
            */
            raf.seek(35);
            System.out.println(raf.readInt());
            String nombre = "";
            for (int i =0;i<10;i++){
                nombre = nombre + raf.readChar();
            }
            System.out.println(raf.readInt());
            System.out.println(raf.readDouble());
            System.out.println(raf.readBoolean());
            System.out.println(raf.readChar());
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }//fin main
}//fin class
