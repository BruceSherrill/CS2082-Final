import java.util.Random;

public class Dice {

	//Double Array holds rolled chars like pseudo boggle board
	//where [x][y] and x being row and y being column
	private char[][] board  = new char[4][4];
	
	//Official Die Configuration
	private char[] die1 = {'R','I','F','O','B','X'};
	private char[] die2 = {'I','F','E','H','E','Y'};
	private char[] die3 = {'D','E','N','O','W','S'};
	private char[] die4 = {'U','T','O','K','N','D'};
	private char[] die5 = {'H','M','S','R','A','O'};
	private char[] die6 = {'L','U','P','E','T','S'};
	private char[] die7 = {'A','C','I','T','O','A'};
	private char[] die8 = {'Y','L','G','K','U','E'};
	private char[] die9 = {'Q','B','M','J','O','A'};
	private char[] die10 = {'E','H','I','S','P','N'};
	private char[] die11 = {'V','E','T','I','G','N'};
	private char[] die12 = {'B','A','L','I','Y','T'};
	private char[] die13 = {'E','Z','A','V','N','D'};
	private char[] die14 = {'R','A','L','E','S','C'};
	private char[] die15 = {'U','W','I','L','R','G'};
	private char[] die16 = {'P','A','C','E','M','D'};
	
	
	public char[][] getBoard() {
		return board;
	}
	public void setBoard(char[][] board) {
		this.board = board;
	}
	
	
	
	public char[] getDie1() {
		return die1;
	}
	public void setDie1(char[] die1) {
		this.die1 = die1;
	}
	public char[] getDie2() {
		return die2;
	}
	public void setDie2(char[] die2) {
		this.die2 = die2;
	}
	public char[] getDie3() {
		return die3;
	}
	public void setDie3(char[] die3) {
		this.die3 = die3;
	}
	public char[] getDie4() {
		return die4;
	}
	public void setDie4(char[] die4) {
		this.die4 = die4;
	}
	public char[] getDie5() {
		return die5;
	}
	public void setDie5(char[] die5) {
		this.die5 = die5;
	}
	public char[] getDie6() {
		return die6;
	}
	public void setDie6(char[] die6) {
		this.die6 = die6;
	}
	public char[] getDie7() {
		return die7;
	}
	public void setDie7(char[] die7) {
		this.die7 = die7;
	}
	public char[] getDie8() {
		return die8;
	}
	public void setDie8(char[] die8) {
		this.die8 = die8;
	}
	public char[] getDie9() {
		return die9;
	}
	public void setDie9(char[] die9) {
		this.die9 = die9;
	}
	public char[] getDie10() {
		return die10;
	}
	public void setDie10(char[] die10) {
		this.die10 = die10;
	}
	public char[] getDie11() {
		return die11;
	}
	public void setDie11(char[] die11) {
		this.die11 = die11;
	}
	public char[] getDie12() {
		return die12;
	}
	public void setDie12(char[] die12) {
		this.die12 = die12;
	}
	public char[] getDie13() {
		return die13;
	}
	public void setDie13(char[] die13) {
		this.die13 = die13;
	}
	public char[] getDie14() {
		return die14;
	}
	public void setDie14(char[] die14) {
		this.die14 = die14;
	}
	public char[] getDie15() {
		return die15;
	}
	public void setDie15(char[] die15) {
		this.die15 = die15;
	}
	public char[] getDie16() {
		return die16;
	}
	public void setDie16(char[] die16) {
		this.die16 = die16;
	}
	
	
	
	//A method that retrieves a letter from each individual die
	public char rollDice(char[] die) {
		
		//Will randomly generate a number following (0 <= x < 6 )
		int dieSide = new Random().nextInt(6);
		
		return die[dieSide];
	}
	
	
	//Sets the array that will pass char's to the board
	public void setBoardArray() {
		
		//Increment that ensures each die is rolled and set to proper space on board
		int counter = 0;
		
		//Two loops that steps through double array that represents board spaces
		for(int x = 0; x < 4; x++) {
			for(int y = 0; y < 4; y++) {
				
				switch (counter) {
				
				case 0:
					board[x][y] = rollDice(getDie1());
					counter++;
					break;
				case 1:
					board[x][y] = rollDice(getDie2());
					counter++;
					break;
				case 2:
					board[x][y] = rollDice(getDie3());
					counter++;
					break;
				case 3:
					board[x][y] = rollDice(getDie4());
					counter++;
					break;
				case 4:
					board[x][y] = rollDice(getDie5());
					counter++;
					break;
				case 5:
					board[x][y] = rollDice(getDie6());
					counter++;
					break;
				case 6:
					board[x][y] = rollDice(getDie7());
					counter++;
					break;
				case 7:
					board[x][y] = rollDice(getDie8());
					counter++;
					break;
				case 8:
					board[x][y] = rollDice(getDie9());
					counter++;
					break;
				case 9:
					board[x][y] = rollDice(getDie10());
					counter++;
					break;
				case 10:
					board[x][y] = rollDice(getDie11());
					counter++;
					break;
				case 11:
					board[x][y] = rollDice(getDie12());
					counter++;
					break;
				case 12:
					board[x][y] = rollDice(getDie13());
					counter++;
					break;
				case 13:
					board[x][y] = rollDice(getDie14());
					counter++;
					break;
				case 14:
					board[x][y] = rollDice(getDie15());
					counter++;
					break;
				case 15:
					board[x][y] = rollDice(getDie16());
					counter++;
					break;
				}
			}
		}
		
	}
	
	
	//A method to test each 'board' cell of the board array is initialized
	public void testBoardArray() {
		
		for(int x = 0; x < 4; x++) {
			for(int y = 0; y < 4; y++) {
				
				System.out.print(board[x][y] + " ");
				
			}
			System.out.println();
		}
		
	}
	
	
	public static void main(String[] args) {
		
		Dice demo = new Dice();
		
		demo.setBoardArray();
		demo.testBoardArray();
	}
	
	
	
	
	
	
}
