package Interfaces;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by albertowusu-asare on 3/6/16.
 */
public interface Graph<V> {
    List<Map.Entry<Vertex, Vertex>> getEdgeList();
    List<Vertex> getAdjacentVertices(Vertex v);
    boolean isDirected();
    void addVertex(Vertex v);
    Set<Vertex> vertexSet();
    Vertex getVertexByEnumeratedVal();
    int numEdges();
    int numVerticies();

    /**
     * Inserts an Interfaces.Edge to the graph. Implementation is dependent on whether or
     * not the graph is directed
     * @param from originator of the edge
     * @param to destinator of the edge;
     */
    void insertEdge(Vertex from, Vertex to);
    void displayGraph();
    void printGraph();

    void setDirection(String direction);
}
