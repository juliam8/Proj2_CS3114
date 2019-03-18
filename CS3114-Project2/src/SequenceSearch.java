/*
 * @author juliam8
 * @author abbym1
 * @version 2019-03-02
 * @param 
 * @param 
 *
 * SequenceFound Object
 * *description*
 */
public class SequenceSearch {
    
    /**
     * Increments number of nodes visited
     */
    public void incrementNumOfNodesVisited() {
        numberOfNodesVisited++;
    }
    
    public int getNumberOfNodesVisited() {
        return numberOfNodesVisited;
    }
    
    /**
     * Stores the number of nodes visited in this search instance
     */
    private int numberOfNodesVisited;
    
    /**
     * Is set based on whether the search is exact
     */
    public boolean exactMatch;
    
    /**
     * Is set based on whether a sequence is found
     */
    public boolean sequenceFound;
    

}
