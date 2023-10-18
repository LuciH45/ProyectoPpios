import javax.swing.JComboBox;
import javax.swing.JPanel;

//LISTA!

public class ListaBuscador extends JComboBox{

    public ListaBuscador(int x, int y, String[] opcionesString, JPanel panel){
        super(opcionesString); //Llamo al constructor de ComboBox y le paso opciones
        setBounds(x, y, 180, 30);
        panel.add(this);
    }

    public Object guardarLugarPartida(){
        return getSelectedItem();
    }

    public Object guardarLugarDestino(){
        return getSelectedItem();
    }

}
