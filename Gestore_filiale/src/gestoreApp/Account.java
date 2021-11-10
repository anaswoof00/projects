package gestoreApp;

import Spedizioni.*;
import javax.swing.*;
import java.awt.event.ActionEvent;




/**
 * Classe che implementa il frame di un Account
 * che può eseguire spedizioni normali, assicurate o
 * visualizzare in formato tabellare le sue spedizioni
 * @author Anas Raouf
 */

public class Account extends create {
	
	private static final long serialVersionUID = 1L;

    /**
     * lista di utenti
     */
	private Lista_Utenti l;

    /**
     * utente loggato
     */
    private Utente u;

   
    /**
     * sono le mie componenti grafiche del mio frame Account
     */
    private JLabel Username, ms ;
    private JButton LogOut, Mostra, Sped_normale, Sped_Sicura;
    private JPanel Panuser;

    
    /**
     * Metodo costruttore che uso per inizializzare i componenti grafici del frame Account
     * @param lista corrisponde alla lista utenti
     * @param ut corrisponde all'utente
     */
    public Account( Lista_Utenti lista, Utente ut) {

        super();

        l = lista;
        u = ut;

        Panuser = new JPanel();
        this.add(Panuser);
		Panuser.setLayout(null);


        ms = new JLabel("Effettua nuove spedizioni o visualizza quelle svolte ");
        Username = new JLabel("Account di "+u.getUsername());
        Sped_normale = new JButton("Spedizione normale");
        Sped_Sicura = new JButton("Spedizione Sicura");
        LogOut = new JButton("Esci");
        Mostra = new JButton("Visualizza spedizioni");

        Sped_normale.addActionListener(this);
        Sped_Sicura.addActionListener(this); 
        LogOut.addActionListener(this);
       Mostra.addActionListener(this);
        
        Username.setBounds(50,25,200,40);        
        ms.setBounds(200,50,300,40);
        
        Sped_normale.setBounds(75,150,200,50);
        Sped_Sicura.setBounds(300,150,200,50);
        Mostra.setBounds(250,250,200,50);
        LogOut.setBounds(50,250,75,50);
		
        
        Panuser.add(ms);
        Panuser.add(Username);
        Panuser.add(Sped_normale);
        Panuser.add(Sped_Sicura);
        Panuser.add(Mostra);
        Panuser.add(LogOut);
        

       

     
    }


    public void actionPerformed(ActionEvent e) {
        String Select = e.getActionCommand();

        if (Select.equals("Spedizione normale")){
        	
        	close_page();
        	New_page(new add_spedizione("NORMALE",l,u));
         	 
        }

        if (Select.equals("Spedizione Sicura")){
        	
        	close_page();
        	New_page(new add_spedizione("ASSICURATA",l,u));
         	
        }

        if (Select.equals("Visualizza spedizioni")){
        	
        	close_page();
            New_page(new Frame_Tab (u,l));
        	
        
        }

        if (Select.equals("Esci")) {
          
           l.SalvaLista();
           close_page();
           New_page(new Login (l));
        
         
          
         
        }
    }  
}
