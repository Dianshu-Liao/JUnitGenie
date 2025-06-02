package org.apache.commons.codec.language;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

public class RefinedSoundex_getMappingCode_3_0_Test {

    private final RefinedSoundex refinedSoundex = RefinedSoundex.US_ENGLISH;

    @Test
    public void testGetMappingCode_ValidLetters() {
        assertEquals('0', refinedSoundex.getMappingCode('A'));
        assertEquals('1', refinedSoundex.getMappingCode('B'));
        assertEquals('3', refinedSoundex.getMappingCode('C'));
        assertEquals('6', refinedSoundex.getMappingCode('F'));
        assertEquals('4', refinedSoundex.getMappingCode('D'));
        assertEquals('2', refinedSoundex.getMappingCode('G'));
        assertEquals('0', refinedSoundex.getMappingCode('H'));
        assertEquals('3', refinedSoundex.getMappingCode('K'));
        assertEquals('5', refinedSoundex.getMappingCode('L'));
        assertEquals('0', refinedSoundex.getMappingCode('M'));
        assertEquals('3', refinedSoundex.getMappingCode('N'));
        assertEquals('0', refinedSoundex.getMappingCode('P'));
        assertEquals('2', refinedSoundex.getMappingCode('Q'));
        assertEquals('1', refinedSoundex.getMappingCode('R'));
        assertEquals('0', refinedSoundex.getMappingCode('S'));
        assertEquals('2', refinedSoundex.getMappingCode('T'));
        assertEquals('0', refinedSoundex.getMappingCode('U'));
        assertEquals('1', refinedSoundex.getMappingCode('V'));
        assertEquals('0', refinedSoundex.getMappingCode('W'));
        assertEquals('0', refinedSoundex.getMappingCode('X'));
        assertEquals('2', refinedSoundex.getMappingCode('Y'));
        assertEquals('0', refinedSoundex.getMappingCode('Z'));
    }

    @Test
    public void testGetMappingCode_InvalidCharacters() {
        // Numeric
        assertEquals('\0', refinedSoundex.getMappingCode('1'));
        // Symbol
        assertEquals('\0', refinedSoundex.getMappingCode('@'));
        // Space
        assertEquals('\0', refinedSoundex.getMappingCode(' '));
        // Newline
        assertEquals('\0', refinedSoundex.getMappingCode('\n'));
        // Null character
        assertEquals('\0', refinedSoundex.getMappingCode('\0'));
    }

    @Test
    public void testGetMappingCode_UpperAndLowerCase() {
        assertEquals(refinedSoundex.getMappingCode('A'), refinedSoundex.getMappingCode('a'));
        assertEquals(refinedSoundex.getMappingCode('B'), refinedSoundex.getMappingCode('b'));
        assertEquals(refinedSoundex.getMappingCode('C'), refinedSoundex.getMappingCode('c'));
        assertEquals(refinedSoundex.getMappingCode('D'), refinedSoundex.getMappingCode('d'));
        assertEquals(refinedSoundex.getMappingCode('E'), refinedSoundex.getMappingCode('e'));
        assertEquals(refinedSoundex.getMappingCode('F'), refinedSoundex.getMappingCode('f'));
        assertEquals(refinedSoundex.getMappingCode('G'), refinedSoundex.getMappingCode('g'));
        assertEquals(refinedSoundex.getMappingCode('H'), refinedSoundex.getMappingCode('h'));
        assertEquals(refinedSoundex.getMappingCode('I'), refinedSoundex.getMappingCode('i'));
        assertEquals(refinedSoundex.getMappingCode('J'), refinedSoundex.getMappingCode('j'));
        assertEquals(refinedSoundex.getMappingCode('K'), refinedSoundex.getMappingCode('k'));
    }
}
