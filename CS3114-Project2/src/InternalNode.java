
/**
 * @author juliam8
 * @author abbym1
 * @version 2019-03-02
 * @param 
 * @param 
 *
 * Internal Node Object
 * *description*
 */

public class InternalNode implements DNATreeNode {
    
    /**
     * Default Constructor
     * Sets all child pointers to the flyweight
     */
    InternalNode(){
        a = new FlyweightNode();
        g = new FlyweightNode();
        c = new FlyweightNode();
        t = new FlyweightNode();
        $ = new FlyweightNode();
    }
    /**
     * Parameterized Constructor
     * @param inA
     * @param inC
     * @param inG
     * @param inT
     * @param in$
     */
    InternalNode(DNATreeNode inA, DNATreeNode inC, DNATreeNode inG, DNATreeNode inT, DNATreeNode in$){
        a = inA;
        c = inC;
        g = inG;
        t = inT;
        $ = in$;
    }
    
    /**
     * Inserts a node at a certain level
     * @param sequence the DNA sequence to insert
     * @param level the level at which the node is
     * @return DNATreeNode 
     */
    public DNATreeNode insert(char[] sequence, int level) {
        nodeLevel = level;
        if (level-1 == sequence.length) {
            LeafNode n = new LeafNode(sequence);
            set$(n);
        }
        else if (sequence[level-1] == 'A') {
            setA(a.insert(sequence, level + 1));
        }
        else if (sequence[level-1] == 'C') {
            setC(c.insert(sequence, level + 1));
        }
        else if (sequence[level-1] == 'G') {
            setG(g.insert(sequence, level + 1));
        }
        else if (sequence[level-1] == 'T') {
            setT(t.insert(sequence, level + 1));
        }
        return this;
    }
    
    public DNATreeNode remove(char[] sequence, int level) {
        if (level-1 == sequence.length) {
            set$($.remove(sequence, level));
            if(a.isFlyweight() && c.isFlyweight() &&
               g.isFlyweight() && t.isFlyweight())
                return $;
        }
        else if (sequence[level-1] == 'A') {
            setA(a.remove(sequence, level + 1));
            if($.isFlyweight() && c.isFlyweight() &&
               g.isFlyweight() && t.isFlyweight())
                return a;
        }
        else if (sequence[level-1] == 'C') {
            setC(c.remove(sequence, level + 1));
            if(a.isFlyweight() && $.isFlyweight() &&
               g.isFlyweight() && t.isFlyweight())
                return c;
        }
        else if (sequence[level-1] == 'G') {
            setG(g.remove(sequence, level + 1));
            if(a.isFlyweight() && c.isFlyweight() &&
               $.isFlyweight() && t.isFlyweight())
                return g;
        }
        else if (sequence[level-1] == 'T') {
            setT(t.remove(sequence, level + 1));
            if(a.isFlyweight() && c.isFlyweight() &&
               g.isFlyweight() && $.isFlyweight())
               return t;
        }
        return this;
    }
    
    /**
     * Finds a sequence
     * @param sequence the DNA sequence to find
     */
    public void search(char[] sequence, int level) {
        //if (level-1 == sequence.length) {
        //    LeafNode n = new LeafNode(sequence);
        //    search(n, level + 1);
        //}
        if (sequence[level-1] == 'A') {
            search(sequence, level + 1);
        }
        else if (sequence[level-1] == 'C') {
            search(sequence, level + 1);
        }
        else if (sequence[level-1] == 'G') {
            search(sequence, level + 1);
        }
        else if (sequence[level-1] == 'T') {
            search(sequence, level + 1);
        }
    }
    
    /**
     * Prints out an Internal Node key
     * @param len boolean whether or not to print length
     * @param stat boolean whether or not to print stats
     */
    public void print(boolean len, boolean stat) {
        System.out.println("I");
        for (int i = 0; i < nodeLevel; i++) {
            System.out.print("  ");
        }
        a.print(len, stat);
        
        for (int i = 0; i < nodeLevel; i++) {
            System.out.print("  ");
        }
        c.print(len, stat);
        
        for (int i = 0; i < nodeLevel; i++) {
            System.out.print("  ");
        }
        g.print(len, stat);
        
        for (int i = 0; i < nodeLevel; i++) {
            System.out.print("  ");
        }
        t.print(len, stat);
        
        for (int i = 0; i < nodeLevel; i++) {
            System.out.print("  ");
        }
        $.print(len, stat);
    }
    
    /**
     * Setter for A child
     * @param inA
     */
    public void setA(DNATreeNode inA) {
        a = inA;
    }
    
    /**
     * Setter for G child
     * @param inG
     */
    public void setG(DNATreeNode inG) {
        g = inG;
    }
    
    /**
     * Setter for C child
     * @param inC
     */
    public void setC(DNATreeNode inC) {
        c = inC;
    }
    
    /**
     * Setter for T child
     * @param inT
     */
    public void setT(DNATreeNode inT) {
        t = inT;
    }

    /**
     * Setter for $ child
     * @param in$
     */
    public void set$(DNATreeNode in$) {
        $ = in$;
    }
    
    
    /**
     * Getter for a child
     * @return DNATreeNode a 
     */
    public DNATreeNode a() {
        return a;
    }
    
    /**
     * Getter for g child
     * @return DNATreeNode g 
     */
    public DNATreeNode g() {
        return g;
    }
        
    /**
     * Getter for c child
     * @return DNATreeNode c
     */
    public DNATreeNode c() {
        return c;
    }
    
    /**
     * Getter for t child
     * @return DNATreeNode t
     */
    public DNATreeNode t() {
        return t;
    }
    
    /**
     * Getter for $ child
     * @return DNATreeNode t
     */
    public DNATreeNode $() {
        return $;
    }
    
    /**
     * This is an internal node, not a leaf
     * @return false
     */
    public boolean isLeaf() {
        return false;
    }
    
    /**
     * This is an internal node, not a flyweight
     * @return false
     */
    public boolean isFlyweight() {
        return false;
    }
    
    /**
     * Stores the level of the node
     */
    private int nodeLevel;
    
    /**
     * Stores the a branch of the node
     */
    private DNATreeNode a;
    /**
     * Stores the c branch of the node
     */
    private DNATreeNode c;
    /**
     * Stores the g branch of the node
     */
    private DNATreeNode g;
    /**
     * Stores the t branch of the node
     */
    private DNATreeNode t;
    /**
     * Stores the $ branch of the node
     */
    private DNATreeNode $;

}
