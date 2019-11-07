
public class board {

	//Double Array holds rolled chars like pseudo boggle board
	//where [x][y] and x being row and y being column
	private char[][] board  = new char[4][4];
	
	//Overloaded Constructor
	board(){
		
		Dice die1 = new Dice(1);
		Dice die2 = new Dice(2);
		Dice die3 = new Dice(3);
		Dice die4 = new Dice(4);
		Dice die5 = new Dice(5);
		Dice die6 = new Dice(6);
		Dice die7 = new Dice(7);
		Dice die8 = new Dice(8);
		Dice die9 = new Dice(9);
		Dice die10 = new Dice(10);
		Dice die11 = new Dice(11);
		Dice die12 = new Dice(12);
		Dice die13 = new Dice(13);
		Dice die14 = new Dice(14);
		Dice die15 = new Dice(15);
		Dice die16 = new Dice(16);
		
		//Increment that ensures each die is rolled and set to proper space on board
				int counter = 0;
				
				//Two loops that steps through double array that represents board spaces
				for(int x = 0; x < 4; x++) {
					for(int y = 0; y < 4; y++) {
						
						switch (counter) {
						
						case 0:
							board[x][y] = rollDice(die1);
							counter++;
							break;
						case 1:
							board[x][y] = rollDice(die2);
							counter++;
							break;
						case 2:
							board[x][y] = rollDice(die3);
							counter++;
							break;
						case 3:
							board[x][y] = rollDice(die4);
							counter++;
							break;
						case 4:
							board[x][y] = rollDice(die5);
							counter++;
							break;
						case 5:
							board[x][y] = rollDice(die6);
							counter++;
							break;
						case 6:
							board[x][y] = rollDice(die7);
							counter++;
							break;
						case 7:
							board[x][y] = rollDice(die8);
							counter++;
							break;
						case 8:
							board[x][y] = rollDice(die9);
							counter++;
							break;
						case 9:
							board[x][y] = rollDice(die10);
							counter++;
							break;
						case 10:
							board[x][y] = rollDice(die11);
							counter++;
							break;
						case 11:
							board[x][y] = rollDice(die12);
							counter++;
							break;
						case 12:
							board[x][y] = rollDice(die13);
							counter++;
							break;
						case 13:
							board[x][y] = rollDice(die14);
							counter++;
							break;
						case 14:
							board[x][y] = rollDice(die15);
							counter++;
							break;
						case 15:
							board[x][y] = rollDice(die16);
							counter++;
							break;
						}
					}
				}
		
		
	}
	
	//A method that retrieves a letter from each individual die
	public char rollDice(Dice die) {
		char x = 0;
		x = die.getRandomSide(die);		
		return x;	
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
	
	
	public static void main (String[] args) {
		
		board board = new board();
		board.testBoardArray();
		
	}
	
	
	
}