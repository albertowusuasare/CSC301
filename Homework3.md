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
