
// On my honor:
//
// -I have not used source code obtained from another student,
// or any other unauthorized source, either modified or
// unmodified.
//
// -All source code and documentation used in my program is
// either my original work, or was derived by me from the
// source code published in the textbook for this course.
//
// -I have not discussed coding details about this project with
// anyone other than my partner (in the case of a joint
// submission), instructor, ACM/UPE tutors or the TAs assigned
// to this course. I understand that I may discuss the concepts
// of this program with other students, and that another student
// may help me debug my program so long as neither of us writes
// anything during the discussion or modifies any computer file
// during the discussion. I have violated neither the spirit nor
// letter of this restriction.
//
// Signed: Abagale Rane Malone, Julia Mahon Kuzin

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author abbym1 - Abagale Malone (abbym1@vt.edu)
 * @author juliam8 - Julia Mahon Kuzin (juliam8@vt.edu)
 * @version 2019-03-02
 *          This is the main class for CS3114 Project 2
 *          
 *          This program runs commands that operate on a DNA
 *          tree. The DNA tree holds DNA sequences consisting of 
 *          A, C, T, and G, and these sequences can be as long or
 *          short as needed. The internal nodes within the tree
 *          have five children, being the A, C, T, G, and cashMoney
 *          children. For a node to be stored in the cashMoney child, 
 *          its sequence must exactly match its path. Valid commands 
 *          are insert, remove, search, print, print lengths, and 
 *          print stats. There is a singular interface from which 
 *          all three types of nodes inherit from. The types of nodes 
 *          are internal nodes, leaf nodes, and flyweight nodes. Leaf 
 *          nodes hold the actual DNA sequences, internal nodes 
 *          have pointers to each of the five children, and 
 *          flyweight nodes are null. Each flyweight node points 
 *          to the same null node as to not take up unnecessary 
 *          space within the program.        
 *          
 */

public class DNAtree {

    /**
     * This is the main function of project 2
     * Compiler: javac
     * JDK: 11.0.2
     * OS: Windows 10
     * Completed: 03/15/2019
     * 
     * @param args
     *            input string array
     * @throws FileNotFoundException
     * 
     * 
     */
    public static void main(String[] args) throws FileNotFoundException {
        // myTree is the DNA tree used DNA sequence nodes
        Tree<DNATreeNode> myTree;
        myTree = new Tree<DNATreeNode>();

        // parse is a Parser object used to interpret the
        // input file contents and execute commands
        Parser parse = new Parser(new File(args[0]), myTree);
        parse.execute();
    }
}
