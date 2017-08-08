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
/**
 *
 * @author tomasm
 */
public class VentanaPedidos extends JFrame implements ItemListener, ActionListener{
    
    
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
    
    
    
    
    
    
    
    
    void Escribir(File fFichero,String cadena)
    {
        // Declaramos un buffer de escritura
        BufferedWriter bw;

        try
        {
            bw = new BufferedWriter(new FileWriter(fFichero,true));
            bw.write(cadena);
            bw.close();

        }catch(Exception e)
        {
            System.out.println(e);
        }

    }

    /***************************************************************
     * El metodo "Borrar" como su nombre lo indica, nos ayuda a
     * borrar un fichero previamente creado, este metodo cuenta con
     * un parametro, el cual es el nombre del fichero que deseamos
     * borrar
    * ***************************************************************/
    void borrar (File Ffichero)
    {
        try
        {
           // Comprovamos si el fichero existe  de ser así procedemos a borrar el archivo
            if(Ffichero.exists())
            {
                Ffichero.delete();
                System.out.println("Ficherro Borrado");
            }

        }catch(Exception e)
        {
            System.out.println(e);
        }
    }

    /***************************************************************
     * Metodo "Modificar", este cuenta con tres parametros que debemos
     * pasarle para su correcto funcionamiento, los cuales son:
     *
     * fAntiguo: Este nos ayuda a saber cual es y donde esta el archivo
     * que deseamos modificar
     *
     * aCadena: Aqui debemos especificar la cadena de caracteres que
     * deseamos modificar o cambiar
     *
     * nCadena: Por ultimo escribimos el nuevo dato que va a sustituir
     * el existente.
    * ******************************************************************/



    void modificar(File fAntiguo,String aCadena,String nCadena)
    {
       /*
            Las dos lienas de codigo siguientes, basicamente lo que hacen es generar un numero aleatorio y
            asignarselos a una nueva variable "nFnuevo" (Nombre Fichero Nuevo) la cual es igual a la ruta
            del directorio padre "fAntiguo" mas  la palabra auxiliar seguido del numero aletorio y la extension
            del archivo nuevo
       * */
        /*Random numaleatorio = new Random(3816L);
        String nFnuevo = fAntiguo.getParent()+"/auxiliar"+String.valueOf(Math.abs(numaleatorio.nextInt()))+".txt";*/

     /*// Creo un nuevo archivo
        File fNuevo= new File(nFnuevo);*/
        // Declaro un nuevo buffer de lectura
        BufferedReader br;
        try
        {
            /*Valido si el fichero antiguo que pasamos como parametro existe, si es asi procedo a leer el
            contenido que hay dentro de el
             */

            if(fAntiguo.exists())
            {
                br = new BufferedReader(new FileReader(fAntiguo));

                /* Mientras el contenido del archivo sea diferente de null procedo a comprar  la linea a modificar con
                lo que hay dentro del archivo, si linea es igual a aCadena escribo el contenido de aCadena en mi nuevo
                fichero(Auxiliar) de lo contrario escribo el mismo contenido que ya tenia el antiguo fichero en mi fichero auxiliar
                    
                 */
                /*while((linea=br.readLine()) != null)
                {
                    if(linea.equals(aCadena))
                    {
                        Escribir(fNuevo,nCadena);

                    }
                    else
                    {
                        Escribir(fNuevo,linea);
                    }
                }*/
                Escribir(fAntiguo,nCadena);
              // Cierro el buffer de lectura
                br.close();

               /* // Capturo el nombre del fichero antiguo
                String nAntiguo = fAntiguo.getName();
                // Borro el fichero antiguo
                borrar(fAntiguo);
                //Renombro el fichero auxiliar con el nombre del fichero antiguo
                fNuevo.renameTo(fAntiguo);*/




            }
            else
            {
                System.out.println("Fichero no Existe");
            }

        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    
    
    public String getArchivo( String ruta ){
        FileReader fr = null;
        BufferedReader br = null;
        //Cadena de texto donde se guardara el contenido del archivo
        String contenido = "";
        try
        {
            //ruta puede ser de tipo String o tipo File
            fr = new FileReader( ruta );
            br = new BufferedReader( fr );
 
            String linea;
            //Obtenemos el contenido del archivo linea por linea
            while( ( linea = br.readLine() ) != null ){ 
                contenido += linea + "\n";
            }
 
        }catch( Exception e ){  }
        //finally se utiliza para que si todo ocurre correctamente o si ocurre 
        //algun error se cierre el archivo que anteriormente abrimos
        finally
        {
            try{
                br.close();
            }catch( Exception ex ){}
        }
        return contenido;
    }
    
    
    
    
    

}
    
    
    
    
    
    

