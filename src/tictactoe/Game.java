
package tictactoe;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class Game extends JFrame{
    private Container pane;
    private String currentPlayer;
    private final JButton [][] board;
    private boolean hasWinner;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem quit, newGAme;
    public Game(){
    pane.setLayout(new GridLayout(3,3));  
        setTitle("Tic Tac Toe");
       setSize(500, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        currentPlayer ="x";
        board =new JButton[3][3];
        hasWinner =false;
        intializeBoard();
        intializeMenuBar();
    }
    
    private void intializeMenuBar(){
     menuBar =new JMenuBar();
     menu = new JMenu("File");
     newGAme =new JMenuItem("New Game");
     newGAme.addActionListener(new ActionListener (){
         @Override
         public void actionPerformed(ActionEvent ae) {
             resetBoard(); }
     });
     quit =new JMenuItem("Quit");
     quit.addActionListener(new ActionListener (){
         @Override
         public void actionPerformed(ActionEvent ae) {
             System.exit(0); }
     });
     menuBar.add(menu);
     menu.add(quit);
     menu.add(newGAme);
        setJMenuBar(menuBar);
    }
    private void resetBoard(){
    currentPlayer ="x";
    hasWinner=false;
    for(int i=0;i<3;i++){
        for(int j=0;j<3;i++){
            board[i][j].setText("");
        }
    }
    
    }
    private void intializeBoard(){
    for(int i=0;i<3;i++)
    {
        for(int j=0;j<3;j++)
        {
          final JButton btn=new JButton();
          btn.setFont(new Font(Font.SANS_SERIF,Font.BOLD,100));
          btn.addActionListener(new ActionListener(){

              @Override
              public void actionPerformed(ActionEvent ae) {
               if(((JButton )ae.getSource()).getText().equals("")&&hasWinner==false)
               {
                   btn.setText(currentPlayer);
                   hasWinner();
                   togglePlayer();
               }
              }
          });
          pane.add(btn);
          
    }
    }
    }
    private void togglePlayer(){
      if(currentPlayer.equals("x"))
          currentPlayer="o";
      else
          currentPlayer="x";
    
    }
    private void hasWinner(){
    if(board[0][0].getText().equals(currentPlayer)&&board[1][0].getText().equals(currentPlayer)&&board[2][0].getText().equals(currentPlayer)){
        JOptionPane.showMessageDialog(null, "player"+ currentPlayer+"has won");
        hasWinner=true;
    }
    if(board[0][1].getText().equals(currentPlayer)&&board[1][1].getText().equals(currentPlayer)&&board[2][1].getText().equals(currentPlayer)){
        JOptionPane.showMessageDialog(null, "player"+ currentPlayer+"has won");
        hasWinner=true;
    }
    if(board[0][2].getText().equals(currentPlayer)&&board[1][2].getText().equals(currentPlayer)&&board[2][2].getText().equals(currentPlayer)){
        JOptionPane.showMessageDialog(null, "player"+ currentPlayer+"has won");
        hasWinner=true;
    }
    }
    
}
