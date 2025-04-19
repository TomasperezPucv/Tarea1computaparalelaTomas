package client;
//lol
import common.Persona;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import common.InterfazDeServer;

public class Client {
	private InterfazDeServer server;
	public Client() {
		
	};
	
	public void startClient() throws RemoteException, NotBoundException{
		Registry registriy = LocateRegistry.getRegistry("localhost",1009);
		server = (InterfazDeServer) registriy.lookup("server");
	}
	
	public void mostrarPersonas() throws RemoteException{
		ArrayList<Persona> personas = server.getPersona();
		for(Persona persona : personas) {
			System.out.println(persona.getNombre()+ "" + persona.getEdad());
		}
	}

}
