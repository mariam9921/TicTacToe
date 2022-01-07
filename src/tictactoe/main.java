
package tictactoe;

import javax.swing.SwingUtilities;


public class main {

    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                /*game*/
                Game Game; 
                Game = new Game();
            }
        });
    }
    
}
