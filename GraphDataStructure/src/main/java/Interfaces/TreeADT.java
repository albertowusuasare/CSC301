package Interfaces;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

/**
 * This describes the core functionality of the tree ADT
 * Created by albertowusu-asare on 3/17/16.
 */
public interface TreeADT<K,V> {
    /**
     * Traverses the tree according to some iterator
     * @param nodeIterator the iterator that defines the traversal order
     * @param outputStream the stream to which the tree is printed.
     */
    void traverse(Iterator<Node<K,V>> nodeIterator,OutputStream outputStream);

    /**
     * Creates a new tree by reading the node values from an input strean
     * @param inputStream the stream to read from
     */
    void create(InputStream inputStream);

    /**
     * @return the root of the tree
     */
    Node<K,V> getRoot();
}
