package org.apache.commons.codec.language;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

public class Metaphone_encode_1_0_Test {

    private Metaphone metaphone;

    @BeforeEach
    public void setUp() {
        metaphone = new Metaphone();
    }

    @Test
    public void testEncode_EmptyString() {
        assertEquals("", metaphone.encode(""));
    }

    @Test
    public void testEncode_NullString() {
        assertEquals("", metaphone.encode(null));
    }

    @Test
    public void testEncode_SingleCharacter() {
        assertEquals("A", metaphone.encode("A"));
        assertEquals("B", metaphone.encode("B"));
        assertEquals("C", metaphone.encode("C"));
        assertEquals("D", metaphone.encode("D"));
        assertEquals("E", metaphone.encode("E"));
        assertEquals("F", metaphone.encode("F"));
    }

    @Test
    public void testEncode_TwoCharacters() {
        assertEquals("K", metaphone.encode("KN"));
        assertEquals("R", metaphone.encode("WR"));
        assertEquals("W", metaphone.encode("WH"));
        assertEquals("S", metaphone.encode("X"));
        assertEquals("S", metaphone.encode("SC"));
        assertEquals("X", metaphone.encode("SH"));
    }

    @Test
    public void testEncode_ThreeCharacters() {
        assertEquals("S", metaphone.encode("SIA"));
        assertEquals("X", metaphone.encode("SIO"));
        assertEquals("T", metaphone.encode("TCH"));
        assertEquals("0", metaphone.encode("TH"));
        assertEquals("K", metaphone.encode("CHA"));
    }

    @Test
    public void testEncode_FourCharacters() {
        assertEquals("J", metaphone.encode("DGE"));
        assertEquals("K", metaphone.encode("KATZ"));
        assertEquals("F", metaphone.encode("PHO"));
        assertEquals("S", metaphone.encode("SHE"));
        assertEquals("X", metaphone.encode("XIA"));
    }

    @Test
    public void testEncode_LongString() {
        assertEquals("X", metaphone.encode("CHAOS"));
        assertEquals("K", metaphone.encode("KNOCK"));
        assertEquals("M", metaphone.encode("MACK"));
        assertEquals("T", metaphone.encode("TOM"));
    }

    @Test
    public void testEncode_SpecialCases() {
        assertEquals("K", metaphone.encode("KNIGHT"));
        assertEquals("S", metaphone.encode("SCIENCE"));
        assertEquals("F", metaphone.encode("PHILIP"));
        assertEquals("S", metaphone.encode("SCHOOL"));
        assertEquals("J", metaphone.encode("GENTLE"));
    }

    @Test
    public void testEncode_SetMaxCodeLen() {
        metaphone.setMaxCodeLen(6);
        assertEquals("KNOCK", metaphone.encode("KNOCK"));
        assertEquals("SCHOOL", metaphone.encode("SCHOOL"));
    }

    @Test
    public void testEncode_SetMaxCodeLen_LessThanOutput() {
        metaphone.setMaxCodeLen(2);
        assertEquals("KN", metaphone.encode("KNOCK"));
        assertEquals("SC", metaphone.encode("SCHOOL"));
    }
}
