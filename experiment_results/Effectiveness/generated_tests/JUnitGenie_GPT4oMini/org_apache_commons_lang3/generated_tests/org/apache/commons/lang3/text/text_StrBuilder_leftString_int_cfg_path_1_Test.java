package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class text_StrBuilder_leftString_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testLeftString() {
        // Arrange
        StrBuilder strBuilder = new StrBuilder();
        // Assuming we have properly initialized buffer and size for the test
        char[] bufferArray = {'H', 'e', 'l', 'l', 'o'};
        strBuilder.buffer = bufferArray; // Directly assigning for testing
        strBuilder.size = bufferArray.length; // Set size according to buffer length

        int lengthToTest = 3; // Valid length less than size

        // Act
        String result = strBuilder.leftString(lengthToTest);

        // Assert
        assertEquals("Hel", result);
    }

}