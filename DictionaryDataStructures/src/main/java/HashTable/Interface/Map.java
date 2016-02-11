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
    void insert(K key, V value);

    /**
     * returns a value for the corresponding key
     */
    V get(K key);

    /**
     * returns a set of all the entries in the Map
     */
    Set<Entry<K,V>> entrySet();

    /**
     * removes an entry from the Map according key
     */
    void remove(K key);

    /**
     * Clears the entire map structure
     */
    void clear();

}
