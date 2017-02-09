package enigma;

import org.apache.commons.lang3.ArrayUtils;

/* Extra Credit Only */

/** An alphabet of encodable characters.  Provides a mapping from characters
 *  to and from indices into the alphabet.
 *  @author Michelle Truong
 */
class Alphabet {

    /** A new alphabet containing CHARS.  Character number #k has index
     *  K (numbering from 0). No character may be duplicated. */
    Alphabet(String chars) {
        _chars = chars.toCharArray();
    }

    /** Returns the size of the alphabet. */
    int size() {
        return _chars.length;
    }

    /** Returns true if C is in this alphabet. */
    boolean contains(char c) {
        for (int i = 0; i < size(); i++) {
            if (_chars[i] == c) {
                return true;
            }
        }
        return false;
    }

    /** Returns character number INDEX in the alphabet, where
     *  0 <= INDEX < size(). */
    char toChar(int index) {
        return (char) index;
    }

    /** Returns the index of character C, which must be in the alphabet. */
    int toInt(char c) {
        return ArrayUtils.indexOf(_chars, c);
    }

    /** Char[] of chars. **/
    private char[] _chars;

}
