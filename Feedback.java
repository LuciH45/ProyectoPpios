import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Listo!

public class Feedback extends CuadroComentarios{

    public Feedback(JPanel panel, int x, int y) {
        super(panel, "¿Quieres dejar un Feedback o propuesta de mejora?", x, y);
    }

    public void leerFeedback(){
        //Evento Oyente de Acción del radio botón
        ActionListener oyenteDeAccionFbRad = new ActionListener() {
                
            @Override
            public void actionPerformed(ActionEvent e) {
                radiobtn.setEnabled(false);
                lbl.setText("¡Dejanos tu feedback/propuesta abajo!");
                txtarea.setBackground(Color.WHITE);
                txtarea.setEnabled(true);
                btn.setEnabled(true);
            }

        };

        radiobtn.addActionListener(oyenteDeAccionFbRad);

        //Evento Oyente de Acción del botón

        ActionListener oyenteDeAccionFbBtn = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                txtarea.setEnabled(false);
                btn.setEnabled(false);
                btn.setText("¡ENVIADO!");
                btn.setHorizontalAlignment(SwingConstants.CENTER);
            }
            
        };

        btn.addActionListener(oyenteDeAccionFbBtn);
    }
}
