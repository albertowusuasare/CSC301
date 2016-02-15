import HashTable.Implementation.HashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

    WordCounter() throws Exception {
         this(".");
    }
    WordCounter(String fileName) throws Exception {
        if(fileName == null)
            throw new Exception("Filename cannot be null");
        this.fileName = fileName;
        this.counterMap = new HashMap<>();
    }
    public  void readWords() throws IOException {
        List<String> wordsInFile = new ArrayList<String>();
        BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(fileName));
        String s;
        while((s= bufferedReader.readLine()) != null){
            wordsInFile.add(s);
        }
        bufferedReader.close();
        this.linesFromFile = wordsInFile;
    }

    public  void countWords(){
       Stream stream= linesFromFile.stream().map(s -> {
          return s.split("\\s+");
        }).map(arr-> {
            Integer val;
            for(String s : arr){
                if((val = this.counterMap.get(s)) == null){
                    this.counterMap.insert(s,1);
                }
                else {
                  this.counterMap.insert(s,val++);
                }
            }
            return this.counterMap;
        });
    }

    public String toString(){
        return this.counterMap.toString();
    }

}
