/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoprogramacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author tomasm
 */
public class VentanaLogin extends JFrame implements KeyListener, ActionListener, ItemListener{
    ClasePedido clasePedido = new ClasePedido();
    
    JButton botonE = new JButton("Entrar");
    JTextField text1 = new JTextField(20);
    JTextField text2 = new JTextField(20);
    public VentanaLogin(){
        super("Bascara Fast Food App");
        setSize(250,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(250,250);
        
        JPanel nombre_correo = new JPanel();
        nombre_correo.setLayout(new FlowLayout());
        nombre_correo.add(new JLabel("Nombre"));
        
        JPanel texto1 = new JPanel();
        texto1.setLayout(new FlowLayout());
        texto1.add(text1);
        
        JPanel contraseña = new JPanel();
        contraseña.setLayout(new FlowLayout());
        contraseña.add(new JLabel("Contraseña"));
        
        JPanel texto2 = new JPanel();
        texto2.setLayout(new FlowLayout());
        texto2.add(text2);
        
        JPanel botonEntrar = new JPanel();
        botonEntrar.setLayout(new FlowLayout(FlowLayout.RIGHT));
        botonE.addActionListener(this::actionPerformed);
        botonEntrar.add(botonE);
        
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(5,1));
        panelPrincipal.add(nombre_correo);
        panelPrincipal.add(texto1);
        panelPrincipal.add(contraseña);
        panelPrincipal.add(texto2);
        panelPrincipal.add(botonEntrar);
        
        Container cp = getContentPane();
        cp.add(panelPrincipal);
        this.pack();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.botonE) {
            if (text1.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"Ingrese su nombre","Error",JOptionPane.INFORMATION_MESSAGE); 
            }else{
                if (text2.getText().equals("")){
                   JOptionPane.showMessageDialog(null,"Ingrese su contraseña","Error",JOptionPane.INFORMATION_MESSAGE);
                }else{
                   VentanaApp ventanaApp = new VentanaApp();
                   ventanaApp.nombre = text1.getText();
                   this.setVisible(false);
                   ventanaApp.setVisible(true);
               }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
    }
}
