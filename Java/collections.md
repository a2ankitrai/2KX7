# Collections
---

![collection_cheat_sheet](./_image/collection_cheat_sheet.PNG)

## Collection << Interface >>

```java
public interface Collection<E>
extends Iterable<E>
```

The root interface in the collection hierarchy. A collection represents a group of objects, known as its elements.

## List << Interface >>

```java
public interface List<E>
extends Collection<E>
```

An ordered collection (also known as a sequence). The user of this interface has precise control over where in the list each element is inserted. The user can access elements by their integer index (position in the list), and search for elements in the list.

lists typically allow duplicate elements. 

The `List` interface provides a special iterator, called a `ListIterator`, that allows element insertion and replacement, and bidirectional access in addition to the normal operations that the Iterator interface provides.

Implementations:

---

### ArrayList (Class)

```java
public class ArrayList<E>
extends AbstractList<E>
implements List<E>, RandomAccess, Cloneable, Serializable
```

Resizable-array implementation of the `List` interface. 

Implements all optional list operations, and permits all elements, including `null`. In addition to implementing the List interface, this class provides methods to manipulate the size of the array that is used internally to store the list. (This class is roughly equivalent to Vector, except that **it is unsynchronized**.)

The `size`, `isEmpty`, `get`, `set`, `iterator`, and `listIterator` operations run in constant time. The add operation runs in *amortized constant time*, that is, adding n elements requires O(n) time. All of the other operations run in linear time (roughly speaking). The constant factor is low compared to that for the `LinkedList` implementation.

Each ArrayList instance has a capacity. As elements are added to an ArrayList, its capacity grows automatically.

An application can increase the capacity of an ArrayList instance before adding a large number of elements using the `ensureCapacity` operation. This may reduce the amount of incremental reallocation.

```java
public void ensureCapacity(int minCapacity)
```

**this implementation is not synchronized.** To externally synchronize the list should be "wrapped" using the `Collections.synchronizedList` method. This is best done at creation time, to prevent accidental unsynchronized access to the list:

```java
   List list = Collections.synchronizedList(new ArrayList(...));
```

The iterators returned by this class's iterator and listIterator methods are **fail-fast**: if the list is structurally modified at any time after the iterator is created, in any way except through the iterator's own remove or add methods, the iterator will throw a `ConcurrentModificationException`. Thus, in the face of concurrent modification, the iterator fails quickly and cleanly, rather than risking arbitrary, non-deterministic behavior at an undetermined time in the future.

---
   
### Vector (Class)   

```java
public class Vector<E>
extends AbstractList<E>
implements List<E>, RandomAccess, Cloneable, Serializable
```

The `Vector` class implements a growable array of objects. Like an array, it contains components that can be accessed using an integer index. However, the size of a `Vector` can grow or shrink as needed to accommodate adding and removing items after the `Vector` has been created.

As of the Java 2 platform v1.2, this class was retrofitted to implement the `List` interface, making it a member of the Java Collections Framework. Unlike the new collection implementations, `Vector` is synchronized. If a thread-safe implementation is not needed, it is recommended to use `ArrayList` in place of `Vector`.

---

### CopyOnWriteArrayList (Class) 

```java
package java.util.concurrent

public class CopyOnWriteArrayList<E>
extends Object
implements List<E>, RandomAccess, Cloneable, Serializable
```

A thread-safe variant of `ArrayList` in which all mutative operations (add, set, and so on) are implemented by making a fresh copy of the underlying array. 

This is ordinarily too costly, but may be more efficient than alternatives when traversal operations vastly outnumber mutations, and is useful when you cannot or don't want to synchronize traversals, yet need to preclude interference among concurrent threads.

The "snapshot" style iterator method uses a reference to the state of the array at the point that the iterator was created. This array never changes during the lifetime of the iterator, so interference is impossible and the iterator is guaranteed not to throw `ConcurrentModificationException`. The iterator will not reflect additions, removals, or changes to the list since the iterator was created. Element-changing operations on iterators themselves (remove, set, and add) are not supported. These methods throw `UnsupportedOperationException`.

