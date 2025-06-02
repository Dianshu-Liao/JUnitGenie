package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.filter.FilteringParserDelegate;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class filter_FilteringParserDelegate_hasToken_JsonToken_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testHasTokenReturnsFalseWhenTokensDoNotMatch() {
        // Arrange
        JsonToken tokenToTest = JsonToken.VALUE_STRING; // Example token
        JsonToken currentToken = JsonToken.VALUE_NUMBER_INT; // Different token to ensure the test case
        FilteringParserDelegate parserDelegate = new FilteringParserDelegate(null, null, false, false);
        
        // Set the protected field _currToken using reflection
        try {
            java.lang.reflect.Field field = FilteringParserDelegate.class.getDeclaredField("_currToken");
            field.setAccessible(true);
            field.set(parserDelegate, currentToken);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // Act
        boolean result = parserDelegate.hasToken(tokenToTest);

        // Assert
        assertFalse(result);
    }

}