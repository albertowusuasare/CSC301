package HashTable.Implementation;

import HashTable.Interface.Entry;
import HashTable.Interface.Map;

import java.util.Set;

/**
 * Created by albertowusu-asare on 2/10/16.
 *
 * This is a concrete map class that allows the mapping of Key to their
 * respective values using the hash table implementation.
 *
 * This provides constant time for the basic operations.
 */
public class HashMap<K,V> implements Map<K,V> {

    static final int DEFAULT_INITIAL_CAPACITY = 32;
    static final double DEFAULT_LOAD_FACTOR = 0.75;
    transient Entry[] entryTable;
    final double loadFactor;


    public HashMap(int initialCapacity, double loadFactor) throws Exception {
        if(initialCapacity < 0)
            throw new Exception("Table Size cannot be < 0  :" + initialCapacity);
        if(loadFactor <=0 )
            throw new Exception("Load factor value not accepted : " + loadFactor);
        entryTable = new Entry[initialCapacity];
        this.loadFactor = loadFactor;
    }
    public HashMap(int capacity) throws Exception {
       this(capacity,DEFAULT_LOAD_FACTOR);
    }
    public HashMap() throws Exception {
       this(DEFAULT_INITIAL_CAPACITY,DEFAULT_LOAD_FACTOR);
    }

    @Override
    public void insert(Object key, Object value) {

    }

    @Override
    public Object get(Object key) {
        return null;
    }

    @Override
    public Set<Entry<K,V>> entrySet() {
        return null;
    }

    @Override
    public void remove(Object key) {

    }

    @Override
    public void clear() {

    }
}
