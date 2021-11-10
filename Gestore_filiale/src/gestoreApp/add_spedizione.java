package gestoreApp;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

/**
 * Classe che implementa un frame in cui un utente aggiunge spedizioni normali o assicurate
 * @author Anas Raouf
 */
public class add_spedizione extends create  {
    private static final long serialVersionUID = 1L;

    /**
     * lista di utenti
     */
    private Lista_Utenti l;
    


    /**
     * utente che sta aggiungendo le spedizioni
     */
    private Utente u;

    /**
     * indica il tipo di spedizioni che effettuo
     */
   private String Type;

    /**
     * componenti grafici del mio frame add_spedizione
     */
    private JLabel m1, m2, ps, ind, Val;
    private JTextField Peso , Indirizzo , Val_assicurato;
    private JButton Aggiungi, Indietro;
    private JPanel Pansp ;


    /**
     * metodo costruttore del frame per effetture una nuova spedizione normale o assicurata
     * @param tipo indica il tipo di spedizione effettuato 
     * @param l lista di utenti
     * @param u utente che sta effetuando le spedizioni
     */
    public add_spedizione(String tipo , Lista_Utenti l, Utente u) {

        super();
        Pansp = new JPanel();
        this.add(Pansp);
		Pansp.setLayout(null);

        this.l = l;
        this.u = u;
        Type = tipo;
      
       
        m1 = new JLabel("SPEDIZIONE NORMALE");
        m2= new JLabel("SPEDIZIONE SICURA");
        ps = new JLabel("Peso");
        ind = new JLabel("Indirizzo");
        Val = new JLabel("Valore assicurato");
        Peso = new JTextField("", 3);
        Indirizzo = new JTextField("", 25);
        Val_assicurato = new JTextField ("", 5);
       
        Aggiungi = new JButton("Aggiungi");
        Indietro = new JButton("Indietro");


        Aggiungi.addActionListener(this);
        Indietro.addActionListener(this);
        this.addWindowListener(this);
        
        m1.setBounds(160,20,150,40); 
        m2.setBounds(160,20,150,40); 
        ps.setBounds(150,75,50,40);        
        Peso.setBounds(200,85,40,20);
        ind.setBounds(150,125,200,50);
        Indirizzo.setBounds(220,140,100,20);
        Val.setBounds(150,190,120,40);
        Val_assicurato.setBounds(280,200,50,30);
        Indietro.setBounds(130,280,100,30);
        Aggiungi.setBounds(300,270,130,40);
         
        if (Type  == "NORMALE") {
            Val_assicurato.setEditable(false);
            Pansp.add(m1);
        }
        else
        	Pansp.add(m2); 
          
        Pansp.add(Val_assicurato);  
        Pansp.add(ps);
        Pansp.add(Peso);
        Pansp.add(ind);
        Pansp.add(Indirizzo);
        Pansp.add(Val);
        Pansp.add(Aggiungi);
        Pansp.add(Indietro);

        

    }

    public void actionPerformed(ActionEvent e) {
        String Select = e.getActionCommand();

        if (Select.equals("Aggiungi")) {
            String peso = Peso.getText();
            String indirizzo = Indirizzo.getText();
            String val = Val_assicurato.getText();
            boolean flag = false;

            if (peso.equals("") || indirizzo.equals("") ) {
                JOptionPane.showMessageDialog(this, "Inserire tutti i campi della spedizione ", "Errore", JOptionPane.ERROR_MESSAGE); 
                flag = true;
            }
            if (Type == "ASSICURATA"  ) {
        	    if (val.equals("") && flag==false ) 
                      JOptionPane.showMessageDialog(this, "Inserire tutti i campi della spedizione ", "Errore", JOptionPane.ERROR_MESSAGE);
        	    flag = true;
            }
            //CONTROLLO IL PESO DEL PACCO CHE DEVE ESSERE UN INTERO E MAGGIORE DI 0
            try {
                @SuppressWarnings("unused")
                int p= Integer.parseInt(peso);
            }
            catch (java.lang.NumberFormatException e1) {
           
            close_page();
            New_page(new add_spedizione(Type, l, u));
            
            if(flag == false)   
            JOptionPane.showMessageDialog(this, "Peso deve essere di tipo intero ", "Errore", JOptionPane.ERROR_MESSAGE);

            }
            int PS = Integer.parseInt(peso);

            if (PS <=0 ) {
            	
            	close_page();
            	New_page(new add_spedizione(Type, l, u));
            	
            	JOptionPane.showMessageDialog(this, "Peso deve essere maggiore di 0 ", "Errore", JOptionPane.ERROR_MESSAGE);

            }
            else {
                if (Type == "NORMALE" && flag == false) {
                	 JOptionPane.showMessageDialog(this, "Spedizione normale è avvenuta con successo ", "", JOptionPane.INFORMATION_MESSAGE);
                	 u.Genera_Sped_normale(indirizzo, PS);
                	 l.SalvaLista();
                	 close_page();
                     New_page(new add_spedizione(Type, l, u) );
              
                }
            }

            if (Type == "ASSICURATA") {

            //CONTROLLO IL VALORE ASSICURATO CHE DEVE ESSERE UN INTERO E MAGGIORE DI 0
          	
                try {
                    @SuppressWarnings("unused")
                    int v = Integer.parseInt(val);
                }
                catch(java.lang.NumberFormatException e2) {
                	close_page();
                    New_page(new add_spedizione(Type, l, u) );
                    
                    if(flag == false)
                    JOptionPane.showMessageDialog(this, "Valore Assicurato deve essere di tipo intero", "Errore", JOptionPane.ERROR_MESSAGE);

                }

                int VL = Integer.parseInt(val);
                if (VL <= 0) {
                    JOptionPane.showMessageDialog(this, "Valore assicurato deve essere maggiore di 0 ", "Errore", JOptionPane.ERROR_MESSAGE);
                    
                    close_page();
                    New_page(new add_spedizione(Type, l, u) );
                 

                }
                else {
                	 JOptionPane.showMessageDialog(this, "La Spedizione assicurata è avvenuta con successo ", "", JOptionPane.INFORMATION_MESSAGE);
                    u.Genera_Sped_sicura(indirizzo , PS, VL);
                    l.SalvaLista();
                    close_page();
                    New_page(new add_spedizione(Type, l, u) );
                 

                }
            }
        }
            if (Select.equals("Indietro")) {
            	 l.SalvaLista();
            	
     
                close_page();
            	New_page(new Account(l,u));
              	
        }
    
    }
    @Override
    public void windowClosing(WindowEvent e) {
        l.SalvaLista();
        System.exit(0);
    }
}

