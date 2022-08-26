/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

/**
 *
 * @author KCNTT
 */
public class readClient extends Thread{
    private Socket soc;
    private JTextPane txp;
    private  DataInputStream dataIn;
    private DataOutputStream dataOut;
    private String msg ;
    private String name;

    public readClient(Socket soc, JTextPane txp,String name) {
        this.txp = txp;
        this.soc = soc;
        this.name = name;
    }
    
    @Override
    public void run() {
        try {
            dataIn = new DataInputStream(soc.getInputStream());
            dataOut = new DataOutputStream(soc.getOutputStream());
            dataOut.writeUTF(name);
            while (true) {            
                msg = dataIn.readUTF();
                txp.setText(txp.getText()+"\n"+msg);
            }
        } catch (IOException ex) {
            txp.setText("error readClient .");
            ex.printStackTrace();
        }
        
    }
    
}

