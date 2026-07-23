package test;

import model.FortuneLog;
import persistence.JsonReader;
import model.Fortune;

import org.junit.jupiter.api.Test;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@ExcludeFromJacocoGeneratedReport
public class TestJsonReader extends TestJson {
    
    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/nonExistent.json");
        try {
            FortuneLog fortuneList = reader.read();
            fail("IOException expected");
        } catch(IOException e) {
            // Pass test
        }
    }

    

    @Test
    void testReaderEmptyFortuneLog() {
        JsonReader reader = new JsonReader("./data/testEmptyFLReader.json");
        try {
            FortuneLog fortuneLog = reader.read();
            assertEquals(0, fortuneLog.getFortuneList().size());
        } catch (IOException e) {
            fail("Error in file read");
        }
    }

    @Test
    void testReadFortuneLog() {
        JsonReader reader = new JsonReader("./data/testReadFL.json");
        try {
            FortuneLog fortuneLog = reader.read();
            ArrayList<Fortune> fortunes = fortuneLog.getFortuneList();
            assertEquals(3, fortunes.size());
            checkFortuneCorrectness("Will it rain?", "Heads", false, fortunes.get(0));
            checkFortuneCorrectness("Will it be sunny?", "Tails", true, fortunes.get(1));
            checkFortuneCorrectness("Will I pass?", "Tails", true, fortunes.get(2));
        } catch (IOException e) {
            fail("Error in reading file");
        }
    }

    @Test 
    void testReaderNonExistentCardList() {
        JsonReader jsonReader = new JsonReader("./data/illegal.json");
        try {
            ArrayList<String> cardList = jsonReader.readCards();
            fail("IOException expected");
        } catch (IOException e) {

        }
    }

    @Test
    void testReaderEmptyCardList() {
        JsonReader jsonReader = new JsonReader("./data/testEmptyCardListReader.json");
        try {
            ArrayList<String> cardList = jsonReader.readCards();
            assertEquals(0, cardList.size());
        } catch (IOException e) {
            fail("IOException should not occur");
        }
    }

    @Test
    void testReaderCardList() {
        JsonReader jsonReader = new JsonReader("./data/testEmptyCardListReader.json");
        try {
            ArrayList<String> cardList = jsonReader.readCards();
            assertEquals(2, cardList.size());
            assertEquals("The Fool", cardList.get(0));
            assertEquals("The Magician", cardList.get(1));
        } catch (IOException e) {
            fail("IOException should not occur");
        }
    }
}
