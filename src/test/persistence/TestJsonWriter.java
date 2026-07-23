package persistence;

import model.FortuneLog;
import model.Fortune;
import persistence.TestJson;
import org.junit.jupiter.api.Test;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@ExcludeFromJacocoGeneratedReport

// Desigend with help fm the JSON Serialization Demon
public class TestJsonWriter {
    
    @Test
    void testWriteToInvalidFile() {
        try {
            JsonWriter writer = new JsonWriter("./data/noExist");
            writer.open();
            fail("IOException expected");
        } catch (IOException e) {

        }
    }

    @Test
    void testWriteToEmptyFL() {
        try {
            JsonWriter myWriter = new JsonWriter("./data/testEmptyFLWriter.json");
            FortuneLog testFortuneLog = new FortuneLog();

            myWriter.open();
            myWriter.write(testFortuneLog);
            myWriter.close();

            JsonReader myReader = new JsonReader("./data/testEmptyFLWriter.json");
            testFortuneLog = myReader.read();

            assertEquals(0, testFortuneLog.getFortuneList().size());
        } catch (IOException e) {
            fail("Error in writing to file");
        }
    }

    @Test
    void testWriteToFortuneList() {
        try {
            JsonWriter myWriter = new JsonWriter("./data/testEmptyFLWriter.json");
            FortuneLog testFortuneLog = new FortuneLog();
            
            Fortune fortune1 = new Fortune("Will he text me back?", "Heads", false);
            Fortune fortune2 = new Fortune("Are Melanie and Sincere still together?", "Tails", true);
            Fortune fortune3 = new Fortune("Am I doing this right?", "Heads", true);
            testFortuneLog.addFortune(fortune1);
            testFortuneLog.addFortune(fortune2);
            testFortuneLog.addFortune(fortune3);

            myWriter.open();
            myWriter.write(testFortuneLog);
            myWriter.close();

            JsonReader myReader = new JsonReader("./data/testEmptyFLWriter.json");
            testFortuneLog = myReader.read();

            assertEquals(3, testFortuneLog.getFortuneList().size());

            assertEquals(fortune1.toString(), testFortuneLog.getFortune(0));
            assertFalse(testFortuneLog.getFortuneList().get(0).getRating());
            assertEquals(fortune2.toString(), testFortuneLog.getFortune(1));
            assertTrue(testFortuneLog.getFortuneList().get(1).getRating());
            assertEquals(fortune3.toString(), testFortuneLog.getFortune(2));
            assertTrue(testFortuneLog.getFortuneList().get(2).getRating());

        } catch (IOException e) {
            fail("Error in writing to file");
        }
    }
}
