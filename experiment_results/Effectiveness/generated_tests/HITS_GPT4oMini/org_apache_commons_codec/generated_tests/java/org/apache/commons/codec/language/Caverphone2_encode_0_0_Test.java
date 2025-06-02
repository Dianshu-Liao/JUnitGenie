package org.apache.commons.codec.language;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

class Caverphone2_encode_0_0_Test {

    private final Caverphone2 caverphone2 = new Caverphone2();

    @Test
    void testEncode_EmptyString() {
        String result = caverphone2.encode("");
        assertEquals("1111111111", result);
    }

    @Test
    void testEncode_NullString() {
        String result = caverphone2.encode(null);
        assertEquals("1111111111", result);
    }

    @Test
    void testEncode_SingleCharacter() {
        assertEquals("1111111111", caverphone2.encode("A"));
        assertEquals("1111111111", caverphone2.encode("Z"));
    }

    @Test
    void testEncode_RemoveFinalE() {
        assertEquals("1111111111", caverphone2.encode("e"));
        assertEquals("1111111111", caverphone2.encode("Steve"));
    }

    @Test
    void testEncode_HandleStartOptions() {
        assertEquals("cou2f1111", caverphone2.encode("cough"));
        assertEquals("rou2f1111", caverphone2.encode("rough"));
        assertEquals("tou2f1111", caverphone2.encode("tough"));
        assertEquals("enou2f1111", caverphone2.encode("enough"));
        assertEquals("trou2f1111", caverphone2.encode("trough"));
        assertEquals("2n1111111111", caverphone2.encode("gn"));
    }

    @Test
    void testEncode_HandleReplacements() {
        assertEquals("2q1111111111", caverphone2.encode("cq"));
        assertEquals("si1111111111", caverphone2.encode("ci"));
        assertEquals("se1111111111", caverphone2.encode("ce"));
        assertEquals("sy1111111111", caverphone2.encode("cy"));
        assertEquals("2ch1111111111", caverphone2.encode("tch"));
        assertEquals("k1111111111", caverphone2.encode("c"));
        assertEquals("k1111111111", caverphone2.encode("q"));
        assertEquals("k1111111111", caverphone2.encode("x"));
        assertEquals("f1111111111", caverphone2.encode("v"));
        assertEquals("2g1111111111", caverphone2.encode("dg"));
        assertEquals("sio1111111111", caverphone2.encode("tio"));
        assertEquals("sia1111111111", caverphone2.encode("tia"));
        assertEquals("t1111111111", caverphone2.encode("d"));
        assertEquals("fh1111111111", caverphone2.encode("ph"));
        assertEquals("p1111111111", caverphone2.encode("b"));
        assertEquals("s21111111111", caverphone2.encode("sh"));
        assertEquals("s1111111111", caverphone2.encode("z"));
    }

    @Test
    void testEncode_HandleVowelsAndConsonants() {
        assertEquals("A3111111111", caverphone2.encode("apple"));
        assertEquals("A3111111111", caverphone2.encode("orange"));
        assertEquals("A3111111111", caverphone2.encode("banana"));
    }

    @Test
    void testEncode_ComplexCases() {
        assertEquals("k2k1111111111", caverphone2.encode("cough"));
        assertEquals("s2111111111", caverphone2.encode("sh"));
        assertEquals("f1111111111", caverphone2.encode("v"));
        assertEquals("t1111111111", caverphone2.encode("d"));
        assertEquals("k1111111111", caverphone2.encode("g"));
    }

    @Test
    void testEncode_TrailingCharacters() {
        assertEquals("1111111111", caverphone2.encode("!@#$%^&*()"));
    }
}
