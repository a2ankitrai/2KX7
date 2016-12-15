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

import java.util.*;

// A bunch of utility functions.
public class DSutil {

  // Swap two objects in an array
  public static void swap(Object[] array, int p1, int p2) {
    Object temp = array[p1];
	array[p1] = array[p2];
	array[p2] = temp;
  }

  // Randomly permute the Objects in an array
static void permute(Object[] A) {
  for (int i = A.length; i > 0; i--) // for each i
    swap(A, i-1, DSutil.random(i));  //   swap A[i-1] with
}                                    //   a random element

  // Create a random number function to return values
  // uniformly distributed within the range 0 to n-1.
  static private Random value = new Random(); // Hold the Random class object

  static int random(int n) { // My own function
	return Math.abs(value.nextInt()) % n;
  }

}
