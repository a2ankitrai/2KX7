
#Design Principle
 
***Identify the aspects of your application that vary and separate them from what stays the same.***

Take what varies and `encapsulate` it so it won't affect the rest of your code. The result? Fewer unintended consequences from code changes and more flexibility in your systems!

- ***Program to an interface, not an implementation.***

- ***Favor composition over inheritance.***
	When you put two classes together in a HAS-A relationship you're using composition. Creating systems using composition gives you a lot more flexibility. Not only does it let you encapsulate a family of algorithms into their own set of classes, but it also lets you change behavior at runtime as long as the object you're composing with implements the correct behavior interface.
	
##Strategy Pattern

  The Strategy Pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. Strategy lets the algorithm vary independently from clients that use it.


---

##Observer Pattern

  The Observer Pattern defines a one-to-many dependency between objects so that when one object changes state, all of its dependents are notified and updated automatically.
	
  The subject and observers define the one-to-many relationship. The observers are dependent on the subject such that when the subject's state changes, the observers get notified. Depending on the style of notification, the observer may also be updated with new values.
	
	
  ###The power of Loose Coupling
  - Strive for loosely coupled designs between objects that interact. When two objects are loosely coupled, they can interact, but have very little knowledge of each other.
  
  - The Observer Pattern provides an object design where subjects and observers are loosely coupled.
---	

##Decorator Pattern

  The Decorator Pattern attaches additional responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality.
		
  ###The Open-Closed Principle
  Classes should be open for extension, but closed for modification.
	