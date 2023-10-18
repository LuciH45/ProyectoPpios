import javax.swing.ImageIcon;

//Listo!

public class Bloque extends Lugar{
    
    String numBloque;
    static ImageIcon iconobloq = new ImageIcon("bloque.jpeg"); //Le pongo static para que sea un valor estático y así poderlo usar en el constructor

    public Bloque(int x, int y, String numBloque) {
        super("Bloque "+numBloque, "Elemento del conjunto de los edificios universitarios.", iconobloq, x, y);
        this.numBloque = numBloque;
    }

    @Override
    public String toString() {
        return "Nombre del lugar: "+nombre+"\nDescripción: "+descripcion+"\nBloque: "+numBloque;
    }

}
