
public class Driver //Test a change
{
    public static void main(String args[]) 
    {
    	
    	//Creates the trie
    	Trie tree = new Trie();
    	
    	//Imports the dictionary text file to the trie
    	tree.importDictionary();
    	
    	//Tests to see if the word is valid
    	System.out.println(tree.isWord("hello"));
    	System.out.println(tree.isWord("goodbye"));
    	System.out.println(tree.isWord("notaword"));

	}
}
