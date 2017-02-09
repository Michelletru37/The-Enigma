package enigma;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


/**
 * Created by michelletruong on 10/7/16.
 */
public class MachineTest {

    @Test
    public void advance() {
        Permutation plug = new Permutation("", alpha);
        String setting = "AXLE";
        Reflector ref = new Reflector("B", reflectBPerm);
        FixedRotor fix = new FixedRotor("BETA", fixedBetaPerm);
        MovingRotor ro3 = new MovingRotor("III", rotorIIIPerm, notchesrotIII);
        MovingRotor ro4 = new MovingRotor("IV", rotorIVPerm, notchesrotIV);
        MovingRotor ro5 = new MovingRotor("I", rotorIPerm, notchesrotI);
        String[] refArr = {"B", "BETA", "III", "IV", "I"};
        Machine m1 = new Machine(alpha, 5, 4, collection);
        m1.insertRotors(refArr);
        m1.setRotors(ref, fix, ro3, ro4, ro5, setting);
        m1.setPlugboard(plug);

        String fin = m1.convert("FROMHISSHOULDERHIAWATHA");
        assertEquals("HYIHLBKOMLIUYDCMPPSFSZW", fin);

    }
    @Test
    public void advance2() {
        Permutation plug = new Permutation("(AQ)(EP)", alpha);
        String setting = "AAAA";
        Reflector ref = new Reflector("B", reflectBPerm);
        FixedRotor fix = new FixedRotor("BETA", fixedBetaPerm);
        MovingRotor ro3 = new MovingRotor("I", rotorIPerm, notchesrotI);
        MovingRotor ro4 = new MovingRotor("II", rotorIIPerm, notchesrotII);
        MovingRotor ro5 = new MovingRotor("III", rotorIIIPerm, notchesrotIII);
        String[] refArr = {"B", "BETA", "I", "II", "III"};
        Machine m1 = new Machine(alpha, 5, 4, collection);
        m1.insertRotors(refArr);
        m1.setRotors(ref, fix, ro3, ro4, ro5, setting);
        m1.setPlugboard(plug);

        String fin = m1.convert("HELLOWORLD");
        assertEquals("IHBDQQMTQZ", fin);

    }
    @Test
    public void advance3() {
        Permutation plug = new Permutation("(AQ)(EP)", alpha);
        String setting = "AAAA";
        Reflector ref = new Reflector("B", reflectBPerm);
        FixedRotor fix = new FixedRotor("BETA", fixedBetaPerm);
        MovingRotor ro3 = new MovingRotor("I", rotorIPerm, notchesrotI);
        MovingRotor ro4 = new MovingRotor("II", rotorIIPerm, notchesrotII);
        MovingRotor ro5 = new MovingRotor("III", rotorIIIPerm, notchesrotIII);
        String[] refArr = {"B", "BETA", "I", "II", "III"};
        Machine m1 = new Machine(alpha, 5, 4, collection);
        m1.insertRotors(refArr);
        m1.setRotors(ref, fix, ro3, ro4, ro5, setting);
        m1.setPlugboard(plug);

        String fin = m1.convert("IHBDQQMTQZ");
        assertEquals("HELLOWORLD", fin);
    }

    Alphabet alpha = new Alphabet("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
    Permutation rotorIPerm = new Permutation("(AELTPHQXRU) (BKNW) (CMOY) (DFG) (IV) (JZ) (S)", alpha);
    Permutation rotorIIPerm = new Permutation("(FIXVYOMW) (CDKLHUP) (ESZ) (BJ) (GR) (NT) (A) (Q)", alpha);
    Permutation rotorIIIPerm = new Permutation("(ABDHPEJT) (CFLVMZOYQIRWUKXSG) (N)", alpha);
    Permutation rotorIVPerm = new Permutation("(AEPLIYWCOXMRFZBSTGJQNH) (DV) (KU)", alpha);
    Permutation rotorVPerm = new Permutation("(AVOLDRWFIUQ)(BZKSMNHYC) (EGTJPX)", alpha);
    Permutation rotorVIPerm = new Permutation("(AJQDVLEOZWIYTS) (CGMNHFUX) (BPRK)", alpha);
    Permutation rotorVIIPerm = new Permutation("(ANOUPFRIMBZTLWKSVEGCJYDHXQ)", alpha);
    Permutation rotorVIIIPerm = new Permutation("(AFLSETWUNDHOZVICQ) (BKJ) (GXY) (MPR)", alpha);
    Permutation fixedBetaPerm = new Permutation("(ALBEVFCYODJWUGNMQTZSKPR) (HIX)", alpha);
    Permutation fixedGammaPerm = new Permutation("(AFNIRLBSQWVXGUZDKMTPCOYJHE)", alpha);
    Permutation reflectBPerm = new Permutation("(AE) (BN) (CK) (DQ) (FU) (GY) (HW) (IJ) (LO) (MP) (RX) (SZ) (TV)", alpha);
    Permutation reflectCPerm = new Permutation("(AR) (BD) (CO) (EJ) (FN) (GT) (HK) (IV) (LM) (PW) (QZ) (SX) (UY)", alpha);
    Rotor rotI = new Rotor("I", rotorIPerm);
    Rotor rotII = new Rotor("II", rotorIIPerm);
    Rotor rotIII = new Rotor("III", rotorIIIPerm);
    Rotor rotIV = new Rotor("IV", rotorIVPerm);
    Rotor rotV = new Rotor("V", rotorVPerm);
    Rotor rotVI = new Rotor("VI", rotorVIPerm);
    Rotor rotVII = new Rotor("VII", rotorVIIPerm);
    Rotor rotVIII = new Rotor("VIII", rotorVIIIPerm);
    Rotor fixedBeta = new Rotor("Beta", fixedBetaPerm);
    Rotor fixedGamma = new Rotor("Gamma", fixedGammaPerm);
    Rotor reflectB = new Rotor("B", reflectBPerm);
    Rotor reflectC = new Rotor("C", reflectCPerm);

    ArrayList<Rotor> collection = new ArrayList<Rotor>() {
        {
            add(rotI);
            add(rotII);
            add(rotIII);
            add(rotIV);
            add(rotV);
            add(rotVI);
            add(rotVII);
            add(rotVIII);
            add(fixedBeta);
            add(fixedGamma);
            add(reflectB);
            add(reflectC);
        }
    };

    String notchesrotI = "Q";
    String notchesrotII = "E";
    String notchesrotIII = "V";
    String notchesrotIV = "J";
    String notchesrotV = "Z";
    String notchesVI, notchesVII, notchesVIII = "ZM";

}


