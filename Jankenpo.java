/**
 * Jankenpo -- This is a class that is used to create a GUI that implements functioning buttons that will instruct you and let you play
 JanKenPo or Rock Paper Scissors with save score feature.
 * @author    Ricki Ace Gaborno
 */

import javax.swing.*; 
import java.awt.event.*;  
import java.awt.*;
import java.io.*;

public class Jankenpo extends JFrame{ //this class is a frame
   //instance variables
   private int cChoice ;
   private String computerChoice = " ";
   private String pChoice = " ";
   private int cScore = 0;
   private int dScore = 0;
   private int pScore = 0;
   private final int WIDTH = 900;
   private final int HEIGHT = 600; 

   
   // JFrame instance Variables
   private JButton buttonRock = new JButton("ROCK");
   private JButton buttonPaper = new JButton("PAPER");
   private JButton buttonScissors = new JButton("SCISSORS");
   private JButton buttonHowtoplay = new JButton("INSTRUCTIONS");
   private JButton buttonScore = new JButton("Save Your Score");
   private JLabel title = new JLabel(" Rock Paper Scissors ", SwingConstants.CENTER);
   private JLabel playerChoice = new JLabel("You chose: " + pChoice);
   private JLabel winner = new JLabel("");
   private JLabel instruct = new JLabel("Choose Either Rock Paper Scissors");
   private JLabel compChoice = new JLabel("Computer chose: " + computerChoice);
   private JLabel playerScore = new JLabel("Your Score: " + pScore);
   private JLabel draws = new JLabel("Draws: " + dScore);
   private JLabel compScore = new JLabel("Computer's score: " + cScore);
   
 
   //Instruction for Jankenpo frame to set it's size and title
   public Jankenpo(){
      this.setSize(WIDTH, HEIGHT);  
      this.setTitle("Rock Paper Scissors");
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setVisible(true);
      this.setResizable(false);
   }
 

