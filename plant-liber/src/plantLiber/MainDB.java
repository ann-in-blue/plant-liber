package plantLiber;

/**
 * Classe che contiene il main per inizializzare il database.
 * Richiama la classe ConnectionDB che crea una connessione con il db e poi esegue le varie queries di inserimento.
 * @author a-00
 *
 */
public class MainDB 
{
	
	public static void main(String[] args)
	{
		ConnectionDB connectionDB = new ConnectionDB();
		connectionDB.inizializzaDB();
	}

}

