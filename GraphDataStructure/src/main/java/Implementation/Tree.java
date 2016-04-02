package Implementation;

import Interfaces.Node;
import Interfaces.TreeADT;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * This class is an implementation of a tree data structure using arrays.
 * @author Albert Owusu-Asare
 */
public class Tree<V> implements TreeADT<V>{
    private static int MAX_SIZE = 1000;
    private static int DEFAULT_INDEX = -1;
    private static final int ODD_MULTIPLIER = 1;
    private static final int EVEN_MULTIPLIER = 2;
    TreeNode<V> vertices [];
    TreeNode rootNode;
    int currentIndex;

    Tree(){
        this(MAX_SIZE);
    }
    Tree(int size){
        vertices = new TreeNode[size];
        currentIndex = 0;
        this.rootNode = vertices[0];
    }
    public TreeNode left(TreeNode node){
        int leftIndex = (node.index * EVEN_MULTIPLIER) + ODD_MULTIPLIER;
        return vertices[leftIndex];
    }

    public TreeNode right(TreeNode node){
        int rightIndex = (node.index *EVEN_MULTIPLIER) + EVEN_MULTIPLIER;
        return vertices[rightIndex];
    }

    public TreeNode getNodeAtIndex(int index){
        if (index > vertices.length -1 )
            throw new IllegalArgumentException("Index out of bounds");
        return vertices[index];
    }

    public TreeNode getRootNode(){
        return this.rootNode;
    }

    public void addItem(V value) {
        TreeNode node = new TreeNode(currentIndex,value);
        vertices[currentIndex++] = node;
    }

    public Iterator iterator() {
        return null;
    }

    public String toString(){
        return Arrays.deepToString(vertices);
    }

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
        int treeSize = 10;
        Tree<Integer> testTree = new Tree(treeSize);
        for(int i = 0 ; i < treeSize ; i++){
            testTree.addItem(random.nextInt(10));
        }

        System.out.println(testTree);

        List<Integer> traversalResults = Traversal.traversePreOrder(testTree);
        System.out.println(traversalResults.toString());
    }
}
