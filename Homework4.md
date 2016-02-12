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
