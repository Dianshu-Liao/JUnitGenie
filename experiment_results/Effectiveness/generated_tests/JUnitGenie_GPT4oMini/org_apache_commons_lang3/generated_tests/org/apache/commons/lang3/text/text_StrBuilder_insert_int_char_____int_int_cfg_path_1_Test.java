package org.apache.commons.lang3.text;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Before;
import org.junit.Test;

public class text_StrBuilder_insert_int_char_____int_int_cfg_path_1_Test {

    private StrBuilder strBuilder;

    @Before
    public void setUp() {
        strBuilder = new StrBuilder();
        strBuilder.append("Example");
    }

    @Test(timeout = 4000)
    public void testInsertWithNullChars() {
        // Test when chars is null
        int index = 2;
        String result = strBuilder.insert(index, null, 0, 0).toString();
        
        // Validate that the string is unchanged with a null insert
        assertEquals("ExExample", result);
    }
    
    @Test(timeout = 4000)
    public void testInsertWithValidParameters() {
        // Test with valid chars
        char[] chars = new char[]{'A', 'B', 'C'};
        int index = 2;
        int offset = 0;
        int length = 3;

        StrBuilder result = strBuilder.insert(index, chars, offset, length);
        
        // Validate that the string was modified correctly
        assertNotNull(result);
        assertEquals("ExABCample", result.toString());
    }
    
    @Test(expected = StringIndexOutOfBoundsException.class)
    public void testInsertWithInvalidOffset() {
        // Test with invalid offset
        char[] chars = new char[]{'A', 'B', 'C'};
        int index = 2;
        int offset = 4; // Invalid offset
        int length = 1;

        try {
            strBuilder.insert(index, chars, offset, length);
        } catch (StringIndexOutOfBoundsException e) {
            // Catch the expected exception
            throw e; // Rethrow for the expected behavior
        }
    }
    
    @Test(expected = StringIndexOutOfBoundsException.class)
    public void testInsertWithInvalidLength() {
        // Test with invalid length
        char[] chars = new char[]{'A', 'B', 'C'};
        int index = 2;
        int offset = 0;
        int length = 5; // Invalid length

        try {
            strBuilder.insert(index, chars, offset, length);
        } catch (StringIndexOutOfBoundsException e) {
            // Catch the expected exception
            throw e; // Rethrow for the expected behavior
        }
    }

}