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

Answer
-----
We have n nodes in the BST. The total number of data space = 4*n. The total number of pointer space = (3*4)*n = 12*n. The total number of space then is  : 4*n + 12 *n = 16 *n. The ration of data space over total space is : 4/16 = 1/4 = 25%.

b) only leaf nodes store data; internal nodes store two child pointers. The data field requires four bytes and each pointer requires two bytes.

Answer
-----

Given that the binary search tree has a height of h and assumning that the total number of nodes is some power of 2. Thus n = 2^k. Then we know that the total number of leaves is 2^h. Now because only leaf nodes store data, we use 2^h * 2 bytes =  2^ (h+1) bytes. The number of internal nodes is 2^k -1 (not counting the root of the tree). Therefore the total number of bytes for each node is 2*2bytes * [2^k -1] = 2^2k - 2^2.

The ration then becomes  = (2^ (h+1)) / (2^2k - 2^2.)
