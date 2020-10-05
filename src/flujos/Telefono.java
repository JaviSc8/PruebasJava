package flujos;

import java.io.*;
import java.util.ArrayList;


 //@author Javier Rivera Bellet
 
public class Telefono {

    //Constructor:
    public Telefono (){};
    
   //Nombre y creación de fichero "Directorio":
    static final String fichero = "Directorio.txt";
  
    //Método escribirDirectorio:
    public void escribirDirectorio(String[] nombres, int[] telefonos) throws IOException{
        DataOutputStream datout = null; 
   
    try{
    datout = new DataOutputStream(new BufferedOutputStream(new FileOutputStream (fichero)));
        for (int i = 0; i < nombres.length; i++) {
        datout.writeUTF(nombres[i]);}
        for (int j = 0; j < telefonos.length; j++) {
        datout.writeInt(telefonos[j]);}
        
    }catch(IOException e){System.out.println("Error"); 
    }finally{datout.close();}
    }
    
    //Método leerDirectorio:
    public void leerDirectorio() throws IOException{
        DataInputStream datin = null; 
    
    try{
        datin = new DataInputStream(new BufferedInputStream(new FileInputStream(fichero)));
        
        String nombre1;
        String nombre2;
        int telefono1;
        int telefono2;
        ArrayList<String> contenido = new ArrayList<String>(); 
        
        while(true){
            nombre1 = datin.readUTF();
            nombre2 = datin.readUTF();
            telefono1 = datin.readInt();
            telefono2 = datin.readInt();
            
            System.out.format("Nombre:%2s Teléfono:%2d\nNombre:%2s Teléfono:%2d\n",nombre1, telefono1, nombre2, telefono2); 
        
        contenido.add (nombre1+telefono1);
        contenido.add (nombre2+telefono2);
        System.out.println("Hay un total de "+contenido.size()+" personas en el directorio");
        }
        
        }catch(EOFException e){System.out.println("Fin de lectura del fichero");
        }catch(IOException e){System.out.println("Error"); 
        }finally{datin.close();}
        
        }
    //Método accesoAleatorio:
    public void accesoAleatorio(int posicion, String valor1, int valor2) throws IOException{
        RandomAccessFile ra = null; 
        
    try{
    ra = new RandomAccessFile(fichero,"rw");
  
    if(posicion==1){
        ra.seek(0);
        ra.writeUTF(valor1);
        ra.seek(28);
        ra.writeInt(valor2);
    }
    if(posicion==2){
        ra.seek(14);
        ra.writeUTF(valor1);
        ra.seek(32);
        ra.writeInt(valor2);
    } 
    }catch(IOException e){System.out.println("Error"); 
    }finally{ra.close();}
    }
}