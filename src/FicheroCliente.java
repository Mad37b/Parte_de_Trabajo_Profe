

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class FicheroCliente {
	
	static public List <Cliente> lclientes=new ArrayList<>();
	
	public FicheroCliente() {
		    try (ObjectInputStream miFichero = new ObjectInputStream(new FileInputStream("Clientes.dat"))) {
			// Cuando no haya mas objetos saltara la excepcion EOFException
			
			while (true) {
				lclientes = (ArrayList<Cliente>) miFichero.readObject();
			}
		} catch (ClassNotFoundException e) {System.out.println("1");
		} catch (EOFException e) {System.out.println("2");
		} catch (IOException e) {System.out.println("3");
		}
	}	

	/** Metodo 1 : Crear fichero **/

	public static void crearFichero(List<Cliente> cliente) {
		
		
		// Escribir fichero por objeto

		try (ObjectOutputStream miFichero = new ObjectOutputStream(new FileOutputStream("Clientes.dat"))) {

			miFichero.writeObject(cliente);

		} catch (IOException write) {
			System.out.println("ERROR 01: No se da grabado la lista");
		}

	}
	
}