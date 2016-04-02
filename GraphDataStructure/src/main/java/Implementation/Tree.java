package Implementation;

import Interfaces.Node;
import Interfaces.TreeADT;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * This class is an implementation of a Tree data structure using arrays.
 * @author Albert Owusu-Asare
 * @date Sat Apr  2 10:15:50 CDT 2016
 */
public class Tree<V> implements TreeADT<V>{
    private static int MAX_SIZE = 1000;
    private static int DEFAULT_INDEX = -1;
    private static final int ODD_MULTIPLIER = 1;
    private static final int EVEN_MULTIPLIER = 2;
    private TreeNode<V> vertices [];
    private int currentIndex;
    private int vertexSize;

    Tree(){
        this(MAX_SIZE);
    }
    Tree(int size){
        vertices = new TreeNode[size];
        vertexSize = size;
        currentIndex = 0;
    }

    /**
     * Returns the left node of a given node
     * @param node parent node
     */
    public TreeNode left(TreeNode node){
        int leftIndex = (node.index * EVEN_MULTIPLIER) + ODD_MULTIPLIER;
        return (leftIndex < vertexSize) ? vertices[leftIndex] : null;
    }

    /**
     * Returns the right node of a given node
     * @param node the parent node
     */
    public TreeNode right(TreeNode node){
        int rightIndex = (node.index *EVEN_MULTIPLIER) + EVEN_MULTIPLIER;
        return (rightIndex < vertexSize) ? vertices[rightIndex] : null;
    }

    /**
     * Returns the rootNode of the tree
     *
     * <p> If the tree is not initiated yet, null is returned</p>
     * @return
     */
    public TreeNode getRootNode(){
        return (currentIndex > 0) ? this.vertices[0] : null;
    }

    /**
     * Adds a node with value @code{value} to the tree;
     * @param value
     */
    public void addNode(V value) {
        TreeNode node = new TreeNode(currentIndex,value);
        vertices[currentIndex++] = node;
    }

    /**
     * An iterator of the tree. Encapsulate a particular traversal order for the tree;
     * @return
     */
    public Iterator iterator() {
        return null;
    }

    public TreeNode [] getVertices() {
        return vertices;
    }

    @Override
    public String toString(){
        return Arrays.deepToString(vertices);
    }

    /**
     * This class encapsulates the details of a node;
     * @param <V>
     */
    class TreeNode<V> {
        int index;
        V value;
        TreeNode(){
            this(null);
        }

        TreeNode(V val){
            this(DEFAULT_INDEX,val);
        }

        TreeNode(int index, V value){
            this.index = index;
            this.value = value;
        }

        public String toString(){
            return "{" + index +","+ value.toString()+ "}";
        }
    }

    public static void main(String [] args){
        Random random = new Random();
        int treeSize = 7;
        Tree<Integer> testTree = new Tree(treeSize);
        for(int i = 0 ; i < treeSize ; i++){
            testTree.addNode(random.nextInt(10));
        }
        System.out.println("Test tree :"+testTree);
        List<Integer> traversalResults = Traversal.traverseDepthFirstPreOrder(testTree);
        System.out.println("PreOrderDepthFirst :" +traversalResults);
        traversalResults = Traversal.traverseDepthFirstPostOrder(testTree);
        System.out.println("PostOrderDepthFirst :" + traversalResults);
        traversalResults = Traversal.traverseDepthFirstInOrder(testTree);
        System.out.println("InOrderDepthFirst :" + traversalResults);
        traversalResults = Traversal.traverseBreadthFirst(testTree);
        System.out.println("BreathFirst :" + traversalResults);
    }
}
