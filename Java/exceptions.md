# Exceptions


## ArrayStoreException

Thrown to indicate that an attempt has been made to store the wrong type of object into an array of objects. For example, the following code generates an ArrayStoreException:
```java
     Object x[] = new String[3];
     x[0] = new Integer(0);
```