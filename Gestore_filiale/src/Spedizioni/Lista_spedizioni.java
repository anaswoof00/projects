package Spedizioni;
import java.io.*;
import java.util.*;




	public class Lista_spedizioni implements Serializable{
		
		
		private static final long serialVersionUID = 1L;
		
		

		/**
		 * lista di spedizioni parametrizzata su Spedizione
		 */
		private List <Sped> Spedizioni;

		/**
		 * metodo costruttore che crea e ritorna un ArrayList di spedizioni vuoto
		 */
		public Lista_spedizioni() {
			Spedizioni = new ArrayList<Sped>();
		}
		
		

		/**
		 * medoto che ritorna la spedizione presente all' indice passato come parametro
		 * @param index indice della spedizione da ritornare
		 * @return la spedizione memorizzata all' indice index
		 */
		public Sped get(int index) {
			return Spedizioni.get(index);
		}

		/**
		 * metodo che ritorna il numero di spedizioni nell' ArrayList Spedizioni
		 * @return numero di spedizioni  nell' ArrayList Spedizioni
		 */
		public int getNumSpedizioni() {
			return Spedizioni.size();
		}

		
		/**
		 * metodo che cancella una spedizione dall' ArrayList Spedizioni
		 * @param s spedizione da cancellare
		 */
		public void  Remove (Sped s){ 
			Spedizioni.remove(s); 
			}
	   
		
		/**
		 * metodo che aggiunge la nuova spedizione all' ArrayList Spedizioni
		 * @param s spedizione da aggiungere
		 */
		public void Aggiungi(Sped s) {
		
		Spedizioni.add(s);
	}
	
}
	



