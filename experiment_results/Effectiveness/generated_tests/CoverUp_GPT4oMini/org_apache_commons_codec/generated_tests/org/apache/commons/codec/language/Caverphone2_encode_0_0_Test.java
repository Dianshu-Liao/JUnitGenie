package org.apache.commons.codec.language;

import org.apache.commons.codec.language.Caverphone2;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class Caverphone2_encode_0_0_Test {

    private final Caverphone2 caverphone2 = new Caverphone2();

    @Test
    public void testEncode_EmptyString() {
        String result = caverphone2.encode("");
        assertEquals("1111111111", result);
    }

    @Test
    public void testEncode_Null() {
        String result = caverphone2.encode(null);
        assertEquals("1111111111", result);
    }

    @Test
    public void testEncode_Lowercase() {
        String result = caverphone2.encode("hello");
        assertEquals("h2l3", result);
    }

    @Test
    public void testEncode_Uppercase() {
        String result = caverphone2.encode("HELLO");
        assertEquals("h2l3", result);
    }

    @Test
    public void testEncode_NonAlphabeticCharacters() {
        String result = caverphone2.encode("h3ll0!");
        assertEquals("h2l3", result);
    }

    @Test
    public void testEncode_FinalERemoval() {
        String result = caverphone2.encode("cake");
        assertEquals("k3k", result);
    }

    @Test
    public void testEncode_StartHandling() {
        String result = caverphone2.encode("cough");
        assertEquals("cou2f1111111111", result);
    }

    @Test
    public void testEncode_MultipleReplacements() {
        String result = caverphone2.encode("tough");
        assertEquals("tou2f1111111111", result);
    }

    @Test
    public void testEncode_ComplexString() {
        String result = caverphone2.encode("enough");
        assertEquals("enou2f1111111111", result);
    }

    @Test
    public void testEncode_FinalReplacements() {
        String result = caverphone2.encode("broad");
        assertEquals("pr2d1111111111", result);
    }

    @Test
    public void testEncode_ConsecutiveCharacters() {
        String result = caverphone2.encode("sssss");
        assertEquals("S1111111111", result);
    }

    @Test
    public void testEncode_OnlyVowels() {
        String result = caverphone2.encode("aeiou");
        assertEquals("A1111111111", result);
    }

    @Test
    public void testEncode_ComplexInput() {
        String result = caverphone2.encode("Coughing");
        assertEquals("cou2f3n1111111111", result);
    }
}
