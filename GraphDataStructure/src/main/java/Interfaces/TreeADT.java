package Interfaces;

import Implementation.AlbyGraph;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.util.Iterator;
import java.util.Scanner;

/**
 * This describes the core functionality of the tree ADT
 * Created by albertowusu-asare on 3/17/16.
 */
public interface TreeADT<V> {
    void addNode(V value);
    Iterator iterator();
}
