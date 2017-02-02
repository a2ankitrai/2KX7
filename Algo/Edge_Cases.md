# Edge Cases

**String with some known special cases:**

- Empty string
- Long string
- Unicode string (special characters)
- If limited to a specific set of characters, what happens when some are not in the range
- Odd/even length string
- Null (as argument)
- Non-null terminated

---

**Integer with known special cases:**

- 0
- Min/MaxInt
- Negative/Positive

---

**Sort algorithm that could fail in the following boundary cases:**

- Empty input
- 1 element input
- Very long input (maybe of length max(data type used for index))
- Garbage inside the collection that will be sorted
- Null input
- Duplicate elements
- Collection with all elements equal
- Odd/even length input

---

Then, take all these cases and create a long list trying to understand how they overlap. Ex:

- Empty string case covers the empty collection case
- Null string == null collection
- etc.
Now create test cases for them :)