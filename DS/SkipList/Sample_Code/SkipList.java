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
// Source code example for "A Practical Introduction
// to Data Structures and Algorithm Analysis"
// by Clifford A. Shaffer, Prentice Hall, 1998.
// Copyright 1998 by Clifford A. Shaffer

public class SkipList {  // Skiplist class
  SkipNode head; // Header node for skiplist -- always there
  private int level;     // Level of the current deepest node
  // Convention: A level 0 node has 1 pointer (at array index 0)
  int [ ] levels;
  int [ ] nodeValues;
  int Pointer;
  boolean valueFound = false;


  public SkipList() {    // Constructor
    head = new SkipNode(null, 0); // The header is initially at level 0
    level = -1;          // Indicates no nodes of any level
  }

  private void AdjustHead(int newLevel) { // Create a new (larger) head
    SkipNode temp = head;
    head = new SkipNode(null, newLevel);
    for (int i=0; i<=level; i++)
      head.forward[i] = temp.forward[i];
    level = newLevel;
  }

  public void print() {    // Print out contents of a skiplist
    SkipNode temp = head;
    while (temp != null) {
      System.out.print(temp.value() + ": length is "
                       + temp.forward.length + ":");
      for (int i=0; i<temp.forward.length; i++)
        if (temp.forward[i] == null)
          System.out.print("null ");
        else
          System.out.print(temp.forward[i].value() + " ");
      System.out.println();
      temp = temp.forward[0];
    }
    System.out.println();
  }
    
int randomLevel() { // Pick a level on exponential distribution
  int lev;
  for (lev=0; DSutil.random(2) == 0; lev++); // Do nothing
  return lev;
}

public void insert (Elem newValue) { // Insert into skiplist
  int newLevel = randomLevel();     // Select level for new node
  if (newLevel > level)             // New node will be deepest
    AdjustHead(newLevel);           // Add null pointers to header
  SkipNode[] update = new SkipNode[level+1]; // Track end of level
  SkipNode x = head;                // Start at header node
  for (int i=level; i>=0; i--) {    // Search for insert position
    while((x.forward[i] != null) &&
          (((Elem)x.forward[i].value()).key() < newValue.key()))
      x = x.forward[i];
    update[i] = x;                  // Keep track of end at level i
  }
  x = new SkipNode(newValue, newLevel);  // Create new node
  for (int i=0; i<=newLevel; i++) {      // Splice into list
    x.forward[i] = update[i].forward[i]; // Who x points to
    update[i].forward[i] = x;            // Who y points to
  }
}

// THe function returns the node after finding it in the list.
  public Elem search(int searchKey)	
  { // Skiplist Search
    SkipNode x = head; 
    
    if ( levels != null )
      levels = null;
    if ( nodeValues != null )
      nodeValues = null;
      
    levels = new int [20];
    nodeValues = new int [20];
    Pointer =0;
    
	for (int i=level; i>=0; i--)      // For each level...		
    {
      levels [Pointer] = i;
      try
      {
       	nodeValues [ Pointer] = ( ( Elem )x.forward[i].value ( ) ).key();
      } catch ( NullPointerException e )
      {
      	nodeValues [Pointer] = ( ( Elem )x.value ( ) ).key();
      }
	  Pointer++;

	  while ((x.forward[i] != null) && ( ( (Elem)x.forward[i].value()).key() < searchKey))
	  {
	    x = x.forward[i];
	  	levels [Pointer] = i;
	  	try
	  	{
          nodeValues [ Pointer] = ( ( Elem )x.value ( ) ).key();
        }  catch ( NullPointerException e )
        {  }
	    Pointer++;
	  }             			
    }
	  
	x = x.forward[0];  // Move to actual record, if it exists
	
	if ((x != null) && (((Elem)x.value()).key() == searchKey))
	{	
	  levels [Pointer] = 0;
	  nodeValues [ Pointer] = searchKey;
	  Pointer++;
	  levels [Pointer] = -1;
	  nodeValues [Pointer] = -1;
	}
	
	else
	{
	  levels [Pointer] = -1;
	  nodeValues [Pointer] = -2;
	}
	  	  
	if ((x != null) && (((Elem)x.value()).key() == searchKey))
	{	  
	  valueFound = true;
	  return (Elem) x.value();               // Got it
	}
	else
	{
	  valueFound = false;
	  return null;                 // Its not there	
	}
  }
  
  public int [] return_levels ( )
  {
  	return levels;
  }

  public int [] return_nodeValues ( )
  {
  	return nodeValues;
  }
  
  public int return_Pointer ( )
  {
  	return Pointer;
  }
  
  public boolean returnIfFound ( )
  {
  	return valueFound;
  }
  
  public void resetValueFound ( )
  {
  	valueFound = false;
  }
}
