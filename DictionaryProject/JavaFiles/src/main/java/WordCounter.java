import HashTable.Implementation.HashMap;
import HashTable.Interface.Map;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Created by albertowusu-asare on 2/14/16.
 * This is a simple file reader that reads text from a text file and provides functionality
 * for processing the read in file.
 */
public class WordCounter{

    private String fileName;
    private List<String> linesFromFile;
    private HashMap<String,Integer> counterMap;
    private java.util.HashMap<String,Integer> counterMap2;
    private String splitCriteria = "\\s+";
    private final boolean CASE_SENSITIVE = true;

    WordCounter() throws Exception {
         this(".");
    }
    WordCounter(String fileName) throws Exception {
        if(fileName == null)
            throw new Exception("Filename cannot be null");
        this.fileName = fileName;
        this.counterMap = new HashMap<>();
        this.counterMap2 = new java.util.HashMap<>();
    }
    public List<String> readLinesInFiles() throws IOException {
        return readLinesInFiles(this.fileName);
    }
    public List<String> readLinesInFiles(String fileName) throws IOException {
       List<String> wordsInFile = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(fileName));
        String s;
        while((s= bufferedReader.readLine()) != null){
            wordsInFile.add(s);
        }
        bufferedReader.close();
        this.linesFromFile = wordsInFile;

        return this.linesFromFile;
    }

    public List<String> getLinesFromFiles(){
        return this.linesFromFile;
    }

    public void countWords(){
      linesFromFile.stream().map(s -> s.split(splitCriteria)).forEach(arr -> populateMap(arr));
    }

    public void populateMap(String [] arr){
        Integer val;
        for(String s:arr){
            if(CASE_SENSITIVE)
                s= s.toLowerCase();

            if((val = this.counterMap.get(s)) == null){
                this.counterMap.insert(s, 1);
               // this.counterMap2.put(s, 1);
            }
            else {
                this.counterMap.insert(s,++val);
               // this.counterMap2.put(s,++val);
            }
        }
    }

    public String toString(){
        //return this.counterMap2.toString();
       return this.counterMap.get("the").toString();
    }

    public Map<String,Integer> getMap(){
        return this.counterMap;
    }

}
