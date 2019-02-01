
package paint.view;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Welcome extends javax.swing.JFrame {


    
    public Welcome() {
        initComponents();
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        PBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(350, 150));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/paint/view/paintwindow.PNG"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 370));

        PBar.setForeground(new java.awt.Color(204, 51, 0));
        PBar.setBorderPainted(false);
        getContentPane().add(PBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 650, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {
       
        Welcome w = new Welcome();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                w.setVisible(true);
            }
        });
                try {
                for (int i=0 ; i<= 100 ; i++){
                        Thread.sleep(50);
                        w.PBar.setValue(i);
                }
                }catch (Exception e){}
                w.dispose();
                w.setVisible(false);
                Frame f = new Frame();
                f.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar PBar;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
