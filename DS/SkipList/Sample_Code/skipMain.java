/*
Part of the algoviz@vt collection of algorithm visualizations.
Copyright (C) 2007  Virginia Tech Department of Computer Science

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
*/

/********************************************************************************/
/* The following class is written by Purvi Saraiya.
It  performs the graphics routines for animating the skip list algorithm*/
/********************************************************************************/

import javax.swing.*;
import javax.swing.BorderFactory.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.lang.Integer;
import javax.swing.JComponent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.*;
import javax.swing.text.JTextComponent;

// This class lays the interface for the skip list

class setUp implements ActionListener
{
  JFrame frame; //The main frame for the system
  Container contentpane; //The container for the syste
  
  JPanel bottomPanel; // The bottom panel having all the buttons to control the user interaction
  
  JTextField Input; // The input field to enter the number to insert in the skip list
  JButton Enter; // The button to show that user wants to enter the number in the skip list
  JButton Next; // To step through the algorithm
  JButton Restart; // To restart the system
  JButton Help; // To display the help file for this system
  JButton Search; // The button to show that user wants to implement the search operation for the number that is entered
  
  JPanel textPanel; // The panel for the text field
  JTextPane textPane;// The text field to display the message strings
  
  String displayText[]; // The array containing the feedback messages
  int displayPointer; // To keep track of the messages
  JScrollPane TextAreaScrollPane; // scrollpane for the text field
  
  Document doc;  //The document for the jtextpane
  // The various styles to display different types of text messages..
  String [] Styles = { "Blue", "Red", "Orange", "red", "blue" };
  Style def;
  Style Blue;
  Style Red;
  Style Orange;
  Style red;
  Style blue;
  
  int buttonWidth; // To make all the buttons have fixed width
  int buttonHeight; // TO make all the buttons have fixed height
  int screenwidth; // To store the screen width of the system
  int screenheight; // To store the height of the system
  
  drawSkip draw; // draws the skiplist
  SkipList skip; // the skiplist on which operation are performed
  Instructions instruction; // The class that displays the instructions for this skiip list
    
  int ElementEntered; // to insert an element into the skipList.
  int SearchKey; // to search for an element in the skipList.
  String AlgoSelected = null; // To store the operation that user wants to perform on the skiplist
  int Length =0; //The length of the skip list
      
