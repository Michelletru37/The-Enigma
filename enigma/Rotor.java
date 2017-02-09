package enigma;

import org.apache.commons.lang3.ArrayUtils;

import static enigma.EnigmaException.*;

/** Superclass that represents a rotor in the enigma machine.
 *  @author Michelle Truong
 */
class Rotor {

    /**
     * A rotor named NAME whose permutation is given by PERM.
     */
    Rotor(String name, Permutation perm) {
        _name = name;
        _permutation = perm;
    }

    /**
     * Return my name.
     */
    String name() {
        return _name;
    }

    /**
     * Return my alphabet.
     */
    Alphabet alphabet() {
        return _permutation.alphabet();
    }

    /**
     * Return my permutation.
     */
    Permutation permutation() {
        return _permutation;
    }

    /**
     * Return the size of my alphabet.
     */
    int size() {
        return _permutation.size();
    }

    /**
     * Return my current setting.
     */
    int setting() {
        return _position % size();
    }

    /**
     * Set setting() to POSN.
     */
    void set(int posn) {
        _position = posn % size();
    }

    /**
     * Return the conversion of P (an integer in the range 0..size()-1)
     * according to my permutation.
     */

    int convertForward(int p) {
        int want = 0;
        int k = 0;
        char[] permArray = _permutation.getPermToArray();
        char[] parCharArray = _permutation.getParCharArray();

        int toconv = p + _position;
        toconv = _permutation.wrap(toconv);
        char letter = toLetter(toconv);

        int index = ArrayUtils.indexOf(parCharArray, letter);
        if (parCharArray[index + 1] == ')') {
            for (int i = 1; i < parCharArray.length; i++) {
                if (parCharArray[index - i] == '(') {
                    char mapTo = parCharArray[index - i + 1];
                    want = toIndex(mapTo);
                    break;
                }
            }
        } else {
            for (int i = 0; i < permuteBase.length(); i++) {
                if (letter == permArray[i]) {
                    want = permArray[i + 1];
                    break;
                }
            }
        }
        if (want > permuteBase.length()) {
            want = want - 'A';
        }
        return _permutation.wrap((want - _position) % size());

    }

    /**
     * Return the conversion of E (an integer in the range 0..size()-1)
     * according to the inverse of my permutation.
     */
    int convertBackward(int e) {
        int want = 0;
        int k = 0;
        char[] permArray = _permutation.getPermToArray();
        char[] parCharArray = _permutation.getParCharArray();
        int toconv = e + _position;
        toconv = _permutation.wrap(toconv);

        char letter = toLetter(toconv);
        int index = ArrayUtils.indexOf(parCharArray, letter);
        if (parCharArray[index - 1] == '(') {
            for (int i = 1; i < parCharArray.length; i++) {
                if (parCharArray[index + i] == ')') {
                    char mapTo = parCharArray[index + i - 1];
                    want = toIndex(mapTo);
                    break;
                }
            }
        } else {

            for (int i = 0; i < alphabet().size(); i++) {
                if (letter == permArray[i]) {
                    want = permArray[i - 1];
                    break;
                }
            }
        }
        if (want > permuteBase.length()) {
            want = want - 'A';
        }
        return _permutation.wrap((want - _position) % permuteBase.length());
    }

    /** Returns the conversion of I to character. **/
    char toLetter(int i) {
        return (char) (i + 'A');
    }

    /** Returns the conversition of C to integer. **/
    int toIndex(char c) {
        return (c - 'A');
    }

    /**
     * Returns true iff I am positioned to allow the rotor to my left
     * to advance.
     */
    boolean atNotch() {
        return false;
    }

    /**
     * Advance me one position, if possible. By default, does nothing.
     */
    void advance() {
    }

    /** Returns name of Rotor. Never used this. **/
    @Override
    public String toString() {
        return "Rotor " + _name;
    }

    /**
     * My name.
     */
    private final String _name;

    /**
     * The permutation implemnted by this rotor in its 0 position.
     */
    private Permutation _permutation;

    /** My position. **/
    private int _position;

    /** Used for size comparison. **/
    private String permuteBase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";





}
