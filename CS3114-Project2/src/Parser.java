
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author juliam8
 * @author abbym1
 * @version 2019-03-02
 *
 * This object parses a file and interprets the contents according to
 * CS3114 Project 2 requirements
 */
public class Parser {
    /**
     * Parameterized constructor for the Parser class Sets the private member
     * variables mTree and mScan
     * 
     * @param inputFile     Path to the input file containing the commands
     * @param dnaTree       DNA tree associated with the parser object
     *                      and input file upon which the commands will be run
     */
    Parser(File inputFile, Tree<DNATreeNode> dnaTree) {
        try {
            mTree = dnaTree;
            mScan = new Scanner(inputFile);
        } 
        catch (FileNotFoundException e) {
            //Auto-generated catch block
            e.printStackTrace();
        }
    }
    

    /**
     * Parses each command from the input file using a Scanner 
     * calls the appropriate helper function(s) to execute each command
     */
    public void execute() {

        while (mScan.hasNext()) {
            // command holds the command string in the file
            //      which dictates the next action to take
            String command = mScan.next();

            if (command.equals("insert")) {
                insert();
            } 
            else if (command.equals("remove")) {
                remove();
            } 
            else if (command.equals("search")) {
                mTree.search(mScan.next().toCharArray());
            } 
            else if (command.equals("print")) {
                mTree.print();
            }
        }
        mScan.close();
    }
    
    /**
     * Checks input DNA sequence for validity
     * @param sequence     Input sequence
     * @return      True for a valid sequence, else False
     */
    private boolean validSequence(char[] sequence) {
        // validChars holds all valid characters for the sequence
        String validChars = "ACGT";
  
        for (int i = 0; i < sequence.length; ++i) {
            // j is a single character in the key
            String checkChar = Character.toString(sequence[i]);
            if (!validChars.contains(checkChar)) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Method to execute the BST insert command 
     * Accepts or rejects the input rectangle based on 0,0 1024,1024 bounds
     */
    private void insert() {
        // dna is the name of the sequence to insert
        String dna = mScan.next();
        // data is an array that holds the rectangle coordinates
        char[] sequence = dna.toCharArray();
        //seq is the String cast of sequence
        String seq = sequence.toString();
        
        //DNATreeNode newNode;
        //newNode = new LeafNode(sequence);
        
        if (!validSequence(sequence)) {
            System.out.println("sequence rejected: " + seq);
        }
        else if (mTree.search(sequence)) {
            System.out.println("sequence " + seq);
            System.out.println(" already exists");
        } 
        else {
            mTree.insert(sequence);
        }
    }


    /**
     * Remove the DNA sequence that is read in from the tree
     */
    private void remove() {
        // dna is the name of the sequence to remove
        String dna = mScan.next();
        // data is an array that holds the rectangle coordinates
        char[] sequence = dna.toCharArray();
       // DNATreeNode temp = null;// = mTree.remove(sequence);
        
       /* if (sequence == null) {
            System.out.print("sequence " + sequence.toString() );
            System.out.print(" does not exist");
        }
        else {
            System.out.print("sequence " + sequence.toString() );
            System.out.print(" removed");
        }*/
    }

    /**
     * This holds the scanner for the input file
     */
    private Scanner mScan;
    
    /**
     * This holds the tree commands are executed upon
     * made protected for testing purposes
     */
    protected Tree<DNATreeNode> mTree;
}

