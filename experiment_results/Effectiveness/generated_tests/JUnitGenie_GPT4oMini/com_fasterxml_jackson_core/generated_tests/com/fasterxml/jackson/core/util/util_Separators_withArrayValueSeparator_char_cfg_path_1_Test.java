package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.Separators;
import com.fasterxml.jackson.core.util.Separators.Spacing;
import org.junit.Test;
import static org.junit.Assert.*;

public class util_Separators_withArrayValueSeparator_char_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testWithArrayValueSeparator() {
        // Arrange
        String rootSeparator = ",";
        char objectFieldValueSeparator = ':';
        Spacing objectFieldValueSpacing = Spacing.NONE; // Changed from DEFAULT to NONE or appropriate constant
        char objectEntrySeparator = ';';
        Spacing objectEntrySpacing = Spacing.NONE; // Changed from DEFAULT to NONE or appropriate constant
        String objectEmptySeparator = "";
        char arrayValueSeparator = '|';
        Spacing arrayValueSpacing = Spacing.NONE; // Changed from DEFAULT to NONE or appropriate constant
        String arrayEmptySeparator = "[]";

        Separators separators = new Separators(rootSeparator, objectFieldValueSeparator, objectFieldValueSpacing,
                objectEntrySeparator, objectEntrySpacing, objectEmptySeparator, arrayValueSeparator, arrayValueSpacing, arrayEmptySeparator);

        // Act
        Separators result = separators.withArrayValueSeparator(arrayValueSeparator);

        // Assert
        assertSame(separators, result); // Since the arrayValueSeparator is the same, it should return the same instance

        // Act with different separator
        char newArrayValueSeparator = '&';
        result = separators.withArrayValueSeparator(newArrayValueSeparator);

        // Assert
        assertNotSame(separators, result); // Should return a new instance
        // Use a method to get the arrayValueSeparator instead of direct access
        assertEquals(newArrayValueSeparator, result.getArrayValueSeparator()); // Check if the new separator is set correctly
    }

}