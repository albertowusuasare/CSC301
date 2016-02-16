/**
 * Created by albertowusu-asare on 2/16/16.
 */
import org.junit.Test;

import java.io.File;
import java.util.List;

import static junit.framework.Assert.assertTrue;

public class WordCounterTest {

    @Test
    public void readLinesFromFileTest() throws Exception {
        WordCounter wc = new WordCounter("./TextFiles/SimpleText.txt");
        String expectedLine = "Well,somebody’s doing the raping, Don.I mean somebody’s doing it. Who’s doing the raping? Who’s doing the raping?";
        List<String> linesInFile=wc.readLinesInFiles();
        assertTrue("Single line in file", linesInFile.size() == 1);
        assertTrue(linesInFile.contains(expectedLine));
    }

    @Test
    public void countWordsTest(){

    }
}
