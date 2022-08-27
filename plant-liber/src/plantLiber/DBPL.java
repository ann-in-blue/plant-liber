package plantLiber;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBPL 
{
	
	static Connection conn = null;
	
	/**
	 * funzione che esegue una query sul database
	 * @param query
	 */
	public static void popolaBDPL (String query)
	{
		try {
			
			Statement stmt = conn.createStatement();
			stmt.execute(query);
//			if(stmt.executeQuery(query)) {
//				
//				System.out.println("done");
//				
//			}	
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
			System.err.println("SQLState: " + ex.getSQLState());
			System.err.println("VendorError: "+ ex.getErrorCode());
			
		} /*finally {
			try {
				conn.close();
			}catch(SQLException ex) {
				
			}
		}*/
	}
	
	/**
	 * funzione che crea un dato numero di piante generando 
	 * per ognuna la query di inserimento specifica
	 * @param numPiante
	 * @return l'ultima query generata sotto forma di stringa
	 */
	public static String generaPianteRandom(int inizio, int fine) {
		
		String res ="";
	
		for (int i = inizio; i < fine; i++) {
			res = "INSERT INTO Pianta(idCampione,nomeComune,nomeScientifico,specie,caratteristica,regione,area,ambiente,tipo)"
					+ "VALUES("+ i + "," + "'nomeC_"+ i +"','" + "nomeS_" + i + "','"+ "Specie_"+
					(int)(Math.random()*500)+"',"+(int)(Math.random()*300)+",'reg_"+(int)(Math.random()*130)+
					"','area_"+(int)(Math.random()*400)+"','habitat_"+(int)(Math.random()*70)+"','Vascolare')";
							
					System.out.println(res);
					popolaBDPL(res);
		}
		return res;
	}
	
	/**
	 * metodo per la creazione della query specifica per creare sul database delle tuple di tipo Pianta Officinale
	 * @param inizio
	 * @param fine
	 * @return query da eseguire
	 */
	public static String generaPiantaOfficinaleRandom(int inizio, int fine) {
		
		String res = "";
		
		
				for (int i = inizio; i < fine; i++) {
					res= "INSERT INTO PiantaOfficinale(idCampione,proprietàOfficinali) VALUES ("+ i  +",p_" + (int)(Math.random()*100)+")";
		
					System.out.println(res);
					popolaBDPL(res);
				} 
				return res;
	}
	
	
	/**
	 * Metodo che crea la query che permette di inserire tuple di tipo PiantaVascolare nel Database
	 * @param inizio
	 * @param fine
	 * @return
	 */
	public static String generaAngiospermeRandom(int inizio, int fine) {
		
		String res = "";
		
		for (int i = inizio; i < fine; i++) {
			res= "INSERT INTO Angiosperme(idCampione,fiore) VALUES ("+ i  +"," + (int)(Math.random()*150)+")";

			System.out.println(res);
			popolaBDPL(res);
		} 
		
		return res;
	}
	
	/**
	 * Metodo che permette di creare la query per l'inserimento nel database di un elemento generico
	 * @param inizio
	 * @param fine
	 * @param tab -> tabella in cui inserire la tupla
	 * @return query da eseguire
	 */
	public static String generaTuplaGenerica(int inizio, int fine, Tabella tab) {
		
		String res = "";
		for (int i =inizio;i < fine; i++) {
			
		 switch(tab)
					{
			
			case Pianta -> res = "INSERT INTO Pianta(idCampione,nomeComune,nomeScientifico,specie,caratteristica,regione,area,ambiente,tipo)"
					+ "VALUES("+ i + "," + "'nomeC_"+ i +"','" + "nomeS_" + i + "','"+ "Specie_"+
					(int)(Math.random()*500)+"','"+(int)(Math.random()*300)+"','regione_"+(int)(Math.random()*400)+"','area_"+(int)(Math.random()*400)+"','habitat_"+(int)(Math.random()*70)+"','Vascolare')";
							
			case Fiore -> res = "INSERT INTO Fiore(idFiore, struttura, colore, dimensione) "
					+ "VALUES ("+ i + ",'s_"+ (int)(Math.random()*60)+ "','c_"+ (int)(Math.random()*20) + "',"+(int)(Math.random()*200)+")";
			case Angiosperme -> res = "INSERT INTO Angiosperme(idCampione,fiore)"
					+ " VALUES ("+ i  +"," + (int)(Math.random()*150)+")";
			case PiantaOfficinale -> res = "INSERT INTO PiantaOfficinale(idCampione,proprietàOfficinali) "
					+ "VALUES ("+ i  +",'p_" + (int)(Math.random()*100)+"')";
	
			case Specie -> res = "INSERT INTO Specie(nome) VALUES ('specie_"+i+"')";
			
			case Caratteristiche -> res = "INSERT INTO Caratteristiche(tipo,durata,altezza,forma,tossicità) "
					+ "VALUES (" + i + ",'d_"+ (int)(Math.random()*9)+ "',"+ (int)(Math.random()*350)+ ",'f_"+(int)(Math.random()*30)+
					"','t_"+(int)(Math.random()*2)+"')";
			
			case Classificazione -> res = "INSERT INTO Classificazione(nomeSpecie,regno,divisione,classe,ordine,famiglia,genere)"
					+ "	 VALUES('specie_"+ i+"','regno_"+(int)(Math.random()*3)+"','divisione_"+(int)(Math.random()*35)+"','classe_"+ 
					(int)(Math.random()*20)+"','ordine_"+(int)(Math.random()*10)+"','famiglia_"+(int)(Math.random()*25)+"','genere_"+(int)(Math.random()*17)+"')";
			
			case Habitat -> res = "INSERT INTO Habitat(tipoH,fasciaClimatica,latitudine,altitudine,topologia, nome) VALUES("+i+",'clima_"+(int)(Math.random()*17)+"','lat_"
					+ (int)(Math.random()*999999)+"',"+(int)(Math.random()*5000)+",'topol_"+(int)(Math.random()*25)+"','habitat_"+(int)(Math.random()*70)+"')";
			
			case Area -> res = "INSERT INTO Area(nome,regione,clima) VALUES('area_"+ i +"','reg_"+ (int)(Math.random()*130)+ "',"+(int)(Math.random()*70)+")";
			
			case Raccoglitore -> res = "INSERT INTO Raccoglitore(CF,nome,cognome,istituto) "
					+ "VALUES('CF_"+ i + "','nome_" + i+ "','cogn_"+i+"',"+(int)(Math.random()*270)+")";
			
			case IstitutoDiRicerca -> res = "INSERT INTO IstitutoDiRicerca(cod,via,numeroCivico,CAP,denominazione) "
					+ "VALUES("+i+",'via_"+(int)(Math.random()*370)+"',"+(int)(Math.random()*1000)+","+(int)(Math.random()*99999)+""
							+ ",'denom_"+ i+"')";
			
			case ParteEdibile -> res = "INSERT INTO ParteEdibile(parte) VALUES('parte_"+ i+ "')";
			case Collezione -> res = "INSERT INTO Collezione(idCollezione,nomeCollezione,dataRaccolta,luogoRaccolta,raccoglitore) VALUES("+i+""
					+ ",'nomeColl_"+i+"',"+ "'1999/01/03'"+",'area_"+ (int)(Math.random()*400) +"','CF_"+(int)(Math.random()*900)+"')" ;
			
			case ProprietàOfficinali -> res = "INSERT INTO ProprietàOfficinali(tipoP,utilizzo,controindicazione,parteEdibile)"
					+ " VALUES('tipo_"+i+"','ut_"+(int)(Math.random()*40)+"','c_"+(int)(Math.random()*4)+
					"','parte_"+(int)(Math.random()*37)+"')";
			
			default -> res = "";
					};
					
			System.out.println(res);
					popolaBDPL(res);
		}
		return res;
	}
	//FIORE 150, PROP 100 HABITAT 70 AREA 400 SPECIE 500 CARATT 300 REGIONE 130 CLASS 90 RACCOGL 900 PEDIB 37
	
}
