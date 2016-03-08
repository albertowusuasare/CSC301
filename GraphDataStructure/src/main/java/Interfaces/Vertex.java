package Interfaces;

/**
 * Created by albertowusu-asare on 3/6/16.
 */
public interface Vertex{
    void getWeight();
    void getNumInDegree();
    void getNumOutDegree();
    void getVertexVal();
    void getEnumeratedValue();
    @Override
    int hashCode();
    @Override
    boolean equals(Object o);
}
