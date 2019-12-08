import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class timer extends JPanel {

  JLabel label;
  Timer timer;
  int count = 180;
  boolean inGame;
  JPanel timerPanel;

  public timer() 
  {
	//setOpaque(false);
	//set to false until the counter starts
	inGame = false;

	
	//What shows when the timer is not running
    label = new JLabel("3:00");
	label.setForeground(Color.black);
	label.setFont(new Font("Dialog", Font.PLAIN, 40));

    //Adds label to panel
    add(label);
    
    //creates new timer that performs an action ever 1000Ms (1 second)
    timer = new Timer(1000, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) 
      {      
        //if counter is still >=0 it will reset the label 
        if (count >= 0) {
        	
        	timerDisplay();

        } 
        //else stop the timer & actionEvent
        else {
          ((Timer) (e.getSource())).stop();
          inGame = false;
          label.setText("GAME OVER");

        }
        count--;
      }
    });
    
  }
  
  
  //Method to start the timer
  public void startTimer() 
  {
	    timer.start();
	    inGame = true;
  }
  
  
  //Method to Reset Timer
  public void resetTimer() 
  {
	  label.setForeground(Color.black);
	  inGame = false;
	  timer.stop();
	  count = 180;
      timerDisplay();
  }
  
  public void timerDisplay() {
  	int sec = count % 60;
    int min = (count / 60)%60;
    
    if (min>0 && sec>=10)
    {
    label.setText(Integer.toString(min) + ":" + Integer.toString(sec));
    }
    
    else if (min>0 && sec<10) 
    {
        label.setText(Integer.toString(min) + ":0" + Integer.toString(sec));
    }
    
    else if (min<=0 && sec>10) 
    {
        label.setText(Integer.toString(sec));
    }
    
    else if (min<=0 && sec<=10) 
    {
    	label.setForeground(Color.red);
        label.setText(Integer.toString(sec));
    }
    
    

  }
  //returns whether the timer is running or not (AKA user is in game)
  public boolean getInGame() {
	  return inGame;
  }

  

}