package test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.CardReading;
import model.CoinFlip;
import model.Fortune;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

@ExcludeFromJacocoGeneratedReport
public class TestCardReading {
    CardReading testFortune;
    CardReading testFortune2;
    ArrayList<String> acceptedOutputs;

    @BeforeEach
    void runBefore() {
        testFortune = new CardReading("Should I get a coffee?");
        testFortune2 = new CardReading("What is up?", "The Fool, The Magician, The World", false);
        acceptedOutputs = testFortune.getCardNames();
    }

    @Test
    void testConstructor() {
        assertEquals(testFortune.getTopic(), "Should I get a coffee?");
        assertEquals(testFortune.getResult(), null);
        assertEquals(testFortune.getRating(), false);
        assertNotEquals(null, testFortune.getCardNames());

        assertEquals(22, testFortune.getCardNames().size());


        assertEquals("What is up?", testFortune2.getTopic());
        assertEquals("The Fool, The Magician, The World", testFortune2.getResult());
        assertEquals(false, testFortune2.getRating());

    }

    @Test
    void testRollFortune() {
        testFortune.rollFortune();
        String numericalResults = acceptedOutputs.get(testFortune.getResultNums().get(0)) + ", " +
                                  acceptedOutputs.get(testFortune.getResultNums().get(1)) + ", " +
                                  acceptedOutputs.get(testFortune.getResultNums().get(2));
        assertEquals(numericalResults, testFortune.getResult());
    }

    @Test
    void testRollFortuneMultiples() {
        testFortune.rollFortune();
        String numericalResults = acceptedOutputs.get(testFortune.getResultNums().get(0)) + ", " +
                                  acceptedOutputs.get(testFortune.getResultNums().get(1)) + ", " +
                                  acceptedOutputs.get(testFortune.getResultNums().get(2));

        assertEquals(numericalResults, testFortune.getResult());

        testFortune.rollFortune();
        numericalResults = acceptedOutputs.get(testFortune.getResultNums().get(0)) + ", " +
                           acceptedOutputs.get(testFortune.getResultNums().get(1)) + ", " +
                           acceptedOutputs.get(testFortune.getResultNums().get(2));

        assertEquals(numericalResults, testFortune.getResult());
    }

    @Test
    void testRollFortuneNoDuplicates() {
        testFortune.rollFortune();
        int prev = -1;
        assertEquals(3, testFortune.getResultNums().size());
        for (Integer integer: testFortune.getResultNums()) {
            if (integer == prev) {
                fail();
            } else if (!(integer >= 0 || integer <= 21)) {
                fail();
            }
            else {
                prev = integer;
            }
        }
    }

    @Test
    void testInterpretFortune() {
        assertEquals(testFortune.interpretFortune(0), "The Fool");
        assertEquals(testFortune.interpretFortune(1), "The Magician");
        assertEquals(testFortune.interpretFortune(21), "The World");
    }
}
