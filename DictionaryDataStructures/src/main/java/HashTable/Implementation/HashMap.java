package HashTable.Implementation;


import HashTable.Interface.Map;
import HashTable.Interface.MapEntry;

import java.util.HashSet;
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
        tableSize = entryTable.length-1;
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
            return insertWithNullKey(value);
        int keyHash = getHashForKey(key);
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
        addNewEntryToTable(key, value, index, keyHash);
        return null;
    }

    /**
     * Checks if the a given key is the same as the key in an entry.
     * @param keyHash
     * @param key
     * @param entry
     * @return
     */
    private boolean isSameKey( int keyHash,K key, Entry entry) {
        Object entryKey = null;
        return entry.hash == keyHash && ((entryKey = entry.key) == key) || key.equals(entryKey);
    }

    private int getIndex(int keyHash, int tableSize) {
        return keyHash % (tableSize-1);

    }

    private void addNewEntryToTable(K key, V value, int index,int hash) {
        Entry entry = entryTable[index];
        entryTable[index] = new Entry(hash,key,value,entry);
    }
    private V insertWithNullKey(V value) {
        for(Entry<K,V> e = entryTable[0];e != null; e=e.next){
            if(e.key == null){
                V oldValue = e.value;
                e.value = value;
                count ++;
                return oldValue;
            }
        }
        addNewEntryToTable(null,value,0,0);
        return null;
    }

    @Override
    public V get(K key) {
        if(key == null)
           return getNullKey();
        int keyHash = getHashForKey(key);
        int index = getIndex(keyHash,tableSize);
        Entry<K,V> entry = entryTable[index];
        for(;entry !=null; entry = entry.next){
            K entryKey;
            if(isSameKey(keyHash,key,entry)){
                return entry.value;
            }
        }
        return null;
    }

    private V getNullKey() {
        Entry<K,V> entry = entryTable[0];
        for(;entry != null;entry = entry.next){
            if(entry.key == null){
                return entry.value;
            }
        }
        return null;
    }


    @Override
    public V remove(K key) {
        int keyHash = getHashForKey(key);
        int index = getIndex(keyHash, tableSize);
        Entry<K,V> currentEntry = entryTable[index];
        Entry<K,V> previousEntry;
        while(currentEntry != null){
            if(isSameKey(keyHash,key,currentEntry)){
                previousEntry = currentEntry;
                previousEntry = currentEntry.next;
                return currentEntry.value;
            }
            currentEntry = currentEntry.next;
        }
        return null;
    }

    private int getHashForKey(K key) {
        return key.hashCode();
    }

    @Override
    public void clear() {
        for(int i = 0; i< entryTable.length;i++){
            entryTable[i]=null;
        }
        tableSize = 0;
    }

    @Override
    public int size() {
        return this.tableSize;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        for(int i = 0; i < tableSize ; i++){
            Entry<K,V> entry = entryTable[i];
            while(entry != null){
                if(sb.length() >1){
                    sb.append(", ");}
                sb.append(entry.key);
                sb.append("=");
                sb.append(entry.value);
                entry = entry.next;
            }
        }
        sb.append('}');
        return sb.toString();
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
