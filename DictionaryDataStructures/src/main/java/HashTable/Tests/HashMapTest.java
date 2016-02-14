package HashTable.Tests;

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
 * TODO : refactor tests. DRY out functions
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

    @Test
    public void invalidInsertTest() throws Exception {
        int negativeInteger = randInt(0,32767+32768) - 32768;
        thrown.expect(Exception.class);
        Map<Integer,Character> integerMapWithInitialCapacity  = new HashMap<Integer, Character>(negativeInteger);
        Map<Integer,Character> integerMapWithLoadFactor = new HashMap<Integer, Character>(negativeInteger,negativeInteger);
    }

    @Test
    public void getValueByKeyTest() throws Exception {
        Map<Integer,Character> integerMap  = new HashMap<Integer, Character>();
        java.util.HashMap<Integer,Character> expectedIntegerMap = new java.util.HashMap<Integer, Character>();
        int upperBound = randInt(97,107);
        for (int i =97; i < upperBound; i++){
            integerMap.insert(i,new Character((char) i));
        }
        for (int i =97; i < upperBound; i++){
            assertTrue(integerMap.get(i)== new Character((char) i));
        }
    }

    @Test
    public void entrySetTest() throws Exception{
        Map<Integer,Character> integerMap  = new HashMap<Integer, Character>();
        java.util.HashMap<Integer,Character> expectedIntegerMap = new java.util.HashMap<Integer, Character>();
        int upperBound = randInt(97,107);
        for (int i =97; i < upperBound; i++){
            integerMap.insert(i,new Character((char) i));
            expectedIntegerMap.put(i, new Character((char) i));
        }
        assertEquals("EntrySet Test: ",expectedIntegerMap.entrySet(),integerMap.entrySet());
    }

    @Test
    public void removeTest() throws Exception {
        Map<Integer,Character> integerMap  = new HashMap<Integer, Character>();
        int upperBound = randInt(97,107);
        for (int i =97; i < upperBound; i++){
            integerMap.insert(i, new Character((char) i));
        }

        int randomNumber = randInt(97,upperBound);
        integerMap.remove(randomNumber);
        assertFalse("Remove function: ", integerMap.get(randomNumber) == new Character((char) randomNumber));
    }

    @Test
    public void clearTest() throws Exception {
        Map<Integer,Character> integerMap  = new HashMap<Integer, Character>();
        java.util.HashMap<Integer,Character> expectedIntegerMap = new java.util.HashMap<Integer, Character>();
        int upperBound = randInt(97,107);
        for (int i =97; i < upperBound; i++){
            integerMap.insert(i,new Character((char) i));
        }
        integerMap.clear();
        assertTrue("Clear function test: ", integerMap.entrySet().isEmpty());
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
