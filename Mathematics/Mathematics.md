# Mathematics

---

## Representing numbers in different bases

---

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

- all integer numbers (except 0 and 1) are made up of primes.

- Some important cryptographic algorithms such as RSA critically depend on the fact that prime factorization of large numbers takes a long time. 

- Basically you have a "public key" consisting of a product of two large primes used to encrypt a message, and a "secret key" consisting of those two primes used to decrypt the message. You can make the public key public, and everyone can use it to encrypt messages to you, but only you know the prime factors and can decrypt the messages. Everyone else would have to factor the number, which takes too long to be practical, given the current state of the art of number theory.

- The product of the two prime numbers can be used as a public key, while the primes themselves as a private key. Any operation done to data that can only be undone by knowing one of the two factors will be non-trivial to unencrypt.

- The RSA encryption algorithm which is commonly used in secure commerce web sites, is based on the fact that it is easy to take two (very large) prime numbers and multiply them, while it is extremely hard to do the opposite - meaning: take a very large number, given which it has only two prime factors, and find them.

---

## Integer number factorization

Integer factorization is the decomposition of a composite number ( a positive integer that can be formed by multiplying together two smaller positive integers) into a product of smaller integers. If these integers are further restricted to prime numbers, the process is called prime factorization.

When the numbers are very large, no efficient, non-quantum integer factorization algorithm is known. 
 
If you multiply two large prime numbers, you get a huge non-prime number with only two (large) prime factors. A **semiprime** (also called biprime or 2-almost prime, or pq number) is a natural number that is the product of two (not necessarily distinct) prime numbers

--- 
### The Sieve of Eratosthenes

The Sieve of Eratosthenes will generate all the primes from 2 to a given number n. It begins by assuming that all numbers are prime. It then takes the first prime number and removes all of its multiples. It then applies the same method to the next prime number. This is continued until all numbers have been processed. Below is the code for the sieve:

```
public boolean[] sieve(int n)
{
   boolean[] prime=new boolean[n+1];
   Arrays.fill(prime,true);
   prime[0]=false;
   prime[1]=false;
   int m=Math.sqrt(n);

   for (int i=2; i<=m; i++)
      if (prime[i])
         for (int k=i*i; k<=n; k+=i)
            prime[k]=false;

   return prime;
}
```



- How to efficiently find all prime divisors of an integer.
- checking if a number is prime or finding the Nth prime number are fundamental tasks with multiple applications.

---

## Greatest common divisor (GCD)

The greatest common divisor (GCD) of two numbers a and b is the greatest number that divides evenly into both a and b. Naively we could start from the smallest of the two numbers and work our way downwards until we find a number that divides into both of them:

```
for (int i=Math.min(a,b); i>=1; i--)
   if (a%i==0 && b%i==0)
      return i;
```

Although this method is fast enough for most applications, there is a faster method called Euclid’s algorithm. Euclid’s algorithm iterates over the two numbers until a remainder of 0 is found.

This algorithm can be easily coded as a recursive function:

```
//assume that a and b cannot both be 0
public int GCD(int a, int b)
{
   if (b==0) return a;
   return GCD(b,a%b);
}
```

**efficient algorithm for computing GCD** - *Euclid’s algorithm*

---
 
## Sum of Numbers

sum of n integers = n*(n+1)/2


---

## the essentials of combinatorics and probability


