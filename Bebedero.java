import javax.swing.ImageIcon;

//Listo!

public class Bebedero extends Lugar{
    
    
    String numBloque,numPiso;
    static ImageIcon iconobeb = new ImageIcon("Bebedero.jpeg"); //Le pongo static para que sea un valor estático y así poderlo usar en el constructor

    public Bebedero(int x, int y, String numBloque, String numPiso) {

        super("Bebedero", "Dispositivo que proporciona agua potable para beber.", iconobeb, x, y);
        this.numBloque = numBloque;
        this.numPiso = numPiso;

    }

    @Override
    public String toString() {
        return "Nombre del lugar: "+nombre+"\nDescripción: "+descripcion+"\nBloque: "+numBloque+"\nPiso: "+numPiso;
    }


}
