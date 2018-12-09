package tictactoe;
 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
 

public class TicTacToeFrame extends JFrame{
   private char whoseTurn = 'X';
   private boolean gameOver = false;
   private Cell[][] cells = new Cell[3][3];
   private static String Xname = "";
   private static String Oname = "";
   Color pieces = new Color(0,59,65);
   
   
   public String getXname() {
	return Xname;
}



public static void setXname(String xname) {
	Xname = xname;
}



public String getOname() {
	return Oname;
}



public static void setOname(String oname) {
	Oname = oname;
}

JLabel jlblStatus = new JLabel(Xname +"'s turn to play");
 
   
   public TicTacToeFrame(){
       /// Panel to hold cells
       JPanel panel = new JPanel(new GridLayout(3, 3, 0, 0));
       for (int i = 0; i < 3; i++)
           for (int j = 0; j < 3; j++)
               panel.add(cells[i][j] = new Cell());
 
 
       add(panel, BorderLayout.CENTER);
       add(jlblStatus, BorderLayout.SOUTH);
   }
 
   
   	/// checks if the board full
    public boolean isFull(){
       for (int i = 0; i < 3; i++)
           for (int j = 0; j < 3; j++)
               if (cells[i][j].getToken() == ' ')
                   return false;
       return true;
    }
 
    /// checks for three in a row
   public boolean isWon(char token) {
       for (int i = 0; i < 3; i++)
           if ((cells[i][0].getToken() == token)
                   && (cells[i][1].getToken() == token)
                   && (cells[i][2].getToken() == token)){
               return true;
           }
       for (int j = 0; j < 3; j++)
           if ((cells[0][j].getToken() == token)
               && (cells[1][j].getToken() == token)
               && (cells[2][j].getToken() == token)){
               return true;
           }
              if ((cells[0][0].getToken() == token)
               && (cells[1][1].getToken() == token)
               && (cells[2][2].getToken() == token)){
               return true;
           }
 
       if ((cells[0][2].getToken() == token)
               && (cells[1][1].getToken() == token)
               && (cells[2][0].getToken() == token)){
               return true;
           }
 
       return false;
   }
 
 
    public class Cell extends JPanel{
	private char token = ' ';
 
       
       public Cell(){
           setBorder(new LineBorder(Color.BLACK, 1));
           addMouseListener(new MyMouseListener());
       }
 
       
       public char getToken(){
           return token;
       }
 
       
       public void setToken(char input){
           token = input;
           repaint();
       }
 
      
       protected void paintComponent(Graphics g){
           super.paintComponent(g);
           Graphics2D g2 = (Graphics2D) g;
           g2.setColor(Color.RED);
           g2.fillRect(0, 0, 600, 600);
           
           if (token == 'X'){
        	   super.paintComponent(g);
        	   g2.setColor(Color.white);
        	   g2.fillRect(0,0,getWidth(),getHeight());g2.setColor(Color.blue);
        	   g2.setStroke(new BasicStroke(3));
        	   g2.drawLine(10, 10, getWidth() - 10, getHeight() - 10);
               g2.drawLine(getWidth() - 10, 10, 10, getHeight() - 10);
           }
 
           else if (token == 'O'){
        	   g2.setColor(Color.white);
        	   g2.fillRect(0,0,getWidth(),getHeight());
        	   g2.setStroke(new BasicStroke(3));
        	   g2.setColor(Color.BLUE);
        	   g2.drawOval(10, 10, getWidth() - 20, getHeight() - 20);
           }
       }
 
       private class MyMouseListener extends MouseAdapter{
           @Override
           public void mouseClicked(MouseEvent e){
               if (gameOver)
                   return;
               if (token == ' ' && whoseTurn != ' ')
                   setToken(whoseTurn);
 
               if (isWon(whoseTurn)){
                   if (whoseTurn == 'x') {
                	   jlblStatus.setText(Oname + " won! Game over!");
                	   whoseTurn = ' ';
                	   gameOver = true;
                   }else {
                	   jlblStatus.setText(Xname + " won! Game over!");
                	   whoseTurn = ' ';
                	   gameOver = true;
                   }
               }else if (isFull()){
                   jlblStatus.setText("Tie game! Game over!");
                   whoseTurn = ' ';
                   gameOver = true;
               }else {
                   if (whoseTurn == 'X'){
                	   whoseTurn = 'O';
                	   jlblStatus.setText(Oname + "'s turn.");
                   }else{
                	   whoseTurn = 'X';
                	   jlblStatus.setText(Xname + "'s turn.");
                   
               		}
                   
               	}
           }
       } 
    }
}
