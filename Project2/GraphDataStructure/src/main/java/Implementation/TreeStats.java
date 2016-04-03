package Implementation;

import java.io.*;
import java.util.*;

/**
 * This class provides functionality for testing the efficiency of our Tree implementations
 * @author  Albert Owusu-Asare
 *
 */
public class TreeStats {
    public static Map<String,Integer> methodMap = new HashMap<String, Integer>();
    static {
        methodMap.put("DEPTH_FIRST_PRE_ORDER",1);
        methodMap.put("DEPTH_FIRST_POST_ORDER",2);
        methodMap.put("DEPTH_FIRST_IN_ORDER",3);
        methodMap.put("BREADTH_FIRST",4);
    }

    public static final int DEFAULT_NUM_VERTICES = 1000;


    public static Tree<String> readTreeFromFile(String fileName, int numValues) throws FileNotFoundException {
        File file  = new File(fileName);
        Tree<String> tree = new Tree(numValues);
        Scanner scanner = new Scanner(file);
        scanner.useDelimiter("\\p{javaWhitespace}+");
        while(scanner.hasNext()){
            String nextValue = scanner.next();
            tree.addNode(nextValue);
        }
        return tree;
    }

    public  static void reportStatistics(String [] fileNames) throws IOException {
        for(String fileName : fileNames){
            double initialize;
            long initializeStart = System.nanoTime();
            Tree tree = readTreeFromFile(fileName, DEFAULT_NUM_VERTICES);
            long initializeEnd = System.nanoTime();
            initialize = (double) initializeEnd- initializeStart;
            double depthFirstPreOrder = getTimeTaken(methodMap.get("DEPTH_FIRST_PRE_ORDER"),tree);
            double depthFirstPostOrder = getTimeTaken(methodMap.get("DEPTH_FIRST_POST_ORDER"),tree);
            double depthFirstInOrder = getTimeTaken(methodMap.get("DEPTH_FIRST_IN_ORDER"),tree);
            double breadthFirst = getTimeTaken(methodMap.get("BREADTH_FIRST"),tree);
            Stats stats = new
                    Stats(fileName,initialize,depthFirstPreOrder,depthFirstPostOrder,depthFirstInOrder,breadthFirst);
            stats.toMilliSec();
            writeToOutputFile(stats);
        }
    }

    private static void writeToOutputFile(Stats stats) throws IOException {
        FileWriter fw = new FileWriter(stats.fileName+"Out");
        BufferedWriter bw = new BufferedWriter(fw);
        String header = "Displaying the results for " + stats.fileName +" ...";
        String title = "Function Call => Time taken for function call";
        bw.write(header);
        bw.newLine();
        bw.write(title);
        bw.newLine();
        bw.write("DEPTH_FIRST_PRE_ORDER                                          =>" + stats.depthFirstPreOrder);
        bw.newLine();
        bw.write("DEPTH_FIRST_POST_ORDER                                         =>" + stats.depthFirstPostOrder);
        bw.newLine();
        bw.write("DEPTH_FIRST_IN_ORDER                                           =>" + stats.depthFirstInOrder);
        bw.newLine();
        bw.write("BREADTH_FIRST                                                  =>" + stats.breadthFirst);
        bw.newLine();
        bw.write("INITIALIZE_TREE                                                =>" + stats.initialize);
        bw.newLine();
        bw.close();
    }


    private static double getTimeTaken(int traversalMode,Tree tree) {
        long startTime, endTime, duration;


        switch (traversalMode) {
            case 1: {
                startTime = System.nanoTime();
                Traversal.traverseDepthFirstPreOrder(tree);
                endTime = System.nanoTime();
            }
            break;
            case 2: {
                startTime = System.nanoTime();
                Traversal.traverseDepthFirstPostOrder(tree);
                endTime = System.nanoTime();
            }
            break;
            case 3: {
                startTime = System.nanoTime();
                Traversal.traverseDepthFirstInOrder(tree);
                endTime = System.nanoTime();
            }
            break;
            case 4: {
                startTime = System.nanoTime();
                Traversal.traverseBreadthFirst(tree);
                endTime = System.nanoTime();
            }
            break;
            default: {
                startTime = 0;
                endTime = 0;
            }
            break;
        }
       duration = (endTime - startTime);
        return (double) duration;
    }

    static class Stats {
        String fileName;
        double initialize;
        double depthFirstPreOrder;
        double depthFirstPostOrder;
        double depthFirstInOrder;
        double breadthFirst;

        Stats(String fileName){
            this(fileName,0,0,0,0,0);
        }
        Stats(String fileName,double initialize, double depthFirstPreOrder,double depthFirstPostOrder,
              double depthFirstInOrder, double breadthFirst){
            this.fileName = fileName;
            this.initialize = initialize;
            this.depthFirstPreOrder = depthFirstPreOrder;
            this.depthFirstPostOrder = depthFirstPostOrder;
            this.depthFirstInOrder = depthFirstInOrder;
            this.breadthFirst = breadthFirst;
        }

        void toMilliSec(){
            this.initialize = this.initialize / 1000000;
            this.depthFirstPreOrder = this.depthFirstPreOrder /1000000;
            this.depthFirstPostOrder = this.depthFirstPostOrder /1000000;
            this.depthFirstInOrder = this.depthFirstInOrder /1000000;
            this.breadthFirst = this.breadthFirst /1000000;
        }

    }

    public static void main(String ... args) throws IOException {
        String IN_ORDER_REVERSE = "src/main/java/Implementation/in-order-reverse.txt";
        String IN_ORDER = "src/main/java/Implementation/in-order.txt";
        String RANDOM ="src/main/java/Implementation/random.txt";
        String [] fileNames = new String [] {IN_ORDER,IN_ORDER_REVERSE,RANDOM};
        reportStatistics(fileNames);

    }
}
