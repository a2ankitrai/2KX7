# Interview Preparation
---
>Before everything else, getting ready is the secret of success. 
	- H. Ford
	
## The interview lifecycle
1. Identify companies that you are interested in, and, ideally, find people you know at these companies.

2. Prepare your resume using the guidelines below, and submit it via a personal contact (preferred), or through an online submission process.
		
	### The resume
	  Key points to keep in mind when writing a resume:
	  - Have a clear statement of your objective; in particular, make sure that you tailor your resume for a given employer.
		E.g., "My outstanding ability is developing solutions to computationally challenging problems; communicating them in written and oral form; and working with teams to implement them. I would like to apply these abilities at XYZ."
	  - The most important points—the ones that differentiate you from everyone else-should come first. People reading your resume proceed in sequential order, so you want to impress them with what makes you special early on.(Maintaining a logical flow, though desirable, is secondary compared to this principle.)
		* As a consequence, you should not list your programming languages, coursework, etc. early on, since these are likely common to everyone. You should list significant class projects (this also helps with keywords for HR.), as well as talks/papers you've presented, and even standardized test scores, if truly exceptional.
		
---

## Strategies For A Great Interview

>The essence of strategy is choosing what not to do.  
-M. E. PORTER		
	
A typical one hour interview with a single interviewer consists of five minutes of introductions and questions about the candidate's resume. This is followed by five to fifteen minutes of questioning on basic programming concepts. The core of the interview is one or two detailed design questions where the candidate is expected to present a detailed solution on a whiteboard, paper, or IDE. Depending on the interviewer and the question, the solution may be required to include syntactically correct code and tests.	
	
### Approaching the problem

No matter how clever and well prepared you are, the solution to an interview problem may not occur to you immediately. Here are some things to keep in mind when this happens.


***Clarify the question:*** This may seem obvious but it is amazing how many interviews go badly because the candidate spends most of his time trying to solve the wrong problem. If a question seems exceptionally hard, you may have misunderstood it.  
  A good way of clarifying the question is to state a concrete instance of the problem.For example, if the question is "find the first occurrence of a number greater than k in a sorted array", you could ask "if the input array is (2, 20, 30) and k is 3, then are you supposed to return 1, the index of 20?" These questions can be formalized as unit tests.
  
  
***Spell out the brute-force solution:*** Problems that are put to you in an interview tend to have an obvious brute-force solution that has a high time complexity compared to more sophisticated solutions.


try all the possible configurations. Advantages to this approach include: (1.) it helps you explore opportunities for optimization and hence reach a better solution, (2.) it gives you an opportunity to demonstrate some problem solving and coding skills, and (3.) it establishes that both you and the interviewer are thinking about the same problem. Be warned that this strategy can sometimes be detrimental if it takes a long time describe the brute-force approach.  


***Think out loud:*** One of the worst things you can do in an interview is to freeze
up when solving the problem. It is always a good idea to think out loud. On the
one hand, this increases your chances of finding the right solution because it forces
you to put your thoughts in a coherent manner. On the other hand, this helps the
interviewer guide your thought process in the right direction. Even if you are not able
to reach the solution, the interviewer will form some impression of your intellectual
ability.


***Apply patterns:*** Patterns-general reusable solutions to commonly occurring
problems can be a good way to approach a baffling problem. Examples include
finding a good data structure, seeing if your problem is a good fit for a general
algorithmic technique, e.g., divideand conquer, recursion, or dynamic programming,
and mapping the problem to a graph.


### Presenting the solution

Once you have an algorithm, it is important to present it in a clear manner. Your
solution will be much simpler if you use Java or C++,and take advantage of libraries
such as Collections or Boost. However, it is far more important that you use the
language you are most comfortable with. Here are some things to keep in mind
when presenting a solution.


***Libraries:*** Master the libraries, especially the data structures. Do not waste time
and lose credibility trying to remember how to pass an explicit comparator to a BST
constructor. Remember that a hash function should use exactly those fields which
are used in the equality check. A comparison function should be transitive.


***Focus on the top-level algorithm:*** It's OK to use functions that you will implement
later. This will let you focus on the main part of the algorithm, will penalize you
less if you don't complete the algorithm. (Hash, equals, and compare functions are
good candidates for deferred implementation.) Specify that you will handle main
algorithm first, then corner cases. Add TODO comments for portions that you want
to come back to.


***Manage the whiteboard:*** You will likely use more of the board than you expect,
so start at the top-left comer. Have a system for abbreviating variables, e.g., declare
stackMax and then use sm for short. Make use of functions-skip implementing
anything that's trivial (e.g., finding the maximum of an array) or standard (e.g., a
thread pool).


