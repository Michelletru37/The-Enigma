package enigma;

import java.io.PrintStream;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.HashMap;
import static enigma.EnigmaException.*;

/** Enigma simulator.
 *  @author Michelle Truong
 */
public final class Main {

    /**
     * Process a sequence of encryptions and decryptions, as
     * specified by ARGS, where 1 <= ARGS.length <= 3.
     * ARGS[0] is the name of a configuration file.
     * ARGS[1] is optional; when present, it names an input file
     * containing messages.  Otherwise, input comes from the standard
     * input.  ARGS[2] is optional; when present, it names an output
     * file for processed messages.  Otherwise, output goes to the
     * standard output. Exits normally if there are no errors in the input;
     * otherwise with code 1.
     */
    public static void main(String... args) {

        try {
            new Main(args).process();
            return;
        } catch (EnigmaException excp) {
            System.err.printf("Error: %s%n", excp.getMessage());
        }
        System.exit(1);
    }

    /**
     * Check ARGS and open the necessary files (see comment on main).
     */
    Main(String[] args) {
        if (args.length < 1 || args.length > 3) {
            throw error("Only 1, 2, or 3 command-line arguments allowed");
        }
        _config = getInput(args[0]);

        if (args.length > 1) {
            _input = getInput(args[1]);
        } else {
            _input = new Scanner(System.in);
        }

        if (args.length > 2) {
            _output = getOutput(args[2]);
        } else {
            _output = System.out;
        }
    }

    /**
     * Return a Scanner reading from the file named NAME.
     */
    private Scanner getInput(String name) {
        try {
            return new Scanner(new File(name));
        } catch (IOException excp) {
            throw error("could not open %s", name);
        }
    }

    /**
     * Return a PrintStream writing to the file named NAME.
     */
    private PrintStream getOutput(String name) {
        try {
            return new PrintStream(new File(name));
        } catch (IOException excp) {
            throw error("could not open %s", name);
        }
    }

    /**
     * Configure an Enigma machine from the contents of configuration
     * file _config and apply it to the messages in _input, sending the
     * results to _output.
     */
    private void process() {
        readConfig();
        allRotorsGenerator();
        m = new Machine(_alphabet, _numRotors, _numPawns, allRotors);
        while (_input.hasNextLine()) {
            setRotorArr();
            setUp(m, _settings);
        }
    }

    /** Creates non-moving rotors. **/
    private void createNMRotors() {
        String cyclesNoPar;
        int length = 0;
        List cyclesList = new ArrayList();
        while (length < _alphabet.size()) {
            String cycles = _config.next();
            cyclesNoPar = cycles.replaceAll("[()]", "");
            int cycleLength = cyclesNoPar.length();
            length += cycleLength;
            cyclesList.add(cycles);
        }
        cyclesString = cyclesList.toString();
        cyclesString = cyclesString.replaceAll("\\[", "");
        cyclesString = cyclesString.replaceAll("\\]", "").replaceAll(",", "");
        perm = new Permutation(cyclesString, _alphabet);

        if (rotorType.charAt(0) == 'M') {
            Rotor mR = new MovingRotor(_name, perm, notchesString);
            allRotors.add(mR);
        }
        if (rotorType.charAt(0) == 'N') {
            Rotor fR = new FixedRotor(_name, perm);
            allRotors.add(fR);
        }
        if (rotorType.charAt(0) == 'R') {
            Rotor r = new Reflector(_name, perm);
            allRotors.add(r);
        }
    }

