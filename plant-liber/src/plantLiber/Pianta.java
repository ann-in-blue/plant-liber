package plantLiber;

public class Pianta {

	private String idCampione;
	private String nomeComune;
	private String nomeScientifico;
	private String specie;
	private String famiglia;
	
	private String regno;
	private String divisione;
	private String fasciaClimatica;
	

	public Pianta(String nomeScientifico, String specie, String famiglia, String regno, String divisione,
			String fasciaClimatica) {
		super();
		this.nomeScientifico = nomeScientifico;
		this.specie = specie;
		this.famiglia = famiglia;
		this.regno = regno;
		this.divisione = divisione;
		this.fasciaClimatica = fasciaClimatica;
	}
	public String getRegno() {
		return regno;
	}
	public void setRegno(String regno) {
		this.regno = regno;
	}
	public String getDivisione() {
		return divisione;
	}
	public void setDivisione(String divisione) {
		this.divisione = divisione;
	}
	public String getFasciaClimatica() {
		return fasciaClimatica;
	}
	public void setFasciaClimatica(String fasciaClimatica) {
		this.fasciaClimatica = fasciaClimatica;
	}
	public Pianta(String idCampione, String nomeScientifico, String specie, String famiglia) {
		this.idCampione = idCampione;
		this.nomeScientifico = nomeScientifico;
		this.specie = specie;
		this.famiglia =  famiglia;
	}
	public String getFamiglia() {
		return famiglia;
	}
	public void setFamiglia(String famiglia) {
		this.famiglia = famiglia;
	}
	public String getSpecie() {
		return specie;
	}
	public void setSpecie(String specie) {
		this.specie = specie;
	}
	public String getIdCampione() {
		return idCampione;
	}
	public void setIdCampione(String idCampione) {
		this.idCampione = idCampione;
	}
	public String getNomeComune() {
		return nomeComune;
	}
	public void setNomeComune(String nomeComune) {
		this.nomeComune = nomeComune;
	}
	public String getNomeScientifico() {
		return nomeScientifico;
	}
	public void setNomeScientifico(String nomeScientifico) {
		this.nomeScientifico = nomeScientifico;
	}
	
	
}
