# High Level Design and Low Level Design

## High Level Design: 

High Level Design (HLD) is the overall system design - covering the system architecture and database design. It describes the relation between various modules and functions of the system. data flow, flow charts and data structures are covered under HLD.

Identify High level Entities. High level entities are objects, or groups of objects, that constitute major constructs of your design. Good examples of entities are a data access layer, a controller object, a set of business objects, etc…


### Design a twitter like system

- Clarify what the system should let a user do. Use case Requirements
- Come up with high level components for this system. 
	- There needs to be a data store (DB or key-value store) that stores user data, people he follows etc. Each of these relationships might be in the same table or be broken into multiple tables. The relationship might have attributes and those need to be put in somewhere too.  **some db design skills here and come up with a good table design**.
	- There needs to be a front-end for the user to view/login etc. and a backend that talks to this data store (or it could be a 2 level system with the front end directly talking to the datastore). Talk about the pros/cons of the two approaches.
	- What is a good mechanism to send posts from a user to others? A queue? Or can it be modeled using the same datastore? Is it advantageous to use a queue so that it can be extended to publish to third party people at some time in the future? 
	- Is a cache needed? What would it store, what is its eviction policy etc.
	- What about security of this system. Atleast come up with some validation at the entry points of each of these components.
		- Security comes with strong authentication and encryption maintained. HTTPS ? Prevention of XSS and MySQL injection attacks ? Two step verification of user input data ? Proper cleansing of user input data (is it what is only required) ? Captcha ? Securing api's using HMAC and nonces ? Strong passwords only ? Proper access rules for files defined in .htaccess ? Proper permissions of the code base ? and so on..

----

## Low Level Design Document: 

- Low Level Design (LLD) is like detailing the HLD. 
- It defines the actual logic for each and every component of the system. 
- Class diagrams with all the methods,Properties,variables and relation between classes comes under LLD. 


LLD is basically oops concepts implementation for the given problem

### Design how you'd represent a Football tournament.

- Find out the major "entities" that you need - each of these will mostly end up being a class of its own.
- You'll end up with a bunch of classes with some relationship between them (base and child classes or composite ones - isA or hasA relationship)
- Now that you have a set of classes, start with the major ones and figure out what methods /operations make sense of each of them and write down a method signature. The interviewer will mostly restrict the discussion to a few major classes and just the major methods on each of these classes. - Eg: Tournament.createSchedule(), Tournament.getStatsForMatch(), Match.calculateStats() etc.
- Next, think about the best data structures to be used inside each of these classes so that the methods can work efficiently.

discuss about OO concepts, polymorphism, implementation details inside a class etc. There's more focus on extensibility of a class and correct representation of concepts, rather than a focus on scale.




----
	
	
	
	
	
	
	
	
	
	