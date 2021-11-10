package gestoreApp;

import java.awt.event.ActionEvent;
import javax.swing.*;
import Spedizioni.*;

/**
 * Classe che implementa il frame del login di un utente
 * @author Anas Raouf
 */
public class Login extends create{
	
	private static final long serialVersionUID = 100L;
	
	/**
     * username dell'amministratore
     */
	
	private static final String UsAdmin = "Pinco";

    /**
     * password dell'amministratore
     */
    private static final String PassAdmin = "Pallino";
    
    
	private JLabel t1, t2 , t3;
	private JPanel PanLog;
	private JButton reg , accedi ;
	private JTextField Un ;
	private JPasswordField Pass;  
	private Lista_Utenti l;
	
	public Login(Lista_Utenti lista) {
		
		super();
		
		
		l = lista;
	    PanLog = new JPanel();
		this.add(PanLog);
		PanLog.setLayout(null);
		
		t1 = new JLabel ("Benvenuto , effettua la Registrazione o il Login");
		t2 = new JLabel ("Username ");
	    t3 = new JLabel( "Password");
		Un = new JTextField ("",20);
		Pass = new JPasswordField ("",20);
		reg = new JButton("Registrazione");
		accedi = new JButton("Accedi");
		
		reg.addActionListener(this);
		accedi.addActionListener(this);
		
		t1.setBounds(220,10,300,100);
		t2.setBounds(200,150,100,10);
		Un.setBounds(300,145,200,20);
		t3.setBounds(200,220,100,10);
		Pass.setBounds(300,215,200,20);
		accedi.setBounds(175,300,150,40);
		reg.setBounds(350,300,150,40);
		
		
		PanLog.add(t1);
		PanLog.add(t2);
		PanLog.add(Un);		
		PanLog.add(t3);
		PanLog.add(Pass);
		PanLog.add(reg);
		PanLog.add(accedi);
		
	}	
		
	    public void actionPerformed(ActionEvent e) {
	        String choose = e.getActionCommand();
	      
	         if (choose.equals("Registrazione")) {
	        	
	        	close_page();
	            New_page(new Registrazione(l));
           
	         }
	         boolean flag = false;
	         if (choose.equals("Accedi")) {
	            String user = "", password = "";
	            char[] p;
	            user = Un.getText();
	            p = Pass.getPassword();
	            for (int i = 0; i < p.length; i++)
	                password = password + p[i];
	            
	            

	            /*controllo di aver inserito tutti i dati per il login */
	            if (user.equals("") || password.equals("")){
	                JOptionPane.showMessageDialog(this, "Inserire tutti i campi della registrazione ", "Errore", JOptionPane.ERROR_MESSAGE);
	                flag=true;
	               
	            }

	            /* se sono l' admin controllo di aver inseito username e password corrette*/
	             
	            
	                if (user.equals(UsAdmin) && password.equals(PassAdmin)){
	                	JOptionPane.showMessageDialog(this, "Benvenuto Amministratore", "", JOptionPane.INFORMATION_MESSAGE);
	                
	                	close_page();
	                    New_page(new Frame_Tab(l));	 
	                    flag = true;
	                    
	               }
	             
	             
	              if (user.equals(UsAdmin) && (!password.equals(PassAdmin)) && flag==false){
	                   JOptionPane.showMessageDialog(this, "Password Admin errata ", "Errore", JOptionPane.ERROR_MESSAGE);
	          
	                   close_page();
	                   New_page(new Login(l));	 
	                   
	                }
	              else{
	                    Utente present = new Utente();
	                    for (int i=0; i<l.getNumUtenti(); i++){
	                        Utente tmp = l.get(i);
	                        if (tmp.getUsername().equals(user))
	                            present = l.get(i);

	                    }
	               
	                    if (present.getUsername().equals("") && !(user.equals(UsAdmin))){
	                        JOptionPane.showMessageDialog(this, "Utente Inesistente ", "Errore", JOptionPane.ERROR_MESSAGE);
	                    
	                        close_page();
	    	                New_page(new Login(l));
	                    }
	                    //se arrivo qui l' utente esiste allora controllo la password
	                    else{
	                        if (present.getPassword().equals(password) && !(user.equals(UsAdmin))){
	                            @SuppressWarnings("unused")
								Utente tmp;
	                            for (int i=0; i<l.getNumUtenti(); i++){
	                                tmp = l.get(i);
	                                
	                            }
	                       
	                         
	    	                 
	                         close_page();
	                       	 New_page(new Account(l,present));
	                       	 flag=true;
	                            
	                        }
	                        else if(flag==false){
	                            JOptionPane.showMessageDialog(this, "Password errata ", "Errore", JOptionPane.ERROR_MESSAGE);
	                            close_page();
		    	                New_page(new Login(l));
	                        }
	                        
	                       
	                    }
	            
	                } 
              }
	    }
}

	        
	     
	        

	        	
	        
	       
	        
	 