    /** Creates moving rotors. **/
    private void createMRotors() {
        String notches = _config.next();
        rotorType = Character.toString(notches.charAt(0));
        List<String> notchesList = new ArrayList();
        for (int i = 1; i < notches.length(); i++) {
            notchesList.add(Character.toString(notches.charAt(i)));
        }
        notchesString = notchesList.toString().replaceAll("\\[", "");
        notchesString = notchesString.replaceAll("\\]", "");

        String cyclesNoPar;
        int length = 0;
        List cyclesList = new ArrayList();
        while (length < _alphabet.size()) {
            String cycles = new String();
            cycles = _config.next();
            cyclesNoPar = cycles.replaceAll("[()]", "");
            int cycleLength = cyclesNoPar.length();
            length += cycleLength;
            cyclesList.add(cycles);
        }
        cyclesString = cyclesList.toString();
        cyclesString = cyclesString.replaceAll("\\[", "");
        cyclesString = cyclesString.replaceAll("\\]", "").replaceAll(",", "");
        perm = new Permutation(cyclesString, _alphabet);

        if (rotorType.charAt(0) == 'M') {
            Rotor mR = new MovingRotor(_name, perm, notchesString);
            allRotors.add(mR);
        }
        if (rotorType.charAt(0) == 'N') {
            Rotor fR = new FixedRotor(_name, perm);
            allRotors.add(fR);
        }
        if (rotorType.charAt(0) == 'R') {
            Rotor r = new Reflector(_name, perm);
            allRotors.add(r);
        }
    }

    /** Generates allRotors. **/
    private void allRotorsGenerator() {
        while (_config.hasNext()) {
            String a = _config.next();
            if (a.charAt(0) == 'A') {
                continue;
            } else if (a.charAt(0) == '5') {
                String j = a;
                _numRotors = Integer.parseInt(j);
                j = _config.next();
                _numPawns = Integer.parseInt(j);
            }

            String nextPhrase = a;
            if (Arrays.asList(reflectorNames).contains((nextPhrase))) {
                _name = nextPhrase;
                rotorType = _config.next();
                createNMRotors();
            }
            if (Arrays.asList(fixedRotorNames).contains((nextPhrase))) {
                _name = nextPhrase;
                rotorType = _config.next();
                createNMRotors();
            }
            if (Arrays.asList(rotorNames).contains(nextPhrase)) {
                _name = nextPhrase;
                createMRotors();
            }
        }
    }

    /**
     * Return an Enigma machine configured from the contents of configuration
     * file _config.
     */
    private Machine readConfig() {
        try {
            _alphabet = new UpperCaseAlphabet();
            return new Machine(_alphabet, 2, 1, null);
        } catch (NoSuchElementException excp) {
            throw error("configuration file truncated");
        }
    }

    /** Returns array of rotor names that you'll use according to _input. **/
    private void setRotorArr() {
        String[] rotors = new String[5];
        String a = _input.next();
        if (a.charAt(0) == '*') {
            rotors[0] = _input.next();
        } else {
            rotors[0] = a;
        }
        rotors[1] = _input.next();
        rotors[2] = _input.next();
        rotors[3] = _input.next();
        rotors[4] = _input.next();
        _settings = _input.next();

        HashMap<String, Rotor> stuff = new HashMap<String, Rotor>() { {
                put("I", allRotors.get(0));
                put("II", allRotors.get(1));
                put("III", allRotors.get(2));
                put("IV", allRotors.get(3));
                put("V", allRotors.get(4));
                put("VI", allRotors.get(5));
                put("VII", allRotors.get(6));
                put("VIII", allRotors.get(7));
                put("BETA", allRotors.get(8));
                put("GAMMA", allRotors.get(9));
                put("B", allRotors.get(10));
                put("C", allRotors.get(11));
            } };

        for (int i = 0; i < rotors.length; i++) {
            rotorz[i] = stuff.get(rotors[i]);
        }
        rotorArrNames = rotors;
    }
    /** Creates plugboard cycles. **/
    private void setPlugCycles() {
        String plugCyclesString = "";
        ArrayList plugCycles = new ArrayList();
        while (_input.hasNext()) {
            String k = _input.next();
            char beg = k.charAt(0);
            if (beg != '*' && !_alphabet.contains(beg) && (beg == '(')) {
                plugCycles.add(k);
            } else {
                _k = k;
                plugCyclesString = plugCycles.toString().replaceAll("\\]", "");
                plugCyclesString = plugCyclesString.replaceAll("\\[", "");
                plugCyclesString = plugCyclesString.replaceAll(",", "");
                break;
            }
        }
        plugboard = new Permutation(plugCyclesString, _alphabet);
    }
    /** Creates and prints each line inn _input. Takes in K. **/
    private void setFullMsg(String k) {
        while (_input.hasNextLine()) {
            String line = k + _input.nextLine();
            _entireMsg = m.convert(line.toString());
            printMessageLine(_entireMsg);
            break;
        }
        while (_input.hasNextLine()) {
            String line = _input.nextLine();
            _entireMsg = m.convert(line.toString());
            printMessageLine(_entireMsg);
        }
    }

