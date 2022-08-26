/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextPane;

/**
 *
 * @author KCNTT
 */
public class readServer extends Thread{
    private Socket soc;
    private JTextPane txp;
    private  DataOutputStream dataOut;
    private DataInputStream dataIn;

    public readServer(Socket soc, JTextPane txp) {
        this.soc = soc;
        this.txp = txp;
    }

    @Override
    public void run() {
        try {
            dataIn = new DataInputStream(soc.getInputStream());
            String msg;
            while (true) {
                msg = dataIn.readUTF();
                for (User user : User.listUser) {
                    dataOut = new DataOutputStream(user.soc.getOutputStream());
                    dataOut.writeUTF(msg);
                }
               
               txp.setText(txp.getText()+"\n"+msg);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
    
}
