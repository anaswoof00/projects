package gestoreApp;

import java.awt.event.*;
import javax.swing.JFrame;

/**
 * Classe che implementa un JFrame modificato, che implementa sia un ActionListener che un
 * WindowListener, ogni classe del package gestoreApp estende questa classe
 * @author Anas Raouf
 */
public class create extends JFrame implements ActionListener, WindowListener {

	/**
     * metodo costruttore, alla chiusura del frame termina il programma
     */
    public create() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private static final long serialVersionUID = 1L;


    public void actionPerformed(ActionEvent e) {}
    
    /**
     * metodo che uso per chiudere  un Frame 
     */

    public void close_page() { 
       this.setVisible(false);
       this.dispose();

     } 
    
    /**
     * metodo che uso per aprire un nuovo frame
     * @param frame frame da rendere visibile
   
     */
    public void New_page(create frame) {
    	
       frame.setVisible(true);
       frame.pack();
       frame.setLocationRelativeTo(null);
       frame.setSize(600,400);
     }

     

    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {}

    @Override
    public void windowClosed(WindowEvent e) {}
    @Override
    public void windowIconified(WindowEvent e) {}
    @Override
    public void windowDeiconified(WindowEvent e) {}
    @Override
    public void windowActivated(WindowEvent e) {}
    @Override
    public void windowDeactivated(WindowEvent e) {}
}

