import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class BoggleGUI extends JFrame implements ActionListener {
	

	//Make the Dice
	private Dice die1 = new Dice(1); 
	private Dice die2 = new Dice(2);
	private Dice die3 = new Dice(3);
	private Dice die4 = new Dice(4);
	private Dice die5 = new Dice(5);
	private Dice die6 = new Dice(6);
	private Dice die7 = new Dice(7);
	private Dice die8 = new Dice(8);
	private Dice die9 = new Dice(9); 
	private Dice die10 = new Dice(10);
	private Dice die11 = new Dice(11);
	private Dice die12 = new Dice(12);
	private Dice die13 = new Dice(13);
	private Dice die14 = new Dice(14);
	private Dice die15 = new Dice(15);
	private Dice die16 = new Dice(16);
	
	//char variables to hold
	//randomly retrieved letter from dice
	private char letter1 = die1.getRandomSide(die1);
	private char letter2 = die2.getRandomSide(die2);
	private char letter3 = die3.getRandomSide(die3);
	private char letter4 = die4.getRandomSide(die4);
	private char letter5 = die5.getRandomSide(die5);
	private char letter6 = die6.getRandomSide(die6);
	private char letter7 = die7.getRandomSide(die7);
	private char letter8 = die8.getRandomSide(die8);
	private char letter9 = die1.getRandomSide(die9);
	private char letter10 = die2.getRandomSide(die10);
	private char letter11 = die3.getRandomSide(die11);
	private char letter12 = die4.getRandomSide(die12);
	private char letter13 = die5.getRandomSide(die13);
	private char letter14 = die6.getRandomSide(die14);
	private char letter15 = die7.getRandomSide(die15);
	private char letter16 = die8.getRandomSide(die16);
	
	// Dice BUttons. -- Possible to look into JToggleButton for dies?
	private JButton dieBtn1 = new JButton(String.valueOf(letter1)); 
	private JButton dieBtn2 = new JButton(String.valueOf(letter2)); 
	private JButton dieBtn3 = new JButton(String.valueOf(letter3)); 
	private JButton dieBtn4 = new JButton(String.valueOf(letter4)); 
	private JButton dieBtn5 = new JButton(String.valueOf(letter5)); 
	private JButton dieBtn6 = new JButton(String.valueOf(letter6)); 
	private JButton dieBtn7 = new JButton(String.valueOf(letter7)); 
	private JButton dieBtn8 = new JButton(String.valueOf(letter8)); 
	private JButton dieBtn9 = new JButton(String.valueOf(letter9)); 
	private JButton dieBtn10 = new JButton(String.valueOf(letter10)); 
	private JButton dieBtn11 = new JButton(String.valueOf(letter11)); 
	private JButton dieBtn12 = new JButton(String.valueOf(letter12)); 
	private JButton dieBtn13 = new JButton(String.valueOf(letter13)); 
	private JButton dieBtn14 = new JButton(String.valueOf(letter14)); 
	private JButton dieBtn15 = new JButton(String.valueOf(letter15)); 
	private JButton dieBtn16 = new JButton(String.valueOf(letter16)); 
	
	// More buttons. Separated for organizational purposes. 
	private JButton startBtn = new JButton("start");
	private JButton confirmWordBtn = new JButton("confirmWord");

	private JButton timerBtn = new JButton("Timer"); 

	
	// PANELS.
	private JPanel leftPanel = new JPanel(new GridLayout(4,4));
	private JPanel rightPanel = new JPanel(new GridLayout(2,1));
	private JPanel bottomPanel = new JPanel(new BorderLayout());
	private JPanel mainPanel = new JPanel(new BorderLayout());
	
	//
	private JTextArea displayArea = new JTextArea(4, 10);
	
    timer timer = new timer();
	
	private BoggleGUI () {
		// Window Requirements.
		super("Boggle");
		setSize(700, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		// Boggle Board is divided into three panels. 
		// Left for the dies
		// right for the UI
		// Bottom for the timer. 
		buildLeftPanel();
		buildRightPanel();
		buildBottomPanel();
		addPanelsToFrame();
		addListener();
				
		//IF YOU GUYS WANT TO MAKE TIMER
		//START WHEN GUI IS RAN, PUT 
		//timer.startTimer(); HERE
		setVisible(true);
	}
	



	// Die Panel.
	private void buildLeftPanel() {
		leftPanel.add(dieBtn1);
		leftPanel.add(dieBtn2);
		leftPanel.add(dieBtn3);
		leftPanel.add(dieBtn4);
		leftPanel.add(dieBtn5);
		leftPanel.add(dieBtn6);
		leftPanel.add(dieBtn7);
		leftPanel.add(dieBtn8);
		leftPanel.add(dieBtn9);
		leftPanel.add(dieBtn10);
		leftPanel.add(dieBtn11);
		leftPanel.add(dieBtn12);
		leftPanel.add(dieBtn13);
		leftPanel.add(dieBtn14);
		leftPanel.add(dieBtn15);
		leftPanel.add(dieBtn16);
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
		
		//Takes the 'String' variable from clicker
		//and converts it into a char so 
		//it may be compared to buttons
		char clickedBtn = clicker.charAt(0);
		
		if (clickedBtn == letter1) {
			displayArea.append("Button1");
		} else if (clickedBtn == letter2) {
			displayArea.append("Button2");
		} else if (clickedBtn == letter3) {
			displayArea.append("Button3");
		} else if (clickedBtn == letter4) {
			displayArea.append("Button4");
		} else if (clickedBtn == letter5) {
			displayArea.append("Button5");
		} else if (clickedBtn == letter6) {
			displayArea.append("Button6");
		} else if (clickedBtn == letter7) {
			displayArea.append("Button7");
		} else if (clickedBtn == letter8) {
			displayArea.append("Button8");
		} else if (clickedBtn == letter9) {
			displayArea.append("Button9");
		} else if (clickedBtn == letter10) {
			displayArea.append("Button10");
		} else if (clickedBtn == letter11) {
			displayArea.append("Button11");
		} else if (clickedBtn == letter12) {
			displayArea.append("Button12");
		} else if (clickedBtn == letter13) {
			displayArea.append("Button13");
		} else if (clickedBtn == letter14) {
			displayArea.append("Button14");
		} else if (clickedBtn == letter15) {
			displayArea.append("Button15");
		} else if (clickedBtn == letter16) {
			displayArea.append("Button16");
		} else if (clicker == "start"){
			timer.startTimer();
		}
		
		displayArea.append("\n");
	}
	
	
	
	// Making buttons click able.
	private void addListener() {
		
		// TESTING FOR OUTPUT
		// It will then go to the actionPerformed method. 
		dieBtn1.addActionListener(this);
		dieBtn2.addActionListener(this);
		dieBtn3.addActionListener(this);
		dieBtn4.addActionListener(this);
		dieBtn5.addActionListener(this);
		dieBtn6.addActionListener(this);
		dieBtn7.addActionListener(this);
		dieBtn8.addActionListener(this);
		dieBtn9.addActionListener(this);
		dieBtn10.addActionListener(this);
		dieBtn11.addActionListener(this);
		dieBtn12.addActionListener(this);
		dieBtn13.addActionListener(this);
		dieBtn14.addActionListener(this);
		dieBtn15.addActionListener(this);
		dieBtn16.addActionListener(this);
		
		startBtn.addActionListener(this);
		
		
	}
	
	
	// ============= Main ================
	public static void main(String[] args) {
		BoggleGUI gui = new BoggleGUI();
	}	
}
