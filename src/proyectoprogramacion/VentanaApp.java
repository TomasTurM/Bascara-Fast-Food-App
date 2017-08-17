/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoprogramacion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
/**
 *
 * @author tomasm
 */
public class VentanaApp extends JFrame implements ItemListener, ActionListener, WindowFocusListener {
    ClasePedido pedido = new ClasePedido();
    ClasePedido clasePedido = new ClasePedido();
    
    VentanaLogin ventanaLogin = new VentanaLogin();
    
    String nombreConsumidor = ventanaLogin.clasePedido.nombreConsumidor;
    
    JPanel preferenciasHamburguesa = new JPanel();
    JPanel preferenciasPizza = new JPanel();
    JPanel preferenciasEmpanadas = new JPanel();
    JPanel panelPrincipal1 = new JPanel();
    JPanel panelPrincipal2 = new JPanel();
    JPanel pedirComida = new JPanel();
    JPanel panelPreferencias = new JPanel();
    JPanel panelPrincipal3 = new JPanel();
    Container cp = getContentPane();
    
    JButton confirmar = new JButton("Confirmar");
    
    JRadioButton rb1 = new JRadioButton("Doble Hamburguesa");
    JRadioButton rb2 = new JRadioButton("Triple Hamburguesa");
    JRadioButton rb3 = new JRadioButton("Pollo");
    JRadioButton rb4 = new JRadioButton("Carne");     
    JRadioButton rb5 = new JRadioButton("Carne Cuchillo");     
    JRadioButton rb6 = new JRadioButton("Jamon y Queso");     
    JRadioButton rb7 = new JRadioButton("Criollo");
    
    JCheckBox cb1 = new JCheckBox("Queso");
    JCheckBox cb2 = new JCheckBox("Tomate");
    JCheckBox cb3 = new JCheckBox("Lechuga");
    JCheckBox cb4 = new JCheckBox("Mayonesa");     
    JCheckBox cb5 = new JCheckBox("Tomate");     
    JCheckBox cb6 = new JCheckBox("Rucula");     
    JCheckBox cb7 = new JCheckBox("Huevo"); 
    JCheckBox cb8 = new JCheckBox("Jamon"); 
    
    JTextField tf1 = new JTextField(2);
    
    
    JLabel jl1 = new JLabel();
    
    String[] listaComida = {"","Hamburguesa", "Pizza", "Empanadas"};
    String[] listaBebida = {"Sin Bebida","Agua", "Coca~Cola","Coca~Cola Zero","Coca~Cola Light","Fanta", "Manaos", "Sprite", "Prity","Mirinda","Cerveza Iguana", "Fernet Branca"};
    String[] listaGuarnicion = {"Sin Guarnicion","Papas Fritas", "Ensalada","Rabas"};
    String[] listaAderezo = {"Sin Aderezo","Ketchup", "Mayonesa","Mostaza"};
    
    JComboBox comboBoxComida = new JComboBox(listaComida);
    JComboBox comboBoxBebida = new JComboBox(listaBebida);
    JComboBox comboBoxGuarnicion = new JComboBox(listaGuarnicion);
    JComboBox comboBoxAderezo = new JComboBox(listaAderezo);
    
