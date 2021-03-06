# Serialization

Serialization is process of converting object into byte stream. Serialized object (byte stream) can be:
- Transferred over network.
- Persisted/saved into file.
- Persisted/saved into database.

Once, object have have been transferred over network or persisted in file or in database, we could deserialize the object and retain its state as it is in which it was serialized

## Serialize and DeSerialize object in java

In order to serialize object our class needs to implement `java.io.Serializable` interface. Serializable interface is **Marker interface** i.e. it **does not have any methods of its own**, but it **tells Jvm that object has to converted into byte stream**.

### Serialization

Create object of ObjectOutput and give its reference variable name `oout` and call `writeObject()` method and pass our employee object as parameter [oout.writeObject(object1) ]

```java
OutputStream fout = new FileOutputStream("ser.txt");
ObjectOutput oout = new ObjectOutputStream(fout);
oout.writeObject(object1);
```

### Deserialization

Create object of ObjectInput and give it’s reference variable name `oin` and call `readObject()` method [oin.readObject() ]

```java
InputStream fin=new FileInputStream("ser.txt");
ObjectInput oin=new ObjectInputStream(fin);
System.out.println("DeSerialization process has started, displaying employee objects...");
Employee emp;
emp=(Employee)oin.readObject();
```

During deserialization process when file is read till end using readObject() in while loop then EOFException is thrown. Java Api doesn’t provide any elegant solution to signify end the file. Solution:

- Create a class `EofIndicatorClass` which `implements` `Serializable` interface.
- During serialization - Write instance of EofIndicatorClass at EOF during serialization to indicate EOF during deSerialization process.
- During DeSerialization If oin.readObject() returns instanceof EofIndicatorClass that means it's EOF, exit while loop and EOFException will not be thrown.

---

## Some Pointers

- Primitive types are also part of serialization process.
- ArrayList, HashSet and HashMap implements Serializable interface, so if we will use them as member of class they will get Serialized and DeSerialized as well.
- If any of the member does not implement Serializable than `NotSerializableException` is thrown. (In java 8 null is returned)
- If superClass has implemented Serializable that means subclass is also Serializable (as subclass always inherits all features from its parent class), for avoiding Serialization in sub-class we can define `writeObject()` method and throw `NotSerializableException()` from there as done below.

	```java
	private void writeObject(ObjectOutputStream os) throws NotSerializableException {
     throw new NotSerializableException("This class cannot be Serialized");
	} 
	```
- We can customize Serialization process by defining `writeObject()`  method & DeSerialization process by defining `readObject()` method.	
- int will be initialized to 0 and Integer will be initialized to null during DeSerialization if they were not part of Serialization.




---

## Externalizable 

By implementating java.io.Serializable, you get "automatic" serialization capability for objects of your class. The Java runtime will use reflection to figure out how to marshal and unmarshal your objects.

In earlier version of Java, reflection was very slow, and so serializaing large object graphs (e.g. in client-server RMI applications) was a bit of a performance problem. To handle this situation, the `java.io.Externalizable` interface was provided, which is like `java.io.Serializable` but with custom-written mechanisms to perform the marshalling and unmarshalling functions (you need to implement `readExternal` and `writeExternal` methods on your class). This gives you the means to get around the reflection performance bottleneck.

A big downside of Externalizable is that you have to maintain this logic yourself - if you add, remove or change a field in your class, you have to change your writeExternal/readExternal methods to account for it.

---

## SerialVersionUID
 
`serialVersionUID` is used for **version control of object**. If we  don’t define serialVersionUID in the class, and any modification is made in class, then we won’t be able to deSerialize our class because `serialVersionUID` generated by java compiler for modified class will be different from old serialized object. And deserialization process will end up throwing 	`java.io.InvalidClassException`  (because of serialVersionUID mismatch)
 
The serialization at runtime associates with each serializable class a version number, called a serialVersionUID, which is used during deserialization to verify that the sender and receiver of a serialized object have loaded classes for that object that are compatible with respect to serialization.

When we Deserialize class ( class which has been modified after Serialization and also class doesn’t declare `SerialVersionUID` ) `InvalidClassException` is thrown.

