package org.apache.commons.codec.language;
import org.apache.commons.codec.language.RefinedSoundex;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class language_RefinedSoundex_getMappingCode_char_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetMappingCode_ValidLetter() {
        RefinedSoundex refinedSoundex = new RefinedSoundex(new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'});
        char result = refinedSoundex.getMappingCode('A');
        assertEquals('A', result);
    }

    @Test(timeout = 4000)
    public void testGetMappingCode_NonLetter() {
        RefinedSoundex refinedSoundex = new RefinedSoundex(new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'});
        char result = refinedSoundex.getMappingCode('1');
        assertEquals(0, result);
    }

    @Test(timeout = 4000)
    public void testGetMappingCode_UpperCase() {
        RefinedSoundex refinedSoundex = new RefinedSoundex(new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'});
        char result = refinedSoundex.getMappingCode('Z');
        assertEquals('Z', result);
    }

    @Test(timeout = 4000)
    public void testGetMappingCode_LowerCase() {
        RefinedSoundex refinedSoundex = new RefinedSoundex(new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'});
        char result = refinedSoundex.getMappingCode('a');
        assertEquals('A', result);
    }

    @Test(timeout = 4000)
    public void testGetMappingCode_IndexOutOfBounds() {
        RefinedSoundex refinedSoundex = new RefinedSoundex(new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'});
        char result = refinedSoundex.getMappingCode('['); // '[' is not a valid letter
        assertEquals(0, result);
    }

}