***Test for corner cases:*** For many problems, your general idea may work for most inputs but there may be pathological instances where your algorithm (or your
implementation of it) fails. For example, your binary search code may crash if the
input is an empty array; or you may doarithmetic without considering the possibility
of overflow. It is important to systematically consider these possibilities. If there is
time, write unit tests. Small, extreme, or random inputs make for good stimuli. Don't
forget to add code for checking the result. Often the code to handle obscure corner
cases may be too complicated to implement in an interview setting. If so, you should
mention to the interviewer that you are aware of these problems, and could address
them if required.

***Syntax:*** Interviewers rarely penalize you for small syntax errors since modem
integrated development environments (IDEs) excel at handling these details. However lots of bad syntax may result in the impression that you have limited coding
experience. Once you are done writing your program, make a pass through it to fix
any obvious syntax errors before claiming you are done.  

Have a convention for identifiers, e.g., i , j , k for array indices, A ,B, C for arrays,
hm for HashMap, s for a String, sb for a StringBuilder, etc.

---

## Algorithms, Data Structures, and System Design

Algorithms, data structures, and system design underlie all software. Algorithms and data structure code is usually a small component of a system dominated by the user interface (UI), I/O, and format conversion. It is often hidden in library calls. However, such code is usually the crucial component in terms of performance and correctness, and often serves to differentiate products. Furthermore, platforms and programming languages change quickly but a firm grasp of data structures, algorithms, and system design principles, will always be a foundational part of any successful software endeavor. Finally, many of the most successful software companies have hired based on ability and potential rather than experience or knowledge of specifics, underlying the effectiveness of this approach to selecting candidates.

---

## General conversation

Often interviewers will ask you questions about your past projects. The point of this conversation is to answer the following questions:

***Can the candidate clearly communicate a complex idea?*** This is one of the most important skills for working in an engineering team. If you have a grand idea to redesign a big system, can you communicate it to your colleagues and bring them on board? It is crucial to practice how you will present your best work. Being precise, clear, and having concrete examples can go a long way here. Candidates communicating in a language that is not their first language, should take extra care to speak slowly and make more use of the whiteboard to augment their words.

***Is the candidate passionate about his work?*** We always want our colleagues to be excited, energetic, and inspiring to work with. If you feel passionately about your work, and your eyes light up when describing what you've done, it goes a long way in establishing you as a great colleague. Hence when you are asked to describe a project from the past, it is best to pick something that you are passionate about rather than a project that was complex but did not interest you.

---

## Stress interviews

Some companies, primarily in the finance industry, make a practice of having one of the interviewers create a stressful situation for the candidate. The stress may be injected technically, e.g., via a ninja problem, or through behavioral means, e.g., the interviewer rejecting a correct answer or ridiculing the candidate. The goal is to see how a candidate reacts to such situations-does he fall apart, become belligerent, or get swayed easily. (Bear in mind you will not know a priori if a particular interviewer will be conducting a stress interview.)

---

## Learning from bad outcomes

The reality is that not every interview results in a job offer. There are many reasons for not getting a particular job. Some are technical..

Often, your interviewer may have spent a few minutes looking at your resume - this is a depressingly common practice. This can lead to your being asked questions on topics outside of the area of expertise you claimed on your resume, e.g., routing protocols or Structured Query Language (SQL). If so, make sure your resume is accurate, and brush up on that topic for the future.

You can fail an interview for nontechnical reasons, e.g., you came across as uninterested, or you did not communicate clearly. The company may have decided not to hire in your area, or another candidate with similar ability but more relevant experience was hired.

**You will not get any feedback from a bad outcome, so it is your responsibility to try and piece together the causes. Remember the only mistakes are the ones you don't learn from.**

---

## Negotiating an offer

An offer is not an offer till it is on paper, with all the details filled in. All offers are negotiable. We have seen compensation packages bargained up to twice the initial offer, but 10-20% is more typical. When negotiating, remember there is nothing to be gained, and much to lose, by being rude. (Being firm is not the same as being rude.)

To get the best possible offer, get multiple offers, and be flexible about the form of your compensation. For example, base salary is less flexible than stock options, signon bonus, relocation expenses, and Immigration and Naturalization Service (INS) filing costs. Be concrete—instead of just asking for more money, ask for a P% higher salary. Otherwise the recruiter will simply come back with a small increase in the sign-on bonus and claim to have met your request.

Your HR contact is a professional negotiator, whose fiduciary duty is to the company. He will know and use negotiating techniques such as reciprocity, getting consensus, putting words in your mouth ("don't you think that's reasonable?"), as well as threats, to get the best possible deal for the company. (This is what recruiters themselves are evaluated on internally.) The Wikipedia article on negotiation lays bare many tricks we have seen recruiters employ.

One suggestion: stick to email, where it is harder for someone to paint you into a corner. If you are asked for something (such as a copy of a competing offer), get something in return. Often it is better to bypass the HR contact and speak directly with the hiring manager.

At the end of the day, remember your long term career is what counts, and joining a company that has a brighter future (social-mobile vs. legacy enterprise), or offers a position that has more opportunities to rise (developer vs. tester) is much more important than a 10-20% difference in compensation.
