package Model;



public class ASD {	
    private int idsocieta;
    private String citta;
    private String nome;
    private String indirizzo;
    private String provincia;
    private String regione;
    private String email;
    private String password;
    private String telefono;
    private String geolocalizzazione;

    public ASD(int idsocieta, String citta, String nome, String indirizzo, String provincia, String regione, String email, String password, String telefono, String geolocalizzazione) {
        this.idsocieta = idsocieta;
        this.citta = citta;
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.provincia = provincia;
        this.regione = regione;
        this.email = email;
        this.password = password;
        this.telefono = telefono;
        this.geolocalizzazione = geolocalizzazione;
    }
    
    public ASD(int idsocieta, String citta, String nome, String indirizzo, String provincia, String regione, String email, String password, String telefono) {
        this.idsocieta = idsocieta;
        this.citta = citta;
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.provincia = provincia;
        this.regione = regione;
        this.email = email;
        this.password = password;
        this.telefono = telefono;
        this.geolocalizzazione = "";
    }

    public ASD(String citta, String nome, String indirizzo, String provincia, String regione, String email, String password, String telefono, String geolocalizzazione) {
        this.idsocieta = 0;
        this.citta = citta;
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.provincia = provincia;
        this.regione = regione;
        this.email = email;
        this.password = password;
        this.telefono = telefono;
        this.geolocalizzazione = geolocalizzazione;
    }

    public ASD(String citta, String nome, String indirizzo, String provincia, String regione, String email, String password, String telefono) {
        this.idsocieta = 0;
        this.citta = citta;
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.provincia = provincia;
        this.regione = regione;
        this.email = email;
        this.password = password;
        this.telefono = telefono;
        this.geolocalizzazione = "";
    }
    
    public ASD(String citta, String nome, String indirizzo, String provincia, String regione, String email, String telefono) {
        this.idsocieta = 0;
        this.citta = citta;
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.provincia = provincia;
        this.regione = regione;
        this.email = email;
        this.telefono = telefono;
        this.geolocalizzazione = "";
    }
    
    public String getGeolocalizzazione() {
		return geolocalizzazione;
	}

	public void setGeolocalizzazione(String geolocalizzazione) {
		this.geolocalizzazione = geolocalizzazione;
	}

	public int getIdsocieta() {
        return idsocieta;
    }

    public void setIdsocieta(int idsocieta) {
        this.idsocieta = idsocieta;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getRegione() {
        return regione;
    }

    public void setRegione(String regione) {
        this.regione = regione;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

	@Override
	public String toString() {
		return "ASD [idsocieta=" + idsocieta + ", citta=" + citta + ", nome=" + nome + ", indirizzo=" + indirizzo
				+ ", provincia=" + provincia + ", regione=" + regione + ", email=" + email + ", password=" + password
				+ ", telefono=" + telefono + ", geolocalizzazione=" + geolocalizzazione + "]";
	}
    
    
}