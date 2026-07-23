package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.CardReading;
import model.CoinFlip;
import model.Fortune;

public class TestCardReading {
    Fortune testFortune;
    Fortune testFortune2;
    ArrayList<String> acceptedOutputs;

    @BeforeEach
    void runBefore() {
        testFortune = new CardReading("Should I get a coffee?");
        acceptedOutputs = new ArrayList<String>();
    }

    @Test
    void testConstructor() {
        assertEquals(testFortune.getTopic(), "Should I get a coffee?");
        assertEquals(testFortune.getResult(), null);
        assertEquals(testFortune.getRating(), false);
    }

    @Test
    void testRollFortune() {
        ArrayList<String> acceptedOutputs = new ArrayList<String>();
        acceptedOutputs.add("The Fool");
        acceptedOutputs.add("The Magician");

        testFortune.rollFortune();
        assertTrue(acceptedOutputs.contains(testFortune.getResult()));
    }

    @Test
    void testRollFortuneMultiples() {
        ArrayList<String> acceptedOutputs = new ArrayList<String>();
        acceptedOutputs.add("The Fool");
        acceptedOutputs.add("The Magician");

        testFortune.rollFortune();
        assertTrue(acceptedOutputs.contains(testFortune.getResult()));

        testFortune.rollFortune();
        assertTrue(acceptedOutputs.contains(testFortune.getResult()));
    }

    @Test
    void testInterpretFortune() {
        assertEquals(testFortune.interpretFortune(0), "The Fool");
        assertEquals(testFortune.interpretFortune(1), "The Magician");
    }
}