    public VentanaApp () {
        super("Bascara Fast Food App");
        setSize(250,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(250,250);
        addWindowFocusListener(this);
        
        JPanel bienvenido = new JPanel();
        bienvenido.setLayout(new FlowLayout());
        JLabel fuente = new JLabel();
        fuente.setFont(new java.awt.Font("Tahoma", 1, 40));
        fuente.setForeground(new java.awt.Color(255,   0,   0));
        fuente.setText("Bienvenido");
        bienvenido.add(fuente);
        
        JPanel logo = new JPanel();
        logo.setLayout(new FlowLayout());
        ImageIcon icon = new ImageIcon("dibujo.png", "Logo");
        logo.add(new JLabel(icon));
        
        JPanel texto = new JPanel();
        texto.setLayout(new FlowLayout());
        texto.add(jl1);
        
        JPanel comida = new JPanel();
        comida.setLayout(new FlowLayout());
        comida.add(new JLabel("Comida"));
        
        JPanel opcionesComida = new JPanel();
        opcionesComida.setLayout(new FlowLayout());
        opcionesComida.add(comboBoxComida);
        
        comboBoxComida.addItemListener(this::itemStateChanged);
        opcionesComida.add(comboBoxComida);
        
        preferenciasHamburguesa.setLayout(new BoxLayout(preferenciasHamburguesa, BoxLayout.Y_AXIS));
        
        rb1.addActionListener(this::actionPerformed);
        rb2.addActionListener(this::actionPerformed);
        
        preferenciasHamburguesa.add(rb1);
        preferenciasHamburguesa.add(rb2);
        preferenciasHamburguesa.add(cb1);
        preferenciasHamburguesa.add(cb2);
        preferenciasHamburguesa.add(cb3);
        preferenciasHamburguesa.add(cb4);
        
        preferenciasPizza.setLayout(new BoxLayout(preferenciasPizza, BoxLayout.Y_AXIS));
        preferenciasPizza.add(cb5);
        preferenciasPizza.add(cb6);
        preferenciasPizza.add(cb7);
        preferenciasPizza.add(cb8);
        
        preferenciasEmpanadas.setLayout(new BoxLayout(preferenciasEmpanadas, BoxLayout.Y_AXIS));
        preferenciasEmpanadas.add(new JLabel("Cantidad Empanadas:"));
        preferenciasEmpanadas.add(tf1);
        
        rb3.addActionListener(this::actionPerformed);
        rb4.addActionListener(this::actionPerformed);
        rb5.addActionListener(this::actionPerformed);
        rb6.addActionListener(this::actionPerformed);
        rb7.addActionListener(this::actionPerformed);
        
        preferenciasEmpanadas.add(rb3);
        preferenciasEmpanadas.add(rb4);
        preferenciasEmpanadas.add(rb5);
        preferenciasEmpanadas.add(rb6);
        preferenciasEmpanadas.add(rb7);
        
        JPanel bebida = new JPanel();
        bebida.setLayout(new FlowLayout());
        bebida.add(new JLabel("Bebida"));
        
        JPanel opcionesBebida = new JPanel();
        opcionesBebida.setLayout(new FlowLayout());
        opcionesBebida.add(comboBoxBebida);
        
        JPanel guarnicion = new JPanel();
        guarnicion.setLayout(new FlowLayout());
        guarnicion.add(new JLabel("Guarnicion"));
        
        
        JPanel opcionesGuarnicion = new JPanel();
        opcionesGuarnicion.setLayout(new FlowLayout());
        opcionesGuarnicion.add(comboBoxGuarnicion);
        
        JPanel aderezo = new JPanel();
        aderezo.setLayout(new FlowLayout());
        aderezo.add(new JLabel("Aderezo"));
        
        
        JPanel opcionesAderezo = new JPanel();
        opcionesAderezo.setLayout(new FlowLayout());
        opcionesAderezo.add(comboBoxAderezo);
        
        JPanel botonConfirmar = new JPanel();
        botonConfirmar.setLayout(new FlowLayout(FlowLayout.RIGHT));
        confirmar.addActionListener(this::actionPerformed);
        botonConfirmar.add(confirmar);
        
        panelPrincipal1.setLayout(new GridLayout(2,2));
        panelPrincipal1.add(bienvenido);
        panelPrincipal1.add(logo);
        panelPrincipal1.add(texto);
        
        panelPrincipal2.setLayout(new BoxLayout(panelPrincipal2, BoxLayout.Y_AXIS));
        pedirComida.setLayout(new FlowLayout());
        pedirComida.add(comida);
        pedirComida.add(opcionesComida);
        panelPrincipal2.add(pedirComida);
        panelPreferencias.setLayout(new FlowLayout());
        panelPrincipal2.add(panelPreferencias);
        panelPrincipal2.add(new JLabel(""));
        
        GridBagConstraints medidas1 = new GridBagConstraints();
        medidas1.gridx = 0;
        medidas1.gridy = 0;
        medidas1.gridwidth = 1;
        medidas1.gridheight = 1;
        GridBagConstraints medidas2 = new GridBagConstraints();
        medidas2.gridx = 1;
        medidas2.gridy = 0;
        medidas2.gridwidth = 1;
        medidas2.gridheight = 1;
        GridBagConstraints medidas3 = new GridBagConstraints();
        medidas3.gridx = 0;
        medidas3.gridy = 1;
        medidas3.gridwidth = 1;
        medidas3.gridheight = 1;
        GridBagConstraints medidas4 = new GridBagConstraints();
        medidas4.gridx = 1;
        medidas4.gridy = 1;
        medidas4.gridwidth = 1;
        medidas4.gridheight = 1;
        GridBagConstraints medidas5 = new GridBagConstraints();
        medidas5.gridx = 0;
        medidas5.gridy = 2;
        medidas5.gridwidth = 1;
        medidas5.gridheight = 1;
        GridBagConstraints medidas6 = new GridBagConstraints();
        medidas6.gridx = 1;
        medidas6.gridy = 2;
        medidas6.gridwidth = 1;
        medidas6.gridheight = 1;
        GridBagConstraints medidas7 = new GridBagConstraints();
        medidas7.gridx = 2;
        medidas7.gridy = 3;
        medidas7.gridwidth = 1;
        medidas7.gridheight = 1;
        panelPrincipal3.setLayout(new GridBagLayout());
        panelPrincipal3.add(bebida, medidas1);
        panelPrincipal3.add(opcionesBebida, medidas2);
        panelPrincipal3.add(guarnicion, medidas3);
        panelPrincipal3.add(opcionesGuarnicion, medidas4);
        panelPrincipal3.add(aderezo, medidas5);
        panelPrincipal3.add(opcionesAderezo, medidas6);
        panelPrincipal3.add(botonConfirmar, medidas7);
        
        cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
        cp.add(panelPrincipal1);
        cp.add(panelPrincipal2);
        cp.add(panelPrincipal3);
        this.pack();
    }
    
    @Override
            public void itemStateChanged(ItemEvent evt) {
                if(evt.getStateChange() == ItemEvent.SELECTED) {
                    if(evt.getItem() == "") {
                        panelPreferencias.remove(preferenciasPizza);
                        panelPreferencias.remove(preferenciasHamburguesa);
                        panelPreferencias.remove(preferenciasEmpanadas);
                        vaciarHamburguesa();
                        vaciarPizza();
                        vaciarEmpanadas();
                        panelPreferencias.validate();
                        panelPrincipal2.validate();
                        cp.validate();
                        this.pack();
                    }
                    if(evt.getItem() == "Hamburguesa") {
                        panelPreferencias.remove(preferenciasPizza);
                        panelPreferencias.remove(preferenciasEmpanadas);
                        vaciarEmpanadas();
                        vaciarPizza();
                        panelPreferencias.add(preferenciasHamburguesa);
                        panelPreferencias.validate();
                        panelPrincipal2.validate();
                        cp.validate();
                        this.pack();
                    }
                    if(evt.getItem() == "Pizza") {
                        panelPreferencias.remove(preferenciasEmpanadas);
                        panelPreferencias.remove(preferenciasHamburguesa);
                        vaciarHamburguesa();
                        vaciarEmpanadas();
                        panelPreferencias.add(preferenciasPizza);
                        panelPreferencias.validate();
                        panelPrincipal2.validate();
                        cp.validate();
                        this.pack();
                    }
                    if(evt.getItem() == "Empanadas") {
                        panelPreferencias.remove(preferenciasPizza);
                        panelPreferencias.remove(preferenciasHamburguesa);
                        vaciarHamburguesa();
                        vaciarPizza();
                        panelPreferencias.add(preferenciasEmpanadas);
                        panelPreferencias.validate();
                        panelPrincipal2.validate();
                        cp.validate();
                        this.pack();
                    }}
                    /*Problema de CheckBox no solucionado
                else if (evt.getStateChange() == ItemEvent.ITEM_STATE_CHANGED) {
                    if(rb1.equals(true)) {
                        rb2.setSelected(false);
                        System.out.println("Hola");
                    }
                    if(evt.getSource().equals(rb2)) {
                        rb1.setSelected(false);
                    }
                    if(evt.getSource().equals(rb3)) {
                        rb4.setSelected(false);
                        rb5.setSelected(false);
                        rb6.setSelected(false);
                        rb7.setSelected(false);
                    }
                    if(evt.getSource().equals(rb4)) {
                        rb3.setSelected(false);
                        rb5.setSelected(false);
                        rb6.setSelected(false);
                        rb7.setSelected(false);
                    }
                    if(evt.getSource().equals(rb5)) {
                        rb4.setSelected(false);
                        rb3.setSelected(false);
                        rb6.setSelected(false);
                        rb7.setSelected(false);
                    }
                    if(evt.getSource().equals(rb6)) {
                        rb4.setSelected(false);
                        rb5.setSelected(false);
                        rb3.setSelected(false);
                        rb7.setSelected(false);
                    }
                    if(evt.getSource().equals(rb7)) {
                        rb4.setSelected(false);
                        rb5.setSelected(false);
                        rb6.setSelected(false);
                        rb3.setSelected(false);
                    }
                }*/
            }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.confirmar) {
             setearPedido();
        }
    }   
    
    @Override
    public void windowGainedFocus(WindowEvent e) {
        String textoHola = "Hola " + nombreConsumidor + ", ¿Qué desea ordenar?";
        jl1.setText(textoHola);
        jl1.validate();
        panelPrincipal1.validate();
        cp.validate();
    }

    @Override
    public void windowLostFocus(WindowEvent e) {
    }
    
    public void vaciarHamburguesa () {
        rb1.setSelected(false);
        rb2.setSelected(false);
        cb1.setSelected(false);
        cb2.setSelected(false);
        cb3.setSelected(false);
        cb4.setSelected(false);
    }
    
    public void vaciarPizza () {
        cb5.setSelected(false);
        cb6.setSelected(false);
        cb7.setSelected(false);
        cb8.setSelected(false);
    }
    
    public void vaciarEmpanadas () {
        tf1.setText(null);
        rb3.setSelected(false);
        rb4.setSelected(false);
        rb5.setSelected(false);
        rb6.setSelected(false);
        rb7.setSelected(false);
    }
    
    public void setearPedido () {
            pedido.nombreConsumidor = nombreConsumidor;
            pedido.comida = comboBoxComida.getSelectedItem().toString();
             pedido.dobleHamburguesa = rb1.isSelected();
             pedido.tripleHamburguesa = rb2.isSelected();
             pedido.queso = cb1.isSelected();
             pedido.tomate1 = cb2.isSelected();
             pedido.lechuga = cb3.isSelected();
             pedido.mayonesa = cb4.isSelected();
             pedido.tomate2 = cb5.isSelected();
             pedido.rucula = cb6.isSelected();
             pedido.huevo = cb7.isSelected();
             pedido.jamon = cb8.isSelected();
             pedido.cantEmpanadas = tf1.getText();
             pedido.pollo = rb3.isSelected();
             pedido.carne = rb4.isSelected();
             pedido.carneCuchillo =  rb5.isSelected();
             pedido.jamon_queso = rb6.isSelected();
             pedido.criollo = rb7.isSelected();
             pedido.bebida = comboBoxBebida.getSelectedItem().toString();
             pedido.guarnicion = comboBoxGuarnicion.getSelectedItem().toString();
             pedido.aderezo = comboBoxAderezo.getSelectedItem().toString();
             System.out.println(toString());
             
    }

    @Override
    public String toString() {
        return "VentanaApp{" + "pedido=" + pedido + '}';
    }
}
