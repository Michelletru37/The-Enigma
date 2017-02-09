
package enigma;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.Timeout;
import static org.junit.Assert.*;

/**
 * Created by michelletruong on 10/7/16.
 */
public class AlphabetTest {

/* ***** TESTS ***** */

    @Test
    public void checkContainsTest() {
        String chars = "ABC";
        Alphabet alpha = new Alphabet(chars);
        assertEquals(true, alpha.contains('A'));
    }

    @Test
    public void checkToChar() {
        String chars = "ABCDE";
        Alphabet alpha = new Alphabet(chars);
        assertEquals(69, alpha.toChar('E'));
    }

    @Test
    public void checkToInt() {
        String chars = "ABCDE";
        Alphabet alpha = new Alphabet(chars);
        assertEquals(4, alpha.toInt('E'));
    }
}

