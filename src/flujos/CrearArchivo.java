package flujos;

import java.awt.Desktop;
import java.io.*;
import java.util.*;

 //@author Javier Rivera Bellet

public class CrearArchivo {
    //Constructor:
    public CrearArchivo (){}

    //Método:
    public void crear() throws IOException{
    //Introducir nombre de archivo por teclado:
    Scanner nombre = new Scanner(System.in); 
    String nombreArch=nombre.nextLine();
    //Nombre y creación de fichero:
    String ruta = nombreArch+".txt";
    File archivo = new File(ruta);
    FileWriter fw;
    BufferedWriter bf = null;
    
    //Comprobación/Apertura y/o escritura:
    if(archivo.exists()){{
     try {Desktop.getDesktop().open(archivo);
     }catch (IOException e) {
        System.out.println("Archivo ya creado");
     }}
    }else{
    try {
    fw = new FileWriter(archivo);
    bf = new BufferedWriter(fw);
    bf.write("1, 2, 3, 4, 5, 6, 7, 8, 9, 10");
            }catch(IOException e){System.out.println("Error");
            }finally{bf.close();
    } 
}}}

    

