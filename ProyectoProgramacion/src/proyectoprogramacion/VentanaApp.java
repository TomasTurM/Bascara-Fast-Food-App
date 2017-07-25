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
    
    public VentanaApp () {
        super("App");
        setSize(250,250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocation(250,250);
        
        JPanel bienvenido = new JPanel();
        bienvenido.setLayout(new FlowLayout());
        JLabel fuente = new JLabel();
        fuente.setFont(new java.awt.Font("Tahoma", 0, 36));
        bienvenido.add(fuente);
        
        /*JPanel logo = new JPanel();
        logo.setLayout(new FlowLayout());
        logo.add(new ImageIcon());*/
        
        JPanel texto = new JPanel();
        texto.setLayout(new FlowLayout());
        texto.add(new JLabel("Hola " + ", ¿Qué desea ordenar?"));
        
        JPanel comida = new JPanel();
        comida.setLayout(new FlowLayout());
        comida.add(new JLabel("Comida"));
        
        String[] listaComida = {"Hamburguesa", "Pizza", "Empanadas"};
        JPanel opcionesComida = new JPanel();
        opcionesComida.setLayout(new FlowLayout());
        opcionesComida.add(new JComboBox(listaComida));
        
        JPanel preferenciasHaburguesa = new JPanel();
        preferenciasHaburguesa.setLayout(new BoxLayout(preferenciasHaburguesa, BoxLayout.Y_AXIS));
        preferenciasHaburguesa.add(new JRadioButton("Doble Hamburguesa"));
        preferenciasHaburguesa.add(new JRadioButton("Triple Hamburguesa"));
        preferenciasHaburguesa.add(new JCheckBox("Queso"));
        preferenciasHaburguesa.add(new JCheckBox(""));
        preferenciasHaburguesa.add(new JCheckBox(""));
        
        
        
        
        
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
        
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(10,2));
        panelPrincipal.add(bienvenido);
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange() == ItemEvent.SELECTED) {
            if(e.getItem() == "Hamburguesa") {
                System.out.println("river => Intoxicados");
            }
            if(e.getItem() == "Pizza") {
                System.out.println("boca => el único Grande");
            }
            if(e.getItem() == "Empanadas") {
                System.out.println("boca => el único Grande");
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
