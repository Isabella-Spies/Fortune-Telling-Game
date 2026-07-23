package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.CoinFlip;
import model.Fortune;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

@ExcludeFromJacocoGeneratedReport
public class TestCoinFlip {
    Fortune testFortune;
    Fortune testFortune2;

    @BeforeEach
    void runBefore() {
        testFortune = new CoinFlip("Should I get a coffee?");
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
        acceptedOutputs.add("Heads");
        acceptedOutputs.add("Tails");

        testFortune.rollFortune();
        assertTrue(acceptedOutputs.contains(testFortune.getResult()));
    }

    @Test
    void testRollFortuneMultiples() {
        ArrayList<String> acceptedOutputs = new ArrayList<String>();
        acceptedOutputs.add("Heads");
        acceptedOutputs.add("Tails");

        testFortune.rollFortune();
        assertTrue(acceptedOutputs.contains(testFortune.getResult()));

        testFortune.rollFortune();
        assertTrue(acceptedOutputs.contains(testFortune.getResult()));
    }

    @Test
    void testInterpretFortuneHeads() {
        assertEquals(testFortune.interpretFortune(0), "Heads");
    }

    @Test
    void testInterpretFortuneTails() {
        assertEquals(testFortune.interpretFortune(1), "Tails");
    }
}
