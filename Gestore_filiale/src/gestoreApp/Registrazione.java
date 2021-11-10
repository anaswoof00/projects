package gestoreApp;

import java.awt.event.ActionEvent;
import javax.swing.*;


/**
 * Classe che implementa il frame della registrazione di un utente
 * @author Anas Raouf
 */
public class Registrazione extends create {
	
	private static final long serialVersionUID = 100L;
	
	
    /* componenti grafiche*/
	private JLabel r1, r2 , r3 ;
	private JTextField loc , Unreg ;
	private JPasswordField Passreg;  
	private JPanel Panreg;
	private JButton iscriviti , indietro ;
	private Lista_Utenti l;
	
	
	/**
	 * metodo costruttore che uso per inizializzare i componenti del mio frame
	 * @param lista che corrisponde alla lista degli user
	 */
    public Registrazione(Lista_Utenti lista) {
            
		super();

     	this.l = lista;
     	
     	
		Panreg = new JPanel();
		this.add(Panreg);
		Panreg.setLayout(null);
		
	    r1 = new JLabel ("Username");
		r2 = new JLabel ("Password");
	    r3 = new JLabel( "Indirizzo");
		Unreg = new JTextField ("",20);
		Passreg = new JPasswordField ("",20);
		loc = new JTextField("",20);
		iscriviti = new JButton("Iscriviti");
		indietro = new JButton("Indietro");
		
		iscriviti.addActionListener(this);
		indietro.addActionListener(this);
		
		r1.setBounds(200,75,100,10);
		Unreg.setBounds(300,73,200,20);
		r2.setBounds(200,150,100,10);
		Passreg.setBounds(300,145,200,20);
		r3.setBounds(220,220,100,10);
		loc.setBounds(300,215,200,20);
		indietro.setBounds(125,300,125,35);
		iscriviti.setBounds(350,300,150,40);
		
		
		Panreg.add(r1);
		Panreg.add(Unreg);
		Panreg.add(r2);
		Panreg.add(Passreg);		
		Panreg.add(r3);
		Panreg.add(loc);
		Panreg.add(indietro);
		Panreg.add(iscriviti);
		
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String Choose = e.getActionCommand();
        
        if (Choose.equals("Indietro")) {
        	
        	close_page();
        	New_page(new Login(l));
          
        	 }
        if (Choose.equals("Iscriviti")){
            String username = "", password = "",  indirizzo = "";
            
            char[] ps;
            username = Unreg.getText();
            indirizzo = loc.getText();  
            ps = Passreg.getPassword();
          
             for (int i = 0; i < ps.length; i++)
                 password = password + ps[i];
         
	       
             boolean flag = false;
            
            
           if (username.equals("") || indirizzo.equals("") || password.equals("")   ) {
        	   flag = true;
   
                JOptionPane.showMessageDialog(this, "Inserire tutti i campi della registrazione ", "Errore", JOptionPane.ERROR_MESSAGE);
           
             } 
                /*controllo che l' username inserito non sia quello dell'amministratore */
              if (username.equals("Pinco")) {
                   
                  JOptionPane.showMessageDialog(this, "Inserire un username diverso da Admin", "Errore", JOptionPane.ERROR_MESSAGE);
                  close_page();
              	  New_page(new Registrazione(l)); 
              } 
               else {    
                 
            	 Utente new_User = new Utente(username, password, indirizzo);
                 boolean control_Present = false;
            	 
              /*controllo che l' utente inserito non sia gia presente nella lista */
            	 for (int i=0; i<l.getNumUtenti(); i++) {
         			Utente utente = l.get(i);
         			if (utente.getUsername().equals( new_User.getUsername())) {
         				control_Present = true;
         		   JOptionPane.showMessageDialog(this, "Username già presente", "Errore", JOptionPane.ERROR_MESSAGE);
         				break;
         				 
         			}
         			
            	 } 
         			
         	if(control_Present == false && flag==false){
         		JOptionPane.showMessageDialog(this, "L'iscrizione é completata con successo", "", JOptionPane.INFORMATION_MESSAGE); 
                l.Aggiungi_utente(new_User); 
                l.SalvaLista();
               
                close_page();
                New_page(new Account(l,new_User));
                 
            }     
            	 
            else
            {
            	close_page();
            	New_page(new Registrazione(l));  
         	
         	
              }
         		 
                      
            }      	  
                    
        }      
                       
    }                
                       
}                     
              
         	
              
        
        
	
 


 
	