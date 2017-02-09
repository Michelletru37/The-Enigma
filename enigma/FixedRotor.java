package enigma;


/** Class that represents a rotor that has no ratchet and does not advance.
 *  @author Michelle Truong
 */
class FixedRotor extends Rotor {

    /** A non-moving rotor named NAME whose permutation at the 0 setting
     * is given by PERM. */
    FixedRotor(String name, Permutation perm) {
        super(name, perm);
        _name = name;
        _perm = perm;
    }

    @Override
    /** Fixed rotors don't advance. **/
    void advance() {
    }

    /** Name of fixed rotor. **/
    private String _name;

    /** Permutation of fixed rotor. **/
    private Permutation _perm;
}