  // Constructor for this class
  public setUp ( )
  {
  	frame = new JFrame ( );
    bottomPanel = new JPanel ( );
    
    contentpane = frame.getContentPane ( ); // The container for the main frame
    contentpane.setLayout (null); // Setting the layout to null
    
    buttonWidth = 70; // making all the buttons have fixed width
    buttonHeight = 70; // Making all the buttons have fixed height
        
    // The following lines allow the user to create the buttons        
    Enter = new JButton ( "Input" );
    Enter.setActionCommand ( "Enter" );
    
    Restart = new JButton ( "Restart" );
    Restart.setActionCommand ( "Restart" );
    
    Next = new JButton ( "Next" );
    Next.setActionCommand ( "Next" );
    
    Input = new JTextField ( 5 );
    
    Help = new JButton ( "Help" );
    Help.setActionCommand ( "Help" );
    
    Search = new JButton ( "Search" );
    Search.setActionCommand ( "Search" );
    
    // Setting the intial state of each button
    
    Enter.setEnabled ( true );
    Restart.setEnabled ( true );
    Input.setEditable ( true );
    Input.setEnabled ( true );
    Next.setEnabled ( false );
    Search.setEnabled ( false );
    
    // Creating new font for the buttons
    
    Font F = new Font ( "Arial", Font.PLAIN, 17 );
    Font newfont = new Font ( "Arial", Font.PLAIN, 9 );
    
    // Setting the fonts to display the labels for each button
    
    Input.setFont ( F );
    Enter.setFont ( newfont );
    Restart.setFont ( newfont );
    Next.setFont ( newfont );
    Help.setFont ( newfont );
    Search.setFont ( newfont );
    
    // Adding action listener to all the buttons
    
    Input.addActionListener ( this );
    Enter.addActionListener ( this );
    Restart.addActionListener ( this );
    Next.addActionListener ( this );
    Help.addActionListener ( this );
    Search.addActionListener ( this );
    
    // creating the text field
    textPane = new JTextPane ( );
    textPane.setEditable ( false );
    textPane.setRequestFocusEnabled ( true );
    textPane.setText ( " " );
    
    // Display the screen based on the display screen width and height.
    
    // creates a tool kit to get the screen dimension
    Toolkit tk = Toolkit.getDefaultToolkit ( );
    Dimension d = tk.getScreenSize ( );

    screenheight = d.height - 40;
    screenwidth = d.width - 40;

    // Draw creates the image to perform the graph routines         
    draw = new drawSkip ( screenwidth-3 , screenheight*5/8 );
    draw.setLocation ( 0,2 );    
    
    // creates a null skip list because no nodes initially
    skip = new SkipList ( );
    
    //Setting the location of the bottompanel
    bottomPanel.setSize ( screenwidth , screenheight/8-20 );
    bottomPanel.setLocation ( 1,screenheight*7/8 );
    
    // setting the position of the text field
    double posx  = 0;
    double posy = 2.0/8.0 * screenheight;
    double sizex = screenwidth;
    
    int positionX = (int) posx;
    int positionY = (int) posy;
    int sizeX = (int) sizex;
   
    double XX =  screenwidth;
    double YY =  screenheight*5.0/8.0+2;
    int xX = ( int ) XX;
    int yY = ( int ) YY;
    
    //Adding the textfield to the panel
    TextAreaScrollPane = new JScrollPane ( textPane );
    TextAreaScrollPane.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    TextAreaScrollPane.setPreferredSize ( new Dimension ( sizeX-20, positionY-5) );
    
    textPanel = new JPanel ( );
    
    // setting position of the text field
    textPanel.add ( TextAreaScrollPane );
    textPanel.setLocation ( 0,yY );
    textPanel.setSize ( xX, positionY );//Panel for ScrollPane.        
    
    // adding various buttons to the bottom panel
    bottomPanel.add ( Input );
    bottomPanel.add ( Enter );
    bottomPanel.add ( Search );
    bottomPanel.add ( Next );
    bottomPanel.add ( Restart );
    bottomPanel.add ( Help );

    frame.addWindowListener ( new WindowAdapter ( ) // for closing the frame..
    {
      public void windowClosing ( WindowEvent e )
      {
        System.exit ( 0 );	
      }
    });
    
    doc = textPane.getDocument ( );

	// creating various styles to display the text
	def = StyleContext.getDefaultStyleContext ( ).
                                        getStyle ( StyleContext.DEFAULT_STYLE ); 
                                        
	// To display the text strings in simple blue having font size of 14                                                                                                                       
    Blue = textPane.addStyle ( "Blue",def );
    StyleConstants.setForeground ( Blue, Color.blue );
    StyleConstants.setFontFamily ( Blue, "Arial" );
    StyleConstants.setFontSize ( Blue, 14 );
    
    // To display the text strings in blue having font size of 14 and bold
    blue = textPane.addStyle ( "blue",def );
        
    StyleConstants.setForeground ( blue, Color.blue );
    StyleConstants.setFontFamily ( blue, "Arial" );
    StyleConstants.setFontSize ( blue, 14 );
    StyleConstants.setBold ( blue, true );

	// To display the text in red bold and having font size of 14
    Red = textPane.addStyle ( "Red", def );
    StyleConstants.setForeground ( Red, Color.red );
    StyleConstants.setAlignment( Red, StyleConstants.ALIGN_CENTER); 
    StyleConstants.setFontFamily ( Red, "Arial" );
    StyleConstants.setFontSize ( Red, 14 );
    StyleConstants.setBold ( Red, true );
    
    // To display the text in orange having font size of 14
    Orange = textPane.addStyle ( "Orange", def );
    StyleConstants.setForeground ( Orange, Color.orange );
    StyleConstants.setFontFamily ( Orange, "Arial" );
    StyleConstants.setFontSize ( Orange, 14 ); 
    
    // To display the text in red having font size of 14 and not bold
    red = textPane.addStyle ( "red", def );
    StyleConstants.setForeground ( red, Color.red );
    StyleConstants.setFontFamily ( red, "Arial" );
    StyleConstants.setFontSize ( red, 14 );
    StyleConstants.setBold ( red, false );
    
    // the message strings
    displayText = new String [1000];
    displayText [displayPointer++ ] = "The Skip List is currently empty.\n Enter an element to start the animation.";        
    Message ( "Red" );

    contentpane.add ( draw );
    contentpane.add ( bottomPanel );
    contentpane.add ( textPanel );
    
    // setting the size of the main frame and adding title to the main frame
    frame.setTitle ( "Closed Hash Algorithms.." );
    frame.setSize ( screenwidth,screenheight );
    frame.setVisible ( true );
  }

/**********************************************************************************/
 /* The following function is called each time any button is pressed and performs 
 appropriate function depending on which button is pressed*/  
/**********************************************************************************/    

