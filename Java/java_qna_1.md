# Java Q & A - I

## Autoboxing Q + A

**Q.** Why does the first group of statements print true, but the second false?  	
```java
	Integer a1 = 100;
	Integer a2 = 100;
	System.out.println(a1 == a2);   // true

	Integer b1 = new Integer(100);
	Integer b2 = new Integer(100);
	System.out.println(b1 == b2);   // false

	Integer c1 = 150;
	Integer c2 = 150;
	System.out.println(c1 == c2);   // false
```  


**A.**  The second prints `false` because `b1` and `b2` are references to different Integer objects. The first and third code fragments rely on autoboxing. Surprisingly the first prints true because values between -128 and 127 appear to refer to the same immutable Integer objects (Java's implementation of `valueOf()` retrieves a cached values if the integer is between -128 and 127), while Java constructs new objects for each integer outside this range.	

## Algorithm Analysis

**Q.** How do I increase the amount of memory and stack space that Java allocates?  


**A.** You can increase the amount of memory allotted to Java by executing with `java -Xmx200m Hello` where 200m means 200 megabytes. The default setting is typically 64MB. You can increase the amount of stack space allotted to Java by executing with `java -Xss200k Hello` where 200k means 200 kilobytes. The default setting is typically 128KB. It's possible to increase both the amount of memory and stack space by executing with `java -Xmx200m -Xss200k Hello`.