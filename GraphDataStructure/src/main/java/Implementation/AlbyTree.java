package Implementation;

import Interfaces.Node;
import Interfaces.TreeADT;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Scanner;

/**
 *  * An implementation of the tree abstract data structure
 * Created by albertowusu-asare on 3/17/16
 */
public class AlbyTree implements TreeADT{
    private AlbyNode rootNode;

    AlbyTree(){
        this.rootNode = null;
    }

    public void traverse(Iterator iterator, OutputStream outputStream) {

    }

    public void create(Scanner sc) {
        while (sc.hasNext()) {
            String next = sc.next();
            System.out.println(next);
            AlbyNode newNode = new AlbyNode(next,next);
            this.rootNode = insert(this.rootNode,newNode);
        }
        sc.close();
    }

    public AlbyNode insert(AlbyNode root, AlbyNode newNode){
        if(root == null)
           return newNode;
        else if(root.right == null)
            return insert(root.right,newNode);

        return insert(root.left,newNode);
    }

    public Node getRoot() {
        return this.rootNode;
    }

    private class AlbyNode implements Node< String, String>{
        String key;
        String value;
        AlbyNode left;
        AlbyNode right;
        AlbyNode(){
            this(null,null);
        }
        AlbyNode(String key, String value){
            this(key,value,null,null);
        }
        AlbyNode(String key, String value, AlbyNode left, AlbyNode right){
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
        public String getKey() {
            return this.key;
        }


        public String getValue() {
            return this.value;
        }

        public AlbyNode getRight(){
            return this.right;
        }
        public AlbyNode getLeft(){
            return this.left;
        }

        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            sb.append(key.toString());
            sb.append(",");
            sb.append(value.toString());
            sb.append("}");
            return sb.toString();
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(this.rootNode.toString());
        sb.append(this.rootNode.left.toString());
        sb.append(this.rootNode.right.toString());
        sb.append("}");
        return sb.toString();
    }

    public static void main (String [] args){
        AlbyTree albyTree = new AlbyTree();
        Scanner sc = new Scanner("/Users/albertowusu-asare/Google Drive/Spring 2016/CSC301/github/CSC301/" +
                "GraphDataStructure/src/main/java/Implementation/CreateTestFile");
        sc.useDelimiter(",");
        albyTree.create(sc);
        System.out.println(albyTree);
    }
}
