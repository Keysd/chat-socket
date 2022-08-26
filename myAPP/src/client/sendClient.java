/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.awt.TextField;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KCNTT
 */
public class sendClient extends Thread{
    private Socket soc;
    private String msg;
    private DataOutputStream dataOut;
    private String name;

    public sendClient(Socket soc,String msg,String name) {
        this.soc = soc;
        this.msg=msg;
        this.name= name;
    }
    

    @Override
    public void run() {
        try {
            dataOut = new DataOutputStream(soc.getOutputStream());
            dataOut.writeUTF(name+" :"+msg);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
}
