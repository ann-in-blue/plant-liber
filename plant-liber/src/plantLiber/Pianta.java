package plantLiber;

public class Pianta {

	private String idCampione;
	private String nomeComune;
	private String nomeScientifico;
	
	public Pianta(String idCampione, String nomeComune, String nomeScientifico) {
		this.idCampione = idCampione;
		this.nomeComune = nomeComune;
		this.nomeScientifico = nomeScientifico;
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
