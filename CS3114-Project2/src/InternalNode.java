
/**
 * @author juliam8
 * @author abbym1
 * @version 2019-03-02
 *
 *          Internal Node Object
 *          This type of node stores the null pointer
 *          which every empty node points to. This has
 *          no children.
 *          Implements the DNA Tree Node Interface
 */

public class InternalNode implements DNATreeNode {

    /**
     * Default Constructor
     * Sets all child pointers to the flyweight
     */
    InternalNode() {
        a = new FlyweightNode();
        g = new FlyweightNode();
        c = new FlyweightNode();
        t = new FlyweightNode();
        cashMoney = new FlyweightNode();
    }


    /**
     * Inserts a node at a certain level
     * 
     * @param sequence
     *            the DNA sequence to insert
     * @param level
     *            the level at which the node is
     * @param print
     *            whether or not to print the inserted level
     * @return DNATreeNode that was inserted
     */
    public DNATreeNode insert(char[] sequence, int level, boolean print) {
        // set nodeLevel insertion for printing space purposes
        nodeLevel = level;
        if (level - 1 == sequence.length) {
            // create a new node, n, if lowest possible depth is reached
            LeafNode n = new LeafNode(sequence);
            if (print) {
                System.out.println(level);
            }
            setCashMoney(n);
        }
        // only print level if that is the place of insertion which is
        // dictated by whether the destination is a flyweight
        else if (sequence[level - 1] == 'A') {
            if (a.isFlyweight() && print) {
                System.out.println(level);
            }
            setA(a.insert(sequence, level + 1, print));
        }
        else if (sequence[level - 1] == 'C') {
            if (c.isFlyweight() && print) {
                System.out.println(level);
            }
            setC(c.insert(sequence, level + 1, print));
        }
        else if (sequence[level - 1] == 'G') {
            if (g.isFlyweight() && print) {
                System.out.println(level);
            }
            setG(g.insert(sequence, level + 1, print));
        }
        else if (sequence[level - 1] == 'T') {
            if (t.isFlyweight() && print) {
                System.out.println(level);
            }
            setT(t.insert(sequence, level + 1, print));
        }
        // return the altered tree
        return this;
    }


    /**
     * Traverses down to find leaf node to remove
     * 
     * @param sequence
     *            the sequence to remove
     * @param level
     *            the level at which the search is
     * @return the removed DNA tree node
     */
    public DNATreeNode remove(char[] sequence, int level) {
        // set the $ child if at same depth as length of sequence
        // recursively call each remove function with node types
        if (level - 1 == sequence.length) {
            setCashMoney(cashMoney.remove(sequence, level));
        }
        else if (sequence[level - 1] == 'A') {
            setA(a.remove(sequence, level + 1));
        }
        else if (sequence[level - 1] == 'C') {
            setC(c.remove(sequence, level + 1));
        }
        else if (sequence[level - 1] == 'G') {
            setG(g.remove(sequence, level + 1));
        }
        else if (sequence[level - 1] == 'T') {
            setT(t.remove(sequence, level + 1));
        }
        // check if the tree needs to be shrunk after removing the node
        return shrinkCheck();
    }


    /**
     * Shrinks the tree according to if there is one non flyweight
     * 
     * @return the DNA tree node that needs to be shrunk
     */
    private DNATreeNode shrinkCheck() {
        // return A child if a leaf and other children are flyweights
        if (!a.isFlyweight()) {
            if (g.isFlyweight() && c.isFlyweight() && t.isFlyweight()
                && cashMoney.isFlyweight() && a.isLeaf()) {
                return a;
            }
        }
        // return G child if a leaf and rest are flyweights
        else if (!g.isFlyweight()) {
            if (c.isFlyweight() && t.isFlyweight() && cashMoney.isFlyweight()
                && g.isLeaf()) {
                return g;
            }
        }
        // return C child if a leaf and rest are flyweights
        else if (!c.isFlyweight()) {
            if (t.isFlyweight() && cashMoney.isFlyweight() && c.isLeaf()) {
                return c;
            }
        }
        // return T child if a leaf and rest are flyweights
        else if (!t.isFlyweight()) {
            if (cashMoney.isFlyweight() && t.isLeaf()) {
                return t;
            }
        }
        else {
            // if all children are flyweights, just return flyweight
            if (cashMoney.isFlyweight()) {
                return new FlyweightNode();
            }
            // only $ is left to check if not a flyweight
            else if (!cashMoney.isFlyweight() && cashMoney.isLeaf()) {
                return cashMoney;
            }
        }
        // do not shrink if there is not an only leaf child
        return this;
    }