  // Creates Panel to implement elements onto screen and there respective locations
  // Creates ActionListener interface for which creates a method that gives buttons actions or events
  public void initializeGUI() throws Exception{
      ActionListener ears = new MyListener();
      buttonRock.addActionListener(ears);
      buttonPaper.addActionListener(ears);
      buttonScissors.addActionListener(ears);
      buttonHowtoplay.addActionListener(ears);
      buttonScore.addActionListener(ears);
      
      //Creates Main Panel to implement other panels
      JPanel mPanel = new JPanel( );  
      mPanel.setLayout(new BorderLayout( ));

      //Create Panel for Title, Instructions Button, and Save Your Score Button
      JPanel topPanel = new JPanel();
      topPanel.setBackground(Color.orange);
      topPanel.setLayout(new BorderLayout());
      topPanel.add(buttonHowtoplay, BorderLayout.WEST);
      topPanel.add(title);
      topPanel.add(buttonScore, BorderLayout.EAST);
      
      mPanel.add(topPanel, BorderLayout.NORTH);
      
      //Creates Panel for the button Paper
      JPanel centerPanel = new JPanel();
      buttonPaper.setPreferredSize(new Dimension(300, 200 ));
      buttonPaper.setBackground(Color.white);
      centerPanel.setBackground(Color.magenta);
      centerPanel.add(buttonPaper);
      
      mPanel.add(centerPanel, BorderLayout.CENTER);
      
      //Creates Panel for the button Rock
      JPanel leftPanel = new JPanel();
      leftPanel.setBackground(Color.magenta);
      buttonRock.setBackground(Color.gray);
      buttonRock.setPreferredSize(new Dimension(300, 200 ));
      leftPanel.add(buttonRock);
      
      mPanel.add(leftPanel, BorderLayout.WEST);
      
      //Creates Panel for the button Scissors
      JPanel rightPanel = new JPanel();
      rightPanel.setBackground(Color.magenta);
      buttonScissors.setBackground(Color.pink);
      buttonScissors.setPreferredSize(new Dimension(300, 200 ));
      rightPanel.add(buttonScissors);
      
      mPanel.add(rightPanel, BorderLayout.EAST);
      
      // Creates Panel for South Border for main panel or mPanel      
      JPanel bottomPanel = new JPanel();
      bottomPanel.setBackground(Color.cyan);
      bottomPanel.setLayout(new GridLayout (2 , 3 ,100, 200));
      bottomPanel.add(playerChoice);
      bottomPanel.add(winner);
      bottomPanel.add(compChoice);
      bottomPanel.add(playerScore);
      bottomPanel.add(draws);
      bottomPanel.add(compScore);

      mPanel.add(bottomPanel, BorderLayout.SOUTH);
      
      
      //Adds panel to JanKenPo Frame
      this.add(mPanel);     
   }
      
      
   //inner class 
   private class MyListener implements ActionListener {
      // A method  that assigns buttons when pressed as events
      public void actionPerformed(ActionEvent e)  {
         
         if(e.getSource( ) == buttonHowtoplay){
            JOptionPane.showMessageDialog(null,"Choose Either Rock Paper or Scissors" + 
            "\nRock beats Scissors" + "\nPaper beats Rock" + "\nScissors beats Paper", "Intructions",JOptionPane.INFORMATION_MESSAGE);
         }
            
         if(e.getSource( ) == buttonRock){
            cChoice = (int)(Math.random()*3);
            pChoice = "Rock";
            int p = 0;
            playerChoice.setText("You chose: " + pChoice);
            
            if ( cChoice == 0 ) {
               computerChoice = "Rock";
               compChoice.setText("Computer chose: " + computerChoice);
            }
            if ( cChoice == 1 ) {
               computerChoice = "Paper";
               compChoice.setText("Computer chose: " + computerChoice);
            }
            if ( cChoice == 2 ) {
               computerChoice = "Scissors";
               compChoice.setText("Computer chose: " + computerChoice);
            }
            
            
            switch(cChoice){
            
               case 0:
                  winner.setText ("Its a Draw!");
                  ++dScore;
                  draws.setText ("Draws: " + dScore );
                  break;   
                  
               case 1:
                  winner.setText ("Computer Wins!");
                  ++cScore;
                  compScore.setText ("Computer's score: " + cScore );
                  break;
                  
               case 2:
                  winner.setText ("You Win!");
                  ++pScore;
                  playerScore.setText ("Your Score: " + pScore );
                  break;
  
            }      
         }   
               
               
                  
         if(e.getSource( ) == buttonPaper){
            cChoice = (int)(Math.random()*3);
            pChoice = "Paper";
            int p = 1;
            playerChoice.setText("You chose: " + pChoice);
            
            if ( cChoice == 0 ) {
               computerChoice = "Rock";
               compChoice.setText("Computer chose: " + computerChoice);
            }
            if ( cChoice == 1 ) {
               computerChoice = "Paper";
               compChoice.setText("Computer chose: " + computerChoice);
            }
            if ( cChoice == 2 ) {
               computerChoice = "Scissors";
               compChoice.setText("Computer chose: " + computerChoice);
            }
            
            
            switch(cChoice){
            
               case 1:
                  winner.setText ("Its a Draw!");
                  ++dScore;
                  draws.setText ("Draws: " + dScore );
                  break;   
                  
               case 2:
                  winner.setText ("Computer Wins!");
                  ++cScore;
                  compScore.setText ("Computer's score: " + cScore );
                  break;
                  
               case 0:
                  winner.setText ("You Win!");
                  ++pScore;
                  playerScore.setText ("Your Score: " + pScore );
                  break;
  
            }
         }         
    
         if(e.getSource( ) == buttonScissors){
            cChoice = (int)(Math.random()*3);
            pChoice = "Scissors";
            int p = 2;
            playerChoice.setText("You chose: " + pChoice);
            
            if ( cChoice == 0 ) {
               computerChoice = "Rock";
               compChoice.setText("Computer chose: " + computerChoice);
            }
            if ( cChoice == 1 ) {
               computerChoice = "Paper";
               compChoice.setText("Computer chose: " + computerChoice);
            }
            if ( cChoice == 2 ) {
               computerChoice = "Scissors";
               compChoice.setText("Computer chose: " + computerChoice);
            }
            
            
            switch(cChoice){
            
               case 2:
                  winner.setText ("Its a Draw!");
                  ++dScore;
                  draws.setText ("Draws: " + dScore );
                  break;   
                  
               case 0:
                  winner.setText ("Computer Wins!");
                  ++cScore;
                  compScore.setText ("Computer's score: " + cScore );
                  break;
                  
               case 1:
                  winner.setText ("You Win!");
                  ++pScore;
                  playerScore.setText ("Your Score: " + pScore );
                  break;
  
            }
         }      
      
         if(e.getSource( ) == buttonScore) {
         
            JOptionPane.showMessageDialog(null,"Your Score Has been saved to text file scores.txt", "Your Score Has Been Saved",JOptionPane.INFORMATION_MESSAGE);
            
            try {
            File file = new File("scores.txt");
            FileWriter fw = new FileWriter(file, true);
            PrintWriter pw = new PrintWriter(fw);
            
            pw.println("Your Score: " + pScore + " Draws: " + dScore + " Computer's score: " + cScore);
            
            pw.close();
            }
            catch (IOException ex) {
            }
            

         }
      
      
      
      
      
      
      
      
      }
   }      


 
}