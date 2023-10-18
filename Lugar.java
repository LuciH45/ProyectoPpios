import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Image;

//LISTO!

public class Lugar extends JButton  {

    String nombre;
    String descripcion;
    ImageIcon icono;
    int posicionx,posiciony;

    JLabel lblpartida = new JLabel("", SwingConstants.CENTER);
    JLabel lbldestino = new JLabel(""+nombre, SwingConstants.CENTER);


    public Lugar(String nombre, String descripcion, ImageIcon icono, int x, int y) {

        setBounds(x,y,50,50);
        setIcon(new ImageIcon(icono.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH)));
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.posicionx = x;
        this.posiciony = y;
        setVisible(false);
        lblpartida.setVisible(false);
        lblpartida.setBounds(x-35, y+60, 120, 30);
        lblpartida.setText("Partida - "+nombre);
        lblpartida.setFont(new Font("arial", 3, 12));
        lbldestino.setVisible(false);
        lbldestino.setBounds(x-35, y+60, 120, 30);
        lbldestino.setText("Destino - "+nombre);
        lbldestino.setFont(new Font("arial", 3, 12));

        
    }

    public void marcarloPartida(JPanel panel){

        setVisible(true);
        setOpaque(true);
        lblpartida.setVisible(true);
        panel.add(this);
        panel.add(lblpartida);

    }

    public void marcarloDestino(JPanel panel){

        setVisible(true);
        setOpaque(true);
        lbldestino.setVisible(true);
        panel.add(this);
        panel.add(lbldestino);

    }

    

}
