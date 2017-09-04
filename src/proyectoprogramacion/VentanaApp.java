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
import org.json.* ;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author tomasm
 */
public class VentanaApp extends JFrame implements ItemListener, ActionListener, WindowFocusListener {
    ClaseProducto producto = new ClaseProducto();
    ClaseProducto claseProducto = new ClaseProducto();
    ClasePizza clasePizza = new ClasePizza();
    ClaseHamburguesa claseHamburguesa = new ClaseHamburguesa();
    
    VentanaLogin ventanaLogin = new VentanaLogin();
    
    String nombreConsumidor = ventanaLogin.claseProducto.nombreConsumidor;
    
    int numeroPedido = 1;
    int numValid;
    
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
        
        rb1.addItemListener(this::itemStateChanged);
        rb2.addItemListener(this::itemStateChanged);
        
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
        
        rb3.addItemListener(this::itemStateChanged);
        rb4.addItemListener(this::itemStateChanged);
        rb5.addItemListener(this::itemStateChanged);
        rb6.addItemListener(this::itemStateChanged);
        rb7.addItemListener(this::itemStateChanged);
        
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
                        numValid = 0;
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
                        numValid = 1;
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
                        numValid = 2;
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
                        numValid = 3;
                        panelPreferencias.remove(preferenciasPizza);
                        panelPreferencias.remove(preferenciasHamburguesa);
                        vaciarHamburguesa();
                        vaciarPizza();
                        panelPreferencias.add(preferenciasEmpanadas);
                        panelPreferencias.validate();
                        panelPrincipal2.validate();
                        cp.validate();
                        this.pack();
                    }
                    if(rb1.isSelected()) {
                        rb2.setSelected(false);
                        preferenciasHamburguesa.validate();
                        panelPreferencias.validate();
                        panelPrincipal2.validate();
                        cp.validate();
                    } 
                    if(rb2.isSelected()) {
                        rb1.setSelected(false);
                        preferenciasHamburguesa.validate();
                        panelPreferencias.validate();
                        panelPrincipal2.validate();
                        cp.validate();
                    }
                    if(rb3.isSelected()) {
                        rb4.setSelected(false);
                        rb5.setSelected(false);
                        rb6.setSelected(false);
                        rb7.setSelected(false);
                        preferenciasEmpanadas.validate();
                        panelPreferencias.validate();
                        panelPrincipal2.validate();
                        cp.validate();
                    }
                    if(rb4.isSelected()) {
                        rb3.setSelected(false);
                        rb5.setSelected(false);
                        rb6.setSelected(false);
                        rb7.setSelected(false);
                        preferenciasEmpanadas.validate();
                        panelPreferencias.validate();
                        panelPrincipal2.validate();
                        cp.validate();
                    }
                    if(rb5.isSelected()) {
                        rb4.setSelected(false);
                        rb3.setSelected(false);
                        rb6.setSelected(false);
                        rb7.setSelected(false);
                        preferenciasEmpanadas.validate();
                        panelPreferencias.validate();
                        panelPrincipal2.validate();
                        cp.validate();
                    }
                    if(rb6.isSelected()) {
                        rb4.setSelected(false);
                        rb5.setSelected(false);
                        rb3.setSelected(false);
                        rb7.setSelected(false);
                        preferenciasEmpanadas.validate();
                        panelPreferencias.validate();
                        panelPrincipal2.validate();
                        cp.validate();
                    }
                    if(rb7.isSelected()) {
                        rb4.setSelected(false);
                        rb5.setSelected(false);
                        rb6.setSelected(false);
                        rb3.setSelected(false);
                        preferenciasEmpanadas.validate();
                        panelPreferencias.validate();
                        panelPrincipal2.validate();
                        cp.validate();
                    }
                }
            }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.confirmar) {
            try {
                setearPedido();
            } catch (JSONException ex) {
                Logger.getLogger(VentanaApp.class.getName()).log(Level.SEVERE, null, ex);
            }
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
    
    public void setearPedido () throws JSONException {
            producto.nombreConsumidor = nombreConsumidor;
            producto.comida = comboBoxComida.getSelectedItem().toString();
            claseHamburguesa.dobleHamburguesa = rb1.isSelected();
            claseHamburguesa.tripleHamburguesa = rb2.isSelected();
            claseHamburguesa.queso = cb1.isSelected();
            claseHamburguesa.tomate1 = cb2.isSelected();
            claseHamburguesa.lechuga = cb3.isSelected();
            claseHamburguesa.mayonesa = cb4.isSelected();
            clasePizza.tomate2 = cb5.isSelected();
            clasePizza.rucula = cb6.isSelected();
            clasePizza.huevo = cb7.isSelected();
            clasePizza.jamon = cb8.isSelected();
            producto.cantEmpanadas = tf1.getText();
            producto.pollo = rb3.isSelected();
            producto.carne = rb4.isSelected();
            producto.carneCuchillo =  rb5.isSelected();
            producto.jamon_queso = rb6.isSelected();
            producto.criollo = rb7.isSelected();
            producto.bebida = comboBoxBebida.getSelectedItem().toString();
            producto.guarnicion = comboBoxGuarnicion.getSelectedItem().toString();
            producto.aderezo = comboBoxAderezo.getSelectedItem().toString();
             
            JSONObject jsonObj = new JSONObject();
            JSONArray jsonPedidos = new JSONArray();
            
            jsonPedidos.put(toString());
            jsonObj.put("Pedido",jsonPedidos);
             
            try (FileWriter escritor = new FileWriter("Pedidos.json")) {
                 escritor.write(jsonObj.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
             
             System.out.println(toString());
    }

    @Override
    public String toString() {
        String elPedido = "";
        if (numValid == 1 && claseHamburguesa.dobleHamburguesa == true) {
            elPedido = "Pedido " + numeroPedido + " = " + "Doble Hamburguesa, " + "Queso = " + claseHamburguesa.queso + ", Tomate = " + claseHamburguesa.tomate1 + ", Lechuga = " + claseHamburguesa.lechuga + ", Mayonesa = " + claseHamburguesa.mayonesa + ", Bebida = " + comboBoxBebida.getSelectedItem() + ", Guarnicion = " + comboBoxGuarnicion.getSelectedItem() + ", Aderezo = " + comboBoxAderezo.getSelectedItem();
        } else if (numValid == 1 && claseHamburguesa.tripleHamburguesa == true) {
            elPedido = "Pedido " + numeroPedido + " = " + "Triple Hamburguesa, " + "Queso = " + claseHamburguesa.queso + ", Tomate = " + claseHamburguesa.tomate1 + ", Lechuga = " + claseHamburguesa.lechuga + ", Mayonesa = " + claseHamburguesa.mayonesa + ", Bebida = " + comboBoxBebida.getSelectedItem() + ", Guarnicion = " + comboBoxGuarnicion.getSelectedItem() + ", Aderezo = " + comboBoxAderezo.getSelectedItem();
        }
        if (numValid == 1 && claseHamburguesa.dobleHamburguesa == false && claseHamburguesa.tripleHamburguesa == false) {
            elPedido = "Pedido " + numeroPedido + " = " + "Hamburguesa Simple, " + "Queso = " + claseHamburguesa.queso + ", Tomate = " + claseHamburguesa.tomate1 + ", Lechuga = " + claseHamburguesa.lechuga + ", Mayonesa = " + claseHamburguesa.mayonesa + ", Bebida = " + comboBoxBebida.getSelectedItem() + ", Guarnicion = " + comboBoxGuarnicion.getSelectedItem() + ", Aderezo = " + comboBoxAderezo.getSelectedItem();
        }  
        if (numValid == 2) {
            elPedido = "Pedido " + numeroPedido + " = " + "Pizza, " + "Tomate = " + clasePizza.tomate2 + ", Rucula = " + clasePizza.rucula + ", Huevo = " + clasePizza.huevo + ", Jamon = " + clasePizza.jamon + ", Bebida = " + comboBoxBebida.getSelectedItem() + ", Guarnicion = " + comboBoxGuarnicion.getSelectedItem() + ", Aderezo = " + comboBoxAderezo.getSelectedItem();
        }
        if (numValid == 3 && producto.pollo == true) {
            elPedido = "Pedido " + numeroPedido + " = " + producto.cantEmpanadas + " Empanada/s de Pollo" + ", Bebida = " + comboBoxBebida.getSelectedItem() + ", Guarnicion = " + comboBoxGuarnicion.getSelectedItem() + ", Aderezo = " + comboBoxAderezo.getSelectedItem();
        } else if (numValid == 3 && producto.carne == true) {
            elPedido = "Pedido " + numeroPedido + " = " + producto.cantEmpanadas + " Empanada/s de Carne" + ", Bebida = " + comboBoxBebida.getSelectedItem() + ", Guarnicion = " + comboBoxGuarnicion.getSelectedItem() + ", Aderezo = " + comboBoxAderezo.getSelectedItem();
        } else if (numValid == 3 && producto.carneCuchillo == true) {
            elPedido = "Pedido " + numeroPedido + " = " + producto.cantEmpanadas + " Empanada/s de Carne al Cuchillo" + ", Bebida = " + comboBoxBebida.getSelectedItem() + ", Guarnicion = " + comboBoxGuarnicion.getSelectedItem() + ", Aderezo = " + comboBoxAderezo.getSelectedItem();
        } else if (numValid == 3 && producto.jamon_queso == true) {
            elPedido = "Pedido " + numeroPedido + " = " + producto.cantEmpanadas + " Empanada/s de Jamon y Queso" + ", Bebida = " + comboBoxBebida.getSelectedItem() + ", Guarnicion = " + comboBoxGuarnicion.getSelectedItem() + ", Aderezo = " + comboBoxAderezo.getSelectedItem();
        } else if (numValid == 3 && producto.criollo == true) {
            elPedido = "Pedido " + numeroPedido + " = " + producto.cantEmpanadas + " Empanada/s Criolla/s" + ", Bebida = " + comboBoxBebida.getSelectedItem() + ", Guarnicion = " + comboBoxGuarnicion.getSelectedItem() + ", Aderezo = " + comboBoxAderezo.getSelectedItem();
        }
        return elPedido;
    }
}
