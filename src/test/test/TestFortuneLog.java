package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;
import model.Fortune;
import model.FortuneLog;

@ExcludeFromJacocoGeneratedReport
public class TestFortuneLog {
    private FortuneLog testFortuneLog;
    private Fortune testFortune1;
    private Fortune testFortune2;
    private Fortune testFortune3;
    private Fortune testFortune4;

    @BeforeEach
    void runBefore() {
        testFortuneLog = new FortuneLog();

        testFortune1 = new Fortune("Will it be sunny?");
        testFortune2 = new Fortune("Will it be rainy?");
        testFortune3 = new Fortune("Will it be cloudy?");
        testFortune4 = new Fortune("Will it be windy?");

        testFortune1.setRating(false);
        testFortune2.setRating(true);
        testFortune3.setRating(false);
        testFortune4.setRating(true);

        testFortune1.setResult("Heads");
        testFortune2.setResult("Tails");
    }

    @Test
    public void testConstructor() {
        assertEquals(testFortuneLog.getFortuneList().size(), 0);
    }

    @Test
    public void testAddFortune() {
        testFortuneLog.addFortune(testFortune1);
        assertTrue(testFortuneLog.getFortuneList().contains(testFortune1));
    }

    @Test
    public void testAddFortuneMultiples() {
        testFortuneLog.addFortune(testFortune1);
        assertTrue(testFortuneLog.getFortuneList().contains(testFortune1));

        testFortuneLog.addFortune(testFortune2);
        assertTrue(testFortuneLog.getFortuneList().contains(testFortune2));
    }

    @Test
    public void testRemoveFortune() {
        testFortuneLog.addFortune(testFortune1);
        assertTrue(testFortuneLog.getFortuneList().contains(testFortune1));

        testFortuneLog.removeFortune(0);
        assertFalse(testFortuneLog.getFortuneList().contains(testFortune1));
    }

    @Test
    public void testRemoveFortuneMultiples() {
        testFortuneLog.addFortune(testFortune1);
        assertTrue(testFortuneLog.getFortuneList().contains(testFortune1));

        testFortuneLog.addFortune(testFortune2);
        assertTrue(testFortuneLog.getFortuneList().contains(testFortune2));

        testFortuneLog.removeFortune(1);
        assertFalse(testFortuneLog.getFortuneList().contains(testFortune2));

        testFortuneLog.removeFortune(0);
        assertFalse(testFortuneLog.getFortuneList().contains(testFortune1));
    }

    @Test
    public void getFortuneTopic() {
        testFortuneLog.addFortune(testFortune1);
        assertEquals(testFortuneLog.getFortune(0), "Topic: [Will it be sunny?] Result: [Heads]");
    }

    @Test
    public void getFortuneTopicMultiple() {
        testFortuneLog.addFortune(testFortune1);
        assertEquals(testFortuneLog.getFortune(0), "Topic: [Will it be sunny?] Result: [Heads]");

        testFortuneLog.addFortune(testFortune2);
        assertEquals(testFortuneLog.getFortune(1), "Topic: [Will it be rainy?] Result: [Tails]");

    }

    @Test
    public void testGetGoodFortunes() {
        testFortuneLog.addFortune(testFortune1);
        testFortuneLog.addFortune(testFortune2);

        assertTrue(testFortuneLog.getGoodFortunes().contains(testFortune2));
        assertFalse(testFortuneLog.getGoodFortunes().contains(testFortune1));
    }

    @Test
    public void testGetGoodFortunesMultiples() {
        testFortuneLog.addFortune(testFortune1);
        testFortuneLog.addFortune(testFortune2);
        testFortuneLog.addFortune(testFortune4);

        assertFalse(testFortuneLog.getGoodFortunes().contains(testFortune1));
        assertTrue(testFortuneLog.getGoodFortunes().contains(testFortune2));
        assertTrue(testFortuneLog.getGoodFortunes().contains(testFortune4));
    }

    @Test
    public void testGetBadFortunes() {
        testFortuneLog.addFortune(testFortune1);
        testFortuneLog.addFortune(testFortune2);

        assertFalse(testFortuneLog.getBadFortunes().contains(testFortune2));
        assertTrue(testFortuneLog.getBadFortunes().contains(testFortune1));
    }

    @Test
     public void testGetBadFortunesMultiples() {
        testFortuneLog.addFortune(testFortune1);
        testFortuneLog.addFortune(testFortune2);
        testFortuneLog.addFortune(testFortune3);
        testFortuneLog.addFortune(testFortune4);

        assertFalse(testFortuneLog.getBadFortunes().contains(testFortune2));
        assertFalse(testFortuneLog.getBadFortunes().contains(testFortune4));
        assertTrue(testFortuneLog.getBadFortunes().contains(testFortune1));
        assertTrue(testFortuneLog.getBadFortunes().contains(testFortune3));
    }


}
