package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class text_StrBuilder_getChars_int_int_char_____int_cfg_path_1_Test {

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void testGetCharsStartIndexLessThanZero() {
        StrBuilder strBuilder = new StrBuilder("Test String");
        char[] destination = new char[10];
        
        // This should throw StringIndexOutOfBoundsException
        strBuilder.getChars(-1, 4, destination, 0);
    }
    
    @Test(expected = StringIndexOutOfBoundsException.class)
    public void testGetCharsEndIndexLessThanZero() {
        StrBuilder strBuilder = new StrBuilder("Test String");
        char[] destination = new char[10];
        
        // This should throw StringIndexOutOfBoundsException
        strBuilder.getChars(0, -1, destination, 0);
    }
    
    @Test(expected = StringIndexOutOfBoundsException.class)
    public void testGetCharsEndIndexGreaterThanLength() {
        StrBuilder strBuilder = new StrBuilder("Test String");
        char[] destination = new char[10];
        
        // This should throw StringIndexOutOfBoundsException
        strBuilder.getChars(0, 20, destination, 0);
    }
    
    @Test(expected = StringIndexOutOfBoundsException.class)
    public void testGetCharsStartIndexGreaterThanEndIndex() {
        StrBuilder strBuilder = new StrBuilder("Test String");
        char[] destination = new char[10];
        
        // This should throw StringIndexOutOfBoundsException
        strBuilder.getChars(5, 3, destination, 0);
    }

}