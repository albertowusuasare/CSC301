
import Implementation.AlbyGraph;
import Implementation.GraphVertex;
import Interfaces.Vertex;
import org.junit.Test;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by albertowusu-asare on 3/6/16.
 */
public class AlbyGraphTest {
    private static final Logger logger = Logger.getLogger(AlbyGraphTest.class.getName());
    static final int NUM_GEN_MAX_VAL = 10;
    //@Test
    public void addVertexTest(){
        AlbyGraph graph = new AlbyGraph();
        int numVertices = generateRandomNum(NUM_GEN_MAX_VAL);
        addVertexesToGraph(graph, numVertices);
        assertTrue("Assert that number of vertices equal expected:",
                graph.numVerticies() == numVertices);
    }

    @Test
    public void testInsertEdgeDirected(){
        boolean isDirected = true;
        int numVertices = generateRandomNum(NUM_GEN_MAX_VAL / 2);
        AlbyGraph graph = insertTest(isDirected, numVertices);
        assertTrue("Assert that number of edges is as expected :",
                graph.numEdges() == numVertices);
    }

    @Test
    public void testInsertEdgeUnDirected(){
        boolean isDirected = false;
        int numVertices = generateRandomNum(NUM_GEN_MAX_VAL / 2);
        AlbyGraph graph = insertTest(isDirected,numVertices);
        assertTrue("Assert that number of edges is as expected :",
                graph.numEdges() == numVertices * 2);
    }
    private AlbyGraph insertTest(boolean isDirected, int numVertices){
        AlbyGraph graph = new AlbyGraph(isDirected);
        List<Vertex> vertexes = vertexGenerator(numVertices * 2 );//even number of vertices
        ListIterator<Vertex> lt = vertexes.listIterator();
        logger.log(Level.INFO,"Directed?:" + isDirected + " Generated Vertices : " + vertexes );
        while(lt.hasNext()){
            Vertex current = lt.next();
            Vertex next = null;
            if(lt.hasNext()) {
                next = lt.next();
            }
            graph.insertEdge(current, next);
        }
        logger.log(Level.INFO, "Directed?:" + isDirected + " numEdgesExpected = " +
                numVertices + " numEdges = " + graph.numEdges());
        logger.log(Level.INFO, "Directed?:" + isDirected + " Graph :" + graph);
        return graph;
    }
    //@Test
    public void testIsDirected(){
        AlbyGraph graph = new AlbyGraph();
        String  direction = "DIRECTED";
        graph.setDirection(direction);
        assertTrue("Assert that the graph is directed: ", graph.isDirected());
        direction = "UNDIRECTED";
        graph.setDirection(direction);
        assertFalse("Assert that the graph is directed: ", graph.isDirected());
    }

    //@Test
    public void testVertexSet(){
        AlbyGraph graph = new AlbyGraph();
        int numVertices = generateRandomNum(NUM_GEN_MAX_VAL);
        List<Vertex> vertices = addVertexesToGraph(graph, numVertices);
        Set<Vertex> vertexSet = graph.vertexSet();
        for(Vertex v : vertices) {
            assertTrue("Assert that the vertexes in the graph are contained in the vertex set",
                    vertexSet.contains(v));
            assertTrue("Total number of vertices == number of vertices generated",
                    vertexSet.size() == vertices.size());
        }
    }

    private List<Vertex> addVertexesToGraph(AlbyGraph graph, int numVertices) {
        List<Vertex> vertices = vertexGenerator(numVertices);
        for(Vertex vertex :vertices)
            graph.addVertex(vertex);
        return vertices;
    }

   // @Test
    public void testNumEdges(){
        AlbyGraph graph = new AlbyGraph();
        int numVertices = generateRandomNum(NUM_GEN_MAX_VAL); //even numbers
        List<Vertex> vertexes = vertexGenerator(numVertices * 2 );
        ListIterator<Vertex> lt = vertexes.listIterator();

        while(lt.hasNext()){
            Vertex current = lt.next();
            Vertex next = null;
            if(lt.hasNext()) {
                 next = lt.next();
            }
            graph.insertEdge(current,next);
        }
        assertTrue("Assert that number of edges is as expected :",
                graph.numEdges() == numVertices);
    }

    /* Helpers */
    private int generateRandomNum(int max) {
        return randInt(0,max);
    }
    private static int randInt(int min, int max) {

        // Usually this can be a field rather than a method variable
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }


    private List<Vertex> vertexGenerator(int numVertices) {
        List<Vertex> vertices = new ArrayList<Vertex>();
        for(int i = 0; i < numVertices;i++){
            GraphVertex<Integer,Integer> graphVertex = new GraphVertex(i);
            vertices.add(graphVertex);
        }
        return vertices;
    }

}
