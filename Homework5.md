#Homework 4
### Skiena 3-2, 3-5, 3-9. 
### Problem 3-2
We are to write a program to reverse the direction of a given singly-linked list.
```
    public Node reverse(){

       Node current, next, previous;
        previous = null;
        current = this.first;

        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
```

### Problem 3-5
Find the overhead fraction (the ration of data space over total space) for each of the following binary tree implementations on n nodes:
(a) All node store data, two child pointers, and  a parent pointer. The data field requires four bytes and each pointer requires four bytes.

#####Answer
-----
We have n nodes in the BST. The total number of data space = 4*n. The total number of pointer space = (3*4)*n = 12*n. The total number of space then is  : 4*n + 12 *n = 16 *n. The ration of data space over total space is : 4/16 = 1/4 = 25%.

b) only leaf nodes store data; internal nodes store two child pointers. The data field requires four bytes and each pointer requires two bytes.

#####Answer
-----

Given that the binary search tree has a height of h and assumning that the total number of nodes is some power of 2. Thus n = 2^k. Then we know that the total number of leaves is 2^h. Now because only leaf nodes store data, we use 2^h * 2 bytes =  2^ (h+1) bytes. The number of internal nodes is 2^k -1 (not counting the root of the tree). Therefore the total number of bytes for each node is 2*2bytes * [2^k -1] = 2^2k - 2^2.

The ration then becomes  = (2^ (h+1)) / (2^2k - 2^2.)

###Problem 3-9
Here we are to concatenate two binary search trees into one binary search tree in O(h) time, where h is the maximal height of the two trees.

#####Answer
----------
A binary search tree is defined recursively as:
1. empty(null)
2. (a t1 t2) where a is the root node and t1 and t2 are binary search trees.

In order to concatenate two BST to one we must make sure to maintain the property of binary search trees in the resulting tree.
This implies that the values of the nodes in the left subtree should be < the value of the root and the value of the nodes in the right subtree should be > the value of the node.

Given two trees S1 and S2, our algorithm is as follows such that all the values in S1 are < all the values in S2, our algorithms is as follows:
```
1. if S1 is null then our resultant is S2.
2. if S2 is null then our resultant is S1.
3. if Neither S1 nor S2 are null, find the maximum value in S1. Max(S1). 
4. Next find the minimum value in S2, Min(S2)
5. find the average of those two values. [Max(S1) + (Max S2) ]/2. This becomes the value of the root of the resultant tree.
6. let t1 be S1 for the resultant tree and let t2 be S2 for the resultant tree.
7. Delete [Max(S1) + (Max S2) ]/2 from any of the subtrees if it exists.
```
