# Java-threading-and-locks
Java concurrency examples demonstrating deadlock, ReentrantLock, ReadWriteLock, fairness, tryLock, and multithreading best practices.
Java Concurrency & Multithreading Examples
This repository contains multiple Java examples demonstrating core multithreading concepts such as Deadlock, Reentrant Locks, Fair vs Unfair Locks, ReadWriteLocks, and tryLock() with timeout.
These examples are useful for Java backend developers, students, and interview preparation.

📌 Contents
1. Deadlock Example
DeadLockExample.java
Demonstrates how deadlock happens when two threads hold locks in opposite order.
Shows the classic scenario using Pan and Paper objects.

2. Read-Write Lock Example
ReadWriterCounter.java
Shows how ReentrantReadWriteLock allows:
Multiple threads to read at the same time.
Only one thread to write at a time.
Good for high-read, low-write scenarios.

3. Fair Lock Example
FairnessExample.java
Uses ReentrantLock(true) to enable fairness, meaning:
First thread waiting will get the lock first.
Prevents thread starvation.

4. Unfair Lock Example
UnfairLockExample.java
Uses ReentrantLock() without fairness.
Shows how threads may acquire locks out of order.
Demonstrates the use of tryLock() to avoid blocking indefinitely.

5. Bank Account Example (tryLock with Timeout)
BankAccount.java
Demonstrates:
Using tryLock(timeout) to avoid deadlocks.
Simulating real-world withdrawal from shared resource.
Handling insufficient balance and lock contention.
