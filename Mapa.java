import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Lista!

public class Mapa {

    JLabel lbl;
    ImageIcon icono;

    public Mapa(JPanel panel){
        iniciarMapa(panel);
    }

    public void iniciarMapa(JPanel panel){

        lbl = new JLabel();
        lbl.setBounds(150, 180, 700, 400);
        panel.add(lbl);

    }

    public void cambioImagen(String nomArchivo){
        icono = new ImageIcon(nomArchivo);
        lbl.setIcon(new ImageIcon(icono.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_SMOOTH)));
    }

}
