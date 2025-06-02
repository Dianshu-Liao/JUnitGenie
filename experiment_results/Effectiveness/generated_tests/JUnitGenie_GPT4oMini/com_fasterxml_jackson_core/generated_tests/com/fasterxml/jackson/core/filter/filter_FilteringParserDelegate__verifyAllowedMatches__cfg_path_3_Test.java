package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.filter.FilteringParserDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.IOException;
import java.lang.reflect.Method;

public class filter_FilteringParserDelegate__verifyAllowedMatches__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testVerifyAllowedMatches() {
        // Arrange
        JsonParser jsonParser = null; // Mock or initialize as necessary
        TokenFilter tokenFilter = null; // Mock or initialize as necessary
        FilteringParserDelegate delegate = new FilteringParserDelegate(jsonParser, tokenFilter, true, false);
        // Set the protected variable _matchCount to 0
        setField(delegate, "_matchCount", 0);
        // Set the protected variable _allowMultipleMatches to false
        setField(delegate, "_allowMultipleMatches", false);

        try {
            // Act
            Method method = FilteringParserDelegate.class.getDeclaredMethod("_verifyAllowedMatches");
            method.setAccessible(true);
            boolean result = (Boolean) method.invoke(delegate);

            // Assert
            assertFalse(result);
        } catch (NoSuchMethodException | IllegalAccessException | java.lang.reflect.InvocationTargetException e) {
            e.printStackTrace();
            if (e instanceof java.lang.reflect.InvocationTargetException) {
                Throwable cause = e.getCause();
                if (cause instanceof IOException) {
                    fail("IOException was thrown: " + cause.getMessage());
                } else {
                    throw new RuntimeException(cause);
                }
            }
        }
    }

    private void setField(FilteringParserDelegate delegate, String fieldName, Object value) {
        try {
            java.lang.reflect.Field field = FilteringParserDelegate.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(delegate, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}