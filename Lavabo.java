import javax.swing.ImageIcon;

//LISTO! :3

public class Lavabo extends Lugar {
    
    String numBloque,numPiso,genero;
    static ImageIcon iconolav = new ImageIcon("lavabo.jpeg"); //Le pongo static para que sea un valor estático y así poderlo usar en el constructor

    public Lavabo(int x, int y, String numBloque, String numPiso, String genero) {

        super("Lavabo", "Lugar para el aseo personal.", iconolav, x, y);
        this.numBloque = numBloque;
        this.numPiso = numPiso;
        this.genero = genero;

    }

    @Override
    public String toString() {
        return "Nombre del lugar: "+nombre+"\nDescripción: "+descripcion+"\nBloque: "+numBloque+"\nPiso: "+numPiso+"\nGenero: "+genero;
    }

    



}
