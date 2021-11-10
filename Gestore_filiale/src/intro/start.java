package intro;
import gestoreApp.*;


public class start {
	
	public static void main(String args[]){
	
	     Lista_Utenti l = new Lista_Utenti() ;
    	 l.CaricaLista();
		
		Login frame = new Login(l);
		frame.setVisible(true);
		frame.pack();
		frame.setLocationRelativeTo(null);
        frame.setSize(600,400); 
    	

       
        }
	}
