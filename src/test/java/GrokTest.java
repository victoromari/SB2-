import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

class GrokTest {
    private static Random rand;

    @BeforeAll
    static void beforeAll() {
        rand = new Random();
    }

    @Test
    void getPowerLevel() {
        for(int count = 0; count < 3; count++){
            int expected = rand.nextInt(300);
            Grok aGrok = new Grok(expected);
            int actual = aGrok.getPowerLevel();
            assertEquals(expected,actual,"Expected " + expected + " got "+ actual);
        }
    }

    @Test
    void setPowerLevel() {
        for(int count = 0; count < 3; count++){
            int expected = rand.nextInt(300);
            Grok aGrok = new Grok();
            aGrok.setPowerLevel(expected);
            int actual = aGrok.getPowerLevel();
            assertEquals(expected,actual,"Expected " + expected + " got "+ actual);
        }
    }

    @Test
    void takePowerPill() {
        for(int index = 0; index < 3; index++){
            int power = rand.nextInt(200);
            PowerPill aPill = new PowerPill("Blue",power);
            Grok aGrok = new Grok();
            int expected = aGrok.getPowerLevel() + power;
            aGrok.takePowerPill(aPill);
            int actual = aGrok.getPowerLevel();
            assertEquals(expected,actual,"Expected " + expected + " got "+ actual);
        }
    }

    @Test
    void tookHit() {
        int power = rand.nextInt(800)+10;
        int expected = (power % 5);
        expected = expected != 0? expected - 5:0;
        Grok aGrok = new Grok(power);
        while (aGrok.getPowerLevel() > 0){
            aGrok.tookHit();
        }
        int actual = aGrok.getPowerLevel();
        assertEquals(expected,actual,"Expected " + expected + " got "+ actual);
    }
}