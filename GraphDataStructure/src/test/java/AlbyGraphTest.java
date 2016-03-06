import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by albertowusu-asare on 3/6/16.
 */
public class AlbyGraphTest {
    @Test
    public void addVertexTest(){
        AlbyGraph graph = new AlbyGraph();
        int numVertices = generateRandomNum();
        List<Vertex> vertices = vertexGenerator(numVertices);
        for(Vertex vertex :vertices)
            graph.addVertex(vertex);
        assertTrue("Assert that number of vertices equal expected:",
                graph.numVerticies() == numVertices);
    }

    @Test
    public void testIsDirected(){
        AlbyGraph graph = new AlbyGraph();
        String  direction = "DIRECTED";
        graph.setDirection(direction);
        assertTrue("Assert that the graph is directed: ", graph.isDirected());
        direction = "UNDIRECTED";
        graph.setDirection(direction);
        assertFalse("Assert that the graph is directed: ", graph.isDirected());
    }


    private int generateRandomNum() {
        return 0;
    }

    /* Helpers */
    private List<Vertex> vertexGenerator(int i) {
        return null;
    }

}
