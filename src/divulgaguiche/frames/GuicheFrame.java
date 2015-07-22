/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package divulgaguiche.frames;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import sistemadivulga.webservice.server;

/**
 *
 * @author Thiago
 */
public class GuicheFrame extends javax.swing.JFrame {

    int guiche;
    String tipo;
    int ultimo = 0;
    public static Timer timer = new Timer(3000, null);
    
    public GuicheFrame(int guiche, String tipo) {
        this.guiche = guiche;
        this.tipo = tipo;
        initComponents();
        this.setSize(1280, 768);
        this.jPanel1.setOpaque(false);
        this.jPanel2.setOpaque(false);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLtipo = new javax.swing.JLabel();
        jLguiche = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLatual = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLfila2 = new javax.swing.JLabel();
        jLfila1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLfundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.lightGray, null, null));

        jLabel2.setFont(new java.awt.Font("Square721 BT", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Guichê:");

        jLtipo.setFont(new java.awt.Font("Square721 BT", 1, 48)); // NOI18N
        jLtipo.setForeground(new java.awt.Color(255, 255, 255));
        jLtipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLtipo.setText("Certidões");

        jLguiche.setFont(new java.awt.Font("Square721 BT", 1, 180)); // NOI18N
        jLguiche.setForeground(new java.awt.Color(255, 255, 255));
        jLguiche.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLguiche.setText("#1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLguiche, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
            .addComponent(jLtipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLtipo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLguiche, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 470, 340);

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.lightGray, null, null));

        jLabel3.setFont(new java.awt.Font("Square721 BT", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Senha Atual:");

        jLatual.setFont(new java.awt.Font("Square721 BT", 1, 180)); // NOI18N
        jLatual.setForeground(new java.awt.Color(102, 0, 153));
        jLatual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLatual.setText("100");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
            .addComponent(jLatual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jLatual, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(510, 10, 400, 340);

        jButton3.setFont(new java.awt.Font("Square721 BT", 1, 48)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 0, 0));
        jButton3.setText("<html><center>Automático</html>");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(950, 30, 320, 130);

        jButton1.setFont(new java.awt.Font("Square721 BT", 1, 48)); // NOI18N
        jButton1.setText("<html><center>Sair</html>");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(950, 590, 320, 130);

        jButton2.setFont(new java.awt.Font("Square721 BT", 1, 48)); // NOI18N
        jButton2.setForeground(new java.awt.Color(102, 0, 255));
        jButton2.setText("<html><center>Chamar<br> Proximo </html>");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(950, 310, 320, 130);

        jButton4.setFont(new java.awt.Font("Square721 BT", 1, 48)); // NOI18N
        jButton4.setForeground(new java.awt.Color(102, 150, 255));
        jButton4.setText("<html><center>Repetir<br> Chamado </html>");
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(950, 450, 320, 130);

        jButton5.setFont(new java.awt.Font("Square721 BT", 1, 48)); // NOI18N
        jButton5.setForeground(new java.awt.Color(102, 0, 153));
        jButton5.setText("<html><center>Chamar<br> Preferencial</html>");
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(950, 170, 320, 130);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(930, 0, 40, 770);

        jLabel6.setFont(new java.awt.Font("Square721 BT", 1, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Fila:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 410, 850, 59);

        jLabel10.setFont(new java.awt.Font("Square721 BT", 1, 48)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Normal:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(220, 500, 330, 59);

        jLabel8.setFont(new java.awt.Font("Square721 BT", 1, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Preferencial:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(150, 560, 350, 59);

        jLfila2.setFont(new java.awt.Font("Square721 BT", 1, 48)); // NOI18N
        jLfila2.setForeground(new java.awt.Color(255, 0, 0));
        jLfila2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLfila2.setText("0");
        getContentPane().add(jLfila2);
        jLfila2.setBounds(310, 570, 460, 40);

        jLfila1.setFont(new java.awt.Font("Square721 BT", 1, 48)); // NOI18N
        jLfila1.setForeground(new java.awt.Color(255, 0, 0));
        jLfila1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLfila1.setText("0");
        getContentPane().add(jLfila1);
        jLfila1.setBounds(310, 510, 460, 40);

        jLabel1.setFont(new java.awt.Font("Square721 BT", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 153));
        jLabel1.setText("mini!");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1);
        jLabel1.setBounds(1240, 0, 33, 18);
        getContentPane().add(jLfundo);
        jLfundo.setBounds(0, 0, 1280, 770);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
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
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
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
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
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
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
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
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.dispose();
        new MiniFrame(guiche, tipo).setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLatual;
    private javax.swing.JLabel jLfila1;
    private javax.swing.JLabel jLfila2;
    private javax.swing.JLabel jLfundo;
    private javax.swing.JLabel jLguiche;
    private javax.swing.JLabel jLtipo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
