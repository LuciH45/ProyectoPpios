import javax.swing.ImageIcon;

//LISTO!

public class MaquinaExpendedora extends Lugar{

    String numBloque,numPiso,descProd;
    static ImageIcon iconomaq = new ImageIcon("Maquina.jpeg"); //Le pongo static para que sea un valor estático y así poderlo usar en el constructor
    
    public MaquinaExpendedora(int x, int y, String numBloque, String numPiso) {
        super("Máquina expendedora", "Máquina dispensadora de aperitivos y bebidas.", iconomaq, x, y);
        this.numBloque = numBloque;
        this.numPiso = numPiso;
        this.descProd = "Alimentos varios y bebidas.";
    }

    @Override
    public String toString() {
        return "Nombre del lugar: "+nombre+"\nDescripción: "+descripcion+"\nBloque: "+numBloque+"\nPiso: "+numPiso+"\nDescripción producto: "+descProd;
    }

}