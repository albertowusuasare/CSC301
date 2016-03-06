import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by albertowusu-asare on 3/6/16.
 */
public interface Graph {
    List<Map.Entry<Vertex,Vertex>> getEdgeList();
    List<Vertex> getAdjacentVertices(Vertex v);
    boolean isDirected();
    void addVertex(Vertex v);
    Set<Vertex> vertexSet();
    Vertex getVertexByEnumeratedVal();
    int numEdges();
    int numVerticies();
    void insertEdge(Vertex from, Vertex to);
    void displayGraph();
    void printGraph();

    void setDirection(String direction);
}
