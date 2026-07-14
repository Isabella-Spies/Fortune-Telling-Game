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
        testFortune1 = new Fortune("Should I get a coffee?");
    }

    @Test
    void testConstructor() {
        assertEquals(testFortune1.getTopic(), "Should I get a coffee?");
        assertEquals(testFortune2.getType(), 0);
    }

    @Test
    void rollFortuneTest(){
        
        
    }


}
