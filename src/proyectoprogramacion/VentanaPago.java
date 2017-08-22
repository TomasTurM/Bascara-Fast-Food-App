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
public class VentanaPago extends JFrame implements ActionListener, ItemListener {
    
    /*Recordatorio: Crear Objetos para elejir los datos de Trajeta*/
    
    JPanel panelOpciones = new JPanel();
    JPanel opcionesEfectivo = new JPanel();
    JPanel opcionesTarjeta = new JPanel();
    Container cp = getContentPane();
    
    JLabel jl1 = new JLabel("Forma de Pago");
    
    String[] listaFormasPago = {"", "Efectivo", "Tarjeta"};
    
    JComboBox jcb1 = new JComboBox(listaFormasPago);
    
    public VentanaPago () {
        super("Bascara Fast Food App");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(250,250);
        setResizable(false);
        setLocation(250,250);
        
        JPanel label1logo = new JPanel();
        label1logo.setLayout(new FlowLayout());
        JLabel fuente = new JLabel();
        fuente.setFont(new java.awt.Font("Tahoma", 1, 40));
        fuente.setForeground(new java.awt.Color(255,   0,   0));
        fuente.setText("Pago");
        label1logo.add(fuente);
        ImageIcon icon = new ImageIcon("dibujo.png", "Logo");
        label1logo.add(new JLabel(icon));
        
        JPanel formaPago = new JPanel();
        formaPago.setLayout(new FlowLayout());
        formaPago.add(jl1);
        formaPago.add(jcb1);
        
        cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
        cp.add(label1logo);
        cp.add(formaPago);
        
        this.pack();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        
    }
}
