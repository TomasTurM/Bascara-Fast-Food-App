/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoprogramacion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
/**
 *
 * @author tomasm
 */
public class VentanaApp extends JFrame implements ItemListener {
    ClasePedido clasePedido = new ClasePedido();
    JPanel preferenciasHamburguesa = new JPanel();
    JPanel preferenciasPizza = new JPanel();
    JPanel preferenciasEmpanadas = new JPanel();
    JPanel panelPrincipal1 = new JPanel();
    JPanel panelPrincipal2 = new JPanel();
    JPanel panelPrincipal3 = new JPanel();
    
    public VentanaApp () {
        super("App");
        setSize(250,250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocation(250,250);
        
        JPanel bienvenido = new JPanel();
        bienvenido.setLayout(new FlowLayout());
        JLabel fuente = new JLabel();
        fuente.setFont(new java.awt.Font("Tahoma", 1, 11));
        fuente.setForeground(new java.awt.Color(255, 255, 255));
        bienvenido.add(fuente);
        
        JPanel logo = new JPanel();
        logo.setLayout(new FlowLayout());
        ImageIcon icon = new ImageIcon("ProyectoProgramacion/dibujo.png", "Logo");
        logo.add(new JLabel(icon));
        
        JPanel texto = new JPanel();
        texto.setLayout(new FlowLayout());
        texto.add(new JLabel("Hola " + " ¿Qué desea ordenar?"));
        
        JPanel comida = new JPanel();
        comida.setLayout(new FlowLayout());
        comida.add(new JLabel("Comida"));
        
        String[] listaComida = {"Hamburguesa", "Pizza", "Empanadas"};
        JPanel opcionesComida = new JPanel();
        opcionesComida.setLayout(new FlowLayout());
        opcionesComida.add(new JComboBox(listaComida));    
        
        preferenciasHamburguesa.setLayout(new BoxLayout(preferenciasHamburguesa, BoxLayout.Y_AXIS));
        preferenciasHamburguesa.add(new JRadioButton("Doble Hamburguesa"));
        preferenciasHamburguesa.add(new JRadioButton("Triple Hamburguesa"));
        preferenciasHamburguesa.add(new JCheckBox("Queso"));
        preferenciasHamburguesa.add(new JCheckBox("Tomate"));
        preferenciasHamburguesa.add(new JCheckBox("Lechuga"));
        preferenciasHamburguesa.add(new JCheckBox("Mayonesa"));
        preferenciasHamburguesa.hide();    
        
        preferenciasPizza.setLayout(new BoxLayout(preferenciasPizza, BoxLayout.Y_AXIS));
        preferenciasPizza.add(new JRadioButton("Tomate"));
        preferenciasPizza.add(new JRadioButton("Rucula"));
        preferenciasPizza.add(new JCheckBox("Huevo"));
        preferenciasPizza.add(new JCheckBox("Jamon"));
        preferenciasPizza.hide();
        
        preferenciasEmpanadas.setLayout(new BoxLayout(preferenciasEmpanadas, BoxLayout.Y_AXIS));
        preferenciasEmpanadas.add(new JLabel("Cantidad Empanadas:"));
        preferenciasEmpanadas.add(new JTextField(2));
        preferenciasEmpanadas.add(new JRadioButton("Pollo"));
        preferenciasEmpanadas.add(new JRadioButton("Carne"));
        preferenciasEmpanadas.add(new JRadioButton("Carne Cuchillo"));
        preferenciasEmpanadas.add(new JRadioButton("Jamon y Queso"));
        preferenciasEmpanadas.add(new JRadioButton("Criollo"));
        preferenciasEmpanadas.hide();
        
        JPanel bebida = new JPanel();
        bebida.setLayout(new FlowLayout());
        bebida.add(new JLabel("Bebida"));
        
        String[] listaBebida = {"Sin Bebida","Agua", "Coca~Cola","Coca~Cola Zero","Coca~Cola Light","Fanta", "Manaos", "Sprite", "Prity","Mirinda","Cerveza Iguana", "Fernet Branca"};
        JPanel opcionesBebida = new JPanel();
        opcionesComida.setLayout(new FlowLayout());
        opcionesComida.add(new JComboBox(listaBebida));
        
        JPanel guarnicion = new JPanel();
        guarnicion.setLayout(new FlowLayout());
        guarnicion.add(new JLabel("Guarnicion"));
        
        String[] listaGuarnicion = {"Sin Guarnicion","Papas Fritas", "Ensalada","Rabas"};
        JPanel opcionesGuarnicion = new JPanel();
        opcionesGuarnicion.setLayout(new FlowLayout());
        opcionesGuarnicion.add(new JComboBox(listaGuarnicion));
        
        JPanel aderezo = new JPanel();
        aderezo.setLayout(new FlowLayout());
        aderezo.add(new JLabel("Aderezo"));
        
        String[] listaAderezo = {"Sin Aderezo","Ketchup", "Mayonesa","Mostaza"};
        JPanel opcionesAderezo = new JPanel();
        opcionesAderezo.setLayout(new FlowLayout());
        opcionesAderezo.add(new JComboBox(listaAderezo));
        
        JPanel botonConfirmar = new JPanel();
        botonConfirmar.setLayout(new FlowLayout(FlowLayout.RIGHT));
        botonConfirmar.add(new JButton("Confirmar"));
        
        
        panelPrincipal1.setLayout(new GridLayout(2,2));
        panelPrincipal1.add(bienvenido);
        panelPrincipal1.add(logo);
        panelPrincipal1.add(texto);
        panelPrincipal1.add(new JLabel(""));
        
        
        panelPrincipal2.setLayout(new GridLayout(4,2));
        panelPrincipal2.add(comida);
        panelPrincipal2.add(opcionesComida);
        panelPrincipal2.add(preferenciasHamburguesa);
        panelPrincipal2.add(new JLabel(""));
        panelPrincipal2.add(preferenciasPizza);
        panelPrincipal2.add(new JLabel(""));
        panelPrincipal2.add(preferenciasEmpanadas);
        panelPrincipal2.add(new JLabel(""));
        
        
        panelPrincipal3.setLayout(new GridLayout(4,2));
        panelPrincipal3.add(bebida);
        panelPrincipal3.add(opcionesBebida);
        panelPrincipal3.add(guarnicion);
        panelPrincipal3.add(opcionesGuarnicion);
        panelPrincipal3.add(aderezo);
        panelPrincipal3.add(opcionesAderezo);
        panelPrincipal3.add(new JLabel(""));
        panelPrincipal3.add(botonConfirmar);
        
        Container cp = getContentPane();
        cp.add(panelPrincipal1, BorderLayout.NORTH);
        cp.add(panelPrincipal2, BorderLayout.CENTER);
        cp.add(panelPrincipal3, BorderLayout.SOUTH);
        this.pack();
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange() == ItemEvent.SELECTED) {
            if(e.getItem() == "Hamburguesa") {
                preferenciasPizza.hide();
                preferenciasEmpanadas.hide();
                preferenciasHamburguesa.show();
                this.panelPrincipal2.validate();
            }
            if(e.getItem() == "Pizza") {
                preferenciasPizza.show();
                preferenciasEmpanadas.hide();
                preferenciasHamburguesa.hide();
                this.panelPrincipal2.validate();
            }
            if(e.getItem() == "Empanadas") {
                preferenciasPizza.hide();
                preferenciasEmpanadas.show();
                preferenciasHamburguesa.hide();
                this.panelPrincipal2.validate();
            }
        }
    }
}
