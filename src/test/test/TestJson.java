package test;

import org.junit.Test;
import model.Fortune;
import static org.junit.jupiter.api.Assertions.assertEquals;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

@ExcludeFromJacocoGeneratedReport
public class TestJson {
    
    protected void checkFortuneCorrectness(String topic, String result, boolean rating, Fortune fortune) {
        assertEquals(topic, fortune.getTopic());
        assertEquals(result, fortune.getResult());
        assertEquals(rating, fortune.getRating());
    }
}
