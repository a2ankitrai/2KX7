# Mathematics

## Representing numbers in different bases

## Integer number factorization

## Prime numbers

A number is prime if it is only divisible by 1 and itself. To find if a number n is prime we could simply check if it divides any numbers below it. We can use the modulus (%) operator to check for divisibility:

```
for (int i=2; i<n; i++)
   if (n%i==0) return false;

return true;
```

We can make this code run faster by noticing that we only need to check divisibility for values of i that are less or equal to the square root of n (call this m). If n divides a number that is greater than m then the result of that division will be some number less than m and thus n will also divide a number less or equal to m. Another optimization is to realize that there are no even primes greater than 2. Once we’ve checked that n is not even we can safely increment the value of i by 2. 

The final method for checking whether a number is prime:

```
public boolean isPrime (int n)
{
   if (n<=1) return false;
   if (n==2) return true;
   if (n%2==0) return false;
   int m=Math.sqrt(n);

   for (int i=3; i<=m; i+=2)
      if (n%i==0)
         return false;

   return true;
}
```

--- 
### The Sieve of Eratosthenes



- How to efficiently find all prime divisors of an integer.
- checking if a number is prime or finding the Nth prime number are fundamental tasks with multiple applications.

## Greatest common divisor (GCD)

The GCD of two integers gives you the greatest integer that divides both integers.

**efficient algorithm for computing GCD**

