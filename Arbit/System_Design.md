# System Design

Designing a high-level architecture for some sort of a software system.

## Some examples

- Design a URL shortening service like bit.ly.

- How would you implement the Google search?

- Design a client-server application which allows people to play chess with one another.

- How would you store the relations in a social network like Facebook and implement a feature where one user receives notifications when their friends like the same things as they do?

The idea of these questions is to have a discussion about the problem at hand. What’s important for the interviewer is the process, which you use to tackle the problem. The typical outcome of such a discussion is a high-level architecture addressing the goals and constraints in the question. Perhaps the interviewer will choose one or more areas where they will want to discuss bottlenecks and other common problems.

### Clarify the constraints and identify the user cases

Spend a few minutes questioning the interviewer and agreeing on the scope of the system. Remember to make sure you know all the requirements the interviewer didn't tell you about in the beginning.

User cases indicate the main functions of the system, and constraints list the scale of the system such as requests per second, requests types, data written per second, data read per second.

### High-level architecture design

Sketch the important components and the connections between them, but don't go into some details. Usually, a scalable system includes webserver (load balancer), service (service partition), database (master/slave database cluster plug cache).

### Component design

For each component, you need to write the specific APIs for each component. You may need to finish the detailed OOD design for a particular function. You may also need to design the database schema for the database.


## Scaling

Vertical scaling :  increasing processors (cores, caches), DISK, RAM

Horizontal scaling:  using mutliple servers and increasing them as the load increses.

---

## System Design Question Concepts

- Amount of data (disk)

- RAID configuration

- Amount of RAM – does everything need to be in RAM? (a lot of times – yes)

- Requests/sec

- Request time

- Data transfer rates

- Network requests in single data center

- Geographically separated locations

- Operations should never be more than nlogn, preferably n

- Sharding/Partitioning (by user/date/content-type/alphabetically) – how do we rebalance?

- Frontend/backend

- Backups? Backup a single user on how many servers?

- Many requests for the same data/lots of updates – all in cache

- Distribute so that the network is negligible

- Parallelizing network requests

- Fan-out (scatter and gather)

- Caching

- Load-balancing

- High availability

- MapReduce

- CDN

- Queues

- Timeouts

- Fail fast

- Circuit breakers

- Throttling

- Consistent hashing for sharding/partitioning

- Compression

- Possible to work harder on writes in order to make reads easier

---

### Some Famous Designs

- [Google Docs](http://blog.gainlo.co/index.php/2016/03/22/system-design-interview-question-how-to-design-google-docs/)
