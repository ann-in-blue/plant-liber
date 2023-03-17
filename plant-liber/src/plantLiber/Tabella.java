package plantLiber;


public enum Tabella {
	
	Pianta(9, "idCampione", "nomeComune", "nomeScientifico",
			"specie", "caratteristica", "regione", "area", "ambiente","tipo"),
	
	PiantaOfficinale (2,"idCampione", "proprietàOfficinali"),
	Angiosperme (2,"idCampione", "fiore"),
	Specie (2, "nome", "classificazioneF"),
	Caratteristiche (5, "tipo", "durata", "altezza", "forma", "tossicità"),
	Classificazione (7, "nomeSpecie", "regno", "divisione",
						"classe", "ordine", "famiglia", "genere"),
	Habitat (5, "tipoH", "fasciaClimatica", "latitudine", "altitudine", "topologia"),
	Area (3, "nome", "regione", "clima"),
	Collezione (6, "idCollezione", "nomeCollezione", "dataRaccolta", 
						"luogoRaccolta", "regioneR", "raccoglitore"),
	Raccoglitore (4, "CF", "nome", "cognome", "istituto"),
	IstitutoDiRicerca (5, "cod", "via", "numCivico", "CAP", "denominazione"),
	ProprietaOfficinali (4, "tipoP", "utilizzo", "controindicazione", "parteEdibile"),
	ParteEdibile (1, "parte"),
	Fiore(4, "idFiore", "struttura", "colore", "dimensione");
	
	public final int NUMERO_ATTRIBUTI;
	
	public String ATTRIBUTI[];
	
	
	private  Tabella(int num_attributi, String... attributi) {
		this.NUMERO_ATTRIBUTI = num_attributi;
		
		this.ATTRIBUTI= new String[NUMERO_ATTRIBUTI];
		ATTRIBUTI = attributi;
		//List attr = new ArrayList<String>(attributi); 
		
	}
	
	@Override
	public String toString(){
		String s ="";
		for(int i = 0; i<ATTRIBUTI.length; i++) {
			s += ATTRIBUTI[i] + (i==ATTRIBUTI.length -1 ? "" : ",");
		}
		return s;
	}
}
