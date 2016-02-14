package HashTable.Implementation;


import HashTable.Interface.Map;
import HashTable.Interface.MapEntry;

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
    int tableSize;
    int count;


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
       this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    @Override
    public V insert(K key, V value) {
        if(key == null)
            insertWithNullKey(value);
        int keyHash = key.hashCode();
        int index = getIndex(keyHash,tableSize );
        Entry<K,V> entry = entryTable[index];
        for(;entry !=null; entry= entry.next){
            if(isSameKey(keyHash,key, entry)){
                V oldValue = entry.value;
                entry.value = value;
                return oldValue;
            }
        }
        count++;
        addNewEntryToTable(key, value,index,keyHash);
        return null;
    }

    private boolean isSameKey( int keyHash,K key, Entry entry) {
        Object entryKey = null;
        return entry.hash == keyHash && ((entryKey = entry.key) == key) || key.equals(entryKey);
    }

    private int getIndex(int keyHash, int tableSize) {
        return 0;

    }

    private void addNewEntryToTable(K key, V value, int index,int hash) {
        Entry entry = entryTable[index];
        entryTable[index] = new Entry(hash,key,value,entry);
    }
    private void insertWithNullKey(Object value) {

    }

    @Override
    public Object get(Object key) {
        return null;
    }

    @Override
    public Set<MapEntry<K,V>> entrySet() {
        return null;
    }

    @Override
    public void remove(Object key) {

    }

    @Override
    public void clear() {

    }

    static class Entry<K,V> implements MapEntry<K,V>{
        final K key;
        V value;
        Entry next;
        final int hash;

        Entry(int hash, K key,V value, Entry next){
            this.key = key;
            this.value = value;
            this.next = next;
            this.hash =hash;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }
        public Entry getNextEntry() {
           return this.next;
        }

        public int getHash(){
            return this.hash;
        }
    }
}
