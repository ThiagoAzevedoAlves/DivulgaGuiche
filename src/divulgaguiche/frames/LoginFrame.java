/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package divulgaguiche.frames;


import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;

        
/**
 *
 * @author Thiago
 */
public class LoginFrame extends javax.swing.JFrame {
    
    public LoginFrame() {
        initComponents();
        this.setSize(400, 300);
        BufferedImage resizedImg = new BufferedImage(400, 300, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = resizedImg.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(new ImageIcon(getClass().getResource("/rec/painel1.png")).getImage(), 0, 0, 400, 300, null);
        g.dispose();
        jLfundo.setIcon(new javax.swing.ImageIcon(resizedImg));
        MoveJanela mj = new MoveJanela(this.jLfundo);
        jLfundo.addMouseListener(mj);
        jLfundo.addMouseMotionListener(mj);
        this.jTextField1.selectAll();
    }
    
    /**
    * Classe Responável pelo Drag'n'Drop da Janela
    */
    public class MoveJanela implements MouseListener, MouseMotionListener{
        
        JComponent target;
        Point start_drag;
        Point start_loc;
        
        public MoveJanela(JComponent target) {
            this.target = target;
        }
        
        public JFrame getFrame(Container target) {
            if (target instanceof JFrame) {
                return (JFrame) target;
            }
            return getFrame(target.getParent());
        }

        Point getScreenLocation(MouseEvent e) {
            Point cursor = e.getPoint();
            Point target_location = this.target.getLocationOnScreen();
            return new Point((int) (target_location.getX() + cursor.getX()), (int) (target_location.getY() + cursor.getY()));
        }
        
        @Override
        public void mouseClicked(MouseEvent e) {            
        }

        @Override
        public void mousePressed(MouseEvent e) {
            this.start_drag = this.getScreenLocation(e);
            this.start_loc = this.getFrame(this.target).getLocation();
        }

        @Override
        public void mouseReleased(MouseEvent e) {            
        }

        @Override
        public void mouseEntered(MouseEvent e) {            
        }

        @Override
        public void mouseExited(MouseEvent e) {            
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            Point current = this.getScreenLocation(e);
            Point offset = new Point((int) current.getX() - (int) start_drag.getX(),(int) current.getY() - (int) start_drag.getY());
            JFrame frame = this.getFrame(target);
            Point new_location = new Point((int) (this.start_loc.getX() + offset.getX()), (int) (this.start_loc.getY() + offset.getY()));
            frame.setLocation(new_location);
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            
        }
               
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLfundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Square721 BT", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 153));
        jLabel1.setText("Tipo:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 170, 140, 50);

        jLabel2.setFont(new java.awt.Font("Square721 BT", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 153));
        jLabel2.setText("Guiche:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 14, 140, 130);

        jComboBox1.setFont(new java.awt.Font("Square721 BT", 1, 36)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Certidões", "Registros" }));
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(150, 170, 240, 50);

        jTextField1.setFont(new java.awt.Font("Square721 BT", 1, 80)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("1");
        getContentPane().add(jTextField1);
        jTextField1.setBounds(150, 10, 240, 140);

        jButton1.setFont(new java.awt.Font("Square721 BT", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 0, 153));
        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(270, 240, 120, 40);

        jButton3.setFont(new java.awt.Font("Square721 BT", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(102, 0, 153));
        jButton3.setText("Mini");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(140, 240, 120, 40);

        jButton2.setFont(new java.awt.Font("Square721 BT", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(102, 0, 153));
        jButton2.setText("Iniciar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(10, 240, 120, 40);

        jLfundo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLfundo.setToolTipText("");
        jLfundo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.lightGray, java.awt.Color.black, java.awt.Color.darkGray));
        getContentPane().add(jLfundo);
        jLfundo.setBounds(0, 0, 400, 300);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
//        try {
//            URL url = new URL("http://0.0.0.0:9876/webservice.sistemadivulga?wsdl");
//            QName qname = new QName("http://webservice.sistemadivulga/", "PainelService");
//            Service service = Service.create(url, qname);
//            server s = service.getPort(server.class);
//            s.IniciaGuiche(Integer.valueOf(this.jTextField1.getText()), 0);
//        } catch (MalformedURLException ex) {
//            ex.printStackTrace();
//        }
        if(this.jComboBox1.getSelectedIndex() == 0){
            GuicheFrame gF = new GuicheFrame(Integer.valueOf(this.jTextField1.getText()), "Certidões");
            gF.setVisible(true);
        }else{
            GuicheFrame gF = new GuicheFrame(Integer.valueOf(this.jTextField1.getText()), "Registros");
            gF.setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
//        try {
//            URL url = new URL("http://0.0.0.0:9876/webservice.sistemadivulga?wsdl");
//            QName qname = new QName("http://webservice.sistemadivulga/", "PainelService");
//            Service service = Service.create(url, qname);
//            server s = service.getPort(server.class);
//            s.IniciaGuiche(Integer.valueOf(this.jTextField1.getText()), 0);
//        } catch (MalformedURLException ex) {
//            ex.printStackTrace();
//        }
        if(this.jComboBox1.getSelectedIndex() == 0){
            MiniFrame mF = new MiniFrame(Integer.valueOf(this.jTextField1.getText()), "Certidões");
            mF.setVisible(true);
        }else{
            MiniFrame mF = new MiniFrame(Integer.valueOf(this.jTextField1.getText()), "Registros");
            mF.setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLfundo;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
