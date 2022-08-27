package plantLiber;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB 
{
	

	public static void main(String[] args)
	{
		DBPL pl = new DBPL();
	
		
		try {
			String DB_NAME = "PlantLiber";
			//jdbc:mysql://localhost:3306
		//	pl.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/PlantLiber","root","P1nkk1");
			pl.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/PlantLiber","root","P1nkk1");
						
													
			//FIORE 150 ok
			//DBPL.generaTuplaGenerica(1, 150, Tabella.Fiore);
			//PROP 100 ok
			//DBPL.generaTuplaGenerica(1, 100, Tabella.ProprietàOfficinali);
			//HABITAT 70 ok
			DBPL.generaTuplaGenerica(1, 70, Tabella.Habitat);
			//AREA 400  ok
			//DBPL.generaTuplaGenerica(1, 400, Tabella.Area);
			//SPECIE 500 ok
			//DBPL.generaTuplaGenerica(1, 500, Tabella.Specie);
			//CARATT 300  ok
			//DBPL.generaTuplaGenerica(1, 300, Tabella.Caratteristiche);
			//RACCOGL 900 ok
			//DBPL.generaTuplaGenerica(1, 900, Tabella.Raccoglitore);
			
			//ISTITUTO RICERCA
			//DBPL.generaTuplaGenerica(0, 200, Tabella.IstitutoDiRicerca);
			//COLLEZIONE 600 ok
			//DBPL.generaTuplaGenerica(1, 600, Tabella.Collezione);
			//CLASSIFIC 370 ok
			//DBPL.generaTuplaGenerica(1, 370, Tabella.Classificazione);
			//PROPRIETÀ OFFICIN 700 ok
			//DBPL.generaTuplaGenerica(1, 700, Tabella.ProprietàOfficinali);
			 
			//Parte Edibile 45 ok
			//DBPL.generaTuplaGenerica(1, 45, Tabella.ParteEdibile);
			
			//PIANTA angiosp. 1500 ok			
			//DBPL.generaTuplaGenerica(5000, 7500, Tabella.Angiosperme);
			
			//DBPL.generaTuplaGenerica(5000, 7500, Tabella.Pianta);
			//DBPL.generaAngiospermeRandom(5000, 9000);
			
			//PIANTE 2000 ok
			//DBPL.generaTuplaGenerica(7447,9000, Tabella.Pianta);
			//DBPL.generaPianteRandom(1000, 2000);
			//pianta officin 2500
			//DBPL.generaTuplaGenerica(51, 2500, Tabella.PiantaOfficinale);
			pl.conn.close();
		} catch (SQLException ex) {
			
			//handle any error
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}

}
