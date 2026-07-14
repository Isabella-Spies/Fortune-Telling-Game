package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestFortune {
    Fortune testFortune1;
    Fortune testFortune2;

    @BeforeEach
    void runBefore() {
        testFortune1 = new Fortune("Should I get a coffee?");
    }

    @Test
    void testConstructor() {
        assertEquals(testFortune1.getTopic(), "Should I get a coffee?");
        assertEquals(testFortune1.getType(), 0);
        assertEquals(testFortune1.getResult(), null);
        assertEquals(testFortune1.getRating(), false);
    }

    @Test
    void testRollFortune(){
        ArrayList<String> acceptedOutputs = new ArrayList<String>();
        acceptedOutputs.add("Heads");
        acceptedOutputs.add("Tails");

        testFortune1.rollFortune();
        assertTrue(acceptedOutputs.contains(testFortune1.getResult()));
    }

    @Test
    void testRollFortuneMultiples(){
        ArrayList<String> acceptedOutputs = new ArrayList<String>();
        acceptedOutputs.add("Heads");
        acceptedOutputs.add("Tails");

        testFortune1.rollFortune();
        assertTrue(acceptedOutputs.contains(testFortune1.getResult()));

        testFortune1.rollFortune();
        assertTrue(acceptedOutputs.contains(testFortune1.getResult()));
    }


}
