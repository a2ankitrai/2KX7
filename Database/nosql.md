# No-SQL Databases
---

# Types of No-SQL databases

## Document Oriented

Uses JSON file to store data. More object oriented compared to RDBMS. These are great for analysis.

Examples:
- MongoDB
- CouchDB

---

## Columnar

Column family databases are designed for large volumes of data, read and write performance, and high availability.

Examples:
- Cassendra
- DynamoDB (Amazon)

---

## Key Value Pairs

These are like documented oriented in terms of having a key and associated value (or Object). Unlike the document oriented databases the key value pairs databases do not allow you to do a query inside the document without having the key first. These are very useful because they are very fast in accessing the data; for having a speedy enquiry. 

Applications:
- Customer browser history on server side

Examples:
- Redis
- Memcached
- Riak

---

## Graph Database

Graph database is a database that uses graph structures for semantic queries with nodes, edges and properties to represent and store data.

Applications:
- People who liked this product are likely to like that product as well. Finding relationships to give recommendations and suggesstion in Shopping apps.
- In Social networking friends suggesstion cause of mutual friends.

Examples:
- Neo4j
- InfiniteGraph 

---

# CAP Theorem

**Consistency** – All the servers in the system will have the same data so anyone using the system will get the same copy regardless of which server answers their request.

**Availability** – The system will always respond to a request (even if it's not the latest data or consistent across the system or just a message saying the system isn't working).

**Partition Tolerance** – The system continues to operate as a whole even if individual servers fail or can't be reached.

![cap](./cap.png)