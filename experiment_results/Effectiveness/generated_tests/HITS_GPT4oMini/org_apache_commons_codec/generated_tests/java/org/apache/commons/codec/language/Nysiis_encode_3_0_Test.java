package org.apache.commons.codec.language;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.regex.Pattern;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

public class Nysiis_encode_3_0_Test {

    private final Nysiis nysiis = new Nysiis();

    @Test
    public void testEncode_NullInput() {
        assertNull(nysiis.encode(null), "Encoding null should return null");
    }

    @Test
    public void testEncode_EmptyString() {
        assertEquals("", nysiis.encode(""), "Encoding an empty string should return an empty string");
    }

    @Test
    public void testEncode_SingleCharacter() {
        assertEquals("A", nysiis.encode("A"), "Encoding 'A' should return 'A'");
        assertEquals("B", nysiis.encode("B"), "Encoding 'B' should return 'B'");
    }

    @Test
    public void testEncode_Mac() {
        assertEquals("MCC", nysiis.encode("MAC"), "Encoding 'MAC' should return 'MCC'");
    }

    @Test
    public void testEncode_Kn() {
        assertEquals("NN", nysiis.encode("KN"), "Encoding 'KN' should return 'NN'");
    }

    @Test
    public void testEncode_K() {
        assertEquals("C", nysiis.encode("K"), "Encoding 'K' should return 'C'");
    }

    @Test
    public void testEncode_Ph() {
        assertEquals("FF", nysiis.encode("PH"), "Encoding 'PH' should return 'FF'");
        assertEquals("FF", nysiis.encode("PF"), "Encoding 'PF' should return 'FF'");
    }

    @Test
    public void testEncode_Sch() {
        assertEquals("SSS", nysiis.encode("SCH"), "Encoding 'SCH' should return 'SSS'");
    }

    @Test
    public void testEncode_EE() {
        assertEquals("Y", nysiis.encode("LEE"), "Encoding 'LEE' should return 'Y'");
    }

    @Test
    public void testEncode_Ie() {
        assertEquals("Y", nysiis.encode("LIE"), "Encoding 'LIE' should return 'Y'");
    }

    @Test
    public void testEncode_Dt() {
        assertEquals("D", nysiis.encode("JORDT"), "Encoding 'JORDT' should return 'D'");
    }

    @Test
    public void testEncode_ComplexInput() {
        assertEquals("MCCN", nysiis.encode("MACN"), "Encoding 'MACN' should return 'MCCN'");
        assertEquals("NNY", nysiis.encode("KNY"), "Encoding 'KNY' should return 'NNY'");
        assertEquals("FFS", nysiis.encode("PHOS"), "Encoding 'PHOS' should return 'FFS'");
        assertEquals("SSSY", nysiis.encode("SCHNEIDER"), "Encoding 'SCHNEIDER' should return 'SSSY'");
    }

    @Test
    public void testEncode_StrictLength() {
        assertEquals("MCC", nysiis.encode("MAC"), "Encoding 'MAC' should return 'MCC' and be truncated to TRUE_LENGTH");
        assertEquals("NN", nysiis.encode("KN"), "Encoding 'KN' should return 'NN' and be truncated to TRUE_LENGTH");
    }

    @Test
    public void testEncode_EndsWithS() {
        assertEquals("MCC", nysiis.encode("MACS"), "Encoding 'MACS' should return 'MCC'");
        assertEquals("NN", nysiis.encode("KNS"), "Encoding 'KNS' should return 'NN'");
    }

    @Test
    public void testEncode_EndsWithA() {
        assertEquals("MCC", nysiis.encode("MACA"), "Encoding 'MACA' should return 'MCC'");
        assertEquals("NN", nysiis.encode("KNA"), "Encoding 'KNA' should return 'NN'");
    }
}
