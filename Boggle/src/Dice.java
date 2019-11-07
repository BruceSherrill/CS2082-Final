import java.util.Random;

public class Dice {

	//The die
	private char[] arrayOfDieSides = {'x','x','x','x','x','x'};
	
	//Potential Side labels (Depending on die number)
	final private char[] die1 = {'R','I','F','O','B','X'};
	final private char[] die2 = {'I','F','E','H','E','Y'};
	final private char[] die3 = {'D','E','N','O','W','S'};
	final private char[] die4 = {'U','T','O','K','N','D'};
	final private char[] die5 = {'H','M','S','R','A','O'};
	final private char[] die6 = {'L','U','P','E','T','S'};
	final private char[] die7 = {'A','C','I','T','O','A'};
	final private char[] die8 = {'Y','L','G','K','U','E'};
	final private char[] die9 = {'Q','B','M','J','O','A'};
	final private char[] die10 = {'E','H','I','S','P','N'};
	final private char[] die11 = {'V','E','T','I','G','N'};
	final private char[] die12 = {'B','A','L','I','Y','T'};
	final private char[] die13 = {'E','Z','A','V','N','D'};
	final private char[] die14 = {'R','A','L','E','S','C'};
	final private char[] die15 = {'U','W','I','L','R','G'};
	final private char[] die16 = {'P','A','C','E','M','D'};
	
	

	//Default Constructor
	Dice(){
	}
	
	//Overloaded Constructor
	Dice(int dieNum){
		
		
		//Switch statement that will assign the die characters 
		//depending on which die is calling the method.
		//Example: If 1 is being passed, you are trying to set the 
		//sides of the die for the top left corner. If 2, the following die
		//to the right of one will be set and so on and so forth
		switch (dieNum) {
		
		case 1: 
			System.arraycopy(die1, 0, arrayOfDieSides, 0, arrayOfDieSides.length);
			break;
		case 2: 
			System.arraycopy(die2, 0, arrayOfDieSides, 0, arrayOfDieSides.length);
			break;
		case 3: 
			System.arraycopy(die3, 0, arrayOfDieSides, 0, arrayOfDieSides.length);
			break;
		case 4: 
			System.arraycopy(die4, 0, arrayOfDieSides, 0, arrayOfDieSides.length);
			break;
		case 5: 
			System.arraycopy(die5, 0, arrayOfDieSides, 0, arrayOfDieSides.length);
			break;
		case 6: 
			System.arraycopy(die6, 0, arrayOfDieSides, 0, arrayOfDieSides.length);
			break;
		case 7: 
			System.arraycopy(die7, 0, arrayOfDieSides, 0, arrayOfDieSides.length);
			break;
		case 8: 
			System.arraycopy(die8, 0, arrayOfDieSides, 0, arrayOfDieSides.length);
			break;
		case 9: 
			System.arraycopy(die9, 0, arrayOfDieSides, 0, arrayOfDieSides.length);
			break;
		case 10: 
			System.arraycopy(die10, 0, arrayOfDieSides, 0, arrayOfDieSides.length);
			break;
		case 11: 
			System.arraycopy(die11, 0, arrayOfDieSides, 0, arrayOfDieSides.length);
			break;
		case 12: 
			System.arraycopy(die12, 0, arrayOfDieSides, 0, arrayOfDieSides.length);
			break;
		case 13: 
			System.arraycopy(die13, 0, arrayOfDieSides, 0, arrayOfDieSides.length);
			break;
		case 14: 
			System.arraycopy(die14, 0, arrayOfDieSides, 0, arrayOfDieSides.length);
			break;
		case 15: 
			System.arraycopy(die15, 0, arrayOfDieSides, 0, arrayOfDieSides.length);
			break;
		case 16: 
			System.arraycopy(die16, 0, arrayOfDieSides, 0, arrayOfDieSides.length);
			break;
		default: 
			System.out.println("Provide constructor with # from 1 to 16"
					+ "or sides will default to 'x'");
			
		}
		
	}
	
	
	//A method that retrieves a letter from each individual die
		public char getRandomSide(Dice die) {
				
		//Will randomly generate a number following (0 <= x < 6 )
		int dieSide = new Random().nextInt(6);
				
		return arrayOfDieSides[dieSide];
		}
		
	
	//Test to show sides are assigned properly
	public void showDieSides() {
		int x = 0;
		while(x < arrayOfDieSides.length) {
			System.out.println(arrayOfDieSides[x]);
			x++;
		}
		
	}
	
	
	public static void main (String[] args) {
		Dice firstDie = new Dice(1);
		Dice die2 = new Dice(88);
		firstDie.showDieSides();
		die2.showDieSides();
	}
	
}
