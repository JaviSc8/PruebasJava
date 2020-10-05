
package flujos;

import java.io.*;

  //@author Javier Rivera Bellet

public class Principal {

    public static void main(String[] args)throws IOException{
        
    CrearArchivo c = new CrearArchivo ();
    c.crear();
    
    String [] nombres = {"Maria Jutiel","Rocio Alonso"};
    int [] telefonos = {698786401,641253200};
    
    Telefono t = new Telefono ();
    t.escribirDirectorio(nombres, telefonos);
    t.leerDirectorio();
    
    t.accesoAleatorio(1,"Juana Garcia",631478864);
    t.accesoAleatorio(2,"Luisa Campoa",600157894);
    
    t.leerDirectorio();
 
    
}}
