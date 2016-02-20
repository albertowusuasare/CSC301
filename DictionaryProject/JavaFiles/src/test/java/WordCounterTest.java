/**
 * Created by albertowusu-asare on 2/16/16.
 */
import HashTable.Interface.Map;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static junit.framework.Assert.assertTrue;

public class WordCounterTest {
    final String FILENAME ="/Users/albertowusu-asare/Google Drive/Spring" +
            " 2016/CSC301/github/CSC301/DictionaryProject/JavaFiles/src/test/TextFiles/SimpleText.txt";

    @Test
    public void readLinesFromFileTest() throws Exception {
        String filePath = FILENAME;
        WordCounter wc = new WordCounter(filePath);
        List<String> linesInFile=wc.readLinesInFiles();
        assertTrue("Single line in file", linesInFile.size() == 2);
    }

    @Test
    public void countWordsTest() throws Exception {
        String filePath = FILENAME;
        WordCounter wc = new WordCounter(filePath);
        List<String> linesInFile=wc.readLinesInFiles();
        linesInFile.stream().forEach(s -> System.out.println(s));
        wc.countWords();
        System.out.println(wc);

    }

}
