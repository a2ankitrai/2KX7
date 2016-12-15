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

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics2D.*;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import java.lang.Object;
import javax.swing.text.*;
import javax.swing.text.JTextComponent;
import java.lang.Integer;

// the following class is used to perform the graphics rot
public class drawSkip extends JComponent
{
  BufferedImage IMG; //IMG on which the graphics routines are performed
  int totalHeight; // The total height of the entire display
  int totalWidth;  // The total width of the entire display
  
  SkipList skipList; // The class that implements the skip List
  SkipNode temp; // Each node of the skip list
  
  // This keeps the drawskip intially false so prevents the drawing of skiplist if it is null
  boolean drawSkip = false; 
  boolean drawSearchValues = false; // To start the animation of the search of the value
  
  String AlgoSelected = "null"; // To distinguish whether the animation is of the insertion/search of a value in the list
  
  int [] levels; // Stores the levels to animate
  int [] nodeValues; // Stores the node values to animate
  int Pointer; // The pointer to levels and nodevalues
  int PointerTracker; // To keep track of how many levels and values have been animated
  boolean valueIsFound; // If the value is found
  boolean IsCompleteTrue = false; // If the search is complete to allow the user to enter a new element to search
  int SearchFor; // The value that is being searched
    
  // The constructor for this class
  public drawSkip ( int width, int height )
  {
  	totalHeight = height;
  	totalWidth = width;  
  	this.setSize ( width, height ); // sets the size of this component
  }

/********************************************************************************/
/* This function implements the graphics routines */
/********************************************************************************/
     
