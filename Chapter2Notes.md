#Chapter 2 notes
### RAM model
-------
The Random Access Machine is characterised by

1. Simpe operations take one step
2. Time it takes to run a loop is dependent on the number of iteratios and the sub program itself
3. Memory access is a one step operation. There is an infinite memory and we are not considering intricases such as caching or disk speed.

Overall the total time = total steps taken in the algorithm. The RAM model gives as the opportunity to study algorithms independent of the machine. It is a very high level understanding of the machine

### Best, worst and average case
--------------
 Here, we are dealing with how algorithms perfomr for all inputs(in terms of the sizes of inputs). 
 We generally talk about: the best case, average case and worst-case.
 
 The differnet cases are basically numerical functions representing time vs input size.
 
 ### Big Oh notation
 -------------
 
###2.3.1 : Dominance Relations
-------
+ Big Oh allows us to group functions into classes. eg the functions f(n)=  0.4566n and g(n) = 64n belong to the same class Theta(n)
+ When two functions do not belong to the same class, one function has to dominate the other. Thus given the functions f(n) and g(n) 
which belong to different classes, either f(n) =O(g(n)) or g(n) = O(f(n))
+ For the functions we will be working with, we have dominance as follows : n! >> 2^n >> n^3 >> n^2 >> n log n >> n  log n >> 1

### 2.4 Working with the Big Oh
-------------
+ When adding functions the sum of two functions is governed by the dominant one


#### Useful links
--------
http://www.algorithm.cs.sunysb.edu/algowiki/index.php/Algo-analysis-TADM2E
http://cseweb.ucsd.edu/classes/sp08/cse101/hw/hw1soln.pdf
