package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.Separators;
import org.junit.Test;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertNotSame;

public class util_Separators_withObjectEmptySeparator_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testWithObjectEmptySeparator_whenSepEqualsObjectEmptySeparator_shouldReturnThis() {
        // Arrange
        Separators separators = new Separators(); // Assuming default constructor initializes objectEmptySeparator
        String sep = separators.getObjectEmptySeparator(); // Use a getter method to access the private field

        // Act
        Separators result = separators.withObjectEmptySeparator(sep);

        // Assert
        assertSame(separators, result);
    }

    @Test(timeout = 4000)
    public void testWithObjectEmptySeparator_whenSepNotEqualsObjectEmptySeparator_shouldReturnNewSeparators() {
        // Arrange
        Separators separators = new Separators(); // Assuming default constructor initializes objectEmptySeparator
        String sep = "newSeparator"; // This should not match the private final field

        // Act
        Separators result = separators.withObjectEmptySeparator(sep);

        // Assert
        // Here we would need to check that the result is a new instance and not the same as the original
        assertNotSame(separators, result);
        // Additional assertions can be added to verify the properties of the new Separators instance
    }


}