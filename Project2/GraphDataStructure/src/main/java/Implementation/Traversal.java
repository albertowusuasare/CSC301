package Implementation;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains utility methods for traversing a tree.
 * The different traversal modes supported are : depthFirstPreOrder,depthFirstPostOrder,inorder, and breathFirst.
 * @author Albert Owusu-Asare
 * @version 1.1 Sat Apr  2 10:24:46 CDT 2016
 */
public class Traversal {
    /**
     * Traverses the tree in a depth first pre order traversal
     * @param tree the tree to traverse
     * @return a list of the values of the nodes in the tree in depth first pre order
     */
    public static <T> List<T> traverseDepthFirstPreOrder(Tree<T> tree){
        List<T> traversalList = new ArrayList<T>();
        return traverseDepthFirstPreOrder(tree, tree.getRootNode(),traversalList);
    }

    /**
     * Traverses the tree in a depth first post order traversal
     * @param tree the tree to traverse
     * @return a list of the values of the nodes in the tree in depth first post order
     */
    public static <T> List<T> traverseDepthFirstPostOrder(Tree<T> tree){
        List<T> traversalList = new ArrayList<T>();
        return traverseDepthFirstPostOrder(tree, tree.getRootNode(), traversalList);
    }


    /**
     * Traverses the tree in a depth first in order traversal
     * @param tree the tree to traverse
     * @return a list of the values of the nodes in the tree in depth first in order
     */
    public static <T> List<T> traverseDepthFirstInOrder(Tree<T> tree){
        List<T> traversalList = new ArrayList<T>();
        return traverseDepthFirstInOrder(tree, tree.getRootNode(), traversalList);
    }

    /**
     * Traverses the tree in a breadth first traversal
     * @param tree the tree to traverse
     * @return a list of the values of the nodes in the tree in breadth first order
     */
    public static <T> List<T> traverseBreadthFirst(Tree<T> tree){
        List<T> traversalList = new ArrayList<T>();
        Tree.TreeNode [] vertices = tree.getVertices();
        for(Tree.TreeNode node : vertices){
            traversalList.add((T)node.value);
        }
        return traversalList;
    }



    /* Private Helper methods */
    private static <T> List<T> traverseDepthFirstPreOrder(Tree<T> tree, Tree.TreeNode root,List<T> traversalList){
        if(root == null)
            return traversalList;
        traversalList.add((T)root.value);
        traverseDepthFirstPreOrder(tree, tree.left(root),traversalList);
        traverseDepthFirstPreOrder(tree, tree.right(root),traversalList);
        return traversalList;
    }

    private static <T> List<T> traverseDepthFirstPostOrder(Tree<T> tree, Tree.TreeNode rootNode, List<T> traversalList)
    {
        if(rootNode == null){
            return traversalList;
        }
        traverseDepthFirstPostOrder(tree, tree.left(rootNode), traversalList);
        traverseDepthFirstPostOrder(tree, tree.right(rootNode), traversalList);
        traversalList.add((T) rootNode.value);
        return traversalList;
    }

    private static <T> List<T> traverseDepthFirstInOrder(Tree<T> tree, Tree.TreeNode rootNode, List<T> traversalList)
    {
        if(rootNode == null){
            return traversalList;
        }
        traverseDepthFirstInOrder(tree, tree.left(rootNode), traversalList);
        traversalList.add((T) rootNode.value);
        traverseDepthFirstInOrder(tree, tree.right(rootNode), traversalList);
        return traversalList;
    }


}
