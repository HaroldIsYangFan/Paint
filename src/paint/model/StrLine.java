
package paint.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;


public class StrLine implements Shape {
    
    protected Point p;
    protected Map<String, Double> prop;
    protected Color c;
    protected Color fc;
    
    public StrLine() {
        prop = new HashMap<>();
        prop.put("x",0.0);
        prop.put("y",0.0);
        prop.put("x1", 0.0);
        prop.put("y2", 0.0);
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
    
        ((Graphics2D) canvas).setStroke(new BasicStroke(2));
        ((Graphics2D) canvas).setColor(getColor());
        ((Graphics2D) canvas).drawLine((int) prop.get("x").intValue(),
                (int) prop.get("y").intValue(),
                (int) prop.get("x1").intValue(),
                (int) prop.get("y1").intValue());
        
    }
    
    public Object clone() throws CloneNotSupportedException {
        Shape Cloned = new StrLine();
        Cloned.setColor(c);
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
        return "StrLine";
    }
    
}
