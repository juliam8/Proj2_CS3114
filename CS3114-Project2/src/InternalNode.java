import java.util.Arrays;

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
     * sets all child pointers to the flyweight
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
     * @param sequence
     * @return DNATreeNode 
     */
    public DNATreeNode insert(char[] sequence, char[] modSeq) {
        if (modSeq.length == 0) {
            LeafNode n = new LeafNode(sequence);
            set$(n);
        }
        else if (modSeq[0] == 'A') {
            modSeq = Arrays.copyOfRange(modSeq, 1, modSeq.length);
            setA(a.insert(sequence, modSeq));
        }
        else if (modSeq[0] == 'C') {
            modSeq = Arrays.copyOfRange(modSeq, 1, modSeq.length);
            setC(c.insert(sequence, modSeq));
        }
        else if (modSeq[0] == 'G') {
            modSeq = Arrays.copyOfRange(modSeq, 1, modSeq.length);
            setG(g.insert(sequence, modSeq));
        }
        else if (modSeq[0] == 'T') {
            modSeq = Arrays.copyOfRange(modSeq, 1, modSeq.length);
            setT(t.insert(sequence, modSeq));
        }
        return this;
    }
    
    /**
     * Prints out an Internal Node key
     * @param node
     */
    public void print(DNATreeNode node) {
        System.out.println("I");
    }
    
    /**
     * @param inA
     */
    public void setA(DNATreeNode inA) {
        a = inA;
    }
    
    /**
     * @param inG
     */
    public void setG(DNATreeNode inG) {
        g = inG;
    }
    
    /**
     * @param inC
     */
    public void setC(DNATreeNode inC) {
        c = inC;
    }
    
    /**
     * @param inT
     */
    public void setT(DNATreeNode inT) {
        t = inT;
    }

    /**
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
