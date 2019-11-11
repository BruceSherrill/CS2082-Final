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
  
  
  public timer() 
  {
	//set to false until the counter starts
	inGame = false;
	//What shows when the timer is not running
    label = new JLabel("3:00");
    
    //Adds label to panel
    add(label);
    
    //creates new timer that performs an action ever 1000Ms (1 second)
    timer = new Timer(1000, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) 
      {
        count--;
        //if counter is still >=0 it will reset the label 
        if (count >= 0) {
        	int sec = count % 60;
            int min = (count / 60)%60;
          label.setText(Integer.toString(min) + ":" + Integer.toString(sec));
        } 
        //else stop the timer & actionEvent
        else {
          ((Timer) (e.getSource())).stop();
          inGame = false;
        }
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
	  inGame = false;
	  timer.stop();
	  count = 180;
      label.setText(Integer.toString(count));
  }
  
  //returns whether the timer is running or not (AKA user is in game)
  public boolean getInGame() {
	  return inGame;
  }

  

}