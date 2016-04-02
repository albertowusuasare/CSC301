package Implementation;

import Interfaces.Graph;
import Interfaces.Vertex;

/**
 * Created by albertowusu-asare on 3/7/16.
 */
public class GraphVertex<W,V> implements Vertex {
    static final int DEFAULT_HASH = Integer.MAX_VALUE;
    int hash;
    W weight;
    V value;
    GraphVertex<W,V> next;
    public GraphVertex(){
        this(null);
    }
    public GraphVertex(V value){
        this(value,null);
    }
    public GraphVertex(V value,GraphVertex<W,V> next){
        this(DEFAULT_HASH,value,next);
    }
    public GraphVertex(int hash, V value, GraphVertex<W,V> next){
        this.hash = hash;
        this.value = value;
        this.next = next;
    }

    public void getWeight() {

    }

    public void getNumInDegree() {

    }

    public void getNumOutDegree() {

    }

    public void getVertexVal() {

    }

    public void getEnumeratedValue() {

    }

    @Override
    public int hashCode(){
        return 31 * 17 + this.value.hashCode();
    }

    @Override
    public boolean equals(Object o){
        if(o == this)
            return true;
        if (!( o instanceof GraphVertex))
            return false;
        GraphVertex<W,V> obj = (GraphVertex<W,V>) o;
        return (this.value == obj.value || (this.value != null && this.value.equals(obj.value)));
    }

    @Override
    public String toString(){
        return "{ " + this.value.toString() +" }";
    }

}