  public void paint ( Graphics g )
  {
  	// Create image to start animation
    IMG = new BufferedImage ( totalWidth-3,totalHeight-3,BufferedImage.TYPE_INT_RGB );
    Graphics2D G = IMG.createGraphics ( );
    G.setColor ( Color.white );// Sets the background to white
    G.fillRect ( 0,0,totalWidth,totalHeight ); 
    //Display text in blue
    G.setColor ( Color.blue );
    Font newfont = new Font ( "Arial", Font.BOLD, 17 );
    G.setFont ( newfont );
    G.setColor ( Color.blue );
    
    // If you are animating the pointers
    boolean IsGreenShown = false;
    // If you are displaying the value if it is found
	boolean IsPinkShown = false;
	
	// Draw skip when the skip List is not null
    if ( drawSkip )
    {
      temp = skipList.head; // The head pointer of the skip List
      int width = 5; // Begin the drawing of the list from this X Cd
      int height = 25;  // Beging the drawing of the list from this Y cd          
      // Creates an array to store the levels 
      int level[] = new int [temp.forward.length];
      // To store the Y cds to begin drawing of the levels
      int levelHeight [] = new int [temp.forward.length];
      // To store the X cds to draw the levels
      int levelWidth [] = new int [temp.forward.length];
      
      // Where to store the level of the pointers to animate them
      int SearchAtHeight [] = new int [temp.forward.length];
      int j=0;
       
      // To search the value
      while ( j < temp.forward.length )
      {
        if ( j== 0 ) // To display the H in the header node
        {
          G.setColor ( Color.cyan ); // Draw each node blue in color
          G.fillRect ( width, height, 35, 30 );
          G.setColor ( Color.blue );
          G.drawString ( "H", width,height+15 ); // To show that it is head node
          G.drawLine ( width,height+28, width+35,height+28 ); // To distinguish the levels
          height = height+ 30;
        }
				
        String str = null;
        str = str.valueOf ( j ); // Store the level number
        
        // Draws the level in the Node
        G.setColor ( Color.cyan );
        G.fillRect ( width, height, 35, 30);
        G.setColor ( Color.blue );
        G.drawString ( str, width, height+15 ); // draws the level number
        G.drawLine ( width,height+28, width+35,height+28 ); // distinguishes each level
         
        String str1 = null;
        str1 = temp.forward[j].value ( ).toString ( );
       	
       	// To store the level height and width to draw the arrows connecting 2 levels
       	// If the next level is a null then it is the end of the list and you have to display the null pointer
        if ( str1 == null )
        {
          levelHeight [j] = height; 
          SearchAtHeight [j] = height-15;
          levelWidth [j] = width+ 45/2;
          height += 30;
        }
      
        else // Stores information for drawing the arrows connecting the pointers
        {
	      level [j] = Integer.parseInt ( str1 );
     	  levelHeight [j] = height+15;
       	  levelWidth [j] = width+ 45/2;
       	  SearchAtHeight [j] = height;
          height += 30;
        }
        j++;
      }        
      
      // Move to the next pointer after the head
      temp = temp.forward [0];
      height =25;
      width = width + 45;

      // Draws the entire skip List             
      while (temp != null) 
      {
        for ( int i=0; i<temp.forward.length; i++ ) // Draws each node one by one together with its level
        {
          String value = "null";           
                  
          if ( temp.value ( ) == null  ) // If the value is null then end node
             value = "null";
          else
             value = value.valueOf ( temp.value ( ) );            

          if ( i ==0 ) // Display the value of the element in the node
          {   	
            G.setColor ( Color.cyan );
            G.fillRect ( width, height, 35, 30);
            G.setColor ( Color.blue );
            G.drawString ( value, width, height+15 );
            G.drawLine ( width,height+28, width+35,height+28 );
          }

          height = height+30; // Increase height of the next level
          
          // fills the rectangle in cyan..    
                
          G.setColor ( Color.cyan );  // Draw the nodes cyan in color
		  
		  if ( AlgoSelected.equals ( "Search" ) ) // If user has selected to search for a value and no insertion of new nodes
		  {
			if ( drawSearchValues && !IsCompleteTrue ) // IF more values have to be highlighted then display the pointer in green 
			{
			  // If last node is being animated
			  if ( ( !IsPinkShown ) && ( levels [PointerTracker ] == i ) && ( nodeValues [PointerTracker] ==  ( ( Elem ) temp.value ( ) ).key ( ) ) && ( SearchFor == nodeValues [PointerTracker] ) && ( levels [PointerTracker] == 0 ) )
			  {
				G.setColor ( Color.pink );
				G.fillRect ( width, height -31,35, 30 );
				G.setColor ( Color.blue );
				G.drawString ( value, width,height -15 );
				// If the last node i.e. the node having the value yyou are searching for is found display it in pink
				IsPinkShown = true; 
			  } 

			  if ( ( !IsGreenShown ) && ( levels [PointerTracker ] == i ) && ( nodeValues [PointerTracker] ==  ( ( Elem ) temp.value ( ) ).key ( ) ) )
			  { // if the current node does not have the value you are looking for
				G.setColor ( Color.green );	
				IsGreenShown = true;
			  }
			}
		  }
		  
		  else
		  { // If the user wants to insert something
			if ( drawSearchValues && !IsCompleteTrue )
			{
			  if ( ( !IsPinkShown ) && ( levels [PointerTracker+1] == -1 ) && ( levels[PointerTracker] == 0 ) && ( nodeValues [PointerTracker] == ( ( Elem ) temp.value ( ) ).key ( ) ) )
			  {
				G.setColor ( Color.red ); // If the position has been reached then display a red arrow showing where the node will be insertd
				if ( SearchFor > nodeValues [ PointerTracker] ) // If the arrow is after the node being displayed
				{
				  G.drawLine ( width+40 , height - 50 , width+ 40, height - 35 );
				  G.drawLine ( width+40 , height - 35, width + 38, height - 38 );
				  G.drawLine ( width+40 , height - 35, width+ 42, height -38 );				  				  
				}
				else // if you have to draw the arrow before the node that is being displayed
				{
				  G.drawLine ( width - 5, height - 50, width -5, height -35 );		
				  G.drawLine ( width -5, height - 35, width - 3, height - 38 );
				  G.drawLine ( width - 5, height-35, width -7, height - 38 );				  				 
				}
				
				IsPinkShown = true; // finished the insertion part enter the node now
			  }
			  
			  if ( ( !IsGreenShown ) && ( levels [PointerTracker] == i) && ( nodeValues [PointerTracker] == ( ( Elem ) temp.value ( ) ).key ( ) ) )
			  {
				G.setColor ( Color.green );
				IsGreenShown = true; // highlight the current pointer			
			  }																											 
			}
		  }
		     
          G.fillRect ( width, height, 35, 30);
          G.setColor ( Color.blue );
          G.setFont ( newfont ); 
          
          
          G.setColor ( Color.blue );
          // The following loop draws the arrows connecting the pointers. If the 
           // the value is null then no need of drawing any pointers from that node.
          if ( !( value.equals ( "null" ) ) )
          {
			G.setColor ( Color.blue );
            int Value = Integer.parseInt ( value );
            if ( level [i] == Value )
            {
              // THe end point of the pointer
              G.fillOval ( levelWidth [i] - 2, levelHeight [i] - 2, 4,4 );
          	  
          	  // draws the line of the arrow
          	  G.drawLine ( levelWidth [i], levelHeight [i], width, height+ 15 );
          	 
          	  // Draws the triangle at the end of the arrow
          	  int PolygonPointsX []= new int [3];
          	  int PolygonPointsY [] = new int [3];
          	  
          	  PolygonPointsX [0] = width-4;
          	  PolygonPointsY [0] = levelHeight [i]-4;
          	  
          	  PolygonPointsX [1] = width;
          	  PolygonPointsY [1] = levelHeight [i];
          	  
          	  PolygonPointsX [2] = width-4;
          	  PolygonPointsY [2] = levelHeight [i] +4;
          	  
              G.fillPolygon ( PolygonPointsX, PolygonPointsY, 3 );
              
              // If the value is not null then store the cds for drawing the pointer
              if ( temp.forward [i] != null )
          	  {
          	    String Temp = temp.forward[i].value ( ).toString ( );
          	    level [i] = Integer.parseInt ( Temp );
          	    levelWidth [i] = width + 45/2;
          	    levelHeight [i] = height+15;
          	  }
          	  else
          	  {
          	    G.fillOval ( levelWidth [i] - 2, levelHeight [i] - 2, 4,4 );
 	            G.drawLine ( levelWidth[i], levelHeight [i], width, height + 15 );
                G.fillPolygon ( PolygonPointsX, PolygonPointsY, 3 );
         	  }          	  
            }	       	  
          }
          
          // If value is null the draw that string
          if (temp.forward[i] == null)
          {
            value = "null";
          }
          else
            value = value.valueOf ( temp.forward[i].value ( ) );
          
          G.setColor ( Color.blue );

          if ( value.equals ( "null" ) )
            G.drawString ( value, width, height+15 );
          
          G.drawLine ( width, height+28, width+35, height+28);
        }
        
        // Move to the next node
        temp = temp.forward[0];
        width = width + 45;
        height = 25;        
      }
      
      // Get rid of these arrays after drawing is complete, no need for them
      level = null; 
      levelWidth = null;
      levelHeight = null;                 
   	}
    g.drawImage ( IMG,0,0,totalWidth,totalHeight,this );  
  }

/********************************************************************************/
/* Draw the skip list, the displaying of the skip list does not start till this
function is called. This prevents any attempt to paint the skip list while it 
is null and thus no null pointer exception*/
/********************************************************************************/
  
