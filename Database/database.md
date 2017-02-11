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

---

## Difference between `rownum` and `rowid`?

ROWID uniquely identifies where a row resides on disk. The ROWNUM is a "pseudo-column", a placeholder that you can reference.

The difference between ROWNUM and ROWID is that ROWNUM is temporary while ROWID is permanent.  Another difference is that ROWID can be used to fetch a row, while ROWNUM only has meaning within the context of a single SQL statement, a way of referencing rows within a fetched result set.

to only display the first-10 rows, you might apply a ROWNUM filter:

```
select * 
from (
   select * from my_view where alert_level=3 order by alert_time desc) 
where 
    rownum<=10;
```



---

##  Join

JOIN is used to combine the results of two tables. To perform a JOIN, each of the tables must have at
least one field that will be used to find matching records from the other table. The join type defines which
records will go into the result set.

INNER JOIN, OUTER JOIN: LEFT OUTER JOIN, RIGHT OUTER JOIN, FULL OUTER JOIN:

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

---

## Denormalized vs. Normalized Databases

Normalized databases are designed to minimize redundancy, while denormalized databases are designed
to optimize read time.

In a traditional normalized database with data like Courses and Teachers, Courses might contain a
column called TeacherID, which is a foreign key to Teacher. One benefit of this is that information about
the teacher (name, address, etc.) is only stored once in the database. The drawback is that many common
queries will require expensive joins.

Instead, we can denormalize the database by storing redundant data. For example, if we knew that we
would have to repeat this query often, we might store the teacher's name in the Courses table. Denormalization
is commonly used to create highly scalable systems.

Under denormalization, we decide that we're okay
with some redundancy and some extra effort to update the database in order to get the efficiency advantages
of fewer joins.

Cons of Denormalization 

- Updates and inserts are more expensive.

- Denormalization can make update and insert code Queries to retrieve can be simpler (and therefore
harder to write.

- Data may be inconsistent. Which is the "correct" value for a piece of data?
- Data redundancy necessitates more storage.

Pros of Denormalization

- Retrieving data is faster since we do fewer joins.
- Queries to retrieve can be simpler (and therefore less likely to have bugs), since we need to look at
fewer tables.


## ACID properties

----


# Question

- Delete duplicate rows in table?

- Kth largest row in a table.

- select the max salary
	
	```
	SELECT Name, Salary FROM Minions
	WHERE Salary = (SELECT Max(Salary) FROM Minions)
	```
	
-  Difference between RANK() and DENSE_RANK() function?
	
	RANK gives you the ranking within your ordered partition. Ties are assigned the same rank, with the next ranking(s) skipped. So, if you have 3 items at rank 2, the next rank listed would be ranked 5. The analytic function rank() will rank the rows with gaps in ranking sequence if there are ties.

	```
	SQL> select ename
	2        ,sal
	3        ,rank() over (order by sal desc) ranking
	4  from   emp;

	ENAME             SAL    RANKING
	---------- ---------- ----------
	KING             5000          1
	FORD             3000          2
	SCOTT            3000          2
	JONES            2975          4
	CLARK            2850          5
	BLAKE            2850          5
	ALLEN            1600          7
	TURNER           1500          8
	```
	
	DENSE_RANK again gives you the ranking within your ordered partition, but the ranks are consecutive. No ranks are skipped if there are ranks with multiple items.
	
	```
	SQL> select ename
	2        ,sal
	3        ,dense_rank() over (order by sal desc) ranking
	4  from   emp;

	ENAME             SAL    RANKING
	---------- ---------- ----------
	KING             5000          1
	FORD             3000          2
	SCOTT            3000          2
	JONES            2975          3
	CLARK            2850          4
	BLAKE            2850          4
	ALLEN            1600          5
	```
	
	Wrap a filter around and pick out the Nth highest salary, say the 4th highest salary.

	```
	SQL> select *
	2  from
	3  (
	4    select ename
	5          ,sal
	6          ,dense_rank() over (order by sal desc) ranking
	7    from   emp
	8  )
	9  where ranking = 4 -- Replace 4 with any value of N
	10  /

	ENAME             SAL    RANKING
	---------- ---------- ----------
	BLAKE            2850          4
	CLARK            2850          4
	```