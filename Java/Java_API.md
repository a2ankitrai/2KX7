# Java_API

`java.util`

Interface Iterator<E>

public interface Iterator<E>

An iterator over a collection. Iterator takes the place of Enumeration in the Java Collections Framework. Iterators differ from enumerations in two ways:

- Iterators allow the caller to remove elements from the underlying collection during the iteration with well-defined semantics.

- Method names have been improved.

**Methods**

- `boolean hasNext()` : Returns true if the iteration has more elements.

- `E next()` : 			Returns the next element in the iteration.

- `void remove( )` :    Removes the current element. Throws IllegalStateException if an attempt is made to call remove( ) that is not preceded by a call to next( ).

---

## ArrayList

ArrayList<Integer> arr = new ArrayList<Integer>();
 
- Add element to the end of the List
```
	 arr.add(x);
```

- Get the Size of the List
```
	arr.size();
```

---

## Collections class

- *Swap method for swapping two elements in an ArrayList*
```
	Collections.swap(arr, index,  size-1);
```	