  public void actionPerformed ( ActionEvent ae )
  {   
  	String message = null;
  	message = ae.getActionCommand ( );

    // If the user selects the button to enter the number
  	if ( message.equals ( "Enter" ) )
  	{
  	  String text = null;
  	  try
  	  {
  	  	AlgoSelected = "Insert"; // Set the algorithm that is selected
  	  	text = Input.getText ( ).trim ( );
  	    Input.setText ( " " ); // Reset the text in the input field
  	    ElementEntered = Integer.parseInt ( text ); // Get the number that is entered
		
		// Gives the user feedback
		displayText [displayPointer++] = "\n The number entered is " + text;
		Message ( "Blue" );
		
		// For the proper display of the string 
     	int length = doc.getLength ();
     	// To change the display of the text area to the most recently inserted string.
		textPane.setCaretPosition ( length );        
		Length++;
		
		// Insert the the first element
		if ( Length == 1 )
		{
		  skip.insert ( new IElem ( ElementEntered ) );
  	      draw.drawSkipList ( skip ); // start drawing the list when the first element is inserted
		}
		else
		{
		  // The insertion of the other elements take place in the drawSKip class
		  draw.drawSearch ( skip, ElementEntered,AlgoSelected );
		  
		  // Reset and set the other buttons to control the user input.
		  Search.setEnabled ( false );
		  Input.setEditable ( false );
		  Input.setEnabled ( false );
		  Enter.setEnabled ( false );
		  Next.setEnabled ( true );
		}  	    		
  	  } 
  	  catch ( NumberFormatException e )
  	  {
  	    displayText[displayPointer++] = "\nThe number is not entered properly";
  	    Message ("Red" );
  	  }
  	}
  	
  	// If the user has selected the search algorithm
  	if ( message.equals ( "Search" )  )
  	{
  	  try
  	  {  
  	    AlgoSelected = "Search"; // Set the selected algorithm to the search 
	    String textEntered = null;
	    textEntered = Input.getText ( ).trim ( );
	    
	    // Get the number that is entered
	    SearchKey = Integer.parseInt ( textEntered );
		displayText [displayPointer++] = "\nThe number being searched is " + textEntered;
		
		// Set the current display to the most recent text that is entered.
		Message ( "Blue" );
    	int length = doc.getLength ();
		textPane.setCaretPosition ( length );
		
		// Animate the search steps
	    draw.drawSearch ( skip, SearchKey,AlgoSelected );
	    	
	    // Control the user interaction		
		Next.setEnabled ( true );
		Search.setEnabled ( false );
		Input.setEditable ( false );
		Input.setEnabled ( false );
		Enter.setEnabled ( false );
	  } 
	  catch ( NumberFormatException e )
	  {
	  	displayText [displayPointer++] = "\nThe Search Key is not entered properly";
	  	Message ( "Red" );
		int length = doc.getLength ();
    	textPane.setCaretPosition ( length );
	  }
  	}  	  	
  	
  	if ( message.equals ( "Restart" ) )
  	{	 
  	  // remove the old display of the skip lists  	  
	  contentpane.remove ( draw );
	  draw = null; 
	  skip = null;	  
	  
	  // Store the message strings to display
	  displayText = null;
	  displayPointer =0;
	  displayText = new String [ 500];
	  
	  // remove the old text messages from the text pane.
	  textPane.setText ( " " );
	  
	  // set the position of the graphics display
	  draw = new drawSkip ( screenwidth-3 , screenheight*5/8 );	  
      draw.setLocation ( 0,2 );   
      
      // Add the new display to the contentpane 
	  contentpane.add ( draw );
	  frame.validate ( );
	  contentpane.repaint ( );
	  
	  // Start with a new skip list
      skip = new SkipList ( );
	  displayText [displayPointer++] = "The skipList is currently empty\n";
	  Message ( "Red" );
	  
	  // Set the position of the text pane to the most recently inserted text
      int length = doc.getLength ();
	  textPane.setCaretPosition ( length );
	  Next.setEnabled ( false );
	  Search.setEnabled ( false );
	  Input.setEnabled ( true );
	  Input.setEditable ( true );
	  Enter.setEnabled ( true );
  	}
  	 
  	// step through the algorithm 	
  	if ( message.equals ( "Next" ) )
  	{		
	  boolean value;	  
	  value =  draw.drawNext ( );	  	  
	  
	  // If there is any more steps to be animated
	  if ( value )
	  {
		 Next.setEnabled ( false );
		 Search.setEnabled ( true );
		 Input.setEnabled ( true );
		 Input.setEditable ( true );
		 Enter.setEnabled ( true );
		 
		 // Get rid of the old highlighted step
		 draw.ResetSearchValues ( );
		 
		 // If the user has selected to insert the element in the skip list
		 if ( AlgoSelected.equals ( "Insert" ) )
		 {
		 	// Insert the element
           skip.insert ( new IElem ( ElementEntered ) );
           
           // draw the skip list
    	   draw.drawSkipList ( skip );	      
		   displayText [displayPointer++] = "\n The element is inserted in its place in the list";
		   Message ( "blue" );
		   int length = doc.getLength ();
    	   textPane.setCaretPosition ( length );

		 }
		 // get rid of the old text that was inserted
		 Input.setText ( " " );
		 
		 // IF the algorithm selected is the search then 
		 if ( AlgoSelected.equals ( "Search" ) )
		 {
		   if ( draw.ReturnvalueIsFound ( ) )
		   {
			 displayText [ displayPointer++] = "\n The number is found";
		     Message ( "blue" );
			 int length = doc.getLength ();
             textPane.setCaretPosition ( length );

		   }
		   else
		   {
			 displayText [displayPointer++] = "\n The number was not found";
			 Message ( "blue" );
			 int length = doc.getLength ();
		     textPane.setCaretPosition ( length );

		   }
		 }
	  }
  	} 
  	
  	// The following statements are excuted to display the help file
  	if ( message.equals ( "Help" ) )
  	{
      if ( instruction != null )
       {
         instruction.getrid ( );  // If any of the manual frame is being displayed get rid of it
         instruction = null; // Prevents more than one frame being open at the same time
       }           
       instruction = new Instructions ( );
       frame.validate ( );              
   	}  
  }

/*************************************************************************/
/* the following function displays the current index of the message in
the displayText array. The text is displayed in the color that is passed in
the current variable*/
/*************************************************************************/   
  
 
  public void Message ( String color )
  {
  	try
    {
      doc.insertString (doc.getLength(), displayText[displayPointer-1],textPane.getStyle ( color ));
    }
        
    catch ( BadLocationException ble )
    {
      System.out.println ( "Couldn't insert initial text." );
    }
  }
  
}

public class skipMain extends JApplet 
{
  public void init ( )
  {
    setUp set = new setUp ( );
  }	
}    