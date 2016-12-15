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

public class SkipNode { // Skiplist node class
  private Object value;   // Data value for the node
  public SkipNode[] forward; // The node's pointer array
  // forward really should not be public.
  // It gets manipulated (only) by the SkipList class

  public Object value() { return value; }

  public SkipNode(Object r, int level) { // Constructor
    value = r;
    forward = new SkipNode[level+1];
    for (int i=0; i<level; i++)
      forward[i] = null;
  }
}
