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
/**********************************************************************************/
/* The following class is written by Purvi Saraiya*/
/* It displays the Help file for the skip lists*/
/**********************************************************************************/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.JTextComponent;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.JComponent;
import javax.swing.text.JTextComponent;

public class Instructions 
{
  Container contentpane;//The container for the main frame
  JFrame frame;  // The main frame  the help file
  JPanel panel;
  
  JTextPane textPane;// The textfield to display the messages
  JScrollPane TextAreaScrollPane; // The scroll pane for the textpane
  
  Document doc;// The doc for the textfield
  String [] Styles = { "BLUE", "BLUEU", "Blue", "blue" };
  
  // The following are the various  styles for displaying the text
  
  Style def;
  Style BLUE;
  Style BLUEU;
  Style Blue;
  Style blue;
  
  String instructions [];//The array for storing the message strings.
  int Pointer =0;// Pointer for the above array.
  
  public Instructions ( )
  {
  	
  	frame = new JFrame ( );
  	contentpane = frame.getContentPane ( );
  	
  	contentpane.setLayout ( new FlowLayout ( )); //Seting the layout of the container
  	
  	textPane = new JTextPane ( ); // The text field for displaying the message
    textPane.setEditable ( false ); // Don't allow the user to change the text that is displayed.
    textPane.setText ( " " );
    
    TextAreaScrollPane = new JScrollPane ( textPane ); // Scrollpane for the textfield
    TextAreaScrollPane.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    TextAreaScrollPane.setPreferredSize ( new Dimension ( 420, 300 ) );
    

    frame.addWindowListener(new WindowAdapter() // for closing the frame..
    {
      public void windowClosing(WindowEvent e)
      {
        frame.setVisible ( false );	
        frame.dispose ( );
      }
    });
    
    panel = new JPanel();
    panel.add(TextAreaScrollPane); // panel for the text field
    panel.setLocation( 0, 0 );
    panel.setSize( 450,310 );//Panel for ScrollPane.

	// Creating an array for storing the text that is to be displayed int the manual.
    instructions = new String [100];
    
    doc = textPane.getDocument ();// THe document for the textfield

	def = StyleContext.getDefaultStyleContext().
                                        getStyle(StyleContext.DEFAULT_STYLE);
    // Display the text in blue with fontsize 16 and in bold
	BLUE = textPane.addStyle ( "BLUE", def );
	StyleConstants.setForeground ( BLUE, Color.blue );
	StyleConstants.setFontFamily ( BLUE, "Arial" );
	StyleConstants.setFontSize ( BLUE, 16 );
	StyleConstants.setBold ( BLUE, true );
	
	// displays the text string in blue with fontsize 16 and in bold and underlined
	BLUEU = textPane.addStyle ( "BLUEU", def );
	StyleConstants.setForeground ( BLUEU, Color.blue );
	StyleConstants.setFontFamily ( BLUEU, "Arial" );
	StyleConstants.setFontSize ( BLUEU, 16 );
	StyleConstants.setBold ( BLUEU, true );
	StyleConstants.setUnderline ( BLUEU, true );
	
	// displays the text string in blue with font size 14 and in bold
    Blue = textPane.addStyle ( "Blue",def );
    StyleConstants.setForeground ( Blue, Color.blue );
    StyleConstants.setFontFamily ( Blue, "Arial" );
    StyleConstants.setFontSize ( Blue, 14 );
	StyleConstants.setBold ( Blue, true );
	StyleConstants.setUnderline ( Blue, true );
    
	// displays the text in blue with font size 14 and not bold
	blue = textPane.addStyle ( "blue",def );
    StyleConstants.setForeground ( blue, Color.blue );
    StyleConstants.setFontFamily ( blue, "Arial" );
    StyleConstants.setFontSize ( blue, 14 );
    
    // The display of the message strings begins here.    
    
    instructions [ Pointer++] = "\t";
	Message ( "BLUE" );
	
	instructions [Pointer++] = "HOW TO USE THIS SYSTEM:\n";
	Message ( "BLUEU" );
	
	instructions [Pointer++] = "\nProbably the easiest way to use this applet is to follow the instructions that are given during run time on the text area.\n\n";
	Message ( "blue" );
                         
    instructions [Pointer++] = "Following is the brief summary of how to run the applet.";
	Message ( "Blue" );
	
	instructions [Pointer++] = "\n\nIntially the skip list is empty. Start the animation by entering a number in the list.";
	Message ( "blue" );
                 
	instructions [Pointer++] = "\n\nYou can animate two operations of the skip lists through this algorithm animation system.";
	Message ( "blue" );
	
	instructions [Pointer++] = "\n\t1. Insertion";
	Message ( "blue" );
	
	instructions [Pointer++] = "\n\t2. Search Operation";
	Message ("blue" );  
	
	instructions [Pointer++] = "\n\nEnter a number in the text field and press the appropriate button to perform either of the operations.";
	Message ("blue" ); 
	
	instructions [Pointer++] = "\n\nTo step through the algorithm press the 'Next' button.";
	Message ("blue" ); 
	
	instructions [Pointer++] = "\n\nYou can restart the system and start with a new list by pressing the restart button.";
	Message ("blue" );      
	
	instructions [Pointer++] = "\n\nRuntime feedback is given to you using the text field.";
	Message ( "blue" );
	
	instructions [ Pointer++] = "\n\n\t";
	Message ( "BLUE" );
	
	instructions [Pointer++] = "COLOR CODING:\n";
	Message ( "BLUEU" );
	
	instructions [ Pointer++] = "\nFollowing are the colors used to show different stages in the algorithm.\n";
	Message ( "blue" );
	
	instructions [Pointer++] = "Pink:";
	Message ( "Blue" );
	
	instructions [Pointer++] = " Highlights if the number on which the search operation is being performed is found in the list.\n\n";
	Message ( "blue" );	
	
	instructions [Pointer++] = "Green:";
	Message ( "Blue" );
	
	instructions [Pointer++] = " Highlights the pointers that are followed during the search and insertion operation.\n\n";
	Message ( "blue" );
	
	instructions [Pointer++] = "Blue:";
	Message ( "Blue" );
	
	instructions [Pointer++] = " All the feedback messages are given in the Text area in blue.\n\n";
	Message ( "blue" );
	
	instructions [Pointer++] = "Red:";
	Message ( "Blue" );
	
	instructions [Pointer++] = " All  instructions and error messages are given in red color.\n\n";
	Message ( "blue" );          
 
 	textPane.setCaretPosition ( 0 );                                         
    contentpane.add ( panel );
    frame.setTitle ( "Instruction Manual " );
    frame.setSize ( 440, 410 );
    frame.validate ( );
    frame.setVisible ( true );
    
 
  }
  
/**********************************************************************************/
/* The following function is called to insert the text in the Text Field.*/
/* I am defining the text string in the main class and then calling this function
to display it using the appropriate style*/
/**********************************************************************************/
  
  public void Message ( String color )
  {
  	try
    {
      doc.insertString(doc.getLength(), instructions[Pointer-1],textPane.getStyle ( color ));
    }
    
    catch (BadLocationException ble)
    {
      System.out.println("Couldn't insert initial text.");
    }
  } 


/**********************************************************************************/
/* The following function will not allow more than one window of the Manual to be open 
at the same time. It disposes if there is any frame open before allowing to create a 
new frame each time the help button is pressed*/
/**********************************************************************************/    
  
  public void getrid ( )
  {
  	frame.setVisible ( false );
  	frame.dispose ( );
  }
  
} 






