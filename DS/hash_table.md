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
slot from the key k. Here, h maps the universe U of keys into the slots of a **hash table** T[0,1... m -1]:

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

---

### Load Factor (Analysis of hashing with chaining)

Given a hash table `T` with `m` slots that stores `n` elements, we define the load
factor `α` for `T` as `n/m`, that is, the average number of elements stored in a chain.
Our analysis will be in terms of `α`, which can be less than, equal to, or greater
than 1.

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

- Linear Probing
- Quadratic Probing
- Double Hashing

---

## Perfect Hashing

---

