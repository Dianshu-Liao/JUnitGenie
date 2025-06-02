package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import org.junit.Test;
import java.io.IOException;
import java.lang.reflect.Method;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class filter_FilteringGeneratorDelegate__checkBinaryWrite__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testCheckBinaryWrite_withINCLUDE_ALL() throws Exception {
        // Arrange
        JsonGenerator jsonGenerator = null; // Mock or create a suitable JsonGenerator as needed
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(jsonGenerator, TokenFilter.INCLUDE_ALL, false, false);
        
        // Access the protected method using reflection
        Method method = FilteringGeneratorDelegate.class.getDeclaredMethod("_checkBinaryWrite");
        method.setAccessible(true);

        // Act
        boolean result = (boolean) method.invoke(delegate);

        // Assert
        assertTrue(result); // Expected true as _itemFilter is TokenFilter.INCLUDE_ALL
    }

    @Test(timeout = 4000)
    public void testCheckBinaryWrite_withBinaryIncluded() throws Exception {
        // Arrange
        JsonGenerator jsonGenerator = null; // Mock or create a suitable JsonGenerator as needed
        TokenFilter tokenFilterMock = new TokenFilter() {
            @Override
            public boolean includeBinary() {
                return true; // Simulate includeBinary returning true
            }
        };
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(jsonGenerator, tokenFilterMock, false, false);

        // Access the protected method using reflection
        Method method = FilteringGeneratorDelegate.class.getDeclaredMethod("_checkBinaryWrite");
        method.setAccessible(true);

        // Act
        boolean result = (boolean) method.invoke(delegate);

        // Assert
        assertTrue(result); // Expected true as _itemFilter's includeBinary() returns true
    }

    @Test(timeout = 4000)
    public void testCheckBinaryWrite_withNullItemFilter() throws Exception {
        // Arrange
        JsonGenerator jsonGenerator = null; // Mock or create a suitable JsonGenerator as needed
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(jsonGenerator, null, false, false);

        // Access the protected method using reflection
        Method method = FilteringGeneratorDelegate.class.getDeclaredMethod("_checkBinaryWrite");
        method.setAccessible(true);

        // Act
        boolean result = (boolean) method.invoke(delegate);

        // Assert
        assertFalse(result); // Expected false as _itemFilter is null
    }

}