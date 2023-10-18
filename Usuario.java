import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//LISTA! SUUU

public class Usuario {
    
    String nombre;
    Lugar ubicacionactual, ubicaciondestino;
    Lugar[] preferencias;

    public Usuario(String nombre){
        this.nombre = nombre;
        preferencias = new Lugar[4];
        ubicacionactual = ubicaciondestino = null;
    }

    public static String ingresarPartidaListaBuscador(ListaBuscador lista){

        return lista.guardarLugarPartida().toString();
        
    }

    public String ingresarDestinoListaBuscador(ListaBuscador lista){

        return lista.guardarLugarPartida().toString();
        
    }

}
