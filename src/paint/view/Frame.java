
package paint.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import paint.controller.Canvas;
import paint.controller.Save;
import paint.model.Ellipse;

@SuppressWarnings("serial")
public class Frame extends JFrame {
    
    private JButton Square, Circle, Ellipse, Rectangle, Triangle, Line,x,y,z,Delete,copy,undo,redo;
    Canvas C;
    private JButton Backgroundcol;
    private JButton Drawingcol ;
    private JButton Fillcol;
    private Color backcolordef = Color.WHITE;
    private Color Drawingcoldef = Color.BLACK;
    private Color Defdcol = Color.BLACK;
    private Color Fillcoldef;
    private Color Fillcolvar;
    private JMenuBar bar;
    private JMenu file,save,load;
    private JMenuItem xml,jason,xfile,jfile;
    Save s = new Save();
    
    
    Frame(){
                C = Canvas.getinstance();
                C.setBackground(Color.WHITE);
		setSize(2000, 770);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
        
                xml = new JMenuItem("As Xml");
		jason = new JMenuItem("As Json");
		xfile = new JMenuItem("Xml file");
		jfile = new JMenuItem("Json file");
		save = new JMenu("Save");
		save.add(xml);
		save.add(jason);
		load = new JMenu("Load");
		load.add(xfile);
		load.add(jfile);
		file = new JMenu("File");
		file.add(save);
		file.add(load);
		bar = new JMenuBar();
		bar.add(file);
		bar.setBounds(0, 0, 1400, 20);

		add(bar);
                
                Ellipse = new JButton(new ImageIcon("Capture2.png"));
                Ellipse.setBackground(Color.WHITE);
                Ellipse.setBounds(100,30,40,40);
                Circle = new JButton(new ImageIcon("Capture1.png"));
                Circle.setBackground(Color.WHITE);
                Circle.setBounds(100, 75, 40, 40);
                Rectangle = new JButton(new ImageIcon("rectangle.png"));
                Rectangle.setBackground(Color.WHITE);
                Rectangle.setBounds(55, 30, 40, 40);
                Square = new JButton(new ImageIcon("Capture.png"));
                Square.setBackground(Color.WHITE);
                Square.setBounds(10,30,40,40);
                Triangle = new JButton(new ImageIcon("Capture3.png"));
                Triangle.setBackground(Color.WHITE);
                Triangle.setBounds(10, 75, 40, 40);
                Line = new JButton(new ImageIcon("Capture4.png"));
                Line.setBackground(Color.WHITE);
                Line.setBounds(55, 75, 40, 40);
                
                
                Backgroundcol = new JButton(new ImageIcon("colorChooser.png"));
                Backgroundcol.setBackground(backcolordef);
                Backgroundcol.setBounds(150, 30, 80, 85);
                Drawingcol = new JButton(new ImageIcon("changeColor.jpg"));
                Drawingcol.setBackground(Color.WHITE);
                Drawingcol.setBounds(240, 30, 40, 40);
                Fillcol = new JButton(new  ImageIcon("fill.png"));
                Fillcol.setBackground(Color.WHITE);
                Fillcol.setBounds(240, 75, 40, 40);
                x = new JButton(new  ImageIcon("move.png"));
                x.setBackground(Color.WHITE);
                x.setBounds(290,30,40,40);
                y = new JButton(new  ImageIcon("refresh.png"));
                y.setBackground(Color.WHITE);
                y.setBounds(340,75,40,40);
                z = new JButton(new  ImageIcon("resize.png"));
                z.setBackground(Color.WHITE);
                z.setBounds(290,75,40,40);
                Delete = new JButton(new ImageIcon("delete.png"));
                Delete.setBackground(Color.WHITE);
                Delete.setBounds(340,30,40, 40);
                copy = new JButton(new ImageIcon("copy.png"));
                copy.setBackground(Color.WHITE);
                copy.setBounds(1080,30,90,80);
                undo = new JButton(new  ImageIcon("undo.png"));
                undo.setBackground(Color.WHITE);
                undo.setBounds(1180,30,70,80);
                redo = new JButton(new  ImageIcon("redo.png"));
                redo.setBackground(Color.WHITE);
                redo.setBounds(1260,30,70,80);
                
                add(Ellipse);
                add(Circle);
                add(Rectangle);
                add(Square);
                add(Triangle);
                add(Line);
                add(Backgroundcol);
                add(Drawingcol);
                add(Fillcol);
                add(x);
                add(y);
                add(z);
                add(Delete);
                add(copy);
                add(undo);
                add(redo);
                
                C.setBounds(0, 120, 1400, 700);
		add(C);
                
		Ellipse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				C.flag = 1;
                                			
                        }
		});           
                Circle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				C.flag = 2;
			}
		});

		Rectangle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				C.flag = 3;
			}
		});
		
		Square.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				C.flag = 4;
			}
		});

		Triangle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				C.flag = 5;
			        
			}
		});

		Line.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				C.flag = 6;
			}
		});
                
                x.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				C.flag = 7;
			}
		});
                y.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				C.refresh(C);
			}
		});
                Delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				C.flag = 9;
			}
		});
                z.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				C.flag = 10;
			}
		});
                copy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				C.flag = 11;
			}
		});
                
                
                Backgroundcol.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        C.backcolflag = JColorChooser.showDialog(null, "Pick Your BackGround Color", backcolordef);
                        if(C.backcolflag == null)
                            C.backcolflag = backcolordef;
                            C.setBackground(C.backcolflag);
                    }
                });
                Drawingcol.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Drawingcoldef = JColorChooser.showDialog(null, "Pick Your Drawing Color", Defdcol);
                        if(Drawingcoldef == null)
                            Drawingcoldef = Defdcol;
                        C.setDrawingcol(Drawingcoldef);
                       
                    }
                });
                Fillcol.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Fillcolvar = JColorChooser.showDialog(null, "Pick Fill Color", Fillcoldef);
                        if(Fillcolvar == null)
                            Fillcolvar = Fillcoldef;
                        C.setFillcol(Fillcolvar);
                    }
                });
                undo.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        C.undo();
                        C.flag=20;
                        C.refresh(this);
                    }
                });
                redo.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        C.redo();
                        C.flag=20;
                        C.refresh(this);
                    }
                });
                xml.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                        s.saveXML(C);
                        JOptionPane.showMessageDialog(null, "Saved");
                    }
                });
                xfile.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        
                         s.Xmlloader(C);
                    }
                });
                jason.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        s.jsonfilesaver(C);
                         JOptionPane.showMessageDialog(null, "Saved");
                    }
                });
                jfile.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        s.loadjson(C);
                    }
                });
                
                 
                  }

}
