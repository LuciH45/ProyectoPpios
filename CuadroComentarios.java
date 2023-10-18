import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

//Listo!

public class CuadroComentarios {

    JRadioButton radiobtn;
    JLabel lbl;
    JTextArea txtarea;
    JButton btn;
    
    public CuadroComentarios(JPanel panel, String pregunta, int x, int y) {

        radiobtn = new JRadioButton(pregunta);
        radiobtn.setBounds(x, y, 350, 30);
        radiobtn.setOpaque(false);
        panel.add(radiobtn);

        lbl = new JLabel("");
        lbl.setBounds(x, y+20, 350, 30);
        panel.add(lbl);

        txtarea = new JTextArea();
        txtarea.setBounds(x, y+60,500,200);
        panel.add(txtarea);
        txtarea.setEnabled(false);
        txtarea.setBackground(Color.GRAY);

        btn = new JButton("Click para enviar");
        btn.setEnabled(false);
        btn.setBounds(x, y+270,200,30);
        panel.add(btn);

    }

    

}
