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
/**
 *
 * @author tomasm
 */
public class VentanaApp extends JFrame implements ItemListener, ActionListener {
    ClasePedido pedido = new ClasePedido();
    ClasePedido clasePedido = new ClasePedido();
    JPanel preferenciasHamburguesa = new JPanel();
    JPanel preferenciasPizza = new JPanel();
    JPanel preferenciasEmpanadas = new JPanel();
    JPanel panelPrincipal1 = new JPanel();
    JPanel panelPrincipal2 = new JPanel();
    JPanel panelPrincipal3 = new JPanel();
    Container cp = getContentPane();
    JButton confirmar = new JButton("Confirmar");
    String nombre;
    
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
        texto.add(new JLabel("Hola " + nombre + ", ¿Qué desea ordenar?"));
        
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
        preferenciasHamburguesa.hide();    
        
        preferenciasPizza.setLayout(new BoxLayout(preferenciasPizza, BoxLayout.Y_AXIS));
        preferenciasPizza.add(cb5);
        preferenciasPizza.add(cb6);
        preferenciasPizza.add(cb7);
        preferenciasPizza.add(cb8);
        preferenciasPizza.hide();
        
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
        preferenciasEmpanadas.hide();
        
        JPanel bebida = new JPanel();
        bebida.setLayout(new FlowLayout());
        bebida.add(new JLabel("Bebida"));
        
        JPanel opcionesBebida = new JPanel();
        opcionesComida.setLayout(new FlowLayout());
        opcionesComida.add(comboBoxBebida);
        
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
        
        panelPrincipal2.setLayout(new GridLayout(3,2));
        panelPrincipal2.add(comida);
        panelPrincipal2.add(opcionesComida);
        panelPrincipal2.add(preferenciasHamburguesa);
        panelPrincipal2.add(preferenciasPizza);
        panelPrincipal2.add(preferenciasEmpanadas);
        
        
        panelPrincipal3.setLayout(new GridLayout(5,2));
        panelPrincipal3.add(bebida);
        panelPrincipal3.add(opcionesBebida);
        panelPrincipal3.add(guarnicion);
        panelPrincipal3.add(opcionesGuarnicion);
        panelPrincipal3.add(aderezo);
        panelPrincipal3.add(opcionesAderezo);
        panelPrincipal3.add(new JLabel(""));
        panelPrincipal3.add(new JLabel(""));
        panelPrincipal3.add(new JLabel(""));
        panelPrincipal3.add(botonConfirmar);
        
        
        cp.add(panelPrincipal1, BorderLayout.NORTH);
        cp.add(panelPrincipal2, BorderLayout.CENTER);
        cp.add(panelPrincipal3, BorderLayout.SOUTH);
        this.pack();
    }
    
    @Override
            public void itemStateChanged(ItemEvent evt) {
                if(evt.getStateChange() == ItemEvent.SELECTED) {
                    if(evt.getItem() == "") {
                        preferenciasPizza.hide();
                        preferenciasEmpanadas.hide();
                        preferenciasHamburguesa.hide();
                        vaciarHamburguesa();
                        vaciarPizza();
                        vaciarEmpanadas();
                    }
                    if(evt.getItem() == "Hamburguesa") {
                        preferenciasPizza.hide();
                        preferenciasEmpanadas.hide();
                        vaciarEmpanadas();
                        vaciarPizza();
                        preferenciasHamburguesa.show();
                    }
                    if(evt.getItem() == "Pizza") {
                        preferenciasEmpanadas.hide();
                        preferenciasHamburguesa.hide();
                        vaciarHamburguesa();
                        vaciarEmpanadas();
                        preferenciasPizza.show();
                    }
                    if(evt.getItem() == "Empanadas") {
                        preferenciasPizza.hide();
                        preferenciasHamburguesa.hide();
                        vaciarHamburguesa();
                        vaciarPizza();
                        preferenciasEmpanadas.show();
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
    }
}
