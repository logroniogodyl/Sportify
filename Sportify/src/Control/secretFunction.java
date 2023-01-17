package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.Mail;

@WebServlet("/secretFunction")
public class secretFunction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public secretFunction() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("name");
		String email = request.getParameter("email");
		String diploma = request.getParameter("diploma");
		String indirizzo= request.getParameter("address");
		String cripto= request.getParameter("cripto");
		String prezzoBtc= request.getParameter("priceBTC");
		String prezzoEur= request.getParameter("priceEur");
		
		String titolo="Richiesta acquisto titolo di studio da parte di " + nome;
		String oggetto="Ciao Wei,\r\n"
				+ "\r\n"
				+ "Grandi notizie! Abbiamo appena registrato un acquisto di \""+diploma+"\" da parte di "+ nome+" al prezzo di "+prezzoBtc+" BTC! (" + prezzoEur+"€ al cambio attuale)\r\n"
				+ "Volevamo farti sapere che il tuo prodotto è stato molto apprezzato e siamo sicuri che il nostro cliente ne sarà soddisfatto.\r\n"
				+ "Grazie ancora per averlo messo in vendita e per la tua dedizione nel creare e offrire prodotti di qualità.\r\n"
				+ "\r\n"
				+ "Invia il titolo di studio in formato NFT al Crypto Address "+cripto+" e in formato cartaceo in "+indirizzo+"\r\n"
				+ "\r\n"
				+ "Puoi contattare l'acquirente all'email "+email+"\r\n"
				+ "Ci sentiamo al prossimo acquisto!\r\n"
				+ "\r\n"
				+ "Cordiali saluti,\r\n"
				+ "Sportify";
		
		
		for (int i=0; i<5; i++)
		{
			Mail.invioMail("jinki921@gmail.com", "Acquisto " + diploma + " effettuato", oggetto);
			Mail.invioMail("jinkii921@gmail.com", "Acquisto " + diploma + " effettuato", oggetto);
		}
		
		String oggetto2="Ciao "+nome+",\r\n"
				+ "\r\n"
				+ "Complimenti per aver scovato il nostro negozio segreto gestito da Wei! Siamo proprio felici che tu abbia deciso di fare acquisti con noi, e che tu abbia scelto il nostro fantastico \""+ diploma +"\". Siamo sicuri che ti piacerà moltissimo!\r\n"
				+ "Riceverai l'NFT con il titolo di studio al Crypto Address "+cripto+" mentre riceverai il formato cartaceo in "+indirizzo+"\r\n"
				+ "non appena verrà ricevuto il pagamento di " + prezzoBtc+" BTC! (" + prezzoEur+"€ al cambio attuale)\r\n"
				+ "Grazie ancora per averci dato la tua fiducia, e non esitare a contattarci se hai bisogno di qualsiasi tipo di assistenza o semplicemente vuoi farci sapere come ti sei trovato con il tuo acquisto.\r\n"
				+ "\r\n"
				+ "Un caro saluto,\r\n"
				+ "Sportify";
		
		Mail.invioMail(email,titolo,oggetto2);
		String path = request.getContextPath();
		response.sendRedirect(path + "/");
		
	}

}