
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
 
public class Trie {
    trieNode root;
   
    public Trie() {
        root = new trieNode();
    }
   
    public void insert(String word) {
        //creates node and sets it to root
        trieNode x = root;
 
        for(int i=0; i<word.length(); i++) {
            //gets numeric value for the current letter in the word
            char tempChar = word.charAt(i);
            int charValue = tempChar - 'a';
           
            //if the root nodes child array does not contain the current letter
            //it will create a new node and set it in the appropriate spot
            //of the child's array
            if (x.children[charValue]==null) {
                trieNode newNode = new trieNode();
                x.children[charValue]=newNode;
                x = newNode;
            }
           
            //if the current letter already exists set root equal to
            //the next letter
            else {
                x=x.children[charValue];
            }
        }
       
        //marks the end of the word in the node
        x.terminating=true;
    }
   
   
    public void importDictionary()
    {
                //While the current line in the text file isn't null it loops adding each word(line in text file)
                //to the Trie
                BufferedReader reader;
                try
                {
                    reader = new BufferedReader(new FileReader("src/dictionary.txt"));
                    String line = reader.readLine();
                    while (line != null)
                        {
                            this.insert(line);  //inserts word into the trie
                            line = reader.readLine();
                        }
                    reader.close();
                }
                catch (IOException e)
                {
                    System.out.println("ERROR: Invalid Dictionary File.");
                }
    }
   
    public boolean search(String word) {
        trieNode node = root;
        boolean endOfWord = false;
        for(int i=0; i<word.length(); i++)
        {
            if(node.children[word.charAt(i) - 97] != null)
            {
                node = node.children[word.charAt(i) - 97];
                endOfWord = true;
            }
           
            else {
                return false;
            }
        }
       
        if(endOfWord==true && node.terminating==true) {
            return true;
        }
        return false;
    }
   
 
    }