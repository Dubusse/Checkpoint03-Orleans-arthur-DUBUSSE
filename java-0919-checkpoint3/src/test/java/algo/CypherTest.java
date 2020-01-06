package algo;

import junit.framework.TestCase;
import org.junit.Test;

public class CypherTest extends TestCase {

    @Test
    public void testTrue() throws Exception {
        assertEquals(true, true);
    }

    @Test
    public void testEncrypt() throws Exception {
        assertEquals("tacos", Cypher.vigenere("tacos",
                new int[]{0}));
        assertEquals("a uhgrfv xo gyirzdrhy", Cypher.vigenere("a secret to everybody",
                new int[]{0, 1, 2, 3, 4}));
        assertEquals("pt hpxqks", Cypher.vigenere("ok boomer",
                new int[]{1, 9, 4, 6}));
    }
}