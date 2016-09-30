# Primitive types

The primitive types in Java are boolean, char, byte, short, int, long, float, and double.

| Type   	|Size in Bytes  			|  Range 																	|
| --------- |:-------------------------:| ------------------------------------------------------------------------- |
| byte  	| 1 byte  					| -128 to 127 																|   	
| short  	| 2 bytes  					| -32,768 to 32,767  														|   	
| int  		| 4 bytes  					| -2,147,483,648 to 2,147,483, 647  										|   	
| long  	| 8 bytes  					| -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807  					|   	
| float  	| 4 bytes  					|  approximately ±3.40282347E+38F (6-7 significant decimal digits) 			|   	
| double  	| 8 bytes 					| approximately ±1.79769313486231570E+308 (15 significant decimal digits)  	|   	
| char 		| 2 byte  					| 0 to 65,536 (unsigned)  													|  	
| boolean  	| not precisely defined*  	| true or false  															|   

---

# Bitwise operators

The signed left shift operator `<<` shifts a bit pattern to the left, and the signed right shift operator `>>` shifts a bit pattern to the right. The bit pattern is given by the left-hand operand, and the number of positions to shift by the right-hand operand. The unsigned right shift operator `>>>` shifts a zero into the leftmost position, while the leftmost position after `>>` depends on sign extension.

On applying bit shift operators to integers left shift operator `<<` **doubles** the left-hand operand by the amount of the right-hand operand. Conversely the right shift operator `>>` halves the left-hand operand by the amount of right hand operand

for e.g.
16 << 2  = 64
4 >> 1   = 2

**1) `>>` (Signed right shift)** In Java, the operator `>>` is signed right shift operator. All integers are signed in Java, and it is fine to use >> for negative numbers. The operator `>>` uses the sign bit (left most bit) to fill the trailing positions after shift. If the number is negative, then 1 is used as a filler and if the number is positive, then 0 is used as a filler. For example, if binary representation of number is 10….100, then right shifting it by 2 using `>>` will make it 11…….1.

**2) `>>>` (Unsigned right shift)** In Java, the operator `>>>` is unsigned right shift operator. It always fills 0 irrespective of the sign of the number.

In binary search to calculate the mid value don't use the following code
```
int mid =(low + high) / 2;
``` 
On the face of it, this assertion might appear correct, but it fails for large values of the int variables low and high. Specifically, it fails if the sum of low and high is greater than the maximum positive int value (231 - 1). The sum overflows to a negative value, and the value stays negative when divided by two. In C this causes an array index out of bounds with unpredictable results. In Java, it throws ArrayIndexOutOfBoundsException

Probably faster, and arguably as clear is:
```
	int mid = (low + high) >>> 1;
``` 



## COMPUTING PARITY

The parity of a sequence of bits is 1 if the number of Is in the sequence is odd;
otherwise, it is 0. Parity checks are used to detect single bit errors in data storage and communication.