Memory consistency effects: As with other concurrent collections, actions in a thread prior to placing an object into a `CopyOnWriteArrayList` **happen-before** actions subsequent to the access or removal of that element from the `CopyOnWriteArrayList` in another thread.

---

###	LinkedList (Class)

```java
public class LinkedList<E>
extends AbstractSequentialList<E>
implements List<E>, Deque<E>, Cloneable, Serializable
```

Doubly-linked list implementation of the `List` and `Deque` interfaces. Implements all optional list operations, and permits all elements (including `null`).

**this implementation is not synchronized**. To synchronize the list should be "wrapped" using the `Collections.synchronizedList` method. This is best done at creation time, to prevent accidental unsynchronized access to the list:

```java
   List list = Collections.synchronizedList(new LinkedList(...));
```

---

## Set << Interface >>

```java
public interface Set<E>
extends Collection<E>
```

A collection that contains no duplicate elements. More formally, sets contain no pair of elements `e1` and `e2` such that `e1.equals(e2)`, and at most one `null` element. As implied by its name, this interface models the mathematical *set* abstraction.

### HashSet (Class)

```java
public class HashSet<E>
extends AbstractSet<E>
implements Set<E>, Cloneable, Serializable
```

This class implements the Set interface, backed by a hash table (actually a `HashMap` instance). It makes no guarantees as to the iteration order of the set; in particular, it does not guarantee that the order will remain constant over time. This class permits the null element.

`HashSet` is internally implemented using `HashMap` in Java.

`HashMap` allows duplicate values and this property is exploited while implementing `HashSet` in Java. Since `HashSet` implements `Set` interface it needs to guarantee uniqueness and this is achieved by storing elements as keys with same value always. `HashSet` can be used in place of `ArrayList` to store the object if you require no duplicate and don't care about insertion order

Since HashSet doesn't provide any direct method for retrieving object e.g. get(Key key) from HashMap or get(int index) from List, only way to get object from HashSet is via Iterator.

Methods add(), remove(), contains() and size() are constant time operation.

#### Constructors

- `HashSet()` : 
Constructs a new, empty set; the backing HashMap instance has default initial capacity (16) and load factor (0.75).

- `HashSet(Collection<? extends E> c)` :
Constructs a new set containing the elements in the specified collection.

- `HashSet(int initialCapacity)` :
Constructs a new, empty set; the backing HashMap instance has the specified initial capacity and default load factor (0.75).

- `HashSet(int initialCapacity, float loadFactor)` :
Constructs a new, empty set; the backing HashMap instance has the specified initial capacity and the specified load factor.

---

### LinkedHashSet (Class)

```java
public class LinkedHashSet<E>
extends HashSet<E>
implements Set<E>, Cloneable, Serializable
```

Hash table and linked list implementation of the `Set` interface, with predictable iteration order. This implementation differs from HashSet in that it maintains a doubly-linked list running through all of its entries. This linked list defines the iteration ordering, which is the order in which elements were inserted into the set (insertion-order).

This class provides all of the optional `Set` operations, and permits `null` elements. Like `HashSet`, it provides constant-time performance for the basic operations (`add`, `contains` and `remove`), assuming the hash function disperses elements properly among the buckets. Performance is likely to be just slightly below that of `HashSet`, due to the added expense of maintaining the linked list, with one exception: Iteration over a `LinkedHashSet` requires time proportional to the size of the set, regardless of its capacity. Iteration over a `HashSet` is likely to be more expensive, requiring time proportional to its capacity.

Both `HashSet` and `LinkedHashSet` allows null.

---

### TreeSet (Class)

```java
public class TreeSet<E>
extends AbstractSet<E>
implements NavigableSet<E>, Cloneable, Serializable
```

A `NavigableSet` implementation based on a `TreeMap`. The elements are ordered using their natural ordering, or by a `Comparator` provided at set creation time, depending on which constructor is used.

This implementation provides guaranteed log(n) time cost for the basic operations (`add`, `remove` and `contains`).

