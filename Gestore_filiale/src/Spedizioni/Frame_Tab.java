package Spedizioni;

import gestoreApp.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;


/**
 * Classe che implementa il frame che mostra in formato tabellare le spedizioni
 */
public  class Frame_Tab extends create{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * lista di users
     */
    private Lista_Utenti list_Users;

    /**
     * lista di spedizioni
     */
    private Lista_spedizioni list_sped;

    /**
     * utente di cui sto visualizzando le spedizioni
     */
    private Utente utente;

    /**
     * variabile che dice se sono l'admin o sono un utente
     */
    private boolean admin;

    /**
     *  componenti grafiche del mio frame Fame_Tab 
     */
    private JLabel Mess_Utente;
    private JLabel Mess_Admin1;
    private JLabel Mess_Admin2;

    private JButton Indietro;
    private JButton Cancella;
    private JButton Rimborso;

    private JPanel Tab_Pan;
  

    private JTable t;
    private Mod_Tab tabella;
  

	 /**
     * metodo che uso per verificare se sono amministratore o utente
     * @return true se sono amministratore altrimenti false
     */
    public boolean isAdmin() { return admin; }


    /**
     * metodo che uso nel costruttore dei frame per decidere se sono l'amministratore o un utente
     * @param admin booleano che decide se sono amministratore o utente
     */
     public void setAdmin ( boolean admin){ this.admin = admin; }



    /**
     * Metodo costruttore che uso per inizializzare i vari componenti del frame Frame_Tab
     * In base a quale tabella costruisco (amministratore o utente) aggiungo  i componenti utili
     */
    public Frame_Tab(){
 
        Tab_Pan = new JPanel();
        this.add(Tab_Pan);
		Tab_Pan.setLayout(null);
		 
        Mess_Utente = new JLabel("Salve , puoi richiedere il rimborso per spedizioni fallite");
        Mess_Admin1 = new JLabel("Salve , puoi modificare lo stato delle spedizioni degli utenti cliccando nella casella apposita");
        Mess_Admin2 = new JLabel( "oppure rimuovere quelle in stato finale ");	
        Indietro = new JButton("Indietro");
        Rimborso = new JButton("Rimborso");
        Cancella = new JButton("Rimuovi");
        
        Indietro.addActionListener(this);
        Rimborso.addActionListener(this);
        Cancella.addActionListener(this);
   
    }

    /**
     * metodo costruttore del frame Frame_Tab per un utente
     *@param u un profilo che sta visualizzando le sue spedizioni
     * @param l lista di utenti a cui appartiene l' utente u
     */
    public Frame_Tab (Utente u, Lista_Utenti l){
        this();
        utente = u;
        list_Users = l;
        setAdmin(false);


        tabella = new Mod_Tab(utente.getSpedizioni());
        t = new JTable(tabella);
        t.setDefaultRenderer(Object.class, new celle_tab());
        t.setPreferredScrollableViewportSize(t.getPreferredSize());
        JScrollPane scrollpane = new JScrollPane(t);
        
        Mess_Utente.setBounds(100,10,330,30);
        scrollpane.setBounds(50,50,500,250);
        Indietro.setBounds(100,315,100,40);
        Rimborso.setBounds(350,315,120,40);
     
        
        Tab_Pan.add(Mess_Utente);
        Tab_Pan.add(scrollpane);
        Tab_Pan.add(Indietro);
        Tab_Pan.add(Rimborso);
     
    }


    /**
     * metodo costruttore del frame Frame_Tab per l'amministratore
     * @param l lista degli utenti registati
     */
    public Frame_Tab(Lista_Utenti l){
        this();
        list_Users = l;
        setAdmin(true);
        

        //creo una lista di spedizioni  di tutti gli utenti presenti nella lista
        list_sped = new Lista_spedizioni();
        for (int i=0; i<l.getNumUtenti(); i++){
            Utente u = l.get(i);
            Lista_spedizioni tmp = u.getSpedizioni();
            for (int j=0; j<tmp.getNumSpedizioni(); j++)
                list_sped.Aggiungi(tmp.get(j));
        }

        tabella = new Mod_Tab(list_sped);
        t = new JTable(tabella);
        t.setDefaultRenderer(Object.class, new celle_tab());
        t.setPreferredScrollableViewportSize(t.getPreferredSize());
        JScrollPane scrollPane1 = new JScrollPane(t);
        
        Mess_Admin1.setBounds(30,10,600,30);
        Mess_Admin2.setBounds(70,30,600,30);
        scrollPane1.setBounds(50,60,500,250);
        Indietro.setBounds(100,315,100,40);
        Cancella.setBounds(250,315,120,40);
 
        Tab_Pan.add(Mess_Admin1);
        Tab_Pan.add(Mess_Admin2);
        Tab_Pan.add(scrollPane1);
        Tab_Pan.add(Indietro);
        Tab_Pan.add(Cancella);
   
     }    

  
  
    @Override
    public void actionPerformed(ActionEvent e) {
        String Scelta = e.getActionCommand();

        if (Scelta.equals("Indietro")){

            if (isAdmin()){
                list_Users.SalvaLista();
                close_page();
                New_page(new Login(list_Users));
          

            }
            else {
                list_Users.SalvaLista();
                close_page();
                New_page(new Account(list_Users, utente));
            
            }
        }

        /*
        seleziono una spedizione, se posso richiedere il rimborso modifico il suo stato,
        altimenti segnalo un errore 
         */
     
        if (Scelta.equals("Rimborso")){
            Lista_spedizioni sped = utente.getSpedizioni();
            int num_rimborsi = 0;

            for (int i=0; i<t.getRowCount(); i++){
                Sped s = sped.get(i);
                String stato = s.getStato();
                
                if (stato.equals("FALLITA") && s.getValoreAssicurato()>0) {
                    t.setValueAt("RICHIESTA RIMBORSO", i, 5);
                    num_rimborsi++;
                }
            }
            if (num_rimborsi == 0)
                JOptionPane.showMessageDialog(this, "Nessun rimborso richiesto ", "", JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(this, "richiesti "+num_rimborsi+" rimborsi", "", JOptionPane.INFORMATION_MESSAGE);
        }

        /*
          rimuovo una spedizione che se è in uno stato finale quindi Ricevuta/Fallita/Rimborso erogato la cancello, alrimenti
          segnalo un errore 
         */
        if (Scelta.equals("Rimuovi")){
            Lista_spedizioni sped = tabella.getLista();
            Sped s = sped.get(t.getSelectedRow());
            String stato = s.getStato();

            if (stato.equals("RICEVUTA") || stato.equals("FALLITA") || stato.equals("RIMBORSO EROGATO")){
            	 

                String nome = s.getNomeUtente();
                Utente u = list_Users.Find_Utente(nome);
                Lista_spedizioni Lista_Sped = u.getSpedizioni();

                Lista_Sped.Remove(s);
            
                u.riduci_spedizione();
                
                sped.Remove(sped.get(t.getSelectedRow()));
                tabella.fireTableDataChanged();
                JOptionPane.showMessageDialog(this, "Spedizione eliminata ","", JOptionPane.INFORMATION_MESSAGE);

            }
            else
                JOptionPane.showMessageDialog(this, "Spedizione non in stato finale", "", JOptionPane.ERROR_MESSAGE);
            list_Users.SalvaLista();
        }
        
    }
   

    @Override
    public void windowClosing(WindowEvent e) {
        list_Users.SalvaLista();
        System.exit(0);
    }
}