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
import org.json.* ;

/**
 *
 * @author tomasm
 */
public class VentanaPedidos extends JFrame implements ItemListener, ActionListener{
    JPanel pedidos = new JPanel();
    
    public VentanaPedidos () {
        super("Bascara Fast Food App");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocation(250,250);
        
        JPanel label1 = new JPanel();
        label1.setLayout(new FlowLayout());
        JLabel fuente = new JLabel();
        fuente.setFont(new java.awt.Font("Tahoma", 1, 40));
        fuente.setForeground(new java.awt.Color(255,   0,   0));
        fuente.setText("Pedidos");
        label1.add(fuente);
        
        JPanel logo = new JPanel();
        logo.setLayout(new FlowLayout());
        ImageIcon icon = new ImageIcon("dibujo.png", "Logo");
        logo.add(new JLabel(icon));
        
        
        pedidos.setLayout(new BoxLayout(pedidos, BoxLayout.Y_AXIS));
        
        
         JSONObject obj = new JSONObject(); 
        
        
        
        
        this.pack();
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void crearPedido () {
        if (getArchivo("Pedidos") != null) {
            pedidos.add(new JButton(""));
        }
        for (int i=0; i < getArchivo("Pedidos").length(); i++) {
            
        }
        
        
        
    }
    
    
    
    
    public void escribirArchivo (File archivo,String texto) {
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(archivo,true));
            bw.write(texto);
            bw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void borrarArchivo (File archivo) {
        try {
            if (archivo.exists()) {
                archivo.delete();
                System.out.println("Ficherro Borrado");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    void modificarArchivo (File archivo,String texto) {
        BufferedReader br;
        try {
            if (archivo.exists()) {
                br = new BufferedReader(new FileReader(archivo));
                escribirArchivo(archivo,texto);
                br.close();
            } else {
                System.out.println("El Archivo no Existe");
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    
    
    
    public String getArchivo (String ruta) {
        FileReader fr;
        BufferedReader br = null;
        String contenido = "";
        try {
            fr = new FileReader(ruta);
            br = new BufferedReader( fr );
            String linea;
            while ((linea = br.readLine()) != null) { 
                contenido += linea + "\n";
            }
        } catch (Exception e){}
        finally
        {
            try{
                br.close();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        return contenido;
    }
    
    public int cantPedidos () {
        int cantidad = 0;
        if (getArchivo ("Pedidos").contains("pedido")) {
            cantidad = cantidad + 1;
        }
        return cantidad;
    }
}
    
    
    
    
    
    

