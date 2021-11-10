package Spedizioni;


	public class Sped_sicura extends Sped {

		/**
		 * valore assicurato della spedizione
		 */
		private int Val_Assicurato;
		
		/**
		 * metodo costruttore usato per creare un oggetto di tipo spedizione assicurata
		 * @param destinazione destinazione della spedizione
		 * @param peso peso della spedizione
		 * @param Val valore assicurato della spedizione
		 */
		public Sped_sicura(String destinazione, int peso, int Val) {
			super(destinazione, peso);
			setValoreAssicurato(Val);
		}
        
		
		
		
		/**
		 * metodo costruttore che uso quando creo un oggetto di tipo spedizione assicurata leggendo
		 * i dati da file
		 * @param Nome nome dell' utente che ha effettuato la spedizione
		 * @param Codice codice della spedizione assicurata
		 * @param Destinazione destinazione della spedizione assicurata
		 * @param Peso peso della spedizione assicurata
		 * @param Data data di creazione della spedizione assicurata
		 * @param Stato stato della spedizione assicurata
		 * @param val valore assicurato della spedizione
		 */
		public Sped_sicura (String Nome, String Codice, String Destinazione, int Peso, String Data, String Stato, int val) {
			super (Nome, Codice, Destinazione, Peso, Data, Stato);
			Val_Assicurato = val;
			
		}

		/**
		 * metodo che ritorna il valore assicurato della spedizione
		 * @return valore assicurato della spedizione
		 */
		@Override
		public int getValoreAssicurato() { return Val_Assicurato;}

		/**
		 * medodo che setta il valore assicurato della spedizione
		 * @param val valore assicurato della spedizione
		 */
		public void setValoreAssicurato(int val){
			Val_Assicurato = val;
		}

		@Override
		public String toString(){
			return ("SICURA"+"\n"+getValoreAssicurato()+"\n"+ getNomeUtente()+"\n"+getCodice()+"\n"+getDestinazione()+"\n"+
					getPeso()+"\n"+getDataImmissione()+"\n"+getStato()+"\n");
		}
}