When we Deserialize class ( class which has been modified after Serialization and also class declare `SerialVersionUID`) its gets DeSerialized successfully.

---

## Constructor calls during DeSerialization process

It depends on whether our object has implemented Serializable or Externalizable. If Serializable has been implemented - constructor is not called during DeSerialization process. But, if Externalizable has been implemented - constructor is called during DeSerialization process.

### constructor calls of super class during DeSerialization process of sub class in java
	
It is depends on whether our superclass has implemented Serializable or not. If superclass has implemented Serializable - constructor is not called during DeSerialization process. If superclass has not implemented Serializable - constructor is called during DeSerialization process.

---

## How DeSerialization works?

An instance of the class is allocated. The instance and its handle are added to the set of known objects. The no-arg constructor for the first non-serializable supertype is run.

- For serializable classes, the fields are initialized to the default value appropriate for its type.
- Then the fields of each class are restored by calling class-specific `readObject` methods, or if these are not defined, by calling the `defaultReadObject` method.
- Note that *field initializers and constructors are not executed for serializable classes during deserialization*.
- In the normal case, the version of the class that wrote the stream will be the same as the class reading the stream. In this case, all of the supertypes of the object in the stream will match the supertypes in the currently-loaded class.
- If the version of the class that wrote the stream had different supertypes than the loaded class, the `ObjectInputStream` must be more careful about restoring or initializing the state of the differing classes.
- It must step through the classes, matching the available data in the stream with the classes of the object being restored. Data for classes that occur in the stream, but do not occur in the object, is discarded.
- For classes that occur in the object, but not in the stream, the class fields are set to default values by default serialization.

---

## Avoiding Deserialization process for Singleton class

We can simply use readResolve() method to return same instance of class, rather than creating a new one. Defining readResolve() method ensures that we don't break singleton pattern during DeSerialization process.

```java
private Object readResolve() 
  throws ObjectStreamException {
    return INSTANCE;
}
```

Also define readObject() method, rather than creating new instance, assign current object to INSTANCE like done below :

```java  
private void readObject(ObjectInputStream ois) throws IOException,ClassNotFoundException{
	ois.defaultReadObject();
	synchronized (SingletonClass.class) {
	 if (INSTANCE == null) {
		   INSTANCE = this;
	 }
	}
}
```

---

## Static and Transient are not serialized 

static member variables are not part of java serialization process. Serialization is applicable on objects or primitive data types only, but static members are class level variables, therefore, different object’s of same class have same value for static member. So, serializing static member will consume unnecessary space and time. Also, if modification is made in static member by any of the object, it won’t be in sync with other serialized object’s value.

Serialization is not applicable on transient variables (it helps in saving time and space during Serialization process), we must mark all rarely used variables as transient. We can initialize transient variables during deSerialization by customizing deSerialization process.

---

## Compatible and incompatible changes in Serialization and DeSerialization

### Compatible Changes :  

Compatible changes are those changes which does not affect deSerialization process even if class was updated after being serialized (provided serialVersionUID has been declared).

- Adding new fields - We can add new member variables in class.
- Adding writeObject()/readObject()  methods - We may add these methods to customize serialization process.
- Removing writeObject()/readObject() methods - We may remove these methods and then default customization process will be used.
- Changing access modifier of a field - The change to access modifiers i.e. public, default, protected, and private have no effect on the ability of serialization to assign values to the fields.
- Changing a field from static to non static OR changing transient filed to non transient field. - it’s like addition of fields.
 
### InCompatible Changes :
  
InCompatible changes are those changes which affect deSerialization process if class was updated after being serialized (provided serialVersionUID has been declared)

- Deletion of fields.
- Changing a nonstatic field to static or  non transient field to transient field. - it’s equal to deletion of fields.
- Modifying the writeObject() / readObject() method - we must not modify these method, though adding or removing them completely is compatible change. 
 
---

## Serialization Alternatives

- We can can convert JSON to transfer the object. JSON is helpful in stringifying and de stringifying object.
- Hibernate (ORM tool) helps in persisting object as it in database and later we can read persisted object.
- We can convert object into XML (as done in web services) and transfer object over network.