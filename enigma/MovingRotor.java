package enigma;
import static enigma.EnigmaException.*;

/** Class that represents a rotating rotor in the enigma machine.
 *  @author Michelle Truong
 */
class MovingRotor extends Rotor {

    /** A rotor named NAME whose permutation in its default setting is
     *  PERM, and whose notches are at the positions indicated in NOTCHES.
     *  The Rotor is initally in its 0 setting (first character of its
     *  alphabet).
     */
    MovingRotor(String name, Permutation perm, String notches) {
        super(name, perm);
        _name = name;
        _perm = perm;
        _notches = notches;
    }
    /** Returns your notches as a char[]. **/
    char[] getNotchesArr() {
        return _notches.toCharArray();
    }

    /** Checks if at notch. **/
    @Override
    boolean atNotch() {
        for (int i = 0; i < getNotchesArr().length; i++) {
            if (toLetter(setting()) == getNotchesArr()[i]) {
                return true;
            }
        }
        return false;
    }

    /** Rotor moves. **/
    @Override
    void advance() {
        if (setting() < size()) {
            set((setting() + 1) % size());
        } else {
            set(0);
        }
    }

    /** Name of your moving rotor. **/
    private String _name;

    /** Permutation of your moving rotor. **/
    private Permutation _perm;

    /** Notches of your moving rotor. **/
    private String _notches;

}
