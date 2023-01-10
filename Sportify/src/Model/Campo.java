package Model;

public class Campo {
	
	private int idcampo;
	private int codiceSoc;
	private int prezzOrari;
	private String tipologia;
	private String nome;
	
	public Campo(int idcampo, int codiceSoc, int prezzOrari, String tipologia, String nome) {
		super();
		this.idcampo = idcampo;
		this.codiceSoc = codiceSoc;
		this.prezzOrari = prezzOrari;
		this.tipologia = tipologia;
		this.nome = nome;
	}
	
	public Campo(int codiceSoc, int prezzOrari, String tipologia, String nome) {
		super();
		this.codiceSoc = codiceSoc;
		this.prezzOrari = prezzOrari;
		this.tipologia = tipologia;
		this.nome = nome;
	}

	public int getIdcampo() {
		return idcampo;
	}

	public void setIdcampo(int idcampo) {
		this.idcampo = idcampo;
	}

	public int getCodiceSoc() {
		return codiceSoc;
	}

	public void setCodiceSoc(int codiceSoc) {
		this.codiceSoc = codiceSoc;
	}

	public int getPrezzOrari() {
		return prezzOrari;
	}

	public void setPrezzOrari(int prezzOrari) {
		this.prezzOrari = prezzOrari;
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

}
