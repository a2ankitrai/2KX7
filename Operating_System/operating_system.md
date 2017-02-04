# Operating System
---

## Process

A process is an instance of program in execution. 

The operating system is responsible for managing all the processes that are running on a computer and allocated each process a certain amount of time to use the processor. In addition, the operating system also allocates various other resources that processes will need such as computer memory or disks. To keep track of the state of all the processes, the operating system maintains a table known as the **process table**. Inside this table, every process is listed along with the resources the processes is using and the current state of the process.

**Processes can be in one of three states: running, ready, or waiting**. 

---

## Threads

Despite of the fact that a thread must execute in process, the process and its associated threads are different concept. Processes are used to group resources together and threads are the entities scheduled for execution on the CPU.

*A thread is a single sequence stream within in a process.* Because threads have some of the properties of processes, they are sometimes called lightweight processes. In a process, threads allow multiple executions of streams. In many respect, threads are popular way to improve application through parallelism. The CPU switches rapidly back and forth among the threads giving illusion that the threads are running in parallel. Like a traditional process i.e., process with one thread, a thread can be in any of several states (Running, Blocked, Ready or Terminated).

Each thread has its own stack. Since thread will generally call different procedures and thus a different execution history. This is why thread needs its own stack. An operating system that has thread facility, the basic unit of CPU utilization is a thread. A thread has or consists of a program counter (PC), a register set, and a stack space. Threads are not independent of one other like processes as a result threads shares with other threads their code section, data section, OS resources  also known as task, such as open files and signals.

**Processes Vs Threads**

*Similarities*

- Like processes threads share CPU and only one thread active (running) at a time. 
- Like processes, thread can create children.
- And like process, if one thread is blocked, another thread can run.

*Differences*

- Unlike processes, threads are not independent of one another. 
- Unlike processes, thread are design to assist one other. Note that processes might or might not assist one another because processes may originate from different users.

### User-Level Threads

User-level threads implement in user-level libraries, rather than via systems calls, so thread switching does not need to call operating system and to cause interrupt to the kernel. In fact, the kernel knows nothing about user-level threads and manages them as if they were single-threaded processes.

*Advantages*

- User-level threads does not require modification to operating systems.

- Simple Representation: Each thread is represented simply by a PC, registers, stack and a small control block, all stored in the user process address space.

- Simple Management: This simply means that creating a thread, switching between threads and synchronization between threads can all be done without intervention of the kernel.

- Fast and Efficient: Thread switching is not much more expensive than a procedure call.

*Disadvantages*

- There is a lack of coordination between threads and operating system kernel. Therefore, process as whole gets one time slice irrespect of whether process has one thread or 1000 threads within. It is up to each thread to relinquish control to other threads.

- User-level threads requires non-blocking systems call i.e., a multithreaded kernel. Otherwise, entire process will blocked in the kernel, even if there are runable threads left in the processes. For example, if one thread causes a page fault, the process blocks.

### Kernel-Level Threads

In this method, the kernel knows about and manages the threads. No runtime system is needed in this case. Instead of thread table in each process, the kernel has a thread table that keeps track of all threads in the system. In addition, the kernel also maintains the traditional process table to keep track of processes. Operating Systems kernel provides system call to create and manage threads.

*Advantages*:

- Because kernel has full knowledge of all threads, Scheduler may decide to give more time to a process having large number of threads than process having small number of threads.

- Kernel-level threads are especially good for applications that frequently block.

*Disadvantages:*

- The kernel-level threads are slow and inefficient. For instance, threads operations are hundreds of times slower than that of user-level threads.

- Since kernel must manage and schedule threads as well as processes. It require a full thread control block (TCB) for each thread to maintain information about threads. As a result there is significant overhead and increased in kernel complexity.

---

## Context Switch

To give each process on a multiprogrammed machine a fair share of the CPU, a hardware clock generates interrupts periodically. This allows the operating system to schedule all processes in main memory (using scheduling algorithm) to run on the CPU at equal intervals. Each time a clock interrupt occurs, the interrupt handler checks how much time the current running process has used. If it has used up its entire time slice, then the CPU scheduling algorithm (in kernel) picks a different process to run. Each switch of the CPU from one process to another is called a context switch.

**Major Steps of Context Switching**

- The values of the CPU registers are saved in the process table of the process that was running just before the clock interrupt occurred.

- The registers are loaded from the process picked by the CPU scheduler to run next.

**Action of Kernel to Context Switch Among Threads**

The threads share a lot of resources with other peer threads belonging to the same process. So a context switch among threads for the same process is easy. It **involves switch of register set, the program counter and the stack**. It is relatively easy for the kernel to accomplished this task.

**Action of kernel to Context Switch Among Processes**

Context switches among processes are expensive. Before a process can be switched its process control block (PCB) must be saved by the operating system. The PCB consists of the following information:

- The process state.
- The program counter, PC.
- The values of the different registers.
- The CPU scheduling information for the process.
- Memory management information regarding the process.
- Possible accounting information for this process.
- I/O status information of the process.

When the PCB of the currently executing process is saved the operating system loads the PCB of the next process that has to be run on CPU. This is a heavy task and it takes a lot of time.

---

- processes, threads and concurrency issues

- locks and mutexes and semaphores and monitors and how they work.

- deadlock and livelock and how to avoid them.

- resources a processes needs, and a thread needs

- how context switching works and how it's initiated by the operating system and underlying hardware

- scheduling



  