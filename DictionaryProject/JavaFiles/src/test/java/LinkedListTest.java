import org.junit.Test;

import java.util.Random;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by albertowusu-asare on 2/11/16.
 */
public class LinkedListTest {
    @Test
    public void insertSizeTest (){
        LinkedList<Integer> integerLinkedList = new LinkedList<Integer>();
        int bound = randInt(0,10);
        for (int i =0 ; i< bound; i++){
            integerLinkedList.insert(i);
        }
        assertTrue("Assert Size of list: ", integerLinkedList.size() == bound);
    }

    @Test
    public void toStringTest(){
        LinkedList<Character> alphabet = new LinkedList<Character>();
        for(int  i = 97 ; i<100;i++){
            char val = (char) i;
            alphabet.insert(new Character(val));
        }
        String predictedResult = "[[ c ],[ b ],[ a ],]";
        assertEquals(predictedResult, alphabet.toString());
    }

    @Test
    public void reverseTest(){
        LinkedList<Character> alphabet = new LinkedList<Character>();
        for(int  i = 97 ; i<100;i++){
            char val = (char) i;
            alphabet.insert(new Character(val));
        }
        String beforeReverse = alphabet.toString();
        LinkedList.Node reversedRoot= alphabet.reverse();
        String afterReverse = alphabet.toString();
        assertEquals("Reverse equality test :", beforeReverse,afterReverse);

    }
    public static int randInt(int min, int max) {

        // Usually this can be a field rather than a method variable
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
}
