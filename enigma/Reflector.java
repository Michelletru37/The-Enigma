package enigma;

import static enigma.EnigmaException.*;

/** Class that represents a reflector in the enigma.
 *  @author Michelle Truong
 */
class Reflector extends FixedRotor {

    /** A non-moving rotor named NAME whose permutation at the 0 setting
     * is PERM. */
    Reflector(String name, Permutation perm) {
        super(name, perm);
        _name = name;
        _perm = perm;
    }

    /** Reflector has one position. **/
    @Override
    void set(int posn) {
        if (posn != 0) {
            throw error("reflector has only one position");
        }
    }

    /** Fixed rotors don't have notches. **/
    @Override
    boolean atNotch() {
        return false;
    }

    /** Fixed rotors do not advance. **/
    @Override
    void advance() {
        throw error("Can't advance");
    }

    /** Name of reflector. **/
    private String _name;

    /** Fixed rotor permutation. **/
    private Permutation _perm;

}
