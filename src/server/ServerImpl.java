package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import common.InterfazDeServer;
import common.Persona;

public class ServerImpl implements InterfazDeServer {
	private ArrayList<Persona> BD_personas = new ArrayList<>();
	
	public ServerImpl() throws RemoteException{
		UnicastRemoteObject.exportObject((Remote) this, 0);
		crearBD();
	}
	
	private void crearBD() {
		Persona persona1 = new Persona("matias",27);
		Persona persona2 = new Persona("Maria eugenia",31);
		BD_personas.add(persona1);
		BD_personas.add(persona2);
	}

	@Override
	public ArrayList<common.Persona> getPersona() throws RemoteException {
		// TODO Auto-generated method stub
		return BD_personas;
	}

	@Override
	public common.Persona Persona(String nombre, int edad) throws RemoteException {
		// TODO Auto-generated method stub
		Persona persona = new Persona(nombre, edad);
		return persona;
	}
}
