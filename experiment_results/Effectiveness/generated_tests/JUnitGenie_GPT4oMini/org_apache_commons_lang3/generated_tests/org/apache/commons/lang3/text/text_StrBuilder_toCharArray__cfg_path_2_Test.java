package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class text_StrBuilder_toCharArray__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testToCharArray_EmptySize() {
        StrBuilder strBuilder = new StrBuilder(); // Using the default constructor
        char[] expected = new char[] {}; // Expected result is an empty char array
        char[] actual = strBuilder.toCharArray();
        assertArrayEquals(expected, actual);
    }

}