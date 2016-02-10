#Homework 3

Worked with Ajuna, Larry, Uzo

###Problem 3-1.
We are to develop an algorithm that returns true if a string contains properly nested and balanced parentheses and false if otherwise.
```
def check_balanced_paren(paren)
  stack = Stack.new
  is_balanced = true
  
  paren.each | ch| do
   if ch = '('
    stack.push(ch)
   else {
    poped_val = stack.pop
   }
   end
   
   if poped_val == null
    return false
   end

  end

end
```
Alternatively we can have a non stack implementation as follows:
```
public class ParenAlgorithms{
	public static boolean checkParenMatch(String parens){
		char [] p = parens.toCharArray();
		boolean balanced = true;
		if(!isEmpty(p)){
			int numOpenParens = 0;
			for (int i= 0; i< p.length ;i++){
				char currentCh = p[i];
				if(isOpenParen(currentCh))
					numOpenParens++;
				else
					numOpenParens--;
				if(numOpenParens < 0){
					balanced = false;
					break;
				}
			}//for
		}//if
		return balanced;
	}
	
	public static  boolean isEmpty(char arr []){
		return (arr.length == 0);
	}

	public static boolean isOpenParen(char ch){
		return ch == '(';
	}

	public static void main(String [] args){
		String test1="(()())(";
		System.out.println("Test1 : " + checkParenMatch(test1));
	}
}
```

###Problem 3-4
We are to design a ditionary data struct ure where search insertion and deltion can all be processed in O(1) time.
```
import java.util.ArrayList;

public class MyDictionary<K,V> {
	ArrayList<K> keys;
	ArrayList<V> values;
	public class MyDictionary(){
		keys = new ArrayList();
		values = new ArrayList();
	}

	private int hash(Key key){
		return key.hashCode;
	}

	public V get(K key){
		if(key == null)
			return null;
		int hashIndex = hash(key);
		return values[hashIndex];
	}

	public V put(Key key, V value){
		if(key == null)
			return null;
		int hashIndex = hash(key)
		V oldVal = values[hashIndex];
		values[hashIndex] = value;
		return oldVal;
	}

	public V remove(Key key){
		int hashIndex = hash(key);
		K key = keys[hashIndex];
		V oldVal = values[hashIndex];
		return ( key == null ? null : oldVal);
	}

}
```
### Problem 3-7
```

class BST<K, V> {
	Node root;
	V maximum;
	V minimum

//Functions
	private void insertHelper(Node root, Node temp) {
	if (root == null)
		root = temp;
	if (root.key.compareTo(key) < 0)
		insertHelper(root.right, temp);
	else
		insertHelper(root.left, temp);
	if (maximum.compareTo(value) > 0)
		maximum = value;
	else if (minimum.compareTo(value) > 0)
		minimum = value;
}

private void insert (Key key, V value) {
	if (key = null)
		throwNewException(“Key cannot be null”)
	Node node = newNode(key, value);
	insertHelper (this.root, node);
}

private V searchHelper(Key key) {
	int compareVal = this.root.key.compareTo(key);
	if(compareVal ==0)
		return this.root.value;
 	else if (compareVal <0)
		return searchHelper(this.root.right,key)
	else 
		return search(this.root.left,key);
}



Delete: 

For our delete function we employ a recursion on the structure of the BST in order to find the particular node to remove. We shall discuss the details of the recursion in different cases:

i) Case 1: When the node we aim to delete is the root node.

Here we run into some difficulty. Simply deleting the root node puts our entire BST at risk. By definition we cannot have a BST without a root so we must find a replacement. 

To keep our the property of the BST intact we search the right subtree of the root for the “biggest” node and make that node our new root.

ii)Case 2: When the node we aim to delete is in the right subtree.

We recursively search for the node on the right hand side and employ a similar technique as discussed in case 2.

iii)Case 3: When the node we aim to delete is in the left subtree.

We recursively search for the node on the left hand side of the tree and employ a similar technique as discussed in case 2.


Overall, we keep in mind whether or not we deleting the maximum or minimum node and update the minimum/maximum values accordingly 


```
