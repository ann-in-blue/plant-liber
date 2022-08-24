package plantLiber;

public class TooManyAttrException extends Exception
{

	public TooManyAttrException(int attributiDichiarati, int attributiRichiesti) {
		

		System.out.println("troppi attributi dichiarati: " 
									+ attributiDichiarati + " attributi inseriti invece di " 
									+ attributiRichiesti + " attributi richiesti");
	}
	

}
