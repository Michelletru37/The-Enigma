package enigma;
import java.util.ArrayList;

import static enigma.EnigmaException.*;

/** Class that represents a complete enigma machine.
 *  @author Michelle Truong
 */
class Machine {

    /** A new Enigma machine with alphabet ALPHA, 1 < NUMROTORS rotor slots,
     *  and 0 <= PAWLS < NUMROTORS pawls.  ALLROTORS contains all the
     *  available rotors. */
    Machine(Alphabet alpha, int numRotors, int pawls,
            ArrayList<Rotor> allRotors) {
        _alphabet = alpha;
        _numRotors = numRotors;
        _pawls = pawls;
        _allRotors = allRotors;
    }

    /** Return the number of rotor slots I have. */
    int numRotors() {
        return _numRotors;
    }

    /** Return the number pawls (and thus rotating rotors) I have. */
    int numPawls() {
        return _pawls;
    }

    /** Set my rotor slots to the rotors named ROTORS from my set of
     *  available rotors (ROTORS[0] names the reflector).
     *  Initially, all rotors are set at their 0 setting. */
    void insertRotors(String[] rotors) {
        _rotorsName[0] = rotors[0];
        _rotorsName[1] = rotors[1];
        _rotorsName[2] = rotors[2];
        _rotorsName[3] = rotors[3];
        _rotorsName[4] = rotors[4];
    }

    /** Set my rotors according to SETTING, which must be a string of four
     *  upper-case letters. The first letter refers to the leftmost
     *  rotor setting (not counting the reflector). REF, FIX, ROT3, ROT4, ROT5.
     *  **/
    void setRotors(Rotor ref, Rotor fix, Rotor rot3, Rotor rot4, Rotor rot5, String setting) {
        _reflector = ref;
        _fixed = fix;
        _rotor3 = rot3;
        _rotor4 = rot4;
        _rotor5 = rot5;
        Rotor[] rotorz = new Rotor[] {_reflector, _fixed, _rotor3, _rotor4, _rotor5};

        char posnFixed = setting.charAt(0);
        char posnrot3 = setting.charAt(1);
        char posnrot4 = setting.charAt(2);
        char posnrot5 = setting.charAt(3);
        rotorz[1].set(posnFixed - 'A');
        rotorz[2].set(posnrot3 - 'A');
        rotorz[3].set(posnrot4 - 'A');
        rotorz[4].set(posnrot5 - 'A');
    }

    /** Set the plugboard to PLUGBOARD. */
    void setPlugboard(Permutation plugboard) {
        _plugboard = plugboard;
    }

    /** Returns the result of converting the input character C (as an
     *  index in the range 0..alphabet size - 1), after first advancing
     *  the machine. */
    int convert(int c) {
        String plugCycles = _plugboard.getCycles();
        String noPPlugCycles = plugCycles.replaceAll("\\s+", "");
        String plugCyclesNoPar = _plugboard.getCycles().replaceAll("[()]", "");
        plugCyclesNoPar = plugCyclesNoPar.replaceAll("\\s+", "");
        char[] noParArr = _plugboard.getPermToArray();
        char[] parCharArray = _plugboard.getParCharArray();
        String parString = parCharArray.toString();
        char letter = toLetter(c);
        int index = 0;
        if (hasPlugboard()) {
            if (noPPlugCycles.contains(Character.toString((char) (c)))) {
                int i = noPPlugCycles.indexOf((char) (c));
                if (parCharArray[i + 1] == ')') {
                    index = parCharArray[i - 1];
                    index = index - 'A';
                }
                if (parCharArray[i - 1] == '(') {
                    index = parCharArray[i + 1];
                    index = index - 'A';
                }
            } else {
                index = c - 'A';
            }
        }

        index = _rotor5.convertForward(index);
        index = _rotor4.convertForward(index);
        index = _rotor3.convertForward(index);
        index = _fixed.convertForward(index);
        index = _reflector.convertForward(index);
        index = _fixed.convertBackward(index);
        index = _rotor3.convertBackward(index);
        index = _rotor4.convertBackward(index);
        index = _rotor5.convertBackward(index);
        char check = toLetter(index);

        if (noPPlugCycles.contains(Character.toString(check))) {
            int i = noPPlugCycles.indexOf(check);
            if (parCharArray[i + 1] == ')') {
                index = parCharArray[i - 1];
            }
            if (parCharArray[i - 1] == '(') {
                index = parCharArray[i + 1];
            }
            index = index - 'A';
            return toLetter(index);
        } else {
            return toLetter(index);
        }
    }
    /** Return true if there is plugboard. **/
    boolean hasPlugboard() {
        if (_plugboard != null) {
            return true;
        } else {
            return false;
        }
    }

    /** Returns the encoding/decoding of MSG, updating the state of
     *  the rotors accordingly. */
    String convert(String msg) {
        msg = msg.toUpperCase().replaceAll("\\s+", "");
        msg = msg.replaceAll(",", "").replaceAll("\\[", "");
        msg = msg.replaceAll("\\]", "");
        char[] msgArray = msg.toCharArray();
        for (int i = 0; i < msg.length(); i++) {

            if (_rotor5.atNotch() && _rotor4.atNotch()) {
                _rotor5.advance();
                _rotor4.advance();
                _rotor3.advance();
            } else if (_rotor5.atNotch()) {
                _rotor5.advance();
                _rotor4.advance();
            } else if (_rotor4.atNotch()) {
                _rotor5.advance();
                _rotor4.advance();
                _rotor3.advance();
            } else {
                _rotor5.advance();
            }
            if (msg.charAt(i) - 'A' == -1) {
                return null;
            }
            msgArray[i] = (char) _machine.convert(msg.charAt(i));
        }
        String msgString = String.valueOf(msgArray);
        return msgString;
    }

    /** Returns I as a char. **/
    char toLetter(int i) {
        return (char) (i + 'A');
    }

    /** Final alphabet. **/
    private final Alphabet _alphabet;

    /** Number of rotors in machine. **/
    private int _numRotors;

    /** Number of pawls in machine. **/
    private int _pawls;

    /** Contains your rotors that you will use. **/
    private String[] _rotorsName = new String[5];

    /** Contains your moving rotors. **/
    private MovingRotor[] movingRotors = new MovingRotor[3];

    /** Contains your fixed rotors. **/
    private FixedRotor[] fixedRotors = new FixedRotor[1];

    /** Contains your reflectors. **/
    private Reflector[] reflectors = new Reflector[1];

    /** Your plugboard. **/
    private Permutation _plugboard;

    /** Your collection of all the rotors. **/
    private ArrayList<Rotor> _allRotors = new ArrayList<Rotor>();

    /** Your reflector. **/
    private static Rotor _reflector;

    /** Your fixedRotor. **/
    private static Rotor _fixed;

    /** Your moving rotor III. **/
    private static Rotor _rotor3;

    /** Your moving rotor IV. **/
    private static Rotor _rotor4;

    /** Your moving rotor V. **/
    private static Rotor _rotor5;

    /** Your machine. **/
    private Machine _machine = this;

    /** Array of rotors. **/
    private Rotor[] rotorz = new Rotor[] {_reflector, _fixed, _rotor3, _rotor4, _rotor5};

}
