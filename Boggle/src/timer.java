import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class timer extends JPanel {

  JLabel label;
  Timer timer;
  int count = 180;
  
  
  public timer() {
	//What shows when the timer is not running
    label = new JLabel("180");
    
    //Adds label to panel
    add(label);
    
    //creates new timer that performs an action ever 1000Ms (1 second)
    timer = new Timer(1000, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) 
      {
        count--;
        //if counter is still >0 it will reset the label
        if (count > 0) {
          label.setText(Integer.toString(count));
        } 
        //else stop the timer & actionEvent
        else {
          ((Timer) (e.getSource())).stop();
          
        }
      }
    });
    
  }
  
  
  //Method to start the timer
  public void startTimer() {
	    timer.start();
  }
  
  public void resetTimer() {
	  timer.stop();
	  count = 180;
      label.setText(Integer.toString(count));

  }
  

}