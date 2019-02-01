
package paint.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;


public class Triangle implements Shape {
    
    protected Point p;
    protected Map<String, Double> prop;
    protected Color c;
    protected Color fc;
    protected String name;

    public Triangle() {
        prop = new HashMap<>();
        prop.put("X1", 0.0);
        prop.put("Y1", 0.0);
        prop.put("X2", 0.0);
        prop.put("Y2", 0.0);
        prop.put("X3", 0.0);
        prop.put("Y3", 0.0);
        prop.put("base",0.0);
        prop.put("Height",0.0);
        
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
        
        
        int[] x=new int[3];
        int[] y=new int[3];
        x[0]=prop.get("X1").intValue();
        x[1]=prop.get("X2").intValue();
        x[2]=prop.get("X3").intValue();
        y[0]=prop.get("Y1").intValue();
        y[1]=prop.get("Y2").intValue();
        y[2]=prop.get("Y3").intValue();
        if(y[2]<y[1])
        {
        x[0]=prop.get("X1").intValue();
        x[1]=prop.get("X2").intValue();
        x[2]=prop.get("X3").intValue();
        y[0]=prop.get("Y2").intValue();
        y[1]=prop.get("Y3").intValue();
        y[2]=prop.get("Y2").intValue();
        }
            
        
        
        if(getFillColor()!=null)
        {
        ((Graphics2D) canvas).setColor(getFillColor());
        ((Graphics2D) canvas).fillPolygon(x, y, 3);
        }
        ((Graphics2D) canvas).setStroke(new BasicStroke(2));
        ((Graphics2D) canvas).setColor(getColor());
        ((Graphics2D) canvas).drawPolygon(x,y,3);
    }
    
    public Object clone() throws CloneNotSupportedException {
        Shape Cloned = new Triangle();
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
        
        Point[] line = new Point[3];
        line[0]=new Point(prop.get("X1").intValue(),prop.get("Y1").intValue());
        line[1]=new Point(prop.get("X2").intValue(),prop.get("Y2").intValue());
        line[2]=new Point(prop.get("X3").intValue(),prop.get("Y3").intValue());
        
        return line;
       
    }
    
    

    @Override
    public String getName() {
        return "Triangle";
    }
    
}
    
