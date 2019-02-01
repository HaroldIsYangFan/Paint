
package paint.controller;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import paint.model.Shape;


public class UR {
 
    
    
    public void undo(Canvas cs){
        
        if (cs.UN.empty()){ 
            JOptionPane.showMessageDialog(null, "You Didn't Draw Anything", "ERROR",JOptionPane.ERROR_MESSAGE); }
        else 
                    {
                                    cs.RE.push(cs.UN.pop());
                                    cs.shapes.remove(cs.shapes.size()-1);
                                    for(int i=cs.shapes.size()-1;i>=0;i--)
                                    {
                                        cs.shapes.get(i).draw(cs.getGraphics());
                                    }
                                    cs.flag=0;
                    }
        
                    
    }
                    

    public void redo(Canvas cs){
        if (cs.RE.empty()){ 
            JOptionPane.showMessageDialog(null, "You Didn't Draw Anything", "ERROR",JOptionPane.ERROR_MESSAGE); }
        else  {
                        cs.UN.push(cs.RE.peek());
                        cs.shapes.add(cs.RE.pop());
                        
                              for(int i=cs.shapes.size()-1;i>=0;i--)
                                    {
                                        cs.shapes.get(i).draw(cs.getGraphics());
                                    }
                                    cs.flag=0;
        }
        

    }
    }

    