    /**
     * Set MAC according to the specification given on SETTINGS,
     * which must have the format specified in the assignment.
     */
    private void setUp(Machine mac, String settings) {
        m.insertRotors(rotorArrNames);
        m.setRotors(rotorz[0], rotorz[1], rotorz[2], rotorz[3], rotorz[4], _settings);
        setPlugCycles();
        m.setPlugboard(plugboard);
        setFullMsg(_k);
    }

    /**
     * Print MSG in groups of five (except that the last group may
     * have fewer letters).
     */
    private void printMessageLine(String msg) {
        String msg2 = msg;
        if (msg.length() == 0) {
            System.out.println();
        } else {
            while (msg2.length() > 0) {
                if (msg2.length() <= 5) {
                    System.out.println(msg2);
                    msg2 = "";
                } else {
                    System.out.print(msg2.substring(0, 5) + " ");
                    msg2 = msg2.substring(5, msg2.length());
                }
            }
        }
    }
    /** Variable to keep check if character is a star. **/
    private String star;

    /** Variable that holds the last _config.next(). **/
    private String _k;

    /** My rotors in my machine. **/
    private Rotor ref, fix, rot3, rot4, rot5;

    /** Array of my rotors in machine. **/
    private Rotor[] rotorz = new Rotor[] {ref, fix, rot3, rot4, rot5};

    /** Alphabet used in this machine. */
    private Alphabet _alphabet;

    /** Source of input messages. */
    private Scanner _input;

    /** Source of machine configuration. */
    private Scanner _config;

    /** File for encoded/decoded messages. */
    private PrintStream _output;

    /** Name of rotor. */
    private String _name;

    /** String Array of numbers 0-5. **/
    private String[] numArr = new String[] {"0", "1", "2", "3", "4", "5"};

    /** Collection of all the rotors. **/
    private ArrayList<Rotor> allRotors = new ArrayList<Rotor>();

    /** String[] of moving rotors. **/
    private String[] rotorNames = new String[] {"I", "II", "III", "IV", "V", "VI", "VII", "VIII"};

    /** String[] of fixed rotors. **/
    private String[] fixedRotorNames = new String[] {"Beta", "Gamma"};

    /** String[] of reflectors. **/
    private String[] reflectorNames = new String[] {"B", "C"};

    /** Number of rotors according to _config. **/
    private int _numRotors;

    /** Number of pawns according to _config. **/
    private int _numPawns;

    /** Plugboard permutation. **/
    private Permutation plugboard;

    /** The type of rotor: M = moving, N = fixed, R = reflector. **/
    private String rotorType;

    /** String of cycles according to _config. **/
    private String cyclesString;

    /** Settings according to _input. **/
    private String _settings;

    /** String of notches that we make each rotor with. **/
    private String notchesString;

    /** Permutation. **/
    private Permutation perm;

    /*** My configured machine. **/
    private Machine m;

    /** My message. **/
    private String _entireMsg;

    /** String[] of reflectors used to check format of configuration line. **/
    private String[] reflectors = new String[] {"B", "C"};

    /** String[] of fixed rotors used to check format of configuration line. **/
    private String[] fixedRotors = new String[] {"Beta", "Gamma"};

    /** String[] of fixed rotors used to check format of configuration line. **/
    private String[] movingRotors = new String[] {"I", "II", "III", "IV", "V", "VI", "VII", "VIII"};

    /** Array of rotor names. **/
    private String[] rotorArrNames = new String[5];

}
