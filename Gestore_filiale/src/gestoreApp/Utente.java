 package gestoreApp;
import Spedizioni.*;

/**
 * classe che implementa i dati dell'utente e le sue spedizioni
 * @author Anas Raouf
 *
 */
public class Utente {

	/**
	 * username dell'user
	 */
	private String Username;

	/**
	 * Password dell'user
	 */
	private String Password;

	/**
	 * indirizzo dell'user
	 */
	private String Indirizzo;

	/**
	 * lista di spedizioni dell' utente
	 */
	private Lista_spedizioni Sped;

	/**
	 * numero di spedizioni effettuate
	 */
	private int num_spedizioni;

	/**
	 * metodo costruttore di un utente
	 * @param Username username dell' user
	 * @param Password password dell' user
	 * @param Indirizzo indirizzo dell' user
	 */
	public Utente(String User, String Psw, String Ind) {
		this.Username = User;
		this.Password = Psw;
		this.Indirizzo = Ind;
		this.Sped = new Lista_spedizioni();
		this.num_spedizioni = 0;
	}

	/**
	 * genero un costruttore che crea un utente senza dati
	 */
	public Utente() {
		this("", "", "");
	}

	/**
	 * metodo che ritorna l' username dell' utente
	 * @return username dell' utente
	 */
	public String getUsername() {
		return Username;
	}

	/**
	 * metodo che ritorna la password dell'User
	 * @return password dell' utente
	 */
	public String getPassword() {
		return Password;
	}

	/**
	 * metodo che ritorna l' indirizzo dell'User
	 * @return indirizzo dell'User
	 */
	public String getIndirizzo() {
		return Indirizzo;
	}
	
	/**
	 * metodo che effettua una spedizione normale alla lista spedizioi dell' utente
	 * @param Destinazione destinazione della spedizione
	 * @param Peso peso della spedizione
	 */	
	public void Genera_Sped_normale(String Destinazione, int Peso) {
		Sped s = new Sped(Destinazione, Peso);
		String codice = getUsername() + num_spedizioni + s.getDestinazione().charAt(0) + s.getPeso();
		codice = codice.toUpperCase();
		s.setCodice(codice);
		s.setNomeUtente(this.Username);
		num_spedizioni += 1;
	    Sped.Aggiungi(s);
		}
	 
	/**	
	 * metodo che effettua una spedizione assicurata alla lista di spedizioni dell' utente
	 * @param Destinazione destinazione della spedizione
	 * @param Peso peso della spedizione
	 * @param val valore assicurato della spedizione
	 */
	public void Genera_Sped_sicura(String Destinazione, int Peso, int val) {
		Sped_sicura s = new Sped_sicura(Destinazione, Peso, val);

		String code = getUsername() + num_spedizioni + s.getDestinazione().charAt(0) + s.getPeso();
		code = code.toUpperCase();
		s.setCodice(code);
		s.setNomeUtente(this.Username);
		num_spedizioni += 1;
	    Sped.Aggiungi(s);
		}

  
	/**
	 * metodo che ritorna il numero delle spedizioni dell'User
	 * @return numero di spedizioni dell'User
	 */
	public int getNumSpedizioni() {
		return num_spedizioni;
	}
	/**
	 * metodo che ritorma la lista di spedizioni
	 * @return lista di spedizioni
	 */
	public Lista_spedizioni getSpedizioni() {
		return Sped;
	}

	/**
	 * metodo che setta la lista di spedizioni dell' utente
	 * @param s nuova lista di spedizioni dell' utente
	 */
	public void setSpedizioni(Lista_spedizioni s){ this.Sped = s; }



	/**
	 * metodo che riduce di uno il numero di spedizioni effettuate
	 */
	public void riduci_spedizione(){
		if (num_spedizioni > 0)
			num_spedizioni -= 1;

	}


	/**
	 * metodo che aggiunge la spedizione effettuata dell' utente,
	 * la uso quando carico le spedizioni leggendo da file
	 * @param s spedizione da aggiungere alla lista delle spedizioni
	 */
	  public void AggiungiSpedizione(Sped s) {
		Sped.Aggiungi(s);
		num_spedizioni +=1;
		
	
		
	 }
	
}
	
