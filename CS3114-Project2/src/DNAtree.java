
//On my honor:
//
//-I have not used source code obtained from another student,
//or any other unauthorized source, either modified or
//unmodified.
//
//-All source code and documentation used in my program is
//either my original work, or was derived by me from the
//source code published in the textbook for this course.
//
//-I have not discussed coding details about this project with
//anyone other than my partner (in the case of a joint
//submission), instructor, ACM/UPE tutors or the TAs assigned
//to this course. I understand that I may discuss the concepts
//of this program with other students, and that another student
//may help me debug my program so long as neither of us writes
//anything during the discussion or modifies any computer file
//during the discussion. I have violated neither the spirit nor
//letter of this restriction.
//
//Signed: Abagale Rane Malone, Julia Mahon Kuzin

import java.io.File;
import java.io.FileNotFoundException;

/**
* @author abbym1 - Abagale Malone (abbym1@vt.edu)
* @author juliam8 - Julia Mahon Kuzin (juliam8@vt.edu)
* @version 2019-03-02
* This is the main class for CS3114 P2
*/

public class DNAtree {

  /**
   * This is the main function of project 2
   * Compiler: javac
   * JDK: 11.0.2
   * OS: Windows 10
   * Completed: 03/15/2019
   * @param args  input string array
   * @throws FileNotFoundException
   * 
   * 
   */
  public static void main(String[] args) throws FileNotFoundException{
      
          // myTree is the DNA tree used 
          // to store ACGT nodes
          Tree<DNATreeNode> myTree;
          myTree = new Tree<DNATreeNode>();
          
          // parse is a Parser object used to interpret the 
          // input file contents and execute commands
          Parser parse = new Parser(new File(args[0]), myTree);
          parse.execute();
      }
      // TODO Auto-generated method stub

  }