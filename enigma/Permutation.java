package enigma;


/** Represents a permutation of a range of integers starting at 0 corresponding
 *  to the characters of an alphabet.
 *  @author Michelle Truong
 */
class Permutation {

    /** Set this Permutation to that specified by CYCLES, a string in the
     *  form "(cccc) (cc) ..." where the c's are characters in ALPHABET, which
     *  is interpreted as a permutation in cycle notation.  Characters not
     *  included in any cycle map to themselves. Whitespace is ignored. */
    Permutation(String cycles, Alphabet alphabet) {
        cyclestoString(cycles);
        _alphabet = alphabet;
        _cycles = cycles;
        _cycleswithParenth = cycles;
    }
    /** converts list of cycles to an array. Takes in a list CYCLES. **/
    public void cyclestoString(String cycles) {
        _cycles = cycles.replaceAll("\\s", "").replaceAll(",", "");
        _cycleswithParenth = cycles.replaceAll("\\s", "").replaceAll(",", "");
        char[] parCharArray = _cycleswithParenth.toCharArray();
        _cycles = _cycles.replaceAll("[()]", "");
        char[] stringtoCharArray =  _cycles.toCharArray();
        _parCharArray = parCharArray;
        _permutationsToArray =  stringtoCharArray;
    }

    /** Returns cycles. **/
    public String getCycles() {
        return _cycles;
    }
    /** Returns a converted string of permutations into array format. **/
    public char[] getPermToArray() {
        return _permutationsToArray;
    }
    /** Returns permutations in array form. **/
    public char[] getParCharArray() {
        return _parCharArray;
    }

    /** Add the cycle c0->c1->...->cm->c0 to the permutation, where CYCLE is
     *  c0c1...cm. */
    private void addCycle(String cycle) {
    }

    /** Return the value of P modulo the size of this permutation. */
    final int wrap(int p) {
        int r = p % size();
        if (r < 0) {
            r += size();
        }
        return r;
    }

    /** Returns the size of the alphabet I permute. */
    int size() {
        return _alphabet.size();
    }

    /** Return the result of applying this permutation to P modulo the
     *  alphabet size. */
    int permute(int p) {
        return p % _alphabet.size();
    }

    /** Return the result of applying the inverse of this permutation
     *  to  C modulo the alphabet size. */
    int invert(int c) {
        return c % _alphabet.size();
    }

    /** Return the result of applying this permutation to the index of P
     *  in ALPHABET, and converting the result to a character of ALPHABET. */
    char permute(char p) {
        return p;
    }

    /** Return the result of applying the inverse of this permutation to C. */
    int invert(char c) {
        int a = c;
        return a;
    }

    /** Return the alphabet used to initialize this Permutation. */
    Alphabet alphabet() {
        return _alphabet;
    }

    /** Return true iff this permutation is a derangement (i.e., a
     *  permutation for which no value maps to itself). */
    boolean derangement() {
        if (_cycles == null) {
            return true;
        }
        return false;
    }

    /** Alphabet of this permutation. */
    private Alphabet _alphabet;

    /** Cycle of this permutation. **/
    private String _cycles;

    /** Cycle with parentheses. **/
    private String _cycleswithParenth;

    /** Permutations in array form. **/
    private char[] _permutationsToArray;

    /** Cycles with parentheses in array form. **/
    private char[] _parCharArray;

}

