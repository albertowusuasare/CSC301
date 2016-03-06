import java.util.List;
import java.util.Map;

/**
 * Created by albertowusu-asare on 3/6/16.
 */
public interface Graph {
    List<Map.Entry<Vertex,Vertex>> getEdgeList();
    List<Vertex> getAdjacentVertices(Vertex v);
    boolean isDirected();
    int numEdges();
    int numVertecies();
    void insertEdge(Vertex from, Vertex to);
}
