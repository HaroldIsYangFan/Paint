
package paint.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;


public class Ellipse implements Shape {
    
    protected Point p;
    protected Map<String, Double> prop;
    protected Color c;
    protected Color fc;
    

    public Ellipse() {
        prop = new HashMap<>();
        prop.put("Width", 0.0);
        prop.put("Length", 0.0);
        prop.put("midX", 0.0);
        prop.put("midY", 0.0);
        prop.put("x",0.0);
        prop.put("y",0.0);
    }
    
    @Override
    public void setPosition(Point position) {
    p = position;
    }

    @Override
    public Point getPosition() {
    return p;
    }

    @Override
    public void setProperties(Map<String, Double> properties) {
    prop = properties;
    }

    @Override
    public Map<String, Double> getProperties() {
    return prop;
    }

    @Override
    public void setColor(Color color) {
    c = color;
    }

    @Override
    public Color getColor() {
    return c;
    }

    @Override
    public void setFillColor(Color color) {
    fc = color;
    }

    @Override
    public Color getFillColor() {
    return fc;
    }

    @Override
    public void draw(Object canvas) {
        double tempx=prop.get("midX")-(prop.get("Width")/2);
        double tempy=prop.get("midY")-(prop.get("Length")/2);
        if(getFillColor()!=null)
        {
        ((Graphics2D) canvas).setColor(getFillColor());
        ((Graphics2D) canvas).fillOval((int) tempx,
                (int) tempy,
                (int) prop.get("Width").intValue(),
                (int) prop.get("Length").intValue());
        }
        ((Graphics2D) canvas).setStroke(new BasicStroke(2));
        ((Graphics) canvas).setColor(getColor());
        
        ((Graphics) canvas).drawOval((int) tempx,
                (int) tempy,
                (int) prop.get("Width").intValue(),
                (int) prop.get("Length").intValue());
        
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        Shape Cloned = new Ellipse();
        Cloned.setColor(c);
        Cloned.setFillColor(fc);
        Cloned.setPosition(p);
        Map newprop = new HashMap<>();
        for (Map.Entry s: prop.entrySet())
            newprop.put(s.getKey(), s.getValue());
        Cloned.setProperties(newprop);
        return Cloned;
      
    }

    @Override
    public Point[] GetPolygonPoints() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    @Override
    public String getName() {
        return "Ellipse";
    }
}
