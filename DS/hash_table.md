# Hash Table & Hashing

A hash table is an effective data structure for implementing dictionaries. Although searching
for an element in a hash table can take as long as searching for an element in a
linked list - ϴ(n) time in the worst case-in practice, hashing performs extremely
well. Under reasonable assumptions, the average time to search for an element in
a hash table is O(1).

When the number of keys actually stored is small relative to the total number of
possible keys, hash tables become an effective alternative to directly addressing an
array, since a hash table typically uses an array of size proportional to the number
of keys actually stored. Instead of using the key as an array index directly, the array
index is computed from the key.

---

## Direct-address Table
	
One-to-one mapping of key values in an array. The size of the direct address table is equal to the number of possible keys and hence possible values.

---

## Hash Tables

With direct addressing, an element with key k is stored in slot k. With hashing,
this element is stored in slot h(k) that is, we use a hash function h to compute the
slot from the key k. Here, h maps the universe U of keys into the slots of a **hash table** T[0,1...,m -1]:

`h : U --> {0,1,....,m-1}`,

where the size m of the hash table is typically much less than |U|. We say that an
element with key k hashes to slot h(k); we also say that h(k) is the hash value of key k.

The hash function reduces the range of array indices and hence the size of the array. Instead of a size of |U|, the array
can have size m.	

### Collision

Two keys may hash to the same slot in hash Table.

**Collision resolution by chaining**

In chaining, we place all the elements that hash to the same slot into the same linked list.

If the hash table supports deletion, then its linked lists should be doubly linked
so that we can delete an item quickly. If the lists were only singly linked, then to
delete element x, we would first have to find x in the list T[h(x.key)] so that we
could update the next attribute of x’s predecessor. With singly linked lists, both
deletion and searching would have the same asymptotic running times.

**Advantages:**

1. Simple to implement.
2. Hash table never fills up, we can always add more elements to chain.
3. Less sensitive to the hash function or load factors.
4. It is mostly used when it is unknown how many and how frequently keys may be inserted or deleted.

**Disadvantages:**

1. Cache performance of chaining is not good as keys are stored using linked list. Open addressing provides better cache performance as everything is stored in same table.
2. Wastage of Space (Some Parts of hash table are never used)
3. If the chain becomes long, then search time can become O(n) in worst case.
4. Uses extra space for links.

---

### Load Factor (Analysis of hashing with chaining)

Given a hash table `T` with `m` slots that stores `n` elements, we define the load
factor `α` for `T` as `n/m`, that is, the average number of elements stored in a chain.
Our analysis will be in terms of `α`, which can be less than, equal to, or greater
than 1.

Expected time to search = `O(1 + α)`
 
Expected time to insert/delete = `O(1 + α)`

Time complexity of search insert and delete is O(1) if  α is O(1)

---

## Hash functions

A good hash function satisfies (approximately) the assumption of simple uniform hashing: each key is equally likely to hash to any of the m slots,  independently of where any other key has hashed to.

### The division method

In the division method for creating hash functions, we map a key k into one of m slots by taking the remainder of k divided by m. That is, the hash function is

`h(k) =  k mod m `

### The multiplication method

The multiplication method for creating hash functions operates in two steps. First, we multiply the key k by a constant A in the range 0 < A < 1 and extract the fractional part of kA. Then, we multiply this value by m and take the floor of the result. In short, the hash function is

`h(k) = Math.Floor( m (kA mod 1))`

where “kA mod 1” means the fractional part of kA, that is, kA - Math.Floor[kA].

### Universal Hashing

Choose the hash function randomly in a way that is independent of the keys that are actually going to be stored. This approach, called universal hashing, can yield provably good performance on average, no matter which keys are being choosen.

---

## Open addressing

In Open Addressing, all elements are stored in the hash table itself. So at any point, size of table must be greater than or equal to total number of keys.

Insert(k): Keep probing until an empty slot is found. Once an empty slot is found, insert k.

Search(k): Keep probing until slot’s key doesn’t become equal to k or an empty slot is reached.

Delete(k): Delete operation is interesting. If we simply delete a key, then search may fail. So slots of deleted keys are marked specially as “deleted”.
Insert can insert an item in a deleted slot, but search doesn’t stop at a deleted slot.

### Linear Probing

In linear probing, we linearly probe for next slot. For example, typical gap between two probes is 1 as taken in below example also.
let hash(x) be the slot index computed using hash function and S be the table size.

```
If slot hash(x) % S is full, then we try (hash(x) + 1) % S
If (hash(x) + 1) % S is also full, then we try (hash(x) + 2) % S
If (hash(x) + 2) % S is also full, then we try (hash(x) + 3) % S 
..................................................
..................................................
```

**Clustering:** The main problem with linear probing is clustering, many consecutive elements form groups and it starts taking time to find a free slot or to search an element.

### Quadratic Probing

We look for i<sup>2</sup>th slot in ith iteration.

```
let hash(x) be the slot index computed using hash function.  
If slot hash(x) % S is full, then we try (hash(x) + 1*1) % S
If (hash(x) + 1*1) % S is also full, then we try (hash(x) + 2*2) % S
If (hash(x) + 2*2) % S is also full, then we try (hash(x) + 3*3) % S
..................................................
..................................................
```

### Double Hashing

Use another hash function hash2(x) and look for i*hash2(x) slot in i'th rotation.

```
let hash(x) be the slot index computed using hash function.  
If slot hash(x) % S is full, then we try (hash(x) + 1*hash2(x)) % S
If (hash(x) + 1*hash2(x)) % S is also full, then we try (hash(x) + 2*hash2(x)) % S
If (hash(x) + 2*hash2(x)) % S is also full, then we try (hash(x) + 3*hash2(x)) % S
..................................................
..................................................
```

### Comparison of above three:

Linear probing has the best cache performance, but suffers from clustering. One more advantage of Linear probing is easy to compute.

Quadratic probing lies between the two in terms of cache performance and clustering.

Double hashing has poor cache performance but no clustering. Double hashing requires more computation time as two hash functions need to be computed.

### Open Addressing vs. Separate Chaining

Advantages of Chaining:
1. Chaining is Simpler to implement.
2. In chaining, Hash table never fills up, we can always add more elements to chain. In open addressing, table may become full.
3. Chaining is Less sensitive to the hash function or load factors.
4. Chaining is mostly used when it is unknown how many and how frequently keys may be inserted or deleted.
5. Open addressing requires extra care for to avoid clustering and load factor.

Advantages of Open Addressing
1. Cache performance of chaining is not good as keys are stored using linked list. Open addressing provides better cache performance as everything is stored in same table.
2. Wastage of Space (Some Parts of hash table in chaining are never used). In Open addressing, a slot can be used even if an input doesn’t map to it.
3. Chaining uses extra space for links.


---

## Other Links

[Hashing Tutorial](http://research.cs.vt.edu/AVresearch/hashing/)

---

