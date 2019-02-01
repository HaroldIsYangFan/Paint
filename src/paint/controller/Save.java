
package paint.controller;

import static com.oracle.jrockit.jfr.ContentType.Class;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamDriver;
import com.thoughtworks.xstream.io.*;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.FileChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import paint.model.Shape;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;



public class Save {
     XStream xstream = new XStream(new DomDriver());
    ArrayList<Shape> x=new ArrayList<>();
    ArrayList<Shape> y=new ArrayList<>();
    XStream json = new XStream(new JettisonMappedXmlDriver());
    File Wanted;
    
    public  void saveXML(Canvas c){
        ArrayList<Shape> list = new ArrayList<Shape>();
        String listassig = new String();
        list = c.shapes;
         listassig=xstream.toXML(list);
         System.out.println(listassig);
         XmlFileSaver(listassig);
                 
    }
    public void XmlFileSaver(String x){
        JFileChooser e = new JFileChooser();
        
        int chosen=e.showSaveDialog(null);
        Wanted = e.getSelectedFile();
        FileNameExtensionFilter s = new FileNameExtensionFilter(x, ".xml");
        e.addChoosableFileFilter(s);
        
        if(Wanted != null){
            filesaver(x,Wanted);
        }
        
        
    }
    public void filesaver(String d,File w){
        try{
            FileWriter fwriter = null;
            fwriter = new FileWriter(w);
            fwriter.write(d);
            fwriter.close();
        } catch (IOException ex){
            JOptionPane.showMessageDialog(null, "Error");
            ex.printStackTrace();
        }
    }
    
    //loadXml
    public void Xmlloader(Canvas c){
        XStream as = new XStream(new DomDriver());
        JFileChooser s = new JFileChooser();
        s.showOpenDialog(null);
        File f = s.getSelectedFile();
        x = (ArrayList)as.fromXML(f);
        for(int i=0;i<x.size();i++){
            (x.get(i)).draw(c.getGraphics());
        }
        for(int i=0;i<x.size();i++)
        {
            c.shapes.add(x.get(i));
        }
        
        
    }
    public void jsonfilesaver(Canvas c){
        JFileChooser chooser = new JFileChooser();
        int returned = chooser.showSaveDialog(null);
        ArrayList<Shape> list1 = new ArrayList<>();
        list1 = c.shapes;
         String jsontype = json.toXML(list1);
        File fjson = chooser.getSelectedFile();
        FileNameExtensionFilter s2 = new FileNameExtensionFilter(jsontype, ".json");
        chooser.addChoosableFileFilter(s2);
         try {
             FileWriter pen = new FileWriter(fjson);
         
          pen.write(jsontype);
          pen.close();
          System.out.println(jsontype);
         } catch (IOException ex) {
             ex.printStackTrace();
         }
    }
    
    public void loadjson(Canvas c){
        JFileChooser loadchooser = new JFileChooser();
  int f=loadchooser.showOpenDialog(null);
  File loaded = loadchooser.getSelectedFile();
  ArrayList<Shape> loadedarraylist = new ArrayList<>();
  loadedarraylist = (ArrayList < Shape >) json.fromXML(loaded);
  
  for(int cout = 0 ; cout<loadedarraylist.size() ; cout++){
    (loadedarraylist.get(cout)).draw(c.getGraphics());
  }
  for(int i=0;i<loadedarraylist.size();i++)
        {
            c.shapes.add(loadedarraylist.get(i));
        }
    }
    
   
   public ArrayList getarraylist()
   {
       return x;
   }
   
        
    }

     
    
    


