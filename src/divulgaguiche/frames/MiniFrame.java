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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import sistemadivulga.webservice.server;

/**
 *
 * @author Thiago
 */
public class MiniFrame extends javax.swing.JFrame {
    
    int guiche;
    String tipo;
    int ultimo = 0;
    public static Timer timer = new Timer(3000, null);
    
    public MiniFrame(int guiche, String tipo) {
        this.guiche = guiche;
        this.tipo = tipo;
        initComponents();
        this.setSize(350, 290);
        //fundo------------------------------------------------------------------------------------//
        BufferedImage resizedImg = new BufferedImage(1280, 768, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = resizedImg.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(new ImageIcon(getClass().getResource("/rec/painel1.png")).getImage(), 0, 0, 1280, 768, null);
        g.dispose();
        
        jLfundo.setIcon(new javax.swing.ImageIcon(resizedImg));
        //-----------------------------------------------------------------------------------------//
        
        this.jLguiche.setText("#"+Integer.toString(guiche));
        this.jLtipo.setText(tipo);
        if(tipo.compareTo("Registros")==0){
            timer.addActionListener(FilaReg);            
        }else{
            timer.addActionListener(FilaCert);
        }
        timer.start();
        MoveJanela mj = new MoveJanela(this.jLfundo);
        jLfundo.addMouseListener(mj);
        jLfundo.addMouseMotionListener(mj);
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
    
    
    public ActionListener FilaReg = (ActionEvent evt) -> {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    URL url = new URL("http://0.0.0.0:9876/webservice.sistemadivulga?wsdl");
                    QName qname = new QName("http://webservice.sistemadivulga/", "PainelService");
                    Service service = Service.create(url, qname);
                    server s = service.getPort(server.class);
                    jLfila1.setText(String.valueOf(s.FilaRegistros()));
                    jLatual.setText(String.valueOf(s.TotalRegistros()));
                } catch (MalformedURLException ex) {
                    Logger.getLogger(GuicheFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    };
    
    public ActionListener FilaCert = (ActionEvent evt) -> {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    URL url = new URL("http://0.0.0.0:9876/webservice.sistemadivulga?wsdl");
                    QName qname = new QName("http://webservice.sistemadivulga/", "PainelService");
                    Service service = Service.create(url, qname);
                    server s = service.getPort(server.class);
                    jLfila1.setText(String.valueOf(s.FilaCertidoes()[0]));
                    jLfila2.setText(String.valueOf(s.FilaCertidoes()[1]));
                    if(ultimo == 0){
                        jLatual.setText(String.valueOf(s.TotalCertidoes()[0]));
                    }else{
                        jLatual.setText(String.valueOf(s.TotalCertidoes()[1]));
                    }
                } catch (MalformedURLException ex) {
                    Logger.getLogger(GuicheFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    };

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLguiche = new javax.swing.JLabel();
        jLtipo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLatual = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLfila2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLfila1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLfundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        jLguiche.setFont(new java.awt.Font("Square721 BT", 1, 14)); // NOI18N
        jLguiche.setForeground(new java.awt.Color(102, 0, 153));
        jLguiche.setText("1");
        getContentPane().add(jLguiche);
        jLguiche.setBounds(180, 20, 30, 18);

        jLtipo.setFont(new java.awt.Font("Square721 BT", 1, 14)); // NOI18N
        jLtipo.setForeground(new java.awt.Color(102, 0, 153));
        jLtipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLtipo.setText("Certidões");
        getContentPane().add(jLtipo);
        jLtipo.setBounds(100, 0, 100, 18);

        jLabel2.setFont(new java.awt.Font("Square721 BT", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 153));
        jLabel2.setText("Gichê:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(110, 20, 50, 18);

        jLabel3.setFont(new java.awt.Font("Square721 BT", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 153));
        jLabel3.setText("Preferencial:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(110, 170, 100, 18);

        jLatual.setFont(new java.awt.Font("Square721 BT", 1, 60)); // NOI18N
        jLatual.setForeground(new java.awt.Color(255, 0, 0));
        jLatual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLatual.setText("100");
        getContentPane().add(jLatual);
        jLatual.setBounds(90, 50, 180, 100);

        jLabel5.setFont(new java.awt.Font("Square721 BT", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 0, 153));
        jLabel5.setText("Senha:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(40, 90, 60, 18);

        jLabel6.setFont(new java.awt.Font("Square721 BT", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 0, 153));
        jLabel6.setText("Normal:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(110, 190, 60, 18);

        jLfila2.setFont(new java.awt.Font("Square721 BT", 1, 14)); // NOI18N
        jLfila2.setForeground(new java.awt.Color(255, 0, 0));
        jLfila2.setText("0");
        getContentPane().add(jLfila2);
        jLfila2.setBounds(220, 170, 60, 18);

        jLabel8.setFont(new java.awt.Font("Square721 BT", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 0, 153));
        jLabel8.setText("Fila:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(160, 140, 30, 20);

        jLfila1.setFont(new java.awt.Font("Square721 BT", 1, 14)); // NOI18N
        jLfila1.setForeground(new java.awt.Color(255, 0, 0));
        jLfila1.setText("0");
        getContentPane().add(jLfila1);
        jLfila1.setBounds(220, 190, 60, 18);

        jButton1.setFont(new java.awt.Font("Square721 BT", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 0, 153));
        jButton1.setText("Repetir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(140, 260, 110, 23);

        jButton2.setFont(new java.awt.Font("Square721 BT", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(102, 0, 153));
        jButton2.setText("Preferencial");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(20, 230, 110, 23);

        jButton3.setFont(new java.awt.Font("Square721 BT", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(102, 0, 153));
        jButton3.setText("Sair");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(260, 230, 70, 50);

        jButton4.setFont(new java.awt.Font("Square721 BT", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(102, 0, 153));
        jButton4.setText("Proximo");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(20, 260, 110, 23);

        jButton5.setFont(new java.awt.Font("Square721 BT", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(102, 0, 153));
        jButton5.setText("Automático");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(140, 230, 110, 23);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 210, 350, 10);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(0, 160, 350, 2);

        jLabel1.setFont(new java.awt.Font("Square721 BT", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 153));
        jLabel1.setText("max!");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1);
        jLabel1.setBounds(300, 0, 33, 18);

        jLfundo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.lightGray, null, null));
        getContentPane().add(jLfundo);
        jLfundo.setBounds(0, 0, 350, 290);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(!"Registros".equals(tipo)){
            try {
                URL url = new URL("http://0.0.0.0:9876/webservice.sistemadivulga?wsdl");
                QName qname = new QName("http://webservice.sistemadivulga/", "PainelService");
                Service service = Service.create(url, qname);
                server s = service.getPort(server.class);
                s.PreferencialProximo2(guiche);
                ultimo = 1;
            } catch (MalformedURLException ex) {
                Logger.getLogger(GuicheFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
            if(!"Registros".equals(tipo)){
            try {
                URL url = new URL("http://0.0.0.0:9876/webservice.sistemadivulga?wsdl");
                QName qname = new QName("http://webservice.sistemadivulga/", "PainelService");
                Service service = Service.create(url, qname);
                server s = service.getPort(server.class);
                if(ultimo == 0){
                    if(s.FilaCertidoes()[1]>0){
                        s.PreferencialProximo2(guiche);
                        ultimo = 1;
                    }else{
                        s.CertidaoProximo2(guiche);
                        ultimo = 0;
                    }
                }else{
                    s.CertidaoProximo2(guiche);
                    ultimo = 0;
                }
            } catch (MalformedURLException ex) {
                Logger.getLogger(GuicheFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                URL url = new URL("http://0.0.0.0:9876/webservice.sistemadivulga?wsdl");
                QName qname = new QName("http://webservice.sistemadivulga/", "PainelService");
                Service service = Service.create(url, qname);
                server s = service.getPort(server.class);
                s.RegistrosProximo2(guiche);
            } catch (MalformedURLException ex) {
                Logger.getLogger(GuicheFrame.class.getName()).log(Level.SEVERE, null, ex);
            }    
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(!"Registros".equals(tipo)){
            try {
                URL url = new URL("http://0.0.0.0:9876/webservice.sistemadivulga?wsdl");
                QName qname = new QName("http://webservice.sistemadivulga/", "PainelService");
                Service service = Service.create(url, qname);
                server s = service.getPort(server.class);
                s.CertidaoProximo2(guiche);
                ultimo = 0;
            } catch (MalformedURLException ex) {
                Logger.getLogger(GuicheFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                URL url = new URL("http://0.0.0.0:9876/webservice.sistemadivulga?wsdl");
                QName qname = new QName("http://webservice.sistemadivulga/", "PainelService");
                Service service = Service.create(url, qname);
                server s = service.getPort(server.class);
                s.RegistrosProximo2(guiche);
            } catch (MalformedURLException ex) {
                Logger.getLogger(GuicheFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(!"Registros".equals(tipo)){
            try {
                URL url = new URL("http://0.0.0.0:9876/webservice.sistemadivulga?wsdl");
                QName qname = new QName("http://webservice.sistemadivulga/", "PainelService");
                Service service = Service.create(url, qname);
                server s = service.getPort(server.class);
                if(ultimo == 0){
                    s.RepeteCertidoes();
                    ultimo = 0;
                }else{
                    s.RepetePreferencial();
                    ultimo = 1;
                }            
            } catch (MalformedURLException ex) {
                Logger.getLogger(GuicheFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                URL url = new URL("http://0.0.0.0:9876/webservice.sistemadivulga?wsdl");
                QName qname = new QName("http://webservice.sistemadivulga/", "PainelService");
                Service service = Service.create(url, qname);
                server s = service.getPort(server.class);
                s.RepeteRegistros();
            } catch (MalformedURLException ex) {
                Logger.getLogger(GuicheFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.dispose();
        new GuicheFrame(guiche, tipo).setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLatual;
    private javax.swing.JLabel jLfila1;
    private javax.swing.JLabel jLfila2;
    private javax.swing.JLabel jLfundo;
    private javax.swing.JLabel jLguiche;
    private javax.swing.JLabel jLtipo;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
