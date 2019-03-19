/**
 * @author juliam8
 * @author abbym1
 * @version 2019-03-02
 *
 *      SequenceSearch Object
 *      
 * This object:
 * 1. Stores boolean data utilized during the searching process. 
 *      There are booleans to indicate if the search is for
 *      an exact match, if the output should be printed, and if
 *      the sequence has been found.
 * 2. Keeps track of the number of nodes that have been visited
 *    in the current search
 */
public class SequenceSearch {
    
    /**
     * Increments number of nodes visited
     */
    public void incrementNumOfNodesVisited() {
        numberOfNodesVisited++;
    }
    
    /**
     * Gets the number of nodes visited
     * @return the number of nodes visited in this search instance
     */
    public int getNumberOfNodesVisited() {
        return numberOfNodesVisited;
    }
    
    /**
     * Set whether this search instance is for an exact match
     * @param match boolean set if exact match search instance
     */
    public void setExactMatch(boolean match) {
        exactMatch = match;
    }
    
    /**
     * Gets private boolean for exact match
     * @return whether this search instance is for an exact match
     */
    public boolean getExactMatch() {
        return exactMatch;
    }
    
    /**
     * Set whether this search instance is for insertion check
     * @param insert boolean set if insertion search instance
     */
    public void setInsertCheck(boolean insert) {
        insertCheck = insert;
    }
    
    /**
     * Gets private variable for insertion check
     * @return whether this search instance is for an insertion check
     */
    public boolean getInsertCheck() {
        return insertCheck;
    }
    
    /**
     * Set whether the sequence has been found for this search instance
     * @param found boolean set if sequence has been found in this search
     */
    public void setSequenceFound(boolean found) {
        sequenceFound = found;
    }
    
    /**
     * @return whether the sequence has been found for this search instance
     */
    public boolean getSequenceFound() {
        return sequenceFound;
    }
    
    /**
     * Stores the number of nodes visited in this search instance
     */
    private int numberOfNodesVisited;
    
    /**
     * Is set based on whether the search is exact
     */
    private boolean exactMatch;
    
    /**
     * Is set based on whether the search is for the insert method
     */
    private boolean insertCheck;
    
    /**
     * Is set based on whether a sequence is found
     */
    private boolean sequenceFound;
    

}
