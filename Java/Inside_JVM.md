# Inside JVM

---

# Introduction to Java's Architecture

Java was designed for networks. Its suitability for
networked environments is inherent in its architecture, which enables secure, robust, platform independent
programs to be delivered across networks and run on a great variety of computers and
devices.

Another challenge the network presents to software developers is security. In addition to their potential
for good, networks represent an avenue for malicious programmers to steal or destroy information, steal
computing resources, or simply be a nuisance. Virus writers, for example, can place their wares on the
network for unsuspecting users to download. Java addresses the security challenge by providing an
environment in which programs downloaded across a network can be run with customizable degrees of
security. A downloaded program can do anything it wants inside the boundaries of the secure
environment, but canít read or write data outside those boundaries.

Platform independence, security, and network-mobility--these three facets of Javaís architecture work
together to make Java suitable for the emerging networked computing environment. Because Java
programs are platform independent, network-delivery of software is more practical. The same version of
a program can be delivered to all the computers and devices the network interconnects. Javaís built-in
security framework also helps make network-delivery of software more practical. By reducing risk, the
security framework helps to build trust in a new paradigm of network-mobile code.

A Java Virtual Machine's main job is to load class files and execute the bytecodes they contain.
