package gestoreApp ;
import java.io.*;
import java.util.*;
import Spedizioni.*;


/**
 * classe che implementa un arrayList di utenti
 * @author Anas Raouf
 *
 */
public class Lista_Utenti{
	
	/**
	 * nome del file in cui salvo e carico la lista di utenti e di spedizioni
	 */
	private static final String file_gestione="Lista_Utenti.txt";

	/**
	 *ArrayList per lista di utenti
	 */
	private ArrayList <Utente> Users;
	
	
	/**
	 * metodo costruttore che crea un nuovo arrayList di utenti 
	 */
	public Lista_Utenti() {
		Users = new ArrayList<Utente>();
	}
	
	
	/**
	 * metodo che restituisce il numero di utenti registrati
	 * @return Users numero utenti registrati
	 */
	public int getNumUtenti() {
		return Users.size();
	}
	
	/**
	 * metodo che restituisce l' utente a un determinato indice nell'ArrayList
	 * @param index indice dell'ArrayList 
	 * @return Users all' indice
	 */
	public Utente get(int index) {
		return Users.get(index);
	}

	
	/**
	 * medoto per aggiungere un utente all' interno dell'ArrayList
	 * @param u
	 */
	public void  Aggiungi_utente (Utente u) {
		Users.add(u);
	}
	
	
	/**
	 * metodo che utilizzo per trovare un utente dal suo username
	 * @param name nome dell' utente che sto cercando
	 * @return l'utente se esiste, null altrimenti
	 */
	public Utente Find_Utente(String name){
		for (int i=0; i<getNumUtenti(); i++){
			Utente tmp = get(i);
			if (tmp.getUsername().equals(name))
				return tmp;
		}
		return null;

	}

	
	/**
	 * metodo per salvare la lista di utenti su file di testo "file_gestione".
	 * Scrivo "--NEXT--" per ogni utente che scrivo e metto i dati relativi all' utente, il numero di spedizioni, e tutte le spedizioni
	 */
	public void SalvaLista ()  {

		System.out.println("Salvataggio in corso");
	  
		File file = new File(file_gestione);
		  System.out.println("Directory Corrente"+ file.getAbsolutePath());
		try {
			FileWriter fw = new FileWriter (file);
			
					
			for (int i=0; i<getNumUtenti(); i++) {
				
				/*scrivo i dati dell' utente */
				Utente u = get(i);
				fw.write("--NEXT--"+"\n");
				fw.write(u.getUsername()+"\n");
				fw.write(u.getPassword()+"\n");
				fw.write(u.getIndirizzo()+"\n");
	       	    fw.write(u.getNumSpedizioni()+"\n");
	       	 
	       	    Lista_spedizioni sped = u.getSpedizioni();
				for (int j=0; j< sped.getNumSpedizioni(); j++){
					fw.write(sped.get(j).toString());
				}
			}
			fw.close();
			
		}
		catch(IOException e) {
			System.out.println("errore nella scrittura di file ");
			e.printStackTrace();
			System.exit(-100);
				
			}
		
			
		}
		

	
	
	/**
	 * metodo per caricare la lista di utenti su file di testo "file_gestione".
	 *  Se non trova il file ne crea uno con il metodo CaricaLista   .
	 */
	public void CaricaLista () {
		
		File file = new File(file_gestione);
		try {
			FileReader filein = new FileReader (file);
		    BufferedReader b=new BufferedReader(filein);
		    String verifico = null;
		    verifico = b.readLine();

	    	if ( verifico == null) {
	    		
	    		b.close();
	    		System.out.println("Ancora nulla caricato");
	    	}
	    	else {
	    		while (verifico != null) {
		    	
		    		String user, password, indirizzo, n_sped;
		    
		    	    user = b.readLine();
		    		password = b.readLine();
		    		indirizzo = b.readLine();
		  		    n_sped = b.readLine();		    
			     	int num_sped  = Integer.parseInt(n_sped);
			    	
		    	Utente U = new Utente(user, password, indirizzo);
			    	Aggiungi_utente(U);
			    	
	 	    	for (int i=0; i<num_sped; i++) {
			    		String tipo_spedizione = b.readLine();
			    		String nome, codice, destinazione, peso, data, stato;

			    	
					   if (tipo_spedizione.equals("NORMALE")){
							nome = b.readLine();
							codice = b.readLine();
	                        destinazione = b.readLine();
							peso = b.readLine();
							data = b.readLine();
		    				stato = b.readLine();
	        				int Peso = Integer.parseInt(peso);
		     				Sped s = new Sped(nome, codice, destinazione, Peso, data, stato);
			        		U.AggiungiSpedizione(s);								
						   
					   }
					   else{
							String val = b.readLine();
							nome = b.readLine();
			     			codice = b.readLine();
							destinazione = b.readLine();
		     				peso = b.readLine();
							data = b.readLine();
							stato = b.readLine();
							int Peso = Integer.parseInt(peso);
							int Val = Integer.parseInt(val);
							Sped_sicura s = new Sped_sicura(nome, codice, destinazione, Peso, data, stato, Val);
						    U.AggiungiSpedizione(s);
                    }
		         }
	 	    	verifico = b.readLine();
		    }
		    	b.close();
		    	System.out.println("Caricamento della lista di utenti con le relative spedizioni ");
	   	}
	    		
	    }		
	    	
	    	
	   /* se non trovo il file uso la funzione salvalista per crearne uno */
		catch(FileNotFoundException e2){
			System.out.println("creazione del file per la lista utenti");
			SalvaLista();
		}
		catch(IOException e) {
			e.printStackTrace();
			System.exit(-200);
		}

	}
	
}
	

	
	


