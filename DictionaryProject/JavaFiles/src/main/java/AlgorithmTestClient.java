import HashTable.Interface.MapEntry;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by albertowusu-asare on 2/21/16.
 * This class performs basics tests on the speed of dictionary algorithms
 */
public class AlgorithmTestClient {
    private List<String> fileNames;
    private WordCounter wc;
    AlgorithmTestClient(List<String>  fileNames, WordCounter wc) {
        this.fileNames = fileNames;
        this.wc = wc;
    }

    AlgorithmTestClient() throws Exception {
        this(new ArrayList<>(),new WordCounter());
    }

    public static void runTest(String inputFileName,String outputFileName,List<String> functionNames) throws Exception {
        Map<String,MapEntry<String,Long>> resultMap = new HashMap<>();
        for(String functionName : functionNames) {
            String functionArg =null;
            long startTime = System.nanoTime();
            callMethod(functionName,functionArg);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
            Entry<String,Long> entry = new Entry<String,Long>(functionArg,new Long(duration));
            resultMap.put(functionName,entry);
        }
        printResults(inputFileName, outputFileName,resultMap);
    }

    private static void callMethod(String methodName,String methodArg){

    }

    private static  void printResults(String inputFileName, String outputFileName,Map<String,MapEntry<String,Long>> resultMap) throws IOException {
        FileWriter fw = new FileWriter(outputFileName);
        String header = "Displaying the results for " + inputFileName +" ...";
        String title = "Function Call => Time taken for function call";
        MapEntry<String,Long> e = null;
        fw.write(header);
        fw.write(title);
        fw.write("Min                                          =>" + resultMap.get("MIN").getValue());
        fw.write("Max                                          =>" + resultMap.get("MAX").getValue());
        fw.write("GET( "+(e=resultMap.get("GET")).getKey()+" )                             =>" + e.getValue());
        fw.write("INSERT( "+(e=resultMap.get("INSERT")).getKey()+" )                 =>" + e.getValue());
        fw.write("DELETE( "+(e=resultMap.get("DELETE")).getKey()+" )                 =>" + e.getValue());
        fw.close();
    }

    static class Entry<K,V> implements MapEntry<K,V>{
        final K key;
        V value;
        Entry<K,V> next;

        Entry( K key,V value){
            this(key,value,null);
        }
        Entry( K key,V value, Entry<K,V> next){
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

    }
}
