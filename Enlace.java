import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//Listo!

public class Enlace extends JButton{

    String enlacelink = "https:/encuentrateeafit/mapa/";
    ImageIcon qr = new ImageIcon("qr.jpeg");
    
    public Enlace(int x,int y,JPanel panel){
        super("Generar enlace");
        setBounds(x, y, 200, 40);
        panel.add(this);
    }

    public void redirigir(){

        ActionListener oyenteEnlace = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,enlacelink,"Enlace mapa",0,qr);
            }
            
        };

        addActionListener(oyenteEnlace);

    }

}
