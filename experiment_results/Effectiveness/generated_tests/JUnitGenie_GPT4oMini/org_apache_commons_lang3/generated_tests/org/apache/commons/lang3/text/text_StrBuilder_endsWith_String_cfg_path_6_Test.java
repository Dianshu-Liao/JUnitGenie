package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class text_StrBuilder_endsWith_String_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testEndsWithWhenStringIsEmpty() {
        // Arrange
        StrBuilder strBuilder = new StrBuilder(10);
        String str = ""; // Test Case when str is empty
        
        // Act
        boolean result;
        try {
            result = strBuilder.endsWith(str);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
            return;
        }

        // Assert
        assertTrue(result); // Should return true
    }

}