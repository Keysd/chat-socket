/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextPane;

/**
 *
 * @author KCNTT
 */
public class serverThread extends Thread{
    private ServerSocket server;
    private Socket soc;
    private JTextPane txp;
    private User user;
    private String name;
    private DataInputStream dataIn;

    public serverThread(ServerSocket server,JTextPane txp) {
        this.server = server;
        this.txp = txp;
    }
    
    @Override
    public void run() {
        try {
            while (true) {                
                soc = server.accept();
                dataIn = new DataInputStream(soc.getInputStream());
                name = dataIn.readUTF();
                user = new User(soc, name);
                user.listUser.add(user);
                txp.setText(txp.getText()+"\nconnect successed: "+soc+"\n list client: "+User.listUser);
                readServer read = new readServer(soc, txp);
                read.start();
            }
        } catch (Exception e) {
             txp.setText(txp.getText()+"\n"+"error: serverThread");
             e.printStackTrace();
        }
        
        
    }
    
}
