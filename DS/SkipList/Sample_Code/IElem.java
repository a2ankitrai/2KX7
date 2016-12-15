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

// Sample implementation for Elem interface.
// A record with just an int field.
public class IElem implements Elem {

  private int value;

  public IElem(int v) { value = v; }
  public IElem() {value = 0;}

  public int key() { return value; }
  public void setkey(int v) { value = v; }

  // Override Object.toString
  public String toString() {
    return Integer.toString(value);
  }

}