Both `HashSet` and `LinkedHashSet` allows null but `TreeSet` doesn't allow `null` and throw `java.lang.NullPointerException` when you will insert `null` into `TreeSet`. Since `TreeSet` uses `compareTo()` method of respective elements to compare them  which throws NullPointerException while comparing with `null`.

---

### When to use HashSet, TreeSet and LinkedHashSet

- use `TreeSet` when you need a collection where elements are sorted without duplicates.

- `HashSet` are rather general purpose `Set` implementation, Use it as default `Set` implementation if you need a fast, duplicate free collection

- `LinkedHashSet` is extension of `HashSet` and its more suitable where you need to maintain insertion order of elements, similar to List without compromising performance for costly `TreeSet`.

---

## SortedSet << Interface >>

```java
public interface SortedSet<E>
extends Set<E>
```

A `Set` that further provides a total ordering on its elements. The elements are ordered using their natural ordering, or by a `Comparator` typically provided at sorted set creation time. The set's iterator will traverse the set in ascending element order. Several additional operations are provided to take advantage of the ordering. (This interface is the set analogue of SortedMap.)

All elements of a SortedSet must implement the `Comparable` interface (or be accepted by the specified `Comparator`) and all such elements must be mutually comparable (i.e, Mutually Comparable simply means that two objects accept each other as the argument to their compareTo method)

## NavigableSet << Interface >>

```java
public interface NavigableSet<E>
extends SortedSet<E>
```

A SortedSet extended with navigation methods reporting closest matches for given search targets. Methods `lower`, `floor`, `ceiling`, and `higher` return elements respectively less than, less than or equal, greater than or equal, and greater than a given element, returning null if there is no such element. A NavigableSet may be accessed and traversed in either ascending or descending order.

---

## CopyOnWriteArraySet (Class)

```java
package java.util.concurrent;

public class CopyOnWriteArraySet<E>
extends AbstractSet<E>
implements Serializable
```

A `Set` that uses an internal `CopyOnWriteArrayList` for all of its operations. Thus, it shares the same basic properties:

- It is best suited for applications in which set sizes generally stay small, read-only operations vastly outnumber mutative operations, and you need to prevent interference among threads during traversal. (For example you can use `CopyOnWriteArraySet` to store object at start-up of application and let multiple application thread access them during application life time. If an new condition or object comes up during that time, it can also be added into this Set, with incurring cost of creating a new array.)

- It is thread-safe.

- Mutative operations (add, set, remove, etc.) are expensive since they usually entail copying the entire underlying array.

- Iterators do not support the mutative remove operation. Trying to remove an element while iterating will result in `UnSupportedOperationException`.

- Traversal via iterators is fast and cannot encounter interference from other threads. Iterators rely on unchanging snapshots of the array at the time the iterators were constructed.

---

## ConcurrentSkipListSet (Class)

```java
package java.util.concurrent;

public class ConcurrentSkipListSet<E>
extends AbstractSet<E>
implements NavigableSet<E>, Cloneable, Serializable
```

A scalable concurrent `NavigableSet` implementation based on a `ConcurrentSkipListMap`. **The elements of the set are kept sorted** according to their natural ordering, or by a Comparator provided at set creation time, depending on which constructor is used.

This implementation provides expected average log(n) time cost for the contains, add, and remove operations and their variants. Insertion, removal, and access operations safely execute concurrently by multiple threads.

ConcurrentSkipListSet does not permit the use of null elements, because null arguments and return values cannot be reliably distinguished from the absence of elements.

---

## Map

an object that maps keys to values, an associative array, a table: the map.

---

## Questions

-	What happens On HashMap in Java if the size of the HashMap  exceeds a given threshold defined by load factor ?

	If the size of the Map exceeds a given threshold defined by load-factor e.g. if the load factor is .75 it will act to re-size the map once it filled 75%. Similar to other collection classes like ArrayList,  Java HashMap re-size itself by creating a new bucket array of size twice of the previous size of HashMap and then start putting every old element into that new bucket array. This process is called rehashing because it also applies the hash function to find new bucket location.

