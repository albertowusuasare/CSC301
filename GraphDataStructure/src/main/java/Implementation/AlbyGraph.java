package Implementation;

import Interfaces.Edge;
import Interfaces.Graph;
import Interfaces.Vertex;

import java.util.*;

/**
 * Created by albertowusu-asare on 3/6/16.
 * This is a graph implementation using adjacency lists
 */
public class AlbyGraph implements Graph {
    Map<Vertex,HashSet<Vertex>> adjacencyList;
    Map<Vertex,Integer> vertexOutDegree;
    List<Edge> edgeList;
    Set<Vertex> vertexSet;
    static final boolean DEFAULT_DIRECTION = false;
    boolean isDirected;

    public AlbyGraph(){
        this(DEFAULT_DIRECTION);
    }
    public AlbyGraph(boolean isDirected){
        this(isDirected, new HashSet<Vertex>(), new ArrayList<Edge>());
    }

    public AlbyGraph(boolean isDirected, Set<Vertex> vertices, List<Edge> edgeList){
        this.isDirected = isDirected;
        this.vertexSet = vertices;
        this.edgeList = edgeList;
        this. adjacencyList = new HashMap<Vertex, HashSet<Vertex>>();
        this.vertexOutDegree = new HashMap<Vertex, Integer>();
    }

    public List<Edge> getEdgeList() {
        return this.edgeList;
    }

    public Set<Vertex> getAdjacentVertices(Vertex v) {
        return this.adjacencyList.get(v);
    }

    public boolean isDirected() {
        return false;
    }

    public void addVertex(Vertex v) {

    }

    public Set<Vertex> vertexSet() {
        return null;
    }

    public Vertex getVertexByEnumeratedVal() {
        return null;
    }

    public int numEdges() {
        return this.edgeList.size();
    }

    public int numVerticies() {
        return 0;
    }

    public void insertEdge(Vertex from, Vertex to) {
       insertEdge(from,to,isDirected);
    }

    private void insertEdge(Vertex from,Vertex to, boolean isDirected){
        HashSet<Vertex> hashSet;
        if((hashSet =this.adjacencyList.get(from)) == null){
            hashSet = new HashSet<Vertex>();
        }
        hashSet.add(to);
        edgeList.add(new GraphEdge(from,to));
        if(!isDirected)
            insertEdge(to,from,!isDirected);
    }

    public void displayGraph() {

    }

    public void printGraph() {
        toString();
    }



    @Override
    public String toString(){
        return edgeList.toString();
    }

    /**
     * This class abstracts the concept of an edge
     * @param <W> the weight type
     */
    public static class GraphEdge<W> implements Edge<W> {
        Vertex from ;
        Vertex to;
        W weight;

        GraphEdge(Vertex from, Vertex to, W weight){
            this.from = from ;
            this.to = to;
            this.weight = weight;
        }

        GraphEdge(Vertex from , Vertex to){
            this(from,to, null);
        }

        public W getWeight() {
          return this.weight;
        }

        @Override
        public int hashCode() {
            return 0;
        }
        @Override
        public String toString(){
            return "(" + from.toString() + "," +  to.toString() + ")";
        }

    }
}
