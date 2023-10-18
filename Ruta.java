public class Ruta {
    
    public static void mostrarRutaADestino(Mapa mapa, Lugar Partida, Lugar Destino){

        if(Partida.nombre.equals("Bloque 19")){

            if (Destino.nombre.equals("Lavabo")){
                mapa.cambioImagen("lavabo19.jpeg");
            }else if(Destino.nombre.equals("Máquina expendedora")){
                mapa.cambioImagen("maquina19.jpeg");
            }else if(Destino.nombre.equals("Bebedero")){
                mapa.cambioImagen("bebedero19.jpeg");
            }else if(Destino.nombre.equals("Cafetera")){
                mapa.cambioImagen("cafetera19.jpeg");
            }

        }else if (Partida.nombre.equals("Bloque 38")){

            if (Destino.nombre.equals("Lavabo")){
                mapa.cambioImagen("lavabo38.jpeg");
            }else if(Destino.nombre.equals("Máquina expendedora")){
                mapa.cambioImagen("maquina38.jpeg");
            }else if(Destino.nombre.equals("Bebedero")){
                mapa.cambioImagen("bebedero38.jpeg");
            }else if(Destino.nombre.equals("Cafetera")){
                mapa.cambioImagen("cafetera38.jpeg");
            }

        }

    }
}
