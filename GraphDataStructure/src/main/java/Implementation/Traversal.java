package Implementation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by albertowusu-asare on 4/2/16.
 */
public class Traversal {
    public static <T> List<T> traversePreOrder(Tree<T> tree){
        return traversePreOrder(tree,tree.getRootNode());
    }

    public static <T> List<T> traversePreOrder(Tree<T> tree, Tree.TreeNode root){
        if(root == null)
            return null;
        List<T> traversalList = new ArrayList();
        traversalList.add((T) root.value);
        traversalList.addAll(traversePreOrder(tree,tree.left(root)));
        traversalList.addAll(traversePreOrder(tree,tree.right(root)));
        return traversalList;
    }


}
