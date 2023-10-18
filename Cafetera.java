import javax.swing.ImageIcon;

//Listo!

public class Cafetera extends Lugar{
    
    String numBloque,numPiso;
    static ImageIcon iconocaf = new ImageIcon("Cafetera.jpeg"); //Le pongo static para que sea un valor estático y así poderlo usar en el constructor

    public Cafetera(int x, int y, String numBloque, String numPiso) {
        super("Cafetera", "Dispositivo para preparar algunas bebidas calientes.", iconocaf, x, y);
        this.numBloque = numBloque;
        this.numPiso = numPiso;
    }

    @Override
    public String toString() {
        return "Nombre del lugar: "+nombre+"\nDescripción: "+descripcion+"\nBloque: "+numBloque+"\nPiso: "+numPiso;
    }

}
