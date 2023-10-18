import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class Comentario extends CuadroComentarios{
    
    String comentario;

    public Comentario(JPanel panel, int x, int y) {
        super(panel, "¿Quieres dejar una opinión o comentario?", x, y);
        this.txtarea = txtarea;
    }

    public void leerComentarios(JTextArea txtarea2, Usuario usuario){

        //Evento Oyente de Acción del radio botón

        ActionListener oyenteDeAccionOpRad = new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                radiobtn.setEnabled(false);
                lbl.setText("¡Dejanos tus opiniones/comentarios abajo!");
                txtarea.setBackground(Color.WHITE);
                txtarea.setEnabled(true);
                btn.setEnabled(true);
            }

        };

        radiobtn.addActionListener(oyenteDeAccionOpRad);

        //Evento Oyente de Acción del botón

        ActionListener oyenteDeAccionOpBtn = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                txtarea.setEnabled(false);
                btn.setEnabled(false);
                btn.setText("¡ENVIADO!");
                btn.setHorizontalAlignment(SwingConstants.CENTER);
                comentario = usuario.nombre+" ha dicho que:\n"+txtarea.getText();
                txtarea2.append("\n"+comentario);
            }
            
        };

        btn.addActionListener(oyenteDeAccionOpBtn);

    }

    

}
