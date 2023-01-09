package Model;

public class Prenotazione {

	private int id_prenotazione;
	private String data_prenotazione;
	private int ora_prenotazione;
	private String email_nonRegistrato;
	private int codiceSoc;
	private int idcampo;
	
	public Prenotazione(int id_prenotazione, String data_prenotazione, int ora_prenotazione, String email_nonRegistrato,
			int codiceSoc, int idcampo) {
		super();
		this.id_prenotazione = id_prenotazione;
		this.data_prenotazione = data_prenotazione;
		this.ora_prenotazione = ora_prenotazione;
		this.email_nonRegistrato = email_nonRegistrato;
		this.codiceSoc = codiceSoc;
		this.idcampo = idcampo;
	}

	public Prenotazione(String data_prenotazione, int ora_prenotazione, String email_nonRegistrato, int codiceSoc,
			int idcampo) {
		super();
		this.data_prenotazione = data_prenotazione;
		this.ora_prenotazione = ora_prenotazione;
		this.email_nonRegistrato = email_nonRegistrato;
		this.codiceSoc = codiceSoc;
		this.idcampo = idcampo;
	}

	public int getId_prenotazione() {
		return id_prenotazione;
	}

	public void setId_prenotazione(int id_prenotazione) {
		this.id_prenotazione = id_prenotazione;
	}

	public String getData_prenotazione() {
		return data_prenotazione;
	}

	public void setData_prenotazione(String data_prenotazione) {
		this.data_prenotazione = data_prenotazione;
	}

	public int getOra_prenotazione() {
		return ora_prenotazione;
	}

	public void setOra_prenotazione(int ora_prenotazione) {
		this.ora_prenotazione = ora_prenotazione;
	}

	public String getEmail_nonRegistrato() {
		return email_nonRegistrato;
	}

	public void setEmail_nonRegistrato(String email_nonRegistrato) {
		this.email_nonRegistrato = email_nonRegistrato;
	}

	public int getCodiceSoc() {
		return codiceSoc;
	}

	public void setCodiceSoc(int codiceSoc) {
		this.codiceSoc = codiceSoc;
	}

	public int getIdcampo() {
		return idcampo;
	}

	public void setIdcampo(int idcampo) {
		this.idcampo = idcampo;
	}
	
	
	
}
