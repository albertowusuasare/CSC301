/**
 * Created by albertowusu-asare on 2/11/16.
 */
public class LinkedList<T> {
    class Node<T>{
        T val;
        Node next;
        Node(T val){
            this.val = val;
            this.next = null;
        }
    }//Node

   private Node first;
    private int size =0;
   public void insert(T val){
       Node temp = new Node(val);
       insert(temp);
       size ++;
   }

    private void insert(Node node){
        if (isEmpty() ){
           this. first = node;
        } else {
            node.next = first;
            first = node;
        }
    }

    public boolean isEmpty(){
        return this.first == null;
    }

    public int size(){
        return this.size;
    }

    @Override
    public String toString(){
        return "[" + toString(first)+"]";
    }

    private String toString(Node root){
        if(root == null)
            return "";
        else
            return "[ " + root.val.toString() + " ],"  + toString(root.next);
    }

    public Node reverse(){

       Node current, next, previous;
        previous = null;
        current = this.first;

        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }


}
