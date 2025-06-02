package org.apache.commons.lang3;

import static org.apache.commons.lang3.CharSetUtils.squeeze;
import org.junit.Test;
import static org.junit.Assert.*;

public class CharSetUtilsTest {

    @Test
    public void testSqueeze_withEmptyStringAndNullSe13() {
        // Arrange
        String str = ""; // Ensures StringUtils.isEmpty(str) returns true
        Set[] set = null; // Ensures CharSetUtils.deepEmpty(set) returns true

        // Act
        String result = squeeze(str, set);

        // Assert
        assertEquals(str, result); // The method should return the input string as is
    }

    @Test
    public void testSqueeze_withEmptyStringAndNullSet() {
        // Arrange
        String str = ""; // Ensures StringUtils.isEmpty(str) returns true
        String[] set = null; // Ensures CharSetUtils.deepEmpty(set) returns true

        // Act
        String result = squeeze(str, set);

        // Assert
        assertEquals(str, result); // The method should return the input string as is
    }


    @Test
    public void testSqueeze_withEmptyStringAndNullSe1t() {
        // Arrange
        String str = ""; // Ensures StringUtils.isEmpty(str) returns true
        Set[] set = null; // Ensures CharSetUtils.deepEmpty(set) returns true

        // Act
        String result = squeeze(str, set);

        // Assert
        assertEquals(str, result); // The method should return the input string as is
    }

}