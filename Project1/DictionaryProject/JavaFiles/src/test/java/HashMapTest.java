import HashTable.Implementation.HashMap;
import HashTable.Interface.Map;
import junit.framework.TestCase;
import junit.framework.*;
import org.junit.*;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

import java.util.Random;

/**
 * Created by albertowusu-asare on 2/10/16.
 */
public class HashMapTest {
   @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void validInsertTest() throws Exception {
        Map<Integer,Character> integerMap  = new HashMap<Integer, Character>();
        java.util.HashMap<Integer,Character> expectedIntegerMap = new java.util.HashMap<Integer, Character>();
        int upperBound = randInt(97,107);
        for (int i =97; i < upperBound; i++){
            integerMap.insert(i,new Character((char) i));
            expectedIntegerMap.put(i,new Character((char) i));
        }
        assertEquals("Insert Test: ",expectedIntegerMap.toString(),integerMap.toString());
    }

    //@Test
    public void invalidInsertTest() throws Exception {
        int negativeInteger = randInt(0,32767+32768) - 32768;
       thrown.expect(Exception.class);
        Map<Integer,Character> integerMapWithInitialCapacity  = new HashMap<Integer, Character>(negativeInteger);
        Map<Integer,Character> integerMapWithLoadFactor = new HashMap<Integer, Character>(negativeInteger,negativeInteger);
    }

    @Test
    public void getValueByKeyTest() throws Exception {
        Map<Integer,Character> integerMap  = new HashMap<Integer, Character>();
        int upperBound = randInt(97,107);
        generateMap(integerMap, upperBound);
        for (int i =97; i < upperBound; i++){
            assertTrue(integerMap.get(i).equals(new Character((char) i)));
        }
    }

    @Test
    public void removeTest() throws Exception {
        Map<Integer,Character> integerMap  = new HashMap<Integer, Character>();
        int upperBound = randInt(97,107);
        integerMap.insert(97, 'a');
        //generateMap(integerMap, 98);
      //  int randomNumber = randInt(97,upperBound);
        integerMap.remove(97);
       // System.out.println("Integer Map size :" + integerMap.size());
        assertTrue("Remove Test: ", integerMap.size() == 0);
    }

    @Test
    public void clearTest() throws Exception {
        Map<Integer,Character> integerMap  = new HashMap<Integer, Character>();
        java.util.HashMap<Integer,Character> expectedIntegerMap = new java.util.HashMap<Integer, Character>();
        int upperBound = randInt(97,107);
        generateMap(integerMap, upperBound);
       // System.out.println("Before clear : " + integerMap.size());
        integerMap.clear();
        //System.out.println("After clear " +integerMap.size());
        //System.out.println("Entries after clear :");
        assertTrue("clearTest", integerMap.size() == 0);
    }

    private void generateMap(Map<Integer, Character> integerMap, int upperBound) {
        for (int i =97; i < upperBound; i++){
            integerMap.insert(i,new Character((char) i));
        }
    }

    private static int randInt(int min, int max) {
        // Usually this can be a field rather than a method variable
        Random rand = new Random();
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
}
