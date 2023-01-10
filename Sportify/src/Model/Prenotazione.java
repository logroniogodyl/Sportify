package Model;

public class Prenotazione {

	private int id_prenotazione;
	private String data_prenotazione;
	private int ora_prenotazione;
	private String email_nonRegistrato;
	private int codiceSoc;
	private int idcampo;
	private String numeroTelefono;
	private String tipologia;
	private String nome;
	
	public Prenotazione(int id_prenotazione, String data_prenotazione, int ora_prenotazione, String email_nonRegistrato,
			int codiceSoc, int idcampo, String numeroTelefono, String tipologia,String nome) {
		super();
		this.id_prenotazione = id_prenotazione;
		this.data_prenotazione = data_prenotazione;
		this.ora_prenotazione = ora_prenotazione;
		this.email_nonRegistrato = email_nonRegistrato;
		this.codiceSoc = codiceSoc;
		this.idcampo = idcampo;
		this.numeroTelefono=numeroTelefono;
		this.tipologia=tipologia;
		this.nome=nome;
	}

	public Prenotazione(String data_prenotazione, int ora_prenotazione, String email_nonRegistrato, int codiceSoc,
			int idcampo,String numeroTelefono, String tipologia,String nome) {
		super();
		this.id_prenotazione=0;
		this.data_prenotazione = data_prenotazione;
		this.ora_prenotazione = ora_prenotazione;
		this.email_nonRegistrato = email_nonRegistrato;
		this.codiceSoc = codiceSoc;
		this.idcampo = idcampo;
		this.numeroTelefono=numeroTelefono;
		this.tipologia=tipologia;
		this.nome=nome;
	}

	public Prenotazione(String data, int orario, String email,int idCampo,  String tel,String nome ) {
		super();
		this.id_prenotazione=0;
		this.data_prenotazione = data;
		this.ora_prenotazione = orario;
		this.email_nonRegistrato = email;
		this.idcampo = idCampo;
		this.numeroTelefono=tel;
		this.nome=nome;
		this.tipologia="";
		this.codiceSoc =0;
	}
	


	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
