# Garbage Collection

**Garbage** means memory the system has previously allocated is no longer being used. For the illusion of infinite memory to work, the language needs to be very safe about “no longer being used”. In order to be collectible, the language has to ensure there’s no way for the program to use that object again. If it can’t get a reference to the object, then it obviously can’t use it again.

The definition of **in use**:

- Any object that’s being referenced by a variable that’s still in scope is in use.

- Any object that’s referenced by another object that’s in use is in use. 

The second rule is the recursive one. If object A is referenced by a variable, and it has some field that references object B, then B is in use since you can get to it through A.

The end result is a graph of reachable objects-all of the objects in the world that you can get to by starting at a variable and traversing through objects. Any object not in that graph of reachable objects is dead to the program and its memory is ripe for a reaping.

## Marking and sweeping

The first algorithm ever invented for GC is "mark-sweep". It works almost exactly like our definition of reachability:

- Starting at the roots, traverse the entire object graph. Every time you reach an object, set a “mark” bit on it to true.

- Once that’s done, find all of the objects whose mark bits are not set and delete them.

