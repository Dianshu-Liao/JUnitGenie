package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class text_StrBuilder_hashCode__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testHashCode() {
        // Arrange
        StrBuilder strBuilder = new StrBuilder();
        strBuilder.append("test"); // This will set the buffer and size appropriately

        // Act
        int hashCode = strBuilder.hashCode();

        // Assert
        int expectedHashCode = 31 * 0 + 't'; // Calculate expected hash code manually
        expectedHashCode = 31 * expectedHashCode + 'e';
        expectedHashCode = 31 * expectedHashCode + 's';
        expectedHashCode = 31 * expectedHashCode + 't';
        assertEquals(expectedHashCode, hashCode);
    }

}