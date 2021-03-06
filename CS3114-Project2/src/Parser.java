
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author juliam8
 * @author abbym1
 * @version 2019-03-02
 *
 *          This object parses a file and interprets the contents according to
 *          CS3114 Project 2 requirements
 */
public class Parser {
    /**
     * Parameterized constructor for the Parser class Sets the private member
     * variables mTree and mScan
     * 
     * @param inputFile
     *            Path to the input file containing the commands
     * @param dnaTree
     *            DNA tree associated with the parser object
     *            and input file upon which the commands will be run
     */
    Parser(File inputFile, Tree<DNATreeNode> dnaTree) {
        try {
            mTree = dnaTree;
            mScan = new Scanner(inputFile);
        }
        catch (FileNotFoundException e) {
            // Auto-generated catch block
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
            // which dictates the next action to take
            String command = mScan.next();

            if (command.equals("insert")) {
                insert();
            }
            else if (command.equals("remove")) {
                remove();
            }
            else if (command.equals("search")) {
                char[] sequence = mScan.next().toCharArray();
                search(sequence);
            }
            else if (command.equals("print")) {
                print();
            }
        }
        mScan.close();
    }

    /**
     * Method to execute the DNA tree insert command
     */
    private void insert() {
        // dna is the name of the sequence to insert
        String dna = mScan.next();
        // data is an array that holds the rectangle coordinates
        char[] sequence = dna.toCharArray();
        
        // do not insert if sequence already exists
        if (checkIfExists(sequence)) {
            System.out.print("sequence ");
            System.out.print(sequence);
            System.out.println(" already exists");
        }
        else {
            System.out.print("sequence ");
            System.out.print(sequence);
            System.out.print(" inserted at level ");
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

        if (checkIfExists(sequence)) {
            mTree.remove(sequence);
            System.out.print("sequence " + dna);
            System.out.println(" removed");
        }
        // only remove if it exists
        else {
            System.out.print("sequence " + dna);
            System.out.println(" does not exist");
        }
    }


    /**
     * Print the nodes within the DNA tree
     */
    private void print() {
        System.out.println("tree dump:");

        if (mScan.hasNext("lengths")) {
            mScan.next();
            // first boolean set if wanting to print the sequence length
            mTree.print(true, false);
        }
        else if (mScan.hasNext("stats")) {
            mScan.next();
            // second boolean set if wanting to print percentages
            mTree.print(false, true);
        }
        else {
            // both booleans false if command is just "print"
            mTree.print(false, false);
        }
    }


    /**
     * Searches for a sequence within tree
     * 
     * @param sequence
     *            the DNA sequence to search for
     */
    private void search(char[] sequence) {
        // instance of class holding search members
        SequenceSearch curSearch = new SequenceSearch();
        // set beginning values for search members
        curSearch.setSequenceFound(false);
        curSearch.setExactMatch(false);
        curSearch.setInsertCheck(false);
        // get the index of the last element in array
        int lastChar = sequence.length - 1;
        // set boolean to true if it should be an exact match
        if (sequence[lastChar] == '$') {
            curSearch.setExactMatch(true);
            // delete the $ symbol from sequence
            sequence = Arrays.copyOf(sequence, sequence.length - 1);
        }
        mTree.search(sequence, curSearch);
        if (!curSearch.getSequenceFound()) {
            System.out.println("no sequence found");
        }
        System.out.print("# of nodes visited: ");
        System.out.println(curSearch.getNumberOfNodesVisited());
    }


    /**
     * Checks if a sequence exists within tree, used in remove and insert
     * 
     * @param sequence
     *            the sequence to check for existence
     * @return a boolean that is set if sequence exists
     */
    private boolean checkIfExists(char[] sequence) {
        // instance of class holding search members
        SequenceSearch curSearch = new SequenceSearch();
        // set beginning values for search members
        curSearch.setSequenceFound(false);
        curSearch.setExactMatch(true);
        curSearch.setInsertCheck(true);

        mTree.search(sequence, curSearch);
        // just checks if sequence already exists
        return curSearch.getSequenceFound();
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
