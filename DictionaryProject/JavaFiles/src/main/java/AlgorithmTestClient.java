import HashTable.Interface.MapEntry;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

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
        this(new ArrayList<>(), new WordCounter());
    }

    public static void runTests(String inputFileName,String outputFileName,List<Entry<String,String>> functionList)
            throws Exception {
        Map<String,MapEntry<String,Long>> resultMap = new HashMap<>();
        WordCounter wc = new WordCounter(inputFileName);
        wc.readLinesInFiles();
        wc.countWords();
        for(Entry<String,String> e : functionList) {
            long duration =callMethod(e.key,e.value,wc.getMap());
            Entry<String,Long> entry = new Entry<>(e.value,new Long(duration));
            resultMap.put(e.key,entry);
        }
        printResults(inputFileName, outputFileName,resultMap);
    }

    private static long callMethod(String methodName,String methodArg, HashTable.Interface.Map<String,Integer> counterMap){
        long startTime , endTime;
        if(methodName.equals("MIN")){
             startTime = System.nanoTime();
             counterMap.getMin();
             endTime = System.nanoTime();
            long duration = (endTime - startTime);
            return duration;
        }

        return -1;
    }

    private static  void printResults(String inputFileName, String outputFileName,Map<String,MapEntry<String,Long>> resultMap) throws IOException {
        FileWriter fw = new FileWriter(outputFileName);
        String header = "Displaying the results for " + inputFileName +" ...";
        String title = "Function Call => Time taken for function call";
        MapEntry<String,Long> e = null;
        fw.write(header);
        fw.write(title);
        fw.write("MIN                                          =>" + resultMap.get("MIN").getValue());
        fw.write("MAX                                          =>" + resultMap.get("MAX").getValue());
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

    private static <K,V extends String> List<Entry<K,V>> initialize(String [] args){
        List<Entry<K,V>> functionEntries  = new ArrayList<>();
        functionEntries.add(new Entry("MAX",null));
        functionEntries.add(new Entry("MIN",null));
        functionEntries.add(new Entry("GET",args[0]));
        functionEntries.add(new Entry("INSERT",args[1]));
        functionEntries.add(new Entry("DELETE",args[2]));
        return functionEntries;
    }
    public static void main(String args) throws Exception {
        String [] argsHolmes = {"Holmes","wumpus","klay"};
        String [] argsOxford = {"Anteater","aardvark","the"};
        List<Entry<String,String>> holmesFunctionList = initialize(argsHolmes);
        List<Entry<String,String>> oxfordFunctionList = initialize(argsOxford);

        List<Entry<String,List<Entry<String,String>>>> testRuns = new ArrayList<>();
        testRuns.add( new Entry<>("Holmes.txt", holmesFunctionList));
        testRuns.add(new Entry<>("OxfordMedical.text", oxfordFunctionList));


        for(Entry<String,List<Entry<String,String>>> e : testRuns){
            String outputFileName = "out" + e.getKey();
            runTests(e.getKey(),outputFileName,e.getValue());
        }
    }
}
