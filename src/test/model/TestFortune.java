package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestFortune {
    Fortune testFortune1;
    Fortune testFortune2;

    @BeforeEach
    void runBefore() {
        testFortune1 = new Fortune("Should I get a coffee?", 0);
    }

    @Test
    void testConstructor() {
        assertEquals(testFortune1.getTopic(), "Should I get a coffee?");
        assertEquals(testFortune2.getType(), 0);

        assertEquals(testFortune2.getTopic(), "What will the next three days look like?");
        assertEquals(testFortune2.getType(), 1);
    }

    @Test
    void rollFortuneTest(){
        // get a number back that is not less than zero
        // get a number back that is not greater than 21
        // get a number back that is not greater than 1 (for 1)
        
    }

    @Test
    void cardFortune(){

    }

    @Test
    void coinFortune(){

    }


}
