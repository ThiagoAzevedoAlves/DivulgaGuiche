/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package divulgaguiche;

import divulgaguiche.frames.LoginFrame;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import sistemadivulga.webservice.server;

/**
 *
 * @author Thiago
 */
public class DivulgaGuiche {

    URL url;
    QName qname;
    Service ws;
    
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }
    
}
