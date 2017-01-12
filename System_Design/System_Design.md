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


---

## At the interview

So what should you do at your interview?

First of all, follow the System Design Process. You already know how to apply it, so we'll be brief. Don't skip steps, don't make assumptions, start broad and go deep when asked.

Second, keep in mind that system design questions serve as an idea exchange platform. Be prepared for discussions about tradeoffs, about pros and cons. Be prepared to give alternatives, to ask questions, to identify and solve bottlenecks, to go broad or deep depending on your interviewer's preferences.

Don't get defensive: whenever your interviewer challenges your architectural choices, acknowledge that rarely an idea is perfect, and outline the advantages and disadvantages of your choice. Be open to new constraints to pop up during the discussion and to adjust your architecture on the fly.

Most of all, have fun. Dreaming up architectures is a very stimulating mental process - enjoy it and stay positive. You're already equipped with the right knowledge, just apply it during your interview and you'll do well.

---
### Some Famous Designs

- [Google Docs](http://blog.gainlo.co/index.php/2016/03/22/system-design-interview-question-how-to-design-google-docs/)

---

## Uber