  public void drawSkipList ( SkipList skip )
  { 
    skipList = skip;
    drawSkip = true;
  	repaint ( );
  }

/********************************************************************************/
/* This function is called if the user is trying to search for a value and 
not inserting a new value*/
/********************************************************************************/

  
  public void drawSearch ( SkipList skip, int SearchKey, String Selected )
  {
  	skipList = skip; // Initialize the skiplist that is to be drawn/searched
	SearchFor = SearchKey; // The key that is being searched for
  	skip.search ( SearchKey ); // Search for the key
  	levels = skip.return_levels ( ); // The total levels that were searched
  	nodeValues = skip.return_nodeValues ( );// The nodes that were searched for
	AlgoSelected = Selected; // THe algorselcted 
  	Pointer = skip.return_Pointer ( );   // THe number of entries that are valid in level and nodevalues
	valueIsFound = skip.returnIfFound ( ); // If the value is there in the skipList
  	PointerTracker = 0; // Steps through the algorithm	
  	drawSearchValues = true; //Helps in controling the display of the skipList
  	IsCompleteTrue = false;	
  	repaint ( );
  }
  
/********************************************************************************/
/* THis function controls the next step that is to be animated*/
/********************************************************************************/  

  public boolean drawNext ( )
  {  		
	PointerTracker++;
    if ( levels [PointerTracker ] == -1  )
      IsCompleteTrue = true; // If you have stepped through the algorithm       	

    repaint ( );
	return IsCompleteTrue;
  }
  

/********************************************************************************/
/* Helps in controling the display and drawing of the skip list and sets variables 
for the loops in the paint method*/
/********************************************************************************/
  
  public void ResetSearchValues ( )
  {
  	drawSearchValues = false;
  	IsCompleteTrue = false;
  	repaint ( );
  }

/********************************************************************************/
/* To pass the information to the skip main function if the value was found or not
in the skip List*/
/********************************************************************************/  
  
  public boolean ReturnvalueIsFound ( )
  {
	return valueIsFound;
  }
  
}

