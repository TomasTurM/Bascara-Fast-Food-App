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
import java.io.*;
import java.util.*;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.* ;

/**
 *
 * @author tomasm
 */

public class VentanaPedidos extends JFrame implements ItemListener, ActionListener{
    JPanel pedidos = new JPanel();
    Container cp = getContentPane();
    
    JSONObject pedidosJSON = new JSONObject();
    JSONArray arrayPedidosJSON = new JSONArray();
    
    VentanaApp ventanaApp = new VentanaApp();
    
    JButton jb1 = new JButton("Hacer otro pedido");
    JButton jb2 = new JButton("Continuar al pago");
    
    public VentanaPedidos () {
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
        fuente.setText("Pedidos");
        label1logo.add(fuente);
        ImageIcon icon = new ImageIcon("dibujo.png", "Logo");
        label1logo.add(new JLabel(icon));
        
        pedidos.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
        
        JPanel jButtons = new JPanel();
        jButtons.setLayout(new FlowLayout(FlowLayout.RIGHT));
        jb1.addActionListener(this::actionPerformed);
        jb2.addActionListener(this::actionPerformed);
        jButtons.add(jb1);
        jButtons.add(jb2);
        
        cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
        cp.add(label1logo);
        cp.add(pedidos);
        cp.add(jButtons);
        
        this.pack();
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.jb1) {
            this.setVisible(false);
            ventanaApp.setVisible(true);
        }
        if (e.getSource() == this.jb2) {
            this.setVisible(false);
            
        }
    }
    
    /* --Incompleto--
    void leerPedidos () {
        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader("f:\\test.json"));

            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject);

            String name = (String) jsonObject.get("name");
            System.out.println(name);

            long age = (Long) jsonObject.get("age");
            System.out.println(age);

            // loop array
            JSONArray msg = (JSONArray) jsonObject.get("messages");
            Iterator<String> iterator = msg.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
    }*/
}
    
    
    
    
    
    

