package Spedizioni;
import javax.swing.table.AbstractTableModel;

/**
 * classe che definisce il modello della tabella, estende la classe AbstractableModel da cui
 * eredita tutte le caratteristiche, e fa override di metodi
 */
public class Mod_Tab extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
	private String[] ColName= {"Nome", "Codice", "Destinazione", "Peso", "Data", "Stato", "Valore Assicurato"};

	/**
	 * lista di spedizioni con la quale vado a presentare la tabella
	 */
	private Lista_spedizioni l;

	

	/**
	 * metodo costruttore del modello della mia tabella
	 * @param l lista di spedizioni con la quale costruisco la tabella
	 */
	public Mod_Tab(Lista_spedizioni l) {
		this.l = l;
		
		
	}

	/**
	 * metodo che ritorna il numero di colonne della tabella
	 */
	public int getColumnCount() {
		return ColName.length;
	}

	/**
	 * metodo che ritorna il numero di righe della tabella
	 */
	public int getRowCount() {
		return l.getNumSpedizioni();
	}

	/*
	 * metodo che ritorna il contenuto della celle della tabella
	 */
	public Object getValueAt(int righe, int colonne) {

		/*SELEZIONA LA SPEDIZIONE*/
		Sped s = l.get(righe);

		
		switch (colonne) {
			case 0:
				return s.getNomeUtente();
			case 1:
				return s.getCodice();
			case 2:
				return s.getDestinazione();
			case 3:
				return s.getPeso();
			case 4:
				return s.getDataImmissione();
			case 5:
				return s.getStato();
		
			case 6:
				return s.getValoreAssicurato();
			default:
				return null;
		}
	}

	/**
	 * metodo che ritorna il nome della colonna
	 */
	 public String getColumnName(int colonne) {
		 return ColName[colonne];
	 }

	 /**
	  * metodo che stabilisce quali celle sono editabili
	  */
	public boolean isCellEditable(int righe, int colonne) {
		
		if (colonne == 5 )
			return true;
		
		return false;
	}

	/**
	 * metodo per settarare lo stato di una spedizione
	 * @param nuovo_Value stato della spedizione
	 * @param righe_index indice di riga della spedizione
	 * @param colonne_index indice di colonna della spedizione
	 */
	@Override
	public void setValueAt(Object nuovo_Value, int righe_index, int colonne_index) {
		String NuovoValore = (String) nuovo_Value;
		Sped s = l.get(righe_index);
		s.setStato(NuovoValore);
		fireTableDataChanged();
	}

	/**
	 * @return lista di spedizioni con cui è costrutita la tabella
	 */
	public Lista_spedizioni getLista(){ return l;}

}

