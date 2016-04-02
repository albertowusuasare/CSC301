package HashTable.Interface;


/**
 * Created by albertowusu-asare on 2/10/16.
 *
 * Contains methods that abstractly define the functionality of any Map
 */
public interface Map<K,V> {
    /**
     * Adds a key value pair to to the Map
     * @param key  the key to insert
     * @param value the value to insert
     */
    V insert(K key, V value);

    /**
     * @param key key to use in retrieving an entry
     * returns a value for the corresponding key
     */
    V get(K key);


    /**
     * @param key to use in removing an entry
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

    MapEntry<K,V> getMax();
    MapEntry<K,V> getMin();
}
