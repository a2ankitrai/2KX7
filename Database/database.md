# Database
---

## super, primary, candidate and foreign keys

- A **superkey** is a set of attributes of a relation schema upon which all attributes of the schema are functionally dependent. No two rows can have the same value of super key attributes.

- A **Candidate** key is minimal superkey, i.e., no proper subset of Candidate key attributes can be a superkey.

- A **Primary Key** is one of the candidate keys. One of the candidate keys is selected as most important and becomes the primary key. There cannot be more that one primary keys in a table.

- **Foreign key** is a field (or collection of fields) in one table that uniquely identifies a row of another table. See this for an example.

---

## difference between primary key and unique constraints

Primary key cannot have NULL value, the unique constraints can have NULL values. There is only one primary key in a table, but there can be multiple unique constrains.

## difference between having and where clause

`HAVING` is used to specify a condition for a group or an aggregate function used in select statement. The `WHERE` clause selects before grouping. The `HAVING` clause selects rows after grouping. Unlike `HAVING` clause, the `WHERE` clause cannot contain aggregate functions.

The difference between the having and where clause in SQL is that the where clause cannot be used with aggregates, but the having clause can.

It is not a predefined rule but  in a good number of the SQL queries, we use WHERE prior to GROUP BY and HAVING after GROUP BY. The Where clause acts as a pre filter where as Having as a post filter.

##  Join

An SQL Join is used to combine data from two or more tables, based on a common field between them.


## view in SQL? How to create one

A view is a virtual table based on the result-set of an SQL statement. We can create using create view syntax.

```
CREATE VIEW view_name AS
SELECT column_name(s)
FROM table_name
WHERE condition
```

**uses of view**

1. Views can represent a subset of the data contained in a table; consequently, a view can limit the degree of exposure of the underlying tables to the outer world: a given user may have permission to query the view, while denied access to the rest of the base table.
2. Views can join and simplify multiple tables into a single virtual table
3. Views can act as aggregated tables, where the database engine aggregates data (sum, average etc.) and presents the calculated results as part of the data
4. Views take very little space to store; the database contains only the definition of a view, not a copy of all the data which it presented.

---

## indexes

A database index is a data structure that improves the speed of data retrieval operations on a database table at the cost of additional writes and the use of more storage space to maintain the extra copy of data.

Data can be stored only in one order on disk. To support faster access according to different values, faster search like binary search for different values is desired, For this purpose, indexes are created on tables. These indexes need extra space on disk, but they allow faster search according to different frequently searched values







## ACID properties

