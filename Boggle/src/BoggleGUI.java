import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class BoggleGUI extends JFrame implements ActionListener {
	

	
	// Dice BUttons. -- Possible to look into JToggleButton for dies?
	private JButton dieBtn1 = new JButton("letter1"); 
	private JButton dieBtn2 = new JButton("letter2"); 
	private JButton dieBtn3 = new JButton("letter3"); 
	private JButton dieBtn4 = new JButton("letter4"); 
	private JButton dieBtn5 = new JButton("letter5"); 
	private JButton dieBtn6 = new JButton("letter6"); 
	private JButton dieBtn7 = new JButton("letter7"); 
	private JButton dieBtn8 = new JButton("letter8"); 
	private JButton dieBtn9 = new JButton("letter9"); 
	private JButton dieBtn10 = new JButton("letter10"); 
	private JButton dieBtn11 = new JButton("letter11"); 
	private JButton dieBtn12 = new JButton("letter12"); 
	private JButton dieBtn13 = new JButton("letter13"); 
	private JButton dieBtn14 = new JButton("letter14"); 
	private JButton dieBtn15 = new JButton("letter15"); 
	private JButton dieBtn16 = new JButton("letter16"); 
	
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
		bottomPanel.add(timerBtn);
		
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
		
		System.out.println("A button has been clicked.");
		String clicker = e.getActionCommand();

		
		if (clicker == "letter1") {
			System.out.println("Button1 has been clicked");
			displayArea.setText(null);
			displayArea.append("Button1");
		} else if (clicker == "letter2") { 
			System.out.println("Button2 Has been clicked");
			displayArea.setText(null);
			displayArea.append("Button 2, clicked");
		}
		
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
		dieBtn13.addActionListener(this);
		dieBtn14.addActionListener(this);
		dieBtn15.addActionListener(this);
		dieBtn16.addActionListener(this);

	}
	
	
	// ============= Main ================
	public static void main(String[] args) {
		BoggleGUI gui = new BoggleGUI();
	}	
}
