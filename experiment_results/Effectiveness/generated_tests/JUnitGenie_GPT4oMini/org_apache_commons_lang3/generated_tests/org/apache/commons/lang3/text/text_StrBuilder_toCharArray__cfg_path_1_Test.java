package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class text_StrBuilder_toCharArray__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testToCharArray_NonEmptyBuffer() {
        // Arrange
        StrBuilder strBuilder = new StrBuilder();
        strBuilder.append("test");
        // The size should be 4 after appending "test"
        
        // Act
        char[] result = strBuilder.toCharArray();
        
        // Assert
        assertArrayEquals(new char[] {'t', 'e', 's', 't'}, result);
    }

    @Test(timeout = 4000)
    public void testToCharArray_EmptyBuffer() {
        // Arrange
        StrBuilder strBuilder = new StrBuilder();
        // The size is 0 by default
        
        // Act
        char[] result = strBuilder.toCharArray();
        
        // Assert
        assertArrayEquals(ArrayUtils.EMPTY_CHAR_ARRAY, result);
    }

}