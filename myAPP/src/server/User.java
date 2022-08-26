package server;

import java.net.Socket;
import java.util.Vector;

public class User {
	public static Vector<User> listUser  = new Vector<User>();
	
	public Socket soc;
	public String name;
	
	public User(Socket soc,String name) {
		this.soc = soc;
		this.name = name;
	}
	
}
