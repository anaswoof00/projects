package Spedizioni;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe che descrive una spedizione
 * @author Anas Raouf
 */
public class Sped {
	private String NomeUtente;

	/**
	 * codice della spedizione
	 */
	private String Codice;

	/**
	 * destinazione della spedizione
	 */
	private String Destinazione;

	/**
	 * peso della spedizione
	 */
	private int Peso;

	/**
	 * data in cui è stata creata la spedizione
	 */
	private String DataImmissione;

	/**
	 * stato in cui si trova la spedizione
	 */
	private String Stato;
	
	/**
	 *metodo costruttore per creare un oggetto di tipo spedizione dell' utente
	 * @param destinazione destinazione della spedizione
	 * @param peso peso della spedizione
	 */
	public Sped( String destinazione, int peso) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String data = sdf.format(new Date());
		setDataImmissione(data);
		setDestinazione(destinazione);
		setPeso(peso);
		setStato("IN PREPARAZIONE");
	}
	
	/**
	 * metodo costruttore per creare un oggetto di tipo spedizione leggendo i dati da file
	 * @param Nome nome dell' utente che ha effettuato la spedizione
	 * @param Codice codice della spedizione
	 * @param Destinazione destinazione della spedizione
	 * @param Peso peso della spedizione
	 * @param Data data di creazione della spedizione
	 * @param Stato stato della spedizione
	 */
	public Sped(String Nome, String Codice, String Destinazione, int Peso, String Data, String Stato) {
		setNomeUtente(Nome);
		setCodice(Codice);
		setDestinazione(Destinazione);
		setPeso(Peso);
		setDataImmissione(Data);
		setStato(Stato);
	}

	/**
	 * metodo che ritorna il codice della spedizione
	 * @return codice della spedizione
	 */
	public String getCodice() { return Codice; }

	/**
	 * metodo che setta il codice di una spedizione
	 * @param codice nuovo codice della spedizione
	 */
	public void setCodice(String codice) { Codice = codice; }

	/**
	 * metodo che ritorna la data di creazione della spedizione
	 * @return data di creazione della spedizione
	 */
	public String getDestinazione() { return Destinazione; }

	/**
	 * metodo che setta la destinazione della spedizione
	 * @param destinazione destinazione della spedizione
	 */
	public void setDestinazione(String destinazione) { Destinazione = destinazione; }

	/**
	 * metodo che ritorna il peso della spedizione
	 * @return peso della spedizione
	 */
	public int getPeso() { return Peso; }

	/**
	 * metodo che setta il peso della spedizione
	 * @param peso peso della spedizione
	 */
	public void setPeso(int peso) { Peso = peso; }

	/**
	 * metodo che ritorna lo stato della spedizione
	 * @return stato della spedizione
	 */
	public String getStato() { return Stato; }

	/**
	 * metodo che setta lo stato della spedizione
	 * @param stato stato della spedizione
	 */
	public void setStato(String stato) { Stato = stato; }

	/**
	 * metodo che ritorna la data di esecuzione della spedizione
	 * @return data di immissione della spedizione
	 */
	public String getDataImmissione() { return DataImmissione; }

	/**
	 * metodo che setta la data della spedizione effettuta
	 * @param dataImmissione data della spedizione effettuata
	 */
	public void setDataImmissione(String dataImmissione) { DataImmissione = dataImmissione; }


	/**
	 * metodo che ritorna il nome dell' utente che ha effettuato la spedizione
	 * @return nome dell' utente che ha effettuato la spedizione
	 */
	public String getNomeUtente() { return NomeUtente;}

	/**
	 * metodo che setta il nome dell' utente che ha effettuato la spedizione
	 * @param nomeUtente nome dell' utente che ha effettuato la spedizione
	 */
	public void setNomeUtente(String nomeUtente) { NomeUtente = nomeUtente; }


    public String toString(){
		return ("NORMALE\n"+getNomeUtente()+"\n"+getCodice()+"\n"+getDestinazione()+"\n"+getPeso()+"\n"+ 
				getDataImmissione()+"\n"+getStato()+"\n");
	}
	

	/**
	 * metodo che ritorna a 0 per il valore assicurato quando trattiamo spedizioni normali
	 * @return a 0 per il valore assicurato
	 */

	public int getValoreAssicurato(){
		return 0;
	}
}


