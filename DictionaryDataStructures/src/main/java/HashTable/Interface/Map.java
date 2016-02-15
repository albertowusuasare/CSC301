package HashTable.Interface;

import java.util.Set;

/**
 * Created by albertowusu-asare on 2/10/16.
 *
 * Contains methods that abstractly define the functionality of any Map
 */
public interface Map<K,V> {
    /**
     * Adds a key value pair to to the Map
     */
    V insert(K key, V value);

    /**
     * returns a value for the corresponding key
     */
    V get(K key);


    /**
     * removes an entry from the Map according key
     */
    V remove(K key);

    /**
     * Clears the entire map structure
     */
    void clear();

    /**
     *  Returns the size of the map currently
     */
    int size();
}
