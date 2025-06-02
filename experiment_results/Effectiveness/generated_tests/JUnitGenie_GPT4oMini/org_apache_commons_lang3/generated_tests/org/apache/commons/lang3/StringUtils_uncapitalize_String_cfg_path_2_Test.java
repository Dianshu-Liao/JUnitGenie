package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_uncapitalize_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testUncapitalize() {
        String input = "Hello"; // valid non-null input
        String expectedResult = "hello"; // expected result after uncapitalizing
        
        // Execute the method
        String result = StringUtils.uncapitalize(input);
        
        // Validate the result
        assertEquals(expectedResult, result);
    }
    
    @Test(timeout = 4000)
    public void testUncapitalizeAlreadyLowercase() {
        String input = "hello"; // valid non-null input
        String expectedResult = "hello"; // expected result remains unchanged
        
        // Execute the method
        String result = StringUtils.uncapitalize(input);
        
        // Validate the result
        assertEquals(expectedResult, result);
    }
    
    @Test(timeout = 4000)
    public void testUncapitalizeEmptyString() {
        String input = ""; // valid non-null input
        String expectedResult = ""; // expected result is an empty string
        
        // Execute the method
        String result = StringUtils.uncapitalize(input);
        
        // Validate the result
        assertEquals(expectedResult, result);
    }
    
    @Test(timeout = 4000)
    public void testUncapitalizeWithNullShouldReturnNull() {
        String input = null; // valid input based on constraints
        String expectedResult = null; // expected result is null
        
        // Execute the method
        String result = StringUtils.uncapitalize(input);
        
        // Validate the result
        assertEquals(expectedResult, result);
    }

    @Test(timeout = 4000)
    public void testUncapitalizeSpecialCharacters() {
        String input = "@Hello"; // valid non-null input
        String expectedResult = "@hello"; // expected result after uncapitalizing
        
        // Execute the method
        String result = StringUtils.uncapitalize(input);
        
        // Validate the result
        assertEquals(expectedResult, result);
    }

}