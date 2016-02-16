#Chapter 2 notes
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
