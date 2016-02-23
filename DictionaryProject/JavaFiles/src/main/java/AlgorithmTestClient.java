import HashTable.Interface.MapEntry;

import java.io.*;
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
        Map<String,MapEntry<String,Double>> resultMap = new HashMap<>();
        WordCounter wc = new WordCounter(inputFileName);
        wc.readLinesInFiles();
        wc.countWords();
        for(Entry<String,String> e : functionList) {
            double duration =callMethod(e.key,e.value,wc.getMap());
            Entry<String,Double> entry = new Entry<>(e.value,new Double(duration));
            resultMap.put(e.key,entry);
        }
        printResults(inputFileName, outputFileName,resultMap);
    }

    private static double callMethod(String methodName,String methodArg, HashTable.Interface.Map<String,Integer> counterMap){
        long startTime =0 , endTime =0,duration;
        if(methodName.equals("MIN")){
             startTime = System.nanoTime();
             counterMap.getMin();
             endTime = System.nanoTime();
        } else if (methodName.equals("MAX")){
            startTime = System.nanoTime();
            counterMap.getMax();
            endTime = System.nanoTime();
        } else if (methodName.equals("GET")){
            startTime = System.nanoTime();
            counterMap.get(methodArg);
            endTime = System.nanoTime();
        }else if (methodName.equals("INSERT")){
            startTime = System.nanoTime();
            counterMap.insert(methodArg,1);
            endTime = System.nanoTime();
        } else if(methodName.equals("DELETE")) {
            startTime = System.nanoTime();
            counterMap.remove(methodArg);
            endTime = System.nanoTime();
        }

         duration = (endTime - startTime);
        return (double) duration /1000000.0 ;

    }

    private static  void printResults(String inputFileName, String outputFileName,Map<String,MapEntry<String,Double>> resultMap) throws IOException {

        FileWriter fw = new FileWriter(outputFileName);
        BufferedWriter bw = new BufferedWriter(fw);
        String header = "Displaying the results for " + inputFileName +" ...";
        String title = "Function Call => Time taken for function call";
        MapEntry<String,Double> e = null;
        bw.write(header);
        bw.newLine();
        bw.write(title);
        bw.newLine();
        bw.write("MIN                                          =>" + resultMap.get("MIN").getValue());
        bw.newLine();
        bw.write("MAX                                          =>" + resultMap.get("MAX").getValue());
        bw.newLine();
        bw.write("GET( " + (e = resultMap.get("GET")).getKey() + " )                             =>" + e.getValue());
        bw.newLine();
        bw.write("INSERT( " + (e = resultMap.get("INSERT")).getKey() + " )                 =>" + e.getValue());
        bw.newLine();
        bw.write("DELETE( " + (e = resultMap.get("DELETE")).getKey() + " )                 =>" + e.getValue());
        bw.newLine();
        bw.close();
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
    public static void main(String []args) throws Exception {
        final String root ="/Users/albertowusu-asare/Google Drive/Spring" +
                " 2016/CSC301/github/CSC301/DictionaryProject/JavaFiles/src/test/TextFiles/";
        String [] argsHolmes = {"Holmes","wumpus","king"};
        String [] argsOxford = {"Anteater","aardvark","the"};
        String [] argsWords2 = {"likely","hyphenation","brisk"};
        List<Entry<String,String>> holmesFunctionList = initialize(argsHolmes);
        List<Entry<String,String>> oxfordFunctionList = initialize(argsOxford);
        List<Entry<String,String>> words2FunctionList = initialize(argsWords2);

        List<Entry<String,List<Entry<String,String>>>> testRuns = new ArrayList<>();
        testRuns.add( new Entry<>("Holmes.txt", holmesFunctionList));
        testRuns.add(new Entry<>("OxfordMedical.txt", oxfordFunctionList));
        testRuns.add(new Entry<>("words2.txt", words2FunctionList));

        for(Entry<String,List<Entry<String,String>>> e : testRuns){
            String outputFileName =  root+"out"+e.getKey();
            runTests(root+e.getKey(),outputFileName,e.getValue());
        }
    }
}