    /**
     * Finds a sequence
     * 
     * @param sequence
     *            the DNA sequence to find
     * @param level
     *            the level at which the search is
     * @param curSearch
     *            the search variables for this instance
     */
    public void search(char[] sequence, int level, SequenceSearch curSearch) {
        curSearch.incrementNumOfNodesVisited();
        // each variation of the node types are called each iteration
        if (level < sequence.length) {
            if (sequence[level] == 'A') {
                a.search(sequence, level + 1, curSearch);
            }
            else if (sequence[level] == 'C') {
                c.search(sequence, level + 1, curSearch);
            }
            else if (sequence[level] == 'G') {
                g.search(sequence, level + 1, curSearch);
            }
            else if (sequence[level] == 'T') {
                t.search(sequence, level + 1, curSearch);
            }
        }
        else if (level == sequence.length) {
            // if searching for exact match at this point just check $ branch
            if (curSearch.getExactMatch()) {
                cashMoney.search(sequence, level, curSearch);
            }
            else {
                // if not exact, search every child
                a.search(sequence, level, curSearch);
                c.search(sequence, level, curSearch);
                g.search(sequence, level, curSearch);
                t.search(sequence, level, curSearch);
                cashMoney.search(sequence, level, curSearch);
            }
        }
    }


    /**
     * Prints out an Internal Node key
     * 
     * @param len
     *            boolean whether or not to print length
     * @param stat
     *            boolean whether or not to print stats
     */
    public void print(boolean len, boolean stat) {
        // print out "I" once for this node
        System.out.println("I");
        // print out as many spaces as depth of node
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
        cashMoney.print(len, stat);
    }


    /**
     * Setter for A child
     * 
     * @param inA
     *            the DNA tree node to set as the A child
     */
    public void setA(DNATreeNode inA) {
        a = inA;
    }


    /**
     * Setter for G child
     * 
     * @param inG
     *            the DNA tree node to set as the G child
     */
    public void setG(DNATreeNode inG) {
        g = inG;
    }


    /**
     * Setter for C child
     * 
     * @param inC
     *            the DNA tree node to set as the C child
     */
    public void setC(DNATreeNode inC) {
        c = inC;
    }


    /**
     * Setter for T child
     * 
     * @param inT
     *            the DNA tree node to set as the T child
     */
    public void setT(DNATreeNode inT) {
        t = inT;
    }


    /**
     * Setter for cashMoney child
     * 
     * @param inCashMoney
     *            the DNA tree node to set as the cashMoney child
     */
    public void setCashMoney(DNATreeNode inCashMoney) {
        cashMoney = inCashMoney;
    }


    /**
     * Getter for a child
     * 
     * @return DNATreeNode a
     */
    public DNATreeNode a() {
        return a;
    }


    /**
     * Getter for g child
     * 
     * @return DNATreeNode g
     */
    public DNATreeNode g() {
        return g;
    }


    /**
     * Getter for c child
     * 
     * @return DNATreeNode c
     */
    public DNATreeNode c() {
        return c;
    }


    /**
     * Getter for t child
     * 
     * @return DNATreeNode t
     */
    public DNATreeNode t() {
        return t;
    }


    /**
     * Getter for cashMoney child
     * 
     * @return DNATreeNode t
     */
    public DNATreeNode getCashMoney() {
        return cashMoney;
    }


    /**
     * This is an internal node, not a leaf
     * 
     * @return false
     */
    public boolean isLeaf() {
        return false;
    }


    /**
     * This is an internal node, not a flyweight
     * 
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
     * Stores the cashMoney branch of the node
     */
    private DNATreeNode cashMoney;

}
