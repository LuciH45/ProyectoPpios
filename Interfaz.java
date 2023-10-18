import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Interfaz extends JFrame{ //Interfaz hereda de JFrame

    //Atributos de interfaz

    JPanel panelInicio;
    JPanel panelMapa;
    JPanel panelSugerencias;
    JPanel comentariosPanel;
    JPanel panelLugar;
    JTextArea textAreaComent= new JTextArea();
    JTextArea textAreaUbic = new JTextArea();

    Usuario[] usuarios = new Usuario[100]; //Donde se guardan los usuarios

    String actualname = ""; //Guarda el nombre actual
    String actualPos = ""; //Guarda la posición actual

    static int indexusuario = 0;

    //Constructor interfaz

    public Interfaz(){

        setTitle("Pantalla de inicio"); //Le pongo el título a la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Por defecto, el programa termina al cerrar la ventana
        setSize(1000, 700);

        //Establezco que el tamaño actual de la ventana sea el minimo tamaño
        setMinimumSize(getSize());

        setLocationRelativeTo(null); //Configuración posición inicial y tamaño de la ventana
        componentesInicio(); //Inicio los componentes de la pantalla incial
        setVisible(true); //Lo pongo visible (importante ponerlo luego de invocar el método)

    }

    //MÉTODOS DE LA INTERFAZ

    private void componentesComunes(JPanel panel){

        JLabel lbl1 = new JLabel("ENCUENTRATE EAFIT",SwingConstants.CENTER); //Label de título con texto centrado
        lbl1.setBounds(360, 5, 250, 30); //Posición y tamaño
        lbl1.setFont(new Font("cooper black", 1, 20)); //Fuente, estilo y tamaño de letra
        lbl1.setForeground(new Color(3, 51, 99)); //Color de letra
        panel.add(lbl1); //Se añade el label al panel

        ImageIcon logoeafit = new ImageIcon("logoeafit.png"); //Se crea la imagen como un ImageIcon
        JLabel lbl2 = new JLabel();
        lbl2.setBounds(790,0,200,120);
        lbl2.setIcon(new ImageIcon(logoeafit.getImage().getScaledInstance(lbl2.getWidth(), lbl2.getHeight(), Image.SCALE_SMOOTH))); //Se añade la imagen (se modifica su tamaño y se le pone el mismo ancho/alto del label)
        panel.add(lbl2);

    }

    private void componentesInicio(){

        //Creación panel de inicio

        panelInicio = new JPanel();
        panelInicio.setLayout(null); //Le quito el diseño por defecto al panel
        panelInicio.setBackground(new Color(180, 143, 235)); //Fondo panel
        this.getContentPane().add(panelInicio); //Se añade el panel a la ventana
        componentesComunes(panelInicio); //Se colocan los componentes comunes

        //Labels

        JTextArea txtAreaHor = new JTextArea("Horario: Lunes - Viernes\n6am - 6pm\nSábados y Domingos\n6am - 9pm");
        txtAreaHor.setBounds(50, 50, 300, 300);
        txtAreaHor.setOpaque(false);
        txtAreaHor.setEditable(false);
        txtAreaHor.setFont(new Font("arial", 3, 14));
        panelInicio.add(txtAreaHor);
        
        JLabel lbl3 = new JLabel("Seleccione el lugar donde se encuentra: ");
        lbl3.setBounds(280, 50, 300, 30);
        lbl3.setFont(new Font("arial", 3, 14));
        panelInicio.add(lbl3);

        JLabel lbl4 = new JLabel("Digite su nombre: ");
        lbl4.setBounds(280, 100, 300, 30);
        lbl4.setFont(new Font("arial", 3, 14));
        panelInicio.add(lbl4);

        JLabel lbl5 = new JLabel(); //Mensaje de error (el usuario no coloca el nombre)
        lbl5.setBounds(430, 200, 200, 30);
        lbl5.setFont(new Font("arial", 2, 14));
        lbl5.setForeground(Color.RED);
        panelInicio.add(lbl5);


        //Lista desplegable - ubicación actual

        Lugar[] ubicobj = {new Bloque(890, 150, "19"),new Bloque(890, 150, "38")};
        String[] ubic = {"Bloque 19","Bloque 38"}; //Opciones de la lista desplegable

        ListaBuscador listaubic = new ListaBuscador(580, 50, ubic, panelInicio);

        //TextField para el nombre

        JTextField txtfield1 = new JTextField();
        txtfield1.setBounds(430, 100, 200, 30);
        panelInicio.add(txtfield1);

        //Botón para continuar

        JButton btn1 = new JButton("Click para continuar");
        btn1.setBounds(430, 150, 200, 30);
        btn1.setBackground(new Color(235, 155, 52));

        //Implementación del evento Oyente de Acción para el botón

        ActionListener oyenteDeAccion1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae){
                
                //Condicional para revisar si el campo Nombre está vacío
                if(txtfield1.getText().isEmpty() == true){
                    lbl5.setText("El campo del nombre está vacío"); 
                }else{
                    lbl5.setText("");
                    actualname = txtfield1.getText();
                    txtfield1.setText("");
                    actualPos = Usuario.ingresarPartidaListaBuscador(listaubic);
                    //System.out.println(actualPos);
                    listaubic.setSelectedItem("Bloque 19");

                    boolean found = false;

                    //Verificamos si ya está el usuario

                    for (int i = 0; i < usuarios.length; i++) {
                        // Verificar si el elemento no es null antes de comparar
                        if (usuarios[i] != null && actualname.equals(usuarios[i].nombre)) {
                            for (int j = 0; j < ubicobj.length; j++) {
                                if(ubicobj[j] != null && actualPos.equals(ubicobj[j].nombre)){
                                    usuarios[i].ubicacionactual = ubicobj[j];
                                    //System.out.println(usuarios[i].ubicacionactual.nombre);
                                    break;
                                }
                            }
                            // Mensaje de confirmación de usuario
                            JOptionPane.showMessageDialog(null, "¡Usuario confirmado!", "Confirmación de usuario", 1);
                            found = true;
                            break;
                        }
                    }

                    //Si no está el usuario, guardamos

                    if(!found){
                        
                        for (int i = 0; i < usuarios.length; i++) {
                            //Comparamos con el == porque no estamos comparando Strings, sino que estamos viendo si la posición es null
                            if (usuarios[i] == null){
                                usuarios[i] = new Usuario(actualname);
                                
                                for (int j = 0; j < ubicobj.length; j++) {
                                    if(ubicobj[j] != null && actualPos.equals(ubicobj[j].nombre)){
                                        usuarios[i].ubicacionactual = ubicobj[j];
                                        //System.out.println(usuarios[i].ubicacionactual.nombre);
                                        break;
                                    }
                                }

                                break;
                            }
                        }

                        JOptionPane.showMessageDialog(null,"¡Usuario guardado!","Guardado de usuario",1);
                    }

                    componentesDos();
                }
            }
        };

        btn1.addActionListener(oyenteDeAccion1);
        panelInicio.add(btn1);

        

    }


    private void componentesDos(){

        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i].nombre.equals(actualname)){
                indexusuario = i;
                break;
            }
        }

       
        //Se oculta el primer panel y se cambia el título
        panelInicio.setVisible(false);
        setTitle("Pantalla de Mapa");

        panelMapa = new JPanel();
        panelMapa.setLayout(null);
        panelMapa.setBackground(new Color(114, 196, 130));
        this.getContentPane().add(panelMapa);
        componentesComunes(panelMapa); //Se colocan los componentes comunes

        //Labels

        
        JLabel lbl4 = new JLabel("Hola "+actualname+", estás actualmente en el "+actualPos);
        lbl4.setBounds(280, 50, 500, 30);
        lbl4.setFont(new Font("cooper black", 1, 20));
        panelMapa.add(lbl4);
        

        JLabel lbl3 = new JLabel("Seleccione el lugar al que desea ir:");
        lbl3.setBounds(280, 100, 300, 30);
        lbl3.setFont(new Font("arial", 3, 14));
        panelMapa.add(lbl3);

        //EnlaceMapa

        Enlace cuadroEnlace = new Enlace(700,605, panelMapa);
        cuadroEnlace.redirigir();

        //MAPA - CLASE

        Mapa campus = new Mapa(panelMapa);
        campus.cambioImagen("mapa-campus-med-full-2018-2.jpg");

        //Hago visible el lugar de partida

        if (usuarios[indexusuario].ubicacionactual != null) {
            usuarios[indexusuario].ubicacionactual.marcarloPartida(panelMapa);

            ActionListener oyenteDeAccionUbicActual = new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    JOptionPane.showMessageDialog(null,"Ingresando al lugar de partida...","Alerta de ingreso",2);
                    componentesPanelUbic(usuarios[indexusuario].ubicacionactual);

                }
            
            };

            usuarios[indexusuario].ubicacionactual.addActionListener(oyenteDeAccionUbicActual);
        }

        //Lista desplegable - destino
        
        Lugar[] destinos19 = {new Lavabo(890, 280, "7", "1", "Ambos"), new MaquinaExpendedora(890, 280, "20", "2"), new Bebedero(890, 280, "12", "1"), new Cafetera(890, 280, "3", "1")};
        Lugar[] destinos38 = {new Lavabo(890, 280, "35", "1", "Ambos"), new MaquinaExpendedora(890, 280, "34", "1"), new Bebedero(890, 280, "33", "1"), new Cafetera(890, 280, "29", "1")};
        String[] ubic = {"Lavabos","Máquinas expendedoras","Bebederos","Cafeteras"}; //Opciones de la lista desplegable

        ListaBuscador listadest = new ListaBuscador(550, 100, ubic, panelMapa);

        //Lista desplegable - preferencias

        JRadioButton radioBtnPref = new JRadioButton("Click para solo mostrar preferencias");
        radioBtnPref.setBounds(610,135,250,40);
        radioBtnPref.setOpaque(false);
        panelMapa.add(radioBtnPref);

        ActionListener oyenteDeAccionPref = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (radioBtnPref.getText().equals("Click para solo mostrar preferencias")){

                    boolean elementFound = false;

                    for (int i = 0; i < usuarios[indexusuario].preferencias.length; i++) {
                        if(usuarios[indexusuario].preferencias[i] != null){
                            elementFound = true;
                            listadest.removeAllItems();
                            for (int j = 0; j < usuarios[indexusuario].preferencias.length; j++) {
                                if (usuarios[indexusuario].preferencias[j] != null){
                                    listadest.addItem(usuarios[indexusuario].preferencias[j].nombre);
                                }
                            }
                            radioBtnPref.setText("Click para mostrar todas las opciones");
                            radioBtnPref.setSelected(false);
                            break;
                        }
                    }

                    if(!elementFound){
                        JOptionPane.showMessageDialog(null,"Usuario sin preferencias...","Error",JOptionPane.ERROR_MESSAGE);
                        radioBtnPref.setSelected(false);
                    }

                }else{

                    radioBtnPref.setText("Click para solo mostrar preferencias");
                    radioBtnPref.setSelected(false);
                    listadest.removeAllItems();

                    for (int j = 0; j < ubic.length; j++) {
                        listadest.addItem(ubic[j]);
                    }

                }

            }
            
        };

        radioBtnPref.addActionListener(oyenteDeAccionPref);

        JButton btndest = new JButton("Click para continuar");
        btndest.setBounds(410,135,200,40);
        panelMapa.add(btndest);

        ActionListener oyenteDestino = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                String nomdest = listadest.guardarLugarDestino().toString();

                switch (nomdest) {
                    case "Lavabos":
                        
                        if (actualPos.equals("Bloque 19")){

                            for (int i = 0; i < destinos19.length; i++) {
                                if (destinos19[i].nombre.indexOf("Lavabo") != -1){
                                    usuarios[indexusuario].ubicaciondestino = destinos19[i];

                                    boolean foundPlace = false;

                                    for (int j = 0; j < usuarios[indexusuario].preferencias.length; j++) {
                                        
                                        if(usuarios[indexusuario].preferencias[j] != null && usuarios[indexusuario].preferencias[j].nombre.equals(usuarios[indexusuario].ubicaciondestino.nombre)){
                                            foundPlace = true;
                                            break;
                                        }

                                    }

                                    if(!foundPlace){

                                        for (int j = 0; j < usuarios[indexusuario].preferencias.length; j++) {
                                        
                                            if(usuarios[indexusuario].preferencias[j] == null){
                                                usuarios[indexusuario].preferencias[j] = new Lugar("Lavabos", "", new ImageIcon(""), 0, 0);
                                                break;
                                            }
                                            

                                        }

                                    }

                                    break;
                                }
                            }

                        }else{

                            for (int i = 0; i < destinos38.length; i++) {
                                if (destinos38[i].nombre.indexOf("Lavabo") != -1){
                                    usuarios[indexusuario].ubicaciondestino = destinos38[i];

                                    boolean foundPlace = false;

                                    for (int j = 0; j < usuarios[indexusuario].preferencias.length; j++) {
                                        
                                        if(usuarios[indexusuario].preferencias[j] !=null && usuarios[indexusuario].preferencias[j].nombre.equals(usuarios[indexusuario].ubicaciondestino.nombre)){
                                            foundPlace = true;
                                            break;
                                        }

                                    }

                                    if(!foundPlace){

                                        for (int j = 0; j < usuarios[indexusuario].preferencias.length; j++) {
                                        
                                            if(usuarios[indexusuario].preferencias[j] == null){
                                                usuarios[indexusuario].preferencias[j] = new Lugar("Lavabos", "", new ImageIcon(""), 0, 0);
                                                break;
                                            }

                                        }

                                    }

                                    break;
                                }
                            }

                        }
                        
                        break;

                    case "Máquinas expendedoras":
                        if (actualPos.equals("Bloque 19")){

                            for (int i = 0; i < destinos19.length; i++) {
                                if (destinos19[i].nombre.indexOf("Máquina expendedora") != -1){
                                    usuarios[indexusuario].ubicaciondestino = destinos19[i];

                                    boolean foundPlace = false;

                                    for (int j = 0; j < usuarios[indexusuario].preferencias.length; j++) {
                                        
                                        if(usuarios[indexusuario].preferencias[j] !=null && usuarios[indexusuario].preferencias[j].nombre.equals(usuarios[indexusuario].ubicaciondestino.nombre)){
                                            foundPlace = true;
                                            break;
                                        }

                                    }

                                    if(!foundPlace){

                                        for (int j = 0; j < usuarios[indexusuario].preferencias.length; j++) {
                                        
                                            if(usuarios[indexusuario].preferencias[j] == null){
                                                usuarios[indexusuario].preferencias[j] = new Lugar("Máquinas expendedoras", "", new ImageIcon(""), 0, 0);
                                                break;
                                            }

                                        }

                                    }
                                    
                                    break;
                                }
                            }

                        }else{

                            for (int i = 0; i < destinos38.length; i++) {
                                if (destinos38[i].nombre.indexOf("Máquina expendedora") != -1){
                                    usuarios[indexusuario].ubicaciondestino = destinos38[i];

                                    boolean foundPlace = false;

                                    for (int j = 0; j < usuarios[indexusuario].preferencias.length; j++) {
                                        
                                        if(usuarios[indexusuario].preferencias[j] !=null && usuarios[indexusuario].preferencias[j].nombre.equals(usuarios[indexusuario].ubicaciondestino.nombre)){
                                            foundPlace = true;
                                            break;
                                        }

                                    }

                                    if(!foundPlace){

                                        for (int j = 0; j < usuarios[indexusuario].preferencias.length; j++) {
                                        
                                            if(usuarios[indexusuario].preferencias[j] == null){
                                                usuarios[indexusuario].preferencias[j] = new Lugar("Máquinas expendedoras", "", new ImageIcon(""), 0, 0);
                                                break;
                                            }

                                        }

                                    }
                                    
                                    break;
                                }
                            }

                        }

                        break;

                    case "Bebederos":

                        if (actualPos.equals("Bloque 19")){

                            for (int i = 0; i < destinos19.length; i++) {
                                if (destinos19[i].nombre.indexOf("Bebedero") != -1){
                                    usuarios[indexusuario].ubicaciondestino = destinos19[i];

                                    boolean foundPlace = false;

                                    for (int j = 0; j < usuarios[indexusuario].preferencias.length; j++) {
                                        
                                        if(usuarios[indexusuario].preferencias[j] !=null && usuarios[indexusuario].preferencias[j].nombre.equals(usuarios[indexusuario].ubicaciondestino.nombre)){
                                            foundPlace = true;
                                            break;
                                        }

                                    }

                                    if(!foundPlace){

                                        for (int j = 0; j < usuarios[indexusuario].preferencias.length; j++) {
                                        
                                            if(usuarios[indexusuario].preferencias[j] == null){
                                                usuarios[indexusuario].preferencias[j] = new Lugar("Bebederos", "", new ImageIcon(""), 0, 0);
                                                break;
                                            }

                                        }

                                    }

                                    break;
                                }
                            }

                        }else{

                            for (int i = 0; i < destinos38.length; i++) {
                                if (destinos38[i].nombre.indexOf("Bebedero") != -1){
                                    usuarios[indexusuario].ubicaciondestino = destinos38[i];

                                    boolean foundPlace = false;

                                    for (int j = 0; j < usuarios[indexusuario].preferencias.length; j++) {
                                        
                                        if(usuarios[indexusuario].preferencias[j] !=null && usuarios[indexusuario].preferencias[j].nombre.equals(usuarios[indexusuario].ubicaciondestino.nombre)){
                                            foundPlace = true;
                                            break;
                                        }

                                    }

                                    if(!foundPlace){

                                        for (int j = 0; j < usuarios[indexusuario].preferencias.length; j++) {
                                        
                                            if(usuarios[indexusuario].preferencias[j] == null){
                                                usuarios[indexusuario].preferencias[j] = new Lugar("Bebederos", "", new ImageIcon(""), 0, 0);
                                                break;
                                            }

                                        }

                                    }

                                    break;
                                }
                            }

                        }
                        break;

                    case "Cafeteras":

                        if (actualPos.equals("Bloque 19")){

                            for (int i = 0; i < destinos19.length; i++) {
                                if (destinos19[i].nombre.indexOf("Cafetera") != -1){
                                    usuarios[indexusuario].ubicaciondestino = destinos19[i];

                                    boolean foundPlace = false;

                                    for (int j = 0; j < usuarios[indexusuario].preferencias.length; j++) {
                                        
                                        if(usuarios[indexusuario].preferencias[j] !=null && usuarios[indexusuario].preferencias[j].nombre.equals(usuarios[indexusuario].ubicaciondestino.nombre)){
                                            foundPlace = true;
                                            break;
                                        }

                                    }

                                    if(!foundPlace){

                                        for (int j = 0; j < usuarios[indexusuario].preferencias.length; j++) {
                                        
                                            if(usuarios[indexusuario].preferencias[j] == null){
                                                usuarios[indexusuario].preferencias[j] = new Lugar("Cafeteras", "", new ImageIcon(""), 0, 0);
                                                break;
                                            }

                                        }

                                    }

                                    break;
                                }
                            }

                        }else{

                            for (int i = 0; i < destinos38.length; i++) {
                                if (destinos38[i].nombre.indexOf("Cafetera") != -1){
                                    usuarios[indexusuario].ubicaciondestino = destinos38[i];

                                    boolean foundPlace = false;

                                    for (int j = 0; j < usuarios[indexusuario].preferencias.length; j++) {
                                        
                                        if(usuarios[indexusuario].preferencias[j] !=null && usuarios[indexusuario].preferencias[j].nombre.equals(usuarios[indexusuario].ubicaciondestino.nombre)){
                                            foundPlace = true;
                                            break;
                                        }

                                    }

                                    if(!foundPlace){

                                        for (int j = 0; j < usuarios[indexusuario].preferencias.length; j++) {
                                        
                                            if(usuarios[indexusuario].preferencias[j] == null){
                                                usuarios[indexusuario].preferencias[j] = new Lugar("Cafeteras", "", new ImageIcon(""), 0, 0);
                                                break;
                                            }

                                        }

                                    }

                                    break;
                                }
                            }

                        }
                        break;
                
                    default:
                        break;

                        
                        
                }

                Ruta.mostrarRutaADestino(campus,usuarios[indexusuario].ubicacionactual,usuarios[indexusuario].ubicaciondestino);
                btndest.setEnabled(false);
                listadest.setEnabled(false);

                if (usuarios[indexusuario].ubicaciondestino != null) {
                    usuarios[indexusuario].ubicaciondestino.marcarloDestino(panelMapa);

                    ActionListener oyenteDeAccionUbicDestino = new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            
                            JOptionPane.showMessageDialog(null,"Ingresando al lugar de destino...","Alerta de ingreso",2);
                            componentesPanelUbic(usuarios[indexusuario].ubicaciondestino);

                        }
                
                    };

                    usuarios[indexusuario].ubicaciondestino.addActionListener(oyenteDeAccionUbicDestino);
                }

                panelMapa.repaint();
                panelMapa.revalidate();
            }
            
            
        };

        
        btndest.addActionListener(oyenteDestino);
        
        
        
        //Inicio los componentes del panel de comentarios
        
        
        //Botones regresar y feedback

        JButton btn1 = new JButton("Pulse aquí para regresar");
        btn1.setBounds(20,20,200,40);

        //Implementamos el oyente de acción para volver al anterior panel

        ActionListener oyenteDeAccion1 = new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                panelMapa.setVisible(false);
                JOptionPane.showMessageDialog(null,"Volviendo al inicio...","Alerta de regreso",2);
                setTitle("Pantalla de inicio");
                panelInicio.setVisible(true);
            }

        };

        btn1.addActionListener(oyenteDeAccion1);
        panelMapa.add(btn1);


        JButton btn2 = new JButton("Dar opinión o feedback");
        btn2.setBounds(20,600,200,50);

        ActionListener oyenteDeAccion2 = new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                componentesTres();
            }

        };

        btn2.addActionListener(oyenteDeAccion2);
        panelMapa.add(btn2);

        //Botón para ver los comentarios

        JButton btnVerComent = new JButton("Click para ver comentarios");
        btnVerComent.setBounds(250,600,200,50);

        ActionListener oyenteDeAccion3 = new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Ingresando a los comentarios...","Alerta de ingreso",2);
                componentesPanelComent();
            }

        };

        btnVerComent.addActionListener(oyenteDeAccion3);
        panelMapa.add(btnVerComent);

        

    }

    private void componentesTres(){

        //Bienvenida al panel y se quita la visibilidad del anterior panel
        
        JOptionPane.showMessageDialog(null,"¡Déjanos tus Opiniones o Feedback!","Bienvenida a opiniones y feedback",1);
        panelMapa.setVisible(false);
        setTitle("Opiniones y Feedback");

        panelSugerencias = new JPanel();
        panelSugerencias.setLayout(null);
        panelSugerencias.setBackground(new Color(222, 178, 102));
        this.getContentPane().add(panelSugerencias);
        componentesComunes(panelSugerencias); //Se colocan los componentes comunes


        //Opiniones y comentarios

        Comentario comentarios = new Comentario(panelSugerencias, 200, 40);
        comentarios.leerComentarios(textAreaComent, usuarios[indexusuario]);

        //Feedback y mejoras

        Feedback feedback = new Feedback(panelSugerencias, 200, 350);
        feedback.leerFeedback();

        //Botón de regreso

        JButton btn1 = new JButton("Regresar");
        btn1.setBounds(775,215,125,300);

        //Implementamos el oyente de acción para volver al anterior panel

        ActionListener oyenteDeAccionReg = new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                panelSugerencias.setVisible(false);
                JOptionPane.showMessageDialog(null,"Volviendo al Mapa...","Alerta de regreso",2);
                setTitle("Pantalla de Mapa");
                panelMapa.setVisible(true);
            }

        };

        btn1.addActionListener(oyenteDeAccionReg);
        panelSugerencias.add(btn1);

    }

    public void componentesPanelComent(){

        panelMapa.setVisible(false);
        setTitle("Pantalla de Visualización - Comentarios");

        comentariosPanel = new JPanel();
        comentariosPanel.setLayout(null);
        comentariosPanel.setBackground(new Color(114, 196, 130));
        this.getContentPane().add(comentariosPanel);
        componentesComunes(comentariosPanel); //Se colocan los componentes comunes

        textAreaComent.setBounds(230,100,500,500);
        textAreaComent.setEditable(false);
        
        comentariosPanel.add(textAreaComent);

        JButton btn1 = new JButton("Regresar");
        btn1.setBounds(775,215,125,300);

        //Implementamos el oyente de acción para volver al anterior panel

        ActionListener oyenteDeAccionReg = new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                comentariosPanel.setVisible(false);
                JOptionPane.showMessageDialog(null,"Volviendo al Mapa...","Alerta de regreso",2);
                setTitle("Pantalla de Mapa");
                panelMapa.setVisible(true);
            }

        };

        btn1.addActionListener(oyenteDeAccionReg);
        comentariosPanel.add(btn1);

    }

    public void componentesPanelUbic(Lugar lugar){

        panelMapa.setVisible(false);
        setTitle("Pantalla de Visualización - Lugar");

        panelLugar = new JPanel();
        panelLugar.setLayout(null);
        panelLugar.setBackground(new Color(114, 196, 130));
        this.getContentPane().add(panelLugar);
        componentesComunes(panelLugar); //Se colocan los componentes comunes

        textAreaUbic.setBounds(230,100,500,500);
        textAreaUbic.setEditable(false);
        textAreaUbic.setText(lugar.toString());
        
        panelLugar.add(textAreaUbic);

        JButton btn1 = new JButton("Regresar");
        btn1.setBounds(775,215,125,300);

        //Implementamos el oyente de acción para volver al anterior panel

        ActionListener oyenteDeAccionReg = new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                panelLugar.setVisible(false);
                JOptionPane.showMessageDialog(null,"Volviendo al Mapa...","Alerta de regreso",2);
                setTitle("Pantalla de Mapa");
                panelMapa.setVisible(true);
                panelMapa.repaint();
                panelMapa.revalidate();
            }

        };

        btn1.addActionListener(oyenteDeAccionReg);
        panelLugar.add(btn1);

    }
}
