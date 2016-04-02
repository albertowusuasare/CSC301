package HashTable.Interface;

/**
 * Created by albertowusu-asare on 2/10/16.
 * Abstracts the functions of an entry. An Entry is defined
 * as any entity that can be used in a Map structure, or any other structure
 * require key value pairs.
 */
public interface MapEntry<K,V> {
    /**
     * @return the key for this entry
     */
    K getKey();

    /**
     * @return returns the value for this entry
     */
    V getValue();
    @Override
    int hashCode();
    @Override
    boolean equals(Object obj);
}
