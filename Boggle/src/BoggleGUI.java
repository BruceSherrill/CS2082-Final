import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class BoggleGUI extends JFrame implements ActionListener {

	// More buttons. Separated for organizational purposes. 
	private JButton startBtn = new JButton("start");
	private JButton confirmWordBtn = new JButton("confirmWord");

	
	// PANELS.
	private JPanel leftPanel = new JPanel(new GridLayout(4,4));
	private JPanel rightPanel = new JPanel(new GridLayout(2,1));
	private JPanel bottomPanel = new JPanel(new BorderLayout());
	private JPanel mainPanel = new JPanel(new BorderLayout());
	
	private JTextArea displayArea = new JTextArea(4, 10);
	
	
	//-----my garbage
    private timer timer = new timer();
	JButton[] buttonArray = new JButton[16];
	boolean[][] isSelected = new boolean[4][4];
	boolean[][] nextSelection = new boolean[4][4];
	boolean firstLetter = true;
    char letterArray[][] = new char[4][4];
	String stringTest = "";
	Trie tree = new Trie();
	

    
	
	private BoggleGUI () {
		// Window Requirements.
		super("Boggle");
		setSize(700, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		tree.importDictionary();
		// Boggle Board is divided into three panels. 
		// Left for the dies
		// right for the UI
		// Bottom for the timer. 
		buildLeftPanel();
		buildRightPanel();
		buildBottomPanel();
		addPanelsToFrame();
		addListener();
				

		setVisible(true);
	}
	
	


	// new game method
	private void buildLeftPanel() {
		
		//creates new die set in char[] diceSet
		Dice die = new Dice();
		char[] diceSet = new char[16];
		diceSet = die.getDieSet();
		
		int counter = 0;
		JButton button;
		
		//fills buttonArray with 16 buttons w/ their appropriate label
		for (int i=0; i<diceSet.length; i++)
		{
			button = new JButton("" + diceSet[i]);
			buttonArray[i] = button;
		}
		 for(int n=0; n<isSelected.length; n++)
		  {
			  for (int m=0; m<nextSelection.length; m++)
			  {
				  nextSelection[n][m] = false;
			  }
		  }
		 

		 //2 for loops that get the x & y coordinate
		for(int x=0; x<4; x++) {
        	 for (int y=0; y<4; y++) {
        		  int yPosition = y;
      			  int xPosition = x;

     			int count = counter;
     			//adds button to panel
     			leftPanel.add(buttonArray[counter]);
     			//adds action listener to button
		        letterArray[xPosition][yPosition] = buttonArray[count].getLabel().charAt(0); 
     			buttonArray[counter].addActionListener(new ActionListener() {
        			 @SuppressWarnings("deprecation")
					public void actionPerformed(ActionEvent e) {
        				 //if canClick() returns true then the button is clickable
        				 if (canClick(xPosition, yPosition) == (true) && timer.getInGame() == true) 
        				 {
        					 System.out.println(xPosition + "," + yPosition + "     " + buttonArray[count].getLabel());
        				        buttonArray[count].setForeground(Color.ORANGE);
        				 }
        			 }
        			 });
     			//increments every loop for 16 total loops
     			counter++;
        	 }
        }
		




	}
	
	
	//if returns true the user can click the button
	//if returns false the user cannot click the button
	private boolean canClick(int x, int y)
	{

		//all possible combinations
		 final int[][] cell = {
			        {x + 1,  y    },  //bottom
			        {x    ,  y + 1},  //right
			        {x - 1,  y    },  //top
			        {x    ,  y - 1},  //left
			        {x + 1,  y + 1},  //bottom-right
			        {x + 1,  y - 1},  //bottom-left
			        {x - 1,  y - 1},  //top-left
			        {x - 1,  y + 1}   //top-right
			    };
		
		 //determines if it is the first click on the board
		 if (firstLetter == true)
		 {
			 isSelected[x][y] = true;
			 firstLetter = false;
			 
			 //for loop that runs through every combination in cell[][] 
			 //what this does is sets every surrounding cell = true
	    	  for(int i=0; i<cell.length; i++)
	    	  {
	    			  if (cell[i][0] >=0 && cell[i][1] >=0 && cell[i][0] <4 && cell[i][1] <4)	
	    			  {
	    			  nextSelection[cell[i][0]][cell[i][1]] = true;
	    			  }
	    	  }
	    return true;
		 }
		 
		 //isSelected[x][y] prevents the user from clicking the same button twice
		 //nextSelection[x][y] only lets the user click the surrounding buttons
		 else if (isSelected[x][y] == false && nextSelection[x][y] == true)
		 {
			 //resets all cells in nextSelection[][] to false
			 for(int o=0; o<isSelected.length; o++)
	    	  {
	    		  for (int p=0; p<nextSelection.length; p++)
	    		  {
	    			  nextSelection[o][p] = false;
	    		  }
	    	  }
			 //sets nextSelection[][] (surrounding cells) to true
	    	  for(int h=0; h<cell.length; h++)
	    	  {
	    			  if (cell[h][0] >=0 && cell[h][1] >=0 && cell[h][0] <4 && cell[h][1] <4)
	    			  {
	    			  nextSelection[cell[h][0]] [cell[h][1]] = true;
	    			  }
	    	  }
			 isSelected[x][y] = true;
			 return true;
		 }
		return false;
	}

	

	
	
	 public void findWords(char boggle[][], boolean isSelected[][], int x, int y, String word) 
			{ 
				// Mark current cell as visited and append current character 
				// to str 
				isSelected[x][y] = true; 
				word = word + boggle[x][y]; 
				
				// If str is present in dictionary, then print it 
				if (word.length() >= 3 && tree.isWord(word.toLowerCase())) 
				System.out.println(word); 
				
				// Traverse 8 adjacent cells of boggle[x][y] 
				
				//x-1 gets the cell to the left
				//row <=x+1 ensures it won't go more than 1 to the right
				//row<4 ensures it won't go past the 4th cell (edge of board)
				
				for (int row=x-1; row<=x+1 && row<4; row++) {
				for (int col=y-1; col<=y+1 && col<4; col++) {
					if (row>=0 && col >=0  && isSelected[row][col] == false) {
						   findWords(boggle, isSelected, row, col, word); 
					}
					}
				}
		        	 

				// Erase current character from string and mark visited 
				// of current cell as false 
				word="";
				isSelected[x][y] = false; 

			} 
	
	
	// UI panel. 
	private void buildRightPanel() {
		rightPanel.add(startBtn);
		rightPanel.add(confirmWordBtn);
		rightPanel.add(displayArea);
		
	}

	
	// Timer panel. 
	private void buildBottomPanel() {
		bottomPanel.add(timer);	
	}
	
	// Adding the panels to the frame after they've been built. 
	private void addPanelsToFrame() {
		mainPanel.add(leftPanel, BorderLayout.WEST);
		mainPanel.add(rightPanel, BorderLayout.EAST);
		mainPanel.add(bottomPanel, BorderLayout.SOUTH);
		
		add(mainPanel);
		
	}
	
	// Action Listeners
	@Override
	public void actionPerformed(ActionEvent e) {
	String clicker = e.getActionCommand();


      if (clicker == "start"){
			timer.startTimer();
			 for(int x=0; x<isSelected.length; x++)
	    	  {
	    		  for (int y=0; y<isSelected.length; y++)
	    		  {
	    			  isSelected[x][y] = false;
	    		  }
	    	  }
		}
      else if (clicker == "confirmWord")
      {
    	  //reset board commented out to test getting answers on button press
//    	  int tempCounter=0;
//    	  
//    	  for(int x=0; x<isSelected.length; x++)
//    	  {
//    		  for (int y=0; y<isSelected.length; y++)
//    		  {
//    			  isSelected[x][y] = false;
//    			  firstLetter = true;
//    			  buttonArray[tempCounter].setForeground(Color.BLACK);
//    			  tempCounter++;
//    		  }
//    	  }
    	  
  		//-------------------------------------------------------------------------------------------
  		for(int x=0; x<4; x++) {
         	 for (int y=0; y<4; y++) {
       		System.out.println(x + "," + y);
  		findWords(letterArray, isSelected, x, y, stringTest);
         	 }
  		}
  		//-------------------------------------------------------------------------------------------
      }//end of else if()
		
	}
	
	
	
	// Making buttons click able.
	private void addListener() {
		startBtn.addActionListener(this);
		confirmWordBtn.addActionListener(this);
	}
	
	
	// ============= Main ================
	public static void main(String[] args) {
		BoggleGUI gui = new BoggleGUI();
	}	
}
