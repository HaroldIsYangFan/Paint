
package paint.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;


public class Square implements Shape {
    
    protected Point p;
    protected Map<String, Double> prop;
    protected Color c;
    protected Color fc;
    public Square() {
        prop = new HashMap<>();
        prop = new HashMap<>();
        prop.put("x",0.0);
        prop.put("y",0.0);
        prop.put("Length", 0.0);
        
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
    public Point[] GetPolygonPoints()
    {
        Point z=new Point(prop.get("x").intValue(),prop.get("y").intValue());
        Point[] line = new Point[4];
        line[0]=z;
        line[1]=new Point(z.x,z.y+prop.get("Length").intValue());
        line[2]=new Point(z.x+prop.get("Length").intValue(),z.y+prop.get("Length").intValue());
        line[3]=new Point(z.x+prop.get("Length").intValue(),z.y);
        return line;
    }

    @Override
    public void draw(Object canvas) {
        
        
        if(getFillColor()!=null)
        {
        ((Graphics2D) canvas).setColor(getFillColor());
        ((Graphics2D) canvas).fillRect(prop.get("x").intValue(),prop.get("y").intValue(),prop.get("Length").intValue(),prop.get("Length").intValue());
        }
        ((Graphics2D) canvas).setStroke(new BasicStroke(2));
        ((Graphics2D) canvas).setColor(getColor());
        ((Graphics2D) canvas).drawRect(prop.get("x").intValue(),prop.get("y").intValue(),prop.get("Length").intValue(),prop.get("Length").intValue());
        
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        Shape Cloned = new Square();
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
    public String getName() {
        return "Square";
    }
    
    